package blasi.nicolo.pcto.bean;
public class TutorScolastico {
    private int id;
    private String classe;
    private String docente;
    private String descrizione;
    private String password;
    private int idPcto;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getDocente() {
        return docente;
    }

    public void setDocente(String docente) {
        this.docente = docente;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public int getIdPcto() {
        return idPcto;
    }

    public void setIdPcto(int idPcto) {
        this.idPcto = idPcto;
    }

    public TutorScolastico() {
    }

    public TutorScolastico(int id, String classe, String docente, String descrizione, int idPcto) {        
        this(id, classe, docente, descrizione, null, idPcto);
    }

    public TutorScolastico(int id, String classe, String docente, String descrizione,String password, int idPcto) {
        this.id = id;
        this.classe = classe;
        this.docente = docente;
        this.descrizione = descrizione;
        this.idPcto = idPcto;
        this.password = password;
    }

    @Override
    public String toString() {
        return id + ", " + classe + ", " + docente + ", " + descrizione + ", " +password+ idPcto + ", " ;
    }



  
   
}
