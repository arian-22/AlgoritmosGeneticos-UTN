import java.util.Random;

public class Ejercicio1 {

	public static void main(String[] args) {
		
		//Declaracion de variables.
		int poblacionInicial[][] = new int[10][30];

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
			long entero = aEntero(poblacionInicial[h]);
			System.out.println("#"+(h+1));
			System.out.println("Cromosoma BINARIO: " + devuelveBinario(poblacionInicial[h]));
			System.out.println("Cromosoma en DECIMAL: " + entero);
			System.out.println("");
		}
	}
	
	//Declaracion de metodos
	
	int funcionObjetivo (){
		int y;

		Random rnd = new Random();
		int coef = (int) ((Math.pow(2, 30))-1);
		int x = rnd.nextInt();
		
		y = (int)Math.pow( (x/coef) , 2);
		
		return y;
	}
	
	static long aEntero (int[] array){
		
		String cromosoma = devuelveBinario(array);	
		long decimalConv = Integer.parseInt(cromosoma, 2);
		
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