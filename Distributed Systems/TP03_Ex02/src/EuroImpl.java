import Convertisseur.EuroPOA;

public class EuroImpl extends EuroPOA {
    @Override
    public float toDollar(float montant) {
        return montant * 1.08f;
    }

    @Override
    public float toPound(float montant) {
        return montant * 0.83f;
    }
}