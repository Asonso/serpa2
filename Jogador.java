import java.util.ArrayList;
import java.util.List;

/**
 * @author 84152 Francisco Picoito
 * @author 55301 Diogo Marques
 * @author 79256 Afonso Santos
 */

public class Jogador {
    private int id;
    private String nome;
    private int numero;
    private List<Desporto> desportos;
    private int jogos;
    private int vitorias;
    private int derrotas;
    private static int ultimoId = 0;

    /**
     * Construtor da classe Jogador.
     *
     * @param nome O nome do jogador
     * @param numero O número associado ao jogador
     * @param desportos A lista de desportos em que o jogador participa
     * @param jogos O número de jogos que o jogador participou
     * @param vitorias O número de vitórias do jogador
     * @param derrotas O número de derrotas do jogador
     */

    public Jogador(String nome, int numero, List<Desporto> desportos, int jogos, int vitorias, int derrotas) {
        this.id = ++ultimoId;
        this.nome = nome;
        this.numero = numero;
        this.desportos = desportos;
        this.jogos = jogos;
        this.vitorias = vitorias;
        this.derrotas = derrotas;
    }

    /**
     * Obtém o identificador único do jogador.
     *
     * @return O identificador único do jogador
     */
    public int getId() {
        return id;
    }
    
    /**
     * Obtém o nome do jogador.
     *
     * @return O nome do jogador
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do jogador.
     *
     * @param nome O novo nome do jogador
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém o número associado ao jogador.
     *
     * @return O número associado ao jogador
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Define o número associado ao jogador.
     *
     * @param numero O novo número associado ao jogador
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * Obtém a lista de desportos em que o jogador participa.
     *
     * @return A lista de desportos em que o jogador participa
     */
    public List<Desporto> getDesportos() {
        return this.desportos;
    }
    
    /**
     * Obtém a lista de desportos em que o jogador participa como uma lista de strings.
     *
     * @return A lista de desportos em que o jogador participa como uma lista de strings
     */
    public List<String> getDesportosAsString() {
        List<String> desportosAsString = new ArrayList<>();
        for (Desporto desporto : desportos) {
            desportosAsString.add(desporto.name());
        }
        return desportosAsString;
    }

    /**
     * Adiciona um novo desporto à lista de desportos em que o jogador participa.
     *
     * @param desporto O desporto a ser adicionado à lista
     */
    public void adicionarDesporto(Desporto desporto) {
        desportos.add(desporto);
    }

    /**
     * Remove um desporto da lista de desportos em que o jogador participa.
     *
     * @param desporto O desporto a ser removido da lista
     */
    public void removerDesporto(Desporto desporto) {
        desportos.remove(desporto);
    }

    /**
     * Obtém o número de jogos que o jogador participou.
     *
     * @return O número de jogos que o jogador participou
     */
    public int getJogos() {
        return jogos;
    }

    /**
     * Define o número de jogos que o jogador participou.
     *
     * @param jogos O novo número de jogos que o jogador participou
     */
    public void setJogos(int jogos) {
        this.jogos = jogos;
    }

    /**
     * Obtém o número de vitórias do jogador.
     *
     * @return O número de vitórias do jogador
     */
    public int getVitorias() {
        return vitorias;
    }

    /**
     * Define o número de vitórias do jogador.
     *
     * @param vitorias O novo número de vitórias do jogador
     */
    public void setVitorias(int vitorias) {
        this.vitorias = vitorias;
    }

    /**
     * Obtém o número de derrotas do jogador.
     *
     * @return O número de derrotas do jogador
     */
    public int getDerrotas() {
        return derrotas;
    }

    /**
     * Define o número de derrotas do jogador.
     *
     * @param derrotas O novo número de derrotas do jogador
     */
    public void setDerrotas(int derrotas) {
        this.derrotas = derrotas;
    }

    
}
