package factory;

import models.Estudiante;
import models.PersonalBiblioteca;
import models.Profesor;
import models.Usuario;

public class UsuarioFactory {
    public Usuario crearUsuario(String tipo, String nombre) {
        if (tipo.equalsIgnoreCase("estudiante"))
            return new Estudiante(nombre);

        else if (tipo.equalsIgnoreCase("profesor"))
            return new Profesor(nombre);

        else if (tipo.equalsIgnoreCase("personal"))
            return new PersonalBiblioteca(nombre);

        return null;
    }
}
