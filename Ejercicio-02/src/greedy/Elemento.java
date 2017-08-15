package greedy;

public class Elemento implements Comparable<Elemento>{
    private String nombre;
    private double valor;
    private double peso;
    private double relacion;
    
    public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getRelacion() {
		return relacion;
	}

	public void setRelacion(double relacion) {
		this.relacion = relacion;
	}

	Elemento(double p, double v){
    
        valor = v;
        peso  = p;
        relacion = v/p;
    }
    
    public String toString() {
        return String.format(" %,12.2f %,12.2f", valor, peso);
    }
    
    public double relacion(){
    	
    	return (this.valor/this.peso);
    }
    
    public int compareTo(Elemento o) {
        if (relacion > o.relacion) {
            return -1;
        }
        if (relacion < o.relacion) {
            return 1;
        }
        return 0;
    }
    
}
