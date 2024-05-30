package blasi.nicolo.pcto.business;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import blasi.nicolo.pcto.bean.Azienda;
import blasi.nicolo.pcto.bean.ProgettoFormativo;
import blasi.nicolo.pcto.business.dao.DaoProgettoFormativo;
import volta.ts.it.ProggettoPCTO.util.MySQLUtil;

public class GestioneProgettoFormativo {
	
	private DaoProgettoFormativo daoProgettoFormativo;
	
	public GestioneProgettoFormativo() 
	{
		daoProgettoFormativo = new DaoProgettoFormativo();
	}
	
	public ProgettoFormativo getById(int id)
	{
		ProgettoFormativo   result = null;   
		Connection conn   = null;
		
		try {
			conn   = MySQLUtil.connect();
			result = daoProgettoFormativo.getById(conn, id);
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySQLUtil.disconnect(conn);
		}
		
		return result;
	}	

	
	public List<ProgettoFormativo> getAll()
	{
		List<ProgettoFormativo> list = null;   
		Connection     conn = null;
		
		try {
			conn = MySQLUtil.connect();
			list = daoProgettoFormativo.getAll(conn);
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySQLUtil.disconnect(conn);
		}

		return list;
	}
	
	public void insert(int id, String descrizioneAttivita, String dataProgetto, 
            int idTutorScolastico, int idTutorAziendale, int idStudente, 
            int idPctoXAzienda, int idSedeTirocinio){  
		
        Connection     conn = null;
        ProgettoFormativo progetto = new ProgettoFormativo(23, "11/9", "11/9", 4, 3, 6, 7, 6);
        try {
            conn = MySQLUtil.connect();
            daoProgettoFormativo.insert(conn, progetto);  

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MySQLUtil.disconnect(conn);
        }
    }

	

}
