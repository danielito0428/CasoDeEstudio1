package entities.prestamo;

public class Prestamo {

    private String fechaInicio;

    private String fechaFin;

    private String idPrestamo;

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

    public String getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(String idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public Prestamo (){

    }

    public Prestamo (String fechaInicio, String fechaFin, String idPrestamo){
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.idPrestamo = idPrestamo;
    }

    @Override
    public String toString() {
        return "Prestamo{" +
                "fechaInicio='" + fechaInicio + '\'' +
                ", fechaFin='" + fechaFin + '\'' +
                '}';
    }
}
