package controller.Dependecias;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


import controller.util.Validador_Fechas;
import controller.util.Validador_Hora;

public class Agregar_Tarea {
    //variables publicas
    // Lista para almacenar las tareas
    public String[][] tareas = new String[100][5]; // ponemos un string de 100 para que agregue las tareas agusto
    public int indiceTareas = 0;  //
    public String NOMBRE_ARCHIVO = "tarea.csv";  //nombre del archivo que se va a crear
    private Scanner sc = new Scanner(System.in);

    // Método para agregar una tarea
    public void Agrega() {
        if (indiceTareas >= tareas.length) {
            System.out.println("No se pueden agregar más tareas. El almacenamiento está lleno.");
            return;
        }
        System.out.println("Ingrese el tema de la tarea: ");
        String tema = sc.nextLine();

        System.out.println("Escribe la descripción de la tarea: ");
        String descripcion = sc.nextLine();

        System.out.println("Ingrese la materia de la tarea: ");
        String materia = sc.nextLine();

        System.out.println("Ingrese la fecha de la tarea (dd/MM/yyyy): ");
        Validador_Fechas funciones = new Validador_Fechas();
        String fecha = funciones.validarFecha();

        System.out.println("Ingrese la hora de la tarea (HH:mm): ");
        Validador_Hora v_hora = new Validador_Hora();
        String hora = v_hora.validarHora();

        // Guardar la tarea en la lista
        tareas[indiceTareas] = new String[]{tema, descripcion, materia, fecha, hora};
        indiceTareas++;
        System.out.println("Tarea agregada exitosamente.");
    }

    
    public void exportarACSV() {
        String[] columnas = {"Tema", "Descripción", "Materia", "Fecha", "Hora"}; 

        try {
            // Verificar si el archivo ya existe y tiene contenido
            boolean archivoExiste = new java.io.File(NOMBRE_ARCHIVO).exists();

            FileWriter writer = new FileWriter(NOMBRE_ARCHIVO, true);

            // Si el archivo está vacío, escribir los encabezados
            if (!archivoExiste || new java.io.File(NOMBRE_ARCHIVO).length() == 0) {
                writer.append(String.join(",", columnas)).append("\n");
            }

            for (String[] tarea : tareas) {
                writer.append(String.join(",", tarea)).append("\n");
            }

            tareas = new String[100][5];
            indiceTareas = 0;
            
            writer.close();

            System.out.println("Tareas exportadas exitosamente al archivo: " + NOMBRE_ARCHIVO);
        } catch (IOException e) {
            System.out.println("Error al exportar las tareas: " + e.getMessage());
        }
    }
}
