import java.util.ArrayList;
import java.util.List;

public class Jogador {
    private int id;
    private String nome;
    private int numero;
    private List<Desporto> desportos;
    private int jogos;
    private int vitorias;
    private int derrotas;
    private static int ultimoId = 0;

    public Jogador(String nome, int numero, List<Desporto> desportos, int jogos, int vitorias, int derrotas) {
        this.id = ++ultimoId;
        this.nome = nome;
        this.numero = numero;
        this.desportos = desportos;
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

    public List<Desporto> getDesportos() {
        return this.desportos;
    }
    
    public List<String> getDesportosAsString() {
        List<String> desportosAsString = new ArrayList<>();
        for (Desporto desporto : desportos) {
            desportosAsString.add(desporto.name());
        }
        return desportosAsString;
    }

    public void adicionarDesporto(Desporto desporto) {
        desportos.add(desporto);
    }

    public void removerDesporto(Desporto desporto) {
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
