import java.util.ArrayList;

/**
 * Write a description of class GestionAnalyses here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GestionAnalyses
{
    // instance variables - replace the example below with your own
    private static ArrayList<Analyse> analyses = new ArrayList<>();;

    public static void chargerAnalyses(ArrayList<String[]> fichier) throws TypeException
    {
        int cptLigne = 1;

        for (String[] record:fichier){
            int analyseID = Integer.parseInt(record[0]);
            String type = record[1];
            String data = record[2];
            int age = Integer.parseInt(record[3]);
            int patientID = Integer.parseInt(record[4]);
            if (type.equals("PLA")){
                analyses.add(new AnalyseSanguine(analyseID,patientID,"Plaquettes",Integer.parseInt(data),age));
            }else if(type.equals("TOX")||type.equals("VHA")){
                analyses.add(new AnalyseVirale(analyseID,patientID,type,data.equals("POSITIF")));
            }else{
                throw new TypeException("\t - Erreur de type à la ligne " + cptLigne + ". Le type \"" + type + "\" est inconnu !" + " La suite du fichier n'a donc pas été prise en compte.");
            }
            cptLigne++;
        }
        System.out.println("\t - Aucune erreur détectée");
    }
    
    public static void afficherAnalyses(){
        System.out.println("----- Affichage des analyses -----");
        for (Analyse a:analyses){
            System.out.println(a);
        }
    }
    
    public static void main(String[] args){
        String localDir = System.getProperty("user.dir");
        if(System.getProperty("os.name").contains("Windows")){
            try{
                System.out.println("----- Chargement du fichier : LstAnalyses.csv -----");
                chargerAnalyses(FileToStr.lireFichier(localDir + "\\src\\LstAnalyses.csv"));
            }catch (TypeException e){
                System.out.println(e.getMessage());
            }
            try{
                System.out.println("----- Chargement du fichier : LstAnalyses2.csv  -----");
                chargerAnalyses(FileToStr.lireFichier(localDir + "\\src\\LstAnalyses2.csv" ));
            }catch (TypeException e){
                System.out.println(e.getMessage());
            }

        }else{
            try{
                System.out.println("----- Chargement du fichier : LstAnalyses.csv -----");
                chargerAnalyses(FileToStr.lireFichier(localDir + "/src/LstAnalyses.csv"));
                System.out.println("----- Chargement du fichier : LstAnalyses2.csv -----");
                chargerAnalyses(FileToStr.lireFichier(localDir + "/src/LstAnalyses2.csv"));
            }catch (TypeException e){
                System.out.println(e.getMessage());
            }
        }
        System.out.println("");
        afficherAnalyses();
    }
}
