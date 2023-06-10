package entities.persona;

//La clase Cliente es hija de la clase Persona
public class Cliente extends Persona{
    //Declaracion de los atributos de la clase Cliente
    private String usuario;
    private String pswd;
    private String estado;

    public Cliente() {
        super();
    }
    //Super constructor de la clase cliente con los atributos de su padre
    public Cliente(String nombre, String apellido, String direccion, String cedula, String telefono, String fechaNacimiento, String usuario, String pswd, String estado) {
        super(nombre, apellido, direccion, cedula, telefono, fechaNacimiento);
        this.usuario = usuario;
        this.pswd = pswd;
        this.estado = estado;

    }

    //Getters y setters de los atributos que pertenecen a la clase Cliente
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

    //Super constructor de la clase Cliente con sus atributos
    public Cliente(String nombre, String apellido, String direccion, String cedula, String telefono, String fechaNacimiento) {
        super(nombre, apellido, direccion, cedula, telefono, fechaNacimiento);
    }
    public Cliente registrarCLiente(String nombre, String apellido, String direccion, String cedula, String telefono, String fechaNacimiento, String usuario, String pswd, String estado){
        Cliente tmpCliente = new Cliente( nombre,  apellido,  direccion, cedula, telefono, fechaNacimiento,  usuario,  pswd,  estado);
        return tmpCliente;
    }

    //Metodo "toString()" de la clase Cliente
    @Override
    public String toString() {
        return "Cliente{" +
                "usuario='" + usuario + '\'' +
                ", pswd='" + pswd + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}
