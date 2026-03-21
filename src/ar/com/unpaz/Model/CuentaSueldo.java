package ar.com.unpaz.Model;

public class CuentaSueldo extends Cuenta {
    private static int contadorCS = 1;
    private String empresa;

    public CuentaSueldo(Cliente titular, String empresa) {
        super(("CS-" + String.format("%03d", contadorCS++)), titular);
        this.empresa = empresa;
    }

    public CuentaSueldo(Cliente titular, double saldo) {
        super(("CS-" + String.format("%03d", contadorCS++)), titular);
        this.saldo = saldo;
    }
    @Override
    public boolean retirar(double monto) throws SaldoInsuficienteException {
        if (monto > saldo) {
            throw new SaldoInsuficienteException("Operación rechazada: Supera el límite retiro. " +
                    "Disponible total: " + saldo);
        }
        saldo -= monto;
        return true;
    }

    //Getters
    public String getEmpresa() {
        return empresa;
    }

    //Setters
    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
}
