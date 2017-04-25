import java.util.Arrays;
import java.util.Random;

public class Cromosoma {
	
	private int arrayCromo[]=new int[30];
	private String cromosoma="";
	private int decimal;
	private double fitness;
	private Random rnd=new Random();
	
	
	Cromosoma(){
		
	}
	
	public int getdecimal() {
		return decimal;
	}

	public void setdecimal(int decimal) {
		this.decimal = decimal;
	}

	public double getFitness() {
		return fitness;
	}

	public void setFitness(double fitness) {
		this.fitness = fitness;
	}
	
	public void crearBinario(){
		for (int j = 0;j < 30; j++){
			int x = rnd.nextInt(2);
			arrayCromo[j] = x;
		}
	}
	
	public void aEntero (){
			
		this.devuelveBinario();	
		decimal = Integer.parseInt(cromosoma, 2);
	}
	
	public void devuelveBinario(){
		for(int i = 0 ; i < 30; i++){
			cromosoma = cromosoma +arrayCromo [i];}
		}
	public void inicializar(){
		
		this.aEntero();
		
	}

}
