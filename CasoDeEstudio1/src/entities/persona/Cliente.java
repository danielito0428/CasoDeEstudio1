package entities.persona;

public class Cliente extends Persona{
    private String usuario;
    private String pswd;
    private String estado;

    public Cliente() {
        super();
    }

    public Cliente(String nombre, String apellido, String direccion, String cedula, String telefono, String fechaNacimiento, String usuario, String pswd, String estado) {
        super(nombre, apellido, direccion, cedula, telefono, fechaNacimiento);
        this.usuario = usuario;
        this.pswd = pswd;
        this.estado = estado;

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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }


    public Cliente(String nombre, String apellido, String direccion, String cedula, String telefono, String fechaNacimiento) {
        super(nombre, apellido, direccion, cedula, telefono, fechaNacimiento);
    }
    public Cliente registrarCLiente(String nombre, String apellido, String direccion, String cedula, String telefono, String fechaNacimiento, String usuario, String pswd, String estado){
        Cliente tmpCliente = new Cliente( nombre,  apellido,  direccion, cedula, telefono, fechaNacimiento,  usuario,  pswd,  estado);
        return tmpCliente;
    }


    @Override
    public String toString() {
        return "Cliente{" +
                "usuario='" + usuario + '\'' +
                ", pswd='" + pswd + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}
