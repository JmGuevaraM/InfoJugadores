
package cl.com.Jugadores.servicio;

public interface ICatalogoJugadores {
    String NOMBRE_RECURSO = "Catalogo_Jugadores.txt";
    void inscribirJugadores(String nombre, int estrellas, String nacionalidad, int edad, double valor);
    void listarJugadores();
    void buscarJugadores(String buscar);
    void iniciarCatalogoJugadores();  
}
