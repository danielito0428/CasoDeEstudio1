package entities.persona;

import entities.libro.Libro;
import logica.Gestor;

import java.util.ArrayList;

//La clase Admin es hija de la clase Persona
public class Admin extends Persona {
    //Declaracion de los atributos de la clase
    private static Gestor appGestor = new Gestor();
    private String usuario;
    private String pswd;
    private boolean estado;
    private String idAdmin;

    //Super constructor con los atributos de la clase Persona y la clase Admin
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

    //Getters y setters de los atributos de la clase Admin
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

    //Metodo "toString()" de la clase Admin
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
