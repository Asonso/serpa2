import java.util.ArrayList;
import java.util.List;

public class Jogador {
    private int id;
    private String nome;
    private int numero;
    private List<String> desportos;
    private int jogos;
    private int vitorias;
    private int derrotas;

    public Jogador(int id, String nome, int numero, int jogos, int vitorias, int derrotas) {
        this.id = id;
        this.nome = nome;
        this.numero = numero;
        this.desportos = new ArrayList<>();
        this.jogos = jogos;
        this.vitorias = vitorias;
        this.derrotas = derrotas;
    }

    public int getid(){
        return id;
    }
    
    public String getNome(){
        return nome;
    }

    public int getNumero(){
        return numero;
    }

    public List<String> getDesportos() {
        return desportos;
    }

    public void adicionarDesporto(String desporto) {
        desportos.add(desporto);
    }

    public void removerDesporto(String desporto) {
        desportos.remove(desporto);
    }
}