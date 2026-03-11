package ar.com.unpaz.model;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    public String nombre;
    public String apellido;
    public int dni;
    public Contacto contacto;
    public List<Cuenta> cuentas;

    //Cuenta

    public Cliente() {
        this.cuentas = new ArrayList<>();
    }

    public List<Cuenta> getCuenta() {
        return this.cuentas;
    }

    public void setCuenta(Cuenta nuevaCuenta) {
        this.cuentas.add(nuevaCuenta);
        nuevaCuenta.setTitular(this);
    }

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

    // Contacto
    public Contacto getContacto() {
        return this.contacto;
    }

    public void setContacto(Contacto contacto) {
        this.contacto = contacto;
    }

}
