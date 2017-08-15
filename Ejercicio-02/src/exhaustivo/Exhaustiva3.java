package exhaustivo;

public class Exhaustiva3 {



		public static void main(String[] args) {
			long time_start = System.currentTimeMillis();
			int objetos[][] = new int[3][3];
			int vec[] =new int[3];
			int maxvec[] = new int[3];
			int max=0,i,j,k,a,acum,acump,maxp = 0,maxvol = 0;
			
			//Defino la matriz
			objetos[0][0]= 1; objetos[0][1]= 1800;objetos[0][2]= 72;
			objetos[1][0]= 2; objetos[1][1]= 600;objetos[1][2]= 36;
			objetos[2][0]= 3; objetos[2][1]= 1200;objetos[2][2]= 60;
			
			max=3000;
			
			for(i=0;i<2;i++){
				for(j=0;j<2;j++){
					for(k=0;k<2;k++){
						vec[0]= i;
						vec[1]= j;
						vec[2]= k;
							
	   					
	   					acum=0;
	   					acump=0;
	   					for (a=0;a<3;a++){
	   						if (vec[a]==1){
	   							acum=acum+objetos[a][1];
	   						}
	   					}
						if (acum<=max){
							for (a=0;a<3;a++){
								if (vec[a]==1){
									acump=acump+objetos[a][2];
								}
							}
							if (acump>maxp){
								for (a=0;a<3;a++){
									maxvec[a]=vec[a];
									maxp=acump;
									maxvol=acum;
								}
							}
						}
					}
				}
			}
			
			
			System.out.println("La mejor combinacion de objetos en la mochila es: \n ");

			for (a=0;a<3;a++){
				System.out.println("Objeto #"+(a+1));
				System.out.println("   --> Volumen: "+ objetos[a][1]+" cm cubicos");
				System.out.println("   --> Valor: $" + objetos[a][2]);
				System.out.print("   --> ¿Esta en la mochila? ");
				if(maxvec[a] == 1) {
					System.out.println("Si");
				}else {
					System.out.println("No");
				}
			}
			System.out.println();
			System.out.println("# Datos de la mochila:");
			System.out.println("   Volumen total: " +maxvol+ " cm cubicos.");
			System.out.println("   Valor total: $" +maxp);
			
			long time_end = System.currentTimeMillis();
			System.out.println();
			System.out.println("-------------------------------------------------------");
			System.out.println();
			System.out.println();
			System.out.println(">> Tiempo de duracion del proceso: "+ ( time_end - time_start ) +" milisegundos.");
			
		}
		
		

	}




