package blasi.nicolo.pcto.bean;
public class StudenteXArgomenti {
    private int id;
    private int idArgomento;
    private int idStudente;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdArgomento() {
        return idArgomento;
    }

    public void setIdArgomento(int idArgomento) {
        this.idArgomento = idArgomento;
    }

    public int getIdStudente() {
        return idStudente;
    }

    public void setIdStudente(int idStudente) {
        this.idStudente = idStudente;
    }

   
    public StudenteXArgomenti() {
    }

    public StudenteXArgomenti(int id, int idArgomento, int idStudente) {
        this.id = id;
        this.idArgomento = idArgomento;
        this.idStudente = idStudente;
    }

    @Override
    public String toString() {
        return id + ", " + idArgomento + ", " + idStudente;
    }

}
