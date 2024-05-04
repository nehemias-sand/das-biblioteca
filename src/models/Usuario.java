package models;

import strategy.PoliticaPrestamo;

public abstract class Usuario {
    protected String nombre;
    protected PoliticaPrestamo politicaPrestamo;

    public abstract void setPoliticaPrestamo();

    public void solicitarPrestamo(Libro libro) {
        politicaPrestamo.solicitarPrestamo(libro);
    }

    public String getNombre() {
        return nombre;
    }
}
