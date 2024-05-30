//@formatter:off
package volta.ts.it.ProggettoPCTO.util;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil 
{
	public static void close(PreparedStatement stmt) {
		close(stmt, null);
	}

	public static void close(ResultSet rset) {
		close(null, rset);
	}

	public static void close(PreparedStatement stmt, ResultSet rset)
	{
		if (rset != null) try { rset.close(); } catch (SQLException e) {}
		if (stmt != null) try { stmt.close(); } catch (SQLException e) {}
	}

	//----------------------------------------------------------------------------------------------
	
	public static int getInt(ResultSet rset, String fieldName) {
		return getInt(rset, fieldName, 0);
	}
	
	public static int getInt(ResultSet rset, String fieldName, int defValue)
	{
		try {
			return rset.getInt(fieldName);
		} catch (SQLException e) {
			return defValue;
		}
	}

	//----------------------------------------------------------------------------------------------
	
	public static long getLong(ResultSet rset, String fieldName) {
		return getLong(rset, fieldName, 0L);
	}
	
	public static long getLong(ResultSet rset, String fieldName, long defValue)
	{
		try {
			return rset.getLong(fieldName);
		} catch (SQLException e) {
			return defValue;
		}
	}

	//----------------------------------------------------------------------------------------------
	
	public static float getFloat(ResultSet rset, String fieldName) {
		return getFloat(rset, fieldName, 0.0F);
	}
	
	public static float getFloat(ResultSet rset, String fieldName, float defValue)
	{
		try {
			return rset.getFloat(fieldName);
		} catch (SQLException e) {
			return defValue;
		}
	}

	//----------------------------------------------------------------------------------------------
	
	public static double getDouble(ResultSet rset, String fieldName) {
		return getDouble(rset, fieldName, 0.0F);
	}
	
	public static double getDouble(ResultSet rset, String fieldName, double defValue)
	{
		try {
			return rset.getFloat(fieldName);
		} catch (SQLException e) {
			return defValue;
		}
	}

	//----------------------------------------------------------------------------------------------
	
	public static String getString(ResultSet rset, String fieldName) {
		return getString(rset, fieldName, null);
	}
	
	public static String getString(ResultSet rset, String fieldName, String defValue)
	{
		try {
			return rset.getString(fieldName);
		} catch (SQLException e) {
			return defValue;
		}
	}
	
}
