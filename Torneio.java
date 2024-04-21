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
    private static int ultimoId = 0;
    
    /**
     * Construtor da classe Torneio
     * 
     * @param desporto      O desporto do Torneio
     * @param data      A data de realização do Torneio
     * @param local     Local onde é realizado o Torneio
     * @param numeroParticipantes       Número de participantes no torneio    
     * @param tipo      Tipo do torneio     
     */
    public Torneio(String desporto, String data, String local, int numeroParticipantes, String tipo, List<Jogador> mainBracket, List<Jogador> losersBracket, List<Arbitro> arbitros) {
        this.id = ++ultimoId;
        this.desporto = desporto;
        this.data = data;
        this.local = local;
        this.numeroParticipantes = numeroParticipantes;
        this.tipo = tipo;
        this.mainBracket = mainBracket;
        this.losersBracket = losersBracket;
        this.arbitros = arbitros;
        
    }

    /**
     * Óbtem o desporto do torneio
     * 
     * @return O desporto do torneio
     */
    public int getId() {
        return id;
    }

    public String getDesporto() {
        return desporto;
    }

    /**
     * Óbtem a data do torneio
     * 
     * @return A data do torneio
     */
    public String getData() {
        return data;
    }

    /**
     * Óbtem o local do torneio
     * 
     * @return O local do torneio
     */
    public String getLocal() {
        return local;
    }


     /**
     * Óbtem o número de participantes no torneio
     * 
     * @return Número de participantes no torneio
     */
    public int getNumeroParticipantes() {
        return numeroParticipantes;
    }

     /**
     * Óbtem o número de participantes no torneio
     * 
     * @return Número de participantes no torneio
     */
    public String getTipo() {
        return tipo;
    }

    public List<Jogador> getMainBracket() {
        return this.mainBracket;
    }

    public void adicionarMainBracket(Jogador jogador) {
        mainBracket.add(jogador);
    }

    public void removerMainBracket(Jogador jogador) {
        mainBracket.remove(jogador);
    }

    public List<Jogador> getLosersBracket() {
        return this.losersBracket;
    }

    public void adicionarLosersBracket(Jogador jogador) {
        losersBracket.add(jogador);
    }

    public void removerLosersBracket(Jogador jogador) {
        losersBracket.remove(jogador);
    }

    public List<Arbitro> getArbitros() {
        return this.arbitros;
    }

    public void adicionarArbitro(Arbitro arbitro) {
        arbitros.add(arbitro);
    }

    public void removerArbitro(Arbitro arbitro) {
        arbitros.remove(arbitro);
    }
}