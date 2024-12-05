package controller;

import java.util.Scanner;
import controller.Dependecias.Agregar_Tarea;
import controller.Dependecias.Buscar_Tarea;
import controller.Dependecias.Mostrar_Tareas;


public class Menu {
<<<<<<< HEAD
    
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

=======
    public void ejecuta_Menu() {

>>>>>>> 74588c1 (Actulizacion 0.0.02)
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
    

    Scanner sc = new Scanner(System.in); // Scanner como atributo
    boolean menu_bucle = true; // Variable de instancia

    // Método para regresar al menú
    public void regresarMenu() {
        System.out.println(" ");
        System.out.println("¿Desea volver al menú?");
        System.out.println("1. SI");
        System.out.println("2. NO");
        System.out.print("Ingrese su respuesta: ");
        int reg_menu = sc.nextInt();
        if (reg_menu == 1) {
            System.out.println("Regresando al menú...");
            System.out.println(" ");
        } else if (reg_menu == 2) {
            System.out.println("Saliendo del programa...");
            menu_bucle = false; // Salir del bucle
        }
    }

    // Método principal del menú
    public void menu() {
        while (menu_bucle) {
            System.out.println("------------------BIENVENIDOS----------------------");
            System.out.println("-----GESTOR DE TAREAS-----");
            System.out.println("1. Agregar nueva tarea");
            System.out.println("2. Buscar Tarea");
            System.out.println("3. Modificar tarea ingresada");
            System.out.println("4. Eliminar tarea");
            System.out.println("5. Revisar estado de tareas agregadas");
            System.out.println("6. Mostrar Tareas Completadas");
            System.out.println("7. Mostrar Tareas por hacer");
            System.out.println("8. Mostrar Tareas por Materias");
            System.out.println("9. Agregar Notas a tareas calificadas");
            System.out.println("10. Salir de la aplicación");
            System.out.println("---------------------------------------------------");
            System.out.print("Menú: ");
            int opcion = sc.nextInt();
            System.out.println(" ");

            switch (opcion) {
                case 1:
                    boolean agregarOtra = true;
                    Agregar_Tarea gestorTareas = new Agregar_Tarea(); // Instancia de clase externa
                    while (agregarOtra) {
                        gestorTareas.Agrega(); // Llamado al método para agregar tarea
                        System.out.println("¿Desea agregar otra tarea?");
                        System.out.println("1. SI");
                        System.out.println("0. NO");
                        System.out.print("Ingrese su respuesta: ");
                        int respuesta = sc.nextInt();
                        sc.nextLine(); // Consumir el salto de línea
                        if (respuesta != 1) {
                            agregarOtra = false; // Salir del bucle si elige "No"
                        }
                    }
                    System.out.print("Ingrese el nombre del archivo para exportar (por ejemplo, tareas.csv): ");
                    String nombreArchivo = sc.nextLine();
                    gestorTareas.exportarACSV(nombreArchivo); // Usar la instancia para exportar tareas
                    regresarMenu(); // Regresar al menú
                    break;
                case 2:
                    System.out.print("Ingrese el nombre del archivo CSV para buscar tareas (por ejemplo, tareas.csv): ");
                    sc.nextLine(); // Consumir el salto de línea
                    String archivoBusqueda = sc.nextLine();
                    Buscar_Tarea buscador = new Buscar_Tarea();
                    buscador.buscarEnCSV(archivoBusqueda); // Llamar al método para buscar tareas
                    regresarMenu(); // Regresar al menú
                    break;
                case 3:
                    System.out.println("Ingrese el nombre del archivo: ");
                    sc.nextLine();  
                    nombreArchivo = sc.next();  // Usamos sc directamente para leer la entrada
                    Mostrar_Tareas mostrar_Tareas = new Mostrar_Tareas();
                    mostrar_Tareas.mostrarTareasDesdeCSV(nombreArchivo);  // Llamar a la función para mostrar las tareas
                    regresarMenu(); // Regresar al menú
                    break;
                
                
                case 10:
                    System.out.println(" ");
                    System.out.println("Gracias por usar nuestro sistema. ¡Hasta pronto!");
                    System.out.println(" ");
                    menu_bucle = false; // Salir del bucle
                    break;
                default:
                    System.out.println("Por favor, ingrese una opción válida del menú.");
                    break;
            }
        }
        sc.close(); // Cerrar scanner
    }

    // Método main para iniciar el menú

}
