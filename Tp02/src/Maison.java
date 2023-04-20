public class Maison {
    // variables d'instance
    private int surface;
    private int nbPiece;
    private boolean location;
    private int price;

    /**
     * Constructeur d'objets de classe Maison
     */
    public Maison(int surface, int nbPiece, boolean location, int price)
    {
        this.surface = surface;
        this.nbPiece = nbPiece;
        this.location = location;
        this.price = price;
    }

    public String afficher(){
        String result = "Maison d'une surface de " + surface + "m2 comportant " + nbPiece + " pièces. ";
        if(location){
            result += "Le loyer est de " + price + "Chf mensuel.";
        }
        else{
            result += "Le prix est de " + price + "Chf.";
        }
        return result;
    }
}
