package ama.simulatore;

import java.util.Comparator;
import java.util.Map;

public class ComparatorePolitichePerRaccolta implements Comparator<Class> {

	private Map<Class<?>, Integer> p2q;

	public ComparatorePolitichePerRaccolta(final Map<Class<?>, Integer> politica2quantita) {
		this.p2q = politica2quantita;
		
	}

	@Override
	public int compare(Class p1, Class p2) {
		return p2q.get(p1)-p2q.get(p2);
	}

}
