// Declara del paquete donde se encuentra la clase
package paquete;

// La clase Perro extiende de la clase abstracta Animal, por lo que hereda sus atributos y métodos
public class Perro extends Animal {

    // Atributo específico de los perros
    private String tamaño;

    // Constructor de la clase Perro que recibe todos los atributos, incluyendo los heredados de Animal
    public Perro(String numero_chip, String nombre, int edad, String raza, boolean adoptado, String tamaño) {
        // Llama al constructor de la clase padre (Animal) para inicializar los atributos comunes
        super(numero_chip, nombre, edad, raza, adoptado);
        // Inicializamos el atributo propio de la clase Perro
        this.tamaño = tamaño;
    }

    // Sobrescribe el método abstracto mostrar() definido en Animal
    // Este método imprime en consola todos los datos del perro
    @Override
    public void mostrar() {
        System.out.println("El numero de chip: " + numero_chip);
        System.out.println("El nombre del perro: " + nombre);
        System.out.println("La edad del perro: " + edad);
        System.out.println("La raza del perro es: " + raza);
        System.out.println("El perro es adoptado o no: " + adoptado);
        System.out.println("El tamaño del perro es: " + tamaño);
    }
}

