package blasi.nicolo.pcto.business.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import blasi.nicolo.pcto.bean.PCTO;


public class DaoPCTO {
    private static final String INSERT = "INSERT INTO PCTO (annoScolastico, classi, corrente) VALUES (?, ?, ?)";
    private static final String GET_BY_ID = "SELECT id, annoScolastico, classi, corrente FROM PCTO WHERE id = ?";
    private static final String GET_ALL = "SELECT id, annoScolastico, classi, corrente FROM PCTO";
    private static final String UPDATE = "UPDATE PCTO SET annoScolastico = ?, classi = ?, corrente = ? WHERE id = ?";
    private static final String DELETE = "DELETE FROM PCTO WHERE id = ?";

    // Create
    public void insert(Connection conn, PCTO pcto) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, pcto.getAnnoScolastico());
            stmt.setString(2, pcto.getClassi());
            stmt.setString(3, pcto.getCorrente());

            stmt.executeUpdate();

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    pcto.setId(generatedKeys.getInt(1));
                }
            }
        }
    }

    // Read by ID
    public PCTO getById(Connection conn, int id) throws SQLException {
        PCTO result = null;
        try (PreparedStatement stmt = conn.prepareStatement(GET_BY_ID)) {
            stmt.setInt(1, id);

            try (ResultSet rset = stmt.executeQuery()) {
                if (rset.next()) {
                    String annoScolastico = rset.getString("annoScolastico");
                    String classi = rset.getString("classi");
                    String corrente = rset.getString("corrente");

                    result = new PCTO(id, annoScolastico, classi, corrente);
                }
            }
        }
        return result;
    }

    // Read all
    public List<PCTO> getAll(Connection conn) throws SQLException {
        List<PCTO> list = new ArrayList<>();
        try (PreparedStatement stmt = conn.prepareStatement(GET_ALL);
             ResultSet rset = stmt.executeQuery()) {

            while (rset.next()) {
                int id = rset.getInt("id");
                String annoScolastico = rset.getString("annoScolastico");
                String classi = rset.getString("classi");
                String corrente = rset.getString("corrente");

                list.add(new PCTO(id, annoScolastico, classi, corrente));
            }
        }
        return list;
    }

    // Update
    public void update(Connection conn, PCTO pcto) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(UPDATE)) {
        	 stmt.setInt(1, pcto.getId());
            stmt.setString(2, pcto.getAnnoScolastico());
            stmt.setString(3, pcto.getClassi());
            stmt.setString(4, pcto.getCorrente());
           
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