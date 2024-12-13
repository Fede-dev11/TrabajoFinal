package controller.util;

import java.util.Scanner;

import controller.util.Utilidades;
import controller.util.Validador_Fechas;

public class Validador_Hora {

    public String validarHora() {
        Scanner sc = new Scanner(System.in);
        String hora_ingresada = "";
        String hora = "";
        boolean hora_validada = false;

        while (!hora_validada) {
            hora_ingresada = sc.nextLine();
            hora = Validador_Fechas.validadorEspacios(hora_ingresada);

            if (hora.length() == 5) {

                String formato_hora = hora.substring(0, 2);
                int formato_hora_entero = Utilidades.transformStringToInt(formato_hora);
                String formato_minutos = hora.substring(3, 5);
                int formato_minutos_entero = Utilidades.transformStringToInt(formato_minutos);

                if (((formato_hora_entero >= 00) && (formato_hora_entero < 24))
                        && ((formato_minutos_entero >= 00) && (formato_minutos_entero < 60))) {
                    hora_validada = true;
                } else {
                    if (((formato_hora_entero >= 24) && (formato_hora_entero < 00))
                            && ((formato_minutos_entero >= 00) && (formato_minutos_entero < 60))) {
                        System.out.print("Ingrese una hora validad: ");
                    } else if (((formato_minutos_entero >= 60) && (formato_minutos_entero < 00))
                            && ((formato_hora_entero >= 00) && (formato_hora_entero < 24))) {
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
                int formato_hora_entero = Utilidades.transformStringToInt(formato_hora);
                String formato_minutos = hora.substring(2, 4);
                int formato_minutos_entero = Utilidades.transformStringToInt(formato_minutos);

                if (((formato_hora_entero >= 00) && (formato_hora_entero < 24))
                        && ((formato_minutos_entero >= 00) && (formato_minutos_entero < 60))) {
                    hora_validada = true;
                } else {
                    if (((formato_hora_entero >= 24) && (formato_hora_entero < 00))
                            && ((formato_minutos_entero >= 00) && (formato_minutos_entero < 60))) {
                        System.out.print("Ingrese una hora validad: ");
                    } else if (((formato_minutos_entero >= 60) && (formato_minutos_entero < 00))
                            && ((formato_hora_entero >= 00) && (formato_hora_entero < 24))) {
                        System.out.print("Ingrese los minutos correstamente: ");
                    } else {
                        System.out.println("El formato de la hora no corresponde, ingrese nuevamente la hora: ");
                    }

                }

                if (hora_validada) {
                    hora = "0" + formato_hora + ":" + formato_minutos;
                    System.out.println("Hora ingresada: " + hora);
                }

            } else if (hora.length() == 4) {

                String formato_hora = hora.substring(0, 2);
                int formato_hora_entero = Utilidades.transformStringToInt(formato_hora);
                String formato_minutos = hora.substring(2, 4);
                int formato_minutos_entero = Utilidades.transformStringToInt(formato_minutos);

                if (((formato_hora_entero >= 00) && (formato_hora_entero < 24))
                        && ((formato_minutos_entero >= 00) && (formato_minutos_entero < 60))) {
                    hora_validada = true;
                } else {
                    if (((formato_hora_entero >= 24) && (formato_hora_entero < 00))
                            && ((formato_minutos_entero >= 00) && (formato_minutos_entero < 60))) {
                        System.out.print("Ingrese una hora validad: ");
                    } else if (((formato_minutos_entero >= 60) && (formato_minutos_entero < 00))
                            && ((formato_hora_entero >= 00) && (formato_hora_entero < 24))) {
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
                int formato_hora_entero = Utilidades.transformStringToInt(formato_hora);
                String formato_minutos = hora.substring(1, 3);
                int formato_minutos_entero = Utilidades.transformStringToInt(formato_minutos);

                if (((formato_hora_entero >= 00) && (formato_hora_entero < 24))
                        && ((formato_minutos_entero >= 00) && (formato_minutos_entero < 60))) {
                    hora_validada = true;
                } else {
                    if (((formato_hora_entero >= 24) && (formato_hora_entero < 00))
                            && ((formato_minutos_entero >= 00) && (formato_minutos_entero < 60))) {
                        System.out.print("Ingrese una hora validad: ");
                    } else if (((formato_minutos_entero >= 60) && (formato_minutos_entero < 00))
                            && ((formato_hora_entero >= 00) && (formato_hora_entero < 24))) {
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