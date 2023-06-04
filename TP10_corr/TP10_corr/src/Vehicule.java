import java.util.Objects;

public abstract class Vehicule {
    private String immatriculation;
    private String marque;
    private String modele;
    private String etat;

    public Vehicule(String immatriculation, String marque, String modele, String etat) {
        this.immatriculation = immatriculation;
        this.marque = marque;
        this.modele = modele;
        this.etat = etat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicule vehicule = (Vehicule) o;
        return Objects.equals(immatriculation, vehicule.immatriculation);
    }

    public String toString(){
        return marque + " " + modele + " immatriculée : " + immatriculation +".\n";
    }

    public String getEtat() {
        return etat;
    }
    public abstract String ajoutAffichage(String affichage);
}
