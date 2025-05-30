import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class CalculClient {
    public static void main(String[] args) {
        try {
            Registry registre = LocateRegistry.getRegistry("localhost", 3000);
            CalculService stub = (CalculService) registre.lookup("CalculService");

            Scanner scanner = new Scanner(System.in);
            System.out.print("Entrez le premier nombre : ");
            int a = scanner.nextInt();
            System.out.print("Entrez le deuxième nombre : ");
            int b = scanner.nextInt();

            System.out.println("Choisissez l'opération : ");
            System.out.println("1. Somme");
            System.out.println("2. Produit");
            System.out.println("3. Soustraction");
            System.out.println("4. Division");
            int choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    System.out.println("Résultat: " + stub.somme(a, b));
                    break;
                case 2:
                    System.out.println("Résultat: " + stub.produit(a, b));
                    break;
                case 3:
                    System.out.println("Résultat: " + stub.soustraction(a, b));
                    break;
                case 4:
                    if (b != 0) {
                        System.out.println("Résultat: " + stub.division(a, b));
                    } else {
                        System.out.println("Erreur : Division par zéro non autorisée.");
                    }
                    break;
                default:
                    System.out.println("Choix invalide.");
            }

            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}