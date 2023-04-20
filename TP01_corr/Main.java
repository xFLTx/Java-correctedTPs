public class Main {
    public static void main(String[] args) {
        Entreprise e = new Entreprise("Agrofi", "Chemin de l'usine 82b", "Privée", 3, "Alimentaire", 42, "Charles Agrofi");
        e.afficher(true);
        e.changerNbBatiment(5);
        e.afficher(true);
        e.changerType("Publique");
        e.afficher(true);
        Employe emp = new Employe("Dupont", "Jean", "Chemin de la route 35", "Comptable", 7, 10000);
        emp.afficher();
    }
}