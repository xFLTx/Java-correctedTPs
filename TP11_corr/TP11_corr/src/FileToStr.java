import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Lecture d'un fichier texte dans un String / dans un tableau de String
 *
 * @author PD, CSI, DZI - HEG-Genève
 * @version Version 3.1 - 24.04.2023
*/
public class FileToStr {

	private static final int EOF = -1;
	private static final String DELIMITEURS_LIGNES = "\n\r";
	private static final String DELIMITEURS_DONNEES = ";\n\r\t\f";
	private static final String DELIMITEURS_MOTS = " .,;:-+*<>%/='\"()[]{}|!?\n\r\t\f0123456789";

	/** Lecture d'un fichier texte dans un String. 
		Lit le fichier dont le nom est précisé en paramètre et retourne son contenu dans un String. 
		Si le fichier n'existe pas ou s'il y a une erreur de lecture, le String vide est retourné. 
		@param fileName Le nom du fichier texte à lire.
		@return le String contenant l'ensemble des caractères du fichier lu. */
	public static String read(String fileName) {
		try {
			//Tentative d'ouverture de fichier et de chargement dans une mémoire tampon
			BufferedInputStream in = new BufferedInputStream(new FileInputStream(fileName));
			//Tentative d'accès au flux de données chargé dans le tampon (ex: fichier pas fermé, connexion ok)
			StringBuilder b = new StringBuilder(in.available());
			//fichier est disponible ET qu'on peut y accéder maintenant
			int c = in.read();
			while (c != EOF) { //lecture jusqu'à la fin du fichier
				//conversion décimal => charactères à travers la table ASCII
				b.append((char)c);
				c = in.read();
			}
			in.close();
			return b.toString();
		}
		catch (FileNotFoundException e0) {
			e0.printStackTrace();
			return "";
		}
		catch (IOException e1) {
			e1.printStackTrace();
			return "";
		}
	}

	/** Lecture d'un fichier texte dans un String[][].
		Lit le fichier dont le nom est précisé en paramètre, le découpe par ligne, et découpe chaque ligne par champ.
		Si le fichier n'existe pas ou s'il y a une erreur de lecture, un tableau de taille 0 est retourné.
		@param fileName Le nom du fichier texte à lire.
		@return le String[][] contenant l'ensemble des lignes du fichier lu, découpées par champ. */
	public static String[][] lireCsv(String fileName) {
		//Lire fichier
		String str = read(fileName);
		//retour du fichier dans la chaine de char
		List<String[]> a = new ArrayList<>();
		int nbChamps = 0;
		StringTokenizer sT = new StringTokenizer(str, DELIMITEURS_LIGNES);
		while (sT.hasMoreTokens()) {
			StringTokenizer sTL = new StringTokenizer(sT.nextToken(), DELIMITEURS_DONNEES);
			List<String> lstChamps = new ArrayList<>();
			while (sTL.hasMoreTokens()) {
				lstChamps.add(sTL.nextToken());
			}
			Object[] o = lstChamps.toArray();
			nbChamps = o.length;
			String[] res = new String[o.length];
			for (int k = 0; k < o.length; k++) {
				res[k] = (String)o[k];
			}
			a.add(res);
		}
		//Création d'une matrice de String à partir d'une ArrayList
		Object[] o = a.toArray();
		String[][] res = new String[o.length][nbChamps];
		for (int k = 0; k < o.length; k++) {
			res[k] = (String[])o[k];
		}
		return res;
	}

	/** Lecture d'un fichier texte dans un tableau de String, décomposé selon les délimiteurs indiqués.
		Lit le fichier dont le nom est précisé en paramètre, le découpe selon les délimiteurs, et retourne le contenu sous forme d'un String[].
		Si le fichier n'existe pas ou s'il y a une erreur de lecture, un tableau de taille 0 est retourné.
		@param fileName Le nom du fichier texte à lire.
		@param delim La liste des délimiteurs.
		@return le String[] contenant l'ensemble des mots du fichier lu. */
	public static String[] lireChamps(String fileName, String delim) {
		String str = read(fileName);
		List<String> a = new ArrayList<>();
		StringTokenizer sT = new StringTokenizer(str, delim);
		while (sT.hasMoreTokens()) {
			a.add(sT.nextToken());
		}
		Object[] o = a.toArray(); String[] res = new String[o.length];
		for (int k = 0; k < o.length; k++) {
			res[k] = (String)o[k];
		}
		return res;
	}

	/** Lecture d'un fichier texte dans un tableau de String.
		Lit le fichier dont le nom est précisé en paramètre, le découpe par ligne, et retourne les lignes sous forme d'un String[].
		Si le fichier n'existe pas ou s'il y a une erreur de lecture, un tableau de taille 0 est retourné.
		@param fileName Le nom du fichier texte à lire.
		@return le String[] contenant l'ensemble des lignes du fichier lu. */
	public static String[] lireLignes(String fileName) {
		return lireChamps(fileName, DELIMITEURS_LIGNES);
	}

   /** Lecture d'un fichier texte dans un tableau de String.
		Lit le fichier dont le nom est précisé en paramètre, le découpe par champ (";\n\r\t\f"), et retourne les champs sous forme d'un String[].
		Si le fichier n'existe pas ou s'il y a une erreur de lecture, un tableau de taille 0 est retourné.
		@param fileName Le nom du fichier texte à lire.
		@return le String[] contenant l'ensemble des champs du fichier lu. */
	public static String[] lireDonnees(String fileName) {
		return lireChamps(fileName, DELIMITEURS_DONNEES);
	}

	/** Lecture d'un fichier texte dans un tableau de String.
		Lit le fichier dont le nom est précisé en paramètre, le découpe par mot (" .,;:-+*<>%/='\"()[]{}|!?\n\r\t\f0123456789"), et retourne les mots sous forme d'un String[].
		Si le fichier n'existe pas ou s'il y a une erreur de lecture, un tableau de taille 0 est retourné.
		@param fileName Le nom du fichier texte à lire.
		@return le String[] contenant l'ensemble des mots du fichier lu. */
	public static String[] lireMots(String fileName) {

		return lireChamps(fileName, DELIMITEURS_MOTS);
	}

   /** Ecriture d'un String[] dans un fichier texte.
      @param fileName Le nom du fichier texte.
      @param str le String[] contenant les lignes à écrire. */
   public static void writeLignes(String fileName, ArrayList<String> str) {
      try {
         OutputStreamWriter w = new OutputStreamWriter(new FileOutputStream(fileName), java.nio.charset.Charset.forName("ISO-8859-1"));
		  for (String s:str) {
			  w.write(s, 0, s.length());
			  w.write("\r	\n", 0, 2);
		  }
         w.close();
      }
      catch (FileNotFoundException e0) {
		  e0.printStackTrace();}
      catch (IOException e1) {
		  e1.printStackTrace();
	  }
   }

} // FileToStr