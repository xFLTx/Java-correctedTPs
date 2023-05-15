public class VoyageAvecVoiture extends Voyage {
    private static final int PRIXVOITURE = 500;
    private String voyageur;

    public VoyageAvecVoiture(int id, String destination, String dateDepart, double prix, String voyageur) {
        super(id, destination, dateDepart, prix);
        this.voyageur = voyageur;
    }

    @Override
    public double calculerPrix() {
        return getPrix() + PRIXVOITURE;
    }

    public String toString() {
        return super.toString() + " " +calculerPrix()+ "chf" + " - " + voyageur + " avec voiture.";
    }
}
