package Controlador;
import ArchivosCSV.RegistroCovid;
import EstructurasAlgoritmos.Cola.Cola;
import EstructurasAlgoritmos.Lista.Lista;
public class DatosGlobales {
        public static Lista<RegistroCovid> listaCovid = new Lista<>();
        public static Cola<RegistroCovid> colaGlobal = new Cola<>();
}
