import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.server.ExportException;
import java.util.ArrayList;
import java.util.HashMap;

public class GestionBoisson implements Stockable {
    private HashMap<Boisson, Integer> stockBoisson = new HashMap<>();
    private static final String CHOCOLAT = "Chocolat";
    private static final String MACCHIATO = "Macchiato";
    private static final String ESPRESSO = "Espresso";

    public void chargerData(String path){
        String[] lignes = FileToStr.lireCsv(path);
        for(String ligne : lignes){
            String[] valeurs = ligne.split(";");
            int quantite = Integer.parseInt(valeurs[0]);
            Boisson b;
            if (valeurs[1].equals(CHOCOLAT)){
                b = new Chocolat(valeurs[1], Double.parseDouble(valeurs[2]), Integer.parseInt(valeurs[3]), valeurs[4]);
            }else if (valeurs[1].equals(MACCHIATO)){
                b = new Macchiato(valeurs[1], Double.parseDouble(valeurs[2]), Integer.parseInt(valeurs[3]), valeurs[4], Integer.parseInt(valeurs[5]), Integer.parseInt(valeurs[6]));
            }else{
                b = new Espresso(valeurs[1], Double.parseDouble(valeurs[2]), Integer.parseInt(valeurs[3]), valeurs[4], Integer.parseInt(valeurs[5]), Integer.parseInt(valeurs[6]));
            }
            stockBoisson.put(b,quantite);
        }
    }

    @Override
    public void afficherStock() {
        for (Boisson b : stockBoisson.keySet()){
            if(stockBoisson.get(b) > 1) {
                System.out.println(b + " : " + stockBoisson.get(b) + " unités." + b.allergie());
            }else {
                System.out.println(b + " : " + stockBoisson.get(b) + " unités. /!\\ A réapprovisionner !"+ b.allergie());
            }
        }
    }

    @Override
    public void servirProduit(Boisson b)  {
        if (stockBoisson.get(b) == 0){
            System.out.println("Impossible de réaliser l'opération, le produit désiré n'est plus disponible.");
        }else{
            stockBoisson.replace(b,stockBoisson.get(b)-1);
            System.out.println(b + " servi. Santé !");
        }
    }


    public static void main(String[] args){
        GestionBoisson gB = new GestionBoisson();
        String localDir = System.getProperty("user.dir");
        gB.chargerData(localDir + File.separator +"src"+ File.separator +"stock.csv");
        System.out.println("------ Affichage du Stock ------- \n");
        gB.afficherStock();
        System.out.println();
        System.out.println("------ Ventes de produits ------- \n");
        Boisson b = new Chocolat("Chocolat",1.5, 25,"au lait");
        gB.servirProduit(b);
        gB.servirProduit(b);
        gB.servirProduit(b);
        System.out.println();
        System.out.println("------ Affichage du Stock ------- \n");
        gB.afficherStock();

    }
}
