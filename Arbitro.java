import java.util.ArrayList;
import java.util.List;

public class Arbitro {
    private int id;
    private String nome;
    private int numero;
    private List<Desporto> desportos;
    private int jogos;
    private static int ultimoId = 0;

    public Arbitro(String nome, List<Desporto> desportos, int jogos) {
        this.id = ++ultimoId;
        this.nome = nome;
        this.desportos = desportos;
        this.jogos = jogos;
    }

    public int getId(){
        return id;
    }
    
    public String getNome(){
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumero(){
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
}