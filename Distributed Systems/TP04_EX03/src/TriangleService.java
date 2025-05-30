import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TriangleService extends Remote {
    String triangleCroissant(int lignes) throws RemoteException;
    String triangleDecroissant(int lignes) throws RemoteException;
}