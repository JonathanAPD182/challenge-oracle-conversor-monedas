package com.alura.conversordemonedas.principal;

import com.alura.conversordemonedas.clases.ConvierteMoneda;
import com.alura.conversordemonedas.clases.Historial;
import com.alura.conversordemonedas.record.Moneda;

import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        var ciclo = true;
        Historial historial = new Historial();

        System.out.println("***************************************************************");
        System.out.println("**          Bienvenido/a al conversor de monedas             **");
        System.out.println("***************************************************************");
        System.out.println("** Algunos de los códigos de monedas disponibles son:        **");
        System.out.println("--------------------------------------------------------------|");
        System.out.println("| Código de moneda |   Nombre de moneda   |       País        |");
        System.out.println("--------------------------------------------------------------|");
        System.out.println("|       USD        | Dólar estadounidense |  Estados Unidos   |");
        System.out.println("|       ARS        | Peso argentino       |  Argentina        |");
        System.out.println("|       COP        | Peso colombiano      |  Colombia         |");
        System.out.println("|       UYU        | Peso uruguayo        |  Uruguay          |");
        System.out.println("|       MXN        | Peso mexicano        |  Mexico           |");
        System.out.println("|       CLP        | Peso chileno         |  Chile            |");
        System.out.println("|       BRL        | Real brasileño       |  Brazil           |");
        System.out.println("|       CAD        | Dólar canadiense     |  Canada           |");
        System.out.println("|       CNY        | Renminbi chino       |  China            |");
        System.out.println("|       INR        | Rupia india          |  India            |");
        System.out.println("|-------------------------------------------------------------|");

        while (ciclo) {
            System.out.println("***************************************************************");
            System.out.println("** Digite una de las siguientes opciones validas:            **");
            System.out.println("**    1. Conversor de Monedas:                               **");
            System.out.println("**    2. Historial de Conversiones                           **");
            System.out.println("**    3. Salir:                                              **");
            System.out.println("***************************************************************");

            ConvierteMoneda convertir = new ConvierteMoneda();

            try {
                var opcion = Integer.valueOf(teclado.nextLine());

                switch (opcion){
                    case 1:
                        try {
                            System.out.println("** Digite código de la moneda local :                          **");
                            var monedaOrigen = teclado.nextLine().toUpperCase();
                            System.out.println("** Digite el código de la moneda que desea calcular u obtener: **");
                            var monedaDestino = teclado.nextLine().toUpperCase();
                            System.out.println("** Digite el valor o monto que desea calcular:                 **");
                            var monto = Double.valueOf(teclado.nextLine());
                            Moneda moneda = convertir.convertirMoneda(monedaOrigen, monedaDestino, monto);
                            var registro = "El valor de " + monto + " [" + moneda.base_code() + "] corresponde al valor final de: " + moneda.conversion_result() + " [" + moneda.target_code() + "].";
                            historial.agregarHistorial(registro);
                            System.out.println("\n" + registro + "\n");
                        } catch (RuntimeException e) {
                            System.out.println(e.getMessage());
                            System.out.println("Finalizando la aplicación");
                        }
                        break;
                    case 2:
                        historial.mostrarHistorial();
                        break;
                    case 3:
                        System.out.println("Terminando Programa! ");
                        ciclo=false;
                        break;
                    default:
                        System.out.println("Opción no valida");
                }

            }catch (NumberFormatException e){
                System.out.println("La opción digitada no es valida! Intente nuevamente con una de las opciones que se muestran a continuación: \n");
            }
        }
    }
}
