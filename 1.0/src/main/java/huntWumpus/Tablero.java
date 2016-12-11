package huntWumpus;


import java.util.Random;
  
/**
 * @author Pedro
 *
 */
public class Tablero   {
 	private static  int tamanyo;
	private static int flechas;
	private static int numPozos;
 	private static Casilla tablero [][] ;
    private static Tablero instance;
	private static int [] posiciones = new int[2];
	private static  int xPosCazador, yPosCazador;

	final static Jugador cazador = Jugador.getInstance();
	final static Oro oro = Oro.getInstance();
	final static Wumpus wumpus = Wumpus.getInstance();


 	
	private  Tablero(int tam, int fl, int numP)  {
 		tamanyo = tam; setFlechas(fl); numPozos = numP;
		tablero =  new Casilla[tamanyo][tamanyo];//Dimensionar tablero
		rellenarTablero();
	}
	 
	
	private void rellenarTablero()  {   
	    tableroVacio();
		rellenarTableroConPozos();
		rellenarTableroConOro();
		rellenarTableroConWumpus();
		rellenarTableroConJugador();
   }
	
	  public final static Tablero getInstance(int tam, int fl, int numP) {
	        if (instance == null)
	            instance = new Tablero(tam, fl, numP);
	        return instance;
	    }
	  public final static Tablero getInstanciaTablero() {
 	        return instance;
	    }

	 
	private void tableroVacio()  {

	    for (int y=0;y<tamanyo;y++){
	        for (int x=0;x<tamanyo;x++){
	      	  tablero[y][x] = new Vacia();
	        }
 
	    }
	  }
		
	  private void rellenarTableroConPozos()  {
		  int xPos, yPos;
 		  Random  rnd = new Random();
 		  try{
	 		  for (int x=0;x<2*numPozos;x++){
					xPos=(rnd.nextInt(tamanyo-1));//numeros entre 0 y tamanyo-1
					Thread.sleep(100);//retardo para el aleatorio
					yPos=(rnd.nextInt(tamanyo-1));//numeros entre 0 y tamanyo-1
					Pozo pozo = new Pozo();
					tablero[yPos][xPos]=pozo;
			  		tablero[yPos][xPos].setOcupada(true);
			  		
				  	//Cargamos brisa alrededor del pozo
		      		  if(xPos!=0)
		  				  tablero[yPos][xPos-1].setBrisa();
		  			  if(xPos!=tamanyo-1)
						  	tablero[yPos][xPos+1].setBrisa();
		   			  if(yPos!=0)
		  				  tablero[yPos-1][xPos].setBrisa();
		   			  if(yPos!=tamanyo-1)
		   				  tablero[yPos+1][xPos].setBrisa();
		   			  System.out.print(".");
				}
 		 } catch (InterruptedException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}	
	  }
	  private void rellenarTableroConOro()  {
		  int xPos, yPos;
 		  Random  rnd = new Random();
 		  try{
	 		  xPos=(rnd.nextInt(tamanyo-1));//numeros entre 0 y tamanyo-1
			  Thread.sleep(100);//retardo para el aleatorio
			  yPos=(rnd.nextInt(tamanyo-1));//numeros entre 0 y tamanyo-1
			  
			  while( tablero[yPos][xPos].getOcupada()){
				  xPos=(rnd.nextInt(tamanyo-1));//numeros entre 0 y tamanyo-1
				  Thread.sleep(100);//retardo para el aleatorio
				  yPos=(rnd.nextInt(tamanyo-1));//numeros entre 0 y tamanyo-1
	   			  System.out.print(".");
	
			  }
			  
	  		  tablero[yPos][xPos] = oro;
	  		  tablero[yPos][xPos].setBrillo(true);
	   		  tablero[yPos][xPos].setOcupada(true);
 		  } catch (InterruptedException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		  }
	  }
	  private void rellenarTableroConWumpus()  {
		  int xPos, yPos;
 		  Random  rnd = new Random();
 		  try{
	 		  xPos=(rnd.nextInt(tamanyo-1));//numeros entre 0 y tamanyo-1
			  Thread.sleep(100);//retardo para el aleatorio
			  yPos=(rnd.nextInt(tamanyo-1));//numeros entre 0 y tamanyo-1
			  
			  while( tablero[yPos][xPos].getOcupada()){
				  xPos=(rnd.nextInt(tamanyo-1));//numeros entre 0 y tamanyo-1
				  Thread.sleep(100);//retardo para el aleatorio
				  yPos=(rnd.nextInt(tamanyo-1));//numeros entre 0 y tamanyo-1
	   			  System.out.print(".");
	
			  }			
			  tablero[yPos][xPos] = wumpus; 
			  
			  //Cargamos hedor alrededor del Wumpus
			  if(xPos!=0)
				  tablero[yPos][xPos-1].setHedor();
			  if(xPos!=tamanyo-1)
			  	tablero[yPos][xPos+1].setHedor();
			  if(yPos!=0)
				  tablero[yPos-1][xPos].setHedor();
			  if(yPos!=tamanyo-1)
				  tablero[yPos+1][xPos].setHedor();
 		 } catch (InterruptedException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		 }
		  
 	  }
	  
	  private void rellenarTableroConJugador()  {
  		  Random  rnd = new Random();
  		  try{
	  		  do{
		  		  xPosCazador=(rnd.nextInt(tamanyo-1));//numeros entre 0 y tamanyo-1
				  Thread.sleep(100);//retardo para el aleatorio
				  yPosCazador=(rnd.nextInt(tamanyo-1));//numeros entre 0 y tamanyo-1
	  		  }while( tablero[yPosCazador][xPosCazador].getOcupada());
	 
			  tablero[yPosCazador][xPosCazador] =  cazador; 
	  	  } catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		  }

 	  }
	  
	  public static void setPosCazador(int y, int x){
		  tablero[yPosCazador][xPosCazador] =  new Vacia();//antigua casilla
		  yPosCazador=y;xPosCazador=x;
 		  tablero[yPosCazador][xPosCazador] =  cazador; //posicion actualizada
		  
	  }
	  public static int getTamanyoTablero(){
		 return tamanyo; 
	  }
		 
	  public static int[] getPosCazador(){
 		 posiciones[0] = yPosCazador;
 		 posiciones[1] = xPosCazador;
		 return posiciones;	
 	}
	  /**
	   * @param objeto
	   *  "salida", "oro","pozo","brisa","wumpus","hedor"
	   * @return
	   */
	  public boolean detectarCasilla(String objeto){
		  String casilla = tablero[yPosCazador][xPosCazador].getTipoObjetoEnCasilla();
		  boolean exito = false;
		  switch (objeto.toLowerCase()){
		  	case "salida":
		  		exito = casilla.equals("Salida");
		  		break;
 		  	case  "oro":
		  		exito = tablero[yPosCazador][xPosCazador].getBrillo();
		  		break;
 		  	case  "pozo":
 				exito = casilla.equals("Pozo");
 				break;
 		  	case  "brisa":
 				exito = tablero[yPosCazador][xPosCazador].getBrisa();
 				break;
 			case  "wumpus":
 				exito=casilla.equals("Wumpus");
 				break;
 			case  "hedor":
 					exito=tablero[yPosCazador][xPosCazador].getHedor();
 				break;
 			default:
 				break;
		  }
		return exito;
	  }
  	 
 
	public boolean detectarGrito() {
		return !Wumpus.getVida(); 
		
	}
	 
 
	public static int getFlechas() {
		return flechas;
	}


	public static void setFlechas(int flechas) {
		Tablero.flechas = flechas;
	}
}