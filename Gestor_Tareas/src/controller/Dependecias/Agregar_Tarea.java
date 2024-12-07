package controller.Dependecias;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import controller.Funciones;

public class Agregar_Tarea {

    // Lista para almacenar las tareas
    public ArrayList<String[]> tareas = new ArrayList<>();
    public String NOMBRE_ARCHIVO = "tarea.csv"; // Para guardar el nombre del archivo y público para usarlo en otros lugares
    private Scanner sc = new Scanner(System.in);

    // Método para agregar una tarea
    public void Agrega() {
        System.out.println("Ingrese el tema de la tarea: ");
        String tema = sc.nextLine();

        System.out.println("Escribe la descripción de la tarea: ");
        String descripcion = sc.nextLine();

        System.out.println("Ingrese la materia de la tarea: ");
        String materia = sc.nextLine();

        System.out.println("Ingrese la fecha de la tarea (dd/MM/yyyy): ");
        Funciones funciones = new Funciones();
        String fecha = funciones.validarFecha();

        System.out.println("Ingrese la hora de la tarea (HH:mm): ");
        String hora = sc.nextLine();

        // Guardar la tarea en la lista
        tareas.add(new String[]{tema, descripcion, materia, fecha, hora});
        System.out.println("Tarea agregada exitosamente.");
    }

    // Método para exportar tareas a un archivo CSV sin sobrescribirlo
    public void exportarACSV() {
        String[] columnas = {"Tema", "Descripción", "Materia", "Fecha", "Hora"};

        try {
            // Verificar si el archivo ya existe y tiene contenido
            boolean archivoExiste = new java.io.File(NOMBRE_ARCHIVO).exists();

            // Abrir el archivo en modo append
            FileWriter writer = new FileWriter(NOMBRE_ARCHIVO, true);

            // Si el archivo está vacío, escribir los encabezados
            if (!archivoExiste || new java.io.File(NOMBRE_ARCHIVO).length() == 0) {
                writer.append(String.join(",", columnas)).append("\n");
            }

            // Escribir las tareas desde la lista
            for (String[] tarea : tareas) {
                writer.append(String.join(",", tarea)).append("\n");
            }

            // Limpiar la lista de tareas después de exportarlas
            tareas.clear();

            // Cerrar el FileWriter
            writer.close();

            System.out.println("Tareas exportadas exitosamente al archivo: " + NOMBRE_ARCHIVO);
        } catch (IOException e) {
            System.out.println("Error al exportar las tareas: " + e.getMessage());
        }
    }
}
