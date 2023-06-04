public class Moto extends Vehicule {
    private int cylindree;

    public Moto(String immatriculation, String marque, String modele, String etat, int cylindree) {
        super(immatriculation, marque, modele, etat);
        this.cylindree = cylindree;
    }

    @Override
    public String toString() {
        return "Moto "+ cylindree +"cc : " + super.toString();
    }
    public String ajoutAffichage(String affichage){return affichage + this;}
}
