package entities.prestamo;

import entities.Configuracion;
import entities.libro.Libro;
import entities.persona.Cliente;

import java.sql.*;
import java.util.ArrayList;

public class PrestamoDAO {
    public boolean registrarPrestamo(Prestamo prestamo) {
        try {
            Configuracion configuracion = new Configuracion();
            Class.forName(configuracion.getClaseJDBC());
            String query = "INSERT INTO PRESTAMO ( iDPRESTAMO,IDLIBRO, Usuario, FECHAINICIO) VALUES (?, ?, ?,?)";
            Connection conn = DriverManager.getConnection(configuracion.getStringConexion());
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, prestamo.getIdPrestamo());
            stmt.setInt(2, prestamo.getIDlibro());
            stmt.setString(3, prestamo.getUsercliente());
            stmt.setString(4, prestamo.getFechaInicio());
            stmt.execute();

            stmt.close();
            conn.close();
            return true;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public static Prestamo registrarEntrega(int prestamo, String fechaFin) {
        Prestamo prestamo1 = null;

        try {
            Configuracion configuracion = new Configuracion();
            Class.forName(configuracion.getClaseJDBC());
            String query = "UPDATE PRESTAMO SET fechaFin=? WHERE iDPRESTAMO = ?";
            Connection conn = DriverManager.getConnection(configuracion.getStringConexion());
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, fechaFin);
            stmt.setInt(2, prestamo);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                query = "SELECT * FROM PRESTAMO WHERE iDPRESTAMO = ?";
                PreparedStatement selectStmt = conn.prepareStatement(query);
                selectStmt.setInt(1, prestamo);
                ResultSet rs = selectStmt.executeQuery();
                if (rs.next()) {
                    String fechaini = rs.getString("fechaInicio");
                    String fechaFin1 = rs.getString("fechaFin");
                    int idPrestamo = rs.getInt("idprestamo");
                    int idLib = rs.getInt("idlibro");
                    String userCli = rs.getString("usuario");

                    prestamo1 = new Prestamo(fechaini, fechaFin1, idPrestamo, idLib, userCli);
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

        return prestamo1;
    }






}
