import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Callback extends UnicastRemoteObject implements InterfaceCallback {
    public Callback() throws RemoteException { }

    public void doCallback(String chaine) throws RemoteException {
        System.out.println(chaine);
    }
}