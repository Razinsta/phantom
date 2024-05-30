package blasi.nicolo.pcto.bean;

public class Argomenti {
    
    private int id;
    private String argomenti;
    
    public Argomenti(int id, String argomenti) {

        this.id = id;
        this.argomenti = argomenti;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArgomenti() {
        return argomenti;
    }

    public void setArgomenti(String argomenti) {
        this.argomenti = argomenti;
    }

    @Override
    public String toString() {
        return id + ", " + argomenti;
    }

}
