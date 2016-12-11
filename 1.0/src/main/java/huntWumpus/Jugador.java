package huntWumpus;

  
public class Jugador extends Casilla  {
	private int xPos, yPos;
	private String direccion;
	private String tipo ;
	private int[] coord;
    private static Jugador instance;

 	private static boolean encuentraOro = false;
 
	private Jugador(){
		super();
 		tipo = "Jugador";
 		direccion = "Norte";
	}
	
	
	//Avanzar.
	public boolean avanzar() {
		boolean exito = false;
		switch(direccion){
			//choque() actualiza coord con alcance de clase;
			case "Norte":
				if (!choque()){
					exito = true;
 					yPos=coord[0]-1;
					xPos=coord[1];		 
 	 				Tablero.setPosCazador(yPos, xPos);
				}
				break;

			case "Sur":
				if (!choque()){
					exito = true;
 					yPos=coord[0]+1;
					xPos=coord[1];
					Tablero.setPosCazador(yPos, xPos);
				} 
				break;

			case "Este":
				if (!choque()){
					exito = true;
 					yPos=coord[0];
					xPos=coord[1]+1;	
					Tablero.setPosCazador(yPos, xPos);
				}
				break;

			case "Oeste":
				if (!choque()){
					exito = true;
 					yPos=coord[0];
					xPos=coord[1]-1;
					Tablero.setPosCazador(yPos, xPos);
				}
				break;

			default:
				break;
		}
		return exito;
 	}
	
	// Girar 90º a izquierda o derecha.
	public void girarIzq() {
		switch(direccion){
			case "Norte":
				direccion="Oeste";
				break;
			case "Sur":
				direccion="Este";
 				break;
			case "Este":
				direccion="Norte";
 				break;
			case "Oeste":
				direccion="Sur";
 				break;
 			default:
				break;
		}
	}
	public void girarDer() {
		switch(direccion){
			case "Norte":
				direccion="Este";
				break;
			case "Sur":
				direccion="Oeste";
 				break;
			case "Este":
				direccion="Sur";
 				break;
			case "Oeste":
				direccion="Norte";
 				break;
 			default:
				break;
		}
	}
	public String getDireccion(){
		return direccion;
	}

	
		// Lanzar una flecha (la flecha llega hasta el Wumpus o la pared)
	public void lanzarFlecha() {
		boolean exito = false;
		System.out.print("Ha lanzado una flecha. ");
		int flechas = getFlechas()-1;
 		Tablero.setFlechas(flechas); 
		consultarPercepciones();
		if (flechas>0 && !exito){
			System.out.println("Se escucha la flecha contra el muro. Dispone de " + flechas
					+ " flechas en el carcaj. Se encuentra rumbo al " + direccion + ".");
		}else if(flechas>0 && exito){
			//actualizar vida de Wumpus
			Tablero.wumpus.setVida(false);
		}
		else{
			System.out.println("Ya no quedan más flechas. Se encuentra rumbo al " + direccion + ".");
 		}
 	}
	

 	public StringBuilder consultarPercepciones()  {
 		StringBuilder percepcion = new StringBuilder();
		if (percibirHedor()) {
	    	percepcion.append("Hedor ");	
    	}
		if (percibirPozo()) {
	    	percepcion.append("Pozo ");	
		}
		if (percibirOro()) {
	    	percepcion.append("Oro ");	
 		}
		 
		if (percibirSalida()) {
	    	percepcion.append("Salida ");	
	    	System.out.print("Se encuentra en la salida.");
 		}
		if (percibirGrito()) {
	    	percepcion.append("Grito ");	
 	    	
		}if (percibirWumpus()) {
	    	percepcion.append("Wumpus ");	

		} if (percepcion.length() == 0) {
			percepcion.append("Nada");
		}
		return percepcion;
	}
	
	public int getFlechas()  {
		return Tablero.getFlechas();
	}
	private boolean percibirHedor()  {
		final Tablero tab = Tablero.getInstanciaTablero();
		return tab.detectarCasilla("hedor");
	}
	private boolean percibirPozo()  {
		final Tablero tab = Tablero.getInstanciaTablero();
		return tab.detectarCasilla("pozo");

	}
	private boolean percibirSalida()  {
	 	final Tablero tab = Tablero.getInstanciaTablero();
		return tab.detectarCasilla("salida");

	}
	private boolean percibirOro()  {
	 	final Tablero tab = Tablero.getInstanciaTablero();
		return tab.detectarCasilla("oro");

	}
	private boolean percibirGrito()  {
		final Tablero tab = Tablero.getInstanciaTablero();
   		return tab.detectarGrito();	
	}
	private boolean percibirWumpus()  {
		final Tablero tab = Tablero.getInstanciaTablero();
		return tab.detectarCasilla("Wumpus");
 
	}
	 

	
	private boolean choque(){
		boolean muro = false;
		int tamanyo = Tablero.getTamanyoTablero();
		
		switch(direccion){
			case "Norte":
				coord=Tablero.getPosCazador();
 				 
				if (coord[0] == 0)//coordenada Y
					muro=true;
				else
					muro=false;
  				break;
			case "Sur":
				coord=Tablero.getPosCazador();
				if (coord[0] == tamanyo-1)
					muro=true;
				else
					muro=false;
				break;
			case "Oeste":
				coord=Tablero.getPosCazador();//coordenada X
				if (coord[1] == 0)
					muro=true;
				else
					muro=false;
				break;
 			case "Este":
				coord=Tablero.getPosCazador();
				if (coord[1] == tamanyo-1)
					muro=true;
				else
					muro=false;
				break;
 			default:
 				break;	 
		}
		return muro;
	}
 		public String getTipo() {
	    	return tipo;
	    }
	  public final static Jugador getInstance(){
	        if (instance == null)
	            instance = new Jugador();
	        return instance;
	    }
	  public  void setEncontradoOro(){
		 encuentraOro = true;
	  }
	  public  boolean getEncontradoOro(){
			return encuentraOro;
	  }
}