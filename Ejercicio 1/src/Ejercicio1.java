import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.*;
//import org.apache.poi.xssf.usermodel.*;

public class Ejercicio1 {

	private static double Crossover = 0.75;
	private static double Mutacion = 0.05;
	public static int cantidadCiclos = 10;
	public static int cantidadIteraciones = 6;
	private static Scanner scan; 
	
	public static void main(String[] args) {
		
		scan = new Scanner(System.in);
		long time_start, time_end;
		Poblacion Poblaciones[] = new Poblacion[cantidadCiclos];
		
		/*
		 * Programa principal
		 * */
		
		//Creacion de la poblacion inicial.
		
		time_start = System.currentTimeMillis();
		Poblacion p = new Poblacion();

		System.out.println("-------------------------------------------------------");
		System.out.println("******************** POBLACIÓN #1 *********************");
		System.out.println("-------------------------------------------------------");
		
		for (int i = 0; i < cantidadIteraciones; i++){
			Cromosoma c = new Cromosoma();
			System.out.println("-Cromosoma #" + (i+1));
			c.inicializar();
			p.añadirCromosoma(c);
			System.out.println();
		}
		p.inicializar();
		p.evolucionarGeneticamente();
		
		Poblaciones[0] = p;
		
		for(int i = 1; i < cantidadCiclos; i++){
			System.out.println("-------------------------------------------------------");
			System.out.println("******************** POBLACIÓN #"+(i+1)+" *********************");
			System.out.println("-------------------------------------------------------");
			
			p = Poblaciones[i-1];
			
			for (int j = 0; j < cantidadIteraciones; j++){
				System.out.println("-Cromosoma #" + (j+1));
				p.getCromosomas().get(j).aEntero();
			}
			p.inicializar();
			p.evolucionarGeneticamente();
			
			Poblaciones[i] = p;
		}
		time_end = System.currentTimeMillis();
		System.out.println("-------------------------------------------------------");
		System.out.println();
		System.out.println();
		System.out.println(">> Tiempo de duración del proceso: "+ ( time_end - time_start ) +" milisegundos.");
		
		System.out.println();
		System.out.println();
		System.out.println("<<<<<<---------------------------------->>>>>>");
		
		System.out.println("Desea exportar toda la evolución genética a un arhivo?");
		System.out.print("Ingrese Si (s) ó No (n): ");
		String imprime = scan.next();
		if (imprime.equals("S") || imprime.equals("s")){
			System.out.println("Imprime.");
			
			//Generacion del archivo de EXCEL
			File archivo = new File("Informe.xlsx");
			Workbook workbook = new HSSFWorkbook(); 
			Sheet pagina = workbook.createSheet("Evolución AG");
						
			// Creamos el estilo paga las celdas del encabezado
	        CellStyle style = workbook.createCellStyle();
	        // Indicamos que tendra un fondo azul aqua
	        // con patron solido del color indicado
	        style.setFillForegroundColor(IndexedColors.AQUA.getIndex());
	        
	        String[] titulos = {"Identificador", "Consumos", 
	                            "Precio Venta", "Precio Compra" };
	        Double[] datos = {1.0, 10.0, 45.5, 25.50};        
	        
	        // Creamos una fila en la hoja en la posicion 0
	        Row fila = pagina.createRow(0);
	        
	        // Creamos el encabezado
	        for(int i = 0; i < titulos.length; i++) {
	            // Creamos una celda en esa fila, en la posicion 
	            // indicada por el contador del ciclo
	            Cell celda = fila.createCell(i);
	            
	            // Indicamos el estilo que deseamos 
	            // usar en la celda, en este caso el unico 
	            // que hemos creado
	            celda.setCellStyle(style); 
	            celda.setCellValue(titulos[i]);
	        }		

	        // Ahora creamos una fila en la posicion 1
	        fila = pagina.createRow(1);
	        
	        // Y colocamos los datos en esa fila
	        for(int i = 0; i < datos.length; i++) {
	            // Creamos una celda en esa fila, en la
	            // posicion indicada por el contador del ciclo
	            Cell celda = fila.createCell(i);
	            
	            celda.setCellValue( datos[i] );        
	        }
			
			// Ahora guardaremos el archivo
	        try {
	            // Creamos el flujo de salida de datos, apuntando al archivo donde queremos almacenar el libro de Excel
	            FileOutputStream salida = new FileOutputStream(archivo);
	            // Almacenamos el libro de Excel via ese flujo de datos
	            workbook.write(salida);
	            
	            // Cerramos el libro para concluir operaciones
	            workbook.close();
	         
	            System.out.println("Archivo creado existosamente en " + archivo.getAbsolutePath());  
	        }catch (FileNotFoundException ex) {
	            System.out.println("Archivo no localizable en sistema de archivos");
	        }catch (IOException ex) {
	            System.out.println("Error de entrada/salida");
	        }  
		}else{
			if(imprime.equals("N") || imprime.equals("n")){
				System.out.println("No imprime.");
			}else{
				System.out.println("Error. Vuelva a ingresar la opción: ");
			}
		}
	}
	
	//Declaracion de metodos
	
	public static double getMutacion() {
		return Mutacion;
	}

	public static double getCrossover() {
		return Crossover;
	}
}