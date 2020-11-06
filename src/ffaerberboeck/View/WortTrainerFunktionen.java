package ffaerberboeck.View;

import ffaerberboeck.Model.WortEintrag;
import ffaerberboeck.Model.WortListe;
import ffaerberboeck.Model.WortTrainer;

/**
 * Diese Klasse ist eine Hilfsklasse die WortEinträge überprüft, sowie welche hinzufügt
 * @author Finn Färberböck
 * @version 06-11-2020
 */
public class WortTrainerFunktionen {
    private int richtig = 0;
    private int gesamt = 0;

    private String worteintrage[];



    /**
     * Diese Methode prüft das aktuelle Wort mit dem Input des Benutzers (übergeben aus dem Controller)
     * @param aktuellwort       Das aktuelle Wort
     * @param input             Der Input des Benutzers
     * @return                  Stimmt oder nicht
     */
    public boolean pruefe(String aktuellwort, String input) {
        boolean tf =false;
        if(aktuellwort.equals(input)) {
            richtig++;
            tf = true;
        }

        return tf;
    }


    /**
     * In dieser Methode werden WortEinträge hinzugefügt und in einem WortTrainer gespeichert
     * @return          Der WortTrainer
     */
    public WortTrainer addWortEintrage () {
        WortListe wl = new WortListe();
        WortEintrag wE1 = new WortEintrag("Apfel","https://www.lebensbaum.com/files/styles/greige_image_476x476/public/images/greiges/apfel-suesserapfel1_0.jpg?itok=6AGJQzt4");
        WortEintrag wE2 = new WortEintrag("Ananas","https://www.lecker.de/assets/styles/300x225/public/field/image/ananas.jpg?itok=7rGdshcC");
        WortEintrag wE3 = new WortEintrag("Banane","https://www.lecker.de/assets/styles/300x225/public/lecker/warenkunde/banane/banane-q.jpg?itok=XFQecVfF");
        WortEintrag wE4 = new WortEintrag("Birne","https://www.lecker.de/assets/styles/300x225/public/lecker/warenkunde/birne/birne-q.jpg?itok=k8G0oY1J");
        WortEintrag wE5 = new WortEintrag("Erdbeere","https://www.lecker.de/assets/styles/300x225/public/field/image/erdbeere-b3.jpg?itok=E3zYYeYg");
        WortEintrag wE6 = new WortEintrag("Himbeere","https://www.lecker.de/assets/styles/300x225/public/lecker/warenkunde/beeren_1/himbeeren_1/himbeeren-q.jpg?itok=2EOP3odF");
        WortEintrag wE7 = new WortEintrag("Kirsche","https://www.lecker.de/assets/styles/300x225/public/lecker/warenkunde/kirsche/kirsche-q.jpg?itok=ZUrPS7Qn");
        WortEintrag wE8 = new WortEintrag("Mango","https://www.lecker.de/assets/styles/300x225/public/field/image/mango-b.jpg?itok=WRRhJ00J");
        WortEintrag wE9 = new WortEintrag("Weintraube","https://www.lecker.de/assets/styles/300x225/public/lecker/warenkunde/hbv_20/weintraube-q.jpg?itok=DQDOYTob");
        WortEintrag wE10 = new WortEintrag("Zitrone","https://www.lecker.de/assets/styles/300x225/public/field/image/zitrone-b.jpg?itok=g8IzLBdh");
        WortEintrag wE11 = new WortEintrag("","https://2.bp.blogspot.com/-TsB8tkQdoQw/V96hiB5V87I/AAAAAAAAjWc/OlKppcaPcIsOKhEJKRJ2MTVtCVc7Jmz_gCLcB/s1600/ziel.png");
        wl.hinzuWort(wE1);
        wl.hinzuWort(wE2);
        wl.hinzuWort(wE3);
        wl.hinzuWort(wE4);
        wl.hinzuWort(wE5);
        wl.hinzuWort(wE6);
        wl.hinzuWort(wE7);
        wl.hinzuWort(wE8);
        wl.hinzuWort(wE9);
        wl.hinzuWort(wE10);
        WortTrainer wt = new WortTrainer(wl);
        return wt;
    }
}
