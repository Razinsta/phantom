package blasi.nicolo.pcto.bean;

public class TutorAziendale {
    
    private int id;
    private String titolo;
    private String nome;
    private String cognome;
    private String descrizione;
    private int idAzienda;
    
    public TutorAziendale(int id, String titolo, String nome, String cognome, String descrizione, int idAzienda) {
        super();
        this.id = id;
        this.titolo = titolo;
        this.nome = nome;
        this.cognome = cognome;
        this.descrizione = descrizione;
        this.idAzienda = idAzienda;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public int getIdAzienda() {
        return idAzienda;
    }

    public void setIdAzienda(int idAzienda) {
        this.idAzienda = idAzienda;
    }

    @Override
    public String toString() {
        return id + ", " + titolo + ", " + nome + ", " + cognome + ", " + descrizione + ", " + idAzienda;
    }

    
    

}

