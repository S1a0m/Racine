package racine;

import java.util.*;

public class Racine {

	public static void main(String[] args) {
		
		int largs = args.length;
		String menu = "Usage: \n"                          // racine usages
				+ "\t racine [ option ] site/app [ option ] user/key\n"
				+ "\n"
				+ "options         :"
				+ "\t-n site name or app\n"
				+ "\t\t	-u user name, email or phone number\n"
				+ "\t\t	-k key\n"
				+ "\t\t	-d delete info\n"
				+ ""
				+ "registering     :   racine -n ( site/app ) -u ( user )\n"
				+ "read            :   racine -r ( site/app ) -k ( key )\n"
				+ "delete user     :   racine -d ( site/app ) -k ( key )\n"
				+ "delete site/app :   racine -d ( site/app )";
		
		// treatment
		switch (largs) {
		case 4:
			System.out.println();
			break;
			
		case 2:
			if (args[0].equals("-d")) {
				try {
					delete_info(args[1], "test");
				}
				catch (/* sure data not found error */) {
					System.out.println("L'application ou le site que vous avez entrez ne figure pas"
							+ "dans la base de donne. Verifiez qu'il est bien ecrit.");
				}
			}
			else {
				System.out.println(menu);
			}
			System.out.println();
			break;
			
		default:
			System.out.println(menu);
		}
	}
	
	// fonction d'affichage des renseignements
	// relatifs a l'utilisateur
	
	public static String read_info(String appId, String key) {
		
		// doit retourner les renseignements relatifs
		// au site ou a l'application de l'utilisateur
		// essentiellement
		
		return "1";  
	}
	
	public static boolean delete_info(String appId, String key) {
		
		// doit supprimer des renseignements 
		// - nom du site ou du processus
		// - renseignements retournes par la clee
		
		return true;
	}
}
