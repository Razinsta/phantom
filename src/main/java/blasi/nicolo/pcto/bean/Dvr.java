package blasi.nicolo.pcto.bean;

public class Dvr {
    
    private int id;
    private String dvr;
    
    public Dvr(int id, String dvr) {
        super();
        this.id = id;
        this.dvr = dvr;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDvr() {
        return dvr;
    }

    public void setDvr(String dvr) {
        this.dvr = dvr;
    }

    @Override
    public String toString() {
        return id + ", " + dvr;
    }

    
    

}
