package blasi.nicolo.pcto.business.dao;
public class DaoPCTOXAzienda {
    
	
	private static final String GET_BY_ID = "SELECT id, statoAvanzamento, esitoContatto, nStudenti, giaContattata, referenteVolta, idPcto, idAzienda"
    + " FROM PCTOXAzienda"  
    + " INNER JOIN PCTO ON PCTOXAzienda.PCTO_id = PCTO.id"  
    + " INNER JOIN Azienda ON PCTOXAzienda.Azienda_id = Azienda.id"
    + " WHERE id = ?";
}
