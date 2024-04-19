import java.util.ArrayList;
import java.util.List;

public class Arbitro {
    private int id;
    private String nome;
    private int numero;
    private List<String> desportos;

    public Arbitro(String nome, int numero) {
        this.id = id;
        this.nome = nome;
        this.numero = numero;
        this.desportos = new ArrayList<>();
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