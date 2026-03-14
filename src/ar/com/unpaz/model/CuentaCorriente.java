package ar.com.unpaz.model;

public class CuentaCorriente extends Cuenta {

    private double limiteDescubierto;

    public CuentaCorriente(String numeroCuenta, Cliente titular, double limite) {
        super(numeroCuenta, titular);
        this.limiteDescubierto = limite;
    }

    @Override
    public boolean retirar(double monto) {
        if (monto <= (saldo + limiteDescubierto)) {
            saldo -= monto;
            return true;
        }
        return false;
    }
}
