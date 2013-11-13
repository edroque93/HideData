package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MainFrame extends JFrame {

    private final String frameTitle = "HideData Alpha Release, ThePirateCat";
    private final Dimension frameDimension = new Dimension(365, 200);
    private final Dimension funcButton = new Dimension(200, 30);
    private final Font funcFont = new Font("Arial", Font.BOLD, 16);

    public MainFrame() throws Exception {
        setTitle(frameTitle);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(frameDimension);
        setResizable(false);
        setLocationRelativeTo(null);
        setContentPane(new BackgroundPanel(ImageIO.read(getClass().getResource("/Resources/stripebg.png")),
                new BorderLayout()));
        createComponents();
        setVisible(true);
    }

    private void createComponents() {
        this.add(createFunctionalPanel(), BorderLayout.NORTH);
        this.add(createExtraPanel(), BorderLayout.SOUTH);
    }

    private void close() {
        dispose();
    }

    private JPanel createFunctionalPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(0, 0, 0, 0));
        panel.add(Box.createRigidArea(new Dimension(0, 35)));
        panel.add(createHide());
        panel.add(Box.createRigidArea(new Dimension(0, 5)));
        panel.add(createShow());
        return panel;
    }

    private JPanel createExtraPanel() {
        JPanel panel = new JPanel(new FlowLayout());
        panel.setBackground(new Color(0, 0, 0, 0));
        panel.add(createPanelAcercaDe());
        panel.add(createPanelExit());
        return panel;
    }

    private JButton createHide() {
        JButton button = new JButton("Ocultar");
        button.setFont(funcFont);
        button.setMaximumSize(funcButton);
        button.setPreferredSize(funcButton);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        return button;
    }

    private JButton createShow() {
        JButton button = new JButton("Mostrar");
        final JFrame buffer = this;
        button.setFont(funcFont);
        button.setMaximumSize(funcButton);
        button.setPreferredSize(funcButton);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ShowFrame frame = new ShowFrame(buffer);
                setVisible(false);
            }
        });
        return button;
    }

    private JButton createPanelAcercaDe() {
        JButton button = new JButton("Acerca de");
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(getContentPane(),
                        "HideData, oculta información en cualquier fichero anexando al final",
                        "Acerca de",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });
        return button;
    }

    private JButton createPanelExit() {
        JButton button = new JButton("Exit");
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                close();
            }
        });
        return button;
    }
}
