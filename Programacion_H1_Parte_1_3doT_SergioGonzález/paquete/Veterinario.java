package paquete;

import java.util.ArrayList;
import java.util.Scanner;

// Clase principal que gestiona los animales a través de un menú interactivo
public class Veterinario {

    // Lista que almacena objetos de tipo Animal
    ArrayList<Animal> listaAnimal = new ArrayList<>();

    // Scanner para capturar la entrada del usuario por consola
    Scanner scanner = new Scanner(System.in);

    // Método para añadir un nuevo animal
    public void AñadirAnimal() {
        // Añade dos animales de ejemplo
        listaAnimal.add(new Perro("1234", "Tovi", 12, "Labrador", true, "mediano"));
        listaAnimal.add(new Gato("4567", "Asland", 5 , "Blanco", true, false));

        // Pregunta al usuario qué tipo de animal desea añadir
        System.out.println("Ingrese un nuevo animal: 1. Perro o 2. Gato: ");
        int tipo = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        // Captura el número del chip
        System.out.println("Introduce el numero del chip: ");
        String num_chip = scanner.nextLine();

        // Verificr si ya existe un animal con ese chip
        if (existeChip(num_chip)) {
            System.out.println("Ya existe un animal con ese número de chip.");
            return; // Sale del método si ya existe
        }

        // Captura datos comunes
        System.out.println("Introduce el nombre: ");
        String nombre = scanner.nextLine();

        System.out.println("Introduce la edad: ");
        int edad = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        System.out.println("Introduce la raza: ");
        String raza = scanner.nextLine();

        System.out.println("Introduce si es adoptado o no: ");
        boolean adoptado = scanner.nextBoolean();
        scanner.nextLine(); // Limpiar buffer

        // Si es un perro, coge su tamaño y crear el objeto correspondiente
        if (tipo == 1) {
            System.out.println("Introduce el tamaño (pequeño, mediano o grande): ");
            String tamaño = scanner.nextLine();
            listaAnimal.add(new Perro(num_chip, nombre, edad, raza, adoptado, tamaño));

        // Si es un gato, coge si tiene leucemia
        } else if (tipo == 2) {
            System.out.println("Ingresa si tiene leucemia o no: ");
            boolean test_leucemia = scanner.nextBoolean();
            scanner.nextLine(); // Limpiar buffer

            listaAnimal.add(new Gato(num_chip, nombre, edad, raza, adoptado, test_leucemia));
        }
    }

    // Método para buscar un animal por su número de chip
    public void buscarNumeroChip() {
        System.out.println("Introduce el numero del chip: ");
        String numero_chip = scanner.nextLine();

        boolean encontrar = false;

        // Busca en la lista de animales
        for (Animal animales : listaAnimal) {
            if (animales.getNumero_chip().equals(numero_chip)) {
                animales.mostrar(); // Muestra los datos si lo encuentra
                encontrar = true;
            }
        }

        // Si no se encontró el chip
        if (!encontrar) {
            System.out.println("No existe ningun animal con ese numero de chip.");
        }
    }

    // Método privado que comprueba si un chip ya está en uso
    private boolean existeChip(String chip) {
        for (Animal animal : listaAnimal) {
            if (animal.getNumero_chip().equals(chip)) {
                return true; // Chip encontrado
            }
        }
        return false; // Chip no encontrado
    }

    // Método que muestra el menú principal y gestiona las opciones
    public void menu() {
        int opcion;
        do {
            // Mostrar menú
            System.out.println(" MENÚ VETERINARIO ");
            System.out.println("1. Añade un animal: ");
            System.out.println("2. Buscar el número del chip: ");
            System.out.println("3. Salir: ");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            // Ejecutar la opción elegida
            switch (opcion) {
                case 1:
                    AñadirAnimal(); // Añadir animal
                    break;
                case 2:
                    buscarNumeroChip(); // Buscar animal por su numero de chip
                    break;
                case 3:
                    System.out.println("Hasta pronto"); // Salir
                    break;
                default:
                    System.out.println("La opcion no es valida"); // Opción incorrecta
            }
        } while (opcion != 3); // Repetir hasta que elija salir
    }
}


