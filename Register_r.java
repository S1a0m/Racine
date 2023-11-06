package racine;

import java.sql.*;

public class Register_r {
	
	private String appId, userId, password	;   // app name or website name
									  // user name, email or phone number
	private static Connection connect = null;
	private static Statement state = null;
	
	public Register_r(String appId, String userId, char[] password) {
		// constructor definition
		this.appId = appId;
		this.userId = userId;
		this.password = new String(password);
		this.table_r();
	}
	
	private void table_r() {
		// create racine table if not exists
		try {
			Class.forName("org.sqlite.JDBC");
			connect = DriverManager.getConnection("jdbc:sqlite:racine.db");
			state = connect.createStatement();
			
			String query = "CREATE TABLE IF NOT EXISTS racine"
					+ "(id INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE,"
					+ "user TEXT NOT NULL,"
					+ "app TEXT NOT NULL,"
					+ "password TEXT NOT NULL,"
					+ "key TEXT NOT NULL)";
			state.executeUpdate(query);
			
			state.close();
			connect.close();
		}
		catch (Exception e) {
			// System.out.println("Cannot connect to racine.db");
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			// System.exit(0);
			// System.out.println("ERROR: could not create data base");
		}
	}
	
	public boolean register_r() {
		// register user data in a data base
		try {
			Class.forName("org.sqlite.JDBC");
			connect = DriverManager.getConnection("jdbc:sqlite:racine.db");
			connect.setAutoCommit(false);
			state = connect.createStatement();
		
			String query = "INSERT INTO racine (user, app, password)"
					+ "VALUES (" + this.userId + "," + this.appId + "," 
					+ this.password + this.key_r() + ");";
			state.executeUpdate(query);
			
			state.close();
			connect.commit();
			connect.close();
			return true;
		}
		catch (Exception e) {
			// System.err.println(e.getClass().getName() + ": " + e.getMessage());
			// System.exit(0);
			System.out.println("ERROR: could not register data");
			return false;
		}
	}
	
	public String key_r() {
		/* create unique key about
		 * user information
		 */
		return "test"; 
	}
}
