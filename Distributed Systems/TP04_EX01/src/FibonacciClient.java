import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

public class FibonacciClient {
    public static void main(String[] args) {
        try {
            Registry registre = LocateRegistry.getRegistry("localhost", 2000);
            FibonacciService stub = (FibonacciService) registre.lookup("FibonacciService");

            List<Long> resultats = stub.calculerFibonacci();
            System.out.println("Suite de Fibonacci calculée : " + resultats);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}