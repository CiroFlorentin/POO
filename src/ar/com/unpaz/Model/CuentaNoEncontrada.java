package ar.com.unpaz.Model;

public class CuentaNoEncontrada extends Exception {
    public CuentaNoEncontrada(String mensaje) {
        super(mensaje);
    }
}
