package racine;

public class RacineRegister {
	
	private String appId, userId, password;   // app name or website name
											  // user name, email or phone number
	
	public RacineRegister(String pappId, String puserId, String ppassword) {
		// constructor definition
		appId = pappId;
		userId = puserId;
		password = ppassword;
		this.make_key();
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
