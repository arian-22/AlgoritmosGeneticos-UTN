package greedy;


class Elemento implements Comparable<Elemento> {
    String nombre;
    double valor;
    double peso;
    
    Elemento(double p, double v){
    
        valor =v;
        peso  =p;
    }
    public String toString() {
        return String.format(" %,12.2f %,12.2f", valor, peso);
    }
    
    public double relacion(){
    	
    	return (this.peso/this.valor);
    }
    
    public int compareTo(Elemento c) {
    	double coef1 = valor / peso;
    	double coef2 = c.valor / c.peso;
    	
		if (coef1 < coef2) {
            return -1;
        }
        if (coef1 > coef2) {
            return 1;
        }
        return 0;
    }
}
