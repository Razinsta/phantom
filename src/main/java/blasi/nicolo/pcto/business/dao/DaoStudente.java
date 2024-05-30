package blasi.nicolo.pcto.business.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import blasi.nicolo.pcto.bean.Studente;
import volta.ts.it.ProggettoPCTO.util.DBUtil;


public class DaoStudente {

	private static final String GET_BY_ID = "SELECT nome, cognome, classe, comunenascita, datanascita, comuneresidenza, indirizzoresidenza, pei, idpcto"
											+ "  FROM studente"
											+ " WHERE id = ?";

	private static final String GET_ALL   = "SELECT id, nome, cognome, classe, comunenascita, datanascita, comuneresidenza, indirizzoresidenza, pei, idpcto"
											+ "  FROM studente";

	private static final String INSERT    = "INSERT INTO studente"
											+ "       (nome, cognome, classe, comunenascita, datanascita, comuneresidenza, indirizzoresidenza, pei, idpcto)"
											+ "       VALUES"
											+ "       (?,?,?,?,?,?,?,?,?)";
	
	private static final String UPDATE = "UPDATE studente SET comunenascita=?, datanascita=?, comuneresidenza=?, indirizzoresidenza=?, pei=?  WHERE id=?";
	
	public int update(Connection conn, Studente studente) {
        int result = 0;
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(UPDATE);
            stmt.setString(1, studente.getComuneNascita());
            stmt.setString(2, studente.getDataNascita()); 
            stmt.setString(3, studente.getComuneResidenza());
            stmt.setString(4, studente.getIndirizzoResidenza());
            stmt.setString(5, studente.getPei());
            stmt.setInt(6, studente.getId());

            result = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(stmt);
        }

        return result; // Returns the number of rows affected (should be 1 for successful update)
    }
	
    public List<Studente> getAll(Connection conn)
    {
        List<Studente>    list = null;      
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
                    int    id                   = DBUtil.getInt(rset,"id"    );
                    String nome                 = DBUtil.getString(rset,"nome"     );
                    String cognome              = DBUtil.getString(rset,"cognome"  );
                    String classe               = DBUtil.getString(rset,"classe"   );
                    String comuneNascita        = DBUtil.getString(rset,"comunenascita");
                    String   data                 = DBUtil.getString(rset,"datanascita");
                    String comuneResidenza      = DBUtil.getString(rset,"comuneresidenza");
                    String indirizzoResidenza   = DBUtil.getString(rset,"indirizzoresidenza");
                    String pei                  = DBUtil.getString(rset,"pei");
                    int idPcto                  = DBUtil.getInt   (rset,"idpcto");

                    list.add( new Studente(id, nome, cognome, classe, comuneNascita, data, comuneResidenza, indirizzoResidenza, pei, idPcto) );
                }
            }
        
        } catch ( SQLException e) {
            e.printStackTrace();
        } finally {
            if (rset != null) try { rset.close(); } catch (SQLException e) {}
            if (stmt != null) try { stmt.close(); } catch (SQLException e) {}
        }
        
        return list;    
    }

	public int insert(Connection conn, String nome, String cognome, String classe, String comuneNascita, String data, String comuneResidenza, String indirizzoResidenza, String pei,int idpcto)
    {
        int result = 0;
        PreparedStatement stmt = null;
        ResultSet         rset = null;
        
        

        try {
            stmt = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, nome    );
            stmt.setString(2, cognome );
            stmt.setString(3, classe);
            stmt.setString(4, comuneNascita    );
            stmt.setString(5, data);
            stmt.setString(6, comuneResidenza    );
            stmt.setString(7, indirizzoResidenza);
            stmt.setString(8, pei);
            stmt.setInt(9, idpcto);
            
            int affected = stmt.executeUpdate();            
            if (affected == 1)
            {
                rset = stmt.getGeneratedKeys();
                if (rset.next())
                    result = DBUtil.getInt(rset, "id");
            }
                    
        } catch ( SQLException e) {
            e.printStackTrace();
            result = -1;
        } finally {
            DBUtil.close(stmt, rset);       
        }
            
        return result;
    }

    public Studente getById(Connection conn, int id)
    {
        Studente          result = null;        
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
                    String nome                 = DBUtil.getString(rset,"nome"     );
                    String cognome              = DBUtil.getString(rset,"cognome"  );
                    String classe               = DBUtil.getString(rset,"classe"   );
                    String comuneNascita        = DBUtil.getString(rset,"comunenascita");
                    String   data                 = DBUtil.getString(rset,"datanascita");
                    String comuneResidenza      = DBUtil.getString(rset,"comuneresidenza");
                    String indirizzoResidenza   = DBUtil.getString(rset,"indirizzoresidenza");
                    String pei                  = DBUtil.getString(rset,"pei");
                    int idPcto                  = DBUtil.getInt   (rset,"idpcto");

                    
                    result = new Studente(id, nome, cognome, classe, comuneNascita, data, comuneResidenza, indirizzoResidenza, pei, idPcto);
                }
            }
        
        } catch ( SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(stmt, rset);       
        }
        
        return result;  

	}	

}

   


