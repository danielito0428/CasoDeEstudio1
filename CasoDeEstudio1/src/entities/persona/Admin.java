package entities.persona;

import entities.libro.Libro;
import logica.Gestor;

public class Admin extends Persona {
    private static Gestor appGestor;
    private String usuario;
    private String pswd;
    private boolean estado;
    private String idAdmin;


    public Admin(String nombre, String apellido, String direccion, String cedula, String telefono, String fechaNacimiento) {
        super(nombre, apellido, direccion, cedula, telefono, fechaNacimiento);
    }

    public Admin(String nombre, String apellido, String direccion, String cedula, String telefono, String fechaNacimiento, String usuario, String pswd, boolean estado, String idAdmin) {
        super(nombre, apellido, direccion, cedula, telefono, fechaNacimiento);
        this.usuario = usuario;
        this.pswd = pswd;
        this.estado = estado;
        this.idAdmin = idAdmin;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPswd() {
        return pswd;
    }

    public void setPswd(String pswd) {
        this.pswd = pswd;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(String idAdmin) {
        this.idAdmin = idAdmin;
    }

    public Libro registrarLibro(int idLibro,String titulo,String autor, String cat,String disp, int cant){
       Libro tmpLibro = new Libro(idLibro,titulo,autor,cat,disp,cant);
        return tmpLibro;




    }

    @Override
    public String toString() {
        return "Admin{" +
                "usuario='" + usuario + '\'' +
                ", pswd='" + pswd + '\'' +
                ", estado=" + estado +
                ", idAdmin='" + idAdmin + '\'' +
                '}';
    }
}
