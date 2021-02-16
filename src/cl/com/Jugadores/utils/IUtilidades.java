package cl.com.Jugadores.utils;

import cl.com.jugadores.modelo.domain.Jugador_Model;
import java.util.List;

public interface IUtilidades {
    
    List<Jugador_Model> ordenarByStars(List<Jugador_Model> jugadores);
}
