package huntWumpus;
import static org.junit.Assert.*;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestPercibir
{
     

    @Test
	public void caso1ClaseJugador()   {
    	//Prueba de metodo percibirHedor()
     	Casilla tablero [][] = new Casilla[4][4];

		final Tablero tab = Tablero.getInstance(4,4,4);
		 for (int y=0;y<4;y++)
		        for (int x=0;x<4;x++)
		      	  tablero[y][x] = new Vacia();
		        
		 for (int z=0;z<4;z++)
		        for (int w=0;w<4;w++)
		      	  tablero[z][w].setHedor();
		       

      	boolean resul = tab.detectarCasilla("Hedor");
 		assertTrue("Error probando detectarCasilla('Hedor'):",resul);
	}

	 
}
