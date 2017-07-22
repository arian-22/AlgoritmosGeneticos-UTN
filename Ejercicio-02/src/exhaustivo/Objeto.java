package exhaustivo;


public class Objeto {


	public static void main(String[] args) {
		
		int objetos[][] = new int[10][3];
		int vec[] =new int[10];
		int maxvec[] = new int[10];
		int max=0,i,j,k,l,m,n,p,q,r,s,a,acum,acump,maxp = 0,maxvol = 0;
		
		//Defino la matriz
		objetos[0][0]= 1; objetos[0][1]= 150;objetos[0][2]= 20;
		objetos[1][0]= 2; objetos[1][1]= 325;objetos[1][2]= 40;
		objetos[2][0]= 3; objetos[2][1]= 600;objetos[2][2]= 50;
		objetos[3][0]= 4; objetos[3][1]= 805;objetos[3][2]= 36;
		objetos[4][0]= 5; objetos[4][1]= 430;objetos[4][2]= 25;
		objetos[5][0]= 6; objetos[5][1]= 1200;objetos[5][2]= 64;
		objetos[6][0]= 7; objetos[6][1]= 770;objetos[6][2]= 54;
		objetos[7][0]= 8; objetos[7][1]= 60;objetos[7][2]= 18;
		objetos[8][0]= 9; objetos[8][1]= 930;objetos[8][2]= 46;
		objetos[9][0]= 10;objetos[9][1]= 353;objetos[9][2]= 28;
		
		max=4200;


		for(i=0;i<2;i++){
			for(j=0;j<2;j++){
				for(k=0;k<2;k++){
					for(l=0;l<2;l++){
						for(m=0;m<2;m++){
							for(n=0;n<2;n++){
								for(p=0;p<2;p++){
									for(q=0;q<2;q++){
										for(r=0;r<2;r++){
											for(s=0;s<2;s++){
												vec[0]= i;
												vec[1]= j;
												vec[2]= k;
												vec[3]= l;
												vec[4]= m;
												vec[5]= n;
												vec[6]= p;
												vec[7]= q;
												vec[8]= r;
												vec[9]= s;	
							   					
							   					acum=0;
							   					acump=0;
							   					for (a=0;a<10;a++){
							   						if (vec[a]==1){
							   							acum=acum+objetos[a][1];
							   						}
							   					}
												if (acum<=max){
													for (a=0;a<10;a++){
														if (vec[a]==1){
															acump=acump+objetos[a][2];
														}
													}
													if (acump>maxp){
														for (a=0;a<10;a++){
															maxvec[a]=vec[a];
															maxp=acump;
															maxvol=acum;
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		
		System.out.println("La mejor combinacion de objetos en la mochila es: \n ");

		for (a=0;a<10;a++){
			System.out.println("Maximo: "+maxvec[a]);
		}

		System.out.println("\n\nTomando los primeros seis objetos, el octavo y el decimo, con un volumen "
				+ "total de " +maxvol+ "cm cubicos \n y un valor total de " +maxp+ " pesos. ");
		System.out.println("Fin");

		
	}
	

}


