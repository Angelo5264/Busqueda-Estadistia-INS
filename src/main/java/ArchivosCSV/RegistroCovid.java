package ArchivosCSV;

public class RegistroCovid {

    private String fechaCorte;
    private String uuid;
    private String fechaMuestra;
    private int edad;
    private String sexo;
    private String institucion;
    private String ubigeo;
    private String departamentoPaciente;
    private String provinciaPaciente;
    private String distritoPaciente;
    private String departamentoMuestra;
    private String provinciaMuestra;
    private String distritoMuestra;
    private String tipoMuestra;
    private String resultado;

    public RegistroCovid(String fechaCorte, String uuid, String fechaMuestra,
                         int edad, String sexo, String institucion, String ubigeo,
                         String departamentoPaciente, String provinciaPaciente, String distritoPaciente,
                         String departamentoMuestra, String provinciaMuestra, String distritoMuestra,
                         String tipoMuestra, String resultado)
    {

        this.fechaCorte = fechaCorte;
        this.uuid = uuid;
        this.fechaMuestra = fechaMuestra;
        this.edad = edad;
        this.sexo = sexo;
        this.institucion = institucion;
        this.ubigeo = ubigeo;
        this.departamentoPaciente = departamentoPaciente;
        this.provinciaPaciente = provinciaPaciente;
        this.distritoPaciente = distritoPaciente;
        this.departamentoMuestra = departamentoMuestra;
        this.provinciaMuestra = provinciaMuestra;
        this.distritoMuestra = distritoMuestra;
        this.tipoMuestra = tipoMuestra;
        this.resultado = resultado;
    }

    public String getFechaCorte() {
        return fechaCorte;
    }

    public String getUuid() {
        return uuid;
    }

    public String getFechaMuestra() {
        return fechaMuestra;
    }

    public int getEdad() {
        return edad;
    }

    public String getSexo() {
        return sexo;
    }

    public String getInstitucion() {
        return institucion;
    }

    public String getUbigeo() {
        return ubigeo;
    }

    public String getDepartamentoPaciente() {
        return departamentoPaciente;
    }

    public String getProvinciaPaciente() {
        return provinciaPaciente;
    }

    public String getDistritoPaciente() {
        return distritoPaciente;
    }

    public String getDepartamentoMuestra() {
        return departamentoMuestra;
    }

    public String getProvinciaMuestra() {
        return provinciaMuestra;
    }

    public String getDistritoMuestra() {
        return distritoMuestra;
    }

    public String getTipoMuestra() {
        return tipoMuestra;
    }

    public String getResultado() {
        return resultado;
    }

    @Override
    public String toString() {
        return uuid + " | " + sexo + " | " + edad + " | " + resultado;
    }
}

