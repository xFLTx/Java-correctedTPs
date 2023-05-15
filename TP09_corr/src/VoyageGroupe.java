import java.util.ArrayList;

public class VoyageGroupe extends Voyage {
    private static final int PRIXPARPERSONNE = 50;
    private ArrayList<String> participants;

    public VoyageGroupe(int id, String destination, String dateDepart, double prix) {
        super(id, destination, dateDepart, prix);
        participants = new ArrayList<>();
    }

    public double calculerPrix() {
        return getPrix() + participants.size() * PRIXPARPERSONNE;
    }

    public void ajouterParticipant(String nom) {
        participants.add(nom);
    }

    public String toString() {
        return super.toString() + " " +calculerPrix()+ "chf" + " - " + participants.size() + " participants";
    }
}
