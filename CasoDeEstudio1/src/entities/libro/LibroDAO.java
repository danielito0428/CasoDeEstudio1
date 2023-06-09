package entities.libro;

import entities.Configuracion;
import entities.persona.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

public class LibroDAO {


    public static ArrayList<Libro> mostrarLibrosDisponibles() {
        ArrayList<Libro> librosDisponibles = new ArrayList<>();

        try {
            Configuracion configuracion = new Configuracion();
            Class.forName(configuracion.getClaseJDBC());
            String query = "SELECT * FROM libro WHERE estado = 'Disponible'";
            Connection conn = null;
            PreparedStatement stmt = null;
            ResultSet rs = null;
            String strConexion = configuracion.getStringConexion();
            conn = DriverManager.getConnection(strConexion);
            stmt = conn.prepareStatement(query);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("IDLIBRO");
                String titulo = rs.getString("TITULO");
                String categoria = rs.getString("CATEGORIA");
                String estado = rs.getString("ESTADO");
                int cantidad = rs.getInt("CANTIDAD");
                String autor = rs.getString("AUTOR");

                Libro libro = new Libro(id, autor, titulo, categoria, estado, cantidad);
                librosDisponibles.add(libro);
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return librosDisponibles;
    }




    public static Libro obtenerLibroPorId(int idLibro) {
        Libro libro = null;

        try {
            Configuracion configuracion = new Configuracion();
            Class.forName(configuracion.getClaseJDBC());
            String query = "SELECT * FROM LIBRO WHERE IDLIBRO = ?";
            Connection conn = DriverManager.getConnection(configuracion.getStringConexion());
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, idLibro);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("IDLIBRO");
                String titulo = rs.getString("TITULO");
                String categoria = rs.getString("CATEGORIA");
                String estado = rs.getString("ESTADO");
                int cantidad = rs.getInt("CANTIDAD");
                String autor = rs.getString("AUTOR");

                libro = new Libro(id, autor,titulo, categoria, estado, cantidad);
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return libro;
    }


    public static Libro cambiarEstadoLibro(int idLibro) {
        Libro libro = null;

        try {
            Configuracion configuracion = new Configuracion();
            Class.forName(configuracion.getClaseJDBC());
            String query = "UPDATE LIBRO SET estado='prestado' WHERE IDLIBRO = ?";
            Connection conn = DriverManager.getConnection(configuracion.getStringConexion());
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, idLibro);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                query = "SELECT * FROM LIBRO WHERE IDLIBRO = ?";
                PreparedStatement selectStmt = conn.prepareStatement(query);
                selectStmt.setInt(1, idLibro);
                ResultSet rs = selectStmt.executeQuery();
                if (rs.next()) {
                    int id = rs.getInt("IDLIBRO");
                    String titulo = rs.getString("TITULO");
                    String categoria = rs.getString("CATEGORIA");
                    String estado = rs.getString("ESTADO");
                    int cantidad = rs.getInt("CANTIDAD");
                    String autor = rs.getString("AUTOR");

                    libro = new Libro(id, autor, titulo, categoria, estado, cantidad);
                }
                rs.close();
                selectStmt.close();
            }

            stmt.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return libro;
    }
    public static Libro cambiarEstadoLibroDev(int idLibro) {
        Libro libro = null;

        try {
            Configuracion configuracion = new Configuracion();
            Class.forName(configuracion.getClaseJDBC());
            String query = "UPDATE LIBRO SET estado='Disponible' WHERE IDLIBRO = ?";
            Connection conn = DriverManager.getConnection(configuracion.getStringConexion());
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, idLibro);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                query = "SELECT * FROM LIBRO WHERE IDLIBRO = ?";
                PreparedStatement selectStmt = conn.prepareStatement(query);
                selectStmt.setInt(1, idLibro);
                ResultSet rs = selectStmt.executeQuery();
                if (rs.next()) {
                    int id = rs.getInt("IDLIBRO");
                    String titulo = rs.getString("TITULO");
                    String categoria = rs.getString("CATEGORIA");
                    String estado = rs.getString("ESTADO");
                    int cantidad = rs.getInt("CANTIDAD");
                    String autor = rs.getString("AUTOR");

                    libro = new Libro(id, autor, titulo, categoria, estado, cantidad);
                }
                rs.close();
                selectStmt.close();
            }

            stmt.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return libro;
    }


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

    public static ArrayList<String> listarLibrosPrestados() {

        ArrayList<String> librosPrestado = new ArrayList<>();
        try {
            Configuracion configuracion = new Configuracion();
            Class.forName(configuracion.getClaseJDBC());
            Connection conn;
            String query = "SELECT CONCAT(C.nombre, ' ', C.apellido) as Nombre,L.titulo, L.autor,L.categoria,L.estado, P.fechaInicio,P.fechaFin FROM prestamo P inner join cliente C on P.usuario =  C.usuario inner join libro L on P.idlibro = L.idlibro ";
            Statement stmt;
            ResultSet rs;
            String strConexion = configuracion.getStringConexion();
            conn = DriverManager.getConnection(strConexion);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                String nombre = rs.getString("Nombre");
                String titulo = rs.getString("titulo");
                String autor = rs.getString("autor");
                String cat = rs.getString("categoria");
                String estado = rs.getString("estado");
                String fInicio = rs.getString("fechaInicio");
                String fFin = rs.getString("FechaFin");

                String [] tmpArr = {nombre, titulo, autor, cat, estado, fInicio, fFin};
                librosPrestado.add(Arrays.toString(tmpArr));

            }
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
        return librosPrestado;
    }



    public static ArrayList<String> buscarLibross() {

        ArrayList<String> librosPrestado = new ArrayList<>();
        try {
            Configuracion configuracion = new Configuracion();
            Class.forName(configuracion.getClaseJDBC());
            Connection conn;
            String query = " SELECT L.titulo from prestamo inner join libro L on L.idlibro = prestamo.idlibro ";
            Statement stmt;
            ResultSet rs;
            String strConexion = configuracion.getStringConexion();
            conn = DriverManager.getConnection(strConexion);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                String titulo = rs.getString("titulo");


                String [] tmpArr = {titulo};
                librosPrestado.add(Arrays.toString(tmpArr));

            }
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
        return librosPrestado;
    }

}
