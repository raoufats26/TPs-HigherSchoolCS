import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class BanqueServer {
    public static void main(String[] args) {
        try {
            BanqueService service = new BanqueServiceImpl();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("BanqueService", service);
            System.out.println("Serveur bancaire prêt...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
