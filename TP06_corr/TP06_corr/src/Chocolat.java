import java.util.Objects;

public class Chocolat extends Boisson {
    private String typeChocolat;

    public Chocolat(String nom, double prix, int taille, String typeChocolat) {
        super(nom, prix, taille);
        this.typeChocolat = typeChocolat;
    }

    public String toString(){
        return super.toString() + "chocolat " + typeChocolat;
    }

    public String allergie(){
        if (!typeChocolat.equals("noir")){
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
        Chocolat chocolat = (Chocolat) o;
        return Objects.equals(typeChocolat, chocolat.typeChocolat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), typeChocolat);
    }
}
