
/**
 * Write a description of class Plat here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Plat
{
    // instance variables - replace the example below with your own
    private String nom;
    private String typePlat;  // Par exemple Entrée Plat ou Dessert 

    /**
     * Constructor for objects of class Plat
     */
    public Plat(String nom, String typePlat)
    {
        this.nom = nom;
        this.typePlat = typePlat;
    }

    public String toString(){
        return nom + " (" + typePlat + ") ";
    }
    
    public boolean equals(Object o){
        return this.nom.equals(((Plat)o).nom) && this.typePlat.equals(((Plat)o).typePlat);
    }
}
