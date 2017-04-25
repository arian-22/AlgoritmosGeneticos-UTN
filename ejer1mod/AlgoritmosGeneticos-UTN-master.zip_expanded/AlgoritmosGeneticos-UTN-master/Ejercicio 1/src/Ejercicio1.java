import java.util.Random;

public class Ejercicio1 {

	public static void main(String[] args) {
		
		//Declaracion de variables.
		int poblacionInicial[][] = new int[10][30];
		float acum= 0;
		/*
		 * Programa principal
		 * */
		
		//Creacion de la poblacion original.
		System.out.println("POBLACIÓN INICIAL:");
		System.out.println("------------------");
		for (int i = 0; i < 10; i++){
			for (int j = 0;j < 30; j++){
				Random rnd = new Random();
				int x = rnd.nextInt(2);
				poblacionInicial[i][j] = x;
			}
			//System.out.println(Arrays.toString(poblacion[i]));
			System.out.println("Nro. "+(i+1)+": " + devuelveBinario(poblacionInicial[i]));
		}
		System.out.println("_____________________________________________________\n");
		for(int h = 0; h < 10; h++){
			int entero = aEntero(poblacionInicial[h]);
			System.out.println("#"+(h+1));
			System.out.println("Cromosoma BINARIO: " + devuelveBinario(poblacionInicial[h]));
			System.out.println("Cromosoma en DECIMAL: " + entero);
			System.out.println("F.Obj: "+ funcionObjetivo(entero));
			acum= funcionObjetivo(entero)+acum;
			System.out.println("Fitness: ");
			System.out.println("");
		}
		System.out.println("Suma: "+acum);
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
	
}