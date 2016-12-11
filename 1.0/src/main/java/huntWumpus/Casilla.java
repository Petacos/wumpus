package huntWumpus;

 
public   class Casilla {
	//percepciones restringidas a la casilla
	private static boolean hedor = false, brisa = false, brillo = false;
 	private  boolean ocupada = false;

	/**
	 * 
	 * @param
	 */
	void setHedor() {
            hedor = true ;
 	}

	public boolean getHedor() {
		return hedor;
	}
	void setBrisa() {
        brisa = true ;
	}

	public boolean getBrisa() {
		return brisa;
	}
 
	
	public void setBrillo(boolean bri) {
        brillo = bri ;
	}

	public boolean getBrillo() {
		return brillo;
	}
	public void setOcupada(boolean ocup) {
		this.ocupada = ocup;  
	}
	public boolean getOcupada() {
		return ocupada;  
	}	 
    
    
  	public String getTipoObjetoEnCasilla() {
  		String casilla = "";
  		Pozo pozo = new Pozo();
   		if (this.getClass() == Wumpus.getInstance().getClass())
 			 casilla = Wumpus.getInstance().getTipo();
   		if (this.getClass().isInstance(pozo))
   			casilla = Pozo.getTipo();
   		if (this.getClass() == Salida.getInstance().getClass())
			 casilla = Salida.getInstance().getTipo();
   		if (this.getClass() == Oro.getInstance().getClass())
			 casilla = Oro.getInstance().getTipo();
		return casilla;
    }
	 

}