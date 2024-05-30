package blasi.nicolo.pcto.bean;

public class SedeTirocinio {
    
    private int id;
    private String sedeTirocinio;
    private String orarioLavoro;
    private String giornatePCTO;
    private int idAzienda;
    
    public SedeTirocinio(int id, String sedeTirocinio, String oarioLavoro, String giornatePCTO, int idAzienda) {
        
        this.id = id;
        this.sedeTirocinio = sedeTirocinio;
        this.orarioLavoro = oarioLavoro;
        this.giornatePCTO = giornatePCTO;
        this.idAzienda = idAzienda;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSedeTirocinio() {
        return sedeTirocinio;
    }

    public void setSedeTirocinio(String sedeTirocinio) {
        this.sedeTirocinio = sedeTirocinio;
    }

    public String getOarioLavoro() {
        return orarioLavoro;
    }

    public void setOarioLavoro(String oarioLavoro) {
        this.orarioLavoro = oarioLavoro;
    }

    public String getGiornatePCTO() {
        return giornatePCTO;
    }

    public void setGiornatePCTO(String giornatePCTO) {
        this.giornatePCTO = giornatePCTO;
    }

    public int getIdAzienda() {
        return idAzienda;
    }

    public void setIdAzienda(int idAzienda) {
        this.idAzienda = idAzienda;
    }

    @Override
    public String toString() {
        return id + ", " + sedeTirocinio + ", " + orarioLavoro + ", " + giornatePCTO + ", " + idAzienda;
    }

    
    
    
    
    

}

