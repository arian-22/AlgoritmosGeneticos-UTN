import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Poblacion { 
	private ArrayList<Cromosoma> cromosomas = new ArrayList<Cromosoma>();
	private double maximo = 0, minimo = Double.MAX_VALUE;
	private double sumaFuncionObjetivo = 0;
	private double promedio;
	private int cantIteraciones = Ejercicio1.cantidadIteraciones;
	
	private Cromosoma ruleta[] = new Cromosoma[cantIteraciones];
	private Cromosoma paresDePadres[] = new Cromosoma[cantIteraciones];
	private Random rnd = new Random();
	
	public void añadirCromosoma(Cromosoma c){
		cromosomas.add(c);
	}

	public ArrayList<Cromosoma> getCromosomas() {
		return cromosomas;
	}

	public void setCromosomas(ArrayList<Cromosoma> cromosomas) {
		this.cromosomas = cromosomas;
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

	public double getSuma() {
		return sumaFuncionObjetivo;
	}

	public void setSuma(double suma) {
		this.sumaFuncionObjetivo = suma;
	}

	public double getPromedio() {
		return promedio;
	}

	public void setPromedio(double promedio) {
		this.promedio = promedio;
	}
	
	public void calcularMaximo(){
		for(int i=0; i < cantIteraciones; i++){
			if(cromosomas.get(i).getValorFuncionObjetivo() >= maximo){
				maximo = cromosomas.get(i).getValorFuncionObjetivo();
			}
		}
		System.out.println("   Maximo: " + maximo);		
	}
	
	public void calcularMinimo(){
		for(int i=0; i < cantIteraciones; i++){
			if(cromosomas.get(i).getValorFuncionObjetivo() <= minimo){
				minimo = cromosomas.get(i).getValorFuncionObjetivo();
			}
		}
		System.out.println("   Minimo: " + minimo);
	}
	
	public void calcularSumatoriaFuncionObjetivo(){
		double acum = 0.0;
		
		for(int i=0; i < cantIteraciones; i++){
			acum += cromosomas.get(i).getValorFuncionObjetivo();
		}
		sumaFuncionObjetivo = acum;
		System.out.println("~Sumatoria de los valores de la F.O.: " + sumaFuncionObjetivo);
	}
	
	public void calcularSumatoriaFuncionFitness(){
		double acum = 0;
		
		for(int i=0; i < cantIteraciones; i++){
			acum += cromosomas.get(i).getFitness();
		}
		System.out.println("~Sumatoria de los valores de la F.F.: " + acum);
	}
	
	public void calcularPromedio(){
		promedio = sumaFuncionObjetivo / cantIteraciones;
		System.out.println("   Pomedio: " + promedio);
	}
	
	public void evolucionarGeneticamente(){
		double random ;
		
		this.crearRuleta();
		this.metodoDeLaRuleta();
		
		cromosomas.clear();
		
		//Crossover
		System.out.println();
		for(int i=0; i < cantIteraciones; i+=2){
			random = Math.random();
			if(random <= Ejercicio1.getCrossover()){
				System.out.println("Resultado del Crossover para el par (" + (i+1) + ","+(i+2)+")");
				this.Crossover(paresDePadres[i], paresDePadres[i+1], i);
			}else{
				System.out.println("No hubo Crossover para el par (" + (i+1) + ","+(i+2)+")" + " - Random (" + random + ") > Crossover (" + Ejercicio1.getCrossover() + ")");
				cromosomas.add(paresDePadres[i]);
				cromosomas.add(paresDePadres[i+1]);
			}
			System.out.println();
		}
		
		System.out.println();
		
		//Mutacion
		for(int i=0; i < cantIteraciones; i++){
			random = Math.random();
			
			if(random <= Ejercicio1.getMutacion()){
				System.out.println("Resultado de la Mutacion para el cromosoma #" + (i+1));
				this.Mutacion(cromosomas.get(i), i);
				//cromosomas.get(i).mutacion();
			}else{
				//pichi[i]=cromosomas.get(i);
				System.out.println("No hubo Mutacion para el cromosoma #" + (i+1) + " - Random (" + random + ") > Crossover (" + Ejercicio1.getMutacion() + ")");
			}
		}
		
		/*for(int b=0;b<pichi.length;b++){
			System.out.println("pichi "+(pichi[b]) );
		}*/
	}
	
	private void metodoDeLaRuleta() {
		System.out.println();
		System.out.println("Lanzamiento de Ruleta");
		for(int j = 0; j < cantIteraciones; j++){
			boolean ok = true;
			int posicion = 0;
			
			//System.out.println(" Padre #"+(j+1));
			double azar = Math.rint(Math.random()*10000)/10000;
			//System.out.println(" >>Nro azar: "+ azar);
			while(ok){
				//System.out.println("  Fitnes del cromosoma: "+ruleta[posicion].getFitness());
				if(azar <= ruleta[posicion].getFitness()){
					paresDePadres[j] = ruleta[posicion];
					ok = false;
					System.out.println("  Comosoma seleccionado: #" + (posicion+1));
				}else{
					if(posicion < cantIteraciones-1){
						posicion++;
						//System.out.println("  Siguiente");
					}else{
						paresDePadres[j] = ruleta[posicion];
						ok = false;
						System.out.println("  Comosoma seleccionado: #" + (posicion+1));
					}
				}
			}
		}
		System.out.println("-FIN RULETA-");
	}

	private void crearRuleta() {
		System.out.println();
		//System.out.println("Ruleta segun Fitness");
		//System.out.println(" Sin ordenar");
		for(int i=0; i < cantIteraciones; i++){
			ruleta[i] = cromosomas.get(i);
			//System.out.println("   "+(i+1)+")" + ruleta[i].getFitness());
		}
		
		Arrays.sort(ruleta);
		
		//System.out.println(" Ordenados");
		for(int i=0; i < cantIteraciones; i++){
			//System.out.println("   "+(i+1)+")" + ruleta[i].getFitness());
		}
	}

	public void inicializar(){
		System.out.println();
		System.out.println("Valores de la Funcion Objetivo de la poblacion.");
		for(int i=0; i < cantIteraciones; i++){
			System.out.print("-Cromosoma #" + (i+1) + "  --->");
			cromosomas.get(i).funcionObjetivo();
		}
		this.calcularSumatoriaFuncionObjetivo();
		
		System.out.println();
		
		System.out.println("Valores Fitness de la poblacion.");
		for(int i=0; i < cantIteraciones; i++){
			System.out.print("-Cromosoma #" + (i+1) + "  --->");
			cromosomas.get(i).funcionFitness(sumaFuncionObjetivo);
		}
		this.calcularSumatoriaFuncionFitness();
		
		System.out.println();
		
		System.out.println("Datos de la poblacion.");
		
		maximo = 0;
		this.calcularMaximo();
		minimo = Double.MAX_VALUE;
		this.calcularMinimo();
		this.calcularPromedio();		
		
	}
	
	private void Crossover(Cromosoma c1, Cromosoma c2, int i){
		int nroAzar = rnd .nextInt(29);
		int aux;
		
		System.out.println("- - - - - - - - - - - -");
		System.out.println("Cromosoma padre 1: " + Arrays.toString(c1.getArrayCromo()));
		System.out.println("Cromosoma padre 2: " + Arrays.toString(c2.getArrayCromo()));
		System.out.println(" >>> Corta en: " + (nroAzar)+" <<<");
		
		for(; nroAzar < 30; nroAzar++){
			aux = c1.getArrayCromo()[nroAzar];
			c1.getArrayCromo()[nroAzar] = c2.getArrayCromo()[nroAzar];
			c2.getArrayCromo()[nroAzar] = aux;
		}
		
		cromosomas.add(c1);
		cromosomas.add(c2);
				
		System.out.println("Cromosoma hijo 1: " + Arrays.toString(c1.getArrayCromo()));
		System.out.println("Cromosoma hijo 2: " + Arrays.toString(c2.getArrayCromo()));	
		
		
	}
	
	private void Mutacion(Cromosoma c1, int i){
		int nroAzar = rnd.nextInt(29);
		//int c[] = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		//Cromosoma cm = new Cromosoma();
		Cromosoma s = new Cromosoma();
		
		s.setArrayCromo(c1.getArrayCromo());

		
		System.out.println("- - - - - - - - - - - -");
		System.out.println("Cromosoma original: " + Arrays.toString(c1.getArrayCromo()));
		System.out.println(" >>> Posicion a mutar: " + (nroAzar+1)+" <<<");
		
		
		
		if(c1.getArrayCromo()[nroAzar] == 0){
			c1.getArrayCromo()[nroAzar] = 1;
		}else{
			c1.getArrayCromo()[nroAzar] = 0;
		}
		
		System.out.println("Cromosoma mutado: " + Arrays.toString(c1.getArrayCromo()));
		
		//cm.setArrayCromo(s.getArrayCromo());
		
		//cm.setArrayCromo(c);
		//cromosomas.set(i, cm);
		
	}

}

