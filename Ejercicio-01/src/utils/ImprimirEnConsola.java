package utils;

import ejercicio01.Poblacion;

public class ImprimirEnConsola {

	public ImprimirEnConsola(Poblacion[] poblaciones) {
		for(int i=0 ; i < poblaciones.length; i++){
			System.out.println("<---------- Poblacion #"+(i+1)+" ---------->");
			System.out.println("");
			System.out.println("Lista de cromosomas de la poblacion:");
			for(int j=0 ; j < poblaciones[i].getCromosomas().length ; j++){
				System.out.println("  Cromosoma #"+(j+1));
				System.out.println("    Binario: "+poblaciones[i].getCromosomas()[j].getCromosoma());
				System.out.println("    Decimal: "+poblaciones[i].getCromosomas()[j].getValorDecimal());
				System.out.println("    Valor func. objetivo:"+poblaciones[i].getCromosomas()[j].getValorFuncionObjetivo());
				System.out.println("    Valor Fitness: "+poblaciones[i].getCromosomas()[j].getValorFitness());
			} 
			System.out.println("Datos de la poblacion:");
			System.out.println("  Maximo: " + poblaciones[i].getMaximo());
			System.out.println("  Minimo: " + poblaciones[i].getMinimo());
			System.out.println("  Suma de la Funcion objetivo: " + poblaciones[i].getSumaFuncionObjetivo());
			System.out.println("  Promedio: " + poblaciones[i].getPromedio());
			System.out.println();
		}
	}
	
	public ImprimirEnConsola(Poblacion poblaciones, int i) {
		System.out.println();
		System.out.println("<---------- Poblacion #"+(i+1)+" ---------->");
		System.out.println("");
		System.out.println("Lista de cromosomas de la poblacion:");
		for(int j=0 ; j < poblaciones.getCromosomas().length ; j++){
			System.out.println("  Cromosoma #"+(j+1));
			System.out.println("    Binario: "+poblaciones.getCromosomas()[j].getCromosoma());
			System.out.println("    Decimal: "+poblaciones.getCromosomas()[j].getValorDecimal());
			System.out.println("    Valor func. objetivo:"+poblaciones.getCromosomas()[j].getValorFuncionObjetivo());
			System.out.println("    Valor Fitness: "+poblaciones.getCromosomas()[j].getValorFitness());
		} 
		System.out.println("Datos de la poblacion:");
		System.out.println("  Maximo: " + poblaciones.getMaximo());
		System.out.println("  Minimo: " + poblaciones.getMinimo());
		System.out.println("  Suma de la Funcion objetivo: " + poblaciones.getSumaFuncionObjetivo());
		System.out.println("  Promedio: " + poblaciones.getPromedio());
		System.out.println();
	}
}
