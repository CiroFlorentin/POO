package ar.com.unpaz.Repository;

import ar.com.unpaz.Model.Cliente;
import ar.com.unpaz.Model.Contacto;
import ar.com.unpaz.Model.CuentaCorriente;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LecturaArchivo {

    public List<CuentaCorriente> leerArchivo() {

        List<CuentaCorriente> lineasDelArchivo = new ArrayList<CuentaCorriente>();

        File file = new File("C:\\Users\\CIRO\\Documents\\Documentos\\Programacion\\POO\\src\\cuenta");
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader buffer = new BufferedReader(fileReader);
            String linea = "";
            while ((linea = buffer.readLine()) != null) {
                String[] array = linea.split(";");
                int descubierto = (int) Double.parseDouble(array[9]);
                double saldo = Double.parseDouble(array[8]);
                Contacto contacto = new Contacto(array[3], array[4], Integer.parseInt(array[5]), Integer.parseInt(array[6]), array[7]);
                Cliente titular = new Cliente(array[0], array[1], Integer.parseInt(array[2]), contacto);
                CuentaCorriente cc = new CuentaCorriente(titular, descubierto, saldo);
                lineasDelArchivo.add(cc);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return lineasDelArchivo;
    }
}
