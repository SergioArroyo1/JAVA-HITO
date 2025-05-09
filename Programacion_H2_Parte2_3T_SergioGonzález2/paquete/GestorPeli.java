package paquete;

import java.util.Scanner;

public class GestorPeli {
    // Instancia de la clase encargada de gestionar las operaciones con películas
    private final PeliculasGestion dao = new PeliculasGestion();
    private final Scanner scanner = new Scanner(System.in);

    // Muestra el menú principal y gestiona las opciones del usuario
    public void menu() {
        int opcion;
        do {
            System.out.println("\nMENU CINE:");
            System.out.println("1 - Ver películas");
            System.out.println("2 - Añadir película");
            System.out.println("3 - Eliminar película");
            System.out.println("4 - Modificar película");
            System.out.println("5 - Salir");
            System.out.print("Selecciona una opción: ");
            opcion = Integer.parseInt(scanner.nextLine());

            // Ejecuta la acción correspondiente según la opción seleccionada
            switch (opcion) {
                case 1 -> dao.verPeliculas();
                case 2 -> dao.anadirPelicula(scanner);
                case 3 -> dao.eliminarPelicula(scanner);
                case 4 -> dao.modificarPelicula(scanner);
                case 5 -> System.out.println("Hasta la vista");
                default -> System.out.println("Opción no válida");
            }

        } while (opcion != 5);
        
        scanner.close();
    }
}

