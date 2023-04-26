import java.util.Objects;

public abstract class Cafe extends Boisson{
    private String provenance;
    private int force;

    public Cafe(String nom, double prix, int taille, String provenance, int force) {
        super(nom, prix, taille);
        this.provenance = provenance;
        this.force = force;
    }

    @Override
    public String toString() {
        return super.toString() + provenance + ", intensité " + force+ ",";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Cafe cafe = (Cafe) o;
        return force == cafe.force && Objects.equals(provenance, cafe.provenance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), provenance, force);
    }
}
