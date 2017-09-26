package tsp;

import java.util.Scanner;

public class TravelingSalesmanProblem {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int op = 0;
		
		System.out.println("Problema del Viajante");
		System.out.println("---------------------");
		System.out.println();
		
		System.out.println("Que desea ejecutar?");
		System.out.println("Busqueda con Heuristica");
		System.out.println("  1 - Buscar recorrido desde un punto de partida.");
		System.out.println("  2 - Obtener el recorrido optimo.");
		System.out.println("Busqueda con Algotimos Geneticos");
		System.out.println("  3 - Buscar recorrido desde un punto de partida.");
		System.out.println("  4 - Obtener el recorrido optimo.");
		System.out.print("Opcion: ");
		op = scan.nextInt(); 
		switch(op) {
			case 1:
				ViajeroHeuristico tspHeuristico = new ViajeroHeuristico();
				break;
			case 2:
				ViajeroHeuristico tspHeuristico2 = new ViajeroHeuristico(op);
				break;
			case 3:
				
				break;
			case 4:
				
				break;
			default:
				System.out.println("Opcion incorrecta. Intente de nuevo. ");
				break;
		}
		System.out.println();


		
	}

}
