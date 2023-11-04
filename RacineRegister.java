package racine;

public class RacineRegister {
	private String appId;   // app name or website name
	private String userId;  // user name, email or phone number
	private String password;
	
	public RacineRegister(String pappId, String puserId, String ppassword) {
		// definition du constructeur
		appId = pappId;
		userId = puserId;
		password = ppassword;
		this.make_key();
	}
	
	public boolean register_user() {
		/* enregistre les donnees de l'utilisateur
		 * dans une BDD
		 */
		return true;
	}
	
	public String make_key() {
		/* cette methode cree la cle unique
		 * relative aux renseignements de l'utilisateur
		 */
		return "key"; 
	}
}
