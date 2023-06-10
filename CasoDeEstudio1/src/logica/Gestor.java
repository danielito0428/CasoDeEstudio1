package logica;

import entities.libro.Libro;
import entities.libro.LibroDAO;
import entities.persona.Cliente;
import entities.persona.ClienteDAO;
import entities.prestamo.Prestamo;
import entities.prestamo.PrestamoDAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import static entities.persona.ClienteDAO.listarUsuarioTipo;
import static entities.persona.ClienteDAO.obtenerClientePorEstado;

public class Gestor {

    //Declaracion de los atributos de la clase Gestor
    private LibroDAO libroDAO;
    private ClienteDAO clienteDAO;
    private ClienteDAO c;
    private PrestamoDAO prestamoDAO;
    private Cliente clien;

    //Constructor que instancia todos los atributos de la clase
    public Gestor() {
        prestamoDAO= new PrestamoDAO();
    clienteDAO = new ClienteDAO();
    c= new ClienteDAO();
     libroDAO = new LibroDAO();

    }

    /**
     * Metodos para insertar registros
     *
     */

    /*El metodo inserta los datos ingresados en el sistema para la creacion de un libro dentro del objeto respecto
    Esto se envia a la base de datos para crear el nuevo registro del libro
    Finalmente se envia un mensaje de registro exitoso*/
    public String insertarLibro(int id, String titulo,String autor,String cat,String disp, int cant) {
        Libro tmpLibro = new Libro(id,titulo,autor,cat,disp,cant);
            LibroDAO.insertarLibro(tmpLibro);
        return "Se agrego un libro";
    }
    public void insertarLibro1(Libro libro) {
        LibroDAO.insertarLibro(libro);

    }
    /*El metodo insertarCliente() recibe como parametro el objeto con la informacion del cliente
    * Posteriormente se se envia a la base de datos para su insercion*/
    public void insertarCliente(Cliente c){
        ClienteDAO.insertarCliente(c);
    }
    /*Este metodo retorna la lista de clientes permite lo que permite listarlos junto a todos sus datos*/
    public ArrayList<Cliente> listarUsuarios() throws SQLException, ClassNotFoundException {
        return new ArrayList<>(ClienteDAO.listarUsuarioTipo());
    }
    /*El metodo prestar libros recibe como parametros los atributos del objeto Prestamo
    *Se crea un objeto Cliente y se obtiene su estado actual y se hacer lo mismo con el libro
    * Despues si ambos tienen sus estado como disponible se puede efectuar el prestamo
    * En caso de no poder realizar el prestamo por no cumplir los requisitos del if se notificara mediante un mensaje*/
    public String  prestarLibro(int idPrestamo,String tag,int idLibro,String fechaInicio){
        Cliente cliente = obtenerClientePorEstado(tag);
        Libro libro =LibroDAO.obtenerLibroPorId(idLibro);
        if (cliente.getEstado().equals("Disponible")&& libro.getDisp().equals("Disponible") ){
            Prestamo tmpPrestamo = new Prestamo(fechaInicio,idPrestamo,idLibro,tag);
            prestamoDAO.registrarPrestamo(tmpPrestamo);
            LibroDAO.cambiarEstadoLibro(idLibro);
        }
        return "El usuario no está disponible para hacer préstamos.";
    }
    /*En el metodo regresarLibro() se consulta la fechaFin y el idPrestamo, para poder registrar efectivamente su devolucion*/
    public void regresarLibro(int idPrestamo,String fechaFin,int idLibro){
        Prestamo tmpPrestamoR = new Prestamo(idPrestamo,fechaFin);
        prestamoDAO.registrarEntrega(idPrestamo,fechaFin);
        LibroDAO.cambiarEstadoLibroDev(idLibro);
    }
    /*Este metodo retorna el ArrayList de los libros prestados lo que permite listarlos junto a su informacion*/
    public ArrayList<String> listarLibrosPrestados(){
        return new ArrayList<>(LibroDAO.listarLibrosPrestados());
    }
    /*El metodo retorna el ArrayList de los libros disponibles para prestamo lo que permite listarlos junto a su informacion*/
    public ArrayList<Libro> mostrarLibrosDisp(){
        return  new ArrayList<>(LibroDAO.mostrarLibrosDisponibles());
    }
    /*Este metodo retorna el ArrayList de titulos de los libros*/
    public ArrayList<String> listarTitulos(){
        return new ArrayList<>(LibroDAO.buscarLibross());
    }



}
