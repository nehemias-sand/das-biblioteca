package strategy;

import models.Libro;

public class PoliticaPrestamoProfesor implements PoliticaPrestamo {
    @Override
    public void solicitarPrestamo(Libro libro) {
        System.out.println("Profesor: " + libro.getTitulo() + " solicitado para préstamo.");
    }
}
