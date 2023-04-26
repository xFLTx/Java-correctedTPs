import java.util.Objects;

public abstract class Boisson {
    private String nom;
    private double prix;
    private int taille;

    public Boisson(String nom, double prix, int taille) {
        this.nom = nom;
        this.prix = prix;
        this.taille = taille;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Boisson)) return false;
        Boisson boisson = (Boisson) o;
        return Double.compare(boisson.prix, prix) == 0 &&
                taille == boisson.taille &&
                Objects.equals(nom, boisson.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, prix, taille);
    }

    public String toString(){
        return nom + "(" + prix + "Chf) - " + taille + "cl ";
    }

    public abstract String allergie();
}
