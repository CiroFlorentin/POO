package ar.com.libreriaunpaz.repository;

import ar.com.libreriaunpaz.model.Libro;

import java.util.List;

public interface LibroRepository {
    void addLibro(Libro libro);

    List<Libro> listar();

    Libro SearchWithCodigo(String codigo);
}
