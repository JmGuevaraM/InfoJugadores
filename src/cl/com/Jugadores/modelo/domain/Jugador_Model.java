package cl.com.jugadores.modelo.domain;

public class Jugador_Model {
    private String nombre;
    private int estrellas;
    private String nacionalidad;
    private int edad;
    private double valor;

    public Jugador_Model() {
    }

    public Jugador_Model(String nombre) {
        this.nombre = nombre;
    }

    public Jugador_Model(String nombre, int estrellas, String nacionalidad, int edad, double valor) {
        this.nombre = nombre;
        this.estrellas = estrellas;
        this.nacionalidad = nacionalidad;
        this.edad = edad;
        this.valor = valor;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEstrellas() {
        return estrellas;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public int getEdad() {
        return edad;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "Jugador :{" + "nombre = " + nombre + ", estrellas = " + estrellas + ", nacionalidad = " + nacionalidad + ", edad = " + edad + ", valor = " + valor + '}';
    }

    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEstrellas(int estrellas) {
        this.estrellas = estrellas;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    
    
}
