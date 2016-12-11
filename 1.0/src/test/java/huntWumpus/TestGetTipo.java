package huntWumpus;
 
import static org.junit.Assert.*;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestGetTipo
{
     

    @Test
	public void caso1ClaseOro ()   {
    	//Prueba de metodo getTipo()

		Oro oro = Oro.getInstance();
 		String  resultadoEsperado = "Oro";
     	String resul =	oro.getTipo() ;
		assertEquals("Error probando oro:",resultadoEsperado,resul);
	}

	 
   
    @Test
  	public void caso2ClaseCasilla()   {
    	//Prueba de metodo getTipoObjetoEnCasilla()

  		Casilla casilla = Wumpus.getInstance();
   		String  resultadoEsperado = "Wumpus";
       	String resul =	casilla.getTipoObjetoEnCasilla() ;
  		assertEquals("Error probando Wumpus:",resultadoEsperado,resul);
  	}
    @Test
    public void caso3ClaseCasilla()   {
    	//Prueba de metodo getTipoObjetoEnCasilla()

  		Casilla casilla = new Pozo();
   		String  resultadoEsperado = "Pozo";
       	String resul =	casilla.getTipoObjetoEnCasilla() ;
  		assertEquals("Error probando Pozo:",resultadoEsperado,resul);
  	}
}
