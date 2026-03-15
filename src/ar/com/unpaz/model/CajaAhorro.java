package ar.com.unpaz.model;

public class CajaAhorro extends Cuenta {
    private static int contadorCa = 1;

    public CajaAhorro(Cliente titular) {
        super(("CA-" + String.format("%03d", contadorCa++)), titular);
    }

    @Override
    public boolean retirar(double monto) throws SaldoInsuficienteException {
        if (monto > saldo) throw new SaldoInsuficienteException("No tenés saldo suficiente. Saldo actual: " + saldo);
        saldo -= monto;
        return true;
    }
}
