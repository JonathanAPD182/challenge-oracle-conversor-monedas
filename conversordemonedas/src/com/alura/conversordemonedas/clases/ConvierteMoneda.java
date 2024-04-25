package com.alura.conversordemonedas.clases;

import com.alura.conversordemonedas.record.Moneda;
import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConvierteMoneda {

    public Moneda convertirMoneda(String monedaOrigen, String monedaDestino, double monto){

        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/460c7372dd2a0ae5dd8c8a24/pair/"+monedaOrigen+"/"+monedaDestino+"/"+monto);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        try {
            HttpResponse<String> response = null;
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Moneda.class);
        }catch (Exception e){
            throw new RuntimeException("La divisa digitada no se encuentra en la base de datos, Utilice una que se encuentre en el menú principal");
        }

    }

}
