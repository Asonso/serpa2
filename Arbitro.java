import java.util.ArrayList;
import java.util.List;

/**
 * @author 84152 Francisco Picoito
 * @author 55301 Diogo Marques
 * @author 79256 Afonso Santos
 */
public class Arbitro {
    private int id;
    private String nome;
    private List<Desporto> desportos;
    private int jogos;
    private static int ultimoId = 0;

    /**
     * Construtor da classe Arbitro.
     *
     * @param nome O nome do árbitro
     * @param desportos A lista de desportos que o árbitro pode arbitrar
     * @param jogos O número de jogos que o árbitro arbitrou
     */    
    public Arbitro(String nome, List<Desporto> desportos, int jogos) {
        this.id = ++ultimoId;
        this.nome = nome;
        this.desportos = desportos;
        this.jogos = jogos;
    }

    /**
     * Obtém o identificador único do árbitro.
     *
     * @return O identificador único do árbitro
     */
    public int getId(){
        return id;
    }
    
    /**
     * Obtém o nome do árbitro.
     *
     * @return O nome do árbitro
     */
    public String getNome(){
        return nome;
    }

    /**
     * Define o nome do árbitro.
     *
     * @param nome O novo nome do árbitro
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém a lista de desportos que o árbitro pode arbitrar.
     *
     * @return A lista de desportos que o árbitro pode arbitrar
     */
    public List<Desporto> getDesportos() {
        return this.desportos;
    }

    /**
     * Obtém a lista de desportos que o árbitro pode arbitrar como uma lista de strings.
     *
     * @return A lista de desportos que o árbitro pode arbitrar como uma lista de strings
     */
    public List<String> getDesportosAsString() {
        List<String> desportosAsString = new ArrayList<>();
        for (Desporto desporto : desportos) {
            desportosAsString.add(desporto.name());
        }
        return desportosAsString;
    }

    /**
     * Adiciona um novo desporto à lista de desportos que o árbitro pode arbitrar.
     *
     * @param desporto O desporto a ser adicionado à lista
     */
    public void adicionarDesporto(Desporto desporto) {
        desportos.add(desporto);
    }

    /**
     * Remover um novo desporto à lista de desportos que o árbitro pode arbitrar.
     *
     * @param desporto O desporto a ser adicionado à lista
     */
    public void removerDesporto(Desporto desporto) {
        desportos.remove(desporto);
    }

    /**
     * Obtém o número de jogos que o árbitro arbitrou.
     *
     * @return O número de jogos que o árbitro arbitrou
     */
    public int getJogos() {
        return jogos;
    }

    /**
     * Define o número de jogos que o árbitro arbitrou.
     *
     * @param jogos O novo número de jogos que o árbitro arbitrou
     */
    public void setJogos(int jogos) {
        this.jogos = jogos;
    }
}