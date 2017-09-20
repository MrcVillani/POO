package es;

//public class metodies {



//1 mappa che associa per ogni tipoligia di rifiuto quante volte è presente

/*
 * public Map<Rifiuto,Integer>(){
 * Map<Rifiuto,Integer> mappa=new HashMap<Rifiuto,Integer>();
 * for(Rifiuto r: getRifiuti()){
 * if(!mappa.containsKey(r.getTipologia()))
 * mappa.put(r.getTipologia(),0);
 * mappa.put(r.getTipologia(),mappa.get(r.getTipologia())+1);
 * }
 * return mappa;
 * }
 */




/* METODO 3:
/*mappa che associa per la chiave mezzo quanti rifiuti sono associati
 * stesso metodo camion Set<Rifiuti>;// associo ai rifiuti un camion tramite il metodo
 * getRaccoglitore; 
 * 
 * public Map<Mezzo,List<Rifiuto> mappa1(){
 * Map<Mezzo,List<Rifiuto>=new HashMap<Mezzo,List<Rifiuto>>();
 * List<Rifiuto> lista;
 * for(Rifiuto r: this.smaltiti()){ // associ solo quelli che sono nella discarica
 * lista=mappa.get(r.getRaccoglitore());
 * if(lista==null)
 * lista=new ArrayList<Rifiuto>();
 * lista.add(r);
 * mappa.put(r.getRaccoglitore(),lista);
 * }
 * return mappa;
 * }
 */




// METODO 4;
/*mappa che ha come chiave class e valore una lista di rifiuti
 * associa per ogni politica una lista di rifiuti che è ordinata per politica!! 4)
 * 
 * public Map<class<?>, List<Rifiuto>(){
 * Map<class<?>,List<Rifiuto> mappa=new HashMap <class<?>,List<Rifiuto>();
 * List<Rifiuto> lista;
 * for(Rifiuto r: this.smaltiti){
 * lista=mappa.get(r.getClass());
 * if(lista==null)
 * lista=new ArrayList<Rifiuto>();
 * lista.add(r);
 * mappa.put(r.getClass(),lista);
 * }
 * for(class<?> p: mappa.keySet()){
 * Collections.sort(mappa.get(p),new Comparatore(this);
 * }
 * return mappa;
 * }
 * 
 * 
 * 
 *altro modo: altamente probabile
 * public class ComparatoreClass implements Comparator<Rifiuto> {
Map<Rifiuto,Mezzo> mappa;

 public ComparatoreClass(Citta c) {
this.mappa = c.getMapRifiutoMezzo();
}

 @Override
public int compare(Rifiuto o1, Rifiuto o2) {
return this.mappa.get(o1).getRaccoglitore().getPolitica().getClass().getName().compareTo(this.mappa.get(o2).getRaccoglitore().getPolitica().getClass().getName());
}





}
 * 
 * public class Comparatore implements Comparator<Rifiuto>{
 * private Collection<Camion> camions;
 * public Comparatore(Collection<Camion> c){
 * this.camions=c;
 * }
 * fare un metodo che passato un rifiuto da il camion che l ha raccolto;
 * public Camion metodo(Rifiuto a){
 * for(Camion c: getCamion()){
 *   for(Rifiuto r: c.getRaccoglitore())){
 *   if (r.equals(a))
 *   return c;
 * }
 * }
 * return null;
 * }
 * 
 * public int compare(Rifiuto o1, Rifiuto o2){
 * return metodo(o1).getPolitica.compareTo(metodo(o2).getPolitica());
 * }
 * }
 */
/*
 * 



 // METODO 5.
 * mappa che ha come chiave class e valore double che è il tempo medio
 * di raccolta di carico sul camion e scarico.
 * i rifiuti sono di tre tipi vetro,umido e non reciclabile.
 * 
 * public Map<Class<?>, double> metodo(){
 * Map<Class<?>, double> mappa=new HashMap<Class<?>, double>();
 * int v=0;
 * int u=0;
 * int nn=0;
 * double=tempomedio;
 * for(Rifiuti r: getRifiuti()){
 * if(r.getClass().equals(Umido.class)){
 * u++;
 * }
 * else if(r.getClass().equals(vetro.class)){
 * v++;
 * }
 * else nn++;
 * if(!mappa.containsKey(r.getClass()))
 * mappa.put(r.getClass(),(double)0);
 * mappa.put(r.getClass(),(double) mappa.get(r.getClass())+ (r.getCamioncarico()-r.getCamionScarico());
 * }
 * for(class<?> p: mappa.keySet()){
 * if(p.equals(Umido.class)&& u>0){
 * tempomedio=mappa.get(p)/u;
 * mappa.put(p,tempomedio);
 * }
 * if(p.equals(Vetro.class)&& v>0){
 * tempomedio=mappa.get(p)/v;
 * mappa.put(p,tempomedio);
 * }
 * if(p.equals(Umido.class)&& u>0){
 * tempomedio=mappa.get(p)/u;
 * mappa.put(p,tempomedio);
 * }
 * }
 * return mappa;
 * }
 * 
 * 
 */

/*
  METODO 6.
 * metodo di una lista che ritorna le distanze percorse dai camion
 * 
 * public List<Integer> metodo2(){
 * List<Integer> lista=new ArrayList<Integer>();
 * for(Camion c: getCamion()){
 * int dist=0;
 *    for(Rifiuto r: mappa1().get(c.getClass())){
 *    dist+=(r.getX.preso()-r.getXlasciato())+(r.gety.preso()-r.getylasciaot())
 /*
 * }
 * lista.add(dist);
 * }
 * return lista;
 * }
 * 
 */


