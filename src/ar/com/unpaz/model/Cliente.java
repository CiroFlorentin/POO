package ar.com.unpaz.model;

public class Cliente {
    public String nombre;
    public String apellido;
    public int dni;
    public Contacto contacto;
    public Cuenta cuenta;

    // Nombre
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Apellido
    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    // DNI
    public int getDni() {
        return this.dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    // Cuenta
    public Cuenta getCuenta() {
        return this.cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    // Contacto
    public Contacto getContacto() {
        return this.contacto;
    }

    public void setContacto(Contacto contacto) {
        this.contacto = contacto;
    }

}
