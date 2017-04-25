
public class Cromosoma {
	private int num;
	private double fitness;
	
	Cromosoma(int x, double y ){
		num=x;
		fitness=y;
		
	}
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public double getFitness() {
		return fitness;
	}

	public void setFitness(double fitness) {
		this.fitness = fitness;
	}

	

}
