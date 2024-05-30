package blasi.nicolo.pcto.business;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import blasi.nicolo.pcto.bean.Studente;
import blasi.nicolo.pcto.business.dao.DaoStudente;
import volta.ts.it.ProggettoPCTO.util.MySQLUtil;

public class GestioneStudente {
	
	private DaoStudente daoStudente;
	private List<String> listaCSVstudenti;
	
	public GestioneStudente() {
		daoStudente = new DaoStudente();
	}
	
	public List<Studente> getAll() {
		List<Studente> list = null;
		Connection conn = null;
		try {
			conn = MySQLUtil.connect();
			list = daoStudente.getAll(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySQLUtil.disconnect(conn);
		}
		return list;
	}
	
	public Studente getById(int id)
	{
		Studente result = null;
		Connection conn = null;

		try {
			conn  = MySQLUtil.connect();
			result = daoStudente.getById(conn, id);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySQLUtil.disconnect(conn);
		}

		return result;
	}
	
	  public int update(Studente studente) {
	        int rowsAffected = 0;
	        Connection conn = null;

	        try {
	            conn = MySQLUtil.connect();
	            rowsAffected = daoStudente.update(conn, studente);

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
				insert(s2[0], s2[1], s2[2],"", "", "", "", "",1);
			}
		}
	  
	public void insert(String nome, String cognome, String classe, String comuneNascita, String dataNascita, String comuneResidenza, String indirizzoResidenza, String pei,int idpcto){ 
		Connection conn = null;
		try {
			conn = MySQLUtil.connect();
			daoStudente.insert(conn, nome, cognome, classe, comuneNascita, dataNascita, comuneResidenza, indirizzoResidenza, pei,idpcto);


		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySQLUtil.disconnect(conn);
		}
	}

	public String getCognome(int id) {
		Studente studente = getById(id);
		return studente.getCognome();
	}
	// Metodo per ottenere RagioneSociale
	public String getName(int id){
		Studente studente = getById(id);
		return studente.getNome();
	}
	
    public void caricaAllegato(String path, int idStudente, int idTipoDocumento) {
        Connection conn = null;
        PreparedStatement stmt = null;

        File pdfFile = new File(path);
        try {
            FileInputStream fis = new FileInputStream(pdfFile);
            conn = MySQLUtil.connect();
            stmt = conn.prepareStatement("INSERT INTO documento(documento, idStudente, idtipodocumento) VALUES (?,?,?)");
            //stmt.setInt(1, id);
            stmt.setBlob(1, fis);
            stmt.setInt(2, idStudente);
            stmt.setInt(3, idTipoDocumento);
            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                MySQLUtil.disconnect(conn);
            }
        }
    }

    public void prendiAllegato(int idStudente, String tipodocumento, String path) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = MySQLUtil.connect();
            stmt = conn.prepareStatement("SELECT documento FROM documento WHERE idstudente = ?");
            stmt.setInt(1, idStudente);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Blob blob = rs.getBlob("documento");
                byte[] byteArray = blob.getBytes(1, (int) blob.length());
                stmt = conn.prepareStatement("SELECT nome, cognome FROM studente WHERE id = ?");
                stmt.setInt(1, idStudente);
                ResultSet rs2 = stmt.executeQuery();
                String nome = "";
                String cognome = "";
                if (rs2.next()) {
                    nome = rs2.getString("nome");
                    cognome = rs2.getString("cognome");
                }
                FileOutputStream fos = new FileOutputStream(path + File.separator + nome + "." + cognome + "." + tipodocumento + ".pdf");
                fos.write(byteArray);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                MySQLUtil.disconnect(conn);
            }
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                MySQLUtil.disconnect(conn);
            }
        }
    }
	
}


