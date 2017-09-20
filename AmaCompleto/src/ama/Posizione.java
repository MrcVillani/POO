package ama;


/**
 * Rappresenta una posizione, modellata come coppia di interi 
 * ascissa (x) ed ordinata (y), all'interno della {@link Citta}.
 * <B>(DA COMPLETARE VEDI DOMANDA 1)</B>
 */
public class Posizione {

	private int x;

	private int y;

	public Posizione(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}


	public Posizione traslazioneUnitaria(int dx, int dy) {
		return new Posizione(getX()+proiettaUnitariamente(dx), getY()+proiettaUnitariamente(dy));
	}


	public Posizione traslazioneUnitariaVerso(Posizione target) {
		final int dx = target.getX()-this.getX();
		final int dy = target.getY()-this.getY();

		return traslazioneUnitaria(dx, dy);
	}

	private int proiettaUnitariamente(int delta) {
		return delta!=0 ? delta / Math.abs(delta) : 0;
	}


	@Override
	public String toString() {
		return "("+getX()+","+getY()+")";
	}
	
	@Override
	public boolean equals(Object o){
		Posizione that = (Posizione) o;
		return this.getX() == that.getX() && this.getY() == that.getY();
	}

	@Override
	public int hashCode(){
		return this.getX() + this.getY();
	}
}
