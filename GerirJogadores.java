import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * @author 84152 Francisco Picoito
 * @author 55301 Diogo Marques
 * @author 79256 Afonso Santos
 */
public class GerirJogadores {
    private static List<Jogador> jogadores = new ArrayList<>();

    /**
     * Obtém a lista de jogadores registrados no sistema.
     *
     * @return A lista de jogadores registrados
     */
    public static List<Jogador> getJogadores() {
        return jogadores;
    }

    /**
     * Verifica se um jogador está associado a algum torneio.
     *
     * @param jogador O jogador a ser verificado
     * @return true se o jogador estiver associado a um torneio, caso contrário false
     */
    public static boolean jogadorEstaEmTorneio(Jogador jogador) {
        for (Torneio torneio : GerirTorneios.getTorneios()) {
            if (torneio.getMainBracket().contains(jogador) || torneio.getLosersBracket().contains(jogador)) {
                return true;
            }
        }
        return false;
    }
    
    
    /**
     * Cria um novo jogador com base nas informações fornecidas pelo utilizador.
     */
    public static void criarJogador() {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.print("Insira o nome do jogador: ");
        String nome = scanner.nextLine();

        int numero;

        do {
            try {
                System.out.println();
                System.out.print("Insira o número do jogador (entre 1-100): ");
                numero = scanner.nextInt();
                if (numero < 1 || numero > 100) {
                    throw new InputMismatchException();
                }
            } catch (InputMismatchException e) {
                System.out.println();
                System.out.println("Por favor, insira um número inteiro entre 1-100.");
                scanner.nextLine(); 
                numero = 0; 
            }
        } while (numero <= 0);

        scanner.nextLine();

        List<Desporto> desportos = new ArrayList<>();
        boolean continuar = true;
        while (continuar) {
            System.out.println("Desportos disponíveis:");
            for (Desporto d : Desporto.values()) {
                System.out.println("- " + d.name());
            }
            System.out.print("Insira um desporto que o jogador pratica (ou digite 'fim' para terminar): ");            
            System.out.println();
            String desportoInput = scanner.nextLine().toUpperCase();
            if (desportoInput.equals("FIM")) {
                if (desportos.isEmpty()) {
                    System.out.println();
                    System.out.println("É necessário inserir pelo menos um desporto.");
                } else {
                    continuar = false;
                }
            } else {
                boolean encontrado = false;
                for (Desporto d : Desporto.values()) {
                    if (desportoInput.equals(d.name())) {
                        desportos.add(d);
                        encontrado = true;
                        break;
                    }
                }
                if (!encontrado) {
                    System.out.println("Desporto inválido. Por favor, insira um desporto válido.");
                }
            }
        }

        Jogador jogador = new Jogador(nome, numero, desportos, 0, 0, 0);
        jogadores.add(jogador);
    }

    /**
     * Modifica um jogador existente no sistema.
     *
     * @param scanner O scanner utilizado para ler as entradas do utilizador
     */
    public static void modificarJogador(Scanner scanner) {
        if (jogadores.isEmpty()) {
            System.out.println();
            System.out.println("Nao existem jogadores registrados.");
            return;
        }

        
        System.out.println();
        System.out.println("Lista de Jogadores:");
        for (Jogador jogador : jogadores) {
            System.out.println("(" + jogador.getId() + ") - " + jogador.getNome() + ", Número:" + jogador.getNumero());
        }

        while (true) {
            System.out.println();
            System.out.println("Insira o ID do jogador que deseja modificar (ou digite 'voltar' para retornar):");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("voltar")) {
                System.out.println("Operaçao cancelada.");
                return; 
            }

            try {
                int id = Integer.parseInt(input);
                boolean jogadorEncontrado = false;
                for (Jogador jogador : jogadores) {
                    if (jogador.getId() == id) {
                        jogadorEncontrado = true;

                        if (jogadorEstaEmTorneio(jogador)) {
                            System.out.println("Este jogador está associado a um torneio e não pode ser modificado.");
                            return; 
                        }

                        System.out.println();
                        System.out.println("Insira o novo nome do jogador:");
                        String nome = scanner.nextLine();
                        
                        int numero ;
                        do {
                            try {
                                System.out.println();
                                System.out.print("Insira o número do jogador (entre 1-100): ");
                                numero = scanner.nextInt();
                                if (numero < 1 || numero > 100) {
                                    throw new InputMismatchException();
                                }
                            } catch (InputMismatchException e) {
                                System.out.println();
                                System.out.println("Por favor, insira um número inteiro entre 1-100.");
                                scanner.nextLine();
                                numero = 0; 
                            }
                        } while (numero <= 0);
                
                        scanner.nextLine();
                                                                            
                        List<Desporto> desportos = jogador.getDesportos();
                        desportos.clear();
                        boolean continuar = true;
                        while (continuar) {
                            System.out.println("Desportos disponíveis:");
                            for (Desporto d : Desporto.values()) {
                                System.out.println("- " + d.name());
                            }
                            System.out.print("Insira um desporto que o jogador pratica (ou digite 'fim' para terminar): ");            
                            System.out.println();
                            String desportoInput = scanner.nextLine().toUpperCase();
                            if (desportoInput.equals("FIM")) {
                                if (desportos.isEmpty()) {
                                    System.out.println();
                                    System.out.println("É necessário inserir pelo menos um desporto.");
                                } else {
                                    continuar = false;
                                }
                            } else {
                                boolean encontrado = false;
                                for (Desporto d : Desporto.values()) {
                                    if (desportoInput.equals(d.name())) {
                                        desportos.add(d);
                                        encontrado = true;
                                        break;
                                    }
                                }
                                if (!encontrado) {
                                    System.out.println("Desporto inválido. Por favor, insira um desporto válido.");
                                }
                            }
                        }

                        jogador.setNome(nome);
                        jogador.setNumero(numero);
                        System.out.println("Jogador modificado com sucesso.");
                        return; 
                    }
                }

                if (!jogadorEncontrado) {
                    System.out.println("Jogador nao encontrado.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, insira um ID válido ou 'voltar'.");
            }
        }
    }

    /**
     * Apaga um jogador existente no sistema.
     *
     * @param scanner O scanner utilizado para ler as entradas do utilizador
     */
    public static void apagarJogador(Scanner scanner) {

        if (jogadores.isEmpty()) {
            System.out.println();
            System.out.println("Nao existem jogadores para apagar.");
            return;
        }

        System.out.println();
        System.out.println("Lista de Jogadores:");
        for (Jogador jogador : jogadores) {
            System.out.println("(" + jogador.getId() + ") - " + jogador.getNome() + ", Número:" + jogador.getNumero());
        }
        
        while (true) {
            System.out.println();
            System.out.println("Insira o ID do jogador que deseja apagar (ou digite 'voltar' para retornar):");
            String input = scanner.nextLine();
            
            if (input.equalsIgnoreCase("voltar")) {
                System.out.println("Operaçao cancelada.");
                return; 
            }
            
            try {
                int id = Integer.parseInt(input);
                for (int i = 0; i < jogadores.size(); i++) {
                    if (jogadores.get(i).getId() == id) {

                        if (jogadorEstaEmTorneio(jogadores.get(i))) {
                            System.out.println("Este jogador está associado a um torneio e não pode ser apagado.");
                            return;
                        }

                        System.out.println("Tem certeza que deseja apagar o jogador '" + jogadores.get(i).getNome() + "'? (s/n)");
                        String confirmacao = scanner.nextLine().toLowerCase();
                        if (confirmacao.equals("s")) {
                            jogadores.remove(i);
                            System.out.println("Jogador removido com sucesso.");
                        } else {
                            System.out.println("Operaçao cancelada. O jogador nao foi removido.");
                        }
                        return; 
                    }
                }
                System.out.println("Jogador nao encontrado.");
            } catch (NumberFormatException e) {
                System.out.println("Por favor, insira um ID válido ou 'voltar'.");
            }
        }
    }
    
    
    /**
     * Mostra todos os jogadores registrados no sistema.
     */
    public static void mostrarTodosJogadores() {
        if (jogadores.isEmpty()) {
            System.out.println();
            System.out.println("Nao existem jogadores registrados.");
        } else {
            System.out.println();
            System.out.println("Jogadores:");
            for (Jogador jogador : jogadores) {
                String desportosAsString = String.join(", ", jogador.getDesportosAsString());
                System.out.println("(" + jogador.getId() + ") - " + jogador.getNome() + ", Número: " + jogador.getNumero() + ", Pratica: " + desportosAsString);
                System.out.println("Tem: " + jogador.getVitorias() + " vitorias e " + jogador.getDerrotas() + " derrotas\n");
            }
        }
    }

    /**
     * Mostra os jogadores que praticam um desporto específico.
     *
     * @param scanner O scanner utilizado para ler as entradas do utilizador
     */
    public static void mostrarJogadoresPorDesporto(Scanner scanner) {
        System.out.println();
        System.out.println("Desportos existentes:");
        for (Desporto d : Desporto.values()) {
            System.out.println("- " + d.name());
        }

        System.out.print("Insira o desporto para visualizar os jogadores: ");
        String desportoInput = scanner.nextLine().toUpperCase();
        Desporto desportoDesejado = null;

        for (Desporto d : Desporto.values()) {
            if (desportoInput.equals(d.name())) {
                desportoDesejado = d;
                break;
            }
        }

        if (desportoDesejado != null) {
            boolean encontrouJogadores = false;
            System.out.println();            
            System.out.println("Jogadores que praticam " + desportoDesejado.name() + ":");
            for (Jogador jogador : jogadores) {
                if (jogador.getDesportosAsString().contains(desportoDesejado.name())) {
                    encontrouJogadores = true;
                    String desportosAsString = String.join(", ", jogador.getDesportosAsString());
                    System.out.println("(" + jogador.getId() + ") - " + jogador.getNome() + ", Número: " + jogador.getNumero() + ", Pratica: " + desportosAsString);
                    System.out.println("Tem: " + jogador.getVitorias() + " vitorias e " + jogador.getDerrotas() + " derrotas\n");
                }
            }
            if (!encontrouJogadores) {
                System.out.println("Nenhum jogador pratica " + desportoDesejado.name() + ".");
            }
        } else {
            System.out.println("Desporto inválido.");
        }
    }

    /**
     * Cria jogadores a partir de um arquivo.
     */
    public static void criarJogadoresFromFile() {
        String fileName = "jogadores.txt"; 
    
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
    
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] tokens = line.split(" ");

                String nome = tokens[0];

                int numero = Integer.parseInt(tokens[1]);

                List<Desporto> desportos = new ArrayList<>();
                for (int i = 2; i < tokens.length; i++) {
                    Desporto desporto = Desporto.valueOf(tokens[i].toUpperCase());
                    desportos.add(desporto);
                }

                Jogador jogador = new Jogador(nome, numero, desportos, 0, 0, 0);
                jogadores.add(jogador);
            }

            System.out.println("Jogadores criados a partir do arquivo com sucesso.");
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: " + fileName);
        } catch (NumberFormatException e) {
            System.out.println("Erro ao ler o número do jogador.");
        } catch (IllegalArgumentException e) {
            System.out.println("Desporto inválido encontrado no arquivo.");
        }
    }    
    



    
}
