import java.util.Arrays;
import java.util.Random;

public class Cromosoma {
	private int arrayCromo[] = new int[30];
	private String cromosoma = "";
	private int valorDecimal;
	private double valorFuncionObjetivo;
	private double valorFitness;
	private Random rnd = new Random();
	
	
	Cromosoma(){
		
	}
	
	public int getValorDecimal() {
		return valorDecimal;
	}

	public void setValorDecimal(int decimal) {
		this.valorDecimal = decimal;
	}

	public double getFitness() {
		return valorFitness;
	}

	public void setFitness(double fitness) {
		this.valorFitness = fitness;
	}
	
	public void crearBinario(){
		for (int j = 0;j < 30; j++){
			int x = rnd.nextInt(2);
			arrayCromo[j] = x;
		}
		System.out.println("Array binario: " + Arrays.toString(arrayCromo));
	}
	
	public void aEntero (){
		this.devuelveBinario();	
		valorDecimal = Integer.parseInt(cromosoma, 2);
		System.out.println("Valor decimal: " + valorDecimal);
	}
	
	private void devuelveBinario(){
		for(int i = 0 ; i < 30; i++){
			cromosoma = cromosoma + arrayCromo [i];
		}
		System.out.println("Valor binario: " + cromosoma);
	}
	
	public void funcionObjetivo (){
		double coef = Math.pow(2, 30) - 1;
		double d = valorDecimal / coef;
		valorFuncionObjetivo = Math.pow((d), 2);
		System.out.println("   F. Objetivo: " + valorFuncionObjetivo);
	}
	
	public void funcionFitness(long suma) {
		this.valorFitness = this.valorFuncionObjetivo / suma;
		System.out.println("   Fitness: " + valorFitness);
	}
	
	public void inicializar(){
		this.crearBinario();
		this.aEntero();
	}

}
