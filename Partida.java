/**
 * @author 84152 Francisco Picoito
 * @author 55301 Diogo Marques
 * @author 79256 Afonso Santos
 */
public class Partida {
    private Torneio torneio;
    private Jogador jogador1;
    private Jogador jogador2;
    private Arbitro arbitro;
    private int jogador1Pontuacao;
    private int jogador2Pontuacao;

    /**
     * Construtor da classe Partida
     *
     * @param torneio            O torneio ao qual a partida pertence
     * @param jogador1           O primeiro jogador da partida
     * @param jogador2           O segundo jogador da partida
     * @param arbitro            O árbitro responsável pela partida
     * @param jogador1Pontuacao A pontuação do primeiro jogador
     * @param jogador2Pontuacao A pontuação do segundo jogador
     */
    public Partida(Torneio torneio, Jogador jogador1, Jogador jogador2, Arbitro arbitro, int jogador1Pontuacao, int jogador2Pontuacao) {
        this.torneio = torneio;
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        this.arbitro = arbitro;
        this.jogador1Pontuacao = jogador1Pontuacao;
        this.jogador2Pontuacao = jogador2Pontuacao;
    }
    
    /**
     * Obtém o torneio associado a esta partida.
     *
     * @return O torneio da partida
     */
    public Torneio getTorneio(){
        return torneio;
    }

    /**
     * Define o torneio associado a esta partida.
     *
     * @param torneio O torneio a ser definido
     */
    public void setTorneio(Torneio torneio) {
        this.torneio = torneio;
    }

    /**
     * Obtém o primeiro jogador desta partida.
     *
     * @return O primeiro jogador
     */
    public Jogador getJogador1(){
        return jogador1;
    }

    /**
     * Define o primeiro jogador desta partida.
     *
     * @param jogador O primeiro jogador a ser definido
     */
    public void setJogador1(Jogador jogador){
        this.jogador1 = jogador1;
    }

    /**
     * Obtém o segundo jogador desta partida.
     *
     * @return O segundo jogador
     */
    public Jogador getJogador2(){
        return jogador2;
    }

    /**
     * Define o segundo jogador desta partida.
     *
     * @param jogador O segundo jogador a ser definido
     */
    public void setJogador2(Jogador jogador){
        this.jogador2 = jogador2;
    }

    /**
     * Obtém o árbitro associado a esta partida.
     *
     * @return O árbitro da partida
     */
    public Arbitro getArbitro(){
        return arbitro;
    }

    /**
     * Define o árbitro associado a esta partida.
     *
     * @param arbitro O árbitro a ser definido
     */
    public void setArbitro(){
        this.arbitro = arbitro;
    }

    /**
     * Obtém a pontuação do primeiro jogador nesta partida.
     *
     * @return A pontuação do primeiro jogador
     */
    public int getJogador1Pontuacao(){
        return jogador1Pontuacao;
    }

    /**
     * Define a pontuação do primeiro jogador nesta partida.
     *
     * @param jogador1Pontuacao A pontuação do primeiro jogador a ser definida
     */
    public void setJogador1Pontuacao(int jogador1Pontuacao){
        this.jogador1Pontuacao = jogador1Pontuacao;
    }
    
    /**
     * Obtém a pontuação do segundo jogador nesta partida.
     *
     * @return A pontuação do segundo jogador
     */
    public int getJogador2Pontuacao(){
        return jogador2Pontuacao;
    }

    /**
     * Define a pontuação do segundo jogador nesta partida.
     *
     * @param jogador2Pontuacao A pontuação do segundo jogador a ser definida
     */
    public void setJogador2Pontuacao(int jogador2Pontuacao){
        this.jogador2Pontuacao = jogador2Pontuacao;
    }
}