
package main;
import entities.persona.Admin;
import logica.Gestor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;

public class UI {
    private static Scanner scanner;
    private static Gestor appGestor;
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

    public static void main(String[] args) throws IOException {
        scanner = new Scanner(System.in);
        int opcion = -1;
        do {
            obtenerTipoUsuario();
            opcion = selecionarOpcion();
            procesarOpcion(opcion);
        } while (opcion != 0);


    }

    public static void print(String pText) {

        print(pText, true);
    }

    public static void print(String pText, Boolean pLinea) {
        if (pLinea)
            System.out.println(pText);
        else
            System.out.print(pText);
    }

    public static int obtenerOpcionMenuAdmin() {
        print("-------------------\n");
        print("MENU ADMIN");
        print("1. Registrar Libro");
        print("2. Listar Libros Prestados");
        print("3. Listar Libros Usuario");
        print("4. Listar Libros Disponibles");
        print("0. Ir al menu principal");
        print("Seleccione una opción: \n");
        print("-------------------");

        return scanner.nextInt();
    }

    public static int obtenerOpcionMenuCliente() {
        print("-------------------\n");
        print("MENU CLIENTE");
        print("1. Registrar Usuario");
        print("2. Solicitar Libro");
        print("3. Devolver Libro");
        print("0. Ir al menu principal ");
        print("Seleccione una opción: \n");
        print("-------------------");

        return scanner.nextInt();
    }

    public static void obtenerTipoUsuario() {
        print("-------------------\n");
        print("USUARIO");
        print("1. ADMIN");
        print("2. CLIENTE");
        print("0. Salir del programa\n ");
        print("-------------------");
    }

    public static void opcionesAdmin() {
        Admin a = new Admin("D","A","a@email.com","123","123456","28/04/2001","admin1","123",true,"ad1");

        int opcion;

        do {
            opcion = obtenerOpcionMenuAdmin();

            switch (opcion) {
                case 1:
                    print("Digite el id del libro: ");
                    int id = scanner.nextInt();
                    print("Digite el titulo del libro: ");
                    String titulo = scanner.next();
                    print("Digite el autor del libro: ");
                    String autor = scanner.next();
                    print("Digite la categoria del libro: ");
                    String cat = scanner.next();
                    print("Digite la disponibilidad del libro: ");
                    String disp = scanner.next();
                    print("Digite la canitidad de copias del libro: ");
                    int cant = scanner.nextInt();
                     appGestor.insertarLibro1(a.registrarLibro(id,titulo,autor,cat,disp,cant));


                    break;
                case 2:
                    print("2");
                    break;
                case 3:
                    print("3");
                    break;
                case 4:
                    print("4");
                    break;
                case 0:

                    return;

            }
            System.out.println();
        } while (opcion != 4);
    }

    public static void opcionesCliente() {

        int opcion;

        do {
            opcion = obtenerOpcionMenuCliente();

            switch (opcion) {
                case 1:
                    print("1");
                    break;
                case 2:
                    print("2");
                    break;
                case 3:
                    print("3");
                    break;
                case 0:
                    break;

            }
            System.out.println();
        } while (opcion != 0);
    }

    static int selecionarOpcion() throws IOException {
        out.print("Digite la opcion que desea: ");
        return Integer.parseInt(in.readLine());
    }

    public static void procesarOpcion(int pOpcion) throws IOException {
        switch (pOpcion) {
            case 1:
                opcionesAdmin();
                break;
            case 2:
                opcionesCliente();
                break;
            case 0:
                out.println("Gracias por usar el programa");
                break;
            default:
                out.println("Opcion Invalida!");
                break;

        }
    }
}