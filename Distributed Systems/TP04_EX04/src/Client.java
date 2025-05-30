import java.rmi.Naming;

public class Client {
    public static void main(String[] args) {
        try {
            Callback obj = new Callback();
            InterfaceServeur serv = (InterfaceServeur) Naming.lookup("Server");
            System.out.println("Démarrage de l’appel");
            serv.replycallBack(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}