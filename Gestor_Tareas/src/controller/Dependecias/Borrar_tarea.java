package controller.Dependecias;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Borrar_tarea {

    public static String NOMBRE_ARCHIVO = "tarea.csv"; // Puedes cambiar esto si el archivo tiene otro nombre
    private Scanner sc = new Scanner(System.in);

    // Método para eliminar una tarea por su tema
    public void eliminarTarea() {
        System.out.println("Ingrese el tema de la tarea que desea eliminar: ");
        String temaEliminar = sc.nextLine();

        // Leer el archivo CSV y cargar las tareas
        ArrayList<String[]> tareasActualizadas = new ArrayList<>();
        boolean tareaEncontrada = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(NOMBRE_ARCHIVO))) {
            String linea;
            // Leer las líneas del archivo CSV
            while ((linea = reader.readLine()) != null) {
                String[] datosTarea = linea.split(",");
                if (!datosTarea[0].equals(temaEliminar)) {
                    // Si la tarea no es la que queremos eliminar, la mantenemos
                    tareasActualizadas.add(datosTarea);
                } else {
                    tareaEncontrada = true;
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        // Si encontramos la tarea, la eliminamos y actualizamos el archivo
        if (tareaEncontrada) {
            // Actualizar el archivo con las tareas restantes
            exportarACSV(tareasActualizadas);
            System.out.println("Tarea eliminada exitosamente.");
        } else {
            System.out.println("No se encontró una tarea con el tema: " + temaEliminar);
        }
    }

    // Método para exportar las tareas actualizadas a un archivo CSV
    private void exportarACSV(ArrayList<String[]> tareasActualizadas) {
        try (FileWriter writer = new FileWriter(NOMBRE_ARCHIVO)) {
            String[] columnas = {"Tema", "Descripción", "Materia", "Fecha", "Hora"};
            writer.append(String.join(",", columnas)).append("\n");

            // Escribir las tareas restantes en el archivo CSV
            for (String[] tarea : tareasActualizadas) {
                writer.append(String.join(",", tarea)).append("\n");
            }

            System.out.println("Tareas exportadas exitosamente al archivo: " + NOMBRE_ARCHIVO);
        } catch (IOException e) {
            System.out.println("Error al exportar las tareas: " + e.getMessage());
        }
    }
}