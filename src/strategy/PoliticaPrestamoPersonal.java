package strategy;

import models.Libro;

public class PoliticaPrestamoPersonal implements PoliticaPrestamo {
    @Override
    public void solicitarPrestamo(Libro libro) {
        System.out.println("Personal de biblioteca: " + libro.getTitulo() + " solicitado para préstamo.");
    }
}
