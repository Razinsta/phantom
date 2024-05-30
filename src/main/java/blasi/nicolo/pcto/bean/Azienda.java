package blasi.nicolo.pcto.bean;

public class Azienda {

    private int id;
    private String ragioneSociale;
    private String pIVA;
    private String sedeLegale;
    private String topic;
    private String note;
    private String statoConvenzione;
    private String nConvenzione;
    private int idDvr;

    public Azienda(int id, String ragioneSociale, String pIVA, String sedeLegale, String topic, String note,
                   String statoConvenzione, String nConvenzione) {

    	this.id = id;
        this.ragioneSociale = ragioneSociale;
        this.pIVA = pIVA;
        this.sedeLegale = sedeLegale;
        this.topic = topic;
        this.note = note;
        this.statoConvenzione = statoConvenzione;
        this.nConvenzione = nConvenzione;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRagioneSociale() {
        return ragioneSociale;
    }

    public void setRagioneSociale(String ragioneSociale) {
        this.ragioneSociale = ragioneSociale;
    }

    public String getpIVA() {
        return pIVA;
    }

    public void setpIVA(String pIVA) {
        this.pIVA = pIVA;
    }

    public String getSedeLegale() {
        return sedeLegale;
    }

    public void setSedeLegale(String sedeLegale) {
        this.sedeLegale = sedeLegale;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getStatoConvenzione() {
        return statoConvenzione;
    }

    public void setStatoConvenzione(String statoConvenzione) {
        this.statoConvenzione = statoConvenzione;
    }

    public String getnConvenzione() {
        return nConvenzione;
    }

    public void setnConvenzione(String nConvenzione) {
        this.nConvenzione = nConvenzione;
    }

    public int getIdDvr() {
        return idDvr;
    }

    public void setIdDvr(int idDvr) {
        this.idDvr = idDvr;
    }

    @Override
    public String toString() {
        return id + ", " + ragioneSociale + ", " + pIVA + ", " + sedeLegale + ", " + topic + ", " + note + ", " + statoConvenzione + ", " + nConvenzione + ", " + idDvr;
    }

    
    
}
							