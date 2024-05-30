package blasi.nicolo.pcto.bean;
public class StudenteXAttivita {
    private int id;
    private int idProgettoFormativo;
    private int idStudente;

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdProgettoFormativo() {
        return idProgettoFormativo;
    }

    public void setIdProgettoFormativo(int idProgettoFormativo) {
        this.idProgettoFormativo = idProgettoFormativo;
    }

    public int getIdStudente() {
        return idStudente;
    }

    public void setIdStudente(int idStudente) {
        this.idStudente = idStudente;
    }


    public StudenteXAttivita() {
    }

    public StudenteXAttivita(int id, int idProgettoFormativo, int idStudente) {
        this.id = id;
        this.idProgettoFormativo = idProgettoFormativo;
        this.idStudente = idStudente;
    }

  
    @Override
    public String toString() {
        return id + ", " + idProgettoFormativo + ", " + idStudente;
    }

}
