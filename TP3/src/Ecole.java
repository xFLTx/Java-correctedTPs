import java.util.Objects;

/**
 * Classe représentant une école. Une école possède les champs suivants :
 *      - nom
 *      - adresse
 *      - type (Publique / Privée)
 *      - nombre de bâtiments
 *      - degré (Primaire, C.O. ou Universitaire)
 *      - domaine (Général, Informatique,Gestion,...)
 *      - nombre d'étudiants
 * 
 * Cette classe doit posséder les méthodes suivantes :
 *      - Changer le nombre de bâtiments
 *      - Changer le nombre d'étudiants
 *      - Une méthode affichant :
 *          Un affichage complet :
 *              Nom de l'école, adresse
 *              Ecole "type" de degré xxxxx dans le domaine yyyyyy
 *              Il y a X bâtiments pour Y étudiants 
 *         OU
 *          Un affichage partiel :
 *              Nom de l'école et adresse
 *      - Changer le degré :
 *           Si l'école est publique
 *              Si le degré est Primaire ou C.O., le domaine est obligatoirement Général
 */
public class Ecole
{
    // variables d'instance
    private String nom;
    private String adresse;
    private String type;
    private int nbBatiment;
    private String degre;
    private String domaine;
    private int nbEtudiants;

    /**
     * Constructeur d'objets de classe Ecole
     */
    public Ecole(String nom, String adresse, String type, int nbBatiment, String degre, String domaine, int nbEtudiants)
    {
        // initialisation des variables d'instance
        this.nom = nom;
        this.adresse = adresse;
        this.type = type;
        this.nbBatiment = nbBatiment;
        this.degre = degre;
        this.domaine = domaine;
        this.nbEtudiants = nbEtudiants;
        
    }

    public void setNbBatiments (int nb){
        this.nbBatiment = nb;
    }
    
    public void setNbEtudiants(int nb){
        this.nbEtudiants = nb;
    }
    
    public String toString(){
            return nom + ", " + adresse + "\nEcole " + type +" de degré " + degre + " dans le domaine " + domaine + "\nIl y a " + nbBatiment + " bâtiments pour " + nbEtudiants + " étudiants";
    }

    @Override
    public boolean equals(Object o) {
        Ecole ecole = (Ecole) o;
        if(((Ecole)o).type.equals("Privée") && type.equals("Privée")){
            return Objects.equals(nom, ecole.nom) && Objects.equals(adresse, ecole.adresse) && Objects.equals(domaine, ecole.domaine);
        }else{
            return Objects.equals(nom, ecole.nom) && Objects.equals(adresse, ecole.adresse);
        }

    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, adresse, domaine);
    }

    public void setDegre (String degre){
        this.degre = degre;
        if (type == "Publique" && (degre == "Primaire" || degre == "C.O.")){
            this.domaine = "Général";
        }
    }
}
