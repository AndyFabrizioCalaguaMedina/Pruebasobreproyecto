/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Datos; // Asegúrate de que este sea el nombre correcto de tu clase
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;

public class CargarDatos {
    private static final int FACTOR_CRECIMIENTO = 10;
    private static Datos[] datos = new Datos[FACTOR_CRECIMIENTO];
    private static int contadorDatos = 0;

    public static Datos[] getDatos() {
        return datos;
    }

    public static void agregarDatos() {
        try {
            File archivo = new File("Muestra.csv"); // Asegúrate de que el nombre del archivo sea correcto
            System.out.println("Ruta del archivo: " + archivo.getAbsolutePath());
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            String linea;

            // Omitir la primera línea (encabezados)
            br.readLine();

            while ((linea = br.readLine()) != null) {
                // Dividir la línea por las comas para obtener los datos
                String[] datosLinea = linea.split(",");

                // Asegúrate de que la longitud de datosLinea sea suficiente
                if (datosLinea.length < 10) {
                    System.err.println("Error: La línea no tiene suficientes columnas: " + linea);
                    continue; // Salta esta línea
                }

                // Crear un objeto Datos con las columnas
                String grupoRiesgo = datosLinea[0];
                String edad = datosLinea[1];
                String sexo = datosLinea[2];
                String fechaVacunacion = datosLinea[3];
                int dosis = Integer.parseInt(datosLinea[4]);
                String fabricante = datosLinea[5];
                String diresa = datosLinea[6];
                String departamento = datosLinea[7];
                String provincia = datosLinea[8];
                String distrito = datosLinea[9];

                Datos nuevoDato = new Datos(grupoRiesgo, edad, sexo, fechaVacunacion, dosis, fabricante, diresa, departamento, provincia, distrito);

                // Expandir el arreglo si es necesario
                if (contadorDatos == datos.length) {
                    Datos[] aux = new Datos[datos.length + FACTOR_CRECIMIENTO];
                    System.arraycopy(datos, 0, aux, 0, datos.length);
                    datos = aux;
                }

                datos[contadorDatos] = nuevoDato;
                contadorDatos++;
            }

            br.close();
        } catch (Exception e) {
            System.out.println("Error al cargar los datos: " + e.getMessage());
        }
    }

    public static void imprimirDatos() {
        for (int i = 0; i < contadorDatos; i++) {
            System.out.println(datos[i]);
        }
    }

    public static void ordenarPorGrupoRiesgo() {
        for (int i = 0; i < contadorDatos; i++) {
            for (int j = 0; j < contadorDatos - 1; j++) {
                if (datos[j].getGrupoRiesgo().compareTo(datos[j + 1].getGrupoRiesgo()) > 0) {
                    Datos aux = datos[j];
                    datos[j] = datos[j + 1];
                    datos[j + 1] = aux;
                }
            }
        }
    }
}