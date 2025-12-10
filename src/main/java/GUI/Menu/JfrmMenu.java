package GUI.Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JfrmMenu {
    public JPanel mainPanel;
    private JPanel tituloPanel;
    private JPanel componenetesPanel;
    private JButton btnCargar;
    private JButton btnFiltrar;
    private JButton graficasButton;

    public JfrmMenu() {
        btnCargar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JfrmCargarData jfrmCargarData = new JfrmCargarData();
                JFrame frame = new JFrame("Cargar Data");
                frame.setContentPane(jfrmCargarData.mainPanel);
                frame.setMinimumSize(new Dimension(600, 500));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
                SwingUtilities.getWindowAncestor(mainPanel).dispose();

            }
        });

        btnFiltrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JfmrFiltrarData jfmrFiltrarData = new JfmrFiltrarData();
                JFrame frame = new JFrame("Cargar Data");
                frame.setContentPane(jfmrFiltrarData.mainPanel);
                frame.setMinimumSize(new Dimension(600, 500));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
                SwingUtilities.getWindowAncestor(mainPanel).dispose();
            }
        });
    }
}
