package ar.com.unpaz.model;

public class CuentaNoEncontrada extends Exception {
    public CuentaNoEncontrada(String mensaje) {
        super(mensaje);
    }
}
