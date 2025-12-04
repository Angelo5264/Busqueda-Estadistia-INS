package Usuario;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ExtraerUsuario {
    private FileReader datosUsuario=null;
    private BufferedReader read=null;

    //Extrayendo el ususario de acuerdo a lo que se escriba en el login y contraseña
    public Usuario extraerUsuario(Usuario usuario) throws IOException {
        try{
            datosUsuario=new FileReader("data/Usuarios.txt");
            if(datosUsuario.ready()){
                read= new BufferedReader(datosUsuario);
                String verificador;
                String DNI = usuario.getDNI(), contraseña = usuario.getContraseña(), nombre, correo;
                while((verificador=read.readLine()) != null){
                    if(DNI.equals(verificador)){
                        if (contraseña == read.readLine()) {
                            nombre = read.readLine();
                            correo = read.readLine();
                            Usuario datosUser = new Usuario(DNI, nombre, correo);
                            return datosUser;
                        }
                    }
                    return null;
                }
            }else{
                IO.println("El archivo no esta listo para ser leido ");
            }
            return null;
        }catch (IOException e){
            IO.println("ERROR: " + e.getMessage());
            return null;
        }finally{
            datosUsuario.close();
        }
    }
}
