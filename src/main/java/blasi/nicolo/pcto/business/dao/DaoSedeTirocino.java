package blasi.nicolo.pcto.business.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import blasi.nicolo.pcto.bean.SedeTirocinio;
import volta.ts.it.ProggettoPCTO.util.DBUtil;
import blasi.nicolo.pcto.bean.Studente;
public class DaoSedeTirocino {

    private static final String GET_BY_ID = "SELECT id, sedetirocinio, oariolavoro, giornatepcto, idazienda"
										  + "  FROM sedetirocinio"
										  + " WHERE id = ?";
	private static final String GET_ALL   = "SELECT id, sedetirocinio, oariolavoro, giornatepcto, idazienda"
									      + "  FROM sedetirocinio";
	private static final String INSERT    = "INSERT INTO sedetirocinio"
			                              + "       (sedetirocinio, oariolavoro, giornatepcto, idazienda)"
			                              + " VALUES"
			                              + "       (?,?,?,?)";

    public List<SedeTirocinio> getAll(Connection conn)
    {
        List<SedeTirocinio> list = null;		
        PreparedStatement stmt = null;
        ResultSet rset = null;

        try {
            stmt = conn.prepareStatement(GET_ALL);
            
            rset = stmt.executeQuery();
            
            if (rset != null)
            {
                list = new ArrayList<>();
                
                while (rset.next())
                {
                    int id = rset.getInt("id");
                    String sedetirocinio = rset.getString("sedetirocinio");
                    String oariolavoro = rset.getString("oariolavoro");
                    String giornatepcto = rset.getString("giornatepcto");
                    int idazienda = rset.getInt("idazienda");

                    list.add( new SedeTirocinio(id, sedetirocinio, oariolavoro, giornatepcto, idazienda) );
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

    public SedeTirocinio getById(Connection conn, int id)
	{
		SedeTirocinio     result = null;		
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
					String sedetirocinio = rset.getString("sedetirocinio");
                    String oariolavoro = rset.getString("oariolavoro");
                    String giornatepcto = rset.getString("giornatepcto");
                    int idazienda = rset.getInt("idazienda");
					
					result = new SedeTirocinio(id, sedetirocinio, oariolavoro, giornatepcto, idazienda);
				}
			}
		
		} catch ( SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(stmt, rset);		
		}
		
		return result;	
	}

    public int insert(Connection conn, String sedetirocinio, String oariolavoro, String giornatepcto, int idazienda)
	{
		int result = 0;
		PreparedStatement stmt = null;
		ResultSet         rset = null;

		try {
			stmt = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, sedetirocinio);
			stmt.setString(2, oariolavoro);
            stmt.setString(3, giornatepcto);
			stmt.setInt(4, idazienda);
		
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
}
