package ar.com.unpaz.Main;

import ar.com.unpaz.Model.*;
import ar.com.unpaz.Repository.LecturaArchivo;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Banco banco = new Banco("Banco de Unpaz");
        cargarDatosPrueba(banco);
        int opcion = 0;

        System.out.println("Bienvenido al Sistema del " + banco.getNombre());

        do {
            mostrarMenuPrincipal();
            opcion = leerEntero(sc, "Seleccione una opcion: ");

            switch (opcion) {
                case 1:
                    crearCuentaMenu(sc, banco);
                    break;
                case 2:
                    banco.getCuentas();
                    break;
                case 3:
                    realizarDeposito(sc, banco);
                    break;
                case 4:
                    realizarTrans(sc, banco);
                    break;
                case 5:
                    banco.getReporteDeudores();
                    break;
                case 6:
                    cargarDatos(banco);
                case 0:
                    System.out.println("Saliendo del sistema.");
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        }
        while (opcion != 0);
        sc.close();
    }

    private static void mostrarMenuPrincipal() {
        System.out.println("\n--- MENÚ DE OPERACIONES ---");
        System.out.println("1. Crear Cuenta");
        System.out.println("2. Ver todas las cuentas");
        System.out.println("3. Depositar");
        System.out.println("4. Transferir");
        System.out.println("5. Ver Deudores");
        System.out.println("6. Cargar Datos");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void crearCuentaMenu(Scanner sc, Banco banco) {
        System.out.println("\n1. Caja de ahoros | 2. Cuenta Corriente | 3. Cuenta Sueldo");
        int tipo = leerEntero(sc, "Tipo: ");

        Cliente nuevoCliente = pedirDatosCliente(sc);

        switch (tipo) {
            case 1:
                CajaAhorro nuevaCaja = new CajaAhorro(nuevoCliente);
                banco.setCuenta(nuevaCaja);
                System.out.println("Exito. Nro: " + nuevaCaja.getNumeroCuenta());
                break;
            case 2:
                CuentaCorriente nuevaCC = new CuentaCorriente(nuevoCliente, 5000);
                banco.setCuenta(nuevaCC);
                System.out.println("Exito. Nro: " + nuevaCC.getNumeroCuenta());
                break;
            case 3:
                System.out.print("Nombre de la empresa: ");
                String empresa = sc.nextLine();
                CuentaSueldo nuevaCS = new CuentaSueldo(nuevoCliente, empresa);
                banco.setCuenta(nuevaCS);
                System.out.println("Exito. Nro: " + nuevaCS.getNumeroCuenta());
            default:
                System.out.println("Opcion no valida.");
        }
    }

    private static Cliente pedirDatosCliente(Scanner sc) {
        System.out.print("Nombre: ");
        String nom = sc.nextLine();
        System.out.print("Apellido: ");
        String ape = sc.nextLine();
        int dni = leerEntero(sc, "DNI: ");

        System.out.println("--- Contacto ---");
        System.out.print("Calle: ");
        String calle = sc.nextLine();
        System.out.print("Localidad: ");
        String loc = sc.nextLine();
        int nro = leerEntero(sc, "Altura: ");
        int cp = leerEntero(sc, "CP: ");
        System.out.print("Email: ");
        String email = sc.nextLine();

        Contacto con = new Contacto(calle, loc, nro, cp, email);
        return new Cliente(nom, ape, dni, con);
    }

    private static int leerEntero(Scanner sc, String mensaje) {
        System.out.print(mensaje);
        int valor = sc.nextInt();
        sc.nextLine();
        return valor;
    }

    private static double leerDouble(Scanner sc, String mensaje) {
        System.out.print(mensaje);
        double valor = sc.nextDouble();
        sc.nextLine();
        return valor;
    }

    private static void realizarDeposito(Scanner sc, Banco banco) {
        System.out.print("Nro de cuenta: ");
        String nroCuenta = sc.nextLine().toUpperCase().trim();
        Cuenta cuenta = banco.getCuentaPorNumero(nroCuenta);
        if (cuenta == null) {
            System.err.println("❌ Error: La cuenta " + nroCuenta + " no existe.");
            return;
        }
        double monto = leerDouble(sc, "Monto a depositar: $");
        cuenta.depositar(monto);
        System.out.println("✅ Depósito exitoso. Nuevo balance: $" + cuenta.getSaldo());
    }

    private static void realizarTrans(Scanner sc, Banco banco) {
        System.out.print("Número de cuenta ORIGEN: ");
        String origen = sc.nextLine().toUpperCase().trim();
        System.out.print("Número de cuenta DESTINO: ");
        String destino = sc.nextLine().toUpperCase().trim();
        double monto = leerDouble(sc, "Monto a transferir: $");

        try {
            banco.transferir(origen, destino, monto);
        } catch (CuentaNoEncontrada e) {
            System.err.println("⚠️ Error de búsqueda: " + e.getMessage());
        } catch (SaldoInsuficienteException e) {
            System.err.println("🚫 Error de balance: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        }
    }

    private static void cargarDatos(Banco banco) {
        LecturaArchivo lecturaArchivo = new LecturaArchivo();
        List<Cuenta> listadoCuentas = lecturaArchivo.leerArchivo();
        for (Cuenta cuenta : listadoCuentas) {
            banco.setCuenta(cuenta);
            System.out.println("Cuenta cargada: " + cuenta.getNumeroCuenta());
        }
    }

    //mock datos
    private static void cargarDatosPrueba(Banco banco) {
        Contacto c1 = new Contacto("Av. Siempre Viva 742", "Springfield", 123, 1665, "homer@test.com");
        Cliente cliente1 = new Cliente("Homero", "Simpson", 11111111, c1);

        CajaAhorro ca = new CajaAhorro(cliente1);
        ca.depositar(10000); // Le damos balance inicial para probar transferencias
        banco.setCuenta(ca);

        Contacto c2 = new Contacto("Calle Falsa 123", "Paz", 456, 1665, "ned@test.com");
        Cliente cliente2 = new Cliente("Ned", "Flanders", 22222222, c2);

        CuentaCorriente cc = new CuentaCorriente(cliente2, 5000);
        banco.setCuenta(cc);

        System.out.println(">>> Datos de prueba cargados (CA-001 y CC-001)");
    }


}
