package ar.com.unpaz.Model;

public class CuentaCorriente extends Cuenta {

    private double limiteDescubierto;
    private static int contadorCC = 1;

    public CuentaCorriente(Cliente titular, double limite) {
        super(("CC-" + String.format("%03d", contadorCC++)), titular);
        this.limiteDescubierto = limite;
    }

    public CuentaCorriente(Cliente titular, double limite, double saldo) {
        super(("CC-" + String.format("%03d", contadorCC++)), titular);
        this.limiteDescubierto = limite;
        this.saldo = saldo;
    }


    double montoDisponible = saldo + limiteDescubierto;
    @Override
    public boolean retirar(double monto) throws SaldoInsuficienteException {
        if (monto > montoDisponible) {
            throw new SaldoInsuficienteException("Operación rechazada: Supera el límite de descubierto. " +
                    "Disponible total: " + montoDisponible);
        }
        saldo -= monto;
        return true;
    }
}
