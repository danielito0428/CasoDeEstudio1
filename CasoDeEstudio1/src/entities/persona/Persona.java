package entities.persona;

//La clase Persona hereda sus atributos a las clases Cliente y Admin, por esto mismo es considerada la clase padre de estas dos
public class Persona {
    //Se declaran las variables de la clase Persona
    private String nombre;
    private String apellido;
    private String direccion;
    private String cedula;
    private String telefono;
    private String fechaNacimiento;

    //Constructor por defecto de la clase Persona
    public Persona() {
    }

    //Constructor pasando por parametros todos los atributos de la clase Persona
    public Persona(String nombre, String apellido, String direccion, String cedula, String telefono, String fechaNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.cedula = cedula;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
    }

    //Getters y setters de la clase Persona
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    //Metodo "toString()" de la clase Persona
    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", direccion='" + direccion + '\'' +
                ", cedula='" + cedula + '\'' +
                ", telefono='" + telefono + '\'' +
                ", fechaNacimiento='" + fechaNacimiento + '\'' +
                '}';
    }
}
