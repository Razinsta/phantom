package blasi.nicolo.pcto.business.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import blasi.nicolo.pcto.bean.Argomenti;


public class DaoArgomenti {
    private static final String INSERT = "INSERT INTO Argomenti (argomenti) VALUES (?)";
    private static final String GET_BY_ID = "SELECT id, argomenti FROM Argomenti WHERE id = ?";
    private static final String GET_ALL = "SELECT id, argomenti FROM Argomenti";
    private static final String UPDATE = "UPDATE Argomenti SET argomenti = ? WHERE id = ?";
    private static final String DELETE = "DELETE FROM Argomenti WHERE id = ?";

    // Create
    public void insert(Connection conn, Argomenti argomento) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, argomento.getArgomenti());
            stmt.executeUpdate();

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    argomento.setId(generatedKeys.getInt(1));
                }
            }
        }
    }

    // Read by ID
    public Argomenti getById(Connection conn, int id) throws SQLException {
        Argomenti result = null;
        try (PreparedStatement stmt = conn.prepareStatement(GET_BY_ID)) {
            stmt.setInt(1, id);

            try (ResultSet rset = stmt.executeQuery()) {
                if (rset.next()) {
                    String argomenti = rset.getString("argomenti");
                    result = new Argomenti(id, argomenti);
                }
            }
        }
        return result;
    }

    // Read all
    public List<Argomenti> getAll(Connection conn) throws SQLException {
        List<Argomenti> list = new ArrayList<>();
        try (PreparedStatement stmt = conn.prepareStatement(GET_ALL);
             ResultSet rset = stmt.executeQuery()) {

            while (rset.next()) {
                int id = rset.getInt("id");
                String argomenti = rset.getString("argomenti");
                list.add(new Argomenti(id, argomenti));
            }
        }
        return list;
    }

    // Update
    public void update(Connection conn, Argomenti argomento) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(UPDATE)) {
            stmt.setString(1, argomento.getArgomenti());
            stmt.setInt(2, argomento.getId());
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