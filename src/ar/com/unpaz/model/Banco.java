package ar.com.unpaz.model;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    private String nombre;
    private List<Cuenta> cuentas;

    public Banco(String nombre) {
        this.nombre = nombre;
        this.cuentas = new ArrayList<>();
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

    // Setters
    public void setCuenta(Cuenta nuevaCuenta) {
        this.cuentas.add(nuevaCuenta);
    }

}
