package paquete; 

// Importamos las clases necesarias para trabajar con bases de datos y para leer entradas del usuario
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Pelicula {

    private static final String url = "jdbc:mysql://localhost:3306/cine_sergiogonzalez";
    private static final String usuario = "root";
    private static final String contraseña = "1234";

    // Método principal que muestra el menú y ejecuta las opciones
    public void ejecutar() {
        Scanner scanner = new Scanner(System.in); // Se crea el objeto Scanner para leer desde teclado
        int opcion;

        do {
            // Mostramos el menú
            System.out.println("1 - Ver películas");
            System.out.println("2 - Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt(); 

            // Ejecutamos la opción seleccionada
            switch (opcion) {
                case 1:
                    mostrarPeliculas(); // Llama al método para mostrar películas
                    break;
                case 2:
                    System.out.println("Hasta luego."); // Mensaje de salida
                    break;
                default:
                    System.out.println("Opción no válida."); // En caso de que no se introduzca ni 1 ni 2
            }
        } while (opcion != 2); // Se repite mientras no se elija "Salir"

        scanner.close(); // Cerramos el Scanner al final
    }

    // Método que se conecta a la base de datos y muestra las películas junto con su género
    public static void mostrarPeliculas() {
        // Consulta SQL que une la tabla 'pelicula' con la tabla 'genero'
        String query = "SELECT p.id_pelicula, p.titulo, p.director, p.ano, p.duracion, g.nombre " +
                       "FROM pelicula p JOIN genero g ON p.id_genero = g.id_genero";

        // Se asegura de cerrar automáticamente la conexión, el Statement y el ResultSet
        try (
            Connection conexion = DriverManager.getConnection(url, usuario, contraseña); // Se conecta a la BD
            Statement stmt = conexion.createStatement(); // Se crea un objeto Statement para ejecutar la consulta
            ResultSet rs = stmt.executeQuery(query) // Se ejecuta la consulta y se guarda el resultado en ResultSet
        ) {
            // Imprime la cabecera de la tabla con formato
            System.out.printf("%-10s %-25s %-20s %-6s %-9s %-10s\n", 
                              "ID", "Título", "Director", "Año", "Duración", "Género");

            // Recorremos cada fila del resultado
            while (rs.next()) {
                // Imprimimos los datos de cada película
                System.out.printf("%-10s %-25s %-20s %-6d %-9d %-10s\n",
                                  rs.getString("id_pelicula"), 
                                  rs.getString("titulo"), 
                                  rs.getString("director"),
                                  rs.getInt("ano"), 
                                  rs.getInt("duracion"), 
                                  rs.getString("nombre")); 
            }

        } catch (Exception e) {
            // Si ocurre algún error durante la conexión o la consulta, se muestra el mensaje
            System.out.println("Error al acceder a la base de datos: " + e.getMessage());
        }
    }
}
