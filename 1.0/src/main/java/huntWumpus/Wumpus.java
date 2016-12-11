package huntWumpus;

public final class Wumpus extends Casilla {
    private static Wumpus instance;
    private String tipo;
    private static boolean vida;

	private  Wumpus() {
        super();
		tipo = "Wumpus";
		vida = true;
	}
	  public static Wumpus getInstance(){
          if (instance == null)
              instance = new Wumpus();
          return instance;
      }
	  public String getTipo() {
			return tipo;
		}
		public void setTipo(String tipo) {
			this.tipo = tipo;
		}
		public static boolean getVida() {
			return vida;
		}
		public void setVida(boolean vi) {
			vida = vi;
		}
}