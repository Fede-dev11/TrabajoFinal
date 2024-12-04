package controller;

import java.util.Scanner;

import controller.Dependecias.Agregar_Tarea;


public class Menu {
    
    Scanner sc = new Scanner(System.in);
    boolean menu_bucle = true;

    public void regresarMenu (){

        System.out.println(" ");
        System.out.println("¿Desea volver al menu?");
        System.out.println("1. SI");
        System.out.println("2. NO");
        System.out.print("Ingrese su respuesta: ");
        int reg_menu = sc.nextInt();
        if (reg_menu == 1) {
            System.out.println("Regresando al menu");
            System.out.println(" ");
        } else if (reg_menu == 2){
            System.out.println("Saliendo del programa ........");
            menu_bucle = false;
        } 

    }
    public void menu () {
        Menu app = new Menu();
        Scanner sc = app.sc;

        while (app.menu_bucle) {
            System.out.println("------------------BIENVENIDOS----------------------");
            System.out.println("-----GESTOR DE TAREAS-----"); // menu inicial
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
            System.out.println("---------------------------------------------------");
            System.out.print("Menu: ");
            int menu = sc.nextInt();
            System.out.println(" ");

            switch (menu) {
                case 1:

                    Agregar_Tarea A_T = new Agregar_Tarea();
                    A_T.Agrega();
                    app.regresarMenu(); // clase para retornar al menu
                    
                    break;
                case 2:
 
                    
                    app.regresarMenu(); // clase para retornar al menu

                    break;
                case 3:

                    
                    app.regresarMenu(); // clase para retornar al menu

                    break;
                case 4:

                    
                    app.regresarMenu(); // clase para retornar al menu

                    break;
                case 5:

                    
                    app.regresarMenu(); // clase para retornar al menu

                    break;
                case 6:

                    
                    app.regresarMenu(); // clase para retornar al menu

                    break;
                case 7:

                    
                    app.regresarMenu(); // clase para retornar al menu

                    break;
                case 8:

                    
                    app.regresarMenu(); // clase para retornar al menu

                    break;
                case 9:

                    
                    app.regresarMenu(); // clase para retornar al menu

                    break;
                case 10:

                    System.out.println(" ");
                    System.out.println("Gracias por ocupar nuestro sistema, esperamos volverle a ver pronto");
                    System.out.println(" ");
                    app.menu_bucle = false; 

                    break;

              
            
                default:
                    System.out.println("Porfavor, sea muy amable de ingresar una opción valida del menu");
                    
                    break;
            }
        }
        
    }
    

}
