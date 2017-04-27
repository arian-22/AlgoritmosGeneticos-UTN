public class Ejercicio1 {

	private static double Crossover = 0.75;
	private static double Mutacion = 0.05;
	public static int cantidadCiclos = 100;
	public static int cantidadIteraciones = 6; 
	
	public static void main(String[] args) {
		
		//Declaracion de variables.
		Poblacion Poblaciones[] = new Poblacion[cantidadCiclos];
		
		/*
		 * Programa principal
		 * */
		
		//Creacion de la poblacion inicial.
		
		Poblacion p = new Poblacion();
		

		System.out.println("-------------------------------------------------------");
		System.out.println("******************** POBLACIÓN #1 *********************");
		System.out.println("-------------------------------------------------------");
		
		for (int i = 0; i < cantidadIteraciones; i++){
			Cromosoma c = new Cromosoma();
			System.out.println("-Cromosoma #" + (i+1));
			c.inicializar();
			p.añadirCromosoma(c);
			System.out.println();
		}
		p.inicializar();
		p.evolucionarGeneticamente();
		
		Poblaciones[0] = p;
		
		for(int i = 1; i < cantidadCiclos; i++){
			System.out.println("-------------------------------------------------------");
			System.out.println("******************** POBLACIÓN #"+(i+1)+" *********************");
			System.out.println("-------------------------------------------------------");
			
			p = Poblaciones[i-1];
			
			for (int j = 0; j < cantidadIteraciones; j++){
				System.out.println("-Cromosoma #" + (j+1));
				p.getCromosomas().get(j).aEntero();
			}
			p.inicializar();
			p.evolucionarGeneticamente();
			
			Poblaciones[i] = p;
		}
	}
	
	//Declaracion de metodos
	
	public static double getMutacion() {
		return Mutacion;
	}

	public static double getCrossover() {
		return Crossover;
	}
}