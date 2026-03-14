package ar.com.unpaz.model;

public class Cliente {
    private String nombre;
    private String apellido;
    private int dni;
    private Contacto contacto;

    //Cuenta

    public Cliente(String nombre, String apellido, int dni, Contacto contacto) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.contacto = contacto;
    }


    // getters
    public String getNombre() {
        return this.nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public int getDni() {
        return this.dni;
    }

    public Contacto getContacto() {
        return this.contacto;
    }

    // setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public void setDni(int dni) {
        this.dni = dni;
    }
    public void setContacto(Contacto contacto) {
        this.contacto = contacto;
    }

}
