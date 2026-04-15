package ar.com.libreriaunpaz.repositorimpl;

import ar.com.libreriaunpaz.model.Libro;
import ar.com.libreriaunpaz.repository.LibroRepository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class LibroRepositoryImpl implements LibroRepository {
    private List<Libro> libros;

    public LibroRepositoryImpl() {
        this.libros = leerArchivo();
    }

    private List<Libro> leerArchivo() {
        List<Libro> libros = new ArrayList<>();
        File file = new File("libros.txt");
        try (BufferedReader buffer = new BufferedReader(new FileReader(file))) {
            String linea;
            while ((linea = buffer.readLine()) != null) {
                String[] array = linea.split(",");
                String codigo = array[0];
                String titulo = array[1];
                String autor = array[2];
                int anio = Integer.parseInt(array[3]);
                boolean estaPrestada = Boolean.parseBoolean(array[4]);
                Libro libro = new Libro(codigo, titulo, autor, anio, estaPrestada);
                libros.add(libro);
            }
        } catch (Exception e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        return libros;
    }

    @Override
    public void addLibro(Libro libro) {
        libros.add(libro);
    }

    @Override
    public List<Libro> listar() {
        return libros;
    }

    @Override
    public Libro SearchWithCodigo(String codigo) {
        for (Libro l : libros) {
            if (l.getCodigo().equalsIgnoreCase(codigo)) {
                return l;
            }
        }
        return null;
    }
}

