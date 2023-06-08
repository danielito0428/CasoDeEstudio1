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


    public boolean insertarLibro(Libro tmpLibro) {




            LibroDAO.insertarLibro(tmpLibro);


        return false;
    }


}
