import java.util.ArrayList;
import java.util.Random;
public class Livre {
    private String titre;
    private String auteur;
    private int nbPage;
    private ArrayList<Recette> recettes = new ArrayList<>();

    public Livre(String titre, String auteur, int nbPage) {
        this.titre = titre;
        this.auteur = auteur;
        this.nbPage = nbPage;
    }

    public String getTitre() {
        return titre;
    }

    public void ajoutRecette(Recette r){
            recettes.add(r);
    }

    public Recette getRecetteAleatoire(){
        Random random = new Random();
        if(recettes.size() > 0){
            return recettes.get(random.nextInt(recettes.size()));
        }
        return null;
    }

    public boolean contient(Recette recette){
        return recettes.contains(recette);
    }

    private String afficheRecettes(){
        String val = "";
        for (int i = 0; i < recettes.size(); i++){
            val += "\t" + recettes.get(i) + "\n";
        }
        return val;
    }

    public String toString() {
        return  "\""+ titre + "\" de " + auteur +" (" + nbPage + " pages) contient les recettes : \n" + afficheRecettes();
    }
}

