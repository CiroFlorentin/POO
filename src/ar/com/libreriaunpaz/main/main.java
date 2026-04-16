package ar.com.libreriaunpaz.main;


import ar.com.libreriaunpaz.model.Libro;
import ar.com.libreriaunpaz.repositorimpl.LibroRepositoryImpl;
import ar.com.libreriaunpaz.repository.LibroRepository;
import ar.com.libreriaunpaz.service.LibroService;
import ar.com.libreriaunpaz.serviceimpl.LibroServiceImpl;

import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        LibroRepository repo = new LibroRepositoryImpl();
        LibroService service = new LibroServiceImpl(repo);

        int opcion;

        do {
            System.out.println("\n===== MENÚ BIBLIOTECA =====");
            System.out.println("1. Agregar libro");
            System.out.println("2. Listar todos los libros");
            System.out.println("3. Buscar libro por código");
            System.out.println("4. Prestar libro");
            System.out.println("5. Devolver libro");
            System.out.println("6. Mostrar libros prestados");
            System.out.println("7. Cantidad de libros prestados");
            System.out.println("8. Mostrar libro más antiguo");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Código: ");
                    String codigo = scanner.nextLine();

                    System.out.print("Título: ");
                    String titulo = scanner.nextLine();

                    System.out.print("Autor: ");
                    String autor = scanner.nextLine();

                    System.out.print("Año: ");
                    int anio = scanner.nextInt();
                    scanner.nextLine();

                    Libro libro = new Libro(codigo, titulo, autor, anio, false);
                    service.addLibro(libro);

                    System.out.println("Libro agregado correctamente");
                    break;

                case 2:
                    List<Libro> libros = service.listarLibros();

                    if (libros.isEmpty()) {
                        System.out.println("No hay libros cargados");
                    } else {
                        mostrarHeader(libros);
                    }
                    break;

                case 3:
                    System.out.print("Ingrese código: ");
                    String codBuscar = scanner.nextLine();

                    Libro encontrado = service.SearchWithCodigo(codBuscar);

                    if (encontrado == null) {
                        System.out.println("Libro no encontrado");
                    } else {
                        System.out.println(encontrado);
                    }
                    break;

                case 4:
                    System.out.print("Código del libro a prestar: ");
                    String codPrestar = scanner.nextLine();
                    service.prestarLibro(codPrestar);
                    break;

                case 5:
                    System.out.print("Código del libro a devolver: ");
                    String codDevolver = scanner.nextLine();
                    service.devolverLibro(codDevolver);
                    break;

                case 6:
                    List<Libro> prestados = service.librosPrestados();

                    if (prestados.isEmpty()) {
                        System.out.println("No hay libros prestados");
                    } else {
                        mostrarHeader(prestados);
                    }
                    break;

                case 7:
                    int cantidad = service.cantidadPrestados();
                    System.out.println("Libros prestados: " + cantidad);
                    break;

                case 8:
                    Libro antiguo = service.libroMasAntiguo();

                    if (antiguo == null) {
                        System.out.println("No hay libros cargados");
                    } else {
                        System.out.println("Libro más antiguo:");
                        System.out.println(antiguo);
                    }
                    break;

                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción inválida");
            }

        } while (opcion != 0);

        scanner.close();
    }

    private static void mostrarHeader(List<Libro> libros) {
        System.out.printf("%-10s %-20s %-20s %-6s %-12s\n",
                "CODIGO", "TITULO", "AUTOR", "AÑO", "ESTADO");
        System.out.println("---------------------------------------------------------------------");
        for (Libro l : libros) {
            System.out.println(l);
        }
    }
}

