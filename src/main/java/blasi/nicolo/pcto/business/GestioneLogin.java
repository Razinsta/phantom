package blasi.nicolo.pcto.business;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import blasi.nicolo.pcto.bean.Login;
import blasi.nicolo.pcto.bean.Studente;
import blasi.nicolo.pcto.business.dao.DaoLogin;
import volta.ts.it.ProggettoPCTO.util.MySQLUtil;

public class GestioneLogin {
	
	private DaoLogin daoLogin;
	private List<String> listaCSVstudenti;
	
	public GestioneLogin() {
		daoLogin = new DaoLogin();
	}

	public int search(String username, String password)
	{
		int result = -1;   
		Connection conn   = null;
		
		try {
			conn   = MySQLUtil.connect();
			result = daoLogin.searchByCredentials(conn, username, password);
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySQLUtil.disconnect(conn);
		}
		
		return result;
	}	
	
	public List<Login> getAll() {
		List<Login> list = null;
		Connection conn = null;
		try {
			conn = MySQLUtil.connect();
			list = daoLogin.getAll(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySQLUtil.disconnect(conn);
		}
		return list;
	}
	
	public Login getById(int id)
	{
		Login result = null;
		Connection conn = null;

		try {
			conn  = MySQLUtil.connect();
			result = daoLogin.getById(conn, id);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySQLUtil.disconnect(conn);
		}

		return result;
	}
	
	  public int update(Login login) {
	        int rowsAffected = 0;
	        Connection conn = null;

	        try {
	            conn = MySQLUtil.connect();
	            rowsAffected = daoLogin.update(conn, login);

	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            MySQLUtil.disconnect(conn);
	        }

	        return rowsAffected; 
	    }
	  
	  public void insertCSV(){ 
			listaCSVstudenti = BizFile.readTextFile("studenti.csv");
			
			for(String s: listaCSVstudenti) {
				
				String[] s2 = s.split(";");
				insert(s2[0], s2[1], s2[3], s2[4]);
			}
		}
	  
	  public void insert(String nome, String cognome, String username, String password){ 
			Connection conn = null;
			try {
				conn = MySQLUtil.connect();
				daoLogin.insert(conn, nome, cognome, username, password);


			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				MySQLUtil.disconnect(conn);
			}
		}
	  

	
}
