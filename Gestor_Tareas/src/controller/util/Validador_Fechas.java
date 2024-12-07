package controller.util;


import java.util.Scanner;

import controller.util.Utilidades;

public class Validador_Fechas {

    private Scanner sc = new Scanner(System.in);

    // Método para validar la fecha
    public String validarFecha() {
        String fecha = "";
        boolean fecha_valida = false;
        int año_actual = 2024;  

        
        while (!fecha_valida) {

            fecha = sc.nextLine().trim(); 

            // Condicional para que podamos ingresar la fecha sin "/"
            if (fecha.length() == 8) { 
                String formato_dd = fecha.substring(0, 2); // Substring = dia = 2 primero digitos
                int dia = Utilidades.transformStringToInt(formato_dd); 
                String mm = fecha.substring(2, 4); // Substring = mes = 2 siguientes digitos
                String yyyy = fecha.substring(4, 8); // Substring = año = los ultimos 4 digitos
                int año = Utilidades.transformStringToInt(yyyy);

                System.out.println(formato_dd + "  " + mm + "   " + yyyy); // provisional para hacer la prueba ya que no me funciona

                
                if ((mm.equals("01") || mm.equals("03") || mm.equals("05") || mm.equals("07") || mm.equals("08") || mm.equals("10") || mm.equals("12")) && (dia <= 31) && (año >= año_actual)) {
                    fecha_valida = true;
                } else if ((mm.equals("04") || mm.equals("06") || mm.equals("09") || mm.equals("11")) && (dia <= 30) && (año >= año_actual)) {
                    fecha_valida = true;
                } else if (mm.equals("02") && (dia <= 28) && (año >= año_actual)) { 
                    fecha_valida = true;
                } else {
                    
                    //para validar cual es el error en la fecha

                    if ((mm.equals("01") || mm.equals("03") || mm.equals("05") || mm.equals("07") || mm.equals("08") || mm.equals("10") || mm.equals("12")) && (dia > 31) && (año >= año_actual)) {
                        System.out.print("El dia ingresado no existe, ingres nuevamente la fecha: ");
                    } else if ((mm.equals("04") || mm.equals("06") || mm.equals("09") || mm.equals("11")) && (dia > 30) && (año >= año_actual)) {
                        System.out.print("El dia ingresado no existe, ingres nuevamente la fecha: ");
                    } else if (mm.equals("02") && (dia > 28) && (año >= año_actual)) { 
                        System.out.print("El dia ingresado no existe, ingres nuevamente la fecha: ");
                    } else if (año < año_actual){
                        System.out.print("El año ingresado no es valido, ingrese nuevamente la fecha: ");
                    }
                }

                if (fecha_valida) {
                    fecha = formato_dd + "/" + mm + "/" + yyyy;
                    System.out.println("La fecha ingresada es: " + fecha);
                }

            // Condicional para ingresar la fecha con "/"

            } else if (fecha.length() == 10) {
                String formato_dd = fecha.substring(0, 2);
                int dia = Utilidades.transformStringToInt(formato_dd);
                String mm = fecha.substring(3, 5);
                String yyyy = fecha.substring(6,10);
                int año = Utilidades.transformStringToInt(yyyy);
                System.out.println(formato_dd + "  " + mm + "   " + yyyy);

                
                if ((mm.equals("01") || mm.equals("03") || mm.equals("05") || mm.equals("07") || mm.equals("08") || mm.equals("10") || mm.equals("12")) && (dia <= 31) && (año >= año_actual)) {
                    fecha_valida = true;
                } else if ((mm.equals("04") || mm.equals("06") || mm.equals("09") || mm.equals("11")) && (dia <= 30) && (año >= año_actual)) {
                    fecha_valida = true;
                } else if (mm.equals("02") && (dia <= 28) && (año >= año_actual)) { 
                    fecha_valida = true;
                } else {

                    //para validar cual es el error en la fecha

                    if ((mm.equals("01") || mm.equals("03") || mm.equals("05") || mm.equals("07") || mm.equals("08") || mm.equals("10") || mm.equals("12")) && (dia > 31) && (año >= año_actual)) {
                        System.out.print("El dia ingresado no existe, ingres nuevamente la fecha: ");
                    } else if ((mm.equals("04") || mm.equals("06") || mm.equals("09") || mm.equals("11")) && (dia > 30) && (año >= año_actual)) {
                        System.out.print("El dia ingresado no existe, ingres nuevamente la fecha: ");
                    } else if (mm.equals("02") && (dia > 28) && (año >= año_actual)) { 
                        System.out.print("El dia ingresado no existe, ingres nuevamente la fecha: ");
                    } else if (año < año_actual){
                        System.out.print("El año ingresado no es valido, ingrese nuevamente la fecha: ");
                    }
                }

                if (fecha_valida) {
                    fecha = formato_dd + "/" + mm + "/" + yyyy;
                    System.out.println("La fecha ingresada es: " + fecha);
                }

            } else {
                System.out.print("La fecha no corresponde al formato, ingrese nuevamente la fecha: ");
                fecha_valida = false; 
            }
        }

        return fecha; 
    }


}