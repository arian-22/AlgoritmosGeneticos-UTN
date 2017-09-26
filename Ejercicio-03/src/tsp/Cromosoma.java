package tsp;
import java.util.Random;
import java.util.Arrays;
import java.util.List;

public class Cromosoma {
	private double funcionObjetivo;
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
				System.out.println("entre al if");
				this.ciudades[cont]=ciuds[aleatorio];
				
				System.out.println("ciudade numero: "+(cont+1)+ciudades[cont].getNombre());
				
				cont++;
				
				
				
			}
		 }while(cont<=22);
		 
			 
		 
		 
	}

}
