package blasi.nicolo.pcto.business.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import blasi.nicolo.pcto.bean.TutorAziendale;


public class DaoTutorAziendale {
    private static final String INSERT = "INSERT INTO TutorAziendale (titolo, nome, cognome, descrizione, idAzienda) VALUES (?, ?, ?, ?, ?)";
    private static final String GET_BY_ID = "SELECT id, titolo, nome, cognome, descrizione, idAzienda FROM TutorAziendale WHERE id = ?";
    private static final String GET_ALL = "SELECT id, titolo, nome, cognome, descrizione, idAzienda FROM TutorAziendale";
    private static final String UPDATE = "UPDATE TutorAziendale SET titolo = ?, nome = ?, cognome = ?, descrizione = ?, idAzienda = ? WHERE id = ?";
    private static final String DELETE = "DELETE FROM TutorAziendale WHERE id = ?";

    // Create
    public void insert(Connection conn, TutorAziendale tutor) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, tutor.getTitolo());
            stmt.setString(2, tutor.getNome());
            stmt.setString(3, tutor.getCognome());
            stmt.setString(4, tutor.getDescrizione());
            stmt.setInt(5, tutor.getIdAzienda());
            stmt.executeUpdate();

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    tutor.setId(generatedKeys.getInt(1));
                }
            }
        }
    }

    // Read by ID
    public TutorAziendale getById(Connection conn, int id) throws SQLException {
        TutorAziendale result = null;
        try (PreparedStatement stmt = conn.prepareStatement(GET_BY_ID)) {
            stmt.setInt(1, id);

            try (ResultSet rset = stmt.executeQuery()) {
                if (rset.next()) {
                    String titolo = rset.getString("titolo");
                    String nome = rset.getString("nome");
                    String cognome = rset.getString("cognome");
                    String descrizione = rset.getString("descrizione");
                    int idAzienda = rset.getInt("idAzienda");

                    result = new TutorAziendale(id, titolo, nome, cognome, descrizione, idAzienda);
                }
            }
        }
        return result;
    }

    // Read all
    public List<TutorAziendale> getAll(Connection conn) throws SQLException {
        List<TutorAziendale> list = new ArrayList<>();
        try (PreparedStatement stmt = conn.prepareStatement(GET_ALL);
             ResultSet rset = stmt.executeQuery()) {

            while (rset.next()) {
                int id = rset.getInt("id");
                String titolo = rset.getString("titolo");
                String nome = rset.getString("nome");
                String cognome = rset.getString("cognome");
                String descrizione = rset.getString("descrizione");
                int idAzienda = rset.getInt("idAzienda");

                list.add(new TutorAziendale(id, titolo, nome, cognome, descrizione, idAzienda));
            }
        }
        return list;
    }

    // Update
    public void update(Connection conn, TutorAziendale tutor) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(UPDATE)) {
            stmt.setString(1, tutor.getTitolo());
            stmt.setString(2, tutor.getNome());
            stmt.setString(3, tutor.getCognome());
            stmt.setString(4, tutor.getDescrizione());
            stmt.setInt(5, tutor.getIdAzienda());
            stmt.setInt(6, tutor.getId());
            stmt.executeUpdate();
        }
    }

    // Delete
    public void delete(Connection conn, int id) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(DELETE)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}