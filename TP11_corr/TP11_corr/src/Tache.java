import java.util.Objects;

public class Tache implements Comparable<Tache> {
    private String description;
    private String dateEcheance;
    private int priorite;
    public Tache(String description, String dateEcheance, int priorite) {
        this.description = description;
        this.dateEcheance = dateEcheance;
        this.priorite = priorite;
    }


    @Override
    public String toString() {
        return priorite + " (" +dateEcheance + ") - " + description;
    }

    public String toCsv() {
        return priorite + ";" +dateEcheance + ";" + description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tache tache = (Tache) o;
        return priorite == tache.priorite && Objects.equals(description, tache.description) && Objects.equals(dateEcheance, tache.dateEcheance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, dateEcheance, priorite);
    }


    @Override
    public int compareTo(Tache o) {
        if      (this.priorite < o.priorite) { return -1; }
        else if (this.priorite > o.priorite) { return +1; }
        else {
            int resEcheance = o.dateEcheance.compareToIgnoreCase(this.dateEcheance);
            if      (resEcheance!= 0) { return resEcheance; }
            else {
                return this.description.compareToIgnoreCase(o.description);
            }
        }
    }



    public int compareParPriorite(Tache o) { return (o.priorite)- this.priorite; }
    public int compareParDescription(Tache o) { return this.description.compareToIgnoreCase(o.description); }
    public int compareParDateEcheance(Tache o) { return this.dateEcheance.compareToIgnoreCase(o.dateEcheance); }

}
