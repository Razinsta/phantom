package blasi.nicolo.pcto.business.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import blasi.nicolo.pcto.bean.RappresentanteLegale;


public class DaoRappresentanteLegale {
    private static final String INSERT = "INSERT INTO RappresentanteLegale (rappresentanteLegale, descrizione, luogoNascita, dataNascita, idAzienda) VALUES (?, ?, ?, ?, ?)";
    private static final String GET_BY_ID = "SELECT id, rappresentanteLegale, descrizione, luogoNascita, dataNascita, idAzienda FROM RappresentanteLegale WHERE id = ?";
    private static final String GET_ALL = "SELECT id, rappresentanteLegale, descrizione, luogoNascita, dataNascita, idAzienda FROM RappresentanteLegale";
    private static final String UPDATE = "UPDATE RappresentanteLegale SET rappresentanteLegale = ?, descrizione = ?, luogoNascita = ?, dataNascita = ?, idAzienda = ? WHERE id = ?";
    private static final String DELETE = "DELETE FROM RappresentanteLegale WHERE id = ?";

    // Create
    public void insert(Connection conn, RappresentanteLegale rappresentante) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, rappresentante.getRappresentanteLegale());
            stmt.setString(2, rappresentante.getDescrizione());
            stmt.setString(3, rappresentante.getLuogoNascita());
            stmt.setString(4, rappresentante.getDataNascita());
            stmt.setInt(5, rappresentante.getIdAzienda());
            stmt.executeUpdate();

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    rappresentante.setId(generatedKeys.getInt(1));
                }
            }
        }
    }

    // Read by ID
    public RappresentanteLegale getById(Connection conn, int id) throws SQLException {
        RappresentanteLegale result = null;
        try (PreparedStatement stmt = conn.prepareStatement(GET_BY_ID)) {
            stmt.setInt(1, id);

            try (ResultSet rset = stmt.executeQuery()) {
                if (rset.next()) {
                    String rappresentanteLegale = rset.getString("rappresentanteLegale");
                    String descrizione = rset.getString("descrizione");
                    String luogoNascita = rset.getString("luogoNascita");
                    String dataNascita = rset.getString("dataNascita");
                    int idAzienda = rset.getInt("idAzienda");

                    result = new RappresentanteLegale(id, rappresentanteLegale, descrizione, luogoNascita, dataNascita, idAzienda);
                }
            }
        }
        return result;
    }

    // Read all
    public List<RappresentanteLegale> getAll(Connection conn) throws SQLException {
        List<RappresentanteLegale> list = new ArrayList<>();
        try (PreparedStatement stmt = conn.prepareStatement(GET_ALL);
             ResultSet rset = stmt.executeQuery()) {

            while (rset.next()) {
                int id = rset.getInt("id");
                String rappresentanteLegale = rset.getString("rappresentanteLegale");
                String descrizione = rset.getString("descrizione");
                String luogoNascita = rset.getString("luogoNascita");
                String dataNascita = rset.getString("dataNascita");
                int idAzienda = rset.getInt("idAzienda");

                list.add(new RappresentanteLegale(id, rappresentanteLegale, descrizione, luogoNascita, dataNascita, idAzienda));
            }
        }
        return list;
    }

    // Update
    public void update(Connection conn, RappresentanteLegale rappresentante) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(UPDATE)) {
            stmt.setString(1, rappresentante.getRappresentanteLegale());
            stmt.setString(2, rappresentante.getDescrizione());
            stmt.setString(3, rappresentante.getLuogoNascita());
            stmt.setString(4, rappresentante.getDataNascita());
            stmt.setInt(5, rappresentante.getIdAzienda());
            stmt.setInt(6, rappresentante.getId());
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
