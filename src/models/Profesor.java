package models;

import strategy.PoliticaPrestamoProfesor;

public class Profesor extends Usuario {

    public Profesor(String nombre) {
        this.nombre = nombre;
        setPoliticaPrestamo();
    }

    @Override
    public void setPoliticaPrestamo() {
        politicaPrestamo = new PoliticaPrestamoProfesor();
    }
}
