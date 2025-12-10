package GUI;

import Usuario.Usuario;
import Usuario.CrearUsuario;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class JfrmRegistro {
    JPanel mainPanel;
    private JPanel tituloPanel;
    private JPanel componenetesPanel;
    private JTextField txtDNI;
    private JTextField txtContra;
    private JTextField txtNombres;
    private JTextField txtCorreo;
    private JButton btnRegistro;
    private JButton btnRegresar;

    public JfrmRegistro() {
        btnRegistro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String DNI=txtDNI.getText();
                String contrasenia = txtContra.getText();
                String nombre=txtNombres.getText();
                String correo=txtCorreo.getText();
                Usuario newUser = new Usuario(DNI,contrasenia,nombre,correo);
                CrearUsuario crearUsuario = new CrearUsuario();
                try {
                    crearUsuario.crearUsuario(newUser);
                    txtDNI.setText("");
                    txtContra.setText("");
                    txtNombres.setText("");
                    txtCorreo.setText("");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        btnRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                SwingUtilities.getWindowAncestor(mainPanel).dispose();

                // Abrir nuevamente el Login
                JfrmLogin loginUI = new JfrmLogin();
                JFrame frameLogin = new JFrame("Login");
                frameLogin.setContentPane(loginUI.mainPanel);
                frameLogin.setMinimumSize(new Dimension(400, 300));
                frameLogin.pack(); // respeta tamaño de UI Designer
                frameLogin.setLocationRelativeTo(null);
                frameLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frameLogin.setVisible(true);
            }
        });
        txtCorreo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                btnRegistro.doClick();
            }
        });
    }
}
