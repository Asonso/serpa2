import java.util.ArrayList;
import java.util.List;

public class Equipa{
    private int id;
    private String nome;
    private DesportoEquipa desporto;
    private List<Jogador> jogadores;
    private static int ultimoId = 0;


    public Equipa(int id, String nome, DesportoEquipa desporto, List<Jogador> jogadores){
        this.id = ++ultimoId;
        this.nome = nome;
        this.desporto = desporto;
        this.jogadores = jogadores;
    }

    public int getid(){
        return id;
    }

    public String getnome(){
        return nome;
    }

    public DesportoEquipa getDesporto() {
        return desporto;
    }

    public void setDesporto(DesportoEquipa Desporto) {
        this.desporto = desporto;
    }

    public List<Jogador> getjogadores() {
        return this.jogadores;
    }

    public List<String> getJogadoresAsString() {
        List<String> jogadoresAsString = new ArrayList<>();
        for (Jogador jogador : jogadores) {
            jogadoresAsString.add(jogador.getNome());
        }
        return jogadoresAsString;
    }

    public void adicionarJogador(Jogador jogador) {
        jogadores.add(jogador);
    }

    public void removerJogador(Jogador jogador) {
        jogadores.remove(jogador);
    }
}

