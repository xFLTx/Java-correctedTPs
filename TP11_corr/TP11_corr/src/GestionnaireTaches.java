import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class GestionnaireTaches {
    private static ArrayList<Tache> listeTaches = new ArrayList<>();

    public static void chargerDonnees(String[][] donnees) {

        for (String[] line : donnees) {
                int priorite = Integer.parseInt(line[0]);
                String dateEcheance = line[1];
                String description = line[2];
                listeTaches.add(new Tache(description,dateEcheance,priorite));
        }
    }

    public static void afficherTaches(String tri) {
        if (listeTaches.isEmpty()) {
            System.out.println("Aucune tâche à afficher.");
        } else {
            System.out.println("Liste des tâches triée via " + tri + " :");
            for (Tache tache : listeTaches) {
                System.out.println(tache);
            }
        }
        System.out.println("\n--------------------------------------\n");
    }



    public static void sauvegarderTachesDansCsv(String nomFichier) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(nomFichier));
            for (Tache tache : listeTaches) {
                writer.write(tache.toCsv());
                writer.newLine();
            }
            System.out.println("Le contenu trié a été sauvegardé dans le fichier " + nomFichier + ".");
            writer.close();
        } catch (IOException e) {
            System.out.println("Une erreur s'est produite lors de la sauvegarde dans le fichier.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        chargerDonnees(FileToStr.lireCsv("taches.csv"));
        afficherTaches("Aucun tri (ordre d'insertion)");
        Collections.sort(listeTaches, new ComparateurParPriorite());
        afficherTaches("tri priorite");
        Collections.sort(listeTaches, new ComparateurParDateEcheance());
        afficherTaches("tri date écheance");
        Collections.sort(listeTaches, new ComparateurParDescription());
        afficherTaches("tri description");
        Collections.sort(listeTaches, null);
        afficherTaches("tri naturel");
        sauvegarderTachesDansCsv("tachesTrieesNaturel.csv");
    }
}
