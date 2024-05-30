package blasi.nicolo.pcto.bean;

import java.util.Arrays;

public class Documento {

    private int id;
    private int[] documento;
    private int idStudente;
    private int idTipoDocumento;

    public Documento(int id, int[] documento, int idStudente, int idTipoDocumento) {
        this.id = id;
        this.documento = documento;
        this.idStudente = idStudente;
        this.idTipoDocumento = idTipoDocumento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int[] getDocumento() {
        return documento;
    }

    public void setDocumento(int[] documento) {
        this.documento = documento;
    }

    public int getIdStudente() {
        return idStudente;
    }

    public void setIdStudente(int idStudente) {
        this.idStudente = idStudente;
    }

    public int getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(int idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    @Override
    public String toString() {
        return id + ", " + Arrays.toString(documento) + ", " + idStudente + ", " + idTipoDocumento;
    }

    
    
}
