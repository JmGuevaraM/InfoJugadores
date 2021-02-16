package cl.com.Jugadores.presentacion;

import cl.com.Jugadores.servicio.*;
import java.util.Scanner;

public class CatalogoFrontal {
    public static void main(String[] args) {
        
        int opc = -1;
        Scanner scanner = new Scanner(System.in);
        ICatalogoJugadores catalogo = new CatalogoJugadoresImpli();
        
        while(opc != 0){
            System.out.println("    *Elige una opcion*  \n"
                    +"1. Iniciar catalogo de Jugadores\n"
                    +"2. Inscribir Jugador\n"
                    +"3. Ver lista de Jugadores\n"
//                    +"4. Buscar pelicula\n"
                    +"0. Salir"
            ); 
            opc = Integer.parseInt(scanner.nextLine());
            
            switch (opc){
                case 1: catalogo.iniciarCatalogoJugadores();break;
                case 2: 
                    System.out.print("Nombre del Jugador: ");
                    var nombre = scanner.nextLine();
                    System.out.print("Estrellas del Jugador: ");
                    int estrellas = Integer.parseInt(scanner.nextLine());
                    System.out.print("Pais del Jugador: ");
                    var pais = scanner.nextLine();
                    System.out.print("Edad del Jugador: ");
                    int edad = Integer.parseInt(scanner.nextLine());
                    System.out.print("Valor del Jugador: ");
                    double valor = Double.parseDouble(scanner.nextLine());
                    catalogo.inscribirJugadores(nombre, estrellas, pais, edad, valor);break;
                case 3: catalogo.listarJugadores();break;
                
                case 0: System.out.println("Hasta Pronto!");break;
                default: System.out.println("Opcion no valida"); break;
            }
        }
        
    }
}
