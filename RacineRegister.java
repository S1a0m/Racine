package racine;

import java.sql.*;

public class RacineRegister {
	
	private String appId, userId, password;   // app name or website name
											  // user name, email or phone number
	private static Connection connect = null;
	private static Statement state = null;
	
	public RacineRegister(String appId, String userId, String password) {
		// constructor definition
		this.appId = appId;
		this.userId = userId;
		this.password = password;
	}
	
	/*static boolean connect_r() {
		// creer a chaque fois la BDD s'il elle n'existe pas
		// renvoi vrai quand ouverture possible faux a contrariot
		try {
			Class.forName("org.sqlite.JDBC");
			connect = DriverManager.getConnection("jdbc:sqlite:racine.db");
			return true;
		}
		catch (Exception e) {
			// System.out.println("Cannot connect to racine.db");
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			// System.exit(0);
			return false;
		}
	}*/
	
	static boolean table_r() {
		// create racine table if not exists
		try {
			Class.forName("org.sqlite.JDBC");
			connect = DriverManager.getConnection("jdbc:sqlite:racine.db");
			state = connect.createStatement();
			
			String query = "CREATE TABLE Racine"
					+ "(id UNSIGNED NOT NULL AUTO_INCREMENT,"
					+ "userId VARCHAR(80) NOT NULL,"
					+ "appId VARCHAR(80) NOT NULL,"
					+ "password TEXT NOT NULL,"
					+ "key TEXT NOT NULL,"
					+ "PRIMARY KEY (id)";
			state.executeUpdate(query);
			
			state.close();
			connect.close();
			return true;
		}
		catch (Exception e) {
			// System.out.println("Cannot connect to racine.db");
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			// System.exit(0);
			return false;
		}
	}
	
	public boolean register_r() {
		// register user data in a data base
		try {
			Class.forName("org.sqlite.JDBC");
			connect = DriverManager.getConnection("jdbc:sqlite:racine.db");
			connect.setAutoCommit(false);
			state = connect.createStatement();
			
			String query = "INSERT INTO Racine (userId, appId, password)"
					+ "VALUES (" + this.appId + "," + this.appId + "," 
					+ this.password + this.key_r() + ");";
			state.executeUpdate(query);
			
			state.close();
			connect.commit();
			connect.close();
			return true;
		}
		catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			// System.exit(0);
			return false;
		}
	}
	
	public String key_r() {
		/* create unique key about
		 * user information
		 */
		return "key"; 
	}
}
