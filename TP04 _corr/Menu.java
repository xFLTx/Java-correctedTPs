
/**
 * Write a description of class Menu here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Menu
{
    // instance variables - replace the example below with your own
    private String nom;
    private int prix;
    private Plat[] plats;
    private int cptPlat;

    /**
     * Constructor for objects of class Menu
     */
    public Menu(String nom, int prix)
    {
        this.nom = nom;
        this.prix = prix;
        this.plats = new Plat[5];
        cptPlat = 0;
    }

    public boolean recherchePlatMenu(Plat plat){
        for (int i = 0; i < plats.length; i++ ){
            if (plats[i] != null && plat.equals(plats[i])){
                return true;
            }
        }
        return false;
    }
    
    public void addPlat(Plat plat)
    {
        if (cptPlat < plats.length){
            plats[cptPlat] = plat;
            cptPlat++;
        }else{
            System.out.println("Erreur : Il ne peut pas y avoir plus que 5 plats dans un menu.\n");
        }
    }
    
    public String toString(){
        String affichage = "Menu " + nom + " à " + prix + "Chf composé de :\n\t";
        for (Plat p : plats){
            if (p != null){
                affichage += p;
            }
        }
        return affichage+"\n";
    }

    public boolean equals(Object o){
        return nom.equals(((Menu)o).nom);
    }
}
