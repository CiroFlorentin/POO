package ar.com.libreriaunpaz.model;

public class Libro {
    private String codigo;
    private String titulo;
    private String autor;
    private int anio;
    private Boolean estaPrestado;

    public Libro() {
    }

    public Libro(String codigo, String titulo, String autor, int anio, Boolean estaPrestado) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
        this.estaPrestado = estaPrestado;
    }

    //GETTERS AND SETTERS
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public Boolean getEstaPrestado() {
        return estaPrestado;
    }

    public void setEstaPrestado(Boolean estaPrestado) {
        this.estaPrestado = estaPrestado;
    }

    @Override
    public String toString() {
        return String.format(
                "%-10s %-20s %-20s %-6d %-12s",
                codigo,
                titulo,
                autor,
                anio,
                estaPrestado ? "Prestado" : "Disponible"
        );
    }
}
