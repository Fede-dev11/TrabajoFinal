package controller.Dependecias;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Borrar_tarea {

    public static String NOMBRE_ARCHIVO = "tarea.csv"; 
    private Scanner sc = new Scanner(System.in);

    private String[][] tareas = new String[100][5]; 
    private int indiceTareas = 0; 

    private void cargarTareas() {
        try (BufferedReader reader = new BufferedReader(new FileReader(NOMBRE_ARCHIVO))) {
            String linea;
            indiceTareas = 0;

            // Leer las líneas del archivo CSV
            while ((linea = reader.readLine()) != null) {
                if (indiceTareas >= tareas.length) {
                    System.out.println("El array de tareas está lleno. Algunas tareas no se cargaron.");
                    break;
                }
                tareas[indiceTareas] = linea.split(",");
                indiceTareas++;
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    public void eliminarTarea() {
        cargarTareas(); 

        System.out.println("Ingrese el tema de la tarea que desea eliminar: ");
        String temaEliminar = sc.nextLine();

        boolean tareaEncontrada = false;
        int nuevaIndice = 0;

        // Crear un nuevo array temporal para las tareas actualizadas
        String[][] tareasActualizadas = new String[100][5];

        for (int i = 0; i < indiceTareas; i++) {
            if (!tareas[i][0].equals(temaEliminar)) {
                tareasActualizadas[nuevaIndice] = tareas[i];
                nuevaIndice++;
            } else {
                tareaEncontrada = true;
            }
        }

        if (tareaEncontrada) {
            indiceTareas = nuevaIndice;
            tareas = tareasActualizadas;
            exportarACSV();
            System.out.println("Tarea eliminada exitosamente.");
        } else {
            System.out.println("No se encontró una tarea con el tema: " + temaEliminar);
        }
    }

    private void exportarACSV() {
        try (FileWriter writer = new FileWriter(NOMBRE_ARCHIVO)) {
            String[] columnas = {"Tema", "Descripción", "Materia", "Fecha", "Hora"};
            writer.append(String.join(",", columnas)).append("\n");

            for (int i = 0; i < indiceTareas; i++) {
                writer.append(String.join(",", tareas[i])).append("\n");
            }

            System.out.println("Tareas exportadas exitosamente al archivo: " + NOMBRE_ARCHIVO);
        } catch (IOException e) {
            System.out.println("Error al exportar las tareas: " + e.getMessage());
        }
    }
}
