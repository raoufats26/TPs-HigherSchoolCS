import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TextService extends Remote {
    String inverse(String mot) throws RemoteException;
    boolean palindrome(String mot) throws RemoteException;
    boolean contenir(String mot, String sousMot) throws RemoteException;
}
