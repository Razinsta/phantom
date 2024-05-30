package blasi.nicolo.pcto.bean;
public class Colloquio {
    private int id;
    private String data;
    private String ora;
    private int idPctoXAzienda;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getOra() {
        return ora;
    }

    public void setOra(String ora) {
        this.ora = ora;
    }

    public int getIdPctoXAzienda() {
        return idPctoXAzienda;
    }

    public void setIdPctoXAzienda(int idPctoXAzienda) {
        this.idPctoXAzienda = idPctoXAzienda;
    }

  
    public Colloquio() {
    }

    public Colloquio(int id, String data, String ora, int idPctoXAzienda) {
        this.id = id;
        this.data = data;
        this.ora = ora;
        this.idPctoXAzienda = idPctoXAzienda;
    }

 
    @Override
    public String toString() {
        return id + ", " + data + ", " + ora + ", " + idPctoXAzienda;
    }

}

