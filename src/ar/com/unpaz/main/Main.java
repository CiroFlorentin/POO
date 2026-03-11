package ar.com.unpaz.main;

import ar.com.unpaz.model.*;

public class Main {
    public static void main(String[] args) {

        Cuenta cuenta1 = new Cuenta();

        cuenta1.setNumeroCuenta(1001);

        cuenta1.setSaldo(2000.50);

        cuenta1.setTitular("Ciro Florentin");

        System.out.println("Numero de cuenta " + cuenta1.getNumberCuenta());
        System.out.println("Titular de la cuenta " + cuenta1.getTitular());
        System.out.println("Saldo de la cuenta: " + cuenta1.getSaldo());

        System.out.println("------------------------");

        Cliente cliente1 = new Cliente();

        cliente1.setNombre("Ciro");
        cliente1.setApellido("Florentin");
        cliente1.setDni(45072536);

        System.out.println("Nombre: " + cliente1.getNombre());
        System.out.println("Apellido: " + cliente1.getApellido());
        System.out.println("DNI: " + cliente1.getDni());

        System.out.println("------------------------");

        Contacto contacto1 = new Contacto();
        contacto1.setCalle("piñero");
        contacto1.setCodigoPostal(1664);
        contacto1.setNumero(1024);
        contacto1.setLocalidad("Jose C Paz");
        contacto1.setEmail("cfloren01@gmail.com");

        System.out.println("Calle: " + contacto1.getCalle());
        System.out.println("Numero: " + contacto1.getNumero());
        System.out.println("Localidad: " + contacto1.getLocalidad());
        System.out.println("Cp: " + contacto1.getCodigoPostal());
        System.out.println("Email: " + contacto1.getEmail());

        System.out.println("------------------------");


        cliente1.setCuenta(cuenta1);
        cliente1.setContacto(contacto1);

    }
}
