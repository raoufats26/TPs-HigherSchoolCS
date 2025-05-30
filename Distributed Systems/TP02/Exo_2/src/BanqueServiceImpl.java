import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

public class BanqueServiceImpl extends UnicastRemoteObject implements BanqueService {
    private Map<Integer, Compte> comptes;

    public BanqueServiceImpl() throws RemoteException {
        super();
        comptes = new HashMap<>();
        // Ajout de comptes de test
        comptes.put(1, new Compte(1, 1000.0));
        comptes.put(2, new Compte(2, 2000.0));
    }

    @Override
    public void deposer(int numero, double montant) throws RemoteException {
        Compte compte = comptes.get(numero);
        if (compte != null) {
            compte.deposer(montant);
        } else {
            System.out.println("Compte " + numero + " non trouvé.");
        }
    }

    @Override
    public boolean retirer(int numero, double montant) throws RemoteException {
        Compte compte = comptes.get(numero);
        if (compte != null) {
            return compte.retirer(montant);
        }
        System.out.println("Compte " + numero + " non trouvé.");
        return false;
    }

    @Override
    public double consulter(int numero) throws RemoteException {
        Compte compte = comptes.get(numero);
        if (compte != null) {
            return compte.getSolde();
        }
        System.out.println("Compte " + numero + " non trouvé.");
        return -1;
    }
}
