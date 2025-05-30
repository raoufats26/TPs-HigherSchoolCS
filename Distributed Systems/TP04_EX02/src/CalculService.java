import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CalculService extends Remote {
    int somme(int a, int b) throws RemoteException;
    int produit(int a, int b) throws RemoteException;
    int soustraction(int a, int b) throws RemoteException;
    double division(int a, int b) throws RemoteException;
}