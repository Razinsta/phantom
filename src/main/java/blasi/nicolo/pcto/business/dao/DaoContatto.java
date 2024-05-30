package blasi.nicolo.pcto.business.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import blasi.nicolo.pcto.bean.Contatto;


public class DaoContatto {
    private static final String INSERT = "INSERT INTO Contatto (titolo, nome, cognome, descrizione, telefono, cellulare, mail, idazienda) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String GET_BY_ID = "SELECT id, titolo, nome, cognome, descrizione, telefono, cellulare, mail, idazienda FROM Contatto WHERE id = ?";
    private static final String GET_ALL = "SELECT id, titolo, nome, cognome, descrizione, telefono, cellulare, mail, idazienda FROM Contatto";
    private static final String UPDATE = "UPDATE Contatto SET titolo = ?, nome = ?, cognome = ?, descrizione = ?, telefono = ?, cellulare = ?, mail = ?, idazienda = ? WHERE id = ?";
    private static final String DELETE = "DELETE FROM Contatto WHERE id = ?";

    // Create
    public void insert(Connection conn, Contatto contatto) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, contatto.getTitolo());
            stmt.setString(2, contatto.getNome());
            stmt.setString(3, contatto.getCognome());
            stmt.setString(4, contatto.getDescrizione());
            stmt.setString(5, contatto.getTelefono());
            stmt.setString(6, contatto.getCellulare());
            stmt.setString(7, contatto.getMail());
            stmt.setInt(8, contatto.getIdazienda());
            stmt.executeUpdate();

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    contatto.setId(generatedKeys.getInt(1));
                }
            }
        }
    }

    // Read by ID
    public Contatto getById(Connection conn, int id) throws SQLException {
        Contatto result = null;
        try (PreparedStatement stmt = conn.prepareStatement(GET_BY_ID)) {
            stmt.setInt(1, id);

            try (ResultSet rset = stmt.executeQuery()) {
                if (rset.next()) {
                    String titolo = rset.getString("titolo");
                    String nome = rset.getString("nome");
                    String cognome = rset.getString("cognome");
                    String descrizione = rset.getString("descrizione");
                    String telefono = rset.getString("telefono");
                    String cellulare = rset.getString("cellulare");
                    String mail = rset.getString("mail");
                    int idazienda = rset.getInt("idazienda");

                    result = new Contatto(id, titolo, nome, cognome, descrizione, telefono, cellulare, mail, idazienda);
                }
            }
        }
        return result;
    }

    // Read all
    public List<Contatto> getAll(Connection conn) throws SQLException {
        List<Contatto> list = new ArrayList<>();
        try (PreparedStatement stmt = conn.prepareStatement(GET_ALL);
             ResultSet rset = stmt.executeQuery()) {

            while (rset.next()) {
                int id = rset.getInt("id");
                String titolo = rset.getString("titolo");
                String nome = rset.getString("nome");
                String cognome = rset.getString("cognome");
                String descrizione = rset.getString("descrizione");
                String telefono = rset.getString("telefono");
                String cellulare = rset.getString("cellulare");
                String mail = rset.getString("mail");
                int idazienda = rset.getInt("idazienda");

                list.add(new Contatto(id, titolo, nome, cognome, descrizione, telefono, cellulare, mail, idazienda));
            }
        }
        return list;
    }

    // Update
    public void update(Connection conn, Contatto contatto) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(UPDATE)) {
            stmt.setString(1, contatto.getTitolo());
            stmt.setString(2, contatto.getNome());
            stmt.setString(3, contatto.getCognome());
            stmt.setString(4, contatto.getDescrizione());
            stmt.setString(5, contatto.getTelefono());
            stmt.setString(6, contatto.getCellulare());
            stmt.setString(7, contatto.getMail());
            stmt.setInt(8, contatto.getIdazienda());
            stmt.setInt(9, contatto.getId());
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
