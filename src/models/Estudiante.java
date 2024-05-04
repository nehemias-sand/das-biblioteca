package models;

import strategy.PoliticaPrestamoEstudiante;

public class Estudiante extends Usuario {

    public Estudiante(String nombre) {
        this.nombre = nombre;
        setPoliticaPrestamo();
    }

    @Override
    public void setPoliticaPrestamo() {
        politicaPrestamo = new PoliticaPrestamoEstudiante();
    }
}
