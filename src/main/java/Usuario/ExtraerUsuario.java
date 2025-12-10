package Usuario;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ExtraerUsuario {
    private FileReader datosUsuario=null;
    private BufferedReader read=null;


    /**
     * Usar login, verifica dni y contraseña sea igual al txt
     * @param dni String DNI
     * @param contraseña String Contraseña
     * @return Objeto Usuario
     * @throws IOException
     */
    public Usuario extraerUsuario(String dni, String contraseña) throws IOException {

        try {
            datosUsuario = new FileReader("data/Usuarios.txt");
            read = new BufferedReader(datosUsuario);

            String linea;
            String[] datos = new String[4];
            int contador = 0;

            while ((linea = read.readLine()) != null) {
                linea = linea.trim();

                // Ignorar corchetes
                if (linea.equals("[") || linea.equals("]") || linea.isEmpty()) {
                    continue;
                }

                // Quitar coma final
                linea = linea.replace(",", "");

                datos[contador] = linea;
                contador++;

                // Ya leímos los 4 datos
                if (contador == 4) {
                    String dniArchivo = datos[0];
                    String passArchivo = datos[1];
                    String nombre = datos[2];
                    String correo = datos[3];

                    // Validar login
                    if (dniArchivo.equals(dni) && passArchivo.equals(contraseña)) {
                        JOptionPane.showMessageDialog(null,"Acceso concedido.");
                        return new Usuario(dniArchivo, passArchivo, nombre, correo);
                    }

                    contador = 0; // resetear para siguiente usuario
                }
            }

        } catch (IOException e) {
            IO.println("ERROR: " + e.getMessage() + "\n");

        } finally {
            if (read != null) read.close();
            if (datosUsuario != null) datosUsuario.close();
        }

        return null;
    }
}
