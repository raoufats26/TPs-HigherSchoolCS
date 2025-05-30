import java.rmi.Remote;
import java.rmi.RemoteException;

public interface BanqueService extends Remote {
    void deposer(int numero, double montant) throws RemoteException;
    boolean retirer(int numero, double montant) throws RemoteException;
    double consulter(int numero) throws RemoteException;
}
