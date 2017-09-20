package ama.simulatore;

import java.util.Comparator;
import java.util.Map;

import ama.mezzo.Mezzo;

public class ComparatoreMezziPerRaccolta implements Comparator<Mezzo> {

	private Map<Mezzo, Integer> m2q;

	public ComparatoreMezziPerRaccolta(final Map<Mezzo, Integer> mezzo2quantita) {
		this.m2q = mezzo2quantita;
	}
	
	@Override
	public int compare(Mezzo m1, Mezzo m2) {
		int cmp = this.m2q.get(m1)-this.m2q.get(m2);
		if(cmp==0) {
			cmp = m1.getPolitica().getId()-m2.getPolitica().getId();
		}
		if(cmp==0) {
			cmp = m1.getPolitica().getClass().getName().compareTo(m2.getPolitica().getClass().getName());
		}
		
		return cmp;
	}

}
