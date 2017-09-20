package ama.mezzo;

import static ama.costanti.CostantiGUI.IMMAGINE_CAMION_ROSSO;

import java.awt.Image;

import ama.Citta;
import ama.Posizione;

public class Pendo extends Politica {

	static private int progId=0;
	private int verso;

	public Pendo(Citta citta) {
		super(citta, progId++);
		this.verso = +1;
	}
	
	public Posizione decidiDirezione(Posizione corrente) {
	 Posizione posizione = corrente.traslazioneUnitaria(this.verso,0);
		if (this.getCitta().sulBordo(posizione)) {
			this.verso = -this.verso;
			return corrente.traslazioneUnitaria(this.verso,0);
		}
			else return posizione;
	}
	


	public Image getImmagine() {
		return IMMAGINE_CAMION_ROSSO;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName()+getId();
	}

}
