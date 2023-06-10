
package main;
import entities.libro.Libro;
import entities.persona.Admin;
import entities.persona.Cliente;
import entities.prestamo.Prestamo;
import logica.Gestor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.sql.SQLException;
import java.util.Scanner;

public class UI {
    //Se declaran los atributos de la clase UI
    private static Scanner scanner;
     private static Gestor appGestor = new Gestor();
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;
    /*Al ingresar un numero del 1 al 2 permitira obtener el tipo de usuario
    *Se mostrara en pantalla un menu dependiendo de cada tipo de usuario*/
    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        scanner = new Scanner(System.in);
        int opcion = -1;
        do {
            obtenerTipoUsuario();
            opcion = selecionarOpcion();
            procesarOpcion(opcion);
        } while (opcion != 0);


    }
    /*Metodo que permite mostrar texto en pantalla*/
    public static void print(String pText) {

        print(pText, true);
    }
    /*En este metodo se recibe una linea de texto para posteriormente mandarlo a imprimir*/
    public static void print(String pText, Boolean pLinea) {
        if (pLinea)
            System.out.println(pText);
        else
            System.out.print(pText);
    }
    //Menu de administrador
    public static int obtenerOpcionMenuAdmin() {
        print("-------------------\n");
        print("MENU ADMIN");
        print("1. Registrar Libro");
        print("2. Listar Libros Prestados");
        print("3. Listar Libros Usuario");
        print("4. Listar Libros Disponibles");
        print("5. Listar Usuarios");
        print("0. Ir al menu principal");
        print("Seleccione una opción: \n");
        print("-------------------");

        return scanner.nextInt();
    }
    //Menu de Cliente
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
    //Menu de tipo de usuario
    public static void obtenerTipoUsuario() {
        print("-------------------\n");
        print("USUARIO");
        print("1. ADMIN");
        print("2. CLIENTE");
        print("0. Salir del programa\n ");
        print("-------------------");
    }
    /*El metodo opcionesAdmin() permite al administrador efectuar varias funciones segun el numero que ingrese
    * La opcion 1 permite al administrador registrar libros y se le pediran los datos respectivos para efectuar el registro
    * La opcion 2 permite al administrador listar los libros que se encuentran actualmente prestados
    * La opcion 3 muestra un listado de los titulos de los libros
    * La opcion 4 permite visualizar los libros que se encuentran disponibles para ser prestados
    * La opcion 5 permite ver un listado de todos los usuarios registrados en el sistema
    * Si se ingresa el 0 como una opcion se volvera al menu de tipo de usuario*/
    public static void opcionesAdmin() throws SQLException, ClassNotFoundException {

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
                    for(String libros: appGestor.listarLibrosPrestados())
                        print(libros);
                    break;
                case 3:
                    for (String l: appGestor.listarTitulos())

                        print(l);

                    break;
                case 4:
                    print("4");
                    appGestor.mostrarLibrosDisp();
                    for (Libro b: appGestor.mostrarLibrosDisp()){
                        print(b.toString());
                    }

                    break;
                case 5:
                    appGestor.listarUsuarios();
                      for(Cliente c: appGestor.listarUsuarios()){
                          print(c.toString());
                      }
                    break;
                case 0:

                    return;

            }
            System.out.println();
        } while (opcion != 0);
    }
    /*El metodo opcionesCliente() permite al cliente efectuar varias funciones segun el numero que ingrese
     * La opcion 1 permite al cliente registrarse, se le pediran los datos necesarios para poder registrar a un cliente en la base de datos
     * La opcion 2 permite a un cliente ya registrado poder pedir prestamos ingresando la informacion necesaria
     * La opcion 3 permite devolver un libro ya prestado anteriormente ingresando los datos del prestamo previamente hecho
     * Si se ingresa el 0 como una opcion se volvera al menu de tipo de usuario*/
    public static void opcionesCliente() {
        int opcion;
        do {
            opcion = obtenerOpcionMenuCliente();
            switch (opcion) {
                case 1:
                    print("Digite su nombre: ");
                    String nombre = scanner.next();
                    print("Digite su apellido ");
                    String apellido = scanner.next();
                    print("Digite su direccion de correo electronico ");
                    String direccion = scanner.next();
                    print("Digite su numero de cedula");
                    String cedula = scanner.next();
                    print("Digite su numero de telefono ");
                    String telefono = scanner.next();
                    print("Digite su fecha de nacimiento ");
                    String fNacimiento = scanner.next();
                    print("Digite su nombre de usuario");
                    String usuario = scanner.next();
                    print("Digite su contrasenia ");
                    String contrasenia = scanner.next();
                    String estado = "activo";
                    Cliente c = new Cliente(nombre,apellido,direccion,cedula,telefono,fNacimiento,usuario,contrasenia,estado);
                    appGestor.insertarCliente(c);
                    break;
                case 2:
                    print("Digite el id de prestamo ");
                    int idPrestamo = scanner.nextInt();
                    print("Digite su usuario ");
                    String tag = scanner.next();
                    print("Digite el id del libro ");
                    int idLibro = scanner.nextInt();
                    print("Digite de inicio del prestamo ");
                    String fechaInicio = scanner.next();
                    appGestor.prestarLibro(idPrestamo,tag,idLibro,fechaInicio);
                    break;
                case 3:
                    print("Digite el id de prestamo ");
                    int idPrest = scanner.nextInt();
                    print("Ingrese la fecha ");
                    String fechaf = scanner.next();
                    print("Digite el id del libro ");
                    int idLibr = scanner.nextInt();
                    appGestor.regresarLibro(idPrest,fechaf,idLibr);
                    break;
                case 0:
                    break;

            }
            System.out.println();
        } while (opcion != 0);
    }
    //El metodo seleccionarOpcion() permite leer el numero que se ingresa en las opciones de cada menu
    static int selecionarOpcion() throws IOException {
        out.print("Digite la opcion que desea: ");
        return Integer.parseInt(in.readLine());
    }
    //El metodo permite seleccionar entre la interfaz de administrador y de cliente
    public static void procesarOpcion(int pOpcion) throws IOException, SQLException, ClassNotFoundException {
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