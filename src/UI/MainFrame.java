package UI;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainFrame extends JFrame {

    private final String frameTitle = "HideData Alpha Release, ThePirateCat";
    private final Dimension frameDimension = new Dimension(365, 200);
    private final Dimension funcButton = new Dimension(200, 30);

    public MainFrame() throws HeadlessException {
        setTitle(frameTitle);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(frameDimension);
        setResizable(false);
        setLocationRelativeTo(null);
        createComponents();
        setVisible(true);
    }

    private void createComponents() {
        this.add(createFunctionalPanel());
        this.add(createExtraPanel(), BorderLayout.SOUTH);
        this.add(createProgramIcon(), BorderLayout.WEST);
    }

    private void close() {
        dispose();
    }

    private JPanel createFunctionalPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(Box.createRigidArea(new Dimension(0,35)));
        panel.add(createOcultar());
        panel.add(Box.createRigidArea(new Dimension(0,5)));
        panel.add(createMostrar());
        return panel;
    }

    private JPanel createExtraPanel() {
        JPanel panel = new JPanel(new FlowLayout());
        panel.add(createPanelAcercaDe());
        panel.add(createPanelExit());
        return panel;
    }

    private JButton createOcultar() {
        JButton button = new JButton("Ocultar");
        button.setMaximumSize(funcButton);
        button.setPreferredSize(funcButton);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        return button;
    }

    private JButton createMostrar() {
        JButton button = new JButton("Mostrar");
        button.setMaximumSize(funcButton);
        button.setPreferredSize(funcButton);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        return button;
    }

    private JButton createPanelAcercaDe() {
        JButton button = new JButton("Acerca de");
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

    private JPanel createProgramIcon() {
        JPanel panel = new JPanel();
        JLabel label = new JLabel();
        label.setIcon(new ImageIcon(getClass().getResource("/Resources/image.png")));
        panel.add(label);
        return panel;
    }
}
