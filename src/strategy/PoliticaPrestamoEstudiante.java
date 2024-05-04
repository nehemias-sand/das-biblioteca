package strategy;

import models.Libro;

public class PoliticaPrestamoEstudiante implements PoliticaPrestamo {
    @Override
    public void solicitarPrestamo(Libro libro) {
        System.out.println("Estudiante: " + libro.getTitulo() + " solicitado para préstamo.");
    }
}
