package ar.com.unpaz.model;

public abstract class Cuenta {
    private String numeroCuenta;
    protected double saldo;
    private Cliente titular;

    public Cuenta(String numeroCuenta, Cliente titular) {
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = 0.0;
    }

    public void depositar(double monto) {
        if (monto > 0) saldo += monto;
    }

    public abstract boolean retirar(double monto) throws SaldoInsuficienteException;

    // Getters
    public String getNumeroCuenta() {
        return this.numeroCuenta;
    }
    public Cliente getTitular() {
        return this.titular;
    }

    public double getSaldo() {
        return this.saldo;
    }

    // Setters
    public void setTitular(Cliente titular) {
        this.titular = titular;
    }
}
