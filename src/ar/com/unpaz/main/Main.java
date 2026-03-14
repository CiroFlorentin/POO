package ar.com.unpaz.main;

import ar.com.unpaz.model.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Cuenta 1
        Contacto conCiro = new Contacto("Paunero", "Jose C. Paz", 1024, 1665, "cfloren01@gmail.com");
        Cliente Ciro = new Cliente("Ciro", "Florentin", 45072536, conCiro);

        // Cuentas de banco
        CajaAhorro ca = new CajaAhorro("CA-001", Ciro);
        ca.depositar(5000);

        CuentaCorriente cc = new CuentaCorriente("CC-001", Ciro, 10000);
        cc.depositar(10000);
        // Banco
        Banco unpaz = new Banco("Banco UNPAZ");
        unpaz.setCuenta(ca);
        unpaz.setCuenta(cc);

        unpaz.getCuentas();

        //gastos
        System.out.println("Compra de un auto con CC");
        System.out.println(cc.retirar(12000) ? "Se pago $12000" : "Saldo Insuficiente");
        System.out.println(cc.retirar(12000) ? "Se pago $12000" : "Saldo Insuficiente");

        System.out.println("Compra de una heladera con Ca");
        System.out.println(ca.retirar(2000) ? "Se pago $2000" : "Saldo Insuficiente");

        unpaz.getCuentas();

        //Busqueda por dni
        System.out.println("Cuentas con el DNI 45072536");
        List<Cuenta> cuentasEncontradas = unpaz.getCuentaPorDni(45072536);
        if (cuentasEncontradas.isEmpty()) {
            System.out.println("No se encontraron cuentas con ese DNI");
        } else {
            for (Cuenta c : cuentasEncontradas) {
                System.out.println("Numero de cuenta: " + c.getNumeroCuenta() + " | Saldo: " + c.getSaldo());
            }
        }
    }
}
