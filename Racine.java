package racine;

import java.util.*;

public class Racine {
	
	private static String menu = "Usage: \n"                          // racine usages
			+ "\t racine [option] site/app [option] user/key\n"
			+ "\n"
			+ "options         :"
			+ "\t-n site name or app\n"
			+ "\t\t	-u user name, email or phone number\n"
			+ "\t\t	-k key\n"
			+ "\t\t	-d delete info\n"
			+ ""
			+ "registering     :   racine -n <site/app> -u <user>\n"
			+ "read            :   racine -r <site/app> -k <key>\n"
			+ "delete user     :   racine -d <site/app> -k <key>\n"
			+ "delete site/app :   racine -d <site/app>";

	public static void main(String[] args) {
		
		int largs = args.length;
		Scanner entry = new Scanner(System.in);
		
		// treatment
		switch (largs) {
		
		case 4:
			
			if (args[0].equals("-n") && args[2].equals("-u")) {
				
				while (true) {
					// entrer le mot de passe sans affichage a l'ecran
					System.out.print("Password: ");
					String password = entry.nextLine();
					entry.nextLine();       // empty entry
					// confirmation
					System.out.print("Confirm: ");
					String confirm = entry.nextLine();
					
					if (password.equals(confirm)) {
						RacineRegister register = new RacineRegister(args[1], args[3], confirm);
						register.register_user();
						
						System.out.println("KEY : " + register.make_key());
						System.out.println("Take a photo of the key.");
						break;
					}
					else {
						System.out.println("ERROR: passwords are not the same.");
						continue;
					}
					
				}
			}
			else if (args[0].equals("-r") && args[2].equals("-k")) {
				read_info(args[1], args[3]);
			}
			else if (args[0].equals("-d") && args[2].equals("-k")) {
				System.out.print("Are you sure you want to delete info (y/n)? ");
				String yn = entry.nextLine();
				
				if (yn.equals("y") || yn.equals("Y")) {
					delete_info(args[1], args[3]);
					System.out.println("DELETE : ok");
				}
				else 
					System.out.println("Bye");
				
			}
			else
				System.out.println(Racine.menu);
			
			break;
			
		case 2:
			
			if (args[0].equals("-d")) {
				System.out.print("Are you sure to delete info (y/n)? ");
				String yn = entry.nextLine();
				
				if (yn.equals("y") || yn.equals("Y")) {
					delete_info(args[1], "test");
					System.out.println("DELETE : ok");
				}
				else 
					System.out.println(Racine.menu);
			
			}
			else {
				System.out.println(Racine.menu);
			}
			break;
			
		default:
			System.out.println(Racine.menu);
		}
	}
	
	public static boolean db_exist() {
		
		// verifier l'existence de la BDD avant de lire
		// ou supprimer les informations
		
		return true;
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
