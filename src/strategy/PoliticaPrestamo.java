package strategy;

import models.Libro;

public interface PoliticaPrestamo {
    void solicitarPrestamo(Libro libro);
}
