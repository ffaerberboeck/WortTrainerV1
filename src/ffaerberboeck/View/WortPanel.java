package ffaerberboeck.View;
import ffaerberboeck.WortControl;
import ffaerberboeck.Model.WortTrainer;

import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Diese Klasse baut die visual Components
 * @version 05-11-2020
 * @author Finn Färberböck
 */
public class WortPanel extends JPanel{
    private int gesamt = 0;

    private JLabel text = new JLabel("Welches Wort wird unten dargestellt (Eingabe zum Überpüfen?)", SwingConstants.LEFT);
    private JLabel rW = new JLabel("Richtige Wörter:");
    private JLabel fW = new JLabel("Falsche Wörter:");
    private JLabel speicherndefaultlabel = new JLabel("WortTrainer.txt");
    private JLabel ladendefaultlabel = new JLabel("WortTrainer.txt");
    private JLabel lrW;
    private JLabel lfW;
    private JLabel lImage;

    private ImageIcon icon= new ImageIcon();

    private JTextField feld = new JTextField("");
    private JTextField speichernfield = new JTextField("Speichern (bitte Pfad eingeben)");
    private JTextField ladenfield = new JTextField("Laden (bitte Pfad eingeben)");

    private String pfad = "https://www.lebensbaum.com/files/styles/greige_image_476x476/public/images/greiges/apfel-suesserapfel1_0.jpg?itok=6AGJQzt4";

    private int zrW = 0;
    private int zfW = 0;

    private JButton zurueck = new JButton("Zurücksetzen");
    private JButton hinzu = new JButton("Wort Hinzufügen");
    private JButton speichernbutton = new JButton("Speichern");
    private JButton ladenbutton = new JButton("Laden");
    private JButton speichernbuttondefault = new JButton("Speichern - Default");
    private JButton ladenbuttondefault = new JButton("Laden - Default");

    /**
     * Diese Methode bildet die grafischen Objekte
     * @param wControl      Ein WortControl Objekt um Aktionen an die Klasse WortControl zu melden
     */
    public WortPanel(WortControl wControl) {

        this.setLayout(new BorderLayout());

        JPanel textpanel = new JPanel(new GridLayout(2,1,5,10));
        text.setFont(new Font("Arial", Font.ITALIC, 44));
        textpanel.add(text);
        text.setFont(new Font("Arial", Font.BOLD, 25));
        textpanel.add(feld);

        this.add(textpanel,BorderLayout.PAGE_START);

        JPanel center = new JPanel(new GridLayout(1,1));
        ImageIcon icon = null;
        try {
            icon = new ImageIcon(new URL(pfad));
            Image image = icon.getImage(); // umwandeln in ein Image-Objekt
            image = image.getScaledInstance(350, 350,  Image.SCALE_SMOOTH); // skalieren auf gewünschte Größe
            this.lImage = new JLabel(new ImageIcon(image)); // anzeigen in einem JLabel
            center.add(lImage);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        this.add(center,BorderLayout.CENTER);

        JPanel functions = new JPanel(new GridLayout(3,3));
        this.lrW = new JLabel(""+zrW+"");
        this.lfW = new JLabel(""+zfW+"");
        functions.add(rW);
        functions.add(lrW);
        zurueck.setBackground(Color.WHITE);
        functions.add(zurueck);
        zurueck.setActionCommand("zurueck");
        zurueck.addActionListener(wControl);
        functions.add(fW);
        functions.add(lfW);
        hinzu.setBackground(Color.WHITE);
        functions.add(hinzu);
        hinzu.setActionCommand("hinzu");
        hinzu.addActionListener(wControl);
        //Neue Buttons

        JPanel functionsneu = new JPanel(new GridLayout(4,2));

        functionsneu.add(speichernbutton);
        speichernbutton.setBackground(Color.WHITE);
        speichernbutton.setActionCommand("s");
        speichernbutton.addActionListener(wControl);

        functionsneu.add(ladenbutton);
        ladenbutton.setBackground(Color.WHITE);
        ladenbutton.setActionCommand("l");
        ladenbutton.addActionListener(wControl);

        functionsneu.add(speichernfield);
        speichernfield.addActionListener(wControl);

        functionsneu.add(ladenfield);
        ladenfield.addActionListener(wControl);

        functionsneu.add(speichernbuttondefault);
        speichernbuttondefault.setBackground(Color.WHITE);
        speichernbuttondefault.setActionCommand("sd");
        speichernbuttondefault.addActionListener(wControl);

        functionsneu.add(ladenbuttondefault);
        ladenbuttondefault.setBackground(Color.WHITE);
        ladenbuttondefault.setActionCommand("ld");
        ladenbuttondefault.addActionListener(wControl);

        functionsneu.add(speicherndefaultlabel);

        functionsneu.add(ladendefaultlabel);

        functions.add(functionsneu);
        this.add(functions,BorderLayout.PAGE_END);

    }



    /**
     * Diese Methode gibt den Input vom JTextField zurück
     * @return den Input
     */
    public String returnText() {
        String input = feld.getText();
        return input;
    }




    /**
     * Diese Methode setzt den Input vom JTextField auf leer
     */
    public void setTextleer() {
        feld.setText("");
    }



    /**
     * Diese Methode gibt den vom Benutzer ausgewählten Pfad zum Laden zurück
     * @return den Input
     */
    public String returnpfadladen() {
        String input = ladenfield.getText();
        return input;
    }



    /**
     * Diese Methode gibt den vom Benutzer ausgewählten Pfad zum Speichern zurück
     * @return den Input
     */
    public String returnpfadspeichern() {
        String input = speichernfield.getText();
        return input;
    }
    /**
     * Diese Mehtod eresetet alle
     */
    public void reset() {
        zrW = 0;
        lrW.setText(""+zrW+"");
        zfW = 0;
        lfW.setText(""+zfW+"");
    }


    /**
     * Diese Methode ist noch nicht fertig geschrieben
     */
    public void richtig() {
        gesamt++;
        zrW++;
        lrW.setText(""+zrW+"");
    }




    /**
     * Diese Methode ist noch nicht fertig geschrieben
     */
    public void falsch() {
        gesamt++;
        zfW++;
        lfW.setText(""+zfW+"");
    }


    /**
     * Diese Methode setzt ein neues Image
     * @param url          Die URL des Bildes
     */
    public void setImage(String url) throws MalformedURLException {
        pfad = url;
        icon = new ImageIcon(new URL(pfad));
        Image image = icon.getImage(); // umwandeln in ein Image-Objekt
        image = image.getScaledInstance(350, 350,  Image.SCALE_SMOOTH); // skalieren auf gewünschte Größe
        lImage.setIcon(icon);
    }



    /**
     * Diese Methode ist noch nicht in Verwendung
     * @param wt        Der WortTrainer
     */
    public void txtdateioutput(WortTrainer wt) {
        String str = wt.toString();
        System.out.println(str);
    }
}
