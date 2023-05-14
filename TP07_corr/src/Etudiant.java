import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

import static java.lang.Math.round;

public class Etudiant {
    private int id;
    private String nom;
    private String prenom;

    private Filiere filiere;
    private HashMap<String, ArrayList<Note>> notes = new HashMap<>();

    public Etudiant(int id, String nom, String prenom, Filiere filiere) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.filiere = filiere;
    }

    public Etudiant(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public Etudiant(int id) {
        this.id = id;
    }

    public void afficheMoyenne(){
        System.out.println(this);
        double moyenneGenerale = 0;
        for(String key : notes.keySet()){
            double moyenne = round(moyenne(notes.get(key)) * 10.0) / 10.0;
            System.out.println("\t" + key + " : " + moyenne);
            moyenneGenerale += moyenne;
        }
        System.out.println("Moyenne générale : " + round(moyenneGenerale/notes.size()*10.0)/10.0);
        System.out.println("--------------------");
    }

    public double moyenne(ArrayList<Note> aL){
        double moyenne = 0;
        int sommeCoef = 0;
        for (Note n : aL){
            moyenne += n.getResultat() * n.getCoefficient();
            sommeCoef += n.getCoefficient();
        }
        return moyenne/sommeCoef;
    }

    public void ajoutNote(String cours, Note note){
        if(notes.containsKey(cours)){
            notes.get(cours).add(note);
        }else{
            ArrayList<Note> notesTemp = new ArrayList<>();
            notesTemp.add(note);
            notes.put(cours, notesTemp);
        }

    }

    public void afficheNotes(){
        System.out.println(this);
        for(String key : notes.keySet()){
            System.out.print(key + " : [");
            System.out.print(notes.get(key).get(0));
            for (int i = 1; i < notes.get(key).size(); i++){
                System.out.print(" ; " + notes.get(key).get(i));
            }
            System.out.println("]");
        }
    }

    public double getMoyenneMatiere(String cours){
        return moyenne(notes.get(cours));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Etudiant etudiant = (Etudiant) o;
        return id == etudiant.id || Objects.equals(nom, etudiant.nom) && Objects.equals(prenom, etudiant.prenom);
    }

    public String toString(){
        return nom + " " + prenom;
    }
}
