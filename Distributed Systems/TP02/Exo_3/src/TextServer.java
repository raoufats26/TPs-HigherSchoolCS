import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class TextServer {
    public static void main(String[] args) {
        try {
            TextService service = new TextServiceImpl();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("TextService", service);
            System.out.println("Serveur de texte prêt...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
