package huntWumpus;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args ) throws InterruptedException
    {
        System.out.println( "Juego Hunt the Wumpus." );
        System.out.print("Introduzca su nombre: ");
        Scanner input = new Scanner(System.in);
        String nombreJugador = input.next();
        System.out.print( "Bienvenido "+ nombreJugador + ". Pulse J para jugar o S para salir: ");
        boolean salir = false;
        do{
        	 String tecla = input.next();
        	if (tecla.toUpperCase().equals("J")){
        		Juego_Wumpus.getInstance();
         	}else if (tecla.toUpperCase().equals("S")){
        		salir = true;
        		System.out.println( "Vuelva pronto " + nombreJugador + ". ");

        	}else
        		System.out.print( "\nPulse J para jugar o Q para salir: ");
        	  
        }while (!salir);
        input.close();
    }
}
