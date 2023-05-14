
/**
 * Write a description of class Analyse here.
 *
 * @author MGR
 * @version 1.0
 */
public abstract class Analyse
{
    private int analyseID; 
    private int patientID;

    /**
     * Constructor for objects of class Analyse
     */
    public Analyse(int analyseID, int patientID)
    {
       this.analyseID = analyseID;
       this.patientID = patientID;
    }
    public int getPatientID(){
        return patientID;
    }
    public String toString(){
        return "Analyse "+analyseID+" pour patient "+patientID;
    }
    
    public boolean equals(Object o){
        return ((Analyse)o).analyseID == analyseID;
    }
    
    public abstract boolean isProblematic();
}
