package utils;

import java.io.File;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import ejercicio01.*;

public class ExportToExcel {
	//Variables para la exportacion de los datos
	File archivo = new File("Informe.xlsx");
	Workbook workbook = new HSSFWorkbook(); 
	Sheet pagina = workbook.createSheet("Evolucion AG");
	Sheet pagina2 = workbook.createSheet("GRAFICAS AG");
	Row fila,fila2;
	Cell celda,celda2;
	int nroFila = 0, nroFila2=0;
	String[] titulos = {"Poblacion 1", "Valor Decimal", 
            "Funcion Objetivo", "Funcion Fitness" };
	
	
	public ExportToExcel(Poblacion[] poblacion){
		System.out.println("Excel");
	}
}
