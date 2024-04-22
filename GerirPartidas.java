import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * @author 84152 Francisco Picoito
 * @author 55301 Diogo Marques
 * @author 79256 Afonso Santos
 */
public class GerirPartidas {
    
    /**
     * Cria uma nova partida para um torneio especificado.
     *
     * @param torneio O torneio para o qual a partida será criada
     * @param scanner O scanner utilizado para ler as entradas do utilizador
     */
    public static void criarPartida(Torneio torneio, Scanner scanner) {
        List<Jogador> mainBracketCopy = new ArrayList<>(torneio.getMainBracket());
    List<Jogador> losersBracketCopy = new ArrayList<>(torneio.getLosersBracket());
    List<Arbitro> arbitros = torneio.getArbitros();
    int numeroPartidas = mainBracketCopy.size() / 2;
    int indiceArbitro = 0;

    if (torneio.getMainBracket().size() == 1 && torneio.getLosersBracket().size() == 1) {
        Jogador jogadorMain = torneio.getMainBracket().get(0);
        Jogador jogadorLosers = torneio.getLosersBracket().get(0);

        Arbitro arbitro = torneio.getArbitros().get(0); 
        Partida partida = new Partida(torneio, jogadorMain, jogadorLosers, arbitro, 0, 0);
        torneio.getPartidas().add(partida);

        System.out.println("Partida criada: " + jogadorMain.getNome() + " vs " + jogadorLosers.getNome() + " com o árbitro " + arbitro.getNome());

        return;
    }
        if (mainBracketCopy.size() == 1 && losersBracketCopy.isEmpty()) {
            Jogador vencedor = mainBracketCopy.get(0);
            System.out.println("\nVencedor do torneio é " + vencedor.getNome());
            torneio.removerMainBracket(vencedor);
            torneio.getArbitros().clear();
            return;
        }
    
        for (int i = 0; i < numeroPartidas; i++) {
            if (mainBracketCopy.size() < 2 || indiceArbitro >= arbitros.size()) {
                break;
            }
    
            Jogador jogador1 = mainBracketCopy.remove(0);
            Jogador jogador2 = mainBracketCopy.remove(0);
            Arbitro arbitro = arbitros.get(indiceArbitro);
    
            arbitro.setJogos(arbitro.getJogos() + 1);
    
            Partida partida = new Partida(torneio, jogador1, jogador2, arbitro, 0, 0);
            torneio.getPartidas().add(partida);
    
            System.out.println("Partida criada: " + jogador1.getNome() + " vs " + jogador2.getNome() + " com o árbitro " + arbitro.getNome());
    
            indiceArbitro++;
            if (indiceArbitro >= arbitros.size()) {
                indiceArbitro = 0;
            }
        }
    
        numeroPartidas = losersBracketCopy.size() / 2; 
        indiceArbitro = 0; 
    
        for (int i = 0; i < numeroPartidas; i++) {
            if (losersBracketCopy.size() < 2 || indiceArbitro >= arbitros.size()) {
                break;
            }
    
            Jogador jogador1 = losersBracketCopy.remove(0);
            Jogador jogador2 = losersBracketCopy.remove(0);
            Arbitro arbitro = arbitros.get(indiceArbitro);
    
            arbitro.setJogos(arbitro.getJogos() + 1);
    
            Partida partida = new Partida(torneio, jogador1, jogador2, arbitro, 0, 0);
            torneio.getPartidas().add(partida);
    
            System.out.println("Partida criada: " + jogador1.getNome() + " vs " + jogador2.getNome() + " com o árbitro " + arbitro.getNome());
    
            indiceArbitro++;
            if (indiceArbitro >= arbitros.size()) {
                indiceArbitro = 0;
            }
        }
    
        System.out.println("Todas as partidas foram criadas para o torneio '" + torneio.getDesporto() + "'.");
    }
    
    
    
    /**
     * Registra as pontuações de todas as partidas de um torneio selecionado.
     *
     * @param scanner O scanner utilizado para ler as entradas do utilizador
     */
    public static void registrarPontosDaPartida(Scanner scanner) {
        List<Torneio> torneios = GerirTorneios.getTorneios();
        List<Torneio> torneiosValidos = new ArrayList<>(); 
    
        for (Torneio torneio : torneios) {
            if (torneio.getMainBracket().size() > 0) {
                torneiosValidos.add(torneio);
            }
        }
    
        if (torneiosValidos.isEmpty()) {
            System.out.println("Não há torneios com mais de um participante para registrar pontuações.");
            return;
        }
    
        System.out.println("Escolha o torneio para o qual deseja registrar os pontos:");
        for (int i = 0; i < torneiosValidos.size(); i++) {
            System.out.println((i + 1) + ". " + torneiosValidos.get(i).getDesporto() + " - " + torneiosValidos.get(i).getData());
        }
    
        System.out.print("Insira o número do torneio: ");
        int numeroTorneio;
        while (true) {
            if (scanner.hasNextInt()) {
                numeroTorneio = scanner.nextInt();
                break;
            } else {
                System.out.println("Entrada inválida. Insira um número inteiro.");
                scanner.next(); 
            }
        }
    
        if (numeroTorneio < 1 || numeroTorneio > torneiosValidos.size()) {
            System.out.println("Número de torneio inválido.");
            return;
        }
    
        Torneio torneio = torneiosValidos.get(numeroTorneio - 1);
    
        List<Partida> partidas = torneio.getPartidas();
    
        if (partidas.isEmpty()) {
            System.out.println("Não há partidas para registrar pontuações neste torneio.");
            return;
        }
        
    
        for (Partida partida : partidas) {
            if (partida.getJogador1Pontuacao() == 0 && partida.getJogador2Pontuacao() == 0) {
                while (true) {
                    System.out.println("\nTorneio: " + torneio.getDesporto());
                    System.out.println("Partida:");
                    System.out.println(partida.getJogador1().getNome() + " vs " + partida.getJogador2().getNome());
    
                    int pontuacaoJogador1;
                    while (true) {
                        System.out.print("Pontuação de " + partida.getJogador1().getNome() + ": ");
                        if (scanner.hasNextInt()) {
                            pontuacaoJogador1 = scanner.nextInt();
                            break;
                        } else {
                            System.out.println("Entrada inválida. Insira um número inteiro.");
                            scanner.next(); 
                        }
                    }
                    partida.setJogador1Pontuacao(pontuacaoJogador1);
                    scanner.nextLine();
    
                    int pontuacaoJogador2;
                    while (true) {
                        System.out.print("Pontuação de " + partida.getJogador2().getNome() + ": ");
                        if (scanner.hasNextInt()) {
                            pontuacaoJogador2 = scanner.nextInt();
                            break;
                        } else {
                            System.out.println("Entrada inválida. Insira um número inteiro.");
                            scanner.next(); 
                        }
                    }
                    partida.setJogador2Pontuacao(pontuacaoJogador2);
                    scanner.nextLine();
                    
                    if (torneio.getMainBracket().size() == 1 && torneio.getLosersBracket().size() == 1) {
                        if (pontuacaoJogador2 > pontuacaoJogador1) {
                            Jogador perdedor = partida.getJogador1();
                            Jogador vencedor = partida.getJogador2();
                            torneio.removerLosersBracket(vencedor); 
                            torneio.adicionarMainBracket(vencedor); 
                            partida.getJogador2().setVitorias(partida.getJogador2().getVitorias() + 1);
                            partida.getJogador1().setDerrotas(partida.getJogador1().getDerrotas() + 1);
                        } else if (pontuacaoJogador1 > pontuacaoJogador2) {
                            Jogador perdedor = partida.getJogador2();
                            Jogador vencedor = partida.getJogador1();
                            torneio.removerLosersBracket(perdedor); 
                            torneio.setVencedor(vencedor); 
                            partida.getJogador1().setVitorias(partida.getJogador1().getVitorias() + 1);
                            partida.getJogador2().setDerrotas(partida.getJogador2().getDerrotas() + 1);
                        }
                    } else {
                        if (torneio.getTipo().equals("DoubleKnockout") && torneio.getMainBracket().size() == 2 && torneio.getLosersBracket().isEmpty()) {
                            if (pontuacaoJogador2 > pontuacaoJogador1) {
                                Jogador perdedor = partida.getJogador1();
                                Jogador vencedor = partida.getJogador2();
                                torneio.removerMainBracket(perdedor);
                                torneio.setVencedor(vencedor); 
                                partida.getJogador2().setVitorias(partida.getJogador2().getVitorias() + 1);
                                partida.getJogador1().setDerrotas(partida.getJogador1().getDerrotas() + 1);
                            } else if (pontuacaoJogador1 > pontuacaoJogador2) {
                                Jogador perdedor = partida.getJogador2();
                                Jogador vencedor = partida.getJogador1();
                                torneio.removerMainBracket(perdedor);
                                torneio.setVencedor(vencedor); 
                                partida.getJogador1().setVitorias(partida.getJogador1().getVitorias() + 1);
                                partida.getJogador2().setDerrotas(partida.getJogador2().getDerrotas() + 1);
                            }
                        } else {
                    Jogador vencedor = null;
                    if (pontuacaoJogador1 > pontuacaoJogador2) {
                        vencedor = partida.getJogador1();
                        vencedor.setVitorias(vencedor.getVitorias() + 1);
                        partida.getJogador2().setDerrotas(partida.getJogador2().getDerrotas() + 1);
                    } else if (pontuacaoJogador2 > pontuacaoJogador1) {
                        vencedor = partida.getJogador2();
                        
                        vencedor.setVitorias(vencedor.getVitorias() + 1);
                        partida.getJogador1().setDerrotas(partida.getJogador1().getDerrotas() + 1);
                    } else {
                        System.out.println("A partida terminou em empate. Por favor, registre novamente os pontos.");
                        continue; 
                    }
    
                    if (vencedor != null) {
                        System.out.println("O jogador " + vencedor.getNome() + " venceu a partida.");
                        if (torneio.getTipo().equals("DoubleKnockout")) {
                            Jogador perdedor = (vencedor == partida.getJogador1()) ? partida.getJogador2() : partida.getJogador1();
                            if (torneio.getLosersBracket().contains(perdedor)) {
                                torneio.removerLosersBracket(perdedor); 
                            } else {
                                torneio.removerMainBracket(perdedor);
                                torneio.adicionarLosersBracket(perdedor); 
                            }
                        } else {
                            if (torneio.getMainBracket().size() == 2 && torneio.getLosersBracket().isEmpty()) {
                                Jogador perdedor = (vencedor == partida.getJogador1()) ? partida.getJogador2() : partida.getJogador1();
                                torneio.removerMainBracket(perdedor);
                                torneio.setVencedor(vencedor);
                            } else{
                            Jogador perdedor = (vencedor == partida.getJogador1()) ? partida.getJogador2() : partida.getJogador1();
                            torneio.removerMainBracket(perdedor);
                        }
                    }
            
                    } else {
                        System.out.println("A partida terminou em empate.");
                    }
                    }
                }
                    break; 
                }
            }
        }
    
        if (torneio.getTipo().equals("DoubleKnockout") && torneio.getMainBracket().size() == 2 && torneio.getLosersBracket().isEmpty() && torneio.getVencedor() != null) {

        } else {
            criarPartida(torneio, scanner);
            return;
        }
    
    }
}    
    
