package cl.com.Jugadores.utils;

import cl.com.jugadores.modelo.domain.Jugador_Model;
import java.util.ArrayList;
import java.util.List;

public class UtilidadesImpl implements IUtilidades {

    @Override
    public List<Jugador_Model> ordenarByStars(List<Jugador_Model> jugadoresPorOdenar) {
       int nElementos = jugadoresPorOdenar.size();

        Jugador_Model aux;
        //Metodo Burbuja
        for(int i=0; i<(nElementos-1);i++){
            for(int j=0; j<(nElementos-1); j++){
                if(jugadoresPorOdenar.get(j).getEstrellas() < jugadoresPorOdenar.get(j+1).getEstrellas()){
                    aux = jugadoresPorOdenar.get(j);
                    jugadoresPorOdenar.set(j,  jugadoresPorOdenar.get(j+1));
                    jugadoresPorOdenar.set((j+1), aux);
                }
                    
            }
        }
       
       
       return jugadoresPorOdenar;
    }
    
}
