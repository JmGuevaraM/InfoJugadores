package cl.com.jugadores.club.datos;

import cl.com.jugadores.excepciones.*;
import cl.com.jugadores.modelo.domain.Jugador_Model;
import java.util.*;

public interface IAccesoDatos {
    
    boolean existe(String nombreRecurso) throws AccesoDatosEx;
    
    List<Jugador_Model> listar(String nombreRecurso) throws LecturaDatosEx;
    
    void inscribir(Jugador_Model jugador, String nombreRecurso, boolean anexar) throws EscrituraDatosEx;
    
    String buscar(String nombreRecurso, String Buscar) throws LecturaDatosEx;
    
    void crear(String nombreRecurso) throws AccesoDatosEx;
    
    void borrar(String nombreRecurso) throws AccesoDatosEx;
    
}
