package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class NuevoGreedy {
	
	

	public static void main(String[] args) {
		long time_start = System.currentTimeMillis();
	ArrayList<Elemento> almacen = new ArrayList<Elemento>();
	ArrayList<Elemento> mochila = new ArrayList<Elemento>();
	double  pesoMaximo=3000;
	
	//cargo productos
	almacen.add(new Elemento(1800,72));
    almacen.add(new Elemento(600, 36));
    almacen.add(new Elemento( 1200, 60));
	
    Double [] auxiliar= new Double[almacen.size()];
	for(int i=0;i<almacen.size();i++) {
		auxiliar [i]= almacen.get(i).relacion();
		}
	    Arrays.sort(auxiliar);  // ordena menor a mayor
	  
	    
	    //para ordenar de mayor a menor
	    
	    Double a;
        for (int i = 0; i < auxiliar.length / 2; i++) {
            a= auxiliar[i];
            auxiliar[i] = auxiliar[auxiliar.length - 1 - i];
            auxiliar[auxiliar.length - 1 - i] = a;
        }
        
	    //validacion y llenado de mochila
	    double pesoMochila=0;
	    double acum = 0;
	    int    posicion=0;
	    
	    
	    
	    // array con las relaciones, agrego par la relacion [1] el tmp,para la relacion en 2 si cumple que nos e lleno
	    while(pesoMochila<=pesoMaximo && posicion < auxiliar.length) { 
	        Elemento tmp = almacen.get(posicion);
	        
	    	for(int r=0; r<3;r++){// para cada relacion
	    		
	        if(pesoMochila + tmp.peso <= pesoMaximo) {
	        	
	        	System.out.println("Entra el objeto de:"+tmp.peso+"..gr y que vale $"+tmp.valor);
	            mochila.add(tmp);
	            acum=acum+tmp.valor;
	            pesoMochila+=tmp.peso;
	            
	        }
	        }
	   posicion++;}
	       
	    
	    long time_end = System.currentTimeMillis();
	    //muetra de resultados
	    for (int i=0;i<almacen.size();i++){	    
	    }
	    System.out.println("Peso mochila:"+pesoMochila);
	    System.out.println("valor total:"+acum);
	    System.out.println(">> Tiempo de duracion del proceso: "+ ( time_end - time_start ) +" milisegundos.");
    
	}//fin main
}//fin clase
