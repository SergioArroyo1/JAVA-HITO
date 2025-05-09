package paquete;

// Importamos las clases necesarias para la conexión a la base de datos
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBasica {
    public static void main(String[] args) {
        
        // URL de conexión a la base de datos
        String url = "jdbc:mysql://localhost:3306/cine_sergiogonzalez";
        
        // Introducimos el usuario y contraseña con los que accedemos a MySQL
        String usuario = "root";
        String contraseña = "1234";

        try {
            // Establecemos la conexión a la base de datos usando los datos anteriores
            Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
            
            // Si se establece correctamente, mostramos un mensaje por consola
            System.out.println("¡Conexión exitosa!");
            conexion.close();
            
        } catch (SQLException e) {
            // Si ocurre un error al conectarse, lo mostramos por consola
            System.out.println("Error de conexión: " + e.getMessage());
        }
    }
}
