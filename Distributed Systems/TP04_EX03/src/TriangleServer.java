import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class TriangleServer implements TriangleService {
    public String triangleCroissant(int lignes) throws RemoteException {
        StringBuilder triangle = new StringBuilder();
        for (int i = 1; i <= lignes; i++) {
            triangle.append(" ".repeat(lignes - i)).append("* ".repeat(i)).append("\n");
        }
        return triangle.toString();
    }

    public String triangleDecroissant(int lignes) throws RemoteException {
        StringBuilder triangle = new StringBuilder();
        for (int i = lignes; i > 0; i--) {
            triangle.append(" ".repeat(lignes - i)).append("* ".repeat(i)).append("\n");
        }
        return triangle.toString();
    }

    public static void main(String[] args) {
        try {
            TriangleServer serveur = new TriangleServer();
            TriangleService stub = (TriangleService) UnicastRemoteObject.exportObject(serveur, 0);

            Registry registre = LocateRegistry.createRegistry(3000);
            registre.rebind("TriangleService", stub);

            System.out.println("Serveur de triangles prêt...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}