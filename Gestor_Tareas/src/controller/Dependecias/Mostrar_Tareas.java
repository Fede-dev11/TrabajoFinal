package controller.Dependecias;

import java.io.File;
import java.util.Scanner;

public class Mostrar_Tareas {

    public void mostrarTareasDesdeCSV(String nombreArchivo) {
        File archivo = new File(nombreArchivo);

        // Verificar si el archivo existe
        if (archivo.exists() && archivo.isFile()) {
            try (Scanner archivoBus = new Scanner(archivo)) {

                System.out.println("Mostrando tareas desde el archivo: " + nombreArchivo);
                // Leer línea por línea
                while (archivoBus.hasNextLine()) {
                    String line = archivoBus.nextLine();
                    String[] datosTarea = line.split(",");  // Separar por comas

                    // Verificar que no haya valores nulos o vacíos en los datos
                    boolean contieneNull = false;
                    for (String dato : datosTarea) {
                        if (dato == null || dato.trim().isEmpty()) {
                            contieneNull = true;
                            break;
                        }
                    }

                    if (!contieneNull) {
                        mostrarTarea(datosTarea);
                    }
                }

            } catch (Exception e) {
                System.out.println("Error al leer el archivo: " + e.getMessage());
            }
        } else {
            System.out.println("El archivo no existe o no es válido.");
        }
    }

    private void mostrarTarea(String[] datosTarea) {
        System.out.println("Tarea:");
        System.out.println("Tema: " + datosTarea[0]);
        System.out.println("Descripción: " + datosTarea[1]);
        System.out.println("Materia: " + datosTarea[2]);
        System.out.println("Fecha: " + datosTarea[3]);
        System.out.println("Hora: " + datosTarea[4]);
        System.out.println("-------------------------------");
    }
}
