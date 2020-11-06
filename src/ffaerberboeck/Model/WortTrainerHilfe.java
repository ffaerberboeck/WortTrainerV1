package ffaerberboeck.Model;

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;
/**
 * Dise Klasse soll den WortTrainer unter einem angegebenen Pfad speichern
 * @version 05-11-2020
 * @author Finn Färberböck
 */

public class WortTrainerHilfe {
    private FileWriter fw;
    private BufferedReader br;



    /**
     * Diese Methode speichert eine WortTrainer Datei unter einem angegebenen Pfad
     * @param pfad          Der beliebige Pfad
     * @param wtc           Der ausgefüllte WortTrainer
     * @throws IOException
     */
    public static void speichern(String pfad, WortTrainer wtc) throws IOException {
        File f = new File(pfad);
        BufferedWriter outputStream = null;
        try{
            outputStream = new BufferedWriter(new FileWriter(f));

            for(int z = 0; z < wtc.leange();z++) {
                outputStream.write(wtc.getWortEintrag(z).toString());
                outputStream.write(System.lineSeparator());
            }
        }finally{
            if(outputStream != null) {
                outputStream.close();
            }
        }
    }






    /**
     * Diese Methode speichert ein WortTrainer Objekt auf einem Default Pfad mit einem WortTrainer Objekt
     * @param wtc   Der ausgefüllte WortTrainer
     * @throws IOException
     */
    public static void speicherndefault(WortTrainer wtc) throws IOException {
        WortTrainerHilfe.speichern("Worttrainer.txt", wtc);
    }



    /**
     * Diese Methode lädt den Worttrainer aus einem angegebenen Pfad und stellt ihn wieder her
     * @param pfad  Der beliebige Pfad
     * @return      Der fertige WortTrainer
     * @throws IOException
     */
    public static WortTrainer laden(String pfad) throws IOException {
        WortListe liste = new WortListe();
        WortTrainer wt = new WortTrainer(liste);

        File f = new File(pfad);
        BufferedReader inputStream = null;

        try {
            inputStream = new BufferedReader(new FileReader(f));
            Scanner s = new Scanner(inputStream);
            s.useDelimiter(Pattern.compile(";|(\\n)"));


            String wort, url;

            while (s.hasNext()) {
                wort = s.next();
                url = s.next();
                liste.hinzuWort(new WortEintrag(wort, url));
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
        return wt;
    }




    /**
     * Diese Methode lädt den Worttrainer aus einem standart Pfad und stellt ihn wieder her
     * @return      Der fertige WortTrainer
     * @throws IOException
     */
    public static WortTrainer ladedefault() throws IOException{
        WortTrainer wt = WortTrainerHilfe.laden("Worttrainer.txt");
        return wt;
    }
}
