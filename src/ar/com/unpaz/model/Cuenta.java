package ar.com.unpaz.model;

public class Cuenta {
    private int numeroCuenta;
    private double saldo;
    private Cliente titular;

    // Titular
    public Cliente getTitular() {
        return this.titular;
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }

    // Cuenta
    public int getNumberCuenta() {
        return this.numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }


    // Saldo
    public double getSaldo() {
        return this.saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
