import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Map;

public class GerirEquipas {

    public static Equipa criarEquipa() {
        Scanner scanner = new Scanner(System.in);
    
        if (GerirJogadores.getJogadores().size() <= 1) {
            System.out.println("Nao existem jogadores suficientes para uma equipa.");
            return null;
        }
    
        System.out.println();
        System.out.println("Nome da Equipa:");
        String nomeEquipa = scanner.nextLine();
    
        DesportoEquipa desporto = null;
        while (desporto == null) {
            System.out.println();
            System.out.println("Desporto praticado:");
            for (DesportoEquipa d : DesportoEquipa.values()) {
                System.out.println("- " + d.name());
            }
            System.out.println();
            String desportoString = scanner.nextLine().toUpperCase();
            try {
                desporto = DesportoEquipa.valueOf(desportoString);
            } catch (IllegalArgumentException e) {
                System.out.println("Desporto inválido. Tente novamente.");
            }
        }
    
        System.out.println();
        System.out.println("Jogadores disponíveis para a equipe que praticam " + desporto.name() + ":");
        List<Jogador> jogadoresDisponiveis = new ArrayList<>();
        Map<String, List<Jogador>> jogadoresPorDesporto = GerirJogadores.getJogadoresPorDesporto();
        List<Jogador> jogadoresDesporto = jogadoresPorDesporto.getOrDefault(desporto.name(), new ArrayList<>());
        for (Jogador jogador : GerirJogadores.getJogadores()) {
            for (Jogador jogadorDesporto : jogadoresDesporto) {
                if (jogador.getId() == jogadorDesporto.getId()) {
                    String desportosAsString = String.join(", ", jogador.getDesportosAsString());
                    System.out.println("(" + jogador.getId() + ") - " + jogador.getNome() + ", Número: " + jogador.getNumero() + ", Pratica: " + desportosAsString);
                    jogadoresDisponiveis.add(jogador);
                    break; // Sair do loop interno quando o jogador é encontrado na lista de desportos
                }
            }
        }
        
    
        if (jogadoresDisponiveis.isEmpty()) {
            System.out.println("Nao existem jogadores disponíveis para este desporto.");
            return null;
        }
    
        List<Jogador> jogadoresEquipa = new ArrayList<>();
        System.out.println();
        System.out.println("Selecione jogadores para a equipe:");
        for (int i = 0; i < 4; i++) {
            boolean jogadorEncontrado = false;
            while (!jogadorEncontrado) {
                System.out.println("ID do Jogador " + (i + 1) + ": ");
                int idJogador = scanner.nextInt();
                for (Jogador jogador : jogadoresDisponiveis) {
                    if (jogador.getId() == idJogador) {
                        jogadoresEquipa.add(jogador);
                        jogadorEncontrado = true;
                        GerirJogadores.removerJogadorDesporto(jogador, desporto);
                        break;
                    }
                }
                if (!jogadorEncontrado) {
                    System.out.println("ID inválido. Por favor, selecione um jogador disponível.");
                }
            }
        }
    
        return new Equipa(0, nomeEquipa, desporto, jogadoresEquipa);
    }
}
