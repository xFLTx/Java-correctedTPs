import java.util.Objects;

public class Macchiato extends Cafe {
    private int quantiteLait;

    public Macchiato(String nom, double prix, int taille, String provenance, int force, int quantiteLait) {
        super(nom, prix, taille, provenance, force);
        this.quantiteLait = quantiteLait;
    }

    public String toString(){
        return super.toString() + " " + quantiteLait+ "cl de lait";
    }

    public String allergie(){
        if (quantiteLait > 0){
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
        Macchiato macchiato = (Macchiato) o;
        return quantiteLait == macchiato.quantiteLait;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), quantiteLait);
    }
}
