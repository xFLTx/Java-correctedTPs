public class Filiere {
    private String nomFiliere;
    private String domaine;

    public Filiere(String nomFiliere, String domaine) {
        this.nomFiliere = nomFiliere;
        this.domaine = domaine;
    }

    @Override
    public String toString() {
        return nomFiliere + " : " + domaine;
    }
}
