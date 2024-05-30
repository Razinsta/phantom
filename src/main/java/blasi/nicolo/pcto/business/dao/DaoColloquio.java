package blasi.nicolo.pcto.business.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import blasi.nicolo.pcto.bean.Colloquio;


public class DaoColloquio {
    private static final String INSERT = "INSERT INTO Colloquio (data, ora, idPctoXAzienda) VALUES (?, ?, ?)";
    private static final String GET_BY_ID = "SELECT id, data, ora, idPctoXAzienda FROM Colloquio WHERE id = ?";
    private static final String GET_ALL = "SELECT id, data, ora, idPctoXAzienda FROM Colloquio";
    //private static final String UPDATE = "UPDATE Colloquio SET data = ?, ora = ?, idPctoXAzienda = ? WHERE id = ?";
    //private static final String DELETE = "DELETE FROM Colloquio WHERE id = ?";

    // Create
    public void insert(Connection conn, Colloquio colloquio) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, colloquio.getData());
            stmt.setString(2, colloquio.getOra());
            stmt.setInt(3, colloquio.getIdPctoXAzienda());
            stmt.executeUpdate();

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    colloquio.setId(generatedKeys.getInt(1));
                }
            }
        }
    }

    // Read by ID
    public Colloquio getById(Connection conn, int id) throws SQLException {
        Colloquio result = null;
        try (PreparedStatement stmt = conn.prepareStatement(GET_BY_ID)) {
            stmt.setInt(1, id);

            try (ResultSet rset = stmt.executeQuery()) {
                if (rset.next()) {
                    String data = rset.getString("data");
                    String ora = rset.getString("ora");
                    int idPctoXAzienda = rset.getInt("idPctoXAzienda");

                    result = new Colloquio(id, data, ora, idPctoXAzienda);
                }
            }
        }
        return result;
    }

    // Read all
    public List<Colloquio> getAll(Connection conn) throws SQLException {
        List<Colloquio> list = new ArrayList<>();
        try (PreparedStatement stmt = conn.prepareStatement(GET_ALL);
             ResultSet rset = stmt.executeQuery()) {

            while (rset.next()) {
                int id = rset.getInt("id");
                String data = rset.getString("data");
                String ora = rset.getString("ora");
                int idPctoXAzienda = rset.getInt("idPctoXAzienda");

                list.add(new Colloquio(id, data, ora, idPctoXAzienda));
            }
        }
        return list;
    }

    // Update
/*    public void update(Connection conn, Colloquio colloquio) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(UPDATE)) {
            stmt.setString(1, colloquio.getData());
            stmt.setString(2, colloquio.getOra());
            stmt.setInt(3, colloquio.getIdPctoXAzienda());
            stmt.setInt(4, colloquio.getId());
            stmt.executeUpdate();
        }
    }

    // Delete
    public void delete(Connection conn, int id) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(DELETE)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }*/
}

