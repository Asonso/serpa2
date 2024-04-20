import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;

public class GerirJogadores {
    private static List<Jogador> jogadores = new ArrayList<>();

    public static void criarJogador() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Insira o nome do jogador: ");
        String nome = scanner.nextLine();

        int numero;

        do {
            try {
                System.out.print("Insira o número do jogador (entre 1-100): ");
                numero = scanner.nextInt();
                if (numero < 1 || numero > 100) {
                    throw new InputMismatchException();
                }
            } catch (InputMismatchException e) {
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
            String desportoInput = scanner.nextLine().toUpperCase();
            if (desportoInput.equals("FIM")) {
                continuar = false;
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
        System.out.println("Jogador nao encontrado.");
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
        System.out.println("Jogador nao encontrado.");
    }

    public static void mostrarJogadores() {
        if (jogadores.isEmpty()) {
            System.out.println("Nao existem jogadores registrados.");
        } else {
            System.out.println("Jogadores:");
            for (Jogador jogador : jogadores) {
                String desportosAsString = String.join(", ", jogador.getDesportosAsString());
                System.out.println("(" + jogador.getId() + ") - " + jogador.getNome() + ", Número: " + jogador.getNumero() + ", Pratica: " + desportosAsString);
            }
        }
    }
    
}
