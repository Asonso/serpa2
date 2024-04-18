import java.util.Scanner;

public class Main {
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
                    GerirTorneios.registrarResultado(); // Adicionado para registrar resultado
                    break;
                case 5:
                    System.out.println("Adeus! (>‿o)");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Escolha inválida. Insira uma das opções.");
            }
        }
    }

    private static void exibirMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Criar Torneio");
        System.out.println("2. Apagar Torneios");
        System.out.println("3. Mostrar Torneios");
        System.out.println("4. Registar Resultado");
        System.out.println("5. Sair");
        System.out.print("Digite sua escolha: ");
    }
}
