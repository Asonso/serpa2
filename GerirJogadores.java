import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerirJogadores {
    private static List<Jogador> jogadores = new ArrayList<>();


    public static void criarJogador(Scanner scanner) {
        System.out.println("Digite o ID do jogador:");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer
        System.out.println("Digite o nome do jogador:");
        String nome = scanner.nextLine();
        System.out.println("Digite o número do jogador:");
        int numero = scanner.nextInt();
        System.out.println("Digite o número de jogos do jogador:");
        int jogos = scanner.nextInt();
        System.out.println("Digite o número de vitórias do jogador:");
        int vitorias = scanner.nextInt();
        System.out.println("Digite o número de derrotas do jogador:");
        int derrotas = scanner.nextInt();

        Jogador jogador = new Jogador(id, nome, numero, jogos, vitorias, derrotas);
        jogadores.add(jogador);
    }

    public static void modificarJogador(Scanner scanner) {
        System.out.println("Digite o ID do jogador que deseja modificar:");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer
        System.out.println("Digite o novo nome do jogador:");
        String nome = scanner.nextLine();
        System.out.println("Digite o novo número do jogador:");
        int numero = scanner.nextInt();
        System.out.println("Digite o novo número de jogos do jogador:");
        int jogos = scanner.nextInt();
        System.out.println("Digite o novo número de vitórias do jogador:");
        int vitorias = scanner.nextInt();
        System.out.println("Digite o novo número de derrotas do jogador:");
        int derrotas = scanner.nextInt();

        for (Jogador jogador : jogadores) {
            if (jogador.getId() == id) {
                jogador.setNome(nome);
                jogador.setNumero(numero);
                jogador.setJogos(jogos);
                jogador.setVitorias(vitorias);
                jogador.setDerrotas(derrotas);
                return; // Sai do método após modificar o jogador
            }
        }
        // Se o jogador com o ID especificado não for encontrado
        System.out.println("Jogador não encontrado.");
    }

    public static void apagarJogador(Scanner scanner) {
        System.out.println("Digite o ID do jogador que deseja apagar:");
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
