package tsp;
import java.util.Arrays;
import java.util.Random;

public class Poblacion {
	private Cromosoma cromosomas[]=new Cromosoma[50];
	private Cromosoma padres[]=new Cromosoma[50];
	private double sumatoriaFuncionObjetivo=0;
	
	public Cromosoma[] getCromosomas() {
		return cromosomas;
	}
	public void setCromosoma(Cromosoma cromo,int posicion)
	{
		this.cromosomas[posicion]=cromo;
		
	}
	public void setCromosomas(Cromosoma[] cromosomas) {
		this.cromosomas = cromosomas;
	}
	public void GenerarPoblacionInicial(Ciudad[] ciuds)
	{
		
		for(int i=0;i<50;i++)
		{
			Cromosoma cromo=new Cromosoma();
			System.out.println("------------------------------------------cromosoma: "+(i+1));
			cromo.asignarCiudadesAleatorias(ciuds);
			cromo.calcularFuncionObjetivo();
			this.cromosomas[i]=cromo;
			
			
			
		}
		calcularSumatoria();
		calcularFitnessPoblacion();
		
	}
	private void calcularFitnessPoblacion() {
		// TODO Auto-generated method stub
		for (int i=0;i<50;i++)
		{
			this.cromosomas[i].calcularFitness(sumatoriaFuncionObjetivo);
		}
	}
	public void calcularSumatoria()
	{
		for (int i=0;i<50;i++)
		{
			this.sumatoriaFuncionObjetivo+=this.cromosomas[i].getFuncionObjetivo();
		}
		
	}
	public void evolucionar(Poblacion pobAnterior) {
		// TODO Auto-generated method stub
		Cromosoma padres[]=new Cromosoma[50];
		padres=metodoDeLaRuleta(pobAnterior);
		
	}
	private Cromosoma[] metodoDeLaRuleta(Poblacion pobAnterior) {

		Cromosoma papas[]=new Cromosoma[50];
		Random rnd=new Random();
		Cromosoma cromosom[]=pobAnterior.getCromosomas();
		System.out.println("el fitnees del primero es: "+cromosom[0]);
				
		for(int i=0;i<50;i++)
		{
			
			double inferior=0;
			System.out.println("el fitness adentro es: "+cromosom[0].getFitness());
			double superior=0;
			superior=cromosom[0].getFitness();
			int posicion=0;
			boolean p=true;
			double random = Math.random();
		
		
		
			while (p)
				
			{
				
				
			if(random>inferior && random<superior)
			{
				padres[i]=cromosom[posicion];
				
				//paresDePadres[i].setArrayDeGenes(valoresEnRuleta[posicion].getArrayDeGenes());
				p=false;
			}
			else
			{
				if(posicion<49)
				{
				inferior=superior;
				superior=superior+cromosom[posicion+1].getFitness();
				
				
				}
			}
			
			if(p)
			{
				
				posicion++;
				
			}
			}
					}
		return papas;
		

	}
}

