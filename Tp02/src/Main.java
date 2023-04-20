public class Main {
    public static void main(String[] args) {
        // Création des instances
        Voiture v1 = new Voiture("Porsche", "Cayenne", 2007);
        Voiture v2 = new Voiture("Ford", "Fiesta", 2019);
        Voiture v3 = new Voiture("Audi", "S3", 2022);
        Maison m1 = new Maison(600,14,true,10800);
        Maison m2 = new Maison(200,8,true,7050);
        Maison m3 = new Maison(100,6,false,1600000);
        Personne p1 = new Personne("Dupont", "Paul", "Chemin de la route 35", 24,v2);
        Personne p2 = new Personne("Grosjean", "Felix", "Chemin de la rue 97", 37, m2);
        Personne p3 = new Personne("Harat", "Séverine", "Chemin de l'impasse 12", 58, v1, m1);
        Personne p4 = new Personne("Carat", "Aude", "Chemin du sentier 34", 19);
        Personne p5 = new Personne("Camar", "Jack", "Chemin de la route 35", 44);

        // Utilisation des accesseurs et mutateurs
        p5.setMaison(m3);  // La 5ème personne a acheté une maison...
        p5.setVoiture(v3); // et une voiture
        System.out.println("Prénom de la première personne enregistrée : " + p1.getPrenom());
        System.out.println();

        // Affichage des personnes
        System.out.println("Affichage des personnes");
        System.out.println("---------------------------------------------");
        System.out.println(p1.afficher());
        System.out.println(p2.afficher());
        System.out.println(p3.afficher());
        System.out.println(p4.afficher());
        System.out.println(p5.afficher());
    }
}
