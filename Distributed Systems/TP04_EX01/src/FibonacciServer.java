import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class FibonacciServer implements FibonacciService {
    public List<Long> calculerFibonacci() throws RemoteException {
        List<Long> sequence = new ArrayList<>();
        long premier = 1, deuxieme = 1;
        for (int i = 0; i < 20; i++) {
            sequence.add(premier);
            long suivant = premier + deuxieme;
            premier = deuxieme;
            deuxieme = suivant;
        }
        return sequence;
    }

    public static void main(String[] args) {
        try {
            FibonacciServer serveur = new FibonacciServer();
            FibonacciService stub = (FibonacciService) UnicastRemoteObject.exportObject(serveur, 0);

            Registry registre = LocateRegistry.createRegistry(2000);
            registre.rebind("FibonacciService", stub);

            System.out.println("Serveur Fibonacci en attente de connexions...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}