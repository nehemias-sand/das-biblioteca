package models;

import strategy.PoliticaPrestamoPersonal;

public class PersonalBiblioteca extends Usuario {

    public PersonalBiblioteca(String nombre) {
        this.nombre = nombre;
        setPoliticaPrestamo();
    }

    @Override
    public void setPoliticaPrestamo() {
        politicaPrestamo = new PoliticaPrestamoPersonal();
    }
}
