package ar.com.unpaz.Model;

public class CajaAhorro extends Cuenta {
    private static int contadorCa = 1;


    public CajaAhorro(Cliente titular) {
        super(("CA-" + String.format("%03d", contadorCa++)), titular);
    }

    public CajaAhorro(Cliente titular, double saldo) {
        super(("CA-" + String.format("%03d", contadorCa++)), titular);
        this.saldo = saldo;
    }

    @Override
    public boolean retirar(double monto) throws SaldoInsuficienteException {
        if (monto > saldo) throw new SaldoInsuficienteException("No tenés saldo suficiente. Saldo actual: " + saldo);
        saldo -= monto;
        return true;
    }


}
