package ar.com.unpaz.Model;

public class Contacto {
    private String calle;
    private String localidad;
    private int numero;
    private int codigoPostal;
    private String email;

    public Contacto(String calle, String localidad, int numero, int codigoPostal, String email) {
        this.calle = calle;
        this.localidad = localidad;
        this.numero = numero;
        this.codigoPostal = codigoPostal;
        this.email = email;
    }

    //getters
    public String getLocalidad() {
        return this.localidad;
    }
    public String getCalle() {
        return this.calle;
    }
    public int getNumero() {
        return this.numero;
    }
    public int getCodigoPostal() {
        return this.codigoPostal;
    }
    public String getEmail() {
        return this.email;
    }

    // setters
    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
