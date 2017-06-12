package ejercicio01;

import java.util.Random;

public class Cromosoma implements Comparable<Cromosoma> {
	private int cantidadDeGenes = 30;
	private int arrayDeGenes[] = new int[cantidadDeGenes];
	private Random rnd = new Random();
	private long valorDecimal;
	private double valorFuncionObjetivo;
	private String cromosoma;
	private double valorFitness;
	
	public int[] getArrayDeGenes() {
		return arrayDeGenes;
	}

	public void setArrayDeGenes(int[] arrayDeGenes) {
		this.arrayDeGenes = arrayDeGenes;
	}

	public double getValorFitness() {
		return valorFitness;
	}

	public void setValorFitness(double valorFitness) {
		this.valorFitness = valorFitness;
	}

	public String getCromosoma() {
		return cromosoma;
	}

	public void setCromosoma(String cromosoma) {
		this.cromosoma = cromosoma;
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

	public void setValorDecimal(long valorDecimal) {
		this.valorDecimal = valorDecimal;
	}

	public Cromosoma crearNuevoCromosoma() {
		for (int j = 0;j < cantidadDeGenes; j++){
			int x = rnd .nextInt(2);
			arrayDeGenes[j] = x;
		}
		
		return this;		
	}

	public void funcionObjetivo (){
		double coef = Math.pow(2, 30) - 1;
		double d = this.getValorDecimal() / coef;
		double valorFuncObj = Math.pow((d), 2);
		this.setValorFuncionObjetivo(valorFuncObj);
		//System.out.println("Funcion objective: " + valorFuncObj);
		//valorFuncionObjetivo = Math.rint(valorFuncionObjetivo*10000)/10000; //Limita a 4 decimales el valor.
	}

	
	public void calcularDecimal() {
		this.arrayToStringCromosoma();	
		Long decimal = Long.parseLong(this.getCromosoma(), 2);
		//System.out.println("Valor decimal: " + decimal);
		this.setValorDecimal(decimal);
		
		
	}

	private void arrayToStringCromosoma() {
		String cromosoma = "";
		for(int i = 0 ; i < cantidadDeGenes; i++){
			cromosoma = cromosoma + this.arrayDeGenes[i];
		}
		this.setCromosoma(cromosoma);
	}

	public void calcularFitness(double sumaFuncionObjetivo) {
		double fitness = this.getValorFuncionObjetivo() / sumaFuncionObjetivo;
		//fitness = Math.rint(fitness*10000)/10000;
		//System.out.println("Fitnesssss: " + fitness);
		this.setValorFitness(fitness);
		
	}
	
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
