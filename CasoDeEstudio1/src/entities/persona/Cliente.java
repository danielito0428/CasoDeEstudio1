package entities.persona;

public class Cliente extends Persona{
    private String usuario;
    private String pswd;
    private boolean estado;
    private String idAdmin;

    public Cliente(String nombre, String apellido, String direccion, String cedula, String telefono, String fechaNacimiento, String usuario, String pswd, boolean estado, String idAdmin) {
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

    public Cliente(String nombre, String apellido, String direccion, String cedula, String telefono, String fechaNacimiento) {
        super(nombre, apellido, direccion, cedula, telefono, fechaNacimiento);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "usuario='" + usuario + '\'' +
                ", pswd='" + pswd + '\'' +
                ", estado=" + estado +
                ", idAdmin='" + idAdmin + '\'' +
                '}';
    }
}
