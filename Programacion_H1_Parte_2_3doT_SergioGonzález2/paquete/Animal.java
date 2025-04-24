package paquete;

//Declaramos de una clase padre abstracta llamada Animal
public abstract class Animal {

 // Atributos protegidos (accesibles desde la misma clase, subclases y el mismo paquete)
 protected String numero_chip;   // Identificador único del animal 
 protected String nombre;        // Nombre del animal
 protected int edad;             // Edad del animal
 protected String raza;          // Raza del animal
 protected boolean adoptado;     // Estado de adopción (true si ha sido adoptado)

 // Constructor de la clase que inicializa todos los atributos
 public Animal(String numero_chip, String nombre, int edad, String raza, boolean adoptado) {
     this.numero_chip = numero_chip;
     this.nombre = nombre;
     this.edad = edad;
     this.raza = raza;
     this.adoptado = adoptado;
 }

 // Creamos un metodo que devuelve el número de chip del animal
 public String getNumero_chip() {
     return numero_chip;
 }

 // Creamos un método abstracto que debe ser implementado por las clases hijas
 // Se espera que cada subclase tenga su propia forma de "mostrar" información
 public abstract void mostrar();

}

