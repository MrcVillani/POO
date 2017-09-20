package ama.mezzo;

import static ama.costanti.CostantiGUI.IMMAGINE_CAMION_VERDE;

import java.awt.Image;
import java.util.Random;

import ama.Citta;
import ama.Posizione;

public class Chase extends Politica{

	static private int progIdChase=0;
	
	final private Random rnd;
	
	public Chase(Citta citta) {
		super(citta,progIdChase++);
		this.rnd = new Random();
	}
	
	@Override
	public Posizione decidiDirezione(Posizione corrente) {
		final Posizione posizioneRifiutoNelleVicinanze = 
				this.getCitta().getRifiutoVicinoA(corrente);
		if (posizioneRifiutoNelleVicinanze==null) 
			return corrente.traslazioneUnitaria(deltaCasuale(),deltaCasuale());
		else return posizioneRifiutoNelleVicinanze;
	}
	
	/**
	 * 
	 * @return un numero intero casuale tra -1,0,+1
	 */
	private int deltaCasuale() {
		return this.rnd.nextInt(3)-1;
	}

	@Override
	public Image getImmagine() {
		return IMMAGINE_CAMION_VERDE;
	}


}
