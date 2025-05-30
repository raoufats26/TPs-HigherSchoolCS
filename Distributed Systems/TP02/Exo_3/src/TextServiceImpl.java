import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class TextServiceImpl extends UnicastRemoteObject implements TextService {

    public TextServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public String inverse(String mot) throws RemoteException {
        return new StringBuilder(mot).reverse().toString();
    }

    @Override
    public boolean palindrome(String mot) throws RemoteException {
        String inverse = new StringBuilder(mot).reverse().toString();
        return mot.equalsIgnoreCase(inverse);
    }

    @Override
    public boolean contenir(String mot, String sousMot) throws RemoteException {
        return mot.contains(sousMot);
    }
}
