package GUI;

import Usuario.ExtraerUsuario;
import Usuario.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class JfrmLogin {
    JPanel mainPanel;
    private JLabel lblTitulo;
    private JPanel componenetesPanel;
    private JTextField txtDNI;
    private JButton btnIngresar;
    private JPasswordField pwdContra;
    private JButton btnRegistrar;



    public JfrmLogin() {
        btnIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String dni = txtDNI.getText();
                String contrasenia = new String(pwdContra.getPassword());
                ExtraerUsuario verificar = new ExtraerUsuario();
                try {
                    Usuario access=verificar.extraerUsuario(dni,contrasenia);
                    if(access!=null){

                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JfrmRegistro jfrmRegistro = new JfrmRegistro();
                JFrame frame = new JFrame("Registro");
                frame.setContentPane(jfrmRegistro.mainPanel);
                frame.setMinimumSize(new Dimension(400, 300));
                frame.pack();
                frame.setLocationRelativeTo(null);// centra
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // solo cierra esa ventana
                frame.setVisible(true);
                SwingUtilities.getWindowAncestor(mainPanel).dispose();
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("JfrmLogin");
        frame.setContentPane(new JfrmLogin().mainPanel);
        frame.setSize(new Dimension(400,300));
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
