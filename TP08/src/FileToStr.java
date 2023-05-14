//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class FileToStr {
    private static final int EOF = -1;
    private static final String DELIMITEURS_LIGNES = "\n\r";
    private static final String DELIMITEURS_DONNEES = ";\n\r\t\f";
    private static final String DELIMITEURS_MOTS = " .,;:-+*<>%/='\"()[]{}|!?\n\r\t\f0123456789";

    private FileToStr() {
    }

    private static String read(String fileName) {
        try {
            BufferedInputStream in = new BufferedInputStream(new FileInputStream(fileName));
            StringBuilder b = new StringBuilder(in.available());

            for(int c = in.read(); c != -1; c = in.read()) {
                b.append((char)c);
            }

            in.close();
            return b.toString();
        } catch (FileNotFoundException var4) {
            var4.printStackTrace();
            return "";
        } catch (IOException var5) {
            var5.printStackTrace();
            return "";
        }
    }

    public static ArrayList<String[]> lireFichier(String fileName) {
        String str = read(fileName);
        ArrayList<String[]> a = new ArrayList();
        StringTokenizer sT = new StringTokenizer(str, "\n\r");

        while(sT.hasMoreTokens()) {
            StringTokenizer sTL = new StringTokenizer(sT.nextToken(), ";\n\r\t\f");
            ArrayList<String> champs = new ArrayList();

            while(sTL.hasMoreTokens()) {
                champs.add(sTL.nextToken());
            }

            Object[] o = champs.toArray();
            String[] ligne = new String[o.length];

            for(int k = 0; k < o.length; ++k) {
                ligne[k] = (String)o[k];
            }

            a.add(ligne);
        }

        return a;
    }
}
