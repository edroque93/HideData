package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.Point;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class ShowFrame extends JFrame {

    private final String showFrameTitle = "Mostrar datos";
    private final Dimension frameDimension = new Dimension(280, 170);
    private JFrame superFrame;

    public ShowFrame() throws HeadlessException {
        super();
        setTitle(showFrameTitle);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        WindowListener exitListener = new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                close();
            }
        };
        addWindowListener(exitListener);
        setSize(frameDimension);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        createComponents();
        setVisible(true);
    }

    public ShowFrame(JFrame superFrame) {
        this();
        this.superFrame = superFrame;
        setSpawnLocation();
    }

    private void close() {
        this.setVisible(false);
        superFrame.setLocation(calculateLocationPoint(this, superFrame));
        superFrame.setVisible(true);
        dispose();
    }

    private void createComponents() {
        this.add(createGetFilePanel(), BorderLayout.NORTH);
        this.add(createTreePanel(), BorderLayout.WEST);
    }

    private JPanel createTreePanel() {
        JPanel panel = new JPanel();
        // Jugando un poco...
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Raiz");
        DefaultMutableTreeNode x = new DefaultMutableTreeNode("Hijo x");
        DefaultMutableTreeNode y = new DefaultMutableTreeNode("Hijo y");
        root.add(x);
        root.add(y);
        JTree tree = new JTree(root);
        tree.setBorder(BorderFactory.createLineBorder(Color.black));
        tree.setPreferredSize(new Dimension(100, 75));
        panel.add(tree);
        return panel;
    }

    private JPanel createGetFilePanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(createFileEdit());
        panel.add(createSearchButton());
        return panel;
    }

    private JTextField createFileEdit() {
        JTextField edit = new JTextField();
        edit.setPreferredSize(new Dimension(200, 27));
        return edit;
    }

    private JButton createSearchButton() {
        JButton button = new JButton("...");
        return button;
    }
    
    private Point calculateLocationPoint(JFrame a, JFrame b) {
        int x = a.getLocation().x + a.getWidth() / 2;
        int y = a.getLocation().y + a.getHeight() / 2;

        x -= b.getWidth() / 2;
        y -= b.getHeight() / 2;

        return new Point(x, y);   
    }

    private void setSpawnLocation() {
        this.setLocation(calculateLocationPoint(superFrame, this));
    }
}
