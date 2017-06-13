package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.*;

import ejercicio01.*;

public class ExportToExcel {
	//Variables para la exportacion de los datos
	private File archivo = new File("Informe.xlsx");
	private Workbook workbook = new HSSFWorkbook(); 
	private Sheet pagina = workbook.createSheet("Evolucion AG");
	private Sheet pagina2 = workbook.createSheet("GRAFICAS AG");
	private Row fila,fila2;
	private Cell celda,celda2;
	private int nroFila = 0, nroFila2=1;
	private String[] titulos = {"Poblacion 1", "Valor Decimal", 
            "Funcion Objetivo", "Funcion Fitness" };
	private int cantidadIteraciones = Ejercicio_01.cantidadDeCromosomas;
	private int cantidadDeCiclos = Ejercicio_01.cantidadDeCiclos;
	
	public ExportToExcel(Poblacion[] p){
		for(int i=0; i < cantidadDeCiclos ; i++){		
			//Hoja1
			titulos[0]="Poblacion "+(i+1);
			// Creamos el encabezado
			fila = pagina.createRow(nroFila);
			//Colocamos los titulos		
			for(int j = 0; j < titulos.length; j++) {
		        celda = fila.createCell(j);
		        
		        //celda.setCellStyle(style); 
		        celda.setCellValue(titulos[j]);
		    }		
			nroFila++;
			//Imrpimimos todos los datos de cada poblacion
			
			for(int num=nroFila; nroFila < (num+cantidadIteraciones); nroFila++) {
				// Ahora creamos una fila en la posicion 1
		        fila = pagina.createRow(nroFila);
		        
		        // Y colocamos los datos en esa fila
		        celda = fila.createCell(0);  
		        celda.setCellValue( p[i].getCromosomas()[nroFila-num].getCromosoma() );  
		        celda = fila.createCell(1);  
		        celda.setCellValue( p[i].getCromosomas()[nroFila-num].getValorDecimal() );
		        celda = fila.createCell(2);  
		        celda.setCellValue( p[i].getCromosomas()[nroFila-num].getValorFuncionObjetivo());
		        celda = fila.createCell(3);  
		        celda.setCellValue( p[i].getCromosomas()[nroFila-num].getValorFitness() );
			}
				
		    fila = pagina.createRow(nroFila);
		    
		    
		    // Y colocamos los datos en esa fila
		    
		    celda = fila.createCell(1);  
		    celda.setCellValue( "Suma" );
		    celda = fila.createCell(2);  
		    celda.setCellValue( p[i].getSumaFuncionObjetivo() );
		    
		    nroFila++;
		    
		    fila = pagina.createRow(nroFila);
		    
		    celda = fila.createCell(1);  
		    celda.setCellValue( "promedio" );
		    celda = fila.createCell(2);  
		    celda.setCellValue( p[i].getPromedio() );
		    
		    nroFila++;
		    
		    fila = pagina.createRow(nroFila);
		    
		    
		    celda = fila.createCell(1);  
		    celda.setCellValue( "máximo" );
		    celda = fila.createCell(2);  
		    celda.setCellValue( p[i].getMaximo() );
		    
		    nroFila++;
		    
		    fila = pagina.createRow(nroFila);
		    
		    
		 
		    
		    celda = fila.createCell(1);  
		    celda.setCellValue( "minimo" );
		    celda = fila.createCell(2);  
		    celda.setCellValue( p[i].getMinimo() );
		    
		    nroFila+=2;
		    //Fin hoja 1
		    
			//Hoja2
		    //Imprimo los titulos
		    fila2 = pagina2.createRow(0);
			
		    celda2 = fila2.createCell(1);
		    celda2.setCellValue("Promedio");
		    
		    celda2 = fila2.createCell(2);
		    celda2.setCellValue("Maximo");
		    
		    celda2 = fila2.createCell(3);
		    celda2.setCellValue("Minimo");
		    
		    celda2 = fila2.createCell(4);
		    celda2.setCellValue("Suma Funcion Obj.");
		    
		    fila2 = pagina2.createRow(nroFila2);
		    
		    
		    // Colocamos los datos que van en la grafica de cada poblacion
		    
		    celda2 = fila2.createCell(0);  
		    celda2.setCellValue( "Poblacion "+ (i+1) );
		    celda2 = fila2.createCell(1);  
		    celda2.setCellValue( p[i].getPromedio() );
		    celda2 = fila2.createCell(2);  
		    celda2.setCellValue( p[i].getMaximo() );
		    celda2 = fila2.createCell(3);  
		    celda2.setCellValue( p[i].getMinimo() );
		    celda2 = fila2.createCell(4);  
		    celda2.setCellValue( p[i].getSumaFuncionObjetivo() );
		    
		    nroFila2++;
		    
			//Fin hoja 2
		}
	    
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
	}
}
