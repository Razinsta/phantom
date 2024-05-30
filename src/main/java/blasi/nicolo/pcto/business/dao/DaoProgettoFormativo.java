package blasi.nicolo.pcto.business.dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import blasi.nicolo.pcto.bean.ProgettoFormativo;
import volta.ts.it.ProggettoPCTO.util.DBUtil;


public class DaoProgettoFormativo {
	private static final String GET_BY_ID = "SELECT id descrizioneAttivita dataProgetto idTutorScolastico idTutorAziendale idStudente"
										  + "		idPctoXAzienda idSedeTirocinio"
										  + "FROM ProgettoFormativo"
										  + "WHERE id = ?";
	private static final String GET_ALL   = "SELECT id descrizioneAttivita dataProgetto idTutorScolastico idTutorAziendale idStudente"
										  + "		idPctoXAzienda idSedeTirocinio"
									      + "FROM ProgettoFormativo";	
	
    private static final String INSERT = "INSERT INTO Progett (ragioneSociale, pIVA, sedeLegale, topic, note, statoConvenzione, nConvenzione, idDVR) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

	//--------------------------------------------------------------------------------------------
	/**
	 * Lettura di un'azienda dato l'id
	 * @param conn la connessione al db
	 * @param id   l'id dell'azienda da cercare
	 * @return ProgettoFormativo dell'azienda da cercare
	 */
	//--------------------------------------------------------------------------------------------

	public ProgettoFormativo getById(Connection conn, int id)
	{
		ProgettoFormativo result = null;		
		PreparedStatement stmt   = null;
		ResultSet         rset   = null;

		try {
			stmt = conn.prepareStatement(GET_BY_ID);
			stmt.setInt(1, id);
			
			rset = stmt.executeQuery();
			
			if (rset != null)
			{
				if (rset.next())
				{
					String descrizioneAttivita = DBUtil.getString(rset, "descrizioneAttivita");
					String dataProgetto     = DBUtil.getString(rset, "dataProgetto"    );
					int idTutorScolastico     = DBUtil.getInt(rset, "idTutorScolastico"    );
					int idTutorAziendale     = DBUtil.getInt(rset, "idTutorAziendale"    );
					int idStudente     = DBUtil.getInt(rset, "idStudente"    );
					int idPctoXAzienda     = DBUtil.getInt(rset, "idPctoXAzienda"    );
					int idSedeTirocinio     = DBUtil.getInt(rset, "idSedeTirocinio"    );
					
					result = new ProgettoFormativo(id, descrizioneAttivita, dataProgetto, idTutorScolastico, idTutorAziendale, idStudente, idPctoXAzienda, idSedeTirocinio);
				}
			}
		
		} catch ( SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(stmt, rset);		
		}
		
		return result;	
	}	
	//--------------------------------------------------------------------------------------------
	/**
	 * Lista di tutte le aziende in db
	 * @param conn           la connessione al db
	 * @return List<ProgettoFormativo> con l'elenco di tutte le aziende
	 */
	//--------------------------------------------------------------------------------------------
	
	public List<ProgettoFormativo> getAll(Connection conn)
	{
		List<ProgettoFormativo>    list = null;		
		PreparedStatement stmt = null;
		ResultSet         rset = null;

		try {
			stmt = conn.prepareStatement(GET_ALL);
			
			rset = stmt.executeQuery();
			
			if (rset != null)
			{
				list = new ArrayList<>();
				
				while (rset.next())
				{
					int    id             			= DBUtil.getInt   (rset, "id");
					String descrizioneAttivita      = DBUtil.getString   (rset, "descrizione");
					String dataProgetto             = DBUtil.getString  (rset, "dataProgetto");
					int idTutorScolastico           = DBUtil.getInt   (rset, "idTutorScolastico");
					int idTutorAziendale            = DBUtil.getInt   (rset, "idTutorAziendale");
					int idStudente             		= DBUtil.getInt   (rset, "idStudente");
					int idPctoXAzienda             	= DBUtil.getInt   (rset, "idPctoXAzienda");
					int idSedeTirocinio             = DBUtil.getInt   (rset, "idSedeTirocinio");
					
					list.add( new ProgettoFormativo(id, descrizioneAttivita, dataProgetto, idTutorScolastico, idTutorAziendale, idStudente, idPctoXAzienda, idSedeTirocinio));
				}
			}
		
		} catch ( SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(stmt, rset);		
		}
		
		return list;	
	}
	
    public void insert(Connection conn, ProgettoFormativo progettoFormativo) throws SQLException {
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, progettoFormativo.getDescrizioneAttivita());
            // ... (set other parameters based on ProgettoFormativo fields)

            stmt.executeUpdate();

            // Optionally retrieve the generated ID (if auto-increment is used)
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    progettoFormativo.setId(generatedKeys.getInt(1));
                }
            }
        } finally {
            DBUtil.close(stmt);
        }
    }

}
