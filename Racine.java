package racine;

public class Racine {

	public static void main(String[] args) {
		/*
		 * PARAMETRES
		 * -n nom du site ou du processus
		 * -u nom de l'utilisateur, email ou numero de telephone
		 * -k la clee relative aux renseignements
		 * -d supprimer un renseignement
		 */
	}
	
	// fonction d'affichage des renseignements
	// relatifs a l'utilisateur
	
	public static String user_info(String appId, String key) {
		return "1"; // doit retourner les renseignements relatifs
					// au site ou a l'application de l'utilisateur
					// essentiellement 
	}
	
	public static boolean delete_info() {
		// doit supprimer des renseignements 
		// - nom du site ou du processus
		// - renseignements retournes par la clee
		return true;
	}
}
