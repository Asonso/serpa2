import java.util.ArrayList;
import java.util.List;
/**
 * @author 84152 Francisco Picoito
 * @author 55301 Diogo Marques
 * @author 79256 Afonso Santos
 */

 public class Torneio {
    private int id;
    private String desporto;
    private String data;
    private String local;
    private int numeroParticipantes;
    private String tipo;
    private List<Jogador> mainBracket;
    private List<Jogador> losersBracket;
    private List<Arbitro> arbitros;
    private List<Partida> partidas;
    private Jogador vencedor;
    private static int ultimoId = 0;
    
    /**
     * Construtor da classe Torneio
     * 
     * @param desporto      O desporto do Torneio
     * @param data          A data de realização do Torneio
     * @param local         Local onde é realizado o Torneio
     * @param numeroParticipantes      Número de participantes no torneio    
     * @param tipo          Tipo do torneio     
     * @param mainBracket       Lista de jogadores que estão no main bracket
     * @param losersBracket     Lista de jogadores que estão no losers bracket
     * @param arbitros      Lista de arbitros a arbitrar neste torneio
     * @param vencedor      Jogador vencedor do torneio
     */
    public Torneio(String desporto, String data, String local, int numeroParticipantes, String tipo, List<Jogador> mainBracket, List<Jogador> losersBracket, List<Arbitro> arbitros, List<Partida> partidas, Jogador vencedor) {
        this.id = ++ultimoId;
        this.desporto = desporto;
        this.data = data;
        this.local = local;
        this.numeroParticipantes = numeroParticipantes;
        this.tipo = tipo;
        this.mainBracket = mainBracket;
        this.losersBracket = losersBracket;
        this.arbitros = arbitros;
        this.partidas = partidas;
        this.vencedor = vencedor;
        
    }

        /**
     * Obtém o id do torneio.
     *
     * @return O id do torneio
     */
    public int getId() {
        return id;
    }

    /**
     * Obtém o desporto do torneio.
     *
     * @return O desporto do torneio
     */
    public String getDesporto() {
        return desporto;
    }

    /**
     * Obtém a data do torneio.
     *
     * @return A data do torneio
     */
    public String getData() {
        return data;
    }

    /**
     * Obtém o local do torneio.
     *
     * @return O local do torneio
     */
    public String getLocal() {
        return local;
    }

    /**
     * Obtém o número de participantes no torneio.
     *
     * @return O número de participantes no torneio
     */
    public int getNumeroParticipantes() {
        return numeroParticipantes;
    }

    /**
     * Obtém o tipo de torneio (ex: simples, duplas).
     *
     * @return O tipo de torneio
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Obtém a lista de jogadores no bracket principal do torneio.
     *
     * @return A lista de jogadores no bracket principal
     */
    public List<Jogador> getMainBracket() {
        return this.mainBracket;
    }

    /**
     * Adiciona um jogador ao bracket principal do torneio.
     *
     * @param jogador O jogador a ser adicionado
     */
    public void adicionarMainBracket(Jogador jogador) {
        mainBracket.add(jogador);
    }

    /**
     * Remove um jogador do bracket principal do torneio.
     *
     * @param jogador O jogador a ser removido
     */
    public void removerMainBracket(Jogador jogador) {
        mainBracket.remove(jogador);
    }

    /**
     * Obtém a lista de jogadores no bracket de perdedores do torneio.
     *
     * @return A lista de jogadores no bracket de perdedores
     */
    public List<Jogador> getLosersBracket() {
        return this.losersBracket;
    }

    /**
     * Adiciona um jogador ao bracket de perdedores do torneio.
     *
     * @param jogador O jogador a ser adicionado
     */
    public void adicionarLosersBracket(Jogador jogador) {
        losersBracket.add(jogador);
    }

    /**
     * Remove um jogador do bracket de perdedores do torneio.
     *
     * @param jogador O jogador a ser removido
     */
    public void removerLosersBracket(Jogador jogador) {
        losersBracket.remove(jogador);
    }

    /**
     * Obtém a lista de árbitros do torneio.
     *
     * @return A lista de árbitros do torneio
     */
    public List<Arbitro> getArbitros() {
        return this.arbitros;
    }

    /**
     * Adiciona um árbitro ao torneio.
     *
     * @param arbitro O árbitro a ser adicionado
     */
    public void adicionarArbitro(Arbitro arbitro) {
        arbitros.add(arbitro);
    }

    /**
     * Remove um árbitro do torneio.
     *
     * @param arbitro O árbitro a ser removido
     */
    public void removerArbitro(Arbitro arbitro) {
        arbitros.remove(arbitro);
    }

    /**
     * Obtém a lista de partidas do torneio.
     *
     * @return A lista de partidas do torneio
     */
    public List<Partida> getPartidas() {
        return this.partidas;
    }

    /**
     * Adiciona uma partida ao torneio.
     *
     * @param partida A partida a ser adicionada
     */
    public void adicionarPartida(Partida partida) {
        this.partidas.add(partida);
    }

    /**
     * Remove uma partida do torneio.
     *
     * @param partida A partida a ser removida
     */
    public void removerPartida(Partida partida) {
        this.partidas.remove(partida);
    }

    /**
     * Obtém o vencedor do torneio.
     *
     * @return O jogador vencedor do torneio
     */
    public Jogador getVencedor() {
        return vencedor;
    }

    /**
     * Define o vencedor do torneio.
     *
     * @param vencedor O jogador vencedor do torneio
     */
    public void setVencedor(Jogador vencedor) {
        this.vencedor = vencedor;
    }

}
