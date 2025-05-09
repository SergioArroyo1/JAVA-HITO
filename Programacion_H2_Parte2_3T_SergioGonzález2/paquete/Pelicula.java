package paquete;

public class Pelicula {
    private int id;
    private String titulo;
    private String director;
    private int ano;
    private int duracion;
    private String genero;

    public Pelicula(int id, String titulo, String director, int ano, int duracion, String genero) {
        this.id = id;
        this.titulo = titulo;
        this.director = director;
        this.ano = ano;
        this.duracion = duracion;
        this.genero = genero;
    }

    public int getId() 
    { return id; }
    public String getTitulo()
    { return titulo; }
    public String getDirector() 
    { return director; }
    public int getAno()
    { return ano; }
    public int getDuracion() 
    { return duracion; }
    public String getGenero() 
    { return genero; }
}
