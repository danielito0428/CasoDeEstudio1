package entities.persona;

import entities.Configuracion;
import entities.libro.Libro;

import java.sql.*;
import java.util.ArrayList;

public class ClienteDAO {
    public static void insertarCliente(Cliente c) {
        try {
            Configuracion configuracion = new Configuracion();
            Class.forName(configuracion.getClaseJDBC());
            //El query al ser un insert necesita de datos por parte del usuario para poder llenar los campos en la tabla
            String query = "INSERT INTO cliente (nombre,apellido,direccion,telefono,cedula,fechaNacimiento,usuario,clave,estado) VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement stmt = null;
            Connection conn = null;
            ResultSet rs = null;
            String strConexion = configuracion.getStringConexion();
            conn = DriverManager.getConnection(strConexion);
            stmt = conn.prepareStatement(query);
            stmt.setString(1, c.getNombre());
            stmt.setString(2, c.getApellido());
            stmt.setString(3, c.getDireccion());
            stmt.setString(4, c.getTelefono());
            stmt.setString(5, c.getCedula());
            stmt.setString(6, c.getFechaNacimiento());
            stmt.setString(7, c.getUsuario());
            stmt.setString(8, c.getPswd());
            stmt.setString(9, c.getEstado());

            stmt.execute();
            //Posteriormente al darle los valores que el usuario ingresa se ejecuta el query en la base de datos para insertar el cliente

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Cliente> listarUsuarioTipo() {
        //Creacion del ArrayList que almacenará todos los Clientes que se encuentren almacenados en la base de datos
        ArrayList<Cliente> usuarioTipos = new ArrayList<>();
        try {
            Configuracion configuracion = new Configuracion();
            Class.forName(configuracion.getClaseJDBC());
            Connection conn;
            //El query al ser un select * va a obtener todos los datos que se encuentren en la tabla cliente
            String query = "SELECT * FROM cliente";
            Statement stmt;
            ResultSet rs;
            String strConexion = configuracion.getStringConexion();
            conn = DriverManager.getConnection(strConexion);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);

            /*Mediante el ciclo while se pueden adquirir todos los registros de la tabla, ya que con el next() permite al ResultSet pasar a la siguiente fila de la tabla
            * Los resultados extraidos desde la tabla asignan a sus respectivas variable y con la ayuda del constructor se pueden crear los objetos
            * Los objetos finalmente se agregan al ArrayList de clientes*/
            while (rs.next()) {

                String nombre = (rs.getString("nombre"));
                String apellido = (rs.getString("usuario"));
                String direccion = (rs.getString("direccion"));
                String telefono = (rs.getString("telefono"));
                String cedula = (rs.getString("cedula"));
                String fechaNacimiento = (rs.getString("fechaNacimiento"));
                String usuario = (rs.getString("usuario"));
                String clave = (rs.getString("clave"));
                String estado = (rs.getString("estado"));
                Cliente c = new Cliente(nombre, apellido, direccion, telefono, cedula, fechaNacimiento, usuario, clave, estado);


                usuarioTipos.add(c);


            }
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
        return usuarioTipos;
    }

    public static Cliente obtenerClientePorEstado(String usua) {
        //Se crea el objeto cliente vacio
        Cliente cliente = null;

        try {
            Configuracion configuracion = new Configuracion();
            Class.forName(configuracion.getClaseJDBC());
            //El query es un select * por lo que se va seleccionar todos los registros, sin embargo al tener where solo se mostraran los resulatados que cumplan los requisitos de este
            String query = "SELECT * FROM Cliente WHERE USUARIO = ?";
            Connection conn = DriverManager.getConnection(configuracion.getStringConexion());
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, usua);
            ResultSet rs = stmt.executeQuery();
            /*Se recorrera la tabla con el if en busca que algun usuario que coincida con lo solicitado en el where del query
            * Al encontrarlo se asignaran los datos a las respectivas variables, para posteriormente crear el objeto*/
            if (rs.next()) {
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String direccion = rs.getString("direccion");
                String telefono = rs.getString("telefono");
                String cedula = rs.getString("cedula");
                String fechaNacimiento = rs.getString("fechaNacimiento");
                String usuario = rs.getString("usuario");
                String clave = rs.getString("clave");
                String estado = rs.getString("estado");
                cliente = new Cliente(nombre, apellido, direccion, telefono, cedula, fechaNacimiento, usuario, clave, estado);
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cliente;
    }
}
