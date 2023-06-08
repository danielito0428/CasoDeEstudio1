package entities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Configuracion {


    private String claseJDBC;
    private String stringConexion;

    public Configuracion() {
        leerConfiguracion();
    }

    public Configuracion(String claseJDBC, String stringConexion) {
        this.claseJDBC = claseJDBC;
        this.stringConexion = stringConexion;
    }

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

    public void leerConfiguracion() {
        Properties properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream("C:\\Users\\edgar\\Desktop\\CasoEstudio\\CasoDeEstudio\\CasoDeEstudio1\\CasoDeEstudio1\\src\\entities\\config.properties");
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



