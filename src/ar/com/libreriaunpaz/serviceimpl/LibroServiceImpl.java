package ar.com.libreriaunpaz.serviceimpl;

import ar.com.libreriaunpaz.model.Libro;
import ar.com.libreriaunpaz.repository.LibroRepository;
import ar.com.libreriaunpaz.service.LibroService;

import java.util.ArrayList;
import java.util.List;

public class LibroServiceImpl implements LibroService {
    private LibroRepository repo;

    public LibroServiceImpl(LibroRepository repo) {
        this.repo = repo;
    }

    @Override
    public void addLibro(Libro libro) {
        repo.addLibro(libro);
    }

    @Override
    public List<Libro> listarLibros() {
        return repo.listar();
    }

    @Override
    public Libro SearchWithCodigo(String codigo) {
        return repo.SearchWithCodigo(codigo);
    }

    @Override
    public void prestarLibro(String codigo) {
        Libro libro = repo.SearchWithCodigo(codigo);
        if (libro == null) {
            System.out.println("Libro no encontrado");
            return;
        }
        if (libro.getEstaPrestado()) {
            System.out.println("El libro ya está prestado");
        } else {
            libro.setEstaPrestado(true);
            System.out.println("Libro prestado correctamente");
        }
    }

    @Override
    public void devolverLibro(String codigo) {
        Libro libro = repo.SearchWithCodigo(codigo);
        if (libro == null) {
            System.out.println("Libro no encontrado");
            return;
        }
        if (!libro.getEstaPrestado()) {
            System.out.println("El libro ya estaba disponible");
        } else {
            libro.setEstaPrestado(false);
            System.out.println("Libro devuelto correctamente");
        }
    }

    @Override
    public List<Libro> librosPrestados() {
        List<Libro> librosPrestados = new ArrayList<>();

        for (Libro l : repo.listar()) {
            if (l.getEstaPrestado()) {
                librosPrestados.add(l);
            }
        }
        return librosPrestados;
    }

    @Override
    public int cantidadPrestados() {
        int contador = 0;

        for (Libro l : repo.listar()) {
            if (l.getEstaPrestado()) {
                contador++;
            }
        }
        return contador;
    }

    @Override
    public Libro libroMasAntiguo() {
        List<Libro> libros = repo.listar();

        if (libros.isEmpty()) return null;

        Libro masAntiguo = libros.getFirst();

        for (Libro l : libros) {
            if (l.getAnio() < masAntiguo.getAnio()) {
                masAntiguo = l;
            }
        }

        return masAntiguo;
    }
}
