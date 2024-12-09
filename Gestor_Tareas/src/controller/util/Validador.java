package controller.util;

import java.util.Scanner;

import controller.Funciones;

public class Validador {
    private Scanner sc = new Scanner(System.in);

    // Método para validar la fecha
    public String validarFecha() {
        String fecha_ingresada = "";
        String fecha = "";
        boolean fecha_valida = false;
        int año_actual = 2024;  

        
        while (!fecha_valida) {

            fecha_ingresada = sc.nextLine().trim(); 
            fecha = Validador.validadorEspacios(fecha_ingresada);

            // Condicional para que podamos ingresar la fecha sin "/"
            if (fecha.length() == 8) { 
                String formato_dd = fecha.substring(0, 2); // Substring = dia = 2 primero digitos
                int dia = Funciones.transformStringInt(formato_dd); 
                String mm = fecha.substring(2, 4); // Substring = mes = 2 siguientes digitos
                String yyyy = fecha.substring(4, 8); // Substring = año = los ultimos 4 digitos
                int año = Funciones.transformStringInt(yyyy);

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
                int dia = Funciones.transformStringInt(formato_dd);
                String mm = fecha.substring(3, 5);
                String yyyy = fecha.substring(6,10);
                int año = Funciones.transformStringInt(yyyy);
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

    public static String validadorEspacios (String txt){
        String txt_validado= "";


        for (int i = 0; i < txt.length(); i++){
            char txt_posicion = txt.charAt(i); 

            if (txt_posicion != ' '){
                txt_validado += txt_posicion;
            }
        }

        return txt_validado;
    }

    

    public String validarHora (){
        String hora_ingresada = "";
        String hora = "";
        boolean hora_validada = false;
        
        while (!hora_validada){
            hora_ingresada = sc.nextLine();
            hora = Validador.validadorEspacios(hora_ingresada);

            if (hora.length() == 5) {

                String formato_hora = hora.substring(0, 2);
                int formato_hora_entero = Funciones.transformStringInt(formato_hora);
                String formato_minutos = hora.substring(3, 5);
                int formato_minutos_entero = Funciones.transformStringInt(formato_minutos);
    
                if (((formato_hora_entero >= 00) && (formato_hora_entero < 24)) && ((formato_minutos_entero >= 00)  && (formato_minutos_entero < 60))){
                    hora_validada = true;
                } else {
                    if (((formato_hora_entero >=24) && (formato_hora_entero < 00)) && ((formato_minutos_entero >= 00)  && (formato_minutos_entero < 60))) {
                        System.out.print("Ingrese una hora validad: ");
                    } else if (((formato_minutos_entero >= 60) && (formato_minutos_entero < 00)) && ((formato_hora_entero >= 00) && (formato_hora_entero < 24))){
                        System.out.print("Ingrese los minutos correstamente: ");
                    } else {
                        System.out.println("El formato de la hora no corresponde, ingrese nuevamente la hora: ");
                    }

                    
                }

                if (hora_validada) {
                    hora = formato_hora + ":" + formato_minutos;
                    System.out.println("Hora ingresada: " + hora);
                }
    
            } else if (hora.length() == 4 && hora.charAt(1) == ':') {

                String formato_hora = hora.substring(0, 1);
                int formato_hora_entero = Funciones.transformStringInt(formato_hora);
                String formato_minutos = hora.substring(2, 4);
                int formato_minutos_entero = Funciones.transformStringInt(formato_minutos);

                if (((formato_hora_entero >= 00) && (formato_hora_entero < 24)) && ((formato_minutos_entero >= 00)  && (formato_minutos_entero < 60))){
                    hora_validada = true;
                } else {
                    if (((formato_hora_entero >=24) && (formato_hora_entero < 00)) && ((formato_minutos_entero >= 00)  && (formato_minutos_entero < 60))) {
                        System.out.print("Ingrese una hora validad: ");
                    } else if (((formato_minutos_entero >= 60) && (formato_minutos_entero < 00)) && ((formato_hora_entero >= 00) && (formato_hora_entero < 24))){
                        System.out.print("Ingrese los minutos correstamente: ");
                    } else {
                        System.out.println("El formato de la hora no corresponde, ingrese nuevamente la hora: ");
                    }

                    
                }

                if (hora_validada) {
                    hora = "0" + formato_hora + ":" + formato_minutos;
                    System.out.println("Hora ingresada: " + hora);
                }

            }else if (hora.length() == 4) {
    
                String formato_hora = hora.substring(0, 2);
                int formato_hora_entero = Funciones.transformStringInt(formato_hora);
                String formato_minutos = hora.substring(2, 4);
                int formato_minutos_entero = Funciones.transformStringInt(formato_minutos);

                if (((formato_hora_entero >= 00) && (formato_hora_entero < 24)) && ((formato_minutos_entero >= 00)  && (formato_minutos_entero < 60))){
                    hora_validada = true;
                } else {
                    if (((formato_hora_entero >=24) && (formato_hora_entero < 00)) && ((formato_minutos_entero >= 00)  && (formato_minutos_entero < 60))) {
                        System.out.print("Ingrese una hora validad: ");
                    } else if (((formato_minutos_entero >= 60) && (formato_minutos_entero < 00)) && ((formato_hora_entero >= 00) && (formato_hora_entero < 24))){
                        System.out.print("Ingrese los minutos correstamente: ");
                    } else {
                        System.out.println("El formato de la hora no corresponde, ingrese nuevamente la hora: ");
                    }

                    
                }

                if (hora_validada) {
                    hora = formato_hora + ":" + formato_minutos;
                    System.out.println("Hora ingresada: " + hora);
                }
    
            } else if (hora.length() == 3) {
                String formato_hora = hora.substring(0, 1);
                int formato_hora_entero = Funciones.transformStringInt(formato_hora);
                String formato_minutos = hora.substring(1, 3);
                int formato_minutos_entero = Funciones.transformStringInt(formato_minutos);

                if (((formato_hora_entero >= 00) && (formato_hora_entero < 24)) && ((formato_minutos_entero >= 00)  && (formato_minutos_entero < 60))){
                    hora_validada = true;
                } else {
                    if (((formato_hora_entero >=24) && (formato_hora_entero < 00)) && ((formato_minutos_entero >= 00)  && (formato_minutos_entero < 60))) {
                        System.out.print("Ingrese una hora validad: ");
                    } else if (((formato_minutos_entero >= 60) && (formato_minutos_entero < 00)) && ((formato_hora_entero >= 00) && (formato_hora_entero < 24))){
                        System.out.print("Ingrese los minutos correstamente: ");
                    } else {
                        System.out.println("El formato de la hora no corresponde, ingrese nuevamente la hora: ");
                    }

                    
                }

                if (hora_validada) {
                    hora = "0" + formato_hora + ":" + formato_minutos;
                    System.out.println("Hora ingresada: " + hora);
                }
            }
        }

        
        return hora;
    }
}
