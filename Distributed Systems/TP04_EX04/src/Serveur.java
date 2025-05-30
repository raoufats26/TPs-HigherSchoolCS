import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class Serveur extends UnicastRemoteObject implements InterfaceServeur {
    public Serveur() throws RemoteException { }

    public void replycallBack(InterfaceCallback obj) throws RemoteException {
        try {
            Thread.sleep(5000);
            obj.doCallback("Bonjour");
            Thread.sleep(5000);
            obj.doCallback("J’utilise Java RMI");
            Thread.sleep(5000);
            obj.doCallback("Fin");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099);
            Serveur serv = new Serveur();
            Naming.rebind("Server", serv);
            System.out.println("Le serveur est prêt...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}