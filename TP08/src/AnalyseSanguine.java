
/**
 * Write a description of class AnalyseSanguine here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class AnalyseSanguine extends Analyse
{
    // instance variables - replace the example below with your own
    private String typeAnalyse;
    private int valeurAnalyse;
    private int age;

    /**
     * Constructor for objects of class AnalyseSanguine
     */
    public AnalyseSanguine(int analyseID, int patientID, String typeAnalyse, int valeurAnalyse, int age)
    {
        super(analyseID, patientID);
        this.typeAnalyse = typeAnalyse;
        this.valeurAnalyse = valeurAnalyse;
        this.age = age;
    }

    public boolean isProblematic(){
        if (valeurAnalyse<160000){
            return true;
        }else if (valeurAnalyse >450000){
            return true;
        }else if (valeurAnalyse > 400000 && age < 16){
            return true;
        }else if (valeurAnalyse > 350000){
            return true;
        }
        return false;
        
    }
    public String toString(){
        return super.toString()+" Bilan "+typeAnalyse+", valeur "+valeurAnalyse+(isProblematic()?" PAS DANS LA NORME":"");
    }
}
