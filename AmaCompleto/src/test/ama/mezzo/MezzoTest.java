package test.ama.mezzo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ama.Citta;
import ama.mezzo.Brown;
import ama.mezzo.Chase;

/** 
 * Controllare che questi test abbiano successo sia
 * prima che dopo aver operato le modifiche suggerite
 * <B>(Vedi DOMANDA 2)</B>
 */
public class MezzoTest {

	private Citta citta;
	
	@Before
	public void setUp() throws Exception {
		this.citta = new Citta(1);
	}

	@Test
	public void testIdProgressiviPerBrownChase() {
		assertEquals(0, new Brown(citta).getId());
		assertEquals(1, new Brown(citta).getId());
		assertEquals(0, new Chase(citta).getId());
		assertEquals(1, new Chase(citta).getId());
	}

}
