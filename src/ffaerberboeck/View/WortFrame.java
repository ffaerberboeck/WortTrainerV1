package ffaerberboeck.View;
import javax.swing.*;

/**
 * Diese Klasse bildet die GUI
 * @version 05-11-2020
 * @author Finn Färberböck
 */
public class WortFrame extends JFrame{
    /**
     * Diese Methode bildet die GUI
     * @param titel         Der Titel
     * @param layoutPanel   Das Layout
     */
    public WortFrame(String titel, JPanel layoutPanel) {
        super(titel);
        this.add(layoutPanel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
