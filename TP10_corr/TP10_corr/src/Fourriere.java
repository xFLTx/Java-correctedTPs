import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Fourriere {
    private static ArrayList<Vehicule> vehicules = new ArrayList<>();
    private static HashMap<String, ArrayList<Vehicule>> vehiculesParEtat = new HashMap<>();


    private static void afficherParTypeVehicule(){
        System.out.println("_________ Affichage par type de véhicule __________");
        String affichage = "------------------\n";
        for (Vehicule v : vehicules){
            affichage = v.ajoutAffichage(affichage);
        }
        System.out.println(affichage);
    }

    private static void afficherParEtat(){
        System.out.println("_________ Affichage par etat __________");
        for(String key : vehiculesParEtat.keySet()){
            System.out.println("--- " + key + " ---");
            for (Vehicule v : vehiculesParEtat.get(key)){
                System.out.print(v);
            }
        }
    }

    private static void insertionHashMap(Vehicule v, String etat){
        if (vehiculesParEtat.containsKey(etat)){
            vehiculesParEtat.get(etat).add(v);
        }else{
            ArrayList<Vehicule> aL = new ArrayList<>();
            aL.add(v);
            vehiculesParEtat.put(etat,aL);
        }
    }

    private static void liberationVehicule(){
        Iterator<Vehicule> it = vehicules.iterator();
        while(it.hasNext()){
            Vehicule v = it.next();
            if (v.getEtat().equals("Abandon") || v.getEtat().equals("Casse")){
                it.remove();
            }
        }
        vehiculesParEtat.remove("Abandon");
        vehiculesParEtat.remove("Casse");
    }

    private static void chargerDonnees(String path){
        String[] lignes = FileToStr.lireCsv(path);
        for(String ligne : lignes){
            String[] tabLigne = ligne.split(";");
            if (tabLigne[0].equals("Moto")){
                Moto m = new Moto(tabLigne[1], tabLigne[2] , tabLigne[3] , tabLigne[4], Integer.parseInt(tabLigne[5]));
                vehicules.add(m);
                insertionHashMap(m,tabLigne[4]);
            }else if (tabLigne[0].equals("Voiture")){
                Voiture v = new Voiture(tabLigne[1], tabLigne[2] , tabLigne[3] ,  tabLigne[4], Integer.parseInt(tabLigne[5]));
                vehicules.add(v);
                insertionHashMap(v,tabLigne[4]);
            }
        }
    }

    public static void main(String[] args) {
        String localDir = System.getProperty("user.dir");
        if(System.getProperty("os.name").contains("Windows")){
            chargerDonnees(localDir + "\\src\\vehicules.csv");
        }else{
            chargerDonnees(localDir + "/src/vehicules.csv");
        }
        afficherParTypeVehicule();
        afficherParEtat();
        liberationVehicule();
        System.out.println();
        afficherParTypeVehicule();
        afficherParEtat();
    }
}
