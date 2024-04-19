/**
 * @author 84152 Francisco Picoito
 * @author 55301 Diogo Marques
 * @author 79256 Afonso Santos
 */

 public class Torneio {
    private String desporto;
    private String data;
    private String local;
    private int numeroEquipas;
    private int elementosPorEquipa;
    private int numeroParticipantes;
    private String tipo;
    
    /**
     * Construtor da classe Torneio
     * 
     * @param desporto      O desporto do Torneio
     * @param data      A data de realização do Torneio
     * @param local     Local onde é realizado o Torneio
     * @param numeroEquipas     Número de equipas no torneio
     * @param numeroParticipantes       Número de participantes no torneio    
     * @param tipo      Tipo do torneio     
     */
    public Torneio(String desporto, String data, String local, int numeroEquipas, int numeroParticipantes, String tipo) {
        this.desporto = desporto;
        this.data = data;
        this.local = local;
        this.numeroEquipas = numeroEquipas;
        this.numeroParticipantes = numeroParticipantes;
        this.tipo = tipo;
    }

    /**
     * Óbtem o desporto do torneio
     * 
     * @return O desporto do torneio
     */
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
     * Óbtem o número de equipas no torneio
     * 
     * @return Número de equipas no torneio
     */
    public int getNumeroEquipas() {
        return numeroEquipas;
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


}