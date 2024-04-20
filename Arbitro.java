import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Arbitro {
    private static List<Arbitro> arbitros = new ArrayList<>();
    private static int contadorArbitros = 0;

    private int id;
    private String nome;
    private int numero;
    private List<Desporto> desportos;

    public Arbitro(String nome, int numero) {
        this.id = ++contadorArbitros;
        this.nome = nome;
        this.numero = numero;
        this.desportos = new ArrayList<>();
        arbitros.add(this);
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getNumero() {
        return numero;
    }

    public List<Desporto> getDesportos() {
        return desportos;
    }

    public void adicionarDesporto(Desporto desporto) {
        desportos.add(desporto);
    }

    public void removerDesporto(Desporto desporto) {
        desportos.remove(desporto);
    }

    public static Arbitro criarArbitro(Scanner scanner) {
        System.out.print("Insira o nome do árbitro: ");
        String nome = scanner.nextLine();

        System.out.print("Insira o número do árbitro: ");
        int numero = scanner.nextInt();

        scanner.nextLine(); // Limpar o buffer do scanner

        return new Arbitro(nome, numero);
    }

    public static List<Arbitro> getArbitros() {
        return arbitros;
    }

    public static void mostrarArbitros() {
        if (arbitros.isEmpty()) {
            System.out.println("Não existem árbitros registados.");
        } else {
            System.out.println("Árbitros:");
            for (Arbitro arbitro : arbitros) {
                System.out.println("- ID: " + arbitro.getId() + ", Nome: " + arbitro.getNome() + ", Número: " + arbitro.getNumero());
            }
        }
    }
}
