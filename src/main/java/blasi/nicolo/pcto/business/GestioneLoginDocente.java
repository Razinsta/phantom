package blasi.nicolo.pcto.business;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import blasi.nicolo.pcto.bean.TutorScolastico;
import blasi.nicolo.pcto.business.dao.DaoTutorScolastico;
import volta.ts.it.ProggettoPCTO.util.MySQLUtil;

public class GestioneLoginDocente {
	
	DaoTutorScolastico gestione;
	
	public GestioneLoginDocente() {
		gestione = new DaoTutorScolastico();
	}

	public int search(String username, String password) {
		int result = -1;   
		Connection conn   = null;
		
		try {
			conn   = MySQLUtil.connect();
			result = gestione.searchByCredentials(conn, username, password);
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySQLUtil.disconnect(conn);
		}
		
		return result;
	}	
	
	public List<TutorScolastico> getAll() {
		List<TutorScolastico> list = null;
		Connection conn = null;
		try {
			conn = MySQLUtil.connect();
			list = gestione.getAll(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySQLUtil.disconnect(conn);
		}
		return list;
	}
	
	public TutorScolastico getById(int id) {
		TutorScolastico result = null;
		Connection conn = null;

		try {
			conn  = MySQLUtil.connect();
			result = gestione.getById(conn,id);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySQLUtil.disconnect(conn);
		}

		return result;
	}
	
	  public int update(TutorScolastico tutor) {
	        int rowsAffected = 0;
	        Connection conn = null;

	        try {
	            conn = MySQLUtil.connect();
	            rowsAffected = gestione.update(conn,tutor);

	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            MySQLUtil.disconnect(conn);
	        }

	        return rowsAffected; 
	    }
	  

	
}
