package com.example.literalura;

import com.example.literalura.ClienteApi;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class LiterAluraApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(LiterAluraApplication.class, args);
    }

    @Override
    public void run(String... args) {
        mostrarMenu();
    }

    public void mostrarMenu() {

        Scanner teclado = new Scanner(System.in);
        ClienteApi cliente = new ClienteApi(); // se crea una sola vez
        int opcion = -1;

        while (opcion != 0) {

            System.out.println("""
                    -------------------------------
                    Elija una opción:
                    
                    1 - Buscar libro por título
                    2 - Listar libros registrados
                    3 - Listar autores registrados
                    4 - Listar autores vivos en un determinado año
                    5 - Listar libros por idioma
                    0 - Salir
                    -------------------------------
                    """);

            try {

                opcion = teclado.nextInt();
                teclado.nextLine();

                switch (opcion) {

                    case 1:
                        System.out.println("Ingrese el título del libro:");
                        String titulo = teclado.nextLine();

                        String respuesta = cliente.buscarLibro(titulo);

                        System.out.println("Resultado:");
                        System.out.println(respuesta);
                        break;

                    case 2:

                        ClienteApi clientes = new ClienteApi();

                        String libros = clientes.obtenerLibros();

                        System.out.println("Listado de libros:");
                        System.out.println(libros);

                        break;

                    case 3:

                        ClienteApi cliente2 = new ClienteApi();

                        String autores = cliente2.obtenerLibros();

                        System.out.println("Listado de autores:");
                        System.out.println(autores);

                        break;
                    case 4:
                        System.out.println("Ingrese el año:");
                        int anio = teclado.nextInt();
                        teclado.nextLine();
                        System.out.println("Buscando autores vivos en " + anio);
                        break;

                    case 5:
                        System.out.println("""
                                Ingrese el idioma:
                                es - Español
                                en - Inglés
                                fr - Francés
                                pt - Portugués
                                """);

                        String idioma = teclado.nextLine();
                        System.out.println("Buscando libros en idioma: " + idioma);
                        break;

                    case 0:
                        System.out.println("Cerrando aplicación...");
                        break;

                    default:
                        System.out.println("Opción inválida.");
                }

            } catch (Exception e) {
                System.out.println("Entrada inválida.");
                teclado.nextLine();
            }
        }

        teclado.close();
    }
}