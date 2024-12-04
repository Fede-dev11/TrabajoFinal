package controller;

import java.util.Scanner;

import controller.Dependecias.Agregar_Tarea;

public class Menu {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        System.out.println("-----GESTOR DE TAREAS-----"); // menu inicial
        System.out.println("Buenos dias usuario, que es lo que necesita el dia de hoy?");
        System.out.println("1. Agregar nueva tarea");
        System.out.println("2. Buscar Tarea");
        System.out.println("3. Modificar tarea ingresada");
        System.out.println("4. Eliminar tarea");
        System.out.println("5. Revisar estado de tareas agregadas");
        System.out.println("6. Mostrar Tareas Completadas");
        System.out.println("7. Mostar Tareas por hacer");
        System.out.println("8. Mostrar Tareas por Materias");
        System.out.println("9. Agregar Notas a tareas calificadas");
        System.out.println("10. Salir de la aplicacion");
        int menuselect = sn.nextInt();
        sn.nextLine();
        switch (menuselect) {
            case 1:
           Agregar_Tarea A_T = new Agregar_Tarea();
            A_T.Agrega();
                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            case 5:

                break;
            case 10: 
            menuselect= 10;
            System.out.println("Gracias por preferirnos <3");
                break;

            default:
            System.out.println("Ingrese un numero que este entre el rango de 1 a 10");
                break;
        }
        sn.close();
    }

}
