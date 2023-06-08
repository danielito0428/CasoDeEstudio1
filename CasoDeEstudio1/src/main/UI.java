
package main;
import logica.Gestor;

import java.util.Scanner;

public class UI {
    private static Scanner scanner;
    private static Gestor appGestor;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        appGestor = new Gestor();
        int opcion;

        do {
            opcion = obtenerOpcionMenu();

            switch (opcion) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:


                    break;
                case 5:


                    break;
                case 6:

                    break;
                default:

                    break;
            }
            System.out.println();
        } while (opcion != 6);

    }
    public static void print(String pText){
        print(pText, true);
    }

    public static void print(String pText, Boolean pLinea){
        if (pLinea)
            System.out.println(pText);
        else
            System.out.print(pText);
    }

    public static int obtenerOpcionMenu(){
        print("MENU PRINCIPAL");
        print("1. Arrancar");
        print("2. Apagar");
        print("3. Avanzar");
        print("4. Detener");
        print("5. Retroceder");
        print("6. Salir");
        print("Seleccione una opción: ");

        return scanner.nextInt();
    }
}