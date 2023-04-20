import java.util.Objects;

public class Recette {
    private String nom;
    private int page;
    private int nbPersonnes;
    private int temps;

    public Recette(String nom, int page, int nbPersonnes, int temps) {
        this.nom = nom;
        this.page = page;
        this.nbPersonnes = nbPersonnes;
        this.temps = temps;
    }


    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Recette)) return false;
        Recette recette = (Recette) o;
        return Objects.equals(nom, recette.nom);
    }

    public String toString() {
        return  nom + " (Page " + page +") pour "+ nbPersonnes + " personnes. Durée de la recette : " +  temps + " minutes.";
    }
}
