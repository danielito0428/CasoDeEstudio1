package entities.libro;

import entities.Configuracion;

import java.sql.*;

public class LibroDAO {


    public static void insertarLibro(Libro libro) {
        try {
            Configuracion configuracion = new Configuracion();
            Class.forName(configuracion.getClaseJDBC());
            String query = "INSERT INTO LIBRO (IDLIBRO,TITULO,CATEGORIA,ESTADO,CANTIDAD) VALUES (?,?,?,?,?)";
            PreparedStatement stmt = null;
            Connection conn = null;
            ResultSet rs = null;
            String strConexion = configuracion.getStringConexion();
            conn = DriverManager.getConnection(strConexion);
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, libro.getIdLibro());
            stmt.setString(2, libro.getTitulo());
            stmt.setString(3, libro.getCategoria());
            stmt.setString(4, libro.getDisp());
            stmt.setInt(5, libro.getCantidad());




            stmt.execute();


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
