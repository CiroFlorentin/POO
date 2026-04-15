package ar.com.libreriaunpaz.service;

import ar.com.libreriaunpaz.model.Libro;

import java.util.List;

public interface LibroService {
    void addLibro(Libro libro);

    List<Libro> listarLibros();

    Libro SearchWithCodigo(String codigo);

    void prestarLibro(String codigo);

    void devolverLibro(String codigo);

    List<Libro> librosPrestados();

    int cantidadPrestados();

    Libro libroMasAntiguo();
}
