
package cl.com.Jugadores.club.datos;

import cl.com.Jugadores.utils.IUtilidades;
import cl.com.Jugadores.utils.UtilidadesImpl;
import cl.com.jugadores.club.datos.IAccesoDatos;
import cl.com.jugadores.excepciones.*;
import cl.com.jugadores.modelo.domain.Jugador_Model;
import java.io.*;
import java.util.*;

public class JugadorDatosImpl implements IAccesoDatos{  
    
    IUtilidades utils = new UtilidadesImpl();
    
    @Override
    public boolean existe(String nombreRecurso) throws AccesoDatosEx {
        boolean result = false;
        var archivo = new File(nombreRecurso);
        result = archivo.exists();
        return result;
    }

    @Override
    public List<Jugador_Model> listar(String nombreRecurso) throws LecturaDatosEx {
        var archivo = new File(nombreRecurso);
        List<Jugador_Model> jugadores = new ArrayList<>();
        try {
            BufferedReader lectura = new BufferedReader(new FileReader(archivo));
            String linea = null;
            linea = lectura.readLine();
            String nombre = "";
            int stars = 0;
            String pais = "";
            int edad = 0;
            double valor = 0.0;
            while(linea != null){
                while(!linea.contains("-------")){
                    if(linea.contains("nombre")){
                        nombre = linea.substring(8);  
                    }
                    if(linea.contains("estrellas")){
                        stars = Integer.parseInt(linea.substring(12));  
                    }
                    if(linea.contains("edad")){
                        edad = Integer.parseInt(linea.substring(7));  
                    }
                    if(linea.contains("Pais")){
                        pais = linea.substring(7);  
                    }
                    if(linea.contains("valor")){
                        valor = Double.parseDouble( linea.substring(7));  
                    }
                    linea = lectura.readLine();
                }
                    var jugador = new Jugador_Model(nombre, stars, pais, edad, valor); 
                    
                   jugadores.add(jugador); 
                                    
                linea = lectura.readLine();
            }
            lectura.close();
            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("Error en lectura de archivo");
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("Error en lectura de archivo");
        }
        
        jugadores = this.utils.ordenarByStars(jugadores);
        
        return jugadores;
    }

    @Override
    public void inscribir(Jugador_Model jugador, String nombreRecurso, boolean anexar) throws EscrituraDatosEx {
        var archivo = new File(nombreRecurso);
        Map jugadoresMap = new HashMap();
        
        jugadoresMap.put("nombre", jugador.getNombre());
        jugadoresMap.put("estrellas", jugador.getEstrellas());
        jugadoresMap.put("Pais", jugador.getNacionalidad());
        jugadoresMap.put("edad", jugador.getEdad());
        jugadoresMap.put("valor", jugador.getValor());
       
        try {
            var inscripcion = new PrintWriter(new FileWriter(archivo,anexar));
            jugadoresMap.keySet().forEach(elemento->{
                inscripcion.println(elemento +" : "+jugadoresMap.get(elemento));
            });
            inscripcion.println("--------------------------------------------");
            inscripcion.close();
            System.out.println("Inscripcion ok");
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new EscrituraDatosEx("Error en escritura de archivo");
        }
    }

    @Override
    public String buscar(String nombreRecurso, String Buscar) throws LecturaDatosEx {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void crear(String nombreRecurso) throws AccesoDatosEx {
        var archivo = new File(nombreRecurso);
        try {
            var salida = new PrintWriter(archivo);
            salida.close();
            System.out.println("Se ha creado archivo");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new AccesoDatosEx("Error al crear Archivo");
        }
    }

    @Override
    public void borrar(String nombreRecurso) throws AccesoDatosEx {
        var archivo = new File(nombreRecurso);
        if(archivo.exists())
            archivo.delete();
        System.out.println("Se ha borrado el archivo");
    }
    
}
