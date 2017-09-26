package tsp;

public class Poblacion {
	private Cromosoma cromosomas[]=new Cromosoma[50];
	public void GenerarPoblacionInicial(Ciudad[] ciuds)
	{
		for(int i=0;0<50;i++)
		{
			Cromosoma cromo=new Cromosoma();
			cromo.asignarCiudadesAleatorias(ciuds);
			cromo.calcularFuncionObjetivo();
					
		}
	}

}
