package racine;

import java.sql.*;

public class RacineRegister {
	
	private String appId, userId, password;   // app name or website name
											  // user name, email or phone number
	
	public RacineRegister(String appId, String userId, String password) {
		// constructor definition
		this.appId = appId;
		this.userId = userId;
		this.password = password;
	}
	
	static boolean connect_db() {
		// creer a chaque fois la BDD s'il elle n'existe pas
		// renvoi vrai quand ouverture possible faux a contrariot
		try {
			Class.forName("org.sqlite.JDBC");
			Connection connect = DriverManager.getConnection("jdbc:sqlite:racine.db");
			return true;
		}
		catch (Exception e) {
			// System.out.println("Cannot connect to racine.db");
			// System.err.println(e.getClass().getName() + ": " + e.getMessage());
			// System.exit(0);
			return false;
		}
	}
	
	public boolean register_user() {
		// register user data in a data base
		return true;
	}
	
	public String make_key() {
		/* create unique key about
		 * user information
		 */
		return "key"; 
	}
}
