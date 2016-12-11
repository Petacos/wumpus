package huntWumpus;

import java.util.NoSuchElementException;
import java.util.Scanner;
 
public class Juego_Wumpus {
 
    Scanner input = new Scanner(System.in);
    private static Juego_Wumpus instance;
    private static int lado,flechas,pozos;
 	final static Jugador cazador = Jugador.getInstance();

	private Juego_Wumpus()  {
		boolean finAventura = false;
		introDatosTeclado();
	    Tablero.getInstance(lado, flechas, pozos);
		System.out.println("Tablero Ok.\n");
		System.out.println("Comienza la aventura. El Sol calienta agradablemente, el viento está en calma.");
		System.out.println("Dispone de " + flechas + " flechas en el carcaj. Se encuentra rumbo al Norte.");
		System.out.println("Puede lanzar una flecha pulsando F.");

		do{
			System.out.print("\nPulse A para avanzar. I para girar a la izquierda, D para girar a la derecha: ");
			Scanner inputAccion = new Scanner(System.in);
		    String comando = inputAccion.next();
 
		    finAventura = realizarAccion(comando.toUpperCase());
 			if(finAventura)
 				inputAccion.close();
		}while(!finAventura);
 
     }
 
	private boolean realizarAccion(String comando)  {
		boolean exit = false;
		switch(comando){
			case "A":
				if(cazador.avanzar()){
					String percepcion = cazador.consultarPercepciones().toString();
	 				if(percepcion.equals("Nada")){
						System.out.println("Es un bonito paraje pero no tiene nada de particular. Continúa hacia el "
								+ cazador.getDireccion() + ".");
					}else if(percepcion.contains("Salida")){
						if (cazador.getEncontradoOro()){
					    	System.out.println(" Encontró el tesoro y la salida. Demasiado fácil. ¿Se atreverá con un tablero más grande? ");
					    	exit = true;
 						}else{
 					       	 System.out.println("Encontró la salida pero todavía no tiene el oro. Continúa la aventura... ");

 						}
					}
	 				if(percepcion.contains("Oro")){
						System.out.println("¡Encontrado el tesoro! Podrá disfrutarlo ¡Si llega vivo a la salida!");
						Oro.getInstance().setBrillo(false);	  
						cazador.setEncontradoOro();
   					}
	 				if(percepcion.contains("Hedor")){
   				    	System.out.println("Se percibe el hedor del Wumpus. Apunte a una dirección y dispare una flecha.");
    				}
					if(percepcion.contains("Pozo")){
				    	System.out.println("Se percibe la brisa de un pozo.");	  
					}
					
					if(percepcion.contains("Wumpus")){
						System.out.println("Un tentáculo le atrapa por la pierna. Trata de liberarse pero rápidamente comprende que todo ha acabado.");
				    	System.out.println("Alimentará al Wumpus y a su leyenda, con la historia del cazador cazado.");
				    }
 				}else{//si no avanza
			    	System.out.println("¡Ouh! Se golpeó fuerte contra el muro, pero avanzó poco.");
  				}
 				break;
			case "I":
				cazador.girarIzq();
				System.out.println("Se encuentra rumbo al " + cazador.getDireccion() + ".");
 				break;
			case "D":
				cazador.girarDer();
				System.out.println("Se encuentra rumbo al " + cazador.getDireccion() + ".");
  				break;
			case "F":
				if (flechas>0){
					flechas--;
					cazador.lanzarFlecha();
					
					if (Tablero.getInstanciaTablero().detectarGrito()){
	 						System.out.println("¡GRRRRAAAOOOOUUUUUU! El Wumpus cae al suelo. Ha muerto. Se acerca a él y le arranca un colmillo como trofeo");
					    	System.out.println("En cuanto recupere el aliento continúe el camino, todavía aguardan peligros.");			
	 				}
				}else
					System.out.println("Ya no quedan más flechas.");

				break;
			default:
				break;
		}
		return exit;
	}
		
		
	
	


	
	private void introDatosTeclado()  {
		System.out.print( "Introducir lado del tablero (mínimo 4): " );
 		try{
		    lado = input.nextInt();
		    if (lado<4) lado = 4;
		}catch( NoSuchElementException e){
			lado = 4;
		}
 		System.out.print( "Introducir cantidad de flechas (mínimo 1): " );
 		try{
		    flechas = input.nextInt();
		    if (flechas<1) flechas = 1;
		}catch( NoSuchElementException ex){
			flechas = 1;
		}
 		System.out.print( "Introducir cantidad de pozos (1 - " + lado + "): " );
 		try{
		    pozos = input.nextInt();
		    if (pozos<1) pozos = 1; else if (pozos>lado) pozos = lado ;
		}catch( NoSuchElementException exc){
			pozos = 1;
		}
 		System.out.print( "\nCreando tablero de " + lado + "x" + lado + ".");
 		
	}

    public static Juego_Wumpus getInstance() throws InterruptedException{
        if (instance == null)
            instance = new Juego_Wumpus();
        return instance;
    }
    public int getFlechas(){
    	return flechas;
    }

 } 
        