package com.alura.conversordemonedas.clases;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Historial {
    List<String> listaTransacciones = new ArrayList<>();


    public void agregarHistorial(String registro){
        // Capturar la hora actual del sistema
        LocalDateTime fecha = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("hh:mm:ss dd-MM-yyyy");
        String fechaFormateada = fecha.format(formato);
        listaTransacciones.add(fechaFormateada + " - " + registro);
    }

    public void mostrarHistorial(){
        for (String registro: listaTransacciones) {
            System.out.println(registro);
        }
        System.out.println("\n");
    }


}
