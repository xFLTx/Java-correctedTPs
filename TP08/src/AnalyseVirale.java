
/**
 * Write a description of class AnalyseVirale here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class AnalyseVirale extends Analyse
{
    // instance variables - replace the example below with your own
    private String nomVirus;
    private boolean valeurAnalyse;

    /**
     * Constructor for objects of class AnalyseVirale
     */
    public AnalyseVirale(int analyseID, int patientID, String nomVirus, boolean valeurAnalyse)
    {
        super(analyseID, patientID);
        this.nomVirus = nomVirus;
        this.valeurAnalyse = valeurAnalyse;
    }

    public boolean isProblematic(){
        return valeurAnalyse;
    }

    public String toString(){
        return super.toString()+" Virus "+nomVirus+" "+(valeurAnalyse?"OUI":"NON");
    }
}
