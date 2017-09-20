package ama.mezzo;

import java.awt.Image;
import java.util.Random;
import static ama.costanti.CostantiGUI.IMMAGINE_CAMION_ROSSO;

import java.awt.Image;
import java.util.Random;

import ama.Citta;
import ama.Posizione;


import ama.Citta;
import ama.Posizione;

public class Pendo extends Politica{

	static private int progIdPendo=0;
	private int verso;

	public Pendo(Citta citta) {
		super(citta, progIdPendo++);
		this.verso = +1;
	}

	@Override
	public Posizione decidiDirezione(Posizione corrente) {
		Posizione nuova = corrente.traslazioneUnitaria(verso,0);
		if(getCitta().sulBordo(nuova)){
			this.verso = -this.verso;
			return corrente.traslazioneUnitaria(verso,0);
		}
		else
		    return nuova;
	}

	@Override
	public Image getImmagine() {
		return IMMAGINE_CAMION_ROSSO;
	}


}
