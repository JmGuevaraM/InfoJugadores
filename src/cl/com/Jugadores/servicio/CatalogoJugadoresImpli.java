
package cl.com.Jugadores.servicio;

import cl.com.Jugadores.club.datos.JugadorDatosImpl;
import cl.com.jugadores.club.datos.*;
import cl.com.jugadores.excepciones.*;
import cl.com.jugadores.modelo.domain.Jugador_Model;

public class CatalogoJugadoresImpli implements ICatalogoJugadores{
    
    private final IAccesoDatos datos;

    public CatalogoJugadoresImpli() {
        this.datos = new JugadorDatosImpl();
    }
    
    @Override
    public void inscribirJugadores(String nombre, int estrellas, String nacionalidad, int edad, double valor) {
        Jugador_Model jugador = new Jugador_Model(nombre, estrellas, nacionalidad, edad, valor);
        boolean anexar = true;
        try {
            this.datos.inscribir(jugador, NOMBRE_RECURSO, anexar);
        } catch (AccesoDatosEx ex) {
            ex.printStackTrace();
            System.out.println("Error de acceso a datos");
        }
    }

    @Override
    public void listarJugadores() {
        try {
            var jugadores = this.datos.listar(NOMBRE_RECURSO);
            jugadores.forEach(item->{
                System.out.println(item);
            });
            
        } catch (AccesoDatosEx ex) {
            System.out.println("Error de acceso de datos");
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void buscarJugadores(String buscar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void iniciarCatalogoJugadores() {
         try {
            if(this.datos.existe(NOMBRE_RECURSO)){
               this.datos.borrar(NOMBRE_RECURSO);
               this.datos.crear(NOMBRE_RECURSO);
            }else{
                this.datos.crear(NOMBRE_RECURSO);
            }
        } catch (AccesoDatosEx ex) {
            System.out.println("Error de acceso a datos");
            ex.printStackTrace(System.out);
        }
    }
    
}
