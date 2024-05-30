package blasi.nicolo.pcto.bean;

public class Contatto {

   

	private int id;
    private String titolo;
    private String nome;
    private String cognome;
    private String descrizione;
    private String telefono;
    private String cellulare;
    private String mail;
    private int idazienda;

    public Contatto() {
    	
    	
    }

    public Contatto(int id, String titolo, String nome, String cognome, String descrizione, 
                      String telefono, String cellulare, String mail, int idazienda) {
        this.id = id;
        this.titolo = titolo;
        this.nome = nome;
        this.cognome = cognome;
        this.descrizione = descrizione;
        this.telefono = telefono;
        this.cellulare = cellulare;
        this.mail = mail;
        this.idazienda = idazienda;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCellulare() {
        return cellulare;
    }

    public void setCellulare(String cellulare) {
        this.cellulare = cellulare;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getIdazienda() {
        return idazienda;
    }

    public void setIdazienda(int idazienda) {
        this.idazienda = idazienda;
    }
    
    @Override
    public String toString() {
        return id + ", " + titolo + ", " + nome + ", " + cognome + ", " + descrizione + ", " + telefono + ", " + cellulare + ", " + mail + ", " + idazienda;
    }

    
}
