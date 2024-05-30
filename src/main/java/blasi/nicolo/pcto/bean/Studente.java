package blasi.nicolo.pcto.bean;


public class Studente {

    private int id;
    private String nome;
    private String cognome;
    private String classe;
    private String comuneNascita;
    private String dataNascita;
    private String comuneResidenza;
    private String indirizzoResidenza;
    private String pei;
    private int idPcto;

    
    public Studente() {}

    
    public Studente(int id, String nome, String cognome, String classe, String comuneNascita, String dataNascita, 
                       String comuneResidenza, String indirizzoResidenza, String pei, int idPcto) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.classe = classe;
        this.comuneNascita = comuneNascita;
        this.dataNascita = dataNascita;
        this.comuneResidenza = comuneResidenza;
        this.indirizzoResidenza = indirizzoResidenza;
        this.pei = pei;
        this.idPcto = idPcto;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getComuneNascita() {
        return comuneNascita;
    }

    public void setComuneNascita(String comuneNascita) {
        this.comuneNascita = comuneNascita;
    }

    public String getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(String dataNascita) {
        this.dataNascita = dataNascita;
    }

    public String getComuneResidenza() {
        return comuneResidenza;
    }

    public void setComuneResidenza(String comuneResidenza) {
        this.comuneResidenza = comuneResidenza;
    }

    public String getIndirizzoResidenza() {
        return indirizzoResidenza;
    }

    public void setIndirizzoResidenza(String indirizzoResidenza) {
        this.indirizzoResidenza = indirizzoResidenza;
    }

    public String getPei() {
        return pei;
    }

    public void setPei(String pei) {
        this.pei = pei;
    }

    public int getIdPcto() {
        return idPcto;
    }

    public void setIdPcto(int idPcto) {
        this.idPcto = idPcto;
    }


	
    @Override
    public String toString() {
        return id + ", " + nome + ", " + cognome + ", " + classe + ", " + comuneNascita + ", " + dataNascita + ", " 
               + comuneResidenza + ", " + indirizzoResidenza + ", " + pei + ", " + idPcto;
    }

    
}
