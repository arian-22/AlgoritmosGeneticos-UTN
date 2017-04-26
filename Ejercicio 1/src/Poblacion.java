import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Poblacion {
	private ArrayList<Cromosoma> cromosomas = new ArrayList<Cromosoma>();
	private int maximo = 0, minimo = Integer.MAX_VALUE;
	private long suma = 0;
	private float promedio;
	private int cantIteraciones = Ejercicio1.cantidadIteraciones;
	private Cromosoma ruleta[] = new Cromosoma[cantIteraciones];
	private int paresDePadres[] = new int[cantIteraciones];
	
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

	public long getSuma() {
		return suma;
	}

	public void setSuma(long suma) {
		this.suma = suma;
	}

	public float getPromedio() {
		return promedio;
	}

	public void setPromedio(float promedio) {
		this.promedio = promedio;
	}
	
	public void calcularMaximo(){
		for(int i=0; i < cantIteraciones; i++){
			if(cromosomas.get(i).getValorDecimal() >= maximo){
				maximo = cromosomas.get(i).getValorDecimal();
			}
		}
		System.out.println("   Máximo: " + maximo);		
	}
	
	public void calcularMinimo(){
		for(int i=0; i < cantIteraciones; i++){
			if(cromosomas.get(i).getValorDecimal() <= minimo){
				minimo = cromosomas.get(i).getValorDecimal();
			}
		}
		System.out.println("   Mínimo: " + minimo);
	}
	
	public void calcularSumatoriaFuncionObjetivo(){
		long acum = 0;
		
		for(int i=0; i < cantIteraciones; i++){
			acum += cromosomas.get(i).getValorDecimal();
		}
		suma = acum;
		System.out.println("~Sumatoria de los valores de la F.O.: " + suma);
	}
	
	public void calcularSumatoriaFuncionFitness(){
		long acum = 0;
		
		for(int i=0; i < cantIteraciones; i++){
			acum += cromosomas.get(i).getFitness();
		}
		//suma = acum;
		System.out.println("~Sumatoria de los valores de la F.F.: " + acum);
	}
	
	public void calcularPromedio(){
		promedio = suma / cantIteraciones;
		System.out.println("   Pomedio: " + promedio);
	}
	
	public void evolucionarGeneticamente(){
		this.crearRuleta();
		this.metodoDeLaRuleta();
	}
	
	private void metodoDeLaRuleta() {
		for(int j = 0; j < cantIteraciones; j++){
			boolean ok = true;
			int posicion = 0;
			
			double azar = Math.random();
			while(ok){
				if(azar <= ruleta[posicion].getFitness()){
					
					ok = false;
				}
			}
		}
	}

	private void crearRuleta() {
		
		//REVISAR CODIGO DE ORDENAMIENTO!
		
		for(int i=0; i < cantIteraciones-1; i++){
			for(int j = 0; j < cantIteraciones-i-1; j++){
				if(cromosomas.get(j+1).getFitness() < cromosomas.get(j).getFitness()){
					ruleta[i] = cromosomas.get(j+1);
				}else{
					ruleta[i] = cromosomas.get(j);
				}
			}
			System.out.println("Orden: " + ruleta[i].getFitness());
		}
		//Arrays.sort(ruleta);
	}

	public void inicializar(){
		this.calcularSumatoriaFuncionObjetivo();
		System.out.println();
		System.out.println("Valores Fitness y Funcion Objetivo de la población.");
		for(int i=0; i < cantIteraciones; i++){
			System.out.println("-Cromosoma #" + (i+1));
			cromosomas.get(i).funcionObjetivo();
			cromosomas.get(i).funcionFitness(suma);
		}
		System.out.println();
		this.calcularSumatoriaFuncionFitness();
		System.out.println();
		System.out.println("Datos de la población.");
		this.calcularMaximo();
		this.calcularMinimo();
		this.calcularPromedio();		
		
	}
}

