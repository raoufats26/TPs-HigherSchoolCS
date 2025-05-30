import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class TextClient {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            TextService service = (TextService) registry.lookup("TextService");

            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("\nMenu Text Processing :");
                System.out.println("1. Inverser un mot");
                System.out.println("2. Vérifier si un mot est un palindrome");
                System.out.println("3. Vérifier si un mot contient un autre");
                System.out.println("4. Quitter");
                System.out.print("Choix : ");
                int choix = scanner.nextInt();
                scanner.nextLine();

                if (choix == 4) {
                    System.out.println("Fermeture du client...");
                    break;
                }

                System.out.print("Entrer un mot : ");
                String mot = scanner.nextLine();

                switch (choix) {
                    case 1:
                        System.out.println("Mot inversé : " + service.inverse(mot));
                        break;
                    case 2:
                        System.out.println(mot + (service.palindrome(mot) ? " est un palindrome." : " n'est pas un palindrome."));
                        break;
                    case 3:
                        System.out.print("Entrer le mot à rechercher : ");
                        String sousMot = scanner.nextLine();
                        System.out.println("Résultat : " + (service.contenir(mot, sousMot) ? "Contient" : "Ne contient pas"));
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
