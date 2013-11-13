package UI;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JComponent;

class backImage extends JComponent {
    
    Image img;

    public backImage(Image i) {
        this.img = i;
        setLayout(new BorderLayout());
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0, null);
    }

}
