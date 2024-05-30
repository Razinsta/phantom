package blasi.nicolo.pcto.business.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import blasi.nicolo.pcto.bean.Help;


public class DaoHelp {
    private static final String INSERT = "INSERT INTO Help (help) VALUES (?)";
    private static final String GET_BY_ID = "SELECT id, help FROM Help WHERE id = ?";
    private static final String GET_ALL = "SELECT id, help FROM Help";
    private static final String UPDATE = "UPDATE Help SET help = ? WHERE id = ?";
    private static final String DELETE = "DELETE FROM Help WHERE id = ?";

    // Create
    public void insert(Connection conn, Help helpObj) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, helpObj.getHelp());
            stmt.executeUpdate();

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    helpObj.setId(generatedKeys.getInt(1));
                }
            }
        }
    }

    // Read by ID
    public Help getById(Connection conn, int id) throws SQLException {
        Help result = null;
        try (PreparedStatement stmt = conn.prepareStatement(GET_BY_ID)) {
            stmt.setInt(1, id);

            try (ResultSet rset = stmt.executeQuery()) {
                if (rset.next()) {
                    String help = rset.getString("help");

                    result = new Help(id, help);
                }
            }
        }
        return result;
    }

    // Read all
    public List<Help> getAll(Connection conn) throws SQLException {
        List<Help> list = new ArrayList<>();
        try (PreparedStatement stmt = conn.prepareStatement(GET_ALL);
             ResultSet rset = stmt.executeQuery()) {

            while (rset.next()) {
                int id = rset.getInt("id");
                String help = rset.getString("help");

                list.add(new Help(id, help));
            }
        }
        return list;
    }

    // Update
    public void update(Connection conn, Help helpObj) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(UPDATE)) {
            stmt.setString(1, helpObj.getHelp());
            stmt.setInt(2, helpObj.getId());
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
