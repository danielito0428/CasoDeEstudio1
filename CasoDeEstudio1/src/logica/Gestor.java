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


    private LibroDAO libroDAO;
    private ClienteDAO clienteDAO;
    private ClienteDAO c;
    private PrestamoDAO prestamoDAO;
    private Cliente clien;


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


    public String insertarLibro(int id, String titulo,String autor,String cat,String disp, int cant) {
        Libro tmpLibro = new Libro(id,titulo,autor,cat,disp,cant);
            LibroDAO.insertarLibro(tmpLibro);
        return "Se agrego un libro";
    }
    public void insertarLibro1(Libro libro) {
        LibroDAO.insertarLibro(libro);

    }
    public void insertarCliente(Cliente c){
        ClienteDAO.insertarCliente(c);
    }

    public ArrayList<Cliente> listarUsuarios() throws SQLException, ClassNotFoundException {
        return new ArrayList<>(ClienteDAO.listarUsuarioTipo());
    }
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

    public void regresarLibro(int idPrestamo,String fechaFin,int idLibro){
        Prestamo tmpPrestamoR = new Prestamo(idPrestamo,fechaFin);
        prestamoDAO.registrarEntrega(idPrestamo,fechaFin);
        LibroDAO.cambiarEstadoLibroDev(idLibro);
    }

    public ArrayList<String> listarLibrosPrestados(){
        return new ArrayList<>(LibroDAO.listarLibrosPrestados());
    }
    public ArrayList<Libro> mostrarLibrosDisp(){
        return  new ArrayList<>(LibroDAO.mostrarLibrosDisponibles());
    }

    public ArrayList<String> listarTitulos(){
        return new ArrayList<>(LibroDAO.buscarLibross());
    }



}
