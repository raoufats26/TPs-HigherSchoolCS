import java.io.Serializable;

public class Compte implements Serializable {
    private static final long serialVersionUID = 1L;

    private int numero;
    private double solde;

    public Compte(int numero, double solde) {
        this.numero = numero;
        this.solde = solde;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public void deposer(double montant) {
        if (montant > 0) {
            this.solde += montant;
            System.out.println("Dépôt de " + montant + " effectué. Nouveau solde : " + solde);
        } else {
            System.out.println("Le montant à déposer doit être positif.");
        }
    }

    public boolean retirer(double montant) {
        if (montant > 0 && montant <= solde) {
            this.solde -= montant;
            System.out.println("Retrait de " + montant + " effectué. Nouveau solde : " + solde);
            return true;
        } else {
            System.out.println("Fonds insuffisants ou montant invalide.");
            return false;
        }
    }

    public double consulter(int num) {
        if (this.numero == num) {
            return this.solde;
        } else {
            System.out.println("Compte non trouvé.");
            return -1;
        }
    }

    @Override
    public String toString() {
        return "Compte{numero=" + numero + ", solde=" + solde + "}";
    }
}
