package blasi.nicolo.pcto.business;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import blasi.nicolo.pcto.bean.TutorScolastico;
import blasi.nicolo.pcto.business.dao.DaoTutorScolastico;
import volta.ts.it.ProggettoPCTO.util.MySQLUtil;

public class GestioneTutorScolastico {
	
	
	private DaoTutorScolastico dao;
	
	public GestioneTutorScolastico() {
		dao = new DaoTutorScolastico();
	}

	
	public List<TutorScolastico> getAll() {
		List<TutorScolastico> list = null;
		Connection conn = null;
		try {
			conn = MySQLUtil.connect();
			list = dao.getAll(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySQLUtil.disconnect(conn);
		}
		return list;
	}
	
	public TutorScolastico getById(int id)
	{
		TutorScolastico result = null;
		Connection conn = null;

		try {
			conn  = MySQLUtil.connect();
			result = dao.getById(conn, id);

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
	            rowsAffected = dao.update(conn, tutor);

	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            MySQLUtil.disconnect(conn);
	        }

	        return rowsAffected; 
	    }
	  
}

