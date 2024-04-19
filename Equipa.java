import java.util.ArrayList;
import java.util.List;

public class Equipa{
    private int id;
    private String nome;
    private List<Jogador> jogadores;
    private Desporto desporto;

    public Equipa(int id, String nome, Desporto desporto){
        this.id = id;
        this.nome = nome;
        this.jogadores = new ArrayList<>();
        this.desporto = desporto;
    }

    public int getid(){
        return id;
    }

    public String getnome(){
        return nome;
    }

    public List<Jogador> getjogadores() {
        return jogadores;
    }

    public void adicionarJogador(String jogador) {
        jogadores.add(jogador);
    }

    public void removerJogador(String jogador) {
        jogadores.remove(jogador);
    }
}

