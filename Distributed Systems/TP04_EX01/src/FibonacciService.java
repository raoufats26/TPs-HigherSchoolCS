import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface FibonacciService extends Remote {
    List<Long> calculerFibonacci() throws RemoteException;
}