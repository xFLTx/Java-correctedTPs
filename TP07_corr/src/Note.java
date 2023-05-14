public class Note {
    private double resultat;
    private int coefficient;

    public Note(double resultat, int coefficient) {
        this.resultat = resultat;
        this.coefficient = coefficient;
    }

    public double getResultat() {
        return resultat;
    }

    public int getCoefficient() {
        return coefficient;
    }

    public String toString(){
        return String.valueOf(resultat);
    }
}
