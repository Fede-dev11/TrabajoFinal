package controller.Dependecias;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Agregar_Tarea {

    // Lista para almacenar las tareas
    private ArrayList<String[]> tareas = new ArrayList<>();
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
        String fecha = sc.nextLine();

        System.out.println("Ingrese la hora de la tarea (HH:mm): ");
        String hora = sc.nextLine();



        // Guardar la tarea
        tareas.add(new String[]{ tema, descripcion, materia, fecha, hora, });
        System.out.println("Tarea agregada exitosamente.");
    }

    // Método para exportar tareas a un archivo CSV
    public void exportarACSV(String nombreArchivo) {
        String[] columnas = { "Tema", "Descripción", "Materia", "Fecha", "Hora"};

        try {
            FileWriter writer = new FileWriter(nombreArchivo);

            // Escribir encabezados y tareas
            writer.append(String.join(",", columnas)).append("\n");
            for (String[] tarea : tareas) {
                writer.append(String.join(",", tarea)).append("\n");
            }

            // Cerrar el FileWriter manualmente
            writer.close();

            System.out.println("Tareas exportadas exitosamente al archivo: " + nombreArchivo);
        } catch (IOException e) {
            System.out.println("Error al exportar las tareas: " + e.getMessage());
        }
    }
}
