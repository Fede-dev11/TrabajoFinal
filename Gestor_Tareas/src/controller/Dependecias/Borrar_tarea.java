package controller.Dependecias;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Borrar_tarea {

    private Scanner sc = new Scanner(System.in);

    // Método para eliminar una tarea
    public void eliminarTarea(String nombreArchivo) {
        ArrayList<String[]> tareas = cargarTareas(nombreArchivo);

        if (tareas.isEmpty()) {
            System.out.println("No hay tareas disponibles para eliminar.");
            return;
        }

        // Mostrar tareas disponibles
        for (int i = 0; i < tareas.size(); i++) {
            String[] tarea = tareas.get(i);
            System.out.println((i + 1) + ". Tema: " + tarea[0] + ", Descripción: " + tarea[1] +", Materia: " + tarea[2] + ", Fecha: " + tarea[3] + ", Hora: " + tarea[4]);
        }

        // Solicitar tarea a eliminar
        System.out.print("Ingrese el número de la tarea que desea eliminar: ");
        int indice = sc.nextInt() - 1;
        sc.nextLine(); // Consumir la línea restante

        if (indice < 0 || indice >= tareas.size()) {
            System.out.println("Número inválido.");
            return;
        }

        // Eliminar y guardar cambios
        tareas.remove(indice);
        guardarTareas(nombreArchivo, tareas);
        System.out.println("Tarea eliminada exitosamente.");
    }

    // Método para cargar tareas desde el archivo
    private ArrayList<String[]> cargarTareas(String nombreArchivo) {
        ArrayList<String[]> tareas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            br.readLine(); // Saltar encabezado
            String linea;
            while ((linea = br.readLine()) != null) {
                tareas.add(linea.split(","));
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        return tareas;
    }

    // Método para guardar tareas en el archivo
    private void guardarTareas(String nombreArchivo, ArrayList<String[]> tareas) {
        try (FileWriter writer = new FileWriter(nombreArchivo)) {
            writer.write("Tema,Descripción,Materia,Fecha,Hora\n");
            for (String[] tarea : tareas) {
                writer.write(String.join(",", tarea) + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo: " + e.getMessage());
        }
    }
}

