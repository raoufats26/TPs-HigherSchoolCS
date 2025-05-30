import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class TriangleClient {
    public static void main(String[] args) {
        try {
            Registry registre = LocateRegistry.getRegistry("localhost", 3000);
            TriangleService stub = (TriangleService) registre.lookup("TriangleService");

            Scanner scanner = new Scanner(System.in);
            System.out.print("Entrez le nombre de lignes : ");
            int lignes = scanner.nextInt();

            System.out.println("Choisissez le type de triangle : ");
            System.out.println("1. Triangle croissant");
            System.out.println("2. Triangle décroissant");
            int choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    System.out.println(stub.triangleCroissant(lignes));
                    break;
                case 2:
                    System.out.println(stub.triangleDecroissant(lignes));
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