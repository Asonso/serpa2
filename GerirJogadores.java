import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.InputMismatchException;

public class GerirJogadores {
    private static List<Jogador> jogadores = new ArrayList<>();
    private static Map<String, List<Jogador>> jogadoresPorDesporto = new HashMap<>(); // Mapa para armazenar os jogadores por desporto

    public static List<Jogador> getJogadores() {
        return jogadores;
    }

    public static Map<String, List<Jogador>> getJogadoresPorDesporto() {
        return jogadoresPorDesporto;
    }

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
                scanner.nextLine(); // Limpa o buffer do scanner
                numero = 0; // Define numero como 0 para forçar o loop a continuar
            }
        } while (numero <= 0);

        scanner.nextLine(); // Limpar o buffer do scanner

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
                        // Verifica se a lista para este desporto já existe no mapa, senão cria uma nova lista
                        jogadoresPorDesporto.putIfAbsent(d.name(), new ArrayList<>());
                        // Adiciona o jogador à lista correspondente ao desporto no mapa
                        jogadoresPorDesporto.get(d.name()).add(new Jogador(nome, numero, desportos, 0, 0, 0));
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
                return; // Voltar ao menu anterior
            }

            try {
                int id = Integer.parseInt(input);
                // Verificar se o jogador com o ID especificado existe
                boolean jogadorEncontrado = false;
                for (Jogador jogador : jogadores) {
                    if (jogador.getId() == id) {
                        jogadorEncontrado = true;
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
                                scanner.nextLine(); // Limpa o buffer do scanner
                                numero = 0; // Define numero como 0 para forçar o loop a continuar
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
                        return; // Sai do método após modificar o jogador
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
                return; // Voltar ao menu anterior
            }
            
            try {
                int id = Integer.parseInt(input);
                // Verificar se o jogador com o ID especificado existe
                for (int i = 0; i < jogadores.size(); i++) {
                    if (jogadores.get(i).getId() == id) {
                        System.out.println("Tem certeza que deseja apagar o jogador '" + jogadores.get(i).getNome() + "'? (s/n)");
                        String confirmacao = scanner.nextLine().toLowerCase();
                        if (confirmacao.equals("s")) {
                            jogadores.remove(i);
                            System.out.println("Jogador removido com sucesso.");
                        } else {
                            System.out.println("Operaçao cancelada. O jogador nao foi removido.");
                        }
                        return; // Sai do método após apagar ou cancelar a operaçao
                    }
                }
                // Se o jogador com o ID especificado nao for encontrado
                System.out.println("Jogador nao encontrado.");
            } catch (NumberFormatException e) {
                System.out.println("Por favor, insira um ID válido ou 'voltar'.");
            }
        }
    }
    
    

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
            }
        }
    }

    public static void mostrarJogadoresPorDesporto(Scanner scanner) {
        System.out.println();
        System.out.println("Desportos existentes:");
        for (Desporto d : Desporto.values()) {
            System.out.println("- " + d.name());
        }

        System.out.print("Insira o desporto para visualizar os jogadores: ");
        String desportoInput = scanner.nextLine().toUpperCase();
        Desporto desportoDesejado = null;

        // Verificar se o desporto inserido existe
        for (Desporto d : Desporto.values()) {
            if (desportoInput.equals(d.name())) {
                desportoDesejado = d;
                break;
            }
        }

        // Se o desporto existir, mostrar jogadores que praticam esse desporto
        if (desportoDesejado != null) {
            boolean encontrouJogadores = false;
            System.out.println();            
            System.out.println("Jogadores que praticam " + desportoDesejado.name() + ":");
            for (Jogador jogador : jogadores) {
                if (jogador.getDesportosAsString().contains(desportoDesejado.name())) {
                    encontrouJogadores = true;
                    String desportosAsString = String.join(", ", jogador.getDesportosAsString());
                    System.out.println("(" + jogador.getId() + ") - " + jogador.getNome() + ", Número: " + jogador.getNumero() + ", Pratica: " + desportosAsString);
                }
            }
            if (!encontrouJogadores) {
                System.out.println("Nenhum jogador pratica " + desportoDesejado.name() + ".");
            }
        } else {
            System.out.println("Desporto inválido.");
        }
    }

    public static void removerJogadorDesporto(Jogador jogador, DesportoEquipa desporto) {
        String nomeDesporto = desporto.name();
        List<Jogador> jogadoresDesporto = jogadoresPorDesporto.get(nomeDesporto);
        if (jogadoresDesporto != null) {
            jogadoresDesporto.remove(jogador.getNome());
        }
    }
    
    
    



    
}
