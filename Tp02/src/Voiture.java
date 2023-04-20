public class Voiture {
    // variables d'instance
    private String marque;
    private String modele;
    private int annee;

    /**
     * Constructeur d'objets de classe Voiture
     */
    public Voiture(String marque, String modele, int annee)
    {
        this.marque = marque;
        this.modele = modele;
        this.annee = annee;
    }

    public String afficher(){
        return (marque + " " + modele + " de " + annee + ".");
    }
}
