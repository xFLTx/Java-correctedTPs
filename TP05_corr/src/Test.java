import java.util.*;

public class Test {
    private static ArrayList<Livre> livres = new ArrayList<>();
    private static HashMap<String, HashSet<Recette>> planning = new HashMap<>();
    private static final int NB_JOURS_PLANNING = 7;
    private static String[] jours = {"Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi", "Dimanche"};

    public static void chargerData(String path){
        String[] textRecette = FileToStr.lireCsv(path);
        String[] ligne = textRecette[0].split(",");
        Livre l = new Livre(ligne[0],ligne[1], Integer.parseInt(ligne[2]));
        for(int i = 1; i < textRecette.length; i++){
            ligne = textRecette[i].split(",");
            l.ajoutRecette(new Recette(ligne[0],Integer.parseInt(ligne[1]),Integer.parseInt(ligne[2]),Integer.parseInt(ligne[3])));
        }
        livres.add(l);
    }

    public static void genererPlanning(){
        Random random = new Random();
        for (int i = 0; i < NB_JOURS_PLANNING; i++){
            HashSet<Recette> plats = new HashSet<>();
            while (plats.size() != 2) {
                plats.add(livres.get(random.nextInt(livres.size())).getRecetteAleatoire());
            }
            planning.put(jours[i],plats);
        }
    }

    public static void afficherPlanning(){
        for (int i = 0; i < planning.size(); i++){
            System.out.println(jours[i]+ " : " + planning.get(jours[i]));
        }
    }

    public static void afficherLivres(){
        for (int i = 0; i < livres.size(); i++){
            System.out.println(livres.get(i));
        }
    }

    public static void rechercheRecette(Recette r){
        boolean trouve = false;
        for(Livre l : livres){
            if (l.contient(r)){
                System.out.println("Le livre \"" + l.getTitre() + "\" contient cette recette.");
                trouve = true;
            }
        }
        if (!trouve){
            System.out.println("Aucun livre ne contient cette recette.");
        }
    }

    public static void rechercheRecettePlanning(Recette r){
        boolean trouve = false;
        for(String key : planning.keySet()){
            Iterator<Recette> it = planning.get(key).iterator();
            while(it.hasNext())
                if (r.equals(it.next())){
                    System.out.println("Cette recette est prévue : " + key);
                    trouve = true;
                }
            }
             /*
            for(Recette recette : planning.get(key)){
                if (r.equals(recette)){
                    System.out.println("Cette recette est prévue : " + key);
                    trouve = true;
                }
            }*/
        if (!trouve){
            System.out.println("Le planning ne contient pas cette recette.");
        }
    }

    public static void main(String[] args){
        String localDir = System.getProperty("user.dir");
        chargerData(localDir + "\\src\\livre1.csv");
        chargerData(localDir + "\\src\\livre2.csv");
        afficherLivres();
        genererPlanning();
        afficherPlanning();
        System.out.println("");
        rechercheRecette(new Recette("Jaret de porc",10,2,60));
        rechercheRecette(new Recette("Jaret de boeuf",10,2,60));
        rechercheRecettePlanning(new Recette("Jaret de porc",10,2,60));
    }
}
