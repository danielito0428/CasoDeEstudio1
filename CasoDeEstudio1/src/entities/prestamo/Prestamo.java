package entities.prestamo;

import entities.libro.Libro;
import entities.persona.Cliente;

public class Prestamo {

    //Declaracion de los atributos de la clase Prestamo
    private String fechaInicio;

    private String fechaFin;

    private int idPrestamo;

    private int IDlibro;
    private String Usercliente;

    //Constructor ultilizado para buscar el prestamo segun su idPrestamo y asginarle la fechaFin
    public Prestamo(int idPrestamo, String fechaFin) {
    }

    //Getters y setters de los atributos de la clase Prestamo
    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(int idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public int getIDlibro() {
        return IDlibro;
    }

    public void setIDlibro(int IDlibro) {
        this.IDlibro = IDlibro;
    }

    public String getUsercliente() {
        return Usercliente;
    }

    public void setUsercliente(String usercliente) {
        Usercliente = usercliente;
    }

    //Se omite la fecha fin, ya que este constructor se utiliza al registrar un Prestamo
    public Prestamo(String fechaInicio, int idPrestamo, int IDlibro, String usercliente) {
        this.fechaInicio = fechaInicio;
        this.idPrestamo = idPrestamo;
        this.IDlibro = IDlibro;
        Usercliente = usercliente;
    }

    //Constructor con todos atributos de la clase
    public Prestamo(String fechaInicio, String fechaFin, int idPrestamo, int IDlibro, String usercliente) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.idPrestamo = idPrestamo;
        this.IDlibro = IDlibro;
        Usercliente = usercliente;
    }

    //Metodo "toString()" de la clase Prestamo
    @Override
    public String toString() {
        return "Prestamo{" +
                "fechaInicio='" + fechaInicio + '\'' +
                ", fechaFin='" + fechaFin + '\'' +
                '}';
    }
}
