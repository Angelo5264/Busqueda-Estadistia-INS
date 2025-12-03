package Usuario;

public class Usuario {
    private String DNI=null;
    private String contraseña=null;
    private String nombre=null;
    private String correo=null;


    public Usuario(){

    }

    /**
     * El constructor guarda datos del login
     * @param DNI Guarda DNI
     * @param contraseña Guarda Contraseña
     */
    public Usuario(String DNI, String contraseña){
        this.DNI=DNI;
        this.contraseña=contraseña;
    }

    /**
     *
     * El constructor instancia el objeto usuario con todos sus atributos
     * @param nombre Nombre del usuario
     * @param contraseña Contraseña que sera usada por el usuario
     * @param correo Correo que tiene el usuario
     * @param DNI DNI que sera usardo para que el usuario entre al sisitema
     *
     */
    public Usuario(String DNI, String contraseña, String nombre, String correo ){
        this.DNI=DNI;
        this.contraseña=contraseña;
        this.nombre=nombre;
        this.correo=correo;

    }

    /**
     * ============================
     *      Getters y Setters
     * ============================
     */

    public String getDNI() {
        return DNI;
    }
    public String getContraseña() {
        return contraseña;
    }
    public String getNombre() {
        return nombre;
    }
    public String getCorreo() {
        return correo;
    }





}
