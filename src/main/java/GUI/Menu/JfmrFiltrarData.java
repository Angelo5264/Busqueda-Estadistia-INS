package GUI.Menu;

import ArchivosCSV.RegistroCovid;
import Controlador.DatosGlobales;
import EstructurasAlgoritmos.Lista.Lista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JfmrFiltrarData {
   public JPanel mainPanel;
   private JPanel camposPanel;
   private JPanel tablaPanel;
   private JTable tablaFiltrados;
   private JTextField txtCampo;
   private JTextField txtValor;
   private JButton btnFiltrar;
   private JButton btnAgregarCola;
   private JButton regresarButton;
   private Lista<RegistroCovid> registrosFiltrados;

   public JfmrFiltrarData() {
      btnFiltrar.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent actionEvent) {
            Lista<RegistroCovid> registrosCovids =actualizarTabla();
            registrosFiltrados=registrosCovids;
         }
      });
      btnAgregarCola.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent actionEvent) {
            if (registrosFiltrados == null || registrosFiltrados.isEmpty()) {
               JOptionPane.showMessageDialog(null, "No hay registros filtrados para agregar a la cola.");
               return;
            }

            for (RegistroCovid r : registrosFiltrados) {
               DatosGlobales.colaGlobal.encolar(r);
            }

            JOptionPane.showMessageDialog(null, "Registros agregados a la Cola Global.");
         }
      });
      regresarButton.addActionListener(new ActionListener() {
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

   public Lista<RegistroCovid> actualizarTabla() {
      // Obtener los valores del UI
      String campo = txtCampo.getText().trim().toLowerCase(); // ejemplo: "resultado"
      String valor = txtValor.getText().trim();              // ejemplo: "POSITIVO"

      // Columnas de la tabla
      String[] columnas = { "Fecha Corte", "UUID", "Fecha Muestra", "Edad", "Sexo",
              "Institución", "Ubigeo", "Dep. Paciente", "Prov. Paciente",
              "Dist. Paciente", "Dep. Muestra", "Prov. Muestra", "Dist. Muestra",
              "Tipo Muestra", "Resultado" };

      DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

      // Filtrar usando la lista global
      Lista<RegistroCovid> filtrados;
      if (valor.isEmpty() || campo.isEmpty()) {
         // Si no hay filtro, mostrar todos
         filtrados = DatosGlobales.listaCovid;
      } else {
         filtrados = DatosGlobales.listaCovid.filtrarPorCampo(campo, valor);
      }

      // Llenar la tabla
      for (RegistroCovid r : filtrados) {
         Object[] fila = {
                 r.getFechaCorte(), r.getUuid(), r.getFechaMuestra(), r.getEdad(),
                 r.getSexo(), r.getInstitucion(), r.getUbigeo(),
                 r.getDepartamentoPaciente(), r.getProvinciaPaciente(), r.getDistritoPaciente(),
                 r.getDepartamentoMuestra(), r.getProvinciaMuestra(), r.getDistritoMuestra(),
                 r.getTipoMuestra(), r.getResultado()
         };
         modelo.addRow(fila);
      }

      // Asignar modelo a JTable con scroll
      tablaFiltrados.setModel(modelo);
      tablaPanel.removeAll();
      tablaPanel.setLayout(new BorderLayout());
      JScrollPane scrollPane = new JScrollPane(tablaFiltrados);
      tablaPanel.add(scrollPane, BorderLayout.CENTER);
      tablaPanel.revalidate();
      tablaPanel.repaint();
      return filtrados;
   }

}
