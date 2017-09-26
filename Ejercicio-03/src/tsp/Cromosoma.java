package tsp;
import java.util.Random;
import java.util.Arrays;
import java.util.List;

public class Cromosoma {
	private float FuncionObjetivo;
	private Ciudad ciudades[]=new Ciudad[23];
	public void calcularFuncionObjetivo()
	{
		int recorrido=0;
		for (int i=0;i<22;i++)
		{
				recorrido+=this.ciudades[i].getDistancia(ciudades[i+1].getNombre());
			
		}
		this.FuncionObjetivo=10000/recorrido;
	}
	public void asignarCiudadesAleatorias(Ciudad[] ciuds)
	{
		 Random rnd=new Random();
		 for(int i=0;i<23;i++)
		 {
			int aleatorio= (int)(rnd.nextDouble() * 22);
			
		 }
		 
			 
		 
		 
	}

}
