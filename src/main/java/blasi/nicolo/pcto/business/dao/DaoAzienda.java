package blasi.nicolo.pcto.business.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import blasi.nicolo.pcto.bean.Azienda;


public class DaoAzienda {
	private static final String INSERT = "INSERT INTO azienda (ragionesociale, piva, sedelegale, topic, note, statoconvenzione, nconvenzione) VALUES (?, ?, ?, ?, ?, ?, ?)";

	private static final String GET_BY_ID = "SELECT id, ragionesociale, piva, sedelegale, topic, note, statoconvenzione, nconvenzione FROM azienda WHERE id = ?";

	private static final String GET_ALL = "SELECT id, ragionesociale, piva, sedelegale, topic, note, statoconvenzione, nconvenzione FROM azienda";

	private static final String UPDATE = "UPDATE azienda SET ragionesociale = ?, piva = ?, sedelegale = ?, topic = ?, note = ?, statoconvenzione = ?, nconvenzione = ? WHERE id = ?";

	private static final String DELETE = "DELETE FROM azienda WHERE id = ?";

    // Create
    public int insert(Connection conn, Azienda azienda) throws SQLException {
    	int id = 0;
        try (PreparedStatement stmt = conn.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, azienda.getRagioneSociale());
            stmt.setString(2, azienda.getpIVA());
            stmt.setString(3, azienda.getSedeLegale());
            stmt.setString(4, azienda.getTopic());
            stmt.setString(5, azienda.getNote());
            stmt.setString(6, azienda.getStatoConvenzione());
            stmt.setString(7, azienda.getnConvenzione());
            stmt.executeUpdate();

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                	 id = generatedKeys.getInt(1);
                    azienda.setId(id);
                }
            }
        }
        return id;
    }

    // Read by ID
    public Azienda getById(Connection conn, int id) throws SQLException {
        Azienda result = null;
        try (PreparedStatement stmt = conn.prepareStatement(GET_BY_ID)) {
            stmt.setInt(1, id);

            try (ResultSet rset = stmt.executeQuery()) {
                if (rset.next()) {
                    String ragioneSociale = rset.getString("ragionesociale");
                    String pIVA = rset.getString("piva");
                    String sedeLegale = rset.getString("sedelegale");
                    String topic = rset.getString("topic");
                    String note = rset.getString("note");
                    String statoConvenzione = rset.getString("statoconvenzione");
                    String nConvenzione = rset.getString("nconvenzione");

                    result = new Azienda(id, ragioneSociale, pIVA, sedeLegale, topic, note, statoConvenzione, nConvenzione);
                }
            }
        }
        return result;
    }

    // Read all
    public List<Azienda> getAll(Connection conn) throws SQLException {
        List<Azienda> list = new ArrayList<>();
        try (PreparedStatement stmt = conn.prepareStatement(GET_ALL);
             ResultSet rset = stmt.executeQuery()) {

            while (rset.next()) {
                int id = rset.getInt("id");
                String ragioneSociale = rset.getString("ragioneSociale");
                String pIVA = rset.getString("pIVA");
                String sedeLegale = rset.getString("sedeLegale");
                String topic = rset.getString("topic");
                String note = rset.getString("note");
                String statoConvenzione = rset.getString("statoconvenzione");
                String nConvenzione = rset.getString("nconvenzione");
                list.add(new Azienda(id, ragioneSociale, pIVA, sedeLegale, topic, note, statoConvenzione, nConvenzione));
            }
        }
        return list;
    }

    // Update
    public void update(Connection conn, Azienda azienda) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(UPDATE)) {
            stmt.setString(1, azienda.getRagioneSociale());
            stmt.setString(2, azienda.getpIVA());
            stmt.setString(3, azienda.getSedeLegale());
            stmt.setString(4, azienda.getTopic());
            stmt.setString(5, azienda.getNote());
            stmt.setString(6, azienda.getStatoConvenzione());
            stmt.setString(7, azienda.getnConvenzione());
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