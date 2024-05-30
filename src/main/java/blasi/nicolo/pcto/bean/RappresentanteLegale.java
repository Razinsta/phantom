package blasi.nicolo.pcto.bean;
public class RappresentanteLegale {
    private int id;
    private String rappresentanteLegale;
    private String descrizione;
    private String luogoNascita;
    private String dataNascita;
    private int idAzienda;

   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRappresentanteLegale() {
        return rappresentanteLegale;
    }

    public void setRappresentanteLegale(String rappresentanteLegale) {
        this.rappresentanteLegale = rappresentanteLegale;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getLuogoNascita() {
        return luogoNascita;
    }

    public void setLuogoNascita(String luogoNascita) {
        this.luogoNascita = luogoNascita;
    }

    public String getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(String dataNascita) {
        this.dataNascita = dataNascita;
    }

    public int getIdAzienda() {
        return idAzienda;
    }

    public void setIdAzienda(int idAzienda) {
        this.idAzienda = idAzienda;
    }

 
    public RappresentanteLegale() {
    }

    public RappresentanteLegale(int id, String rappresentanteLegale, String descrizione, String luogoNascita, String dataNascita, int idAzienda) {
        this.id = id;
        this.rappresentanteLegale = rappresentanteLegale;
        this.descrizione = descrizione;
        this.luogoNascita = luogoNascita;
        this.dataNascita = dataNascita;
        this.idAzienda = idAzienda;
    }

  
    @Override
    public String toString() {
        return id + ", " + rappresentanteLegale + ", " + descrizione + ", " + luogoNascita + ", " + dataNascita + ", " + idAzienda;
    }

}
