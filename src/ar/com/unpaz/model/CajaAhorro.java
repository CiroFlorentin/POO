package ar.com.unpaz.model;

public class CajaAhorro extends Cuenta {
    public CajaAhorro(String numeroCuenta, Cliente titular) {
        super(numeroCuenta, titular);
    }

    @Override
    public boolean retirar(double monto) {
        if (monto <= saldo) {
            saldo -= monto;
            return true;
        }
        return false;
    }
}
