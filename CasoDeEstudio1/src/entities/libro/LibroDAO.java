package entities.libro;

import entities.Configuracion;
import entities.persona.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

public class LibroDAO {


    public static ArrayList<Libro> mostrarLibrosDisponibles() {
        //Se crea un ArrayList para guardar los libros que se encuentran disponibles
        ArrayList<Libro> librosDisponibles = new ArrayList<>();

        try {
            Configuracion configuracion = new Configuracion();
            Class.forName(configuracion.getClaseJDBC());
            //Con el query se hara una busqueda en la tabla de libros, se obtendrán solamente los que tengan el estado de disponible
            String query = "SELECT * FROM libro WHERE estado = 'Disponible'";
            Connection conn = null;
            PreparedStatement stmt = null;
            ResultSet rs = null;
            String strConexion = configuracion.getStringConexion();
            conn = DriverManager.getConnection(strConexion);
            stmt = conn.prepareStatement(query);
            rs = stmt.executeQuery();
            //Con el while se puede recorrer la tabla, gracias a esto se obtienen variables respectivas de cada fila que cumpla con el query anterior
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
        //Se declara el objeto Libro vacio
        Libro libro = null;

        try {
            Configuracion configuracion = new Configuracion();
            Class.forName(configuracion.getClaseJDBC());
            //Al ejecutarse el query se selecciona el libro que cumpla con el requisito de la idLibro
            String query = "SELECT * FROM LIBRO WHERE IDLIBRO = ?";
            Connection conn = DriverManager.getConnection(configuracion.getStringConexion());
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, idLibro);
            ResultSet rs = stmt.executeQuery();
            /*El if permite al ResultSet poder ir revisando si el idLibro es igual a la ingresada
            * Gracias al next() permite revisar cada fila de la tabla de la base de datos
            * Posteriormente se crea el obejto que tiene la misma informacion que el idLibro ingresado*/
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
        //Se declara el objeto Libro vacio
        Libro libro = null;

        try {
            Configuracion configuracion = new Configuracion();
            Class.forName(configuracion.getClaseJDBC());
            //Con el query se busca actualizar el estado del libro a prestado, pero solamente del libro que comparta la idLibro escrita en el where
            String query = "UPDATE LIBRO SET estado='prestado' WHERE IDLIBRO = ?";
            Connection conn = DriverManager.getConnection(configuracion.getStringConexion());
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, idLibro);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                //El query va a seleccionar registro de la tabla libro que tenga una idLibro igual a la ingresada por el usuario
                query = "SELECT * FROM LIBRO WHERE IDLIBRO = ?";
                PreparedStatement selectStmt = conn.prepareStatement(query);
                selectStmt.setInt(1, idLibro);
                ResultSet rs = selectStmt.executeQuery();
                /*Con el if se busca en la tabla el idLibro respectivo
                * Al encontrarlo se crea el objeto, se actualiza a prestado y no se podra quitar este estado hasta que sea devuelto*/
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
        //Se declara el objeto Libro vacio
        Libro libro = null;

        try {
            Configuracion configuracion = new Configuracion();
            Class.forName(configuracion.getClaseJDBC());
            //Este query va a actualizar el estado a disponible, cuando el idLibro sea identico al ingresado al sistema
            String query = "UPDATE LIBRO SET estado='Disponible' WHERE IDLIBRO = ?";
            Connection conn = DriverManager.getConnection(configuracion.getStringConexion());
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, idLibro);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                //El query busca segun la idLibro que se ingresa en la tabla libro
                query = "SELECT * FROM LIBRO WHERE IDLIBRO = ?";
                PreparedStatement selectStmt = conn.prepareStatement(query);
                selectStmt.setInt(1, idLibro);
                ResultSet rs = selectStmt.executeQuery();
                /*Con el if se busca en la tabla el idLibro que coincida
                 * Al encontrarlo se crea el objeto, se actualiza a disponible y no se podra quitar este estado hasta que sea solicitado para prestamo*/
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
            //El query va a insertar un registro en la tabla libro, para poder ingresar libros
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

            /*Despues de leer los datos correspondientes a cada columna se inserta el libro en la base de datos*/


            stmt.execute();


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<String> listarLibrosPrestados() {
        //Se crea el ArrayList en el que se van a guardar los libros que se encuentran prestados
        ArrayList<String> librosPrestado = new ArrayList<>();
        try {
            Configuracion configuracion = new Configuracion();
            Class.forName(configuracion.getClaseJDBC());
            Connection conn;
            //El objetivo del query es mostrar el nombre del cliente y su nombre de usuario, ademas de tambien mostrar la informacion del libro que se encuentra actualmente prestado
            String query = "SELECT CONCAT(C.nombre, ' ', C.apellido) as Nombre,L.titulo, L.autor,L.categoria,L.estado, P.fechaInicio,P.fechaFin FROM prestamo P inner join cliente C on P.usuario =  C.usuario inner join libro L on P.idlibro = L.idlibro ";
            Statement stmt;
            ResultSet rs;
            String strConexion = configuracion.getStringConexion();
            conn = DriverManager.getConnection(strConexion);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            /*Gracias al ciclo while se puede llenar el ArrayList y tambien se puede consultar cada registro de las tablas
            * Posteriormente se asignan los valores de cada una de las variables y se llena el ArrayList con la informacion debida*/
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
        //Se crea el ArrayList en el que se van a guardar los libros que se encuentran prestados
        ArrayList<String> librosPrestado = new ArrayList<>();
        try {
            Configuracion configuracion = new Configuracion();
            Class.forName(configuracion.getClaseJDBC());
            Connection conn;
            //En el query se obtiene el titulo y el id del libro que se encuentra actualmente prestado
            String query = " SELECT L.titulo from prestamo inner join libro L on L.idlibro = prestamo.idlibro ";
            Statement stmt;
            ResultSet rs;
            String strConexion = configuracion.getStringConexion();
            conn = DriverManager.getConnection(strConexion);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            /*En el ciclo while se inserta el titulo del libro en un arreglo temporal
            * posteriormente este arreglo se agrega al ArrayList que se creo anteriormente*/
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
