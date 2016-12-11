package huntWumpus;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

 
@RunWith(Suite.class)
@Suite.SuiteClasses({   
	TestGetTipo.class,TestPercibir.class, 
})

public class TestWumpusSuite  {   
	@BeforeClass
	public static void setUp() {
		 
	}

	@AfterClass
	public static void tearDown() {
 	}
	
}
