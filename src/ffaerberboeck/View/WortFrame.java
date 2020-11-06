package ffaerberboeck.View;
import javax.swing.*;

/**
 * Diese Klasse bildet die GUI
 * @author Finn Färberböck
 * @version 06-11-2020
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
