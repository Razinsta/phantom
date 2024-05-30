package blasi.nicolo.pcto.business;
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
											+ "       (comunenascita, datanascita, comuneresidenza, indirizzoresidenza, pei, idpcto)"
											+ "       VALUES"
											+ "       (?,?,?,?,?,?,?,?,?,?)";
											
	private static final String INSERT_ComuneNascita    = "INSERT INTO studente"
			+ "       (comunenascita)"
			+ "       VALUES"
			+ "       (?)";
	
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

	public int insert(Connection conn,int id, String nome, String cognome, String classe, String comuneNascita, String data, String comuneResidenza, String indirizzoResidenza, String pei, int idPcto)
    {
        int result = 0;
        PreparedStatement stmt = null;
        ResultSet         rset = null;

        try {
            stmt = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1,id);
            stmt.setString(2, nome);
            stmt.setString(3, cognome    );
            stmt.setString(4, classe);
            stmt.setString(5, comuneNascita    );
            stmt.setString(6, data);
            stmt.setString(7, comuneResidenza    );
            stmt.setString(8, indirizzoResidenza);
            stmt.setString(9, pei);
            stmt.setInt(10, idPcto    );
        
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

   


