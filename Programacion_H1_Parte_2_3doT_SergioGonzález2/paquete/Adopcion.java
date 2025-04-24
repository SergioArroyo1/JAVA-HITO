package paquete;

//Clase que representa una adopción de un animal
public class Adopcion {
    private Animal animal;
    private String nombreAdoptante;
    private String dniAdoptante;
    
 // Constructor que inicializa los atributos con los datos pasados como parámetro
    public Adopcion(Animal animal, String nombreAdoptante, String dniAdoptante) {
        this.animal = animal;
        this.nombreAdoptante = nombreAdoptante;
        this.dniAdoptante = dniAdoptante;
    }
 // Devuelve el animal adoptado
    public Animal getAnimal() {
        return animal;
    }
    // Devuelve el nombre del adoptante
    public String getNombreAdoptante() {
        return nombreAdoptante;
    }
 // Devuelve el DNI del adoptante
    public String getDniAdoptante() {
        return dniAdoptante;
    }
}

