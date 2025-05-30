import Convertisseur.Euro;
import Convertisseur.EuroHelper;
import org.omg.CORBA.ORB;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Server {
    public static void main(String[] args) {
        try {
            ORB orb = ORB.init(args, null);
            POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootpoa.the_POAManager().activate();

            EuroImpl euroImpl = new EuroImpl();
            org.omg.CORBA.Object ref = rootpoa.servant_to_reference(euroImpl);
            Euro euroRef = EuroHelper.narrow(ref);

            PrintWriter file = new PrintWriter(new FileWriter("EuroIOR.txt"));
            file.println(orb.object_to_string(euroRef));
            file.close();

            System.out.println("Serveur CORBA Euro en attente des requêtes...");
            orb.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}