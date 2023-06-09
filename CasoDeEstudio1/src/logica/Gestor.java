package logica;

import entities.libro.Libro;
import entities.libro.LibroDAO;
import entities.persona.Cliente;
import entities.persona.ClienteDAO;

import java.sql.SQLException;
import java.util.ArrayList;

import static entities.persona.ClienteDAO.listarUsuarioTipo;

public class Gestor {


    private LibroDAO libroDAO;
    private ClienteDAO clienteDAO;
    private ClienteDAO c;


    public Gestor() {
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


}
