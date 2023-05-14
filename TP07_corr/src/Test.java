import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Test {
    private static ArrayList<Etudiant> etudiants = new ArrayList<>();
    private static HashSet<String> cours = new HashSet<>();

    private static void chargerDonneesEtudiants(String path){
        String[] valEtudiants = FileToStr.lireCsv(path);
        for(int i = 0; i < valEtudiants.length; i++){
            String[] ligne = valEtudiants[i].split(";");
            etudiants.add(new Etudiant(Integer.parseInt(ligne[0]), ligne[1], ligne[2], new Filiere(ligne[3],ligne[4])));
        }
    }

    private static void chargerDonneesNotes(String path){
        String[] valNotes = FileToStr.lireCsv(path);
        for(int i = 0; i < valNotes.length; i++){
            String[] ligne = valNotes[i].split(";");
            cours.add(ligne[1]);
            Etudiant et = new Etudiant(Integer.parseInt(ligne[0]));
            for (Etudiant e : etudiants){
                if (et.equals(e)){
                    e.ajoutNote(ligne[1], new Note(Double.parseDouble(ligne[2]), Integer.parseInt(ligne[3])));
                    break;
                }
            }
        }
    }

    private static void afficheMoyenneEtudiant(){
        for(Etudiant e: etudiants){
            e.afficheMoyenne();
        }
    }

    private static void afficheNoteEtudiant(Etudiant e){
        for(Etudiant etu: etudiants){
            if(e.equals(etu)){
                etu.afficheNotes();
            }
        }
    }

    private static void afficheMoyenneParMatiere(){
        System.out.println("Moyenne par cours :");
        for (String c: cours){
            System.out.println(c + " : ");
            double moyenne = 0;
            for (Etudiant etu: etudiants) {
                moyenne += etu.getMoyenneMatiere(c);
            }
            System.out.println(Math.round(moyenne/etudiants.size()*10.0)/10.0);
        }

    }

    public static void main(String[] args) {
        String localDir = System.getProperty("user.dir");
        if(System.getProperty("os.name").contains("Windows")){
            chargerDonneesEtudiants(localDir + "\\src\\etudiants.csv");
            chargerDonneesNotes(localDir + "\\src\\notes.csv");
        }else{
            chargerDonneesEtudiants(localDir + "/src/etudiants.csv");
            chargerDonneesNotes(localDir + "/src/notes.csv");
        }

        afficheMoyenneEtudiant();
        System.out.println();
        afficheNoteEtudiant(new Etudiant("Cerizo","Cecilia"));
        System.out.println();
        afficheMoyenneParMatiere();
    }
}
