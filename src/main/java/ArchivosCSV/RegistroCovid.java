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

    public int getEdad() {
        return edad;
    }

    public String getResultado() {
        return resultado;
    }

    public String getUuid() {
        return uuid;
    }


    @Override
    public String toString() {
        return uuid + " | " + sexo + " | " + edad + " | " + resultado;
    }
}

