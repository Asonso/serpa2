import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerirJogadores {
    private static List<Jogador> jogadores = new ArrayList<>();

    public static void criarJogador() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insira o nome do jogador:");
        String nome = scanner.nextLine();
        System.out.println("Insira o número do jogador:");
        int numero = scanner.nextInt();

        Jogador jogador = new Jogador(nome, numero, 0, 0, 0);
        jogadores.add(jogador);
    }

    public static void modificarJogador(Scanner scanner) {
        System.out.println("Insira o ID do jogador que deseja modificar:");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer
        System.out.println("Insira o novo nome do jogador:");
        String nome = scanner.nextLine();
        System.out.println("Insira o novo número do jogador:");
        int numero = scanner.nextInt();

        for (Jogador jogador : jogadores) {
            if (jogador.getId() == id) {
                jogador.setNome(nome);
                jogador.setNumero(numero);
                return; // Sai do método após modificar o jogador
            }
        }
        // Se o jogador com o ID especificado não for encontrado
        System.out.println("Jogador não encontrado.");
    }

    public static void apagarJogador(Scanner scanner) {
        System.out.println("Insira o ID do jogador que deseja apagar:");
        int id = scanner.nextInt();
        for (int i = 0; i < jogadores.size(); i++) {
            if (jogadores.get(i).getId() == id) {
                jogadores.remove(i);
                return; // Sai do método após apagar o jogador
            }
        }
        // Se o jogador com o ID especificado não for encontrado
        System.out.println("Jogador não encontrado.");
    }
}
