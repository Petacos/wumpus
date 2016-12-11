package huntWumpus;

public class Salida extends Casilla {
    private static Salida instance;
    private String tipo;
	
    private Salida() {
		super();
		setTipo("Salida");	
	}
	public static Salida getInstance(){
        if (instance == null)
            instance = new Salida();
        return instance;
    }
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}