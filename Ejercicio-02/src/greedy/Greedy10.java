package greedy;

import java.util.*;
 
public class Greedy10 {
    static Vector<Elemento> almacen = new Vector<Elemento>();
    static Vector<Elemento> mochila = new Vector<Elemento>();
    final static double  pesoMaximo=4200;
 
    public static void main(String[] args) {
        
    	long time_start = System.currentTimeMillis();
    
    	cargarDatos();
        resolverProblema();
        mostrarMochila();
        
        long time_end = System.currentTimeMillis();
        System.out.println();
        System.out.println("-------------------------------------------------------");
		System.out.println();
		System.out.println();
		System.out.println(">> Tiempo de duracion del proceso: "+ ( time_end - time_start ) +" milisegundos.");
    }
 
           
    public static void cargarDatos() {
        almacen.add(new Elemento(150,20));
        almacen.add(new Elemento(325, 50));
        almacen.add(new Elemento( 600, 50));
        almacen.add(new Elemento( 805,  36));
        almacen.add(new Elemento(430,  25));
        almacen.add(new Elemento( 1200,  64));
        almacen.add(new Elemento( 770,  54));
        almacen.add(new Elemento( 60,  18));
        almacen.add(new Elemento(930,  46));
        almacen.add(new Elemento( 353,  28));
    }
 
    public static void mostrarMochila() {
    	double pesoMochila=0;
    	double valorMochila=0;
    	System.out.println();
    	for(Elemento e: mochila) {
    		System.out.println(e);
    		pesoMochila+=e.peso;
    		valorMochila+=e.valor;
    	}
    	System.out.println("------");
    	System.out.printf("Peso  = %,12.2f %n", pesoMochila);
    	System.out.printf("Valor = %,12.2f %n", valorMochila);
    }
 
    
    public static void resolverProblema() {
	    // Comparador para ordenar los elementos del almacen por valor
	    Comparator cmp = new Comparator<Elemento>() {
	        public int compare(Elemento x, Elemento y) {
	            return (int) (x.valor/x.peso - y.valor/y.peso);
	        }
	    };
	    Collections.sort(almacen,cmp);  // ordena usando el comparador anterior
	    Collections.reverse(almacen);   // reversa el orden de los elementos
	 
	    double pesoMochila=0;
	    int    posicion=0;
	    while(pesoMochila<pesoMaximo && posicion < almacen.size()) {
	        Elemento tmp = almacen.get(posicion);
	        if(pesoMochila + tmp.peso <= pesoMaximo) {
	            mochila.add(tmp);
	            pesoMochila+=tmp.peso;
	        }
	        posicion++;
	    }
	}

}