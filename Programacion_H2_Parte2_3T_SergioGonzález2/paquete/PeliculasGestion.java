package paquete;

import java.sql.*;
import java.util.Scanner;

public class PeliculasGestion {
    // Credenciales y URL para la conexión a la base de datos
    private static final String url = "jdbc:mysql://localhost:3306/cine_sergiogonzalez";
    private static final String usuario = "root";
    private static final String contraseña = "1234";

    // Muestra todas las películas registradas junto con su género
    public void verPeliculas() {
        // Consulta para obtener información de las películas y su género asociado
        String consulta = "SELECT p.id_pelicula, p.titulo, p.director, p.ano, p.duracion, g.nombre " +
                          "FROM pelicula p JOIN genero g ON p.id_genero = g.id_genero";

        // Ejecuta la consulta y muestra los resultados en formato tabulado
        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
             PreparedStatement ps = conexion.prepareStatement(consulta);
             ResultSet rs = ps.executeQuery()) {

            System.out.printf("%-10s %-25s %-20s %-6s %-9s %-10s\n",
                    "ID", "TITULO", "DIRECTOR", "AÑO", "DURACION", "GENERO");

            while (rs.next()) {
                System.out.printf("%-10s %-25s %-20s %-6d %-9d %-10s\n",
                        rs.getString("id_pelicula"),
                        rs.getString("titulo"),
                        rs.getString("director"),
                        rs.getInt("ano"),
                        rs.getInt("duracion"),
                        rs.getString("nombre"));
            }

        } catch (SQLException e) {
            System.out.println("Error al mostrar las películas: " + e.getMessage());
        }
    }

    // Añade una nueva película a la base de datos
    public void anadirPelicula(Scanner scanner) {
        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña)) {
            System.out.print("Id de la Película: ");
            String id = scanner.nextLine();

            // Verifica si ya existe una película con el mismo ID
            String comprobar = "SELECT COUNT(*) FROM pelicula WHERE id_pelicula = ?";
            PreparedStatement psCheck = conexion.prepareStatement(comprobar);
            psCheck.setString(1, id);
            ResultSet rs = psCheck.executeQuery();
            rs.next();
            if (rs.getInt(1) > 0) {
                System.out.println("Ya existe una película con este ID.");
                return;
            }

            // Solicita al usuario los datos restantes de la película
            System.out.print("Título: ");
            String titulo = scanner.nextLine();
            System.out.print("Director: ");
            String director = scanner.nextLine();
            System.out.print("Año: ");
            int ano = scanner.nextInt();
            System.out.print("Duración en minutos: ");
            int duracion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer
            System.out.print("Género: ");
            String nombreGenero = scanner.nextLine();

            // Busca el ID del género introducido
            String buscarGenero = "SELECT id_genero FROM genero WHERE LOWER(nombre) = LOWER(?)";
            PreparedStatement psGenero = conexion.prepareStatement(buscarGenero);
            psGenero.setString(1, nombreGenero);
            ResultSet rsGenero = psGenero.executeQuery();

            if (!rsGenero.next()) {
                System.out.println("El género '" + nombreGenero + "' no existe.");
                return;
            }
            String idGenero = rsGenero.getString("id_genero");

            // Inserta la nueva película en la base de datos
            String insertar = "INSERT INTO pelicula VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement psInsertar = conexion.prepareStatement(insertar);
            psInsertar.setString(1, id);
            psInsertar.setString(2, titulo);
            psInsertar.setString(3, director);
            psInsertar.setInt(4, ano);
            psInsertar.setInt(5, duracion);
            psInsertar.setString(6, idGenero);

            psInsertar.executeUpdate();
            System.out.println("Película añadida correctamente.");

        } catch (SQLException e) {
            System.out.println("Error al añadir la película: " + e.getMessage());
        }
    }

    // Elimina una película de la base de datos por su ID
    public void eliminarPelicula(Scanner scanner) {
        System.out.print("ID de la película que deseas eliminar: ");
        String id = scanner.nextLine();

        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña)) {
            String eliminar = "DELETE FROM pelicula WHERE id_pelicula = ?";
            PreparedStatement ps = conexion.prepareStatement(eliminar);
            ps.setString(1, id);

            // Ejecuta la eliminación y muestra el resultado
            int filas = ps.executeUpdate();

            if (filas > 0) {
                System.out.println("Película eliminada correctamente.");
            } else {
                System.out.println("No existe una película con ese ID.");
            }

        } catch (SQLException e) {
            System.out.println("Error al eliminar la película: " + e.getMessage());
        }
    }

    // Modifica el título y director de una película existente
    public void modificarPelicula(Scanner scanner) {
        System.out.print("ID de la película a modificar: ");
        String id = scanner.nextLine();

        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña)) {
            System.out.print("Nuevo título: ");
            String nuevoTitulo = scanner.nextLine();
            System.out.print("Nuevo director: ");
            String nuevoDirector = scanner.nextLine();

            // Consulta para actualizar los datos de la película
            String actualizar = "UPDATE pelicula SET titulo = ?, director = ? WHERE id_pelicula = ?";
            PreparedStatement ps = conexion.prepareStatement(actualizar);
            ps.setString(1, nuevoTitulo);
            ps.setString(2, nuevoDirector);
            ps.setString(3, id);

            int filas = ps.executeUpdate();
            if (filas > 0) {
                System.out.println("Película modificada correctamente.");
            } else {
                System.out.println("No existe ninguna película con ese ID.");
            }

        } catch (SQLException e) {
            System.out.println("Error al modificar la película: " + e.getMessage());
        }
    }
}
