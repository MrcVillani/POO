package ant.formica;


import java.awt.Image;
import java.util.Set;

import ant.Ambiente;
import ant.Cibo;
import ant.Coordinate;
import ant.Direzione;
import ant.Formicaio;

public abstract class Formica {

	final private int id;
	
	public Ambiente ambiente;

	public Formicaio formicaio;
	
	private Coordinate posizione; // posizione corrente

	private Direzione direzione;  // direzione corrente

	private Cibo carico;
	
	public Formica(Ambiente ambiente, int id) {
		this.id = id;
		this.ambiente = ambiente;
		this.formicaio = ambiente.getFormicaio();
		/* n.b. si parte dal formicaio */
		this.posizione = this.formicaio.getPosizione();
		this.direzione = Direzione.casuale();
		this.carico = null;
	}
	
	public abstract void simula(int passo);

	public abstract Image getImmagine();
	
	public void eseguiSpostamento() {
		this.setPosizione(this.getPosizione().trasla(this.getDirezione()));
	}

	public void raccogli(final Cibo cibo) {
		this.setCarico(this.ambiente.remove(cibo));
		cibo.setRaccoglitrice(this);
	}

	public Direzione decidiDirezione(Set<Direzione> possibili) {
		Direzione risultato = this.getDirezione();
		
		/* controlla se non sia il momento di cambiare direzione */
		if (decideDiCambiareDirezione() || deveCambiareDirezione(possibili))
			risultato = cambioDirezione(possibili);
		
		return risultato;
	}

	public boolean ciboCaricato() {
		return ( this.getCarico() != null );
	}

	public Cibo scaricaCibo() {
		final Cibo daScaricare = this.carico;
		this.carico = null;
		return daScaricare;
	}
	
	public boolean nelFormicaio() {
		return getPosizione().equals(this.getFormicaio().getPosizione());
	}
		
	public Set<Direzione> getDirezioniAttualmentePossibili() {
		return this.getAmbiente().getPossibiliDirezioni(this.getPosizione());
	}

	public boolean deveCambiareDirezione(final Set<Direzione> direzioniPossibili) {
		return !direzioniPossibili.contains(this.getDirezione());
	}
	
	public abstract boolean decideDiCambiareDirezione();

	public abstract Direzione cambioDirezione(Set<Direzione> possibili);
	
	public int getId() {
		return this.id;
	}

	public Ambiente getAmbiente() {
		return this.ambiente;
	}
	
	private Formicaio getFormicaio() {
		return this.formicaio;
	}

	public Cibo getCarico() {
		return this.carico;
	}
	
	public void setCarico(Cibo cibo) {
		this.carico = cibo;
	}

	public Coordinate getPosizione() {
		return this.posizione;
	}

	protected void setPosizione(Coordinate nuova) {
		this.posizione = nuova;
	}

	public Direzione getDirezione() {
		return this.direzione;
	}
	
	protected void setDirezione(Direzione nuova) {
		this.direzione = nuova;
	}	
	
	@Override
	public String toString() {
		return getClass().getSimpleName()+getId();
	}
}
