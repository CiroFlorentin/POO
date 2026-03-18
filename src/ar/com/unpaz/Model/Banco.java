package ar.com.unpaz.Model;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    private String nombre;
    private List<Cuenta> cuentas;

    public Banco(String nombre) {
        this.nombre = nombre;
        this.cuentas = new ArrayList<>();
    }

    // Transferencia
    public Cuenta getCuentaPorNumero(String numeroCuenta) {
        for (Cuenta c : cuentas) {
            if (c.getNumeroCuenta().equalsIgnoreCase(numeroCuenta)) return c;
        }
        return null;
    }

    public void transferir(String numeroCuentaOrigen, String numeroCuentaDestino, double monto) throws CuentaNoEncontrada, SaldoInsuficienteException {
        try {
            Cuenta origen = getCuentaPorNumero(numeroCuentaOrigen);
            Cuenta destino = getCuentaPorNumero(numeroCuentaDestino);

            if (origen == null || destino == null) {
                throw new CuentaNoEncontrada("Error: Cuenta/s no encontrada/s.");
            }
            origen.retirar(monto);
            destino.depositar(monto);
            System.out.println("Transferencia realizada con exito.");
        } catch (SaldoInsuficienteException e) {
            System.out.println("Fallo en la transferencia: " + e.getMessage());
        } catch (CuentaNoEncontrada e) {
            System.out.println("Fallo en la busqueda: " + e.getMessage());
        }
    }

    // Getters
    public void getCuentas() {
        System.out.println("--- Cuentas en el Banco " + nombre + " ---");
        for (Cuenta c : cuentas) {
            System.out.println("Numero: " + c.getNumeroCuenta() +
                    " | Titular: " + c.getTitular().getNombre() +
                    " | Saldo: " + c.getSaldo());
        }
    }

    public List<Cuenta> getCuentaPorDni(int dni) {
        List<Cuenta> cuentasEncontradas = new ArrayList<>();
        for (Cuenta c : cuentas) {
            if (c.getTitular().getDni() == dni) cuentasEncontradas.add(c);
        }
        return cuentasEncontradas;
    }

    public List<Cuenta> getDeudores() {
        List<Cuenta> deudores = new ArrayList<>();
        for (Cuenta c : cuentas) {
            if (c.getSaldo() < 0) deudores.add(c);
        }
        return deudores;
    }

    public void getReporteDeudores() {
        List<Cuenta> deudores = getDeudores();

        System.out.println("======= REPORTE DE CLIENTES EN MORA =======");
        if (deudores.isEmpty()) {
            System.out.println("No hay clientes con saldo negativo. ¡Todo al día!");
        } else {
            for (Cuenta c : deudores) {
                System.out.println("Cliente: " + c.getTitular().getApellido() + ", " + c.getTitular().getNombre());
                System.out.println("Nro Cuenta: " + c.getNumeroCuenta());
                System.out.println("Deuda: $" + Math.abs(c.getSaldo()));
                System.out.println("-------------------------------------------");
            }
        }
    }

    public String getNombre() {
        return nombre;
    }

    // Setters
    public void setCuenta(Cuenta nuevaCuenta) {
        this.cuentas.add(nuevaCuenta);
    }

}
