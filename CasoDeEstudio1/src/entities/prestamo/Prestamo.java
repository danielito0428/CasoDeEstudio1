package entities.prestamo;

import entities.libro.Libro;
import entities.persona.Cliente;

public class Prestamo {

    private String fechaInicio;

    private String fechaFin;

    private int idPrestamo;

    private int IDlibro;
    private String Usercliente;

    public Prestamo(int idPrestamo, String fechaFin) {
    }


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

    public Prestamo(String fechaInicio, int idPrestamo, int IDlibro, String usercliente) {
        this.fechaInicio = fechaInicio;
        this.idPrestamo = idPrestamo;
        this.IDlibro = IDlibro;
        Usercliente = usercliente;
    }

    public Prestamo(String fechaInicio, String fechaFin, int idPrestamo, int IDlibro, String usercliente) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.idPrestamo = idPrestamo;
        this.IDlibro = IDlibro;
        Usercliente = usercliente;
    }

    @Override
    public String toString() {
        return "Prestamo{" +
                "fechaInicio='" + fechaInicio + '\'' +
                ", fechaFin='" + fechaFin + '\'' +
                '}';
    }
}
