package huntWumpus;

public class Oro extends Casilla {
    private String tipo;
    private static Oro instance;

	private Oro() {
		super();	
		setTipo("Oro");	
	 }
	public static Oro getInstance(){
        if (instance == null)
            instance = new Oro();
        return instance;
    }
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}