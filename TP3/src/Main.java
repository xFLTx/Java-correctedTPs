public class Main {

    public static void comparerEcole(Ecole e1, Ecole e2){
        if(!e1.equals(e2)){
            System.out.println(e1 + "\n--------- n'est pas égal à ---------\n" + e2);
        }else{
            System.out.println(e1 + "\n--------- est égal à ---------\n" + e2);
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {
        Ecole e1 = new Ecole("Haute école de gestion", "Route de drize 19", "Publique", 5, "Tertiaire", "Gestion", 1500 );
        Ecole e2 = new Ecole("Schultz", "Route du lac 29", "Privée", 2, "Secondaire", "Economie", 200 );
        Ecole e3 = new Ecole("Collège Saint-Louis", "Route de Corzier 23", "Privée", 3, "Secondaire", "Général", 400 );
        Ecole e4 = new Ecole("Collège Saint-Louis", "Route de Corzier 23", "Privée", 1, "Secondaire", "Mathématiques", 50 );
        Ecole e5 = new Ecole("Collège de Carouge", "Route des centenaires 34", "Publique", 4, "Secondaire", "Général", 1500 );
        Ecole e6 = new Ecole("Collège de Carouge", "Route des centenaires 34", "Publique", 4, "Secondaire", "Général", 500 );

        System.out.println("Affichage des écoles :\n--------------------------------");
        System.out.println(e1);
        System.out.println(e2);
        System.out.println(e3);
        System.out.println(e4);
        System.out.println(e5);
        System.out.println(e6);

        System.out.println("\nTest des égalités entre écoles\n----------------------");
        comparerEcole(e3,e4);
        comparerEcole(e5,e6);
    }
}