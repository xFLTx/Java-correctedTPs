
/**
 * Write a description of class Employe here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Employe
{
    // instance variables - replace the example below with your own
    private String nom;
    private String prenom;
    private String adresse;
    private String fonction;
    private int anneeDansLEntreprise;
    private int salaireMensuel;

    /**
     * Constructor for objects of class Employe
     */
    public Employe(String nom, String prenom, String adresse, String fonction, int anneeDansLEntreprise, int salaireMensuel)
    {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.fonction = fonction;
        this.anneeDansLEntreprise = anneeDansLEntreprise;
        this.salaireMensuel = salaireMensuel;
    }

    
    public void setAdresse(String adresse)
    {
        this.adresse = adresse;
    }
    
    public void setAnneeDansLEntreprise(int annee)
    {
        this.anneeDansLEntreprise = annee;
    }
    
    public float calculBonus()
    {
        return salaireMensuel + (salaireMensuel /100 )*anneeDansLEntreprise;
    }
    
    public void afficher(){
        System.out.println(nom + " " + prenom + ", " + adresse + ". Fonction : " + fonction + "\n" + anneeDansLEntreprise + " années dans l'entreprise. Salaire : " + calculBonus() + "Chf par mois, " + salaireMensuel + "Chf sans bonus");  
    }
}
