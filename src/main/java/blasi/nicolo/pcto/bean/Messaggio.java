package blasi.nicolo.pcto.bean;
public class Messaggio {
    
    private int id;
    private int idTutorDA;
    private int intidTutorA;
    private String messaggio;
    
    public Messaggio(int id, int idTutorDA, int intidTutorA, String messaggio) {
        super();
        this.id = id;
        this.idTutorDA = idTutorDA;
        this.intidTutorA = intidTutorA;
        this.messaggio = messaggio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdTutorDA() {
        return idTutorDA;
    }

    public void setIdTutorDA(int idTutorDA) {
        this.idTutorDA = idTutorDA;
    }

    public int getIntidTutorA() {
        return intidTutorA;
    }

    public void setIntidTutorA(int intidTutorA) {
        this.intidTutorA = intidTutorA;
    }

    public String getMessaggio() {
        return messaggio;
    }

    public void setMessaggio(String messaggio) {
        this.messaggio = messaggio;
    }

    @Override
    public String toString() {
        return id + ", " + idTutorDA + ", " + intidTutorA + ", " + messaggio;
    }

    
    
    

}
