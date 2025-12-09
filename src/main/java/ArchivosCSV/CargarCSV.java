package ArchivosCSV;

import EstructurasAlgoritmos.Lista.Lista;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CargarCSV {

    public Lista<RegistroCovid> cargarRegistros(String ruta) {

        Lista<RegistroCovid> lista = new Lista<>();

        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {

            String linea;
            boolean primera = true;

            while ((linea = br.readLine()) != null) {

                // Saltar encabezado
                if (primera) {
                    primera = false;
                    continue;
                }

                // Separar por punto y coma
                String[] d = linea.split(";");

                String fechaCorte = d[0];
                String uuid = d[1];
                String fechaMuestra = d[2];

                int edad = 0;
                try {
                    edad = Integer.parseInt(d[3].trim());
                } catch (Exception e) {
                    edad = 0;
                }

                String sexo = d[4];
                String institucion = d[5];
                String ubigeo = d[6];
                String depPaciente = d[7];
                String provPaciente = d[8];
                String distPaciente = d[9];
                String depMuestra = d[10];
                String provMuestra = d[11];
                String distMuestra = d[12];
                String tipo = d[13];
                String resultado = d[14];

                RegistroCovid r = new RegistroCovid(
                        fechaCorte, uuid, fechaMuestra, edad, sexo, institucion, ubigeo,
                        depPaciente, provPaciente, distPaciente, depMuestra, provMuestra,
                        distMuestra, tipo, resultado
                );

                lista.insertarFinal(r);
            }

        } catch (IOException e) {
            System.out.println("Error leyendo CSV: " + e.getMessage());
        }

        return lista;
    }
}
