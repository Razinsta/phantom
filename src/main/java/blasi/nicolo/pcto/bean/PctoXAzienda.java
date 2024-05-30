package blasi.nicolo.pcto.bean;
public class PctoXAzienda {
    private int id;
    private String statoAvanzamento;
    private String esitoContatto;
    private int nStudenti;
    private int idPcto;
    private int idAzienda;

 public PctoXAzienda(int id, String statoAvanzamento, String esitoContatto, int nStudenti, int idPcto, int idAzienda) {
        this.id = id;
        this.statoAvanzamento = statoAvanzamento;
        this.esitoContatto = esitoContatto;
        this.nStudenti = nStudenti;
        this.idPcto = idPcto;
        this.idAzienda = idAzienda;
    }

 
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatoAvanzamento() {
        return statoAvanzamento;
    }

    public void setStatoAvanzamento(String statoAvanzamento) {
        this.statoAvanzamento = statoAvanzamento;
    }

    public String getEsitoContatto() {
        return esitoContatto;
    }

    public void setEsitoContatto(String esitoContatto) {
        this.esitoContatto = esitoContatto;
    }

    public int getNStudenti() {
        return nStudenti;
    }

    public void setNStudenti(int nStudenti) {
        this.nStudenti = nStudenti;
    }

    public int getIdPcto() {
        return idPcto;
    }

    public void setIdPcto(int idPcto) {
        this.idPcto = idPcto;
    }

    public int getIdAzienda() {
        return idAzienda;
    }

    public void setIdAzienda(int idAzienda) {
        this.idAzienda = idAzienda;
    }


    @Override
    public String toString() {
        return id + ", " + statoAvanzamento + ", " + esitoContatto + ", " + nStudenti + ", " + idPcto + ", " + idAzienda;
    }


   


 }
