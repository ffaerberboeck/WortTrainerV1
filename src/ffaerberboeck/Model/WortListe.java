package ffaerberboeck.Model;
/**
 * Diese Klasse arbeitet um ein Array und bildet eine WortListe
 * @author Finn Färberböck
 * @version 06-11-2020
 */
public class WortListe {
    private WortEintrag[] weintrag;

    /**
     * Der Konstruktor setzt den WortEintrag auf 0
     */
    public WortListe() {
        weintrag = new WortEintrag[0];
    }


    /**
     * Hier wird das aktuelle Wort von WortEintrag zurückgegeben
     * @return das aktuelle Wort in String Form
     */
    public String aktuell() {
        String wort;
        wort = weintrag[weintrag.length-1].getWort();
        return wort;
    }



    /**
     * Fügt ein WortEintrag zur Liste hinzu.
     * @param wEintrag      Der WortEintrag
     */
    public void hinzuWort(WortEintrag wEintrag) {
        WortEintrag[] temp = new WortEintrag[weintrag.length+1];
        for (int i = 0; i < weintrag.length; i++) {
            temp[i] = weintrag[i];
        }
        temp[temp.length-1] = wEintrag;
        weintrag = temp;
    }



    /**
     * Erstellt erst ein WortEintrag und fuegt es anschliessend zur Liste bzw. zum Objekt hinzu.
     * @param wort          Das Wort fuer den WortEintrag
     * @param url           Die dazugehoerende URL fuer den WortEintrag
     */
    public void addWort(String wort, String url) {
        this.hinzuWort(new WortEintrag(wort, url));
    }



    /**
     * Gibt die größe des Arrays zurück
     * @return              Die Größe
     */
    public int wiegroßarray() {
        return weintrag.length;
    }



    /**
     * Diese Methode gibt das Wort von einem bestimmten Index zurück
     * @param index         Die zurückzugebene Stelle
     * @return              Der dazupassende Text
     */
    public WortEintrag returnWortEintrag(int index) throws RuntimeException{
        if (index >= 0 && index < weintrag.length) {
            return weintrag[index];
        }
        throw new RuntimeException("ungültger Index!");
    }



    /**
     * Diese Methode löscht ein beliebeiges Wort des Array
     * @param wort          Das zu löschende Wort
     * @return              Hat es geklappt?
     */
    public boolean loescharray(String wort) {
        for (int i = 0; i < weintrag.length; i++) {
            if (weintrag[i].getWort().equals(wort)) {
                weintrag[i] = null;
                WortEintrag[] wE = new WortEintrag[weintrag.length-1];
                int iT = 0;
                for (int iK = 0; iK < weintrag.length; iK++) {
                    if(weintrag[iK] != null) {
                        wE[iT] = weintrag[iK];
                        iT++;
                    }
                }
                weintrag = wE;
                return true;
            }
        }
        return false;
    }



    /**
     * Diese Methode gibt das Array in String form zurück mit den wörtern jeweils in jede einzelne Zeile separiert
     * @return              Der fertige Text
     */
    @Override
    public String toString(){
        String text = "";
        for(int i = 0; i < weintrag.length && weintrag[i] != null; i++) {
            if(i > 0) {
                text += "\n";
            }
            text += (weintrag[i].toString());
        }
        return text;
    }
}
