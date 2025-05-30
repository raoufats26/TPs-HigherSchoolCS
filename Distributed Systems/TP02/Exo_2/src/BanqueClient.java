import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class BanqueClient {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            BanqueService service = (BanqueService) registry.lookup("BanqueService");

            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("\nMenu Banque :");
                System.out.println("1. Déposer de l'argent");
                System.out.println("2. Retirer de l'argent");
                System.out.println("3. Consulter le solde");
                System.out.println("4. Quitter");
                System.out.print("Choix : ");
                int choix = scanner.nextInt();

                if (choix == 4) {
                    System.out.println("Fermeture du client...");
                    break;
                }

                System.out.print("Numéro de compte : ");
                int numero = scanner.nextInt();

                switch (choix) {
                    case 1:
                        System.out.print("Montant à déposer : ");
                        double depot = scanner.nextDouble();
                        service.deposer(numero, depot);
                        break;
                    case 2:
                        System.out.print("Montant à retirer : ");
                        double retrait = scanner.nextDouble();
                        boolean success = service.retirer(numero, retrait);
                        if (!success) {
                            System.out.println("Retrait échoué.");
                        }
                        break;
                    case 3:
                        double solde = service.consulter(numero);
                        if (solde != -1) {
                            System.out.println("Solde actuel : " + solde);
                        } else {
                            System.out.println("Compte non trouvé.");
                        }
                        break;
                    default:
                        System.out.println("Choix invalide.");
                }
            }
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
