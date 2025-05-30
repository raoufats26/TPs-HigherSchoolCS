import HelloApp.Hello;
import HelloApp.HelloImpl;
import org.omg.CORBA.ORB;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Server {
    public static void main(String[] args) {
        try {
            // Initialize ORB
            ORB orb = ORB.init(args, null);

            // Get reference to RootPOA & activate POAManager
            POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootpoa.the_POAManager().activate();

            // Create servant (implementation)
            HelloImpl helloImpl = new HelloImpl();

            // Register servant with the ORB
            org.omg.CORBA.Object ref = rootpoa.servant_to_reference(helloImpl);
            Hello helloRef = HelloApp.HelloHelper.narrow(ref);

            // Save reference to file
            PrintWriter file = new PrintWriter(new FileWriter("HelloIOR.txt"));
            file.println(orb.object_to_string(helloRef));
            file.close();

            System.out.println("CORBA Server Ready...");
            orb.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
