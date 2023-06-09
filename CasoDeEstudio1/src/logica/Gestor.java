package logica;

import entities.libro.Libro;
import entities.libro.LibroDAO;

public class Gestor {


    private LibroDAO libroDAO;


    public Gestor() {

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


}
