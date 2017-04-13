import java.util.*;
import java.util.Random;

public class Ejercicio1 {

	public static void main(String[] args) {
		
		//Declaracion de variables
		int poblacion[][] = new int[10][30] ;
		

		//Programa
		for (int i = 0; i < 10; i++){
			for (int j = 0;j < 30; j++){
				Random rnd = new Random();
				int x = rnd.nextInt(2);
				poblacion[i][j] = x;
			}
			System.out.println(Arrays.toString(poblacion[i]));	
		}
		
		System.out.println("--------------------------------------------------------------");
		
		//int a=Integer.parseInt(Arrays.toString(poblacion[0]));
		//System.out.println(a);
		
		for(int h = 0; h < 10; h++){
			int entero = aEntero(poblacion[h]);
			System.out.println(entero);
		}
		
	}
	
	//Declaracion de metodos
	
	int objetivo (){
		int y;
		
		Random rnd = new Random();
		int coef = (int) ((Math.pow(2, 30))-1);
		int x = rnd.nextInt();
		
		y = (int)Math.pow( (x/coef) ,2);
				
		return y;
	}
	
	static int aEntero (int algo[])
	{
		int k=0, exp=0;
		
		for(int i = 29; i <= 0; i--){
			if(algo[i] == 1){
				k=k+(int) Math.pow(2, exp);
				exp++;
			}
		}
		return k;
	}
}

