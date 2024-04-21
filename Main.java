import java.util.Scanner;
 
public class Main {
 
    /**
     * Método principal que inicia o programa de gerenciamento de torneios.
     *
     * @param args Argumentos de linha de comando
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
   
        while (true) {
            exibirMenuPrincipal();
   
            int escolhaPrincipal = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer
   
            switch (escolhaPrincipal) {
                case 1:
                    menuGerirTorneios(scanner);
                    break;
                case 2:
                    menuGerirJogadores(scanner);
                    break;
                case 3:
                    menuGerirArbitros(scanner);
                    break;
                case 4:
                    System.out.println("Adeus! (>‿o)");
                    System.exit(0);
                case 5:
                    GerirJogadores.criarJogadoresFromFile();
                    break;
                case 6:
                    GerirArbitros.criarArbitrosFromFile();
                    break;
                case 7:
                    GerirTorneios.carregarTorneiosDeArquivo();
                    break;
                case 8:
                    GerirTorneios.registrarPartidas(scanner);
                    break;
                default:
                    System.out.println("Escolha inválida. Insira uma das opções.");
            }
        }
    }
   
    private static void exibirMenuPrincipal() {
        System.out.println("\nMenu Principal:");
        System.out.println("1. Gerir Torneios");
        System.out.println("2. Gerir Jogadores");
        System.out.println("3. Gerir Arbitros");
        System.out.println("4. Sair");
        System.out.print("Digite sua escolha: ");
    }    
   
    private static void menuGerirTorneios(Scanner scanner) {
        while (true) {
            exibirMenuGerirTorneios();
   
            int escolhaTorneios = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer
   
            switch (escolhaTorneios) {
                case 1:
                    GerirTorneios.criarTorneio(scanner);
                    break;
                case 2:
                    GerirTorneios.apagarTorneios(scanner);
                    break;
                case 3:
                    GerirTorneios.mostrarTorneios();
                    break;
                case 4:
                    return; // Voltar ao menu principal
                default:
                    System.out.println("Escolha inválida. Insira uma das opções.");
            }
        }
    }
   
    private static void exibirMenuGerirTorneios() {
        System.out.println("\nMenu Gerir Torneios:");
        System.out.println("1. Criar Torneio");
        System.out.println("2. Apagar Torneios");
        System.out.println("3. Mostrar Torneios");
        System.out.println("4. Voltar ao Menu Principal");
        System.out.print("Digite sua escolha: ");
    }
   
    private static void menuGerirJogadores(Scanner scanner) {
        while (true) {
            exibirMenuGerirJogadores();
   
            int escolhaJogadores = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer
   
            switch (escolhaJogadores) {
                case 1:
                    GerirJogadores.criarJogador();
                    break;
                case 2:
                    GerirJogadores.modificarJogador(scanner);
                    break;
                case 3:
                    GerirJogadores.apagarJogador(scanner);
                    break;
                case 4:
                    menuMostrarJogadores(scanner); // Mostrar opções de mostrar jogadores
                    break;
                case 5:
                    return; // Voltar ao menu principal
                default:
                    System.out.println("Escolha inválida. Insira uma das opções.");
            }
        }
    }
 
    private static void exibirMenuGerirJogadores() {
        System.out.println("\nMenu Gerir Jogadores:");
        System.out.println("1. Criar Jogador");
        System.out.println("2. Modificar Jogador");
        System.out.println("3. Apagar Jogador");
        System.out.println("4. Mostrar Jogadores");
        System.out.println("5. Voltar ao Menu Principal");
        System.out.print("Digite sua escolha: ");
    }
   
   
    private static void menuMostrarJogadores(Scanner scanner) {
        while (true) {
            exibirMenuMostrarJogadores();
   
            int escolhaMostrarJogadores = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer
   
            switch (escolhaMostrarJogadores) {
                case 1:
                    GerirJogadores.mostrarTodosJogadores();
                    break;
                case 2:
                    GerirJogadores.mostrarJogadoresPorDesporto(scanner);
                    break;
                case 3:
                    return; // Voltar ao menu de jogadores
                default:
                    System.out.println("Escolha inválida. Insira uma das opções.");
            }
        }
    }
   
    private static void exibirMenuMostrarJogadores() {
        System.out.println("\nMenu Mostrar Jogadores:");
        System.out.println("1. Mostrar todos os jogadores");
        System.out.println("2. Mostrar jogadores por desporto");
        System.out.println("3. Voltar ao Menu de Jogadores");
        System.out.print("Digite sua escolha: ");
    }
   
 
    private static void menuGerirArbitros(Scanner scanner) {
        while (true) {
            exibirMenuGerirArbitros();
 
            int escolhaArbitros = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer
 
            switch (escolhaArbitros) {
                case 1:
                    GerirArbitros.criarArbitro();
                    break;
                case 2:
                    GerirArbitros.modificarArbitro(scanner);
                    break;
                case 3:
                    GerirArbitros.apagarArbitro(scanner);
                    break;
                case 4:
                    menuMostrarArbitros(scanner);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Escolha inválida. Insira uma das opções.");
            }
        }
    }
 
    private static void exibirMenuGerirArbitros() {
        System.out.println("\nMenu Gerir Arbitros:");
        System.out.println("1. Criar Arbitro");
        System.out.println("2. Modificar Arbitro");
        System.out.println("3. Apagar Arbitro");
        System.out.println("4. Mostrar Arbitros");
        System.out.println("5. Voltar ao Menu Principal");
        System.out.print("Digite sua escolha: ");
    }

    private static void menuMostrarArbitros(Scanner scanner) {
        while (true) {
            exibirMenuMostrarArbitros();
   
            int escolhaMostrarArbitros = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer
   
            switch (escolhaMostrarArbitros) {
                case 1:
                    GerirArbitros.mostrarTodosArbitros();
                    break;
                case 2:
                    GerirArbitros.mostrarArbitrosPorDesporto(scanner);
                    break;
                case 3:
                    return; // Voltar ao menu de jogadores
                default:
                    System.out.println("Escolha inválida. Insira uma das opções.");
            }
        }
    }

    private static void exibirMenuMostrarArbitros() {
        System.out.println("\nMenu Mostrar arbitros:");
        System.out.println("1. Mostrar todos os arbitros");
        System.out.println("2. Mostrar arbitros por desporto");
        System.out.println("3. Voltar ao Menu de Arbitros");
        System.out.print("Digite sua escolha: ");
    }
}