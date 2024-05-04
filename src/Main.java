import factory.UsuarioFactory;
import models.Libro;
import models.Usuario;
import service.InventarioLibros;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        UsuarioFactory usuarioFactory = new UsuarioFactory();
        Usuario usuario = null;

        InventarioLibros inventario = new InventarioLibros();
        inventario.agregarLibro(new Libro("El Principito", "Antoine de Saint-Exupéry"));
        inventario.agregarLibro(new Libro("Cien años de soledad", "Gabriel García Márquez"));
        inventario.agregarLibro(new Libro("Harry Potter y la piedra filosofal", "J.K. Rowling"));

        int opcion;
        do {
            System.out.println("==== Menú ====");
            System.out.println("1. Prestar un libro");
            System.out.println("2. Gestionar inventario");
            System.out.println("0. Salir");
            System.out.print("Ingrese su opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> {
                    System.out.println("Ingrese el tipo de usuario (estudiante, profesor, personal):");
                    String tipoUsuario = scanner.nextLine();
                    System.out.println("Ingrese el nombre:");
                    String nombreUsuario = scanner.nextLine();
                    usuario = usuarioFactory.crearUsuario(tipoUsuario, nombreUsuario);
                    System.out.println("Inventario de libros:");
                    inventario.mostrarInventario();

                    System.out.println("Ingrese el número del libro que desea prestar:");
                    int numeroLibro = scanner.nextInt();
                    scanner.nextLine();

                    if (numeroLibro >= 1 && numeroLibro <= inventario.numeroLibros()) {

                        Libro libroSeleccionado = inventario.obtenerLibro(numeroLibro - 1);
                        usuario.solicitarPrestamo(libroSeleccionado);
                        inventario.eliminarLibro(libroSeleccionado);

                    } else {
                        System.out.println("Número de libro no válido.");
                    }
                }
                case 2 -> {
                    System.out.println("==== Gestión de inventario ====");
                    System.out.println("1. Ver inventario");
                    System.out.println("2. Agregar libro");
                    System.out.println("3. Eliminar libro");
                    System.out.println("4. Buscar libro");
                    System.out.print("Ingrese su opción: ");
                    int opcionGestion = scanner.nextInt();
                    scanner.nextLine();

                    switch (opcionGestion) {
                        case 1 -> inventario.mostrarInventario();
                        case 2 -> {
                            System.out.println("Ingrese el título del libro:");
                            String titulo = scanner.nextLine();

                            System.out.println("Ingrese el autor del libro:");
                            String autor = scanner.nextLine();

                            inventario.agregarLibro(new Libro(titulo, autor));
                            System.out.println("Libro agregado al inventario.");
                        }
                        case 3 -> {
                            System.out.println("Inventario de libros:");
                            inventario.mostrarInventario();

                            System.out.println("Ingrese el número del libro que desea eliminar:");
                            int numeroLibroEliminar = scanner.nextInt();
                            scanner.nextLine();

                            if (numeroLibroEliminar >= 1 && numeroLibroEliminar <= inventario.numeroLibros()) {

                                Libro libroEliminar = inventario.obtenerLibro(numeroLibroEliminar - 1);
                                if (inventario.eliminarLibro(libroEliminar)) {
                                    System.out.println("Libro eliminado del inventario.");
                                } else {
                                    System.out.println("Error al eliminar el libro del inventario.");
                                }

                            } else {
                                System.out.println("Número de libro no válido.");
                            }
                        }
                        case 4 -> {
                            System.out.println("Ingrese el título del libro a buscar:");
                            String tituloBuscar = scanner.nextLine();

                            System.out.println("Resultados de la búsqueda:");
                            for (Libro libroEncontrado : inventario.buscarLibro(tituloBuscar)) {
                                System.out.println(libroEncontrado.toString() + "\n");
                            }
                        }
                        default -> System.out.println("Opción no válida.");
                    }
                }
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción no válida.");
            }

        } while (opcion != 0);

        scanner.close();
    }
}
