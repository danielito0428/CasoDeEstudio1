package entities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Configuracion {

    //Declaracion de los atrbutos de la clase Configuracion
    private String claseJDBC;
    private String stringConexion;
    //Constructor de la clase que ejecuta el metodo leerConfiguracion()
    public Configuracion() {
        leerConfiguracion();
    }
    //Constructor con todos los atributos de la clase
    public Configuracion(String claseJDBC, String stringConexion) {
        this.claseJDBC = claseJDBC;
        this.stringConexion = stringConexion;
    }
    //Getters y setters de los atributos de la clase Configuracion
    public String getClaseJDBC() {
        return claseJDBC;
    }

    public void setClaseJDBC(String claseJDBC) {
        this.claseJDBC = claseJDBC;
    }

    public String getStringConexion() {
        return stringConexion;
    }

    public void setStringConexion(String stringConexion) {
        this.stringConexion = stringConexion;
    }
    /*En el metodo leerConfiguracion() se ubica el proyecto en el directorio de documnetos como primer paso
    * Posteriormente se hace un llamado a los drivers del JDBC y tambien se llama al String de conexion de la base de datos*/
    public void leerConfiguracion() {
        Properties properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream("C:\\Users\\JIV\\Desktop\\CasoEstudioGrupal\\CasoDeEstudio1\\CasoDeEstudio1\\src\\entities\\config.properties");
            properties.load(fileInputStream);
            this.setClaseJDBC(properties.getProperty("claseJDBC"));
            this.setStringConexion(properties.getProperty("stringConexion"));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }


}



