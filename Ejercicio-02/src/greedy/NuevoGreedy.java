package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class NuevoGreedy{
	//static ArrayList<Elemento> almacen = new ArrayList<Elemento>();
	private static Elemento[] almacen;
	static ArrayList<Elemento> mochila = new ArrayList<Elemento>();

	public static void main(String[] args) {
		double pesoMochila = 0;
		double acum = 0;
		double pesoMaximo = 0;
		int cantElementos = 0, op = 0;
		Scanner scan = new Scanner(System.in);
		
		long time_start = System.currentTimeMillis();
		
		System.out.println("¿Cual desea ejecutar?");
		System.out.println("1 - Greedy con 10 elementos");
		System.out.println("2 - Greedy con 3 elementos");
		System.out.print("Opcion: ");
		op = scan.nextInt(); 
		switch(op) {
			case 1:
				almacen = new Elemento[10];
				pesoMaximo = 4200;
				cargarDatos(1);
				cantElementos = 10;
				break;
			case 2:
				almacen = new Elemento[3];
				pesoMaximo = 3000;
				cargarDatos(2);
				cantElementos = 3;
				break;
			default:
				System.out.println("Opcion incorrecta. Intente de nuevo. ");
				break;
		}
		System.out.println();
		System.out.println("Opcion elejida: " + op);
		System.out.println("Cantidad elementos: " + cantElementos);
		System.out.println("Peso máximo: " + pesoMaximo);
		System.out.println();
		
		Arrays.sort(almacen);
		/*for(int i = 0 ; i < cantElementos ; i++) {
			System.out.println("#"+ i + " - " + almacen[i].getRelacion());
		}*/
		
	    //Validacion y llenado de mochila
		int posicion = 0;
		while((pesoMochila <= pesoMaximo) && (posicion < cantElementos)) { 
			
			Elemento tmp = new Elemento(almacen[posicion].getPeso(), almacen[posicion].getValor());
			
			if((pesoMochila + tmp.getPeso()) <= pesoMaximo) {  		    		
	    		System.out.println("Objeto entrante a la mochila");
				System.out.println("   --> Volumen: "+ tmp.getPeso() +" cm cubicos.");
				System.out.println("   --> Valor: $" + tmp.getValor());
				System.out.println("   --> Relacion: " + tmp.getRelacion());
				
	            mochila.add(tmp);
	            acum = acum + tmp.getValor();
	            pesoMochila += tmp.getPeso();
	    	}else {
	    		System.out.println("##### - El objeto en la pocision #"+ (posicion+1) + " excede el peso.");
	    		System.out.println("   --> Volumen: "+ tmp.getPeso() +" cm cubicos.");
				System.out.println("   --> Valor: $" + tmp.getValor());
				System.out.println("   --> Relacion: " + tmp.getRelacion());
	    	}
			
			System.out.println("*_* Peso actual de la mochila: " + pesoMochila);
		
		    posicion++;
		}
		       
		
		long time_end = System.currentTimeMillis();
		
		//Imprimir resultado		
		System.out.println();
		System.out.println("# Datos de la mochila:");
		System.out.println("   Volumen total: " +pesoMochila+ " cm cubicos.");
		System.out.println("   Valor total: $" +acum);
		
		System.out.println("");
		System.out.println("----------------------------------");
		System.out.println(">> Tiempo de duracion del proceso: "+ ( time_end - time_start ) +" milisegundos.");
	    
	}
	
	//Cargar datos de los elementos.
	public static void cargarDatos(int cant) {
		if(cant == 1) {
			almacen[0] = (new Elemento(150,20));
			almacen[1] = (new Elemento(325, 40));
			almacen[2] = (new Elemento( 600, 50));
			almacen[3] = (new Elemento( 805,  36));
			almacen[4] = (new Elemento(430,  25));
			almacen[5] = (new Elemento( 1200,  64));
			almacen[6] = (new Elemento( 770,  54));
			almacen[7] = (new Elemento( 60,  18));
			almacen[8] = (new Elemento(930,  46));
			almacen[9] = (new Elemento( 353,  28));				
		}else {
			almacen[0] = (new Elemento(1800,72));
		    almacen[1] = (new Elemento(600, 36));
		    almacen[2] = (new Elemento( 1200, 60));
		}
	}
}
