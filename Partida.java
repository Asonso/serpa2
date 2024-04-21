public class Partida {
    private Torneio torneio;
    private Jogador jogador1;
    private Jogador jogador2;
    private Arbitro arbitro;
    private int jogador1Pontuacao;
    private int jogador2Pontuacao;

    public Partida(Torneio torneio, Jogador jogador1, Jogador jogador2, Arbitro arbitro, int jogador1Pontuacao, int jogador2Pontuacao) {
        this.torneio = torneio;
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        this.arbitro = arbitro;
        this.jogador1Pontuacao = jogador1Pontuacao;
        this.jogador2Pontuacao = jogador2Pontuacao;
    }
    
    public Torneio getTorneio(){
        return torneio;
    }

    public void setTorneio(Torneio torneio) {
        this.torneio = torneio;
    }

    public Jogador getJogador1(){
        return jogador1;
    }

    public void setJogador1(Jogador jogador){
        this.jogador1 = jogador1;
    }

    public Jogador getJogador2(){
        return jogador2;
    }

    public void setJogador2(Jogador jogador){
        this.jogador2 = jogador2;
    }

    public Arbitro getArbitro(){
        return arbitro;
    }

    public void setArbitro(){
        this.arbitro = arbitro;
    }

    public int getJogador1Pontuacao(){
        return jogador1Pontuacao;
    }

    public void setJogador1Pontuacao(int jogador1Pontuacao){
        this.jogador1Pontuacao = jogador1Pontuacao;
    }
    
    public int getJogador2Pontuacao(){
        return jogador2Pontuacao;
    }

    public void setJogador2Pontuacao(int jogador2Pontuacao){
        this.jogador2Pontuacao = jogador2Pontuacao;
    }
}