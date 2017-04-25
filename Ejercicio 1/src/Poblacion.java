import java.util.ArrayList;
import java.util.Arrays;

public class Poblacion {
	private ArrayList<Cromosoma> cromosomas=new ArrayList<Cromosoma>();
	private int maximo = 0, minimo = Integer.MAX_VALUE, suma = 0;
	private float promedio;
	private int cantIter=5;
	
	public void añadirCromosoma(Cromosoma c){
		cromosomas.add(c);
	}

	public ArrayList<Cromosoma> getCromosomas() {
		return cromosomas;
	}

	public void setCromosomas(ArrayList<Cromosoma> cromosomas) {
		this.cromosomas = cromosomas;
	}

	public int getMaximo() {
		return maximo;
	}

	public void setMaximo(int maximo) {
		this.maximo = maximo;
	}

	public int getMinimo() {
		return minimo;
	}

	public void setMinimo(int minimo) {
		this.minimo = minimo;
	}

	public int getSuma() {
		return suma;
	}

	public void setSuma(int suma) {
		this.suma = suma;
	}

	public float getPromedio() {
		return promedio;
	}

	public void setPromedio(float promedio) {
		this.promedio = promedio;
	}
	
	public void calcularMaximo(){
		
		for(int i=0; i < cantIter; i++){
			if(cromosomas.get(i).getdecimal() >= maximo){
				maximo = cromosomas.get(i).getdecimal();
			}
		}
		
	}
	
	public void calcularMinimo(){
		for(int i=0; i < cantIter; i++){
			if(cromosomas.get(i).getdecimal() <= minimo){
				minimo = cromosomas.get(i).getdecimal();
			}
		}
	}
	
	public void calcularSumatoria(){
		
		for(int i=0; i < cantIter; i++){
			suma = cromosomas.get(i).getdecimal() + suma;
		}
		
		
	}
	
	public void calcularPromedio(){
		promedio=suma/cromosomas.size();
		
	}
	
	public void evolucionarGeneticamente(){
		
	}
	
	public void inicializarPoblacion(){
		
	}
}

