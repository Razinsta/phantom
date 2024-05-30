package blasi.nicolo.pcto.bean;

public class PCTO {

    private int id;
    private String annoScolastico;
    private String classi;
    private String corrente;

   
    public PCTO(int id, String annoScolastico, String classi, String corrente) {
        this.id = id;
        this.annoScolastico = annoScolastico;
        this.classi = classi;
        this.corrente = corrente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnnoScolastico() {
        return annoScolastico;
    }

    public void setAnnoScolastico(String annoScolastico) {
        this.annoScolastico = annoScolastico;
    }

    public String getClassi() {
        return classi;
    }

    public void setClassi(String classi) {
        this.classi = classi;
    }

    public String getCorrente() {
        return corrente;
    }
	
	@Override
	public String toString() {
	    return id + ", " + annoScolastico + ", " + classi + ", " + corrente;
	}

    
    
    
    
}
