package ffaerberboeck.Model;

import java.util.Random;
/**
 * Diese Klasse ist der Wort Trainer und ist der Motor der Klassen
 * @version 05-11-2020
 * @author Finn Färberböck
 */
public class WortTrainer {
    private WortListe wListe;
    private int zahl;



    /**
     * Der Konstruktor der ein WortListe Objekt übernimmt
     * @param lc    Die WortListe
     */
    public WortTrainer(WortListe lc) {
        this.wListe = lc;
        zahl = 0;
    }


    /**
     * Das aktuelle Wort von WortEintrag
     * @return      das aktuelle Wort in String Form
     */
    public String aktuell() {
        return wListe.aktuell();
    }



    /**
     * Diese Methode sucht ein Zufalls Wort
     * @return      das Wort
     */
    public WortEintrag zufallWort() {
        Random zufall = new Random();
        zahl = zufall.nextInt(wListe.wiegroßarray());
        return wListe.returnWortEintrag(zahl);
    }



    /**
     * Diese Methode sucht ein Index Wort
     * @return      das Wort
     */
    public WortEintrag getWortEintrag(int index) {
        return wListe.returnWortEintrag(index);
    }


    /**
     * Die Länge des Arrays
     * @return      Die Länge in int
     */
    public int leange() {
        int z =0;
        z = wListe.wiegroßarray();
        return z;
    }



    /**
     * getter für Zahl
     * @return      Die akteulle Zahl
     */
    public int getZahl() {
        return this.zahl;
    }



    /**
     * Diese Methode checkt das aktuelle Wort
     * @param wort  Das Wort was gecheckt werden soll
     * @return      stimmt das Wort?
     */
    public boolean aktuellWortcheck(String wort) {
        if (wListe.returnWortEintrag(zahl).getWort().equals(wort)) {
            return true;
        }
        return false;

    }



    /**
     * Diese Methode checkt das aktuelle Wort auf gleiche Buchstaben groß/klein ist egal
     * @param wort          Das zu checkende Wort
     * @return              stimmt das Wort
     */
    public boolean aktuelWortcheckkg(String wort) {
        if (wListe.returnWortEintrag(zahl).getWort().toLowerCase().equals(wort.toLowerCase())) {
            return true;
        }
        return false;
    }


    /**
     * Hier wird der WortTrainer in String Form umgewandelt
     * @return      Der fertige String
     */
    public String toString() {
        String str = wListe.toString();
        return str;
    }
}
