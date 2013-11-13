package UI;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.LayoutManager;
import javax.swing.JComponent;

class BackgroundPanel extends JComponent {

    Image img;

    public BackgroundPanel(Image i, LayoutManager lm) {
        this.img = i;
        setLayout(lm);
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0, null);
    }

}
