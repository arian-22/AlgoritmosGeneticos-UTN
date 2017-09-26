package tsp;

public class Poblacion {
	private Cromosoma cromosomas[]=new Cromosoma[50];
	public void GenerarPoblacionInicial(Ciudad[] ciuds)
	{
		for(int i=0;i<50;i++)
		{
			Cromosoma cromo=new Cromosoma();
			System.out.println("------------------------------------------cromosoma: "+(i+1));
			cromo.asignarCiudadesAleatorias(ciuds);
			cromo.calcularFuncionObjetivo();
			
			
		}
	}

}
