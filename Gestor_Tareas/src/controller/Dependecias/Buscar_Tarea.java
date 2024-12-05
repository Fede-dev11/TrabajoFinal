
package controller.Dependecias;

import java.io.File;
import java.util.Scanner;

public class Buscar_Tarea {

    // Método para buscar tareas en un archivo CSV
    public void buscarEnCSV(String nombreArchivo) {
        File archivo = new File(nombreArchivo);

        // Verificar si el archivo existe
        if (archivo.exists() && archivo.isFile()) {
            Scanner archivoBus = null;
            boolean encontrado = false;

            // Leer el archivo línea por línea
            try {
                archivoBus = new Scanner(archivo);
                System.out.println("Ingrese el criterio de búsqueda: ");
                Scanner sc = new Scanner(System.in);
                String criterio = sc.nextLine().toLowerCase();

                // Leer línea por línea
                while (archivoBus.hasNextLine()) {
                    String line = archivoBus.nextLine();
                    String[] datosTarea = line.split(",");  // Separar por comas

                    // Verificar si alguna columna contiene el criterio de búsqueda
                    for (String dato : datosTarea) {
                        if (dato.toLowerCase().contains(criterio)) {
                            encontrado = true;
                            mostrarTarea(datosTarea);  // Mostrar tarea
                            break;
                        }
                    }
                }

                if (!encontrado) {
                    System.out.println("No se encontraron tareas con el criterio proporcionado.");
                }
            } catch (Exception e) {
                System.out.println("Error al leer el archivo.");
            } finally {
                if (archivoBus != null) {
                    archivoBus.close();  // Cerrar el Scanner después de leer el archivo
                }
            }
        } else {
            System.out.println("El archivo no existe o no es válido.");
        }
    }

    // Método para mostrar los datos de una tarea
    private void mostrarTarea(String[] datosTarea) {
        System.out.println("Tarea encontrada:");
        for (String dato : datosTarea) {
            System.out.print(dato + "\t");
        }
        System.out.println();
    }
}
