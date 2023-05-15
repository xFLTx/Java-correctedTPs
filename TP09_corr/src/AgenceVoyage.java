import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class AgenceVoyage implements IGestionnaireVoyage {
    private ArrayList<Voyage> voyagesReserves;

    public AgenceVoyage() {
        voyagesReserves = new ArrayList<>();
    }

    public void chargerDonnees(String path){
        try{
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String line = reader.readLine();
            while(line != null){
                String[] ligne = line.split(";");
                if(ligne.length == 5){
                    voyagesReserves.add(new VoyageAvecVoiture(Integer.parseInt(ligne[0]),ligne[1], ligne[2], Double.parseDouble(ligne[3]), ligne[4]));
                }else{
                    VoyageGroupe v = new VoyageGroupe(Integer.parseInt(ligne[0]),ligne[1], ligne[2], Double.parseDouble(ligne[3]));
                    for(int i = 4; i < ligne.length; i++){
                        v.ajouterParticipant(ligne[i]);
                    }
                    voyagesReserves.add(v);
                }
                line = reader.readLine();
            }
            reader.close();
        }catch (FileNotFoundException e){
            System.out.println("--------- Erreur de fichier ---------");
            System.out.println("Le fichier "+ path + " spécifié n'existe pas.");
            System.out.println();
        }catch (IOException e){
            System.out.println("Problème de lecture/fermeture du fichier.");
        }
    }

    public void reserverVoyage(Voyage voyage) throws VoyageDejaReserveException {
        for (Voyage v : voyagesReserves) {
            if (voyage.equals(v)) {
                throw new VoyageDejaReserveException("Le voyage " + voyage.getId() + " a déjà été réservé !");
            }
        }
        voyagesReserves.add(voyage);
        System.out.println("Le voyage " + voyage.getId()  + " a été réservé.");
    }

    public void afficherVoyagesReserves() {
        System.out.println("Voyages réservés :");
        for (Voyage v : voyagesReserves) {
            System.out.println("- " + v.toString());
        }
    }

    public void supprimerVoyageReserve(Voyage v) throws VoyageNonTrouveException {
        boolean trouve = false;
        Iterator<Voyage> it = voyagesReserves.iterator();
        while (it.hasNext()){
            Voyage vo = it.next();
            if(v.equals(vo)){
                it.remove();
                trouve = true;
                System.out.println("Le voyage " + v.getId()  + " a été supprimé.");
                break;
            }
        }
        if(!trouve){
            throw new VoyageNonTrouveException("Le voyage ayant l'id " + v.getId() + " est introuvable.");
        }
    }

    public static void main(String[] args) {
        AgenceVoyage aV = new AgenceVoyage();
        String localDir = System.getProperty("user.dir");
        if(System.getProperty("os.name").contains("Windows")){
            aV.chargerDonnees(localDir + "\\src\\LstVoyage.csv");
            aV.chargerDonnees(localDir + "\\src\\LstVoyage2.csv");
        }else{
            aV.chargerDonnees(localDir + "/src/LstVoyage.csv");
            aV.chargerDonnees(localDir + "/src/LstVoyage2.csv");
        }
        aV.afficherVoyagesReserves();
        System.out.println();
        try{
            aV.reserverVoyage(new VoyageAvecVoiture(121,"Genève", "25.06.2023", 550.40, "Simon"));
            aV.reserverVoyage(new VoyageAvecVoiture(121,"Genève", "25.06.2023", 550.40, "Simon"));
        }catch(VoyageDejaReserveException e){
            System.out.println("--------- Erreur de réservation ---------");
            System.out.println(e.getMessage());
        }
        System.out.println();
        System.out.println("------- Affichage après ajout -------");
        aV.afficherVoyagesReserves();
        System.out.println();
        try{
            aV.supprimerVoyageReserve(new VoyageAvecVoiture(121,"Genève", "25.06.2023", 550.40, "Simon"));
            aV.supprimerVoyageReserve(new VoyageAvecVoiture(121,"Genève", "25.06.2023", 550.40, "Simon"));
        }catch(VoyageNonTrouveException e){
            System.out.println("--------- Erreur de suppression ---------");
            System.out.println(e.getMessage());
            System.out.println();
        }
        System.out.println("------- Affichage après suppression -------");
        aV.afficherVoyagesReserves();
    }
}
