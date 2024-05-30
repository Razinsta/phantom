package volta.ts.it.ProggettoPCTO.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MySQLUtil{
	private static final String DB_DRIVER   = "com.mysql.cj.jdbc.Driver";
	private static final String DB_DATABASE = "jdbc:mysql://192.168.8.103:3306/pcto4e4f_sql";
	private static final String DB_USERNAME = "pcto4e4f_sql";
	private static final String DB_PASSWORD = "Pcto!";
	public static void loadDriver() throws ClassNotFoundException{
		Class.forName(DB_DRIVER);
	}
	public static Connection connect() throws SQLException
	{
		return DriverManager.getConnection(DB_DATABASE, DB_USERNAME, DB_PASSWORD);
	}
	public static void disconnect(Connection connection)
	{
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

