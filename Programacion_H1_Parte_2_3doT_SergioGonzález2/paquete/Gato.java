// Declara del paquete donde se encuentra la clase
package paquete;

// Clase Gato que hereda de la clase abstracta Animal
public class Gato extends Animal {

    // Atributo propio de los gatos: indica si ha pasado el test de leucemia
    private boolean test_leucemia;

    // Constructor de la clase Gato que recibe todos los atributos, incluyendo los heredados
    public Gato(String numero_chip, String nombre, int edad, String raza, boolean adoptado, boolean test_leucemia) {
        // Llama al constructor de la clase padre (Animal) para inicializar los atributos comunes
        super(numero_chip, nombre, edad, raza, adoptado);

        // Inicializa el atributo específico de Gato
        this.test_leucemia = test_leucemia;
    }

    // Implementamos el método abstracto mostrar() heredado de Animal
    // Este método imprime en consola todos los datos del gato
    @Override
    public void mostrar() {
        System.out.println("El numero del chip: " + numero_chip);
        System.out.println("El nombre del gato: " + nombre);
        System.out.println("La edad del gato: " + edad);
        System.out.println("La raza del gato es: " + raza);
        System.out.println("El gato es adoptado: " + adoptado);
        System.out.println("El test de leucemia ha dado: " + test_leucemia);
    }
    
    public boolean getTestLeucemia() {
    	return test_leucemia;
    }
}

