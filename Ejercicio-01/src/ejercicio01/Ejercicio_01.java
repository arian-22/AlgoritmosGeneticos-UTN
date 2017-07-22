package ejercicio01; 

import java.util.Scanner;
import utils.*;

public class Ejercicio_01 {
	/*Definicion de variables de clase*/
	public static int cantidadDeCromosomas = 10;
	public static int cantidadDeCiclos = 15;
	private static double Crossover = 0.75;
	private static double Mutacion = 0.05;
		
	public static void main(String[] args) {
		/*Definicion de variables de instancia*/
		//Variables auxiliares
		Scanner scan = new Scanner(System.in);
		boolean elitismo = false;
		
		@SuppressWarnings("unused")
		ImprimirEnConsola print;
		
		//Variables para el desarrollo del programa
		Poblacion poblaciones[] = new Poblacion[cantidadDeCiclos];
		
				
		/*Programa principal*/
		
		//Preguntar si desea modificar las variables del ejercicio
		System.out.print("¿Desea cambiar las variables del ejercicio dado? (S/N): ");
		String cambiaVariables = scan.next();
		if (cambiaVariables.equals("S") || cambiaVariables.equals("s")){
			System.out.print("Ingrese cantidad de cromosomas: ");
			cantidadDeCromosomas = scan.nextInt();
			System.out.print("Ingrese cantidad de ciclos: ");
			cantidadDeCiclos = scan.nextInt();
			System.out.print("Ingrese probabilidad de Crossover: ");
			Crossover = scan.nextDouble();
			System.out.print("Ingrese probabilidad de Mutacion: ");
			Mutacion = scan.nextDouble();
			
			System.out.println("Variables modificadas:");
			
		}
		System.out.println("    Cant. cromosomas: "+ cantidadDeCromosomas);
		System.out.println("    Cant. iteraciones: " + cantidadDeCiclos);
		System.out.println("    Crossover: " + Crossover);
		System.out.println("    Mutacion: " + Mutacion);
	//	
		//Preguntar si desea realizarla con elitismo
		System.out.print("¿Desea realizar con Elitismo? (S/N): ");
		String realizaConElitismo = scan.next();
		if (realizaConElitismo.equals("S") || realizaConElitismo.equals("s")){
			elitismo = true;
			Poblacion.setElitismo(elitismo);
		}

		
		/*Crar poblacion inicial*/
		poblaciones[0] = new Poblacion();
		//Inicializar todos los datos
		poblaciones[0].crearPoblacionInicial();
		//Calcular los valores de la poblacion
		poblaciones[0].calcularValoresDeLaPoblacion();
		print = new ImprimirEnConsola(poblaciones[0], 0);
		
		/*Una vez que esta la poblacion, someterla a la evolucion genetica*/
		for(int i=1; i < cantidadDeCiclos ; i++){
			poblaciones[i] = new Poblacion();
			//Evolucionar Geneticamente
			poblaciones[i] = evolucionGenetica(poblaciones[i-1]);
			
			//Reinicializar los datos de la poblacion actual
			poblaciones[i].calcularValoresDeLaPoblacion();
			print = new ImprimirEnConsola(poblaciones[i], i);
		}
				
			
		
		//Preguntar si desea emitir informe
		System.out.println("¿Que desea imprimir? ");
		System.out.println("1 - Imprimir en consola");
		System.out.println("2 - Imprimir excel");
		System.out.println("3 - Imprimir ambas");
		System.out.print("Opcion seleccionada: ");
		int imprime = scan.nextInt();
		System.out.println();
		switch(imprime){
		case 1:
			@SuppressWarnings("unused") 
			ImprimirEnConsola iec = new ImprimirEnConsola(poblaciones);
			break;
		case 2:
			@SuppressWarnings("unused") 
			ExportToExcel ete = new ExportToExcel(poblaciones);
			break;
		case 3:
			@SuppressWarnings("unused") 
			ImprimirEnConsola ic = new ImprimirEnConsola(poblaciones);
			@SuppressWarnings("unused") 
			ExportToExcel ee = new ExportToExcel(poblaciones);
			break;
		default:
			System.out.println("Opcion incorrecta");
			break;
		}
		scan.close();
		
	}

	private static Poblacion evolucionGenetica(Poblacion poblacionAnterior) {
		Poblacion poblacion = new Poblacion();
		poblacion.evolucionarGeneticamente(poblacionAnterior);		
		return poblacion;
		
	}

	public static double getMutacion() {
		return Mutacion;
	}

	public static double getCrossover() {
		return Crossover;
	}

}
