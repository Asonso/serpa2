import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            exibirMenu();

            int escolha = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

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
                    Arbitro.mostrarArbitros();
                    break;
                case 9:
                    mostrarDetalhesArbitro(scanner);
                    break;
                case 10:
                    System.out.println("Adeus! (>‿o)");
                    System.exit(0);
                default:
                    System.out.println("Escolha inválida. Insira uma das opções.");
            }
        }
    }

    public static void exibirMenu() {
        System.out.println("\n=== Menu ===");
        System.out.println("1. Criar torneio");
        System.out.println("2. Apagar torneios");
        System.out.println("3. Mostrar torneios");
        System.out.println("4. Criar jogador");
        System.out.println("5. Modificar jogador");
        System.out.println("6. Apagar jogador");
        System.out.println("7. Mostrar jogadores");
        System.out.println("8. Mostrar árbitros");
        System.out.println("9. Mostrar detalhes de um árbitro");
        System.out.println("10. Sair");
        System.out.print("Escolha uma opção: ");
    }

    public static void mostrarDetalhesArbitro(Scanner scanner) {
        System.out.print("Insira o ID do árbitro: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner
    
        boolean arbitroEncontrado = false;
        for (Arbitro arbitro : Arbitro.getArbitros()) {
            if (arbitro.getId() == id) {
                System.out.println("\nDetalhes do árbitro:");
                System.out.println("- ID: " + arbitro.getId());
                System.out.println("- Nome: " + arbitro.getNome());
                System.out.println("- Número: " + arbitro.getNumero());
                System.out.println("- Desportos:");
                for (Desporto desporto : arbitro.getDesportos()) {
                    System.out.println("  - " + desporto);
                }
                arbitroEncontrado = true;
                break;
            }
        }
    
        if (!arbitroEncontrado) {
            System.out.println("Árbitro não encontrado com o ID fornecido.");
        }
    }
}
