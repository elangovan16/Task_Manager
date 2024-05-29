package taskmanager.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetConnection {
	private static final String name = "root";
	private static final String password = "Elangovan@16";
	private static final String url = "jdbc:mysql://localhost:3306/tasks_db";
	private static Connection con;

	private GetConnection() {
	}

	public static Connection getConnection() throws SQLException {
		if (con == null || con.isClosed()) {
			con = DriverManager.getConnection(url, name, password);
		}
		return con;
	}

	public static void closeConnection() {
		try {
			if (con != null && !con.isClosed()) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
