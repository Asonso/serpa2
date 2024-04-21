import java.util.List;
import java.util.Scanner;

public class GerirPartidas {
    
    public static void criarPartida(Torneio torneio) {
        // Se não houver jogadores suficientes, não crie partidas
        if (torneio.getMainBracket().size() < 1) {
            System.out.println("Não há jogadores suficientes para criar partidas neste torneio.");
            return;
        }

        List<Jogador> mainBracket = torneio.getMainBracket();
        List<Arbitro> arbitros = torneio.getArbitros();

        // Enquanto houver jogadores suficientes para criar partidas
        while (mainBracket.size() >= 2) {
            Jogador jogador1 = mainBracket.remove(0);
            Jogador jogador2 = mainBracket.remove(0);
            Arbitro arbitro = arbitros.remove(0);

            Partida partida = new Partida(torneio, jogador1, jogador2, arbitro, 0, 0);
            torneio.getPartidas().add(partida);

            System.out.println("Partida criada: " + jogador1.getNome() + " vs " + jogador2.getNome() + " com o árbitro " + arbitro.getNome());
        }

        System.out.println("Todas as partidas foram criadas para o torneio '" + torneio.getDesporto() + "'.");
    }
    
    public static void registrarPontosDaPartida(Scanner scanner) {
        List<Torneio> torneios = GerirTorneios.getTorneios();
        System.out.println("Escolha o torneio para o qual deseja registrar os pontos:");
        for (int i = 0; i < torneios.size(); i++) {
            System.out.println((i + 1) + ". " + torneios.get(i).getDesporto() + " - " + torneios.get(i).getData());
        }
        
        // Solicita ao usuário que insira o número do torneio escolhido
        System.out.print("Insira o número do torneio: ");
        int numeroTorneio = scanner.nextInt();

        // Verifica se o número do torneio está dentro do intervalo válido
        if (numeroTorneio < 1 || numeroTorneio > torneios.size()) {
            System.out.println("Número de torneio inválido.");
            return;
        }

        // Obtém o torneio escolhido com base no número inserido
        Torneio torneio = torneios.get(numeroTorneio - 1);
        
        List<Partida> partidas = torneio.getPartidas();

        if (partidas.isEmpty()) {
            System.out.println("Não há partidas para registrar pontuações neste torneio.");
            return;
        }

        for (int i = 0; i < partidas.size(); i++) {
            Partida partida = partidas.get(i);

            System.out.println("\nTorneio: " + torneio.getDesporto());
            System.out.println("Partida " + (i + 1) + ":");
            System.out.println(partida.getJogador1().getNome() + " vs " + partida.getJogador2().getNome());

            System.out.print("Pontuação de " + partida.getJogador1().getNome() + ": ");
            int pontuacaoJogador1 = scanner.nextInt();
            partida.setJogador1Pontuacao(pontuacaoJogador1);

            System.out.print("Pontuação de " + partida.getJogador2().getNome() + ": ");
            int pontuacaoJogador2 = scanner.nextInt();
            partida.setJogador2Pontuacao(pontuacaoJogador2);

            Jogador perdedor = null;

            if (pontuacaoJogador1 < pontuacaoJogador2) {
                perdedor = partida.getJogador1();
            } else if (pontuacaoJogador2 < pontuacaoJogador1) {
                perdedor = partida.getJogador2();
            }

            if (perdedor != null) {
                System.out.println("O jogador " + perdedor.getNome() + " perdeu a partida.");
                torneio.removerMainBracket(perdedor);
            } else {
                System.out.println("A partida terminou em empate.");
            }
        }

        System.out.println("Pontuações registradas para todas as partidas do torneio '" + torneio.getDesporto() + "'.");
        
        // Após registrar os pontos de todas as partidas, criar novas partidas para o mesmo torneio
        criarPartida(torneio);
    }
}
