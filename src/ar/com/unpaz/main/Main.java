package ar.com.unpaz.main;

import ar.com.unpaz.model.*;

public class Main {
    public static void main(String[] args) {

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


        Cuenta cuenta1 = new Cuenta();

        cuenta1.setNumeroCuenta(1001);

        cuenta1.setSaldo(2000.50);

        Cuenta cuenta2 = new Cuenta();

        cuenta2.setNumeroCuenta(1002);
        cuenta2.setSaldo(1000.50);

        cliente1.setCuenta(cuenta1);
        cliente1.setCuenta(cuenta2);
        cliente1.setContacto(contacto1);

        System.out.println("Cuenta 1: ");
        System.out.println("Cuenta Nro: " + cuenta1.getNumberCuenta());
        System.out.println("Titular: " + cuenta1.getTitular().getNombre());
        System.out.println("DNI: " + cuenta1.getTitular().getDni());
        System.out.println("Email de contacto: " + cuenta1.getTitular().getContacto().getEmail());
        System.out.println("------------------------");

        System.out.println("Cuenta 2: ");
        System.out.println("Cuenta Nro: " + cuenta2.getNumberCuenta());
        System.out.println("Titular: " + cuenta2.getTitular().getNombre());
        System.out.println("DNI: " + cuenta2.getTitular().getDni());
        System.out.println("Email de contacto: " + cuenta2.getTitular().getContacto().getEmail());




    }
}
