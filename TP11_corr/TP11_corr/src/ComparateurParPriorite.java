import java.util.Comparator;

public class ComparateurParPriorite implements Comparator<Tache> {
    @Override
    public int compare(Tache tache1, Tache tache2) {
        return tache1.compareParPriorite(tache2);
    }
}