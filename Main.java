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
                    System.out.println("Adeus! (>‿o)");
                    System.exit(0);
                default:
                    System.out.println("Escolha inválida. Insira uma das opções.");
            }
        }
    }
    
    private static void exibirMenuPrincipal() {
        System.out.println("\nMenu Principal:");
        System.out.println("1. Gerir Torneios");
        System.out.println("2. Gerir Jogadores");
        System.out.println("3. Sair");
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
    
}