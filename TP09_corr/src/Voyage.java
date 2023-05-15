import java.util.Objects;

public abstract class Voyage {
    private int id;
    private String destination;
    private String dateDepart;
    private double prix;

    public Voyage(int id, String destination, String dateDepart, double prix) {
        this.id = id;
        this.destination = destination;
        this.dateDepart = dateDepart;
        this.prix = prix;
    }

    public abstract double calculerPrix();

    public double getPrix() {
        return prix;
    }

    public int getId() {
        return id;
    }

    public String toString() {
        return id + " - " + destination + " (" + dateDepart + ") : ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Voyage voyage = (Voyage) o;
        return id == voyage.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
