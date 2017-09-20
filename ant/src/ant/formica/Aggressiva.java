package ant.formica;

import static ant.costanti.CostantiGUI.IMMAGINE_FORMICA_ROSSA;
import static ant.costanti.CostantiSimulazione.PROBABILITA_CAMBIO_DIREZIONE;

import static ant.simulatore.GeneratoreCasuale.siVerificaEventoDiProbabilita;

import java.awt.Image;
import java.util.Set;

import ant.Ambiente;
import ant.Cibo;
import ant.Direzione;

/**
 * Modella una formica <EM>esploratrice</EM>.
 * <B>(VEDI DOMANDA 2)</B>
 */
public class Aggressiva extends Formica {
	
	static private int progId=0;
	

	public Aggressiva(Ambiente ambiente) {
		super(ambiente, progId++);
		
	}
	
	public Direzione cambioDirezione(Set<Direzione> possibili) {
		return Direzione.scegliAcasoTra(possibili);
	}
	
	public boolean decideDiCambiareDirezione() {
		return ( siVerificaEventoDiProbabilita(PROBABILITA_CAMBIO_DIREZIONE) ) ;
	}

	public void simula(int passo) {
		if (ciboCaricato()) {
			/* cibo gia' trovato? */
			if (nelFormicaio()) {
				/* rientrato, scarica cibo e ricomincia da capo */
				this.formicaio.immagazzinaCaricoDi(this);
			} else {
				/* cibo gia' caricato: redireziona per rientrare verso il formicaio */
				final Direzione versoFormicaio = new Direzione(this.getPosizione(),this.formicaio.getPosizione());
				final Set<Direzione> possibili = getDirezioniAttualmentePossibili();
				if (possibili.contains(versoFormicaio)) 
					this.setDirezione(versoFormicaio);
				else this.setDirezione(Direzione.scegliAcasoTra(possibili));
				/* segnala fonte di cibo lasciando traccia di ferormone durante il rientro */
				this.ambiente.incrementaFerormone(this.getPosizione());
				eseguiSpostamento();
			}
		} else {
			/* ancora senza cibo: continua a cercare */
			final Cibo cibo = this.ambiente.getCibo(this.getPosizione());
			if (cibo!=null) {
				/* trovato! raccogli e porta via... */
				raccogli(cibo);
			} 
			else if(this.ambiente.getDirezioneCiboVicino(this.getPosizione()) != null) {
				this.setDirezione(this.ambiente.getDirezioneCiboVicino(this.getPosizione()));
				eseguiSpostamento();
			}
			
				else { /* niente da fare: scegli una direzione */
				/* calcola l'insieme delle possibili direzioni (senza urtare gli ostacoli) */
				final Set<Direzione> possibili = getDirezioniAttualmentePossibili();
				final Direzione nuovaDirezione = decidiDirezione(possibili);
				/* ricontrolla che la scelta sia sensata: colpisco un ostacolo? */
				if (!possibili.contains(nuovaDirezione))
					throw new IllegalStateException("La direzione scelta per "+this+" non era tra quelle possibili:"
							+ " cosi' la formica sbatte contro un ostacolo!");
				this.setDirezione(nuovaDirezione);
				eseguiSpostamento();
			}
		}
	}

	

	public Image getImmagine() {
		return IMMAGINE_FORMICA_ROSSA;
	}

	

}

