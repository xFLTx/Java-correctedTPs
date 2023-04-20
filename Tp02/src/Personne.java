public class Personne {
    // variables d'instance
    private String nom;
    private String prenom;
    private String adresse;
    private int age;
    private Voiture voiture;
    private Maison maison;
    /**
     * Constructeur d'objets de classe Personne
     */
    public Personne(String nom, String prenom, String adresse, int age)
    {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.age = age;
        this.voiture = null;
        this.maison = null;
    }

    public Personne(String nom, String prenom, String adresse, int age, Voiture voiture)
    {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.age = age;
        this.voiture = voiture;
        this.maison = null;
    }

    public Personne(String nom, String prenom, String adresse, int age, Maison maison)
    {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.age = age;
        this.voiture = null;
        this.maison = maison;
    }

    public Personne(String nom, String prenom, String adresse, int age, Voiture voiture, Maison maison)
    {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.age = age;
        this.voiture = voiture;
        this.maison = maison;
    }

    public void setVoiture(Voiture voiture){
        this.voiture = voiture;
    }

    public void setMaison(Maison maison){
        this.maison = maison;
    }

    public String afficher(){
        String result = (nom + " " + prenom + "(" + age + "), " + adresse + "\nPossessions(s) : ");
        if(voiture == null && maison == null){
            result += " Aucunes";
        }
        else {
            if(voiture != null){
                result += voiture.afficher() + " ";
            }
            if(maison != null){
                result += maison.afficher();
            }
        }
        return result;
    }

    public String getPrenom() {
        return prenom;
    }

}
