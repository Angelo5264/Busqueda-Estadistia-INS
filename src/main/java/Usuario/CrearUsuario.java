package Usuario;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CrearUsuario {
    private FileWriter datosUsuario=null;
    private PrintWriter addText=null;

    /**
     *
     * Creara el usuario y lo añadira al archivo ".txt"
     * @param usuario Recibe un objeto de tipo Usuario
     * @throws IOException Maneja la excepcion al agregar al ".txt"
     *
     */
    public void crearUsuario(Usuario usuario) throws IOException{
        try{
              datosUsuario= new FileWriter("data/Usuarios.txt",true);
              addText= new PrintWriter(datosUsuario);
              addText.print("[\n"
                              +usuario.getDNI()+",\n"           //DNI
                              +usuario.getContraseña()+",\n"    //Contraseña
                              +usuario.getNombre()+",\n"        //Nombre
                              +usuario.getCorreo()+"\n"         //Correo
                              +"]"
              );
        }catch (IOException e){
            IO.println("ERROR: " + e.getMessage());

        }finally{
            datosUsuario.close();
        }
    }
}
