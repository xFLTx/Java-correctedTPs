import java.util.Objects;

public class Espresso extends Cafe{
    private int quantiteCreme;

    public Espresso(String nom, double prix, int taille, String provenance, int force, int quantiteCreme) {
        super(nom, prix, taille, provenance, force);
        this.quantiteCreme = quantiteCreme;
    }

    public String toString(){
        return super.toString() + " " + quantiteCreme+ "cl de crème";
    }

    public String allergie(){
        if (quantiteCreme > 0){
            return "\n\t - Contient du lactose.\n";
        }else{
            return "\n";
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Espresso espresso = (Espresso) o;
        return quantiteCreme == espresso.quantiteCreme;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), quantiteCreme);
    }
}
