package blasi.nicolo.pcto.business.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import blasi.nicolo.pcto.bean.TutorScolastico;


public class DaoTutorScolastico {
    private static final String INSERT = "INSERT INTO tutorscolastico (classe, docente, descrizione, idPcto) VALUES (?, ?, ?, ?)";
    private static final String GET_BY_ID = "SELECT id, classe, docente, descrizione, idPcto FROM tutorscolastico WHERE id = ?";
    private static final String GET_ALL = "SELECT id, classe, docente, descrizione, idPcto FROM tutorscolastico";
    private static final String UPDATE = "UPDATE tutorscolastico SET classe = ?, docente = ?, descrizione = ?, idPcto = ? WHERE id = ?";
    private static final String DELETE = "DELETE FROM tutorscolastico WHERE id = ?";   
    private static final String SEARCH_BY_CREDENTIALS = "SELECT id FROM tutorscolastico WHERE LOWER(REPLACE(docente, ' ' , '' )) = ? AND password = ?";

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
    public void insert(Connection conn, TutorScolastico tutor) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, tutor.getClasse());
            stmt.setString(2, tutor.getDocente());
            stmt.setString(3, tutor.getDescrizione());
            stmt.setInt(4, tutor.getIdPcto());
            stmt.executeUpdate();

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    tutor.setId(generatedKeys.getInt(1));
                }
            }
        }
    }

    // Read by ID
    public TutorScolastico getById(Connection conn, int id) throws SQLException {
        TutorScolastico result = null;
        try (PreparedStatement stmt = conn.prepareStatement(GET_BY_ID)) {
            stmt.setInt(1, id);

            try (ResultSet rset = stmt.executeQuery()) {
                if (rset.next()) {
                    String classe = rset.getString("classe");
                    String docente = rset.getString("docente");
                    String descrizione = rset.getString("descrizione");
                    int idPcto = rset.getInt("idPcto");

                    result = new TutorScolastico(id, classe, docente, descrizione, idPcto);
                }
            }
        }
        return result;
    }

    // Read all
    public List<TutorScolastico> getAll(Connection conn) throws SQLException {
        List<TutorScolastico> list = new ArrayList<>();
        try (PreparedStatement stmt = conn.prepareStatement(GET_ALL);
             ResultSet rset = stmt.executeQuery()) {

            while (rset.next()) {
                int id = rset.getInt("id");
                String classe = rset.getString("classe");
                String docente = rset.getString("docente");
                String descrizione = rset.getString("descrizione");
                int idPcto = rset.getInt("idPcto");

                list.add(new TutorScolastico(id, classe, docente, descrizione, idPcto));
            }
        }
        return list;
    }

    // Update
    public int update(Connection conn, TutorScolastico tutor) throws SQLException {
        int result = 0;
        
        try (PreparedStatement stmt = conn.prepareStatement(UPDATE)) {
            stmt.setString(1, tutor.getClasse());
            stmt.setString(2, tutor.getDocente());
            stmt.setString(3, tutor.getDescrizione());
            stmt.setInt(4, tutor.getIdPcto());
            stmt.setInt(5, tutor.getId());
            result = stmt.executeUpdate();
        }
        
        return result;
    }

    // Delete
    public void delete(Connection conn, int id) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(DELETE)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            "Fabio Rongione".toLowerCase().replace(" ", "");
        }
    }
}