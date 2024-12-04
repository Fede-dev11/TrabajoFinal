package controller.Dependecias;

import java.util.Scanner;

public class Agregar_Tarea {
        public void Agrega() {
            int numeroTareas = 0; // Contareas cantidad de tareas
            boolean ejecuta = true; //Controlar Flujo app
            String[] tareas = new String[20];//Amacenarlas
            Scanner Ingresa = new Scanner(System.in); //Ingresar
            if (numeroTareas < tareas.length) {
            System.out.println("Escribe la descripcion de la Tarea: ");
            String descripcion = Ingresa.nextLine();
            tareas[numeroTareas]= descripcion;
            numeroTareas = numeroTareas + 1;
            System.out.println("Ingrese fecha de la Tarea: ");
            String Fecha = Ingresa.nextLine();
            System.out.println("Ingrese la materia de la Tarea: ");
            String Materia = Ingresa.nextLine();
            
            System.out.println("La tarea de, " +Materia+" Con la descripcion "+ descripcion +", con fecha: " + Fecha);
            System.out.println("Tarea agregada");
            } else {
            System.out.println("No hay espacio para agregar");
            }

        }
}
