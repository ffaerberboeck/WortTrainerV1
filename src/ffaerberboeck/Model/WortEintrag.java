package ffaerberboeck.Model;
import java.util.regex.Pattern;
/**
 * Die Klasse Wort Eintrag ist eine Reine Rückgabe/Überprüf Klasse
 * @version 05-11-2020
 * @author Finn Färberböck
 */
public class WortEintrag {
    private String wort = "";
    private String url = "";



    /**
     * Der Konstruktor
     */
    public WortEintrag() {
        wort = "Wort";
        url = "https://test.com";
    }



    /**
     * Die Methode WortEintrag ist der Konstruktor mit Übergebenen Variablen
     * @param wortc      Der übergebene String vom Wort
     * @param urlc       Der übergebene String von der URL
     */
    public WortEintrag(String wortc, String urlc) {
        if(wortc.length() >= 2 && Pattern.matches("[a-zA-Z]+",wortc)) {
            this.wort = wortc;
        }
        else{
            IllegalArgumentException i = new IllegalArgumentException();
        }
        this.url = urlc;
    }



    /**
     * Diese Methode gibt das Attribut Wort zurück
     * @return Das Attribut Wort
     */
    public String getWort() {
        return this.wort;
    }



    /**
     * Dies Methode gibt das Attribut Url zurück
     * @return Das Attribut url
     */
    public String getUrl() {
        return this.url;
    }



    /**
     * Diese Methode überprüft eine übergebene URL auf Richtigkeit
     * @param url       Eine übergebene URL
     * @return          Ist die URL korrekt?
     */
    public static boolean checkURL(String url) {
        try {
            (new java.net.URL(url)).openStream().close();
            return true;
        } catch (Exception ex) { }
        return false;
    }



    /**
     * Diese Methode kombiniert das Wort mit einem Simikolon und der URL
     * @return          Das fertig kombinierte Wort
     */
    @Override
    public String toString() {
        String wortmisch = this.wort + ";" + this.url;
        return wortmisch;
    }
}
