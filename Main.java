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
            exibirMenu();

            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    GerirTorneios.criarTorneio(scanner);
                    break;
                case 2:
                    GerirTorneios.apagarTorneios();
                    break;
                case 3:
                    GerirTorneios.mostrarTorneios();
                    break;
                case 4:
                    GerirJogadores.criarJogador();
                    break;
                case 5:
                    GerirJogadores.modificarJogador(scanner);
                    break;
                case 6:
                    GerirJogadores.apagarJogador(scanner);
                    break;
                case 7:
                    GerirJogadores.mostrarJogadores();
                    break;
                case 8:
                    System.out.println("Adeus! (>‿o)");
                    System.exit(0);
                default:
                    System.out.println("Escolha inválida. Insira uma das opções.");
            }
        }
    }

    /**
     * Exibe o menu de opções disponíveis para o usuário.
     */
    private static void exibirMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Criar Torneio");
        System.out.println("2. Apagar Torneios");
        System.out.println("3. Mostrar Torneios");
        System.out.println("4. Criar Jogador");
        System.out.println("5. Modificar Jogador");
        System.out.println("6. Apagar Jogador");
        System.out.println("7. Mostrar Jogadores");
        System.out.println("8. Sair");
        System.out.print("Digite sua escolha: ");
    }
}
