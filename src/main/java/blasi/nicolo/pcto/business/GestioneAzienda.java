package blasi.nicolo.pcto.business;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import blasi.nicolo.pcto.bean.Azienda;
import blasi.nicolo.pcto.business.dao.DaoAzienda;
import volta.ts.it.ProggettoPCTO.util.MySQLUtil;

public class GestioneAzienda
{
	private DaoAzienda daoAzienda;
	
	public GestioneAzienda()
	{
		daoAzienda = new DaoAzienda();
	}
	
	
	public Azienda getById(int id)
	{
		Azienda   result = null;   
		Connection conn   = null;
		
		try {
			conn   = MySQLUtil.connect();
			result = daoAzienda.getById(conn, id);
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySQLUtil.disconnect(conn);
		}
		
		return result;
	}	
	
	
	public List<Azienda> getAll()
	{
		List<Azienda> list = null;   
		Connection     conn = null;
		
		try {
			conn = MySQLUtil.connect();
			list = daoAzienda.getAll(conn);
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySQLUtil.disconnect(conn);
		}

		return list;
	}
	
	public int insert(String ragioneSociale, String pIVA, String sedeLegale, String topic, String note, String statoConvenzione, String nConvenzione){   
        Connection     conn = null;
        int id = 0;
        Azienda azienda = new Azienda(0, ragioneSociale, pIVA, sedeLegale, topic, note, statoConvenzione, nConvenzione);
        try {
            conn = MySQLUtil.connect();
             id = daoAzienda.insert(conn, azienda);  

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MySQLUtil.disconnect(conn);
        }
        return id;
    }

     // Metodo per ottenere RagioneSociale
    public String getRagioneSociale(int id){
        Azienda azienda = getById(id);
        return azienda.getRagioneSociale();
    }
        // Metodo per ottenere pIVA
        public String getPIVA(int id) {
            Azienda azienda = getById(id);
            return azienda.getpIVA();
        }
    
        // Metodo per ottenere sedeLegale
        public String getSedeLegale(int id) {
            Azienda azienda = getById(id);
            return azienda.getSedeLegale();
        }
    
        // Metodo per ottenere topic
        public String getTopic(int id) {
            Azienda azienda = getById(id);
            return azienda.getTopic();
        }
    
        // Metodo per ottenere note
        public String getNote(int id) {
            Azienda azienda = getById(id);
            return azienda.getNote();
        }
    
        // Metodo per ottenere statoConvenzione
        public String getStatoConvenzione(int id) {
            Azienda azienda = getById(id);
            return azienda.getStatoConvenzione();
        }
    
        // Metodo per ottenere nConvenzione
        public String getNConvenzione(int id) {
            Azienda azienda = getById(id);
            return azienda.getnConvenzione();
        }
    
        // Metodo per ottenere DVR
        public int getDVR(int id) {
            Azienda azienda = getById(id);
            return azienda.getIdDvr();
        }
    
        //Metodo per ottenere un toString della azienda
        public List<String> getAllDateFromAgency(int id){
            List<String> list = new ArrayList<>();
            list.add(getRagioneSociale(id));
            list.add(getPIVA(id));
            list.add(getSedeLegale(id));
            list.add(getTopic(id));
            list.add(getNote(id));
            list.add(getStatoConvenzione(id));
            list.add("" + getNConvenzione(id));
            list.add("" + getDVR(id));
            return list;
        }
    

}
