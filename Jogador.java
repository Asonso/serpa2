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
    private static int ultimoId = 0;

    public Jogador(String nome, int numero, int jogos, int vitorias, int derrotas) {
        this.id = ++ultimoId;
        this.nome = nome;
        this.numero = numero;
        this.desportos = new ArrayList<>();
        this.jogos = jogos;
        this.vitorias = vitorias;
        this.derrotas = derrotas;
    }

    public int getId() {
        return id;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
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

    public int getJogos() {
        return jogos;
    }

    public void setJogos(int jogos) {
        this.jogos = jogos;
    }

    public int getVitorias() {
        return vitorias;
    }

    public void setVitorias(int vitorias) {
        this.vitorias = vitorias;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public void setDerrotas(int derrotas) {
        this.derrotas = derrotas;
    }
}
