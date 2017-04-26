import java.util.Arrays;
import java.util.Random;
import com.sun.javafx.collections.SortableList;

public class Ejercicio1 {

	private double Crossover = 0.75;
	private double Mutacion = 0.05;
	private static Random rnd = new Random();
	public static int cantidadCiclos = 5;
	public static int cantidadIteraciones = 5; 
	
	public static void main(String[] args) {
		
		//Declaracion de variables.
		Poblacion Poblaciones[] = new Poblacion[20];
		float acum = 0;
		int entero;
		int maximo = 0, minimo = Integer.MAX_VALUE;
		float promedio, fitness;
		float ruleta[] = new float[cantidadIteraciones];
		int pares[] = new int[cantidadIteraciones];
		
		/*
		 * Programa principal
		 * */
		
		//Creacion de la poblacion original.
		
		Poblacion p = new Poblacion();
		System.out.println("POBLACIÓN #");
		System.out.println("------------------");
		
		for (int i = 0; i < cantidadIteraciones; i++){
			Cromosoma c = new Cromosoma();
			System.out.println("-Cromosoma #" + (i+1));
			c.inicializar();
			p.añadirCromosoma(c);
			System.out.println();
		}
		p.inicializar();
		p.evolucionarGeneticamente();
		
		System.out.println("_____________________________________________________\n");
		
		
		/*
		
		for(int h = 0; h < cantidadIteraciones; h++){
			
			entero = aEntero(poblacionInicial[h]);
			System.out.println("#"+(h+1));
			System.out.println("Cromosoma BINARIO: " + devuelveBinario(poblacionInicial[h]));
			System.out.println("Cromosoma en DECIMAL: " + entero);
			System.out.println("F.Obj: "+ funcionObjetivo(entero));
			acum= funcionObjetivo(entero)+acum;
			
			if(entero <= minimo){
				minimo = entero;
			}
			if(entero >= maximo){
				maximo = entero;
			}	
		}
		System.out.println("");
		for(int i = 0; i < cantidadIteraciones; i++){
			entero = aEntero(poblacionInicial[i]);
			fitness = funcionObjetivo(entero)/acum;
			ruleta[i] = fitness;
			System.out.println("Fitness #"+(i+1)+": "+fitness);
		}
		
		Arrays.sort(ruleta);
		
		System.out.println("_____________________________________________________\n");
		System.out.println("Valor Mínimo: " + minimo);
		System.out.println("Valor Máximo: " + maximo);
		System.out.println("Suma: "+acum);
		promedio = acum/cantidadIteraciones;
		System.out.println("Promedio: " + promedio);
		
		//Selección metodo de la Ruleta
		for(int i = 0; i < cantidadCiclos; i++){
			for(int j = 0; j < cantidadIteraciones; i++){
				boolean ok = true;
				int k = 0;
				
				float azar = rnd.nextInt(100) / 100;
				while(ok){
					if(azar <= ruleta[k]){
						
						ok = false;
					}
				}
			}
		}
	*/
	}
	
	//Declaracion de metodos
	
	static float funcionObjetivo (float z){
	    	
		int coef = (int) ((Math.pow(2, 30))-1);
		
		float d=(z/coef);
		float g = (float)Math.pow((d), 2);
		
		return g;
	}
	
	static int aEntero (int[] array){
		
		String cromosoma = devuelveBinario(array);	
		int decimalConv = Integer.parseInt(cromosoma, 2);
		
		return decimalConv;
	}
	
	private static String devuelveBinario(int[] array){
		
		String cromosoma = "";
		for(int i = 0 ; i < 30; i++){
			cromosoma = cromosoma + array[i];
		}
		return cromosoma;
	}
	
	private void Crossover(int[] cromosoma_1, int[] cromosoma_2){
		int nroAzar = rnd.nextInt(29);
		int aux;
		
		for(; nroAzar < 30; nroAzar++){
			aux = cromosoma_1[nroAzar];
			cromosoma_1[nroAzar] = cromosoma_2[nroAzar];
			cromosoma_2[nroAzar] = aux;
		}
	}
	
	private void Mutacion(int[] cromosoma){
		int nroAzar = rnd.nextInt(29);
		
		if(cromosoma[nroAzar] == 0){
			cromosoma[nroAzar] = 1;
		}else{
			cromosoma[nroAzar] = 0;
		}
		
	}
}