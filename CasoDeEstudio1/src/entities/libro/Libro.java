package entities.libro;

public class Libro {
    // Atributos de la clase con sus respectivos tipos de dato Libro
    private int IdLibro;
    private String titulo;
    private String categoria;
    private String disp;
    private String autor;
    private int cantidad;

    //Constructor por defecto de la clase Libro
    public Libro() {

    }

    //Constructor con todos los atributos de la clase siendo sus parametros
    public Libro(int idLibro, String titulo, String autor, String categoria, String disp, int cantidad) {
        IdLibro = idLibro;
        this.titulo = titulo;
        this.autor=autor;
        this.categoria = categoria;
        this.disp = disp;
        this.cantidad = cantidad;
    }

    //Getters y setters de los respectivos atributos anteriormente declarados
    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getDisp() {
        return disp;
    }

    public int getIdLibro() {
        return IdLibro;
    }

    public void setIdLibro(int idLibro) {
        IdLibro = idLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setDisp(String disp) {
        this.disp = disp;
    }

    //Metodo "toString()" de la clase Libro
    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", categoria='" + categoria + '\'' +
                ", disp=" + disp +
                '}';
    }
}
