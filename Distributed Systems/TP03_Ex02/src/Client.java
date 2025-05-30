import Convertisseur.Euro;
import Convertisseur.EuroHelper;
import org.omg.CORBA.ORB;
import java.io.BufferedReader;
import java.io.FileReader;

public class Client {
    public static void main(String[] args) {
        try {
            ORB orb = ORB.init(args, null);

            BufferedReader file = new BufferedReader(new FileReader("EuroIOR.txt"));
            String ior = file.readLine();
            file.close();

            org.omg.CORBA.Object obj = orb.string_to_object(ior);
            Euro euroRef = EuroHelper.narrow(obj);

            float montant = 150;
            System.out.println("Montant: " + montant + " EUR");
            System.out.println("En Dollar: " + euroRef.toDollar(montant) + " USD");
            System.out.println("En Livre Sterling: " + euroRef.toPound(montant) + " GBP");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
