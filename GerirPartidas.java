import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class GerirPartidas {
    
    public static void criarPartida(Torneio torneio) {
        List<Jogador> mainBracketCopy = new ArrayList<>(torneio.getMainBracket()); // Cópia da lista mainBracket
        List<Arbitro> arbitros = torneio.getArbitros();
        int numeroPartidas = mainBracketCopy.size() / 2;
        int indiceArbitro = 0; // Índice para rastrear a posição atual na lista de árbitros
    
        // Verificar se há apenas um jogador no mainBracket
        if (mainBracketCopy.size() == 1) {
            Jogador vencedor = mainBracketCopy.get(0);
            System.out.println("\nVencedor do torneio é " + vencedor.getNome());
            torneio.removerMainBracket(vencedor);
            torneio.getArbitros().clear();
            return;
        }
    
        for (int i = 0; i < numeroPartidas; i++) {
            if (mainBracketCopy.size() < 2 || indiceArbitro >= arbitros.size()) {
                // Se não houver jogadores suficientes ou árbitros, pare de criar partidas
                break;
            }
    
            Jogador jogador1 = mainBracketCopy.remove(0);
            Jogador jogador2 = mainBracketCopy.remove(0);
            Arbitro arbitro = arbitros.get(indiceArbitro);
    
            // Incrementar o número de jogos do árbitro
            arbitro.setJogos(arbitro.getJogos() + 1);
    
            Partida partida = new Partida(torneio, jogador1, jogador2, arbitro, 0, 0);
            torneio.getPartidas().add(partida);
    
            System.out.println("Partida criada: " + jogador1.getNome() + " vs " + jogador2.getNome() + " com o árbitro " + arbitro.getNome());
    
            // Incrementar o índice do árbitro e voltar ao início da lista, se necessário
            indiceArbitro++;
            if (indiceArbitro >= arbitros.size()) {
                indiceArbitro = 0;
            }
        }
    
        System.out.println("Todas as partidas foram criadas para o torneio '" + torneio.getDesporto() + "'.");
    }
    
    
    
    
    public static void registrarPontosDaPartida(Scanner scanner) {
        // Obter lista de torneios disponíveis
        List<Torneio> torneios = GerirTorneios.getTorneios();
        List<Torneio> torneiosValidos = new ArrayList<>(); // Lista para armazenar os torneios válidos
    
        // Filtrar os torneios válidos (aqueles com mais de um participante no mainBracket)
        for (Torneio torneio : torneios) {
            if (torneio.getMainBracket().size() > 1) {
                torneiosValidos.add(torneio);
            }
        }
    
        // Verificar se há torneios válidos para escolha
        if (torneiosValidos.isEmpty()) {
            System.out.println("Não há torneios com mais de um participante para registrar pontuações.");
            return;
        }
    
        // Exibir os torneios disponíveis para registro de pontuações
        System.out.println("Escolha o torneio para o qual deseja registrar os pontos:");
        for (int i = 0; i < torneiosValidos.size(); i++) {
            System.out.println((i + 1) + ". " + torneiosValidos.get(i).getDesporto() + " - " + torneiosValidos.get(i).getData());
        }
    
        // Solicitar ao usuário que insira o número do torneio escolhido
        System.out.print("Insira o número do torneio: ");
        int numeroTorneio;
        while (true) {
            // Verificar se a entrada é um número inteiro
            if (scanner.hasNextInt()) {
                numeroTorneio = scanner.nextInt();
                break;
            } else {
                System.out.println("Entrada inválida. Insira um número inteiro.");
                scanner.next(); // Limpar o buffer do scanner
            }
        }
    
        // Verificar se o número do torneio está dentro do intervalo válido
        if (numeroTorneio < 1 || numeroTorneio > torneiosValidos.size()) {
            System.out.println("Número de torneio inválido.");
            return;
        }
    
        // Obter o torneio escolhido com base no número inserido
        Torneio torneio = torneiosValidos.get(numeroTorneio - 1);
    
        List<Partida> partidas = torneio.getPartidas();
    
        if (partidas.isEmpty()) {
            System.out.println("Não há partidas para registrar pontuações neste torneio.");
            return;
        }
    
        for (Partida partida : partidas) {
            // Verificar se as pontuações são ambas zero
            if (partida.getJogador1Pontuacao() == 0 && partida.getJogador2Pontuacao() == 0) {
                while (true) {
                    System.out.println("\nTorneio: " + torneio.getDesporto());
                    System.out.println("Partida:");
                    System.out.println(partida.getJogador1().getNome() + " vs " + partida.getJogador2().getNome());
    
                    int pontuacaoJogador1;
                    while (true) {
                        // Verificar se a entrada é um número inteiro
                        System.out.print("Pontuação de " + partida.getJogador1().getNome() + ": ");
                        if (scanner.hasNextInt()) {
                            pontuacaoJogador1 = scanner.nextInt();
                            break;
                        } else {
                            System.out.println("Entrada inválida. Insira um número inteiro.");
                            scanner.next(); // Limpar o buffer do scanner
                        }
                    }
                    partida.setJogador1Pontuacao(pontuacaoJogador1);
                    scanner.nextLine();
    
                    int pontuacaoJogador2;
                    while (true) {
                        // Verificar se a entrada é um número inteiro
                        System.out.print("Pontuação de " + partida.getJogador2().getNome() + ": ");
                        if (scanner.hasNextInt()) {
                            pontuacaoJogador2 = scanner.nextInt();
                            break;
                        } else {
                            System.out.println("Entrada inválida. Insira um número inteiro.");
                            scanner.next(); // Limpar o buffer do scanner
                        }
                    }
                    partida.setJogador2Pontuacao(pontuacaoJogador2);
                    scanner.nextLine();
    
                    // Determinar o vencedor com base na pontuação
                    Jogador vencedor = null;
                    if (pontuacaoJogador1 > pontuacaoJogador2) {
                        vencedor = partida.getJogador1();
                        // Incrementar vitórias do jogador 1 e derrotas do jogador 2
                        vencedor.setVitorias(vencedor.getVitorias() + 1);
                        partida.getJogador2().setDerrotas(partida.getJogador2().getDerrotas() + 1);
                    } else if (pontuacaoJogador2 > pontuacaoJogador1) {
                        vencedor = partida.getJogador2();
                        // Incrementar vitórias do jogador 2 e derrotas do jogador 1
                        vencedor.setVitorias(vencedor.getVitorias() + 1);
                        partida.getJogador1().setDerrotas(partida.getJogador1().getDerrotas() + 1);
                    } else {
                        System.out.println("A partida terminou em empate. Por favor, registre novamente os pontos.");
                        continue; // Voltar ao início do loop para registrar os pontos novamente
                    }
    
                    // Remover o jogador perdedor do torneio
                    if (vencedor != null) {
                        System.out.println("O jogador " + vencedor.getNome() + " venceu a partida.");
                        if (torneio.getTipo().equals("DoubleKnockout")) {
                            Jogador perdedor = (vencedor == partida.getJogador1()) ? partida.getJogador2() : partida.getJogador1();
                            torneio.removerMainBracket(perdedor);
                            torneio.adicionarLosersBracket(perdedor); // Adiciona o perdedor ao losersBracket
                        } else {
                            Jogador perdedor = (vencedor == partida.getJogador1()) ? partida.getJogador2() : partida.getJogador1();
                            torneio.removerMainBracket(perdedor);
                        }
                    } else {
                        System.out.println("A partida terminou em empate.");
                    }
    
                    break; // Sai do loop quando os pontos são registrados corretamente
                }
            }
        }
    }
}
        
