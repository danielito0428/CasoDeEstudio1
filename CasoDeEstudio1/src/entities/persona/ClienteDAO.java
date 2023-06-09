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


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Cliente> listarUsuarioTipo() {

        ArrayList<Cliente> usuarioTipos = new ArrayList<>();
        try {
            Configuracion configuracion = new Configuracion();
            Class.forName(configuracion.getClaseJDBC());
            Connection conn;
            String query = "SELECT * FROM cliente";
            Statement stmt;
            ResultSet rs;
            String strConexion = configuracion.getStringConexion();
            conn = DriverManager.getConnection(strConexion);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);

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
        Cliente cliente = null;

        try {
            Configuracion configuracion = new Configuracion();
            Class.forName(configuracion.getClaseJDBC());
            String query = "SELECT * FROM Cliente WHERE USUARIO = ?";
            Connection conn = DriverManager.getConnection(configuracion.getStringConexion());
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, usua);
            ResultSet rs = stmt.executeQuery();
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
