import java.util.Scanner;

/**
 * @author 84152 Francisco Picoito
 * @author 55301 Diogo Marques
 * @author 79256 Afonso Santos
 */
public class Main {

    /**
     * Método principal que inicia o programa de gerenciamento de torneios.
     * Permite ao usuário selecionar várias opções, como gerenciar torneios, jogadores, árbitros ou sair do programa.
     *
     * @param args Argumentos da linha de comando (não utilizados neste programa)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
   
        while (true) {
            exibirMenuPrincipal();
   
            int escolhaPrincipal = scanner.nextInt();
            scanner.nextLine();
   
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
                default:
                    System.out.println("Escolha inválida. Insira uma das opções.");
            }
        }
    }
   
    /**
     * Exibe o menu principal do programa.
     */
    private static void exibirMenuPrincipal() {
        System.out.println("\nMenu Principal:");
        System.out.println("1. Gerir Torneios");
        System.out.println("2. Gerir Jogadores");
        System.out.println("3. Gerir Arbitros");
        System.out.println("4. Sair");
        System.out.print("Digite sua escolha: ");
    }    
   
    /**
     * Exibe o menu de gerenciamento de torneios e permite ao usuário selecionar várias opções relacionadas aos torneios.
     *
     * @param scanner O scanner utilizado para ler as entradas do usuário
     */
    private static void menuGerirTorneios(Scanner scanner) {
        while (true) {
            exibirMenuGerirTorneios();
   
            int escolhaTorneios = scanner.nextInt();
            scanner.nextLine(); 
   
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
                    GerirPartidas.registrarPontosDaPartida(scanner);
                    break;
                case 5:
                    return; 
                default:
                    System.out.println("Escolha inválida. Insira uma das opções.");
            }
        }
    }
   
    /**
     * Exibe o menu de gerenciamento de torneios.
     */
    private static void exibirMenuGerirTorneios() {
        System.out.println("\nMenu Gerir Torneios:");
        System.out.println("1. Criar Torneio");
        System.out.println("2. Apagar Torneios");
        System.out.println("3. Mostrar Torneios");
        System.out.println("4. Pontuar Partidas");
        System.out.println("5. Voltar ao Menu Principal");
        System.out.print("Digite sua escolha: ");
    }
   
    /**
     * Exibe o menu de gerenciamento de jogadores e permite ao usuário selecionar várias opções relacionadas aos jogadores.
     *
     * @param scanner O scanner utilizado para ler as entradas do usuário
     */
    private static void menuGerirJogadores(Scanner scanner) {
        while (true) {
            exibirMenuGerirJogadores();
   
            int escolhaJogadores = scanner.nextInt();
            scanner.nextLine(); 
   
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
                    menuMostrarJogadores(scanner); 
                    break;
                case 5:
                    GerirJogadores.criarJogadoresFromFile();
                    break;
                case 6:
                    return; 
                default:
                    System.out.println("Escolha inválida. Insira uma das opções.");
            }
        }
    }
 
    /**
     * Exibe o menu de gerenciamento de Jogadores.
     */
    private static void exibirMenuGerirJogadores() {
        System.out.println("\nMenu Gerir Jogadores:");
        System.out.println("1. Criar Jogador");
        System.out.println("2. Modificar Jogador");
        System.out.println("3. Apagar Jogador");
        System.out.println("4. Mostrar Jogadores");
        System.out.println("5. Criar jogadores por ficheiro");
        System.out.println("6. Voltar ao Menu Principal");
        System.out.print("Digite sua escolha: ");
    }
   
   
    /**
     * Exibe o menu que permite escolher entre dois métodos de diferentes para mostrar os jogadores
     *
     * @param scanner O scanner utilizado para ler as entradas do usuário
     */
    private static void menuMostrarJogadores(Scanner scanner) {
        while (true) {
            exibirMenuMostrarJogadores();
   
            int escolhaMostrarJogadores = scanner.nextInt();
            scanner.nextLine(); 
   
            switch (escolhaMostrarJogadores) {
                case 1:
                    GerirJogadores.mostrarTodosJogadores();
                    break;
                case 2:
                    GerirJogadores.mostrarJogadoresPorDesporto(scanner);
                    break;
                case 3:
                    return; 
                default:
                    System.out.println("Escolha inválida. Insira uma das opções.");
            }
        }
    }
   
    /**
     * Exibe o menu de gerenciamento de torneios.
     */
    private static void exibirMenuMostrarJogadores() {
        System.out.println("\nMenu Mostrar Jogadores:");
        System.out.println("1. Mostrar todos os jogadores");
        System.out.println("2. Mostrar jogadores por desporto");
        System.out.println("3. Voltar ao Menu de Jogadores");
        System.out.print("Digite sua escolha: ");
    }
   
    /**
     * Exibe o menu de gerenciamento de árbitros e permite ao usuário selecionar várias opções relacionadas aos árbitros.
     *
     * @param scanner O scanner utilizado para ler as entradas do usuário
     */
    private static void menuGerirArbitros(Scanner scanner) {
        while (true) {
            exibirMenuGerirArbitros();
 
            int escolhaArbitros = scanner.nextInt();
            scanner.nextLine(); 
 
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
                    GerirArbitros.criarArbitrosFromFile();
                    break;
                case 6:
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
        System.out.println("5. Criar arbitros por ficheiro");
        System.out.println("6. Voltar ao Menu Principal");
        System.out.print("Digite sua escolha: ");
    }

    private static void menuMostrarArbitros(Scanner scanner) {
        while (true) {
            exibirMenuMostrarArbitros();
   
            int escolhaMostrarArbitros = scanner.nextInt();
            scanner.nextLine(); 
   
            switch (escolhaMostrarArbitros) {
                case 1:
                    GerirArbitros.mostrarTodosArbitros();
                    break;
                case 2:
                    GerirArbitros.mostrarArbitrosPorDesporto(scanner);
                    break;
                case 3:
                    return; 
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