import java.util.Comparator;

public class ComparateurParDescription implements Comparator<Tache> {
    @Override
    public int compare(Tache tache1, Tache tache2) {
        return tache1.compareParDescription(tache2);
    }
}