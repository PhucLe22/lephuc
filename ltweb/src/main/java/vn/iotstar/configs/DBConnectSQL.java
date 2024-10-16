package vn.iotstar.configs;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectSQL {
	private final String serverName = "PHUCLE\\PHUCLE";
	private final String dbName = "ltwebct4";
	private final String portNumber = "1433";
	private final String instance = ""; // be empty
	private final String userID = "sa";
	private final String password = "123";

	public Connection getConnection() {
		Connection conn = null;
		try {
			String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + "\\" + instance + ";databaseName="
					+ dbName;

			if (instance == null || instance.trim().isEmpty()) {
				url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName;
			}

			conn = DriverManager.getConnection(url, userID, password);

			if (conn != null) {
				DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
				System.out.println("Driver name: " + dm.getDriverName());
				System.out.println("Driver version: " + dm.getDriverVersion());
				System.out.println("Product name: " + dm.getDatabaseProductName());
				System.out.println("Product version: " + dm.getDatabaseProductVersion());
				return conn;
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	// Test program. click right-mouse and pick "run as" -> choose java application
	public static void main(String[] args) {
                try {
                    System.out.println(new DBConnectSQL().getConnection());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
}