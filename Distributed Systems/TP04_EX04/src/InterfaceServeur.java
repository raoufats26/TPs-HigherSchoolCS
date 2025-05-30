import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfaceServeur extends Remote {
    void replycallBack(InterfaceCallback obj) throws RemoteException;
}