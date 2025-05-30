import HelloApp.Hello;
import HelloApp.HelloHelper;
import org.omg.CORBA.ORB;
import java.io.BufferedReader;
import java.io.FileReader;

public class Client {
    public static void main(String[] args) {
        try {
            // Initialize ORB
            ORB orb = ORB.init(args, null);

            // Read IOR from file
            BufferedReader file = new BufferedReader(new FileReader("HelloIOR.txt"));
            String ior = file.readLine();
            file.close();

            // Convert string to CORBA object reference
            org.omg.CORBA.Object obj = orb.string_to_object(ior);
            Hello helloRef = HelloHelper.narrow(obj);

            // Call remote method
            String message = helloRef.sayHello();
            System.out.println("Server Response: " + message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
