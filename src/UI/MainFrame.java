package UI;

import java.awt.Dimension;
import java.awt.HeadlessException;
import javax.swing.JFrame;

public class MainFrame extends JFrame {

    private final String frameTitle = "HideData Alpha Release, ThePirateCat";

    public MainFrame() throws HeadlessException {
        setTitle(frameTitle);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(400, 200));
        setLocationRelativeTo(null);
        createComponents();
        setVisible(true);
    }

    private void createComponents() {
        // this.add(Paneles...);
    }

    private void close() {
        dispose();
    }

}
