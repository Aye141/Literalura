package com.example.literalura;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ClienteApi {

    public String buscarLibro(String titulo) {

        try {

            String direccion = "https://gutendex.com/books/?search=" + titulo.replace(" ", "%20");

            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(direccion))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(
                    request,
                    HttpResponse.BodyHandlers.ofString()
            );

            return response.body();

        } catch (IOException | InterruptedException e) {
            return "Error al consultar la API: " + e.getMessage();
        }
    }
    public String obtenerLibros() {

        try {

            String direccion = "https://gutendex.com/books/";

            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(direccion))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(
                    request,
                    HttpResponse.BodyHandlers.ofString()
            );

            return response.body();

        } catch (IOException | InterruptedException e) {
            return "Error al consultar la API: " + e.getMessage();
        }
    }
}