package service;

import models.Libro;

import java.util.ArrayList;
import java.util.List;

public class InventarioLibros {
    private List<Libro> libros;

    public InventarioLibros() {
        libros = new ArrayList<>();
    }

    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    public boolean eliminarLibro(Libro libro) {
        return libros.remove(libro);
    }

    public List<Libro> buscarLibro(String titulo) {
        List<Libro> resultados = new ArrayList<>();
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                resultados.add(libro);
            }
        }
        return resultados;
    }

    public void mostrarInventario() {
        for (int i = 0; i < libros.size(); i++) {
            System.out.println((i + 1) + ". " + libros.get(i));
        }
    }

    public int numeroLibros() {
        return libros.size();
    }

    public Libro obtenerLibro(int indice) {
        return libros.get(indice);
    }
}
