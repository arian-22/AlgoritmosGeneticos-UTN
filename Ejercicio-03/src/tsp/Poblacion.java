package tsp;
import java.util.Arrays;
import java.util.Random;

public class Poblacion {
	private Cromosoma cromosomas[]=new Cromosoma[50];
	private Cromosoma padres[]=new Cromosoma[50];
	private double sumatoriaFuncionObjetivo=0;
	private int posicionInicial=0;
	
	
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
	public void calcularFitnessPoblacion() {
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
	public void calcularLosFitness()
	{
		
	}
	public void evolucionar(Poblacion pobAnterior) {
		// TODO Auto-generated method stub
		Random rnd=new Random();
		Cromosoma padres[]=new Cromosoma[50];
		padres=metodoDeLaRuleta(pobAnterior);
		
		for(int i=0;i<50;i+=2)
		{
			int crossover=1;
			double aleatorio=Math.random();
			if(aleatorio<=0.75)
			{
				crossover(padres[i],padres[i+1]);
			}
			else{
				setUnCromosoma(padres[i]);
				setUnCromosoma(padres[i+1]);
				System.out.println("no hubo crossover");
			}
			System.out.println("-------------------------------------");
			
		}
		for(int i=0;i<50;i++)
		{
			double random=Math.random();
			if(random<=0.05)
			{
				mutacion(this.cromosomas[i]);
			}
			else{
				//System.out.println("no hubo mutacion");
			}
		}
		
	}
	private Cromosoma[] metodoDeLaRuleta(Poblacion pobAnterior) {

		Cromosoma papas[]=new Cromosoma[50];
		Random rnd=new Random();
		Cromosoma cromosom[]=pobAnterior.getCromosomas();
		//System.out.println("el fitnees del primero es: "+cromosom[0]);
		System.out.println(cromosom[0].getRecorrido());
		
		for(int i=0;i<50;i++)
		{
			
			double inferior=0;
			//System.out.println("el fitness adentro es: "+cromosom[0].getFitness());
			double superior=0;
			
			superior=cromosom[0].getFitness();
			int posicion=0;
			boolean p=true;
			double random = Math.random();
		
		
		
			while (p)
				
				
			{
				
				
			if(random>inferior && random<superior)
			{
				papas[i]=cromosom[posicion];
				
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
	
	public void crossover (Cromosoma c1, Cromosoma c2)
	{
		Random rnd=new Random();
		int nroAzar = rnd.nextInt(22);
		System.out.println(" >>> Corta en: " + (nroAzar)+" <<<");
		Cromosoma hijo1 = new Cromosoma();
		Cromosoma hijo2 = new Cromosoma();
		Cromosoma hijoaux = new Cromosoma();
		hijoaux = hijo1;
		
		System.out.println("- - - - - - - - - - - -");
		System.out.println("Cromosoma padre 1: "+c1.getCiudades());
		System.out.println("Cromosoma padre 2: "+c2.getCiudades());
		
		
		// antes del corte copia el padre en el hijo  //
		for(int i=0; i<=nroAzar; i++){
			hijo1.setUnaCiudad(i,c1.getCiudades()[i]);
			hijo2.setUnaCiudad(i,c2.getCiudades()[i]);
		}
				
				nroAzar++;
				int nroAzar2=nroAzar;
		// despues del corte reviso que no se repitan //
		for(int i=0; i <23; i++)
		{
			if(Arrays.asList(hijo1.getCiudades()).contains(c2.getCiudades()[i])==false)
			{
				hijo1.setUnaCiudad(nroAzar,c2.getCiudades()[i]);
				nroAzar++;
			}
			if(Arrays.asList(hijo2.getCiudades()).contains(c1.getCiudades()[i])==false)
			{
				hijo2.setUnaCiudad(nroAzar2,c1.getCiudades()[i]);
				nroAzar2++;
			}
			
		} setUnCromosoma(hijo1);
		setUnCromosoma(hijo2);
			
	}
	
	private void setUnCromosoma(Cromosoma cromo)
	{
		this.cromosomas[this.posicionInicial]=cromo;
		posicionInicial++;
		}
	public void mutacion(Cromosoma c1)
	{
		Random rnd=new Random();
		int pos1= (int)(rnd.nextDouble() * 23);
		int pos2= (int)(rnd.nextDouble() * 23);
		
		Ciudad aux = c1.getCiudades()[pos1];
		c1.setUnaCiudad(pos1,c1.getCiudades()[pos2]);
		c1.getCiudades() [pos2] = aux;
		
		}
		
		
		
		//System.out.println("hijo"+c1.getCiudades());
	}

