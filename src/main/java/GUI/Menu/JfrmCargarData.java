package GUI.Menu;

import ArchivosCSV.CargarCSV;
import ArchivosCSV.RegistroCovid;
import Controlador.DatosGlobales;
import EstructurasAlgoritmos.Lista.Lista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JfrmCargarData {
    public JPanel mainPanel;
    private JPanel tituloPanel;
    private JPanel contentPanel;
    private JTextField txtRuta;
    private JButton cargarButton;
    private JPanel rutaPanel;
    private JPanel tablaPanel;
    private JTable tablaCargada;
    private JButton btnRegresar;

    public JfrmCargarData() {


        cargarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String ruta = txtRuta.getText();
                llenarTabla(ruta);
            }
        });
        btnRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                SwingUtilities.getWindowAncestor(mainPanel).dispose();
                JfrmMenu jfrmMenu = new JfrmMenu();
                JFrame frameLogin = new JFrame("Login");
                frameLogin.setContentPane(jfrmMenu.mainPanel);
                frameLogin.setMinimumSize(new Dimension(400, 300));
                frameLogin.pack(); // respeta tamaño de UI Designer
                frameLogin.setLocationRelativeTo(null);
                frameLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frameLogin.setVisible(true);
            }
        });
    }



    public void llenarTabla(String ruta){
        // Crear columnas de la tabla
        String[] columnas = { "Fecha Corte", "UUID", "Fecha Muestra", "Edad", "Sexo",
                "Institución", "Ubigeo", "Dep. Paciente", "Prov. Paciente",
                "Dist. Paciente", "Dep. Muestra", "Prov. Muestra", "Dist. Muestra",
                "Tipo Muestra", "Resultado" };

        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

        // Cargar datos desde CSV
        CargarCSV cargador = new CargarCSV();
        DatosGlobales.listaCovid = new CargarCSV().cargarRegistros(ruta);

        for (RegistroCovid r : DatosGlobales.listaCovid) {
            Object[] fila = {
                    r.getFechaCorte(), r.getUuid(), r.getFechaMuestra(), r.getEdad(),
                    r.getSexo(), r.getInstitucion(), r.getUbigeo(),
                    r.getDepartamentoPaciente(), r.getProvinciaPaciente(), r.getDistritoPaciente(),
                    r.getDepartamentoMuestra(), r.getProvinciaMuestra(), r.getDistritoMuestra(),
                    r.getTipoMuestra(), r.getResultado()
            };
            modelo.addRow(fila);
        }

        // Asignar modelo a tu JTable
        tablaCargada.setModel(modelo);

        // Poner scroll en el panel
        JScrollPane scrollPane = new JScrollPane(tablaCargada);
        tablaPanel.setLayout(new BorderLayout());
        tablaPanel.add(scrollPane, BorderLayout.CENTER);
    }
}
