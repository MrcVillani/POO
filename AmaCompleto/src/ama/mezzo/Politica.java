package ama.mezzo;

import java.awt.Image;
import java.util.Random;

import ama.Citta;
import ama.Posizione;

public abstract class Politica {

	private int id;

	private Citta citta;
	
	public Politica(Citta citta, int id){
		this.id = id;
		this.citta = citta;
	}
	
	public int getId() {
		return this.id;
	}

	public Citta getCitta() {
		return this.citta;
	}
	
	public abstract Posizione decidiDirezione(Posizione corrente);

	public abstract Image getImmagine();
	

	@Override
	public String toString() {
		return getClass().getSimpleName()+getId();
	}
}
