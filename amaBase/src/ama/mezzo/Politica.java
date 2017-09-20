package ama.mezzo;

import java.awt.Image;
import java.util.Random;

import ama.Citta;
import ama.Posizione;

public abstract class Politica {

	private int id;

	final private Random rnd;
	
	private Citta citta;
	
	public Politica(Citta citta, int id) {
		this.id = id;
		this.citta = citta;
		this.rnd = new Random();
	}
	
	public Politica(int id) {
		this.id = id;
		this.citta = null;
		this.rnd = new Random();
	}
	
	public abstract Image getImmagine();

	public abstract Posizione decidiDirezione(Posizione corrente);

	/**
	 * 
	 * @return un numero intero casuale tra -1,0,+1
	 */
	public int deltaCasuale() {
		return this.rnd.nextInt(3)-1;
	}

	
	public int getId() {
		return this.id;
	}
	
	public Citta getCitta() {
		return this.citta;
	}
	
	@Override
	public String toString() {
		return getClass().getSimpleName()+getId();
	}
}
