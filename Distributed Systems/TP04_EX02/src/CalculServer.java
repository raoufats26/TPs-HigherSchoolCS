import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class CalculServer implements CalculService {
    public int somme(int a, int b) throws RemoteException {
        return a + b;
    }
    public int produit(int a, int b) throws RemoteException {
        return a * b;
    }
    public int soustraction(int a, int b) throws RemoteException {
        return a - b;
    }
    public double division(int a, int b) throws RemoteException {
        if (b == 0) throw new ArithmeticException("Division par zéro non autorisée");
        return (double) a / b;
    }

    public static void main(String[] args) {
        try {
            CalculServer serveur = new CalculServer();
            CalculService stub = (CalculService) UnicastRemoteObject.exportObject(serveur, 0);

            Registry registre = LocateRegistry.createRegistry(3000);
            registre.rebind("CalculService", stub);

            System.out.println("Serveur de calcul prêt...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}