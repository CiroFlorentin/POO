package ar.com.unpaz.Repository;

import ar.com.unpaz.Model.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LecturaArchivo {

    public List<Cuenta> leerArchivo() {

        List<Cuenta> lineasDelArchivo = new ArrayList<Cuenta>();

        File file = new File("C:\\Users\\CIRO\\Documents\\Documentos\\Programacion\\POO\\src\\cuenta");
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader buffer = new BufferedReader(fileReader);
            String linea = "";
            while ((linea = buffer.readLine()) != null) {
                String[] array = linea.split(";");
                int descubierto = (int) Double.parseDouble(array[10]);
                double saldo = Double.parseDouble(array[9]);
                Contacto contacto = new Contacto(array[4], array[5], Integer.parseInt(array[6]), Integer.parseInt(array[7]), array[8]);
                Cliente titular = new Cliente(array[1], array[2], Integer.parseInt(array[3]), contacto);
                if (array[0].equalsIgnoreCase("CC")) {
                    CuentaCorriente cc = new CuentaCorriente(titular, descubierto, saldo);
                    lineasDelArchivo.add(cc);
                } else if (array[0].equalsIgnoreCase("CS")) {
                    CuentaSueldo cs = new CuentaSueldo(titular, saldo);
                    lineasDelArchivo.add(cs);
                } else if (array[0].equalsIgnoreCase("CA")) {
                    CajaAhorro ca = new CajaAhorro(titular, saldo);
                    lineasDelArchivo.add(ca);

                }

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return lineasDelArchivo;
    }
}
