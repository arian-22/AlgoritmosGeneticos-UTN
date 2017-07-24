import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.*;

public class Ejercicio1 {

	private static double Crossover = 0.75;
	private static double Mutacion = 0.05;
	public static int cantidadCiclos =10;
	public static int cantidadIteraciones = 10;
	
	public static void main(String[] args) {
		
		long time_start, time_end;
		Poblacion Poblaciones[] = new Poblacion[cantidadCiclos];
		
		/*Para exportar al excel */
		File archivo = new File("Informe.xlsx");
		Workbook workbook = new HSSFWorkbook(); 
		Sheet pagina = workbook.createSheet("Evolucion AG");
		Sheet pagina2 = workbook.createSheet("GRAFICAS AG");
		Row fila,fila2;
		Cell celda,celda2;
		int nroFila = 0, nroFila2=0;
		String[] titulos = {"Poblacion 1", "Valor Decimal", 
                "Funcion Objetivo", "Funcion Fitness" };
		
		/*
		  Programa principal
		 * */
		
		//Creacion de la poblacion inicial.
		
		time_start = System.currentTimeMillis();
		Poblacion p = new Poblacion();

		System.out.println("-------------------------------------------------------");
		System.out.println("******************** POBLACION #1 *********************");
		System.out.println("-------------------------------------------------------");
		
		//Creacion de la poblaicon inicial
		for (int i = 0; i < cantidadIteraciones; i++){
			Cromosoma c = new Cromosoma();
			System.out.println("-Cromosoma #" + (i+1));
			c.inicializar();
			p.aniadirCromosoma(c);
			System.out.println();
		}
		p.inicializar();
			
		//Hoja1
		// Creamos el encabezado
		fila = pagina.createRow(nroFila);
		
		
		
		for(int i = 0; i < titulos.length; i++) {
            celda = fila.createCell(i);
            
            //celda.setCellStyle(style); 
            celda.setCellValue(titulos[i]);
        }		
		
		for(nroFila = 1; nroFila < (1+cantidadIteraciones); nroFila++) {
			// Ahora creamos una fila en la posicion 1
	        fila = pagina.createRow(nroFila);
	        
	        // Y colocamos los datos en esa fila
	        
	        celda = fila.createCell(0);  
	        celda.setCellValue( p.getCromosomas().get(nroFila-1).getCromosoma() );  
	        celda = fila.createCell(1);  
	        celda.setCellValue( p.getCromosomas().get(nroFila-1).getValorDecimal() );
	        celda = fila.createCell(2);  
	        celda.setCellValue( p.getCromosomas().get(nroFila-1).getValorFuncionObjetivo() );
	        celda = fila.createCell(3);  
	        celda.setCellValue( p.getCromosomas().get(nroFila-1).getFitness() );
		}
			
        fila = pagina.createRow(nroFila);
        
        
        // Y colocamos los datos en esa fila
        
        celda = fila.createCell(1);  
        celda.setCellValue( "Suma" );
        celda = fila.createCell(2);  
        celda.setCellValue( p.getSuma() );
        
	    nroFila++;
	    
        fila = pagina.createRow(nroFila);
        
        
      
        
        celda = fila.createCell(1);  
        celda.setCellValue( "promedio" );
        celda = fila.createCell(2);  
        celda.setCellValue( p.getPromedio() );
        
        nroFila++;
        
        fila = pagina.createRow(nroFila);
        
        
        celda = fila.createCell(1);  
        celda.setCellValue( "máximo" );
        celda = fila.createCell(2);  
        celda.setCellValue( p.getMaximo() );
        
        nroFila++;
        
        fila = pagina.createRow(nroFila);
        
        
     
        
        celda = fila.createCell(1);  
        celda.setCellValue( "minimo" );
        celda = fila.createCell(2);  
        celda.setCellValue( p.getMinimo() );
        
        nroFila+=2;
        //Fin hoja 1
		
		//Hoja2
        fila2 = pagina2.createRow(nroFila2);
		
        celda2 = fila2.createCell(1);
        celda2.setCellValue("Promedio");
        
        celda2 = fila2.createCell(2);
        celda2.setCellValue("Suma");
        
        celda2 = fila2.createCell(3);
        celda2.setCellValue("Maximo");
        
        celda2 = fila2.createCell(4);
        celda2.setCellValue("Minimo");
		
        
        nroFila2++;
        
        
        fila2 = pagina2.createRow(nroFila2);
        
        
        // Y colocamos los datos en esa fila
        
        celda2 = fila2.createCell(0);  
        celda2.setCellValue( "Poblacion 1" );
        celda2 = fila2.createCell(1);  
        celda2.setCellValue( p.getPromedio() );
        celda2 = fila2.createCell(2);  
        celda2.setCellValue( p.getSuma() );
        celda2 = fila2.createCell(3);  
        celda2.setCellValue( p.getMaximo() );
        celda2 = fila2.createCell(4);  
        celda2.setCellValue( p.getMinimo() );
        
        nroFila2++;
        
		//Fin hoja 2
		
		
		Poblaciones[0] = p;
		Poblacion pob; // = Poblaciones[0];
		
		for(int i = 1; i < cantidadCiclos; i++){
			System.out.println("-------------------------------------------------------");
			System.out.println("******************** POBLACION #"+(i+1)+" *********************");
			System.out.println("-------------------------------------------------------");
			
			pob = new Poblacion();
			pob = Poblaciones[i-1];
			
			pob.evolucionarGeneticamente();
			
			System.out.println();
			for (int j = 0; j < cantidadIteraciones; j++){
				System.out.println("-Cromosoma #" + (j+1));
				pob.getCromosomas().get(j).aEntero();
				
			}
			
			pob.inicializar();
			
			
			//Hola 1
			titulos[0]="Poblacion "+(i+1);
			
			fila = pagina.createRow(nroFila);
			
			for(int z = 0; z < titulos.length; z++) {
	            celda = fila.createCell(z);
	            
	            //celda.setCellStyle(style); 
	            celda.setCellValue(titulos[z]);
	        }		
			nroFila++;
			
			for(int num=nroFila; nroFila < num+cantidadIteraciones; nroFila++) {
				// Ahora creamos una fila en la posicion 1
		        fila = pagina.createRow(nroFila);
		        
		        // Y colocamos los datos en esa fila
		        
		        celda = fila.createCell(0);  
		        
		        celda.setCellValue( pob.getCromosomas().get(nroFila-num).getCromosoma() );  
		        celda = fila.createCell(1);  
		        celda.setCellValue( pob.getCromosomas().get(nroFila-num).getValorDecimal() );
		        celda = fila.createCell(2);  
		        celda.setCellValue( pob.getCromosomas().get(nroFila-num).getValorFuncionObjetivo() );
		        celda = fila.createCell(3);  
		        celda.setCellValue( pob.getCromosomas().get(nroFila-num).getFitness() );
			}
			
				// Ahora creamos una fila en la posicion 1
				
		        fila = pagina.createRow(nroFila);
		        
		        
		        // Y colocamos los datos en esa fila
		        
		        celda = fila.createCell(1);  
		        celda.setCellValue( "Suma" );
		        celda = fila.createCell(2);  
		        celda.setCellValue( pob.getSuma() );
		        
		    nroFila++;
		    
	        fila = pagina.createRow(nroFila);
	        
	        
	      
	        
	        celda = fila.createCell(1);  
	        celda.setCellValue( "promedio" );
	        celda = fila.createCell(2);  
	        celda.setCellValue( pob.getPromedio() );
	        
	        nroFila++;
	        
	        fila = pagina.createRow(nroFila);
	        
	        
	       
	        
	        celda = fila.createCell(1);  
	        celda.setCellValue( "máximo" );
	        celda = fila.createCell(2);  
	        celda.setCellValue( pob.getMaximo() );
	        
	        nroFila++;
	        
	        fila = pagina.createRow(nroFila);
	        
	        
	     
	        
	        celda = fila.createCell(1);  
	        celda.setCellValue( "minimo" );
	        celda = fila.createCell(2);  
	        celda.setCellValue( pob.getMinimo() );
					
			nroFila +=2;
			
			//Fin hoja 1
			
			//Hoja 2
			 fila2 = pagina2.createRow(nroFila2);
		        
	        
	        // Y colocamos los datos en esa fila
	        
	        celda2 = fila2.createCell(0);  
	        celda2.setCellValue( "Poblacion " + (i+1) );
	        celda2 = fila2.createCell(1);  
	        celda2.setCellValue( pob.getPromedio() );
	        celda2 = fila2.createCell(2);  
	        celda2.setCellValue( pob.getSuma() );
	        celda2 = fila2.createCell(3);  
	        celda2.setCellValue( pob.getMaximo() );
	        celda2 = fila2.createCell(4);  
	        celda2.setCellValue( pob.getMinimo() );
	        
	        nroFila2++;
	        
			//Fin hoja 2
			
			
			
			Poblaciones[i] = pob;
			
			//p.evolucionarGeneticamente();
			
			p = null;
			
		}
		time_end = System.currentTimeMillis();
		
		System.out.println("-------------------------------------------------------");
		System.out.println();
		System.out.println();
		System.out.println(">> Tiempo de duracion del proceso: "+ ( time_end - time_start ) +" milisegundos.");
		
		System.out.println();
		System.out.println();
		System.out.println("<<<<<<---------------------------------->>>>>>");
		
		/*System.out.println("RESULTADOS\n");
		for(int h = 0; h < cantidadIteraciones; h++){
			System.out.println("Poblacion #" + (h+1));
			System.out.println("Promedio: " + Poblaciones[h].getPromedio());
			System.out.println("Maximo: " + Poblaciones[h].getMaximo());
			System.out.println("Minimo: " + Poblaciones[h].getMinimo());
			System.out.println();
		}
		
		
		System.out.println();
		System.out.println();
		System.out.println("<<<<<<---------------------------------->>>>>>");*/
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
		
		
		
		/*System.out.println("Desea exportar toda la evolucion genetica a un arhivo?");
		System.out.print("Ingrese Si (s) o No (n): ");
		String imprime = scan.next();
		if (imprime.equals("S") || imprime.equals("s")){
			System.out.println("Imprime.");*/
			
			
		 	
		 
		 
	         
	     /*       System.out.println("Archivo creado existosamente en " + archivo.getAbsolutePath());  
	        }catch (FileNotFoundException ex) {
	            System.out.println("Archivo no localizable en sistema de archivos");
	        }catch (IOException ex) {
	            System.out.println("Error de entrada/salida");
	        }  */
		/*}else{
			if(imprime.equals("N") || imprime.equals("n")){
				System.out.println("No imprime.");
			}else{
				System.out.println("Error. Vuelva a ingresar la opcion: ");
			}
		}*/
	}
	
	//Declaracion de metodos
	
	public static double getMutacion() {
		return Mutacion;
	}

	public static double getCrossover() {
		return Crossover;
	}
}