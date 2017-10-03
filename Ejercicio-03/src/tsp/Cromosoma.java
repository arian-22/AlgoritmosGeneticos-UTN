package tsp;
import java.util.Random;
import java.util.Arrays;
import java.util.List;

public class Cromosoma {
	private double funcionObjetivo;
	private double fitness;
	private double recorrido;
	
	public double getRecorrido() {
		return recorrido;
	}
	public void setRecorrido(double recorrido) {
		this.recorrido = recorrido;
	}
	private Ciudad ciudades[]=new Ciudad[23];
	public void calcularFuncionObjetivo()
	{
		int recorrido=0;
		for (int i=0;i<23;i++)
		{
				if(i!=22)
				{
				recorrido+=this.ciudades[i].getDistancia(ciudades[i+1].getNombre());
				}
		}
		System.out.println("el recorrido es"+recorrido);
		this.funcionObjetivo=100000/(double)recorrido;
		System.out.println("----------------------------funcion objetivo= "+ funcionObjetivo);
		this.recorrido=recorrido;
	}
	public void asignarCiudadesAleatorias(Ciudad[] ciuds)
	{
		 Random rnd=new Random();
		 int cont=0;
		 do
		 {
			int aleatorio= (int)(rnd.nextDouble() * 23);
			
			if(Arrays.asList(ciudades).contains(ciuds[aleatorio])==false)
			{
				this.ciudades[cont]=ciuds[aleatorio];
				cont++;
								
			}
		 }while(cont<=22);
		 
	 }
	public void calcularFitness(double sumatoria)
	{
		this.fitness=funcionObjetivo/sumatoria;

	}
	public double getFuncionObjetivo() {
		return funcionObjetivo;
	}
	public void setFuncionObjetivo(double funcionObjetivo) {
		this.funcionObjetivo = funcionObjetivo;
	}
	public Ciudad[] getCiudades() {
		return ciudades;
	}
	public void setCiudades(Ciudad[] ciudades) {
		this.ciudades = ciudades;
	}
	public void setUnaCiudad(int pos,Ciudad ciu)
	{
		this.ciudades[pos]=ciu;
	}
	public double getFitness() {
		return fitness;
	}
	public void setFitness(double fitness) {
		this.fitness = fitness;
	}
}
