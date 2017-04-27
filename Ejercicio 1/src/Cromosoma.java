import java.util.Arrays;
import java.util.Random;

public class Cromosoma implements Comparable<Cromosoma> {
	private int arrayCromo[] = new int[30];
	private String cromosoma = "";
	private long valorDecimal;
	private double valorFuncionObjetivo;
	private double valorFitness;
	private Random rnd = new Random();
	
	Cromosoma(){
		
	}
	
	
	public int[] getArrayCromo() {
		return arrayCromo;
	}


	public void setArrayCromo(int[] arrayCromo) {
		this.arrayCromo = arrayCromo;
	}


	public double getValorFuncionObjetivo() {
		return valorFuncionObjetivo;
	}

	public void setValorFuncionObjetivo(double valorFuncionObjetivo) {
		this.valorFuncionObjetivo = valorFuncionObjetivo;
	}
	
	public long getValorDecimal() {
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
		valorDecimal = Long.parseLong(cromosoma, 2);
		System.out.println("Valor decimal: " + valorDecimal);
	}
	
	private void devuelveBinario(){
		cromosoma = "";
		for(int i = 0 ; i < 30; i++){
			cromosoma = cromosoma + arrayCromo [i];
		}
		System.out.println("Valor binario: " + cromosoma);
	}
	
	public void funcionObjetivo (){
		double coef = Math.pow(2, 30) - 1;
		double d = valorDecimal / coef;
		valorFuncionObjetivo = Math.pow((d), 2);
		
		//System.out.println("   F. Objetivo: " + valorFuncionObjetivo);
		
		valorFuncionObjetivo = Math.rint(valorFuncionObjetivo*10000)/10000;
		
		System.out.println("   F. Objetivo: " + valorFuncionObjetivo);
	}
	
	public void funcionFitness(double sumaFuncionObjetivo) {
		valorFitness = valorFuncionObjetivo / sumaFuncionObjetivo;
		//System.out.println("   Fitness: " + valorFitness);
		
		valorFitness = Math.rint(valorFitness*10000)/10000;
		System.out.println("   Fitness: " + valorFitness);
	}
	
	public void inicializar(){
		this.crearBinario();
		this.aEntero();
		
	}
	
	@Override
	public int compareTo(Cromosoma c) {
		if (valorFitness < c.valorFitness) {
            return -1;
        }
        if (valorFitness > c.valorFitness) {
            return 1;
        }
        return 0;
    }

}
