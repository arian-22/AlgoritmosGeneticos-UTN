package ejercicio01;

import java.util.Arrays;
import java.util.Random;

public class Poblacion {
	/*Variables de la clase*/
	public static boolean elitismo ;
	private int cantidadDeCromosomas = Ejercicio_01.cantidadDeCromosomas;
	//private int cantidadDeCiclos = Ejercicio_01.cantidadDeCiclos;
	private Cromosoma cromosomas[] = new Cromosoma[cantidadDeCromosomas];
	private double maximo = 0, minimo = Double.MAX_VALUE;
	private double sumaFuncionObjetivo = 0;
	private double promedio;
	private Cromosoma[] valoresEnRuleta; 
	private Random rnd = new Random();
	private Cromosoma[] paresDePadres;
	private Cromosoma elite = new Cromosoma();
	
	public boolean isElitismo() {
		return elitismo;
	}

	public static void setElitismo(boolean eli) {
		elitismo = eli;
	}
	
	public Cromosoma getElite() {
		return elite;
	}

	public void setElite(Cromosoma elite) {
		this.elite = elite;
	}

	public void setCromosomas(Cromosoma[] cromosomas) {
		this.cromosomas = cromosomas;
	}

	public Cromosoma[] getCromosomas() {
		return cromosomas;
	}

	public double getMaximo() {
		return maximo;
	}

	public void setMaximo(double maximo) {
		this.maximo = maximo;
	}

	public double getMinimo() {
		return minimo;
	}

	public void setMinimo(double minimo) {
		this.minimo = minimo;
	}

	public double getSumaFuncionObjetivo() {
		return sumaFuncionObjetivo;
	}

	public void setSumaFuncionObjetivo(double sumaFuncionObjetivo) {
		this.sumaFuncionObjetivo = sumaFuncionObjetivo;
	}

	public double getPromedio() {
		return promedio;
	}

	public void setPromedio(double promedio) {
		this.promedio = promedio;
	}

	public void crearPoblacionInicial(){
		for (int i = 0; i < cantidadDeCromosomas; i++){
			Cromosoma c = new Cromosoma();
			cromosomas[i] = c.crearNuevoCromosoma();
		}
	}

	public void calcularValoresDeLaPoblacion() {
		//Calcular los valores en decimal del cromosoma
		for (int i = 0; i < cantidadDeCromosomas; i++){
			cromosomas[i].calcularDecimal();
		}
		//Calcular la funcion objetivo de cada cromosoma
				for (int i = 0; i < cantidadDeCromosomas; i++){
					cromosomas[i].funcionObjetivo();;
				}
		
		//Calcular la sumatorias de la funcion objetivo
		this.calcularSumatoriaFuncionObjetivo();
		
		//Calcular el Fitness de cada cromosoma
		for (int i = 0; i < cantidadDeCromosomas; i++){
			cromosomas[i].calcularFitness(this.sumaFuncionObjetivo);
		}
		
		//Calcular maximo, minimo y promedio de la poblacion
		this.calcularMaximo();
		this.calcularMinimo();
		this.calcularPromedio();	
		
	}
	
	private void calcularPromedio() {
		this.promedio = this.sumaFuncionObjetivo / this.cantidadDeCromosomas;
	}

	private void calcularMinimo() {
		double min = Double.MAX_VALUE;
		for(int i=0; i < cantidadDeCromosomas; i++){
			if(cromosomas[i].getValorFuncionObjetivo() <= min){
				min = cromosomas[i].getValorFuncionObjetivo();
			}
		}
		this.setMinimo(min);
	}

	private void calcularMaximo() {
		double max = 0;
		for(int i=0; i < cantidadDeCromosomas; i++){
			if(cromosomas[i].getValorFuncionObjetivo() >= max){
				max = cromosomas[i].getValorFuncionObjetivo();
				this.setElite(cromosomas[i]);
				
			}
			
		}
		
		this.setMaximo(max);
		
		
	}

	public void calcularSumatoriaFuncionObjetivo(){
		double acum = 0.0;
		for(int i=0; i < cantidadDeCromosomas; i++){
			acum += cromosomas[i].getValorFuncionObjetivo();
		}
		this.setSumaFuncionObjetivo(acum);
	}

	public void evolucionarGeneticamente(Poblacion poblacionAnterior) {
		double random;
		
		//Creo un arreglo con los valores de los fitness de la poblacion anterior
		//Luego los ordeno de menor a mayor
		valoresEnRuleta = new Cromosoma[cantidadDeCromosomas];
		for(int i=0 ; i < cantidadDeCromosomas; i++){
			valoresEnRuleta[i] = new Cromosoma();
			valoresEnRuleta[i].setArrayDeGenes(poblacionAnterior.getCromosomas()[i].getArrayDeGenes());
			valoresEnRuleta[i].setValorFitness(poblacionAnterior.getCromosomas()[i].getValorFitness());
		}
		//valoresEnRuleta = poblacionAnterior.getCromosomas().clone();
		Arrays.sort(this.valoresEnRuleta);
		
		//Realizo el metodo de la ruleta para generar los pares de padres
		//this.metodoDeLaRuleta();
		if(elitismo){
		this.metodoDeLaRuletaConElitismo();
		}
		else
		{this.metodoDeLaRuleta();}
		//Crossover
		cromosomas = new Cromosoma[cantidadDeCromosomas];
		for(int i=0; i < cantidadDeCromosomas; i+=2){
			random = Math.random();
			if(random <= Ejercicio_01.getCrossover()){
				System.out.println("Resultado del Crossover para el par (" + (i+1) + ","+(i+2)+")");
				this.Crossover(paresDePadres[i], paresDePadres[i+1], i);
			}else{
				System.out.println("No hubo Crossover para el par (" + (i+1) + ","+(i+2)+")" + " - Random (" + random + ") > Crossover (" + Ejercicio_01.getCrossover() + ")");
				cromosomas[i] =  new Cromosoma();
				cromosomas[i].setArrayDeGenes(paresDePadres[i].getArrayDeGenes());
				cromosomas[i+1] = new Cromosoma();
				cromosomas[i+1].setArrayDeGenes(paresDePadres[i+1].getArrayDeGenes());
			}
			System.out.println();
		}
		
		System.out.println();
		
		//Mutacion
		for(int i=0; i < cantidadDeCromosomas; i++){
			random = Math.random();
			if(random <= Ejercicio_01.getMutacion()){
				System.out.println("Resultado de la Mutacion para el cromosoma #" + (i+1));
				cromosomas[i] = this.Mutacion(cromosomas[i], i);
			}else{
				System.out.println("No hubo Mutacion para el cromosoma #" + (i+1) + " - Random (" + random + ") > Crossover (" + Ejercicio_01.getMutacion() + ")");
			}
		}
	}

	private Cromosoma Mutacion(Cromosoma cromosoma, int i) {
		int nroAzar = rnd.nextInt(29);
		Cromosoma s = new Cromosoma();
		s.setArrayDeGenes(cromosoma.getArrayDeGenes().clone());
		cromosomas[i] =  new Cromosoma();
		if(s.getArrayDeGenes()[nroAzar] == 0){
			s.getArrayDeGenes()[nroAzar] = 1;
		}else{
			s.getArrayDeGenes()[nroAzar] = 0;
		}
		return s;
	}
//.
	private void Crossover(Cromosoma c1, Cromosoma c2, int i) {
		int nroAzar = rnd .nextInt(29);
		Cromosoma crom1 = new Cromosoma();
		Cromosoma crom2 = new Cromosoma();
		
		System.out.println("- - - - - - - - - - - -");
		System.out.println("Cromosoma padre 1: " + Arrays.toString(c1.getArrayDeGenes()));
		System.out.println("Cromosoma padre 2: " + Arrays.toString(c2.getArrayDeGenes()));
		System.out.println(" >>> Corta en: " + (nroAzar)+" <<<");
		
		for(int j=0; j < nroAzar; j++){
			crom1.getArrayDeGenes()[j] = c1.getArrayDeGenes()[j];
			crom2.getArrayDeGenes()[j] = c2.getArrayDeGenes()[j];
		}
		for(; nroAzar < 30; nroAzar++){
			crom1.getArrayDeGenes()[nroAzar] = c2.getArrayDeGenes()[nroAzar];
			crom2.getArrayDeGenes()[nroAzar] = c1.getArrayDeGenes()[nroAzar];
		}
		cromosomas[i] =  new Cromosoma();
		cromosomas[i].setArrayDeGenes(crom1.getArrayDeGenes());
		cromosomas[i+1] = new Cromosoma();
		cromosomas[i+1].setArrayDeGenes(crom2.getArrayDeGenes());
				
		System.out.println("Cromosoma hijo 1: " + Arrays.toString(crom1.getArrayDeGenes()));
		System.out.println("Cromosoma hijo 2: " + Arrays.toString(crom2.getArrayDeGenes()));	
		
		
	}

	/*private void metodoDeLaRuleta() {
		paresDePadres = new Cromosoma[cantidadDeCromosomas];
		System.out.println("-----------------------RULETA-------------------------");
		for(int j = 0; j < cantidadDeCromosomas; j++){
			boolean ok = true;
			int posicion = 0;
			paresDePadres[j] = new Cromosoma();
			
			double azar = rnd.nextDouble();
			System.out.println("RANDOM: "+azar +"  VS RULETA:  "+valoresEnRuleta[j].getValorFitness());
			while(ok){
				if(azar <= valoresEnRuleta[posicion].getValorFitness()){
					paresDePadres[j].setArrayDeGenes(valoresEnRuleta[posicion].getArrayDeGenes());
					ok = false;
				}else{
					if(posicion < cantidadDeCromosomas-1){
						posicion++;
					}else{
						paresDePadres[j].setArrayDeGenes(valoresEnRuleta[posicion].getArrayDeGenes());
						ok = false;
					}
				}
			}
		}System.out.println("------------------------FIN RULETA---------------------");
		
	}*/
//--NOTA: podria usar el mismo metodo con paresDePAdres [0] = max cromo --> esto es prueba	
	private void metodoDeLaRuletaConElitismo(){
		paresDePadres = new Cromosoma[cantidadDeCromosomas];
		paresDePadres[0] =elite;
		System.out.println("-----------------------RULETA-------------------------");
		for(int j = 1; j < cantidadDeCromosomas; j++){
			boolean ok = true;
			int posicion = 0;
			paresDePadres[j] = new Cromosoma();
			
			double azar = rnd.nextDouble();
			System.out.println("RANDOM: "+azar +"  VS RULETA:  "+valoresEnRuleta[j].getValorFitness());
			while(ok){
				if(azar <= valoresEnRuleta[posicion].getValorFitness()){
					paresDePadres[j].setArrayDeGenes(valoresEnRuleta[posicion].getArrayDeGenes());
					ok = false;
				}else{
					if(posicion < cantidadDeCromosomas-1){
						posicion++;
					}else{
						paresDePadres[j].setArrayDeGenes(valoresEnRuleta[posicion].getArrayDeGenes());
						ok = false;
					}
				}
			}
		}System.out.println("------------------------FIN RULETA---------------------");
		
	}
	
	/*private Cromosoma[] metodoDeLaRuleta(int valores) { //------------------------------RULETA PYTHON

		paresDePadres = new Cromosoma[cantidadDeCromosomas];

		// for i in range(0, nropob):
		for(int j = 0; j < cantidadDeCiclos; j++){
			double	pick = Math.random();
			int current = 0;
			boolean flag = false;
			for(int i = 0; i < cantidadDeCromosomas; i++){   
					while (flag == false)
					{
		                current += ruleta[i].
		                if (current > pick){
		                   paresDePadres[i].setArrayDeGenes(valoresEnRuleta[posicion].getArrayDeGenes());
		                    flag = true;
		                }else{ break; }
		    	 	}
			}             
		} return paresDePadres;
	}*/
	
	private void metodoDeLaRuleta() { 		//----------------------------------------------RULETA AUGUSTO
		System.out.println();
		paresDePadres = new Cromosoma[cantidadDeCromosomas];
		double random;
		System.out.println("---------RULETA-------------");
		for(int i=0;i<cantidadDeCromosomas;i++)
		{
		
			double inferior=0;
			double superior=valoresEnRuleta[0].getValorFitness();
			int posicion=0;
			boolean p=true;
			random = Math.random();
		
		System.out.println("RANDOM: "+random +"  VS RULETA:  "+valoresEnRuleta[i].getValorFitness());
		
			while (p)
				
			{
				
				
			if(random>inferior && random<superior)
			{
				paresDePadres[i]=valoresEnRuleta[posicion];
				
				//paresDePadres[i].setArrayDeGenes(valoresEnRuleta[posicion].getArrayDeGenes());
				p=false;
			}
			else
			{
				if(superior<=1)
				{
				inferior=superior;
				superior=superior+valoresEnRuleta[posicion+1].getValorFitness();
				
				
				}
			}
			
			if(p)
			{
				
				posicion++;
				
			}
			}
					}
		
	}


}
