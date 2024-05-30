package blasi.nicolo.pcto.business.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import blasi.nicolo.pcto.bean.Login;
import volta.ts.it.ProggettoPCTO.util.DBUtil;


public class DaoLogin {
    private static final String INSERT = "INSERT INTO login (nome, cognome, username, password) VALUES (?, ?, ?, ?)";
    private static final String GET_BY_ID = "x, nome, cognome, username, password FROM login WHERE id = ?";
    private static final String GET_ALL = "SELECT id, nome, cognome, username, password FROM login";
    private static final String UPDATE = "UPDATE login SET nome = ?, cognome = ?, username = ?, password = ? WHERE id = ?";
    private static final String DELETE = "DELETE FROM login WHERE id = ?";
    private static final String SEARCH_BY_CREDENTIALS = 
            "SELECT id FROM login WHERE username = ? AND password = ?";

    public int searchByCredentials(Connection conn, String username, String password) throws SQLException {
        int result = -1; // Default value if no match is found

        try (PreparedStatement stmt = conn.prepareStatement(SEARCH_BY_CREDENTIALS)) {
            stmt.setString(1, username);
            stmt.setString(2, password);

            try (ResultSet rset = stmt.executeQuery()) {
                if (rset.next()) {
                    result = rset.getInt("id");
                }
            }
        }

        return result;
    }

    // Create
    public int insert(Connection conn, String nome, String cognome, String username, String password) throws SQLException {
    	int result = 0;
        PreparedStatement stmt = null;
        ResultSet         rset = null;

        try {
            stmt = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, nome    );
            stmt.setString(2, cognome );
            stmt.setString(3, username);
            stmt.setString(4, password    );
            
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

    // Read by ID
    public Login getById(Connection conn, int id) throws SQLException {
        Login result = null;
        try (PreparedStatement stmt = conn.prepareStatement(GET_BY_ID)) {
            stmt.setInt(1, id);

            try (ResultSet rset = stmt.executeQuery()) {
                if (rset.next()) {
                    String nome = rset.getString("nome");
                    String cognome = rset.getString("cognome");
                    String username = rset.getString("username");
                    String password = rset.getString("password");

                    result = new Login(id, nome, cognome, username, password);
                }
            }
        }
        return result;
    }

    // Read all
    public List<Login> getAll(Connection conn) throws SQLException {
        List<Login> list = new ArrayList<>();
        try (PreparedStatement stmt = conn.prepareStatement(GET_ALL);
             ResultSet rset = stmt.executeQuery()) {

            while (rset.next()) {
                int id = rset.getInt("id");
                String nome = rset.getString("nome");
                String cognome = rset.getString("cognome");
                String username = rset.getString("username");
                String password = rset.getString("password");

                list.add(new Login(id, nome, cognome, username, password));
            }
        }
        return list;
    }

    // Update
    public int  update(Connection conn, Login login) throws SQLException {
    	
    	int result = 0;
    	
        try (PreparedStatement stmt = conn.prepareStatement(UPDATE)) {
            stmt.setString(1, login.getNome());
            stmt.setString(2, login.getCognome());
            stmt.setString(3, login.getUsername());
            stmt.setString(4, login.getPassword());
            stmt.setInt(5, login.getId());
            result = stmt.executeUpdate();
        }
        
        return result;
    }

    // Delete
    public void delete(Connection conn, int id) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(DELETE)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}

