import java.util.ArrayList;

public class Restaurant
{
    // instance variables - replace the example below with your own
    private static ArrayList<Menu> menus;
    
    /**
     * Faites vos instances et appels de méthode ici
     */
    private static void recherchePlat(Plat p)
    {
        boolean trouve = false;
        for(Menu m : menus){
            if (m.recherchePlatMenu(p)){
                System.out.println("\tLe plat " + p + "se trouve dans le " + m);
                trouve = true;
            }
        }
        if(!trouve){
            System.out.println("\tLe plat " + p + "n'est dans aucun menu.");
        }
    }
    
    
    /**
     * Faites vos instances et appels de méthode ici
     */
    public static void main(String[] args)
    {
        Plat p1 = new Plat("Cassoulet", "Plat");
        Plat p2 = new Plat("Pâtes au saumon", "Plat");
        Plat p3 = new Plat("Salade verte", "Entrée");
        Plat p4 = new Plat("Assiette Valaisanne", "Entrée/Plat");
        Plat p5 = new Plat("Coupe Danemark", "Dessert");
        Plat p6 = new Plat("Quiche Lorraine", "Plat");
        Plat p7 = new Plat("Pizza 4 saisons", "Plat");
        Plat p8 = new Plat("Tartare d'aubergines", "Entrée");
        Plat p9 = new Plat("Salade Niçoise", "Entrée/Plat");
        Plat p10 = new Plat("Profiteroles", "Dessert");
        Menu m1 = new Menu("du jour", 35);
        Menu m2 = new Menu("de saison", 40);
        Menu m3 = new Menu("duo", 60);
        Menu m4 = new Menu("enfant", 25);
        Menu m5 = new Menu("découverte", 45);
        m1.addPlat(p1); m1.addPlat(p10);
        m2.addPlat(p9); m2.addPlat(p1); m2.addPlat(p10);
        m3.addPlat(p1); m3.addPlat(p2); m3.addPlat(p3); m3.addPlat(p4); m3.addPlat(p5);
        // Test erreur 6 plats
        m3.addPlat(p1);
        m4.addPlat(p1); m4.addPlat(p2);
        m5.addPlat(p7); m5.addPlat(p2); m5.addPlat(p3); m5.addPlat(p8);
        menus = new ArrayList<>();
        menus.add(m1); menus.add(m2); menus.add(m3); menus.add(m4); menus.add(m5);
        System.out.println("\nRecherche de " + p1);
        recherchePlat(p1);
        System.out.println("\nRecherche de " + p6);
        recherchePlat(p6);
    }
}
