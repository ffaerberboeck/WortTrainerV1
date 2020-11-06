package ffaerberboeck;
import ffaerberboeck.Model.WortTrainerHilfe;
import ffaerberboeck.Model.WortTrainer;
import ffaerberboeck.Model.WortListe;
import ffaerberboeck.Model.WortEintrag;
import ffaerberboeck.View.WortFrame;
import ffaerberboeck.View.WortPanel;
import ffaerberboeck.View.WortTrainerFunktionen;

import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.MalformedURLException;

/**
 * Diese Klasse ist der Controller, er verlinkt die Klassen
 * @author Finn Färberböck
 * @version 06-11-2020
 */
public class WortControl implements ActionListener{
    private WortPanel wPanel;
    private WortFrame wFrame;
    private WortEintrag wEintrag;
    private WortListe wListe;
    private WortTrainer wTrainer;
    private WortTrainerHilfe wHilfe;
    private WortTrainerFunktionen wTrainerfunktionen;

    private String wort, url;
    private int z = 0;
    /**
     * Der Konstruktor, welcher Standart Werte in die Objekte speichert, um das Programm zu testen.
     */
    public WortControl() throws MalformedURLException {

        wPanel = new WortPanel(this);
        wFrame = new WortFrame("Wort-Trainer", wPanel);
        wTrainerfunktionen = new WortTrainerFunktionen();
        wTrainer = wTrainerfunktionen.addWortEintrage();


    }

    /**
     * Durch ein Event werden hier Aktionen getätigt
     * @param e Das ActionEvent
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String ac = e.getActionCommand();
        try {
            if(ac.equals("hinzu")) {
                    String inputhinzu = wPanel.returnText();
                    wEintrag = wTrainer.getWortEintrag(z);
                    this.wort = wEintrag.getWort();
                    this.url = wEintrag.getUrl();
                    wPanel.setImage(url);


                    boolean tf = wTrainerfunktionen.pruefe(wort, inputhinzu);
                    if (tf == true) {
                        wPanel.richtig();
                        z++;
                        wEintrag = wTrainer.getWortEintrag(z);
                        this.url = wEintrag.getUrl();
                        wPanel.setImage(url);
                        wPanel.setTextleer();
                    } else {
                        wPanel.falsch();
                    }
            }
            if(ac.equals("zurueck")) {
                wPanel.setTextleer();
                z = 0;
                wEintrag = wTrainer.getWortEintrag(z);
                this.url = wEintrag.getUrl();
                wPanel.setImage(url);
                wPanel.reset();
            }
            if(ac.equals("s")) {
                String pfad = wPanel.returnpfadspeichern();
                wHilfe.speichern(pfad,wTrainer);
            }
            if(ac.equals("l")) {
                String pfad = wPanel.returnpfadladen();
                WortTrainer wt = wTrainer;
                wt = wHilfe.laden(pfad);
                String outputladen = wt.toString();
                System.out.println(outputladen);
                wTrainer = wt;
            }
            if(ac.equals("sd")) {
                wHilfe.speicherndefault(wTrainer);
            }
            if(ac.equals("ld")) {
                WortTrainer wt = wTrainer;
                wt = wHilfe.ladedefault();
                String outputladen = wt.toString();
                System.out.println(outputladen);
                wTrainer = wt;
            }

        }catch(IOException ex) {
            JOptionPane.showMessageDialog(null,ex);
        }
    }
    /**
     * Die Main Methode
     * @param args
     */
    public static void main(String[] args) throws IOException {
        new WortControl();
    }

}
