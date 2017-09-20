package test.ama.simulatore;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import ama.Citta;
import ama.Posizione;
import ama.mezzo.Brown;
import ama.mezzo.Mezzo;
import ama.mezzo.Pendo;
import ama.rifiuto.Carta;
import ama.rifiuto.Rifiuto;
import ama.rifiuto.Vetro;
import ama.simulatore.Simulatore;
import ama.simulatore.Statistiche;

public class StatisticheTest {

	private Simulatore simulatore;

	private Statistiche stats;	

	final static private Posizione ORIGINE = new Posizione(0, 0);

	@Before
	public void setUp() throws Exception {
		this.stats = new Statistiche();
		this.simulatore = new Simulatore();
	}

	/* N.B. E' POSSIBILE USARE I  METODI CHE SEGUONO (E CREARNE DI SIMILARI) 
	 * PER VELOCIZZARE IL TESTING RELATIVO ALLE DOMANDE 3 E SUCCESSIVE */
	private Vetro creaVetroRaccoltoDaBrowniano() {
		final Vetro rifiuto = new Vetro(ORIGINE);
		rifiuto.setRaccoltoDa(this.simulatore.creaBrowniano());	
		return rifiuto;
	}


	private Vetro creaVetroRaccoltoDaChaser() {
		final Vetro rifiuto = new Vetro(ORIGINE);
		rifiuto.setRaccoltoDa(this.simulatore.creaChaser());	
		return rifiuto;
	}

	/* N.B. E' POSSIBILE USARE I METODI SOPRA (E CREARNE DI SIMILARI) 
	 * PER VELOCIZZARE IL TESTING RELATIVO ALLE DOMANDE 3 E SUCCESSIVE */

	@Test
	public void testRaccoltoPerMezzo() {
		Rifiuto rDaBrown1 = creaVetroRaccoltoDaBrowniano();
		Mezzo brown = rDaBrown1.getRaccoglitore();
		Rifiuto rDaChaser1 = creaVetroRaccoltoDaChaser();
		Set<Rifiuto> smaltiti = new HashSet<>();
		smaltiti.add(rDaChaser1);
		smaltiti.add(rDaBrown1);
		assertEquals(2, this.stats.raccoltoPerMezzo(smaltiti).size());
		assertEquals(1, this.stats.raccoltoPerMezzo(smaltiti).get(brown).intValue());
		

	}


	@Test
	public void testOrdinaMezziPerRaccolta_listaVuota() {
		
		Map<Class<?>, Integer> mappaVuota = new HashMap<>();
		assertTrue(this.stats.ordinaPolitichePerRaccolta(mappaVuota).isEmpty());
	}
	
	@Test
	public void testOrdinaMezziPerRaccolta_Singleton() {
		Map<Class<?>, Integer> singletonMap = new HashMap<>();
		singletonMap.put(Pendo.class, 1);
		assertTrue(this.stats.ordinaPolitichePerRaccolta(singletonMap).contains(Pendo.class));
	}
	
	@Test
	public void testOrdinaMezziPerRaccolta_Doubleton() {
		Map<Class<?>, Integer> doubletonMap = new HashMap<>();
		doubletonMap.put(Pendo.class, 1);
		doubletonMap.put(Brown.class, 2);
		assertEquals(2, this.stats.ordinaPolitichePerRaccolta(doubletonMap).size());
		assertEquals(Pendo.class, this.stats.ordinaPolitichePerRaccolta(doubletonMap).get(0));
	}
	
	@Test
	public void testOrdinaMezziPerRaccolta() {
	
		
		
		
	}

	/*                              */
	/* DA COMPLETARE VEDI DOMANDA 6 */
	/*                              */

}
