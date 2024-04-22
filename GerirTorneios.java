/**
 * @author 84152 Francisco Picoito
 * @author 55301 Diogo Marques
 * @author 79256 Afonso Santos
 * 
 */

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.io.File;
import java.io.FileNotFoundException; 
import java.util.Collections;

/**
 * @author 84152 Francisco Picoito
 * @author 55301 Diogo Marques
 * @author 79256 Afonso Santos
 */ 
 public class GerirTorneios {
     private static List<Torneio> torneios = new ArrayList<>();
     private static int contadorTorneios = 0;
    
    /**
     *  Obtém lista de torneios existentes
     * 
     * @return lista de torneios existentes
     */
    public static List<Torneio> getTorneios() {
        return torneios;
    }

    /**
     * Apaga torneios do sistema.
     *
     * @param scanner O scanner é utilizado para ler as entradas do utilizador
     */
    public static void apagarTorneios(Scanner scanner) {

        if (torneios.isEmpty()) {
            System.out.println("\nNao existem torneios para apagar.");
            return;
        }

        while (true) {
            System.out.println("\nInsira o ID do torneio que deseja apagar (ou digite 'voltar' para retornar):");

            for (int i = 0; i < torneios.size(); i++) {
                System.out.println((i + 1) + ". " + torneios.get(i).getDesporto() + " - " + torneios.get(i).getData());
            }

            String input = scanner.nextLine();
            
            if (input.equalsIgnoreCase("voltar")) {
                System.out.println("Operaçao cancelada.");
                return; 
            }
        
            try {
                int id = Integer.parseInt(input);
                for (int i = 0; i < torneios.size(); i++) {
                    if (torneios.get(i).getId() == id) {
                        System.out.println("Tem certeza que deseja apagar o torneio '" + torneios.get(i).getDesporto() + ", " + torneios.get(i).getData() + "'? (s/n)");
                        String confirmacao = scanner.nextLine().toLowerCase();
                        if (confirmacao.equals("s")) {
                            torneios.remove(i);
                            System.out.println("Torneio removido com sucesso.");
                        } else {
                            System.out.println("Operaçao cancelada. O torneio nao foi removido.");
                        }
                        return; 
                    }
                }
                System.out.println("Torneio nao encontrado.");
            } catch (NumberFormatException e) {
                System.out.println("Por favor, insira um ID válido ou 'voltar'.");
            }
        }
    }
 
    /**
    * Cria um novo torneio com base nas informaçoes dadas pelo utilizador.
    *
    * @param scanner O scanner é utilizado para ler as entradas do utilizador
    */
    public static void criarTorneio(Scanner scanner) {
        System.out.println("\nEscolha o tipo de torneio:");
        System.out.println("1. Knockout");
        System.out.println("2. Double Knockout");
        System.out.print("Insira a tua escolha: ");

        int tipoTorneio = 0;

        do {
            try {
                tipoTorneio = scanner.nextInt();
                if (tipoTorneio != 1 && tipoTorneio != 2) {
                    System.out.println("Insira '1' ou '2'.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Insira '1' ou '2'.");
                scanner.nextLine();
            }
        } while (tipoTorneio != 1 && tipoTorneio != 2);

        int numeroParticipantes;

        do {
            try {
                System.out.print("\nInsira o número de participantes (4, 8, 16 ou 32): ");
                numeroParticipantes = scanner.nextInt();

                if (numeroParticipantes != 4 && numeroParticipantes != 8 && numeroParticipantes != 16 && numeroParticipantes != 32) {
                    System.out.println("Insira um número válido de participantes (4, 8, 16 ou 32).");
                    numeroParticipantes = -1;
                }
            } catch (InputMismatchException e) {
                System.out.println("Insira um número válido de participantes (4, 8, 16 ou 32).");
                scanner.nextLine();
                numeroParticipantes = -1;
            }
        } while (numeroParticipantes != 4 && numeroParticipantes != 8 && numeroParticipantes != 16 && numeroParticipantes != 32);

        
        String data;
        do {
            System.out.print("\nInsira a data (formato dd-MM-aaaa): ");
            data = scanner.next();
        } while (!Validacoes.dataValida(data));

        Desporto desporto = Validacoes.validarDesporto(scanner);

        int jogadoresDisponiveis = 0;
        for (Jogador jogador : GerirJogadores.getJogadores()) {
            if (jogador.getDesportos().contains(desporto)) {
                jogadoresDisponiveis++;
            }
        }

        
        if (jogadoresDisponiveis < numeroParticipantes) {
            System.out.println("Nao há jogadores suficientes com o desporto selecionado para o número de participantes especificado. A operaçao foi cancelada.");
            return;
        }

        int arbitrosDisponiveis = 0;
        for (Arbitro arbitro : GerirArbitros.getArbitros()) {
            if (arbitro.getDesportos().contains(desporto)) {
                arbitrosDisponiveis++;
            }
        }

        if (arbitrosDisponiveis < 2) {
            System.out.println("Não há árbitros suficientes com o desporto selecionado para o torneio. A operação foi cancelada.");
            return;
        }
        
        System.out.print("\nInsira o local: ");
        String local = scanner.next();
        
        List<Jogador> losersBracket = new ArrayList<>();
        List<Jogador> mainBracket = new ArrayList<>();
        scanner.nextLine(); 

        if (!GerirJogadores.getJogadores().isEmpty()) {
            System.out.println("\nLista de jogadores disponíveis para o desporto " + desporto + ":");
            for (Jogador jogador : GerirJogadores.getJogadores()) {
                if (jogador.getDesportos().contains(desporto)) {
                    System.out.println("(" + jogador.getId() + "). " + jogador.getNome() + " - Número: " + jogador.getNumero());
                }
            }
        
            for (int i = 0; i < numeroParticipantes; i++) {
                int id = 0;
                boolean idValido = false;
        
                while (!idValido) {
                    try {
                        System.out.print("\nInsira o ID do jogador " + (i + 1) + ": ");
                        id = scanner.nextInt();
        
                        final int finalId = id; 
        
                        boolean idRepetido = mainBracket.stream().anyMatch(jogador -> jogador.getId() == finalId);
                        if (idRepetido) {
                            System.out.println("Este jogador já foi selecionado para uma posiçao anterior. Por favor, insira um ID válido.");
                            continue; 
                        }
        
                        idValido = GerirJogadores.getJogadores().stream().anyMatch(jogador -> jogador.getId() == finalId && jogador.getDesportos().contains(desporto));
        
                        if (!idValido) {
                            System.out.println("ID inválido ou jogador nao corresponde ao desporto do torneio. Por favor, insira um ID válido.");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Entrada inválida. Por favor, insira um número.");
                        scanner.nextLine(); 
                    }
                }
        
                for (Jogador jogador : GerirJogadores.getJogadores()) {
                    if (jogador.getId() == id) {
                        mainBracket.add(jogador);
                        break;
                    }
                }
            }
        

        } else {
            System.out.println("Nao existem jogadores registrados. O torneio será criado sem jogadores.");
        }

        
        List<Arbitro> arbitros = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            int id = 0;
            boolean idValido = false;

            System.out.println("\nLista de arbitros disponíveis para o desporto " + desporto + ":");
            for (Arbitro arbitro : GerirArbitros.getArbitros()) {
                if (arbitro.getDesportos().contains(desporto)) {
                    System.out.println("(" + arbitro.getId() + "). " + arbitro.getNome());
                }
            }

            while (!idValido) {
                try {
                    System.out.print("\nInsira o ID do árbitro " + (i + 1) + ": ");
                    id = scanner.nextInt();

                    final int finalId = id; 

                    boolean idRepetido = arbitros.stream().anyMatch(arbitro -> arbitro.getId() == finalId);
                    if (idRepetido) {
                        System.out.println("Este árbitro já foi selecionado para uma posição anterior. Por favor, insira um ID válido.");
                        continue; 
                    }

                    idValido = GerirArbitros.getArbitros().stream().anyMatch(arbitro -> arbitro.getId() == finalId && arbitro.getDesportos().contains(desporto));

                    if (!idValido) {
                        System.out.println("ID inválido ou árbitro não corresponde ao desporto do torneio. Por favor, insira um ID válido.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida. Por favor, insira um número.");
                    scanner.nextLine(); 
                }
            }

            for (Arbitro arbitro : GerirArbitros.getArbitros()) {
                if (arbitro.getId() == id) {
                    arbitros.add(arbitro);
                    break;
                }
            }
        }

        
        List<Partida> partidas = new ArrayList<>();

        Torneio novoTorneio = null;

        Collections.shuffle(mainBracket);
        if (tipoTorneio == 1) {
            novoTorneio = new Torneio(desporto.toString(), data, local, numeroParticipantes, "Knockout", mainBracket, losersBracket, arbitros, partidas, null);
            torneios.add(novoTorneio);
        } else if (tipoTorneio == 2) {
            novoTorneio = new Torneio(desporto.toString(), data, local, numeroParticipantes, "DoubleKnockout", mainBracket, losersBracket, arbitros, partidas, null);
            torneios.add(novoTorneio);
        }

        GerirPartidas.criarPartida(novoTorneio, scanner);
    }
     /**
      * Mostra os detalhes dos torneios armazenados no sistema, permitindo ao utilizador escolher se deseja mostrar todos os torneios ou apenas um específico.
      * 
      */
     
      public static void mostrarTorneios() {
        Scanner scanner = new Scanner(System.in);
    
        if (torneios.isEmpty()) {
            System.out.println("\nNao existem torneios para mostrar.");
            return;
        }
    
        System.out.println("\nPrefere mostrar todos os torneios ou apenas um específico?");
        System.out.println("1. Todos os torneios");
        System.out.println("2. Mostrar torneio específico");
        System.out.print("Insira sua escolha: ");
    
        int escolha = scanner.nextInt();
    
        if (escolha == 1) {
            for (int i = 0; i < torneios.size(); i++) {
                dadosTorneio(i);
            }
        } else if (escolha == 2) {
            System.out.println("\nInsira o ID do torneio que deseja mostrar: ");
            for (int i = 0; i < torneios.size(); i++) {
                System.out.println((i + 1) + ". " + torneios.get(i).getDesporto() + " - " + torneios.get(i).getData());
            }
            int numeroTorneio;
    
            do {
                try {
                    numeroTorneio = scanner.nextInt();
                    if (numeroTorneio < 1 || numeroTorneio > torneios.size()) {
                        System.out.println("Insira um ID válido de torneio.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Insira um ID válido de torneio.");
                    scanner.nextLine();
                    numeroTorneio = -1;
                }
            } while (numeroTorneio < 1 || numeroTorneio > torneios.size());
    
            dadosTorneio(numeroTorneio - 1);
        } else {
            System.out.println("Opçao inválida.");
        }
    }
     
     /**
      * Mostra os detalhes de um torneio específico com base no índice fornecido.
      * 
      * @param indice O índice do torneio a ser mostrado
      */
      private static void dadosTorneio(int indice) {
        Torneio torneio = torneios.get(indice);
    
        System.out.println("\nTorneio " + (indice + 1) + ":");
        System.out.println("Desporto: " + torneio.getDesporto());
        System.out.println("Data: " + torneio.getData());
        System.out.println("Local: " + torneio.getLocal());
    
        if (torneio.getTipo().equals("Knockout")) {
            System.out.println("Tipo: Knockout");
        } else if (torneio.getTipo().equals("DoubleKnockout")) {
            System.out.println("Tipo: Double Knockout");
        }
    
        System.out.println("Número de Participantes: " + torneio.getNumeroParticipantes());
    
        System.out.println("\nMain Bracket:");
        for (int i = 0; i < torneio.getMainBracket().size(); i++) {
            Jogador jogador = torneio.getMainBracket().get(i);
            System.out.println((i + 1) + ". " + jogador.getNome() + " - Número: " + jogador.getNumero());
        }

    
        if (torneio.getTipo().equals("DoubleKnockout")) {
            System.out.println("\nLosers Bracket:");
            for (int i = 0; i < torneio.getLosersBracket().size(); i++) {
                Jogador jogador = torneio.getLosersBracket().get(i);
                System.out.println((i + 1) + ". " + jogador.getNome() + " - Número: " + jogador.getNumero());
            }
        }

        System.out.println("\nMain Bracket:");
        for (int i = 0; i < torneio.getMainBracket().size(); i++) {
            Jogador jogador = torneio.getMainBracket().get(i);
            System.out.println((i + 1) + ". " + jogador.getNome() + " - Número: " + jogador.getNumero());
        }

        System.out.println("\nLosers Bracket:");
        for (int i = 0; i < torneio.getLosersBracket().size(); i++) {
            Jogador jogador = torneio.getLosersBracket().get(i);
            System.out.println((i + 1) + ". " + jogador.getNome() + " - Número: " + jogador.getNumero());
        }
    
        System.out.println("\nPartidas:");
        List<Partida> partidas = torneio.getPartidas();
        for (int i = 0; i < partidas.size(); i++) {
            Partida partida = partidas.get(i);
            System.out.println("Partida " + (i + 1) + ":");
            System.out.println("Jogador 1: " + partida.getJogador1().getNome() + " - Pontuação: " + partida.getJogador1Pontuacao());
            System.out.println("Jogador 2: " + partida.getJogador2().getNome() + " - Pontuação: " + partida.getJogador2Pontuacao());
            System.out.println("Árbitro: " + partida.getArbitro().getNome() + "\n");
        }
        

        if (torneio.getVencedor() != null) {
            System.out.println("Vencedor: " + torneio.getVencedor().getNome());
        } else {
            System.out.println("Vencedor ainda não determinado.");
        }


        
    }
    





}
