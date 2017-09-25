package tsp;

import java.util.Scanner;

public class ViajeroHeuristico {
	

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Ciudad[] ciudades=new Ciudad[23];
		cargaDatos(ciudades);
		int entradaTeclado=0;
		
		Scanner entradaScanner= new Scanner(System.in);
		
		System.out.println("ingrese ciudad de inicio");
		entradaTeclado=entradaScanner.nextInt();
		int posicion=0;
		ciudades[posicion].setInicial();
		System.out.println(entradaTeclado);
		posicion=busquedaCiudad(entradaTeclado,ciudades);
		ciudades[posicion].setVisitado();
		int ini=entradaTeclado;
		int distancia=0;
		
		System.out.println(posicion);
		System.out.println(ciudades[posicion].getDistancias().length);
		int cont=0;
		
		//int ult=0;
		
		do
			{
				int masCercano=20000;
				System.out.println("la ciudad de origen es "+ciudades[posicion].getNombre());

				for(int k=0;k<22;k++)
				{
					
						
						int destino=busquedaCiudad(ciudades[posicion].dameUno(k).getCiudadDestino(),ciudades);
						//System.out.println("destino: "+destino);
						if(ciudades[posicion].dameUno(k).getDistancia()<masCercano && ciudades[destino].getVisitado()==false)
						{
							masCercano=ciudades[posicion].dameUno(k).getDistancia();
							entradaTeclado=ciudades[destino].getId();
							
							
							//System.out.println("entre al if");
							//System.out.println("el posible destino es: "+entradaTeclado);
						}
					
					
				}
				System.out.println("La ciudad "+(cont+1)+" visitada fue "+ entradaTeclado + ", que se encuentra a "+masCercano);
				
				cont++;
				
				distancia=distancia+masCercano;
				System.out.println("distancia parcial: "+distancia);
				
				posicion=busquedaCiudad(entradaTeclado,ciudades);
				ciudades[posicion].setVisitado();
				System.out.println("-------------------------------------------------------------");
				
				
			}while (cont<22);
		for(int i=0;i<22;i++)
		{	
			int vueltaACasa=busquedaCiudad(entradaTeclado,ciudades);
			if (ciudades[vueltaACasa].dameUno(i).getCiudadDestino().equals(ini))
			{
				System.out.println(ciudades[posicion].dameUno(i).getCiudadOrigen());
				System.out.println(ini);
				distancia=distancia+ciudades[posicion].dameUno(i).getDistancia();
			}
		}
		System.out.println("la distancia total recorrido fue: "+distancia);
				
				
				
			
		
	}
	private static int busquedaCiudad(int id, Ciudad[] ciudades)
	{
		int posicion=0;
		for (int i=0;i<ciudades.length;i++)
		{
			if(id==ciudades[i].getId())
				posicion=i;
		}
		return posicion;
	}
	private static int busquedaCiudad(String vieja,Ciudad[] ciudades)
	{
		int posicion=0;
		
		for(int i=0;i<ciudades.length;i++)
		{
			
			if(vieja.equals(ciudades[i].getNombre()))
				{
					
					posicion=i;
					
					
				}
		}
		return posicion;
		
	}

	private static void cargaDatos(Ciudad[] ciuds) {
		CiudadesDistancias[] dist1=new CiudadesDistancias[23];
		CiudadesDistancias[] dist2=new CiudadesDistancias[23];
		CiudadesDistancias[] dist3=new CiudadesDistancias[23];
		CiudadesDistancias[] dist4=new CiudadesDistancias[23];
		CiudadesDistancias[] dist5=new CiudadesDistancias[23];
		CiudadesDistancias[] dist6=new CiudadesDistancias[23];
		CiudadesDistancias[] dist7=new CiudadesDistancias[23];
		CiudadesDistancias[] dist8=new CiudadesDistancias[23];
		CiudadesDistancias[] dist9=new CiudadesDistancias[23];
		CiudadesDistancias[] dist10=new CiudadesDistancias[23];
		CiudadesDistancias[] dist11=new CiudadesDistancias[23];
		CiudadesDistancias[] dist12=new CiudadesDistancias[23];
		CiudadesDistancias[] dist13=new CiudadesDistancias[23];
		CiudadesDistancias[] dist14=new CiudadesDistancias[23];
		CiudadesDistancias[] dist15=new CiudadesDistancias[23];
		CiudadesDistancias[] dist16=new CiudadesDistancias[23];
		CiudadesDistancias[] dist17=new CiudadesDistancias[23];
		CiudadesDistancias[] dist18=new CiudadesDistancias[23];
		CiudadesDistancias[] dist19=new CiudadesDistancias[23];
		CiudadesDistancias[] dist20=new CiudadesDistancias[23];
		CiudadesDistancias[] dist21=new CiudadesDistancias[23];
		CiudadesDistancias[] dist22=new CiudadesDistancias[23];
		CiudadesDistancias[] dist23=new CiudadesDistancias[23];
		
		//cargar ciudades
		ciuds[0]=new Ciudad(1,"Buenos Aires");
		ciuds[1]=new Ciudad(2,"San S. de Jujuy");
		ciuds[2]=new Ciudad(3,"Salta");
		ciuds[3]=new Ciudad(4, "San M de Tucuman");
		ciuds[4]=new Ciudad(5,"Sgo. del Estero");
		ciuds[5]=new Ciudad(6,"Formosa");
		ciuds[6]=new Ciudad(7,"Resistencia");
		ciuds[7]=new Ciudad(8,"Santa Fe");
		ciuds[8]=new Ciudad(9,"Corrientes");
		ciuds[9]=new Ciudad(10,"Posadas");
		ciuds[10]=new Ciudad(11,"Paran�");
		ciuds[11]=new Ciudad(12,"C�rdoba");
		ciuds[12]=new Ciudad(13,"La Rioja");
		ciuds[13]=new Ciudad(14,"San Juan");
		ciuds[14]=new Ciudad(15,"San Luis");
		ciuds[15]=new Ciudad(16,"Catamarca");
		ciuds[16]=new Ciudad(17,"Mendoza");
		ciuds[17]=new Ciudad(18,"Santa Rosa");
		ciuds[18]=new Ciudad(19,"Neuqu�n");
		ciuds[19]=new Ciudad(20,"Viedma");
		ciuds[20]=new Ciudad(21,"Rawson");
		ciuds[21]=new Ciudad(22,"Rio Gallegos");
		ciuds[22]=new Ciudad(23,"Ushuaia");
		
		//cargar distancias bs AS
		dist1[0]=new CiudadesDistancias("Buenos Aires","San S. de Jujuy",1543);
		dist1[1]=new CiudadesDistancias("Buenos Aires","Salta",1510);
		dist1[2]=new CiudadesDistancias("Buenos Aires","San M de Tucuman",1203);
		dist1[3]=new CiudadesDistancias("Buenos Aires","Sgo. del Estero",1043);
		dist1[4]=new CiudadesDistancias("Buenos Aires","Formosa",1191);
		dist1[5]=new CiudadesDistancias("Buenos Aires","Resistencia",1023);
		dist1[6]=new CiudadesDistancias("Buenos Aires","Santa Fe",478);
		dist1[7]=new CiudadesDistancias("Buenos Aires","Corrientes",940);
		dist1[8]=new CiudadesDistancias("Buenos Aires","Posadas",1040);
		dist1[9]=new CiudadesDistancias("Buenos Aires","Paran�",480);
		dist1[10]=new CiudadesDistancias("Buenos Aires","C�rdoba",715);
		dist1[11]=new CiudadesDistancias("Buenos Aires","La Rioja",1150);
		dist1[12]=new CiudadesDistancias("Buenos Aires","San Juan",1110);
		dist1[13]=new CiudadesDistancias("Buenos Aires","San Luis",790);
		dist1[14]=new CiudadesDistancias("Buenos Aires","Catamarca",1155);
		dist1[15]=new CiudadesDistancias("Buenos Aires","Mendoza",1050);
		dist1[16]=new CiudadesDistancias("Buenos Aires","Santa Rosa",620);
		dist1[17]=new CiudadesDistancias("Buenos Aires","Neuqu�n",1158);
		dist1[18]=new CiudadesDistancias("Buenos Aires","Viedma",960);
		dist1[19]=new CiudadesDistancias("Buenos Aires","Rawson",1455);
		dist1[20]=new CiudadesDistancias("Buenos Aires","Rio Gallegos",2635);
		dist1[21]=new CiudadesDistancias("Buenos Aires","Ushuaia",3228);
		ciuds[0].setDistancias(dist1);
		//cargar distancias jujuy
		dist2[0]=new CiudadesDistancias("San S. de Jujuy","Buenos Aires",1543);
		dist2[1]=new CiudadesDistancias("San S. de Jujuy","Salta",99);
		dist2[2]=new CiudadesDistancias("San S. de Jujuy","San M de Tucuman",340);
		dist2[3]=new CiudadesDistancias("San S. de Jujuy","Sgo. del Estero",500);
		dist2[4]=new CiudadesDistancias("San S. de Jujuy","Formosa",960);
		dist2[5]=new CiudadesDistancias("San S. de Jujuy","Resistencia",860);
		dist2[6]=new CiudadesDistancias("San S. de Jujuy","Santa Fe",1107);
		dist2[7]=new CiudadesDistancias("San S. de Jujuy","Corrientes",883);
		dist2[8]=new CiudadesDistancias("San S. de Jujuy","Posadas",1198);
		dist2[9]=new CiudadesDistancias("San S. de Jujuy","Paran�",1138);
		dist2[10]=new CiudadesDistancias("San S. de Jujuy","C�rdoba",930);
		dist2[11]=new CiudadesDistancias("San S. de Jujuy","La Rioja",770);
		dist2[12]=new CiudadesDistancias("San S. de Jujuy","San Juan",1220);
		dist2[13]=new CiudadesDistancias("San S. de Jujuy","San Luis",1320);
		dist2[14]=new CiudadesDistancias("San S. de Jujuy","Catamarca",572);
		dist2[15]=new CiudadesDistancias("San S. de Jujuy","Mendoza",1345);
		dist2[16]=new CiudadesDistancias("San S. de Jujuy","Santa Rosa",1530);
		dist2[17]=new CiudadesDistancias("San S. de Jujuy","Neuqu�n",2200);
		dist2[18]=new CiudadesDistancias("San S. de Jujuy","Viedma",2124);
		dist2[19]=new CiudadesDistancias("San S. de Jujuy","Rawson",2385);
		dist2[20]=new CiudadesDistancias("San S. de Jujuy","Rio Gallegos",3565);
		dist2[21]=new CiudadesDistancias("San S. de Jujuy","Ushuaia",4158);
		ciuds[1].setDistancias(dist2);
		//cargar distancias salta
		dist3[0]=new CiudadesDistancias("Salta","Buenos Aires",1510);
		dist3[1]=new CiudadesDistancias("Salta","San S. de Jujuy",99);
		dist3[2]=new CiudadesDistancias("Salta","San M de Tucuman",307);
		dist3[3]=new CiudadesDistancias("Salta","Sgo. del Estero",467);
		dist3[4]=new CiudadesDistancias("Salta","Formosa",948);
		dist3[5]=new CiudadesDistancias("Salta","Resistencia",780);
		dist3[6]=new CiudadesDistancias("Salta","Santa Fe",1074);
		dist3[7]=new CiudadesDistancias("Salta","Corrientes",803);
		dist3[8]=new CiudadesDistancias("Salta","Posadas",1118);
		dist3[9]=new CiudadesDistancias("Salta","Paran�",1105);
		dist3[10]=new CiudadesDistancias("Salta","C�rdoba",897);
		dist3[11]=new CiudadesDistancias("Salta","La Rioja",695);
		dist3[12]=new CiudadesDistancias("Salta","San Juan",1145);
		dist3[13]=new CiudadesDistancias("Salta","San Luis",1245);
		dist3[14]=new CiudadesDistancias("Salta","Catamarca",539);
		dist3[15]=new CiudadesDistancias("Salta","Mendoza",1227);
		dist3[16]=new CiudadesDistancias("Salta","Santa Rosa",1497);
		dist3[17]=new CiudadesDistancias("Salta","Neuqu�n",2082);
		dist3[18]=new CiudadesDistancias("Salta","Viedma",2091);
		dist3[19]=new CiudadesDistancias("Salta","Rawson",2352);
		dist3[20]=new CiudadesDistancias("Salta","Rio Gallegos",3532);
		dist3[21]=new CiudadesDistancias("Salta","Ushuaia",4125);
		ciuds[2].setDistancias(dist3);
		//cargar distancias tucuman
		dist4[0]=new CiudadesDistancias("San M de Tucuman","Buenos Aires",1203);
		dist4[1]=new CiudadesDistancias("San M de Tucuman","San S. de Jujuy",340);
		dist4[2]=new CiudadesDistancias("San M de Tucuman","Salta",307);
		dist4[3]=new CiudadesDistancias("San M de Tucuman","Sgo. del Estero",160);
		dist4[4]=new CiudadesDistancias("San M de Tucuman","Formosa",936);
		dist4[5]=new CiudadesDistancias("San M de Tucuman","Resistencia",768);
		dist4[6]=new CiudadesDistancias("San M de Tucuman","Santa Fe",767);
		dist4[7]=new CiudadesDistancias("San M de Tucuman","Corrientes",791);
		dist4[8]=new CiudadesDistancias("San M de Tucuman","Posadas",1106);
		dist4[9]=new CiudadesDistancias("San M de Tucuman","Paran�",798);
		dist4[10]=new CiudadesDistancias("San M de Tucuman","C�rdoba",590);
		dist4[11]=new CiudadesDistancias("San M de Tucuman","La Rioja",338);
		dist4[12]=new CiudadesDistancias("San M de Tucuman","San Juan",838);
		dist4[13]=new CiudadesDistancias("San M de Tucuman","San Luis",938);
		dist4[14]=new CiudadesDistancias("San M de Tucuman","Catamarca",232);
		dist4[15]=new CiudadesDistancias("San M de Tucuman","Mendoza",1005);
		dist4[16]=new CiudadesDistancias("San M de Tucuman","Santa Rosa",1190);
		dist4[17]=new CiudadesDistancias("San M de Tucuman","Neuqu�n",1860);
		dist4[18]=new CiudadesDistancias("San M de Tucuman","Viedma",1784);
		dist4[19]=new CiudadesDistancias("San M de Tucuman","Rawson",2045);
		dist4[20]=new CiudadesDistancias("San M de Tucuman","Rio Gallegos",3225);
		dist4[21]=new CiudadesDistancias("San M de Tucuman","Ushuaia",3818);
		ciuds[3].setDistancias(dist4);
		//cargar distancias sgo del estero
		dist5[0]=new CiudadesDistancias("Sgo. del Estero","Buenos Aires",1043);
		dist5[1]=new CiudadesDistancias("Sgo. del Estero","Salta",467);
		dist5[2]=new CiudadesDistancias("Sgo. del Estero","San S. de Jujuy",500);
		dist5[3]=new CiudadesDistancias("Sgo. del Estero","San M de Tucuman",160);
		dist5[4]=new CiudadesDistancias("Sgo. del Estero","Formosa",776);
		dist5[5]=new CiudadesDistancias("Sgo. del Estero","Resistencia",610);
		dist5[6]=new CiudadesDistancias("Sgo. del Estero","Santa Fe",607);
		dist5[7]=new CiudadesDistancias("Sgo. del Estero","Corrientes",633);
		dist5[8]=new CiudadesDistancias("Sgo. del Estero","Posadas",948);
		dist5[9]=new CiudadesDistancias("Sgo. del Estero","Paran�",638);
		dist5[10]=new CiudadesDistancias("Sgo. del Estero","C�rdoba",430);
		dist5[11]=new CiudadesDistancias("Sgo. del Estero","La Rioja",360);
		dist5[12]=new CiudadesDistancias("Sgo. del Estero","San Juan",810);
		dist5[13]=new CiudadesDistancias("Sgo. del Estero","San Luis",850);
		dist5[14]=new CiudadesDistancias("Sgo. del Estero","Catamarca",212);
		dist5[15]=new CiudadesDistancias("Sgo. del Estero","Mendoza",977);
		dist5[16]=new CiudadesDistancias("Sgo. del Estero","Santa Rosa",1030);
		dist5[17]=new CiudadesDistancias("Sgo. del Estero","Neuqu�n",1567);
		dist5[18]=new CiudadesDistancias("Sgo. del Estero","Viedma",1624);
		dist5[19]=new CiudadesDistancias("Sgo. del Estero","Rawson",1885);
		dist5[20]=new CiudadesDistancias("Sgo. del Estero","Rio Gallegos",3065);
		dist5[21]=new CiudadesDistancias("Sgo. del Estero","Ushuaia",3658);
		ciuds[4].setDistancias(dist5);
		//cargar distancias formosa
		dist6[0]=new CiudadesDistancias("Formosa","Buenos Aires",1191);
		dist6[1]=new CiudadesDistancias("Formosa","Salta",948);
		dist6[2]=new CiudadesDistancias("Formosa","San M de Tucuman",936);
		dist6[3]=new CiudadesDistancias("Formosa","Sgo. del Estero",776);
		dist6[4]=new CiudadesDistancias("Formosa","San S. de Jujuy",960);
		dist6[5]=new CiudadesDistancias("Formosa","Resistencia",168);
		dist6[6]=new CiudadesDistancias("Formosa","Santa Fe",713);
		dist6[7]=new CiudadesDistancias("Formosa","Corrientes",191);
		dist6[8]=new CiudadesDistancias("Formosa","Posadas",506);
		dist6[9]=new CiudadesDistancias("Formosa","Paran�",744);
		dist6[10]=new CiudadesDistancias("Formosa","C�rdoba",1043);
		dist6[11]=new CiudadesDistancias("Formosa","La Rioja",1136);
		dist6[12]=new CiudadesDistancias("Formosa","San Juan",1543);
		dist6[13]=new CiudadesDistancias("Formosa","San Luis",1463);
		dist6[14]=new CiudadesDistancias("Formosa","Catamarca",988);
		dist6[15]=new CiudadesDistancias("Formosa","Mendoza",1710);
		dist6[16]=new CiudadesDistancias("Formosa","Santa Rosa",1523);
		dist6[17]=new CiudadesDistancias("Formosa","Neuqu�n",2060);
		dist6[18]=new CiudadesDistancias("Formosa","Viedma",2117);
		dist6[19]=new CiudadesDistancias("Formosa","Rawson",2378);
		dist6[20]=new CiudadesDistancias("Formosa","Rio Gallegos",3558);
		dist6[21]=new CiudadesDistancias("Formosa","Ushuaia",4151);
		ciuds[5].setDistancias(dist6);
		//cargar distancia resistencia
		dist7[0]=new CiudadesDistancias("Resistencia","Buenos Aires",1023);
		dist7[1]=new CiudadesDistancias("Resistencia","Salta",780);
		dist7[2]=new CiudadesDistancias("Resistencia","San M de Tucuman",765);
		dist7[3]=new CiudadesDistancias("Resistencia","Sgo. del Estero",610);
		dist7[4]=new CiudadesDistancias("Resistencia","Formosa",168);
		dist7[5]=new CiudadesDistancias("Resistencia","San S. de Jujuy",860);
		dist7[6]=new CiudadesDistancias("Resistencia","Santa Fe",545);
		dist7[7]=new CiudadesDistancias("Resistencia","Corrientes",23);
		dist7[8]=new CiudadesDistancias("Resistencia","Posadas",338);
		dist7[9]=new CiudadesDistancias("Resistencia","Paran�",576);
		dist7[10]=new CiudadesDistancias("Resistencia","C�rdoba",875);
		dist7[11]=new CiudadesDistancias("Resistencia","La Rioja",970);
		dist7[12]=new CiudadesDistancias("Resistencia","San Juan",1420);
		dist7[13]=new CiudadesDistancias("Resistencia","San Luis",1295);
		dist7[14]=new CiudadesDistancias("Resistencia","Catamarca",822);
		dist7[15]=new CiudadesDistancias("Resistencia","Mendoza",1587);
		dist7[16]=new CiudadesDistancias("Resistencia","Santa Rosa",1475);
		dist7[17]=new CiudadesDistancias("Resistencia","Neuqu�n",2012);
		dist7[18]=new CiudadesDistancias("Resistencia","Viedma",2069);
		dist7[19]=new CiudadesDistancias("Resistencia","Rawson",2210);
		dist7[20]=new CiudadesDistancias("Resistencia","Rio Gallegos",3390);
		dist7[21]=new CiudadesDistancias("Resistencia","Ushuaia",3983);
		ciuds[6].setDistancias(dist7);
		//cargar distancia santa fe
		dist8[0]=new CiudadesDistancias("Santa Fe","Buenos Aires",478);
		dist8[1]=new CiudadesDistancias("Santa Fe","Salta",1074);
		dist8[2]=new CiudadesDistancias("Santa Fe","San M de Tucuman",767);
		dist8[3]=new CiudadesDistancias("Santa Fe","Sgo. del Estero",607);
		dist8[4]=new CiudadesDistancias("Santa Fe","Formosa",713);
		dist8[5]=new CiudadesDistancias("Santa Fe","Resistencia",545);
		dist8[6]=new CiudadesDistancias("Santa Fe","San S. de Jujuy",1107);
		dist8[7]=new CiudadesDistancias("Santa Fe","Corrientes",568);
		dist8[8]=new CiudadesDistancias("Santa Fe","Posadas",883);
		dist8[9]=new CiudadesDistancias("Santa Fe","Paran�",31);
		dist8[10]=new CiudadesDistancias("Santa Fe","C�rdoba",330);
		dist8[11]=new CiudadesDistancias("Santa Fe","La Rioja",765);
		dist8[12]=new CiudadesDistancias("Santa Fe","San Juan",830);
		dist8[13]=new CiudadesDistancias("Santa Fe","San Luis",625);
		dist8[14]=new CiudadesDistancias("Santa Fe","Catamarca",770);
		dist8[15]=new CiudadesDistancias("Santa Fe","Mendoza",885);
		dist8[16]=new CiudadesDistancias("Santa Fe","Santa Rosa",810);
		dist8[17]=new CiudadesDistancias("Santa Fe","Neuqu�n",1347);
		dist8[18]=new CiudadesDistancias("Santa Fe","Viedma",1404);
		dist8[19]=new CiudadesDistancias("Santa Fe","Rawson",1665);
		dist8[20]=new CiudadesDistancias("Santa Fe","Rio Gallegos",2845);
		dist8[21]=new CiudadesDistancias("Santa Fe","Ushuaia",3438);
		ciuds[7].setDistancias(dist8);
		//cargar distancia corrientes
		dist9[0]=new CiudadesDistancias("Corrientes","Buenos Aires",940);
		dist9[1]=new CiudadesDistancias("Corrientes","Salta",803);
		dist9[2]=new CiudadesDistancias("Corrientes","San M de Tucuman",791);
		dist9[3]=new CiudadesDistancias("Corrientes","Sgo. del Estero",633);
		dist9[4]=new CiudadesDistancias("Corrientes","Formosa",191);
		dist9[5]=new CiudadesDistancias("Corrientes","Resistencia",23);
		dist9[6]=new CiudadesDistancias("Corrientes","Santa Fe",568);
		dist9[7]=new CiudadesDistancias("Corrientes","San S. de Jujuy",883);
		dist9[8]=new CiudadesDistancias("Corrientes","Posadas",315);
		dist9[9]=new CiudadesDistancias("Corrientes","Paran�",590);
		dist9[10]=new CiudadesDistancias("Corrientes","C�rdoba",898);
		dist9[11]=new CiudadesDistancias("Corrientes","La Rioja",993);
		dist9[12]=new CiudadesDistancias("Corrientes","San Juan",1398);
		dist9[13]=new CiudadesDistancias("Corrientes","San Luis",1318);
		dist9[14]=new CiudadesDistancias("Corrientes","Catamarca",845);
		dist9[15]=new CiudadesDistancias("Corrientes","Mendoza",1565);
		dist9[16]=new CiudadesDistancias("Corrientes","Santa Rosa",1378);
		dist9[17]=new CiudadesDistancias("Corrientes","Neuqu�n",1989);
		dist9[18]=new CiudadesDistancias("Corrientes","Viedma",2046);
		dist9[19]=new CiudadesDistancias("Corrientes","Rawson",2187);
		dist9[20]=new CiudadesDistancias("Corrientes","Rio Gallegos",3367);
		dist9[21]=new CiudadesDistancias("Corrientes","Ushuaia",3960);
		ciuds[8].setDistancias(dist9);
		//cargar distancias posadas
		dist10[0]=new CiudadesDistancias("Posadas","Buenos Aires",1040);
		dist10[1]=new CiudadesDistancias("Posadas","Salta",1118);
		dist10[2]=new CiudadesDistancias("Posadas","San M de Tucuman",1106);
		dist10[3]=new CiudadesDistancias("Posadas","Sgo. del Estero",948);
		dist10[4]=new CiudadesDistancias("Posadas","Formosa",506);
		dist10[5]=new CiudadesDistancias("Posadas","Resistencia",338);
		dist10[6]=new CiudadesDistancias("Posadas","Santa Fe",883);
		dist10[7]=new CiudadesDistancias("Posadas","Corrientes",315);
		dist10[8]=new CiudadesDistancias("Posadas","San S. de Jujuy",1198);
		dist10[9]=new CiudadesDistancias("Posadas","Paran�",820);
		dist10[10]=new CiudadesDistancias("Posadas","C�rdoba",1213);
		dist10[11]=new CiudadesDistancias("Posadas","La Rioja",1308);
		dist10[12]=new CiudadesDistancias("Posadas","San Juan",1758);
		dist10[13]=new CiudadesDistancias("Posadas","San Luis",1633);
		dist10[14]=new CiudadesDistancias("Posadas","Catamarca",1160);
		dist10[15]=new CiudadesDistancias("Posadas","Mendoza",1925);
		dist10[16]=new CiudadesDistancias("Posadas","Santa Rosa",1660);
		dist10[17]=new CiudadesDistancias("Posadas","Neuqu�n",2198);
		dist10[18]=new CiudadesDistancias("Posadas","Viedma",2000);
		dist10[19]=new CiudadesDistancias("Posadas","Rawson",2445);
		dist10[20]=new CiudadesDistancias("Posadas","Rio Gallegos",3675);
		dist10[21]=new CiudadesDistancias("Posadas","Ushuaia",4268);
		ciuds[9].setDistancias(dist10);
		//cargar distancias parana
		dist11[0]=new CiudadesDistancias("Paran�","Buenos Aires",480);
		dist11[1]=new CiudadesDistancias("Paran�","Salta",1105);
		dist11[2]=new CiudadesDistancias("Paran�","San M de Tucuman",798);
		dist11[3]=new CiudadesDistancias("Paran�","Sgo. del Estero",638);
		dist11[4]=new CiudadesDistancias("Paran�","Formosa",744);
		dist11[5]=new CiudadesDistancias("Paran�","Resistencia",576);
		dist11[6]=new CiudadesDistancias("Paran�","Santa Fe",31);
		dist11[7]=new CiudadesDistancias("Paran�","Corrientes",590);
		dist11[8]=new CiudadesDistancias("Paran�","Posadas",820);
		dist11[9]=new CiudadesDistancias("Paran�","San S. de Jujuy",1138);
		dist11[10]=new CiudadesDistancias("Paran�","C�rdoba",361);
		dist11[11]=new CiudadesDistancias("Paran�","La Rioja",796);
		dist11[12]=new CiudadesDistancias("Paran�","San Juan",861);
		dist11[13]=new CiudadesDistancias("Paran�","San Luis",656);
		dist11[14]=new CiudadesDistancias("Paran�","Catamarca",801);
		dist11[15]=new CiudadesDistancias("Paran�","Mendoza",916);
		dist11[16]=new CiudadesDistancias("Paran�","Santa Rosa",841);
		dist11[17]=new CiudadesDistancias("Paran�","Neuqu�n",1378);
		dist11[18]=new CiudadesDistancias("Paran�","Viedma",1435);
		dist11[19]=new CiudadesDistancias("Paran�","Rawson",1696);
		dist11[20]=new CiudadesDistancias("Paran�","Rio Gallegos",2876);
		dist11[21]=new CiudadesDistancias("Paran�","Ushuaia",3469);
		ciuds[10].setDistancias(dist11);
		//cargar distancias cordoba
		dist12[0]=new CiudadesDistancias("C�rdoba","Buenos Aires",715);
		dist12[1]=new CiudadesDistancias("C�rdoba","Salta",897);
		dist12[2]=new CiudadesDistancias("C�rdoba","San M de Tucuman",590);
		dist12[3]=new CiudadesDistancias("C�rdoba","Sgo. del Estero",430);
		dist12[4]=new CiudadesDistancias("C�rdoba","Formosa",1043);
		dist12[5]=new CiudadesDistancias("C�rdoba","Resistencia",875);
		dist12[6]=new CiudadesDistancias("C�rdoba","Santa Fe",330);
		dist12[7]=new CiudadesDistancias("C�rdoba","Corrientes",898);
		dist12[8]=new CiudadesDistancias("C�rdoba","Posadas",1231);
		dist12[9]=new CiudadesDistancias("C�rdoba","Paran�",361);
		dist12[10]=new CiudadesDistancias("C�rdoba","San S. de Jujuy",930);
		dist12[11]=new CiudadesDistancias("C�rdoba","La Rioja",435);
		dist12[12]=new CiudadesDistancias("C�rdoba","San Juan",500);
		dist12[13]=new CiudadesDistancias("C�rdoba","San Luis",420);
		dist12[14]=new CiudadesDistancias("C�rdoba","Catamarca",440);
		dist12[15]=new CiudadesDistancias("C�rdoba","Mendoza",670);
		dist12[16]=new CiudadesDistancias("C�rdoba","Santa Rosa",600);
		dist12[17]=new CiudadesDistancias("C�rdoba","Neuqu�n",1137);
		dist12[18]=new CiudadesDistancias("C�rdoba","Viedma",1194);
		dist12[19]=new CiudadesDistancias("C�rdoba","Rawson",1455);
		dist12[20]=new CiudadesDistancias("C�rdoba","Rio Gallegos",3635);
		dist12[21]=new CiudadesDistancias("C�rdoba","Ushuaia",3228);
		ciuds[11].setDistancias(dist12);
		//cargar distancias la rioja
		dist13[0]=new CiudadesDistancias("La Rioja","Buenos Aires",1150);
		dist13[1]=new CiudadesDistancias("La Rioja","Salta",695);
		dist13[2]=new CiudadesDistancias("La Rioja","San M de Tucuman",388);
		dist13[3]=new CiudadesDistancias("La Rioja","Sgo. del Estero",360);
		dist13[4]=new CiudadesDistancias("La Rioja","Formosa",1136);
		dist13[5]=new CiudadesDistancias("La Rioja","Resistencia",970);
		dist13[6]=new CiudadesDistancias("La Rioja","Santa Fe",765);
		dist13[7]=new CiudadesDistancias("La Rioja","Corrientes",993);
		dist13[8]=new CiudadesDistancias("La Rioja","Posadas",1308);
		dist13[9]=new CiudadesDistancias("La Rioja","Paran�",796);
		dist13[10]=new CiudadesDistancias("La Rioja","C�rdoba",435);
		dist13[11]=new CiudadesDistancias("La Rioja","San S. de Jujuy",770);
		dist13[12]=new CiudadesDistancias("La Rioja","San Juan",450);
		dist13[13]=new CiudadesDistancias("La Rioja","San Luis",550);
		dist13[14]=new CiudadesDistancias("La Rioja","Catamarca",156);
		dist13[15]=new CiudadesDistancias("La Rioja","Mendoza",617);
		dist13[16]=new CiudadesDistancias("La Rioja","Santa Rosa",1035);
		dist13[17]=new CiudadesDistancias("La Rioja","Neuqu�n",1472);
		dist13[18]=new CiudadesDistancias("La Rioja","Viedma",1629);
		dist13[19]=new CiudadesDistancias("La Rioja","Rawson",1890);
		dist13[20]=new CiudadesDistancias("La Rioja","Rio Gallegos",3070);
		dist13[21]=new CiudadesDistancias("La Rioja","Ushuaia",3663);
		ciuds[12].setDistancias(dist13);
		//cargar distancias san juan
		dist14[0]=new CiudadesDistancias("San Juan","Buenos Aires",1110);
		dist14[1]=new CiudadesDistancias("San Juan","Salta",1145);
		dist14[2]=new CiudadesDistancias("San Juan","San M de Tucuman",838);
		dist14[3]=new CiudadesDistancias("San Juan","Sgo. del Estero",810);
		dist14[4]=new CiudadesDistancias("San Juan","Formosa",1543);
		dist14[5]=new CiudadesDistancias("San Juan","Resistencia",1420);
		dist14[6]=new CiudadesDistancias("San Juan","Santa Fe",830);
		dist14[7]=new CiudadesDistancias("San Juan","Corrientes",1398);
		dist14[8]=new CiudadesDistancias("San Juan","Posadas",1758);
		dist14[9]=new CiudadesDistancias("San Juan","Paran�",861);
		dist14[10]=new CiudadesDistancias("San Juan","C�rdoba",500);
		dist14[11]=new CiudadesDistancias("San Juan","La Rioja",450);
		dist14[12]=new CiudadesDistancias("San Juan","San S. de Jujuy",1220);
		dist14[13]=new CiudadesDistancias("San Juan","San Luis",320);
		dist14[14]=new CiudadesDistancias("San Juan","Catamarca",606);
		dist14[15]=new CiudadesDistancias("San Juan","Mendoza",167);
		dist14[16]=new CiudadesDistancias("San Juan","Santa Rosa",825);
		dist14[17]=new CiudadesDistancias("San Juan","Neuqu�n",1022);
		dist14[18]=new CiudadesDistancias("San Juan","Viedma",1419);
		dist14[19]=new CiudadesDistancias("San Juan","Rawson",1680);
		dist14[20]=new CiudadesDistancias("San Juan","Rio Gallegos",2860);
		dist14[21]=new CiudadesDistancias("San Juan","Ushuaia",3453);
		ciuds[13].setDistancias(dist14);
		//cargar distancias san luis
		dist15[0]=new CiudadesDistancias("San Luis","Buenos Aires",790);
		dist15[1]=new CiudadesDistancias("San Luis","Salta",1245);
		dist15[2]=new CiudadesDistancias("San Luis","San M de Tucuman",938);
		dist15[3]=new CiudadesDistancias("San Luis","Sgo. del Estero",850);
		dist15[4]=new CiudadesDistancias("San Luis","Formosa",1463);
		dist15[5]=new CiudadesDistancias("San Luis","Resistencia",1295);
		dist15[6]=new CiudadesDistancias("San Luis","Santa Fe",625);
		dist15[7]=new CiudadesDistancias("San Luis","Corrientes",1318);
		dist15[8]=new CiudadesDistancias("San Luis","Posadas",1633);
		dist15[9]=new CiudadesDistancias("San Luis","Paran�",656);
		dist15[10]=new CiudadesDistancias("San Luis","C�rdoba",420);
		dist15[11]=new CiudadesDistancias("San Luis","La Rioja",550);
		dist15[12]=new CiudadesDistancias("San Luis","San Juan",320);
		dist15[13]=new CiudadesDistancias("San Luis","San S. de Jujuy",1320);
		dist15[14]=new CiudadesDistancias("San Luis","Catamarca",705);
		dist15[15]=new CiudadesDistancias("San Luis","Mendoza",260);
		dist15[16]=new CiudadesDistancias("San Luis","Santa Rosa",505);
		dist15[17]=new CiudadesDistancias("San Luis","Neuqu�n",883);
		dist15[18]=new CiudadesDistancias("San Luis","Viedma",1099);
		dist15[19]=new CiudadesDistancias("San Luis","Rawson",1360);
		dist15[20]=new CiudadesDistancias("San Luis","Rio Gallegos",2540);
		dist15[21]=new CiudadesDistancias("San Luis","Ushuaia",3133);
		ciuds[14].setDistancias(dist15);
		//cargar distancias catamarca
		dist16[0]=new CiudadesDistancias("Catamarca","Buenos Aires",1145);
		dist16[1]=new CiudadesDistancias("Catamarca","Salta",539);
		dist16[2]=new CiudadesDistancias("Catamarca","San M de Tucuman",232);
		dist16[3]=new CiudadesDistancias("Catamarca","Sgo. del Estero",212);
		dist16[4]=new CiudadesDistancias("Catamarca","Formosa",988);
		dist16[5]=new CiudadesDistancias("Catamarca","Resistencia",822);
		dist16[6]=new CiudadesDistancias("Catamarca","Santa Fe",770);
		dist16[7]=new CiudadesDistancias("Catamarca","Corrientes",845);
		dist16[8]=new CiudadesDistancias("Catamarca","Posadas",1160);
		dist16[9]=new CiudadesDistancias("Catamarca","Paran�",801);
		dist16[10]=new CiudadesDistancias("Catamarca","C�rdoba",440);
		dist16[11]=new CiudadesDistancias("Catamarca","La Rioja",156);
		dist16[12]=new CiudadesDistancias("Catamarca","San Juan",606);
		dist16[13]=new CiudadesDistancias("Catamarca","San Luis",705);
		dist16[14]=new CiudadesDistancias("Catamarca","San S. de Jujuy",572);
		dist16[15]=new CiudadesDistancias("Catamarca","Mendoza",773);
		dist16[16]=new CiudadesDistancias("Catamarca","Santa Rosa",1040);
		dist16[17]=new CiudadesDistancias("Catamarca","Neuqu�n",1588);
		dist16[18]=new CiudadesDistancias("Catamarca","Viedma",1634);
		dist16[19]=new CiudadesDistancias("Catamarca","Rawson",1895);
		dist16[20]=new CiudadesDistancias("Catamarca","Rio Gallegos",3075);
		dist16[21]=new CiudadesDistancias("Catamarca","Ushuaia",3668);
		ciuds[15].setDistancias(dist16);
		//cargar distancias mendoza
		dist17[0]=new CiudadesDistancias("Mendoza","Buenos Aires",1050);
		dist17[1]=new CiudadesDistancias("Mendoza","Salta",1227);
		dist17[2]=new CiudadesDistancias("Mendoza","San M de Tucuman",1005);
		dist17[3]=new CiudadesDistancias("Mendoza","Sgo. del Estero",977);
		dist17[4]=new CiudadesDistancias("Mendoza","Formosa",1710);
		dist17[5]=new CiudadesDistancias("Mendoza","Resistencia",1587);
		dist17[6]=new CiudadesDistancias("Mendoza","Santa Fe",885);
		dist17[7]=new CiudadesDistancias("Mendoza","Corrientes",1565);
		dist17[8]=new CiudadesDistancias("Mendoza","Posadas",1925);
		dist17[9]=new CiudadesDistancias("Mendoza","Paran�",916);
		dist17[10]=new CiudadesDistancias("Mendoza","C�rdoba",670);
		dist17[11]=new CiudadesDistancias("Mendoza","La Rioja",617);
		dist17[12]=new CiudadesDistancias("Mendoza","San Juan",167);
		dist17[13]=new CiudadesDistancias("Mendoza","San Luis",260);
		dist17[14]=new CiudadesDistancias("Mendoza","Catamarca",773);
		dist17[15]=new CiudadesDistancias("Mendoza","San S. de Jujuy",1345);
		dist17[16]=new CiudadesDistancias("Mendoza","Santa Rosa",765);
		dist17[17]=new CiudadesDistancias("Mendoza","Neuqu�n",855);
		dist17[18]=new CiudadesDistancias("Mendoza","Viedma",1359);
		dist17[19]=new CiudadesDistancias("Mendoza","Rawson",1620);
		dist17[20]=new CiudadesDistancias("Mendoza","Rio Gallegos",2800);
		dist17[21]=new CiudadesDistancias("Mendoza","Ushuaia",3393);
		ciuds[16].setDistancias(dist17);
		//cargar distancias Santa rosa
		dist18[0]=new CiudadesDistancias("Santa Rosa","Buenos Aires",620);
		dist18[1]=new CiudadesDistancias("Santa Rosa","Salta",1497);
		dist18[2]=new CiudadesDistancias("Santa Rosa","San M de Tucuman",1190);
		dist18[3]=new CiudadesDistancias("Santa Rosa","Sgo. del Estero",1030);
		dist18[4]=new CiudadesDistancias("Santa Rosa","Formosa",1523);
		dist18[5]=new CiudadesDistancias("Santa Rosa","Resistencia",1475);
		dist18[6]=new CiudadesDistancias("Santa Rosa","Santa Fe",810);
		dist18[7]=new CiudadesDistancias("Santa Rosa","Corrientes",1378);
		dist18[8]=new CiudadesDistancias("Santa Rosa","Posadas",1660);
		dist18[9]=new CiudadesDistancias("Santa Rosa","Paran�",841);
		dist18[10]=new CiudadesDistancias("Santa Rosa","C�rdoba",600);
		dist18[11]=new CiudadesDistancias("Santa Rosa","La Rioja",1035);
		dist18[12]=new CiudadesDistancias("Santa Rosa","San Juan",825);
		dist18[13]=new CiudadesDistancias("Santa Rosa","San Luis",505);
		dist18[14]=new CiudadesDistancias("Santa Rosa","Catamarca",1040);
		dist18[15]=new CiudadesDistancias("Santa Rosa","Mendoza",765);
		dist18[16]=new CiudadesDistancias("Santa Rosa","San S. de Jujuy",1530);
		dist18[17]=new CiudadesDistancias("Santa Rosa","Neuqu�n",537);
		dist18[18]=new CiudadesDistancias("Santa Rosa","Viedma",594);
		dist18[19]=new CiudadesDistancias("Santa Rosa","Rawson",855);
		dist18[20]=new CiudadesDistancias("Santa Rosa","Rio Gallegos",2035);
		dist18[21]=new CiudadesDistancias("Santa Rosa","Ushuaia",2628);
		ciuds[17].setDistancias(dist18);
		//cargar distancias neuquen
		dist19[0]=new CiudadesDistancias("Neuqu�n","Buenos Aires",1158);
		dist19[1]=new CiudadesDistancias("Neuqu�n","Salta",2082);
		dist19[2]=new CiudadesDistancias("Neuqu�n","San M de Tucuman",1860);
		dist19[3]=new CiudadesDistancias("Neuqu�n","Sgo. del Estero",1567);
		dist19[4]=new CiudadesDistancias("Neuqu�n","Formosa",2060);
		dist19[5]=new CiudadesDistancias("Neuqu�n","Resistencia",2012);
		dist19[6]=new CiudadesDistancias("Neuqu�n","Santa Fe",1347);
		dist19[7]=new CiudadesDistancias("Neuqu�n","Corrientes",1989);
		dist19[8]=new CiudadesDistancias("Neuqu�n","Posadas",2198);
		dist19[9]=new CiudadesDistancias("Neuqu�n","Paran�",1378);
		dist19[10]=new CiudadesDistancias("Neuqu�n","C�rdoba",1137);
		dist19[11]=new CiudadesDistancias("Neuqu�n","La Rioja",1472);
		dist19[12]=new CiudadesDistancias("Neuqu�n","San Juan",1022);
		dist19[13]=new CiudadesDistancias("Neuqu�n","San Luis",883);
		dist19[14]=new CiudadesDistancias("Neuqu�n","Catamarca",1588);
		dist19[15]=new CiudadesDistancias("Neuqu�n","Mendoza",855);
		dist19[16]=new CiudadesDistancias("Neuqu�n","Santa Rosa",537);
		dist19[17]=new CiudadesDistancias("Neuqu�n","San S. de Jujuy",2200);
		dist19[18]=new CiudadesDistancias("Neuqu�n","Viedma",660);
		dist19[19]=new CiudadesDistancias("Neuqu�n","Rawson",750);
		dist19[20]=new CiudadesDistancias("Neuqu�n","Rio Gallegos",1930);
		dist19[21]=new CiudadesDistancias("Neuqu�n","Ushuaia",2523);
		ciuds[18].setDistancias(dist19);
		//cargar distancias viedma
		dist20[0]=new CiudadesDistancias("Viedma","Buenos Aires",960);
		dist20[1]=new CiudadesDistancias("Viedma","Salta",2091);
		dist20[2]=new CiudadesDistancias("Viedma","San M de Tucuman",1784);
		dist20[3]=new CiudadesDistancias("Viedma","Sgo. del Estero",1624);
		dist20[4]=new CiudadesDistancias("Viedma","Formosa",2117);
		dist20[5]=new CiudadesDistancias("Viedma","Resistencia",2069);
		dist20[6]=new CiudadesDistancias("Viedma","Santa Fe",1404);
		dist20[7]=new CiudadesDistancias("Viedma","Corrientes",2046);
		dist20[8]=new CiudadesDistancias("Viedma","Posadas",2000);
		dist20[9]=new CiudadesDistancias("Viedma","Paran�",1435);
		dist20[10]=new CiudadesDistancias("Viedma","C�rdoba",1194);
		dist20[11]=new CiudadesDistancias("Viedma","La Rioja",1629);
		dist20[12]=new CiudadesDistancias("Viedma","San Juan",1419);
		dist20[13]=new CiudadesDistancias("Viedma","San Luis",1099);
		dist20[14]=new CiudadesDistancias("Viedma","Catamarca",1634);
		dist20[15]=new CiudadesDistancias("Viedma","Mendoza",1359);
		dist20[16]=new CiudadesDistancias("Viedma","Santa Rosa",594);
		dist20[17]=new CiudadesDistancias("Viedma","Neuqu�n",660);
		dist20[18]=new CiudadesDistancias("Viedma","San S. de Jujuy",2124);
		dist20[19]=new CiudadesDistancias("Viedma","Rawson",495);
		dist20[20]=new CiudadesDistancias("Viedma","Rio Gallegos",1180);
		dist20[21]=new CiudadesDistancias("Viedma","Ushuaia",1773);
		ciuds[19].setDistancias(dist20);
		//cargar distancias  rawson
		dist21[0]=new CiudadesDistancias("Rawson","Buenos Aires",1455);
		dist21[1]=new CiudadesDistancias("Rawson","Salta",2352);
		dist21[2]=new CiudadesDistancias("Rawson","San M de Tucuman",2045);
		dist21[3]=new CiudadesDistancias("Rawson","Sgo. del Estero",1885);
		dist21[4]=new CiudadesDistancias("Rawson","Formosa",2378);
		dist21[5]=new CiudadesDistancias("Rawson","Resistencia",2210);
		dist21[6]=new CiudadesDistancias("Rawson","Santa Fe",1665);
		dist21[7]=new CiudadesDistancias("Rawson","Corrientes",2187);
		dist21[8]=new CiudadesDistancias("Rawson","Posadas",2495);
		dist21[9]=new CiudadesDistancias("Rawson","Paran�",1696);
		dist21[10]=new CiudadesDistancias("Rawson","C�rdoba",1455);
		dist21[11]=new CiudadesDistancias("Rawson","La Rioja",1890);
		dist21[12]=new CiudadesDistancias("Rawson","San Juan",1680);
		dist21[13]=new CiudadesDistancias("Rawson","San Luis",1360);
		dist21[14]=new CiudadesDistancias("Rawson","Catamarca",1895);
		dist21[15]=new CiudadesDistancias("Rawson","Mendoza",495);
		dist21[16]=new CiudadesDistancias("Rawson","Santa Rosa",855);
		dist21[17]=new CiudadesDistancias("Rawson","Neuqu�n",750);
		dist21[18]=new CiudadesDistancias("Rawson","Viedma",495);
		dist21[19]=new CiudadesDistancias("Rawson","San S. de Jujuy",2385);
		dist21[20]=new CiudadesDistancias("Rawson","Rio Gallegos",1180);
		dist21[21]=new CiudadesDistancias("Rawson","Ushuaia",1773);
		ciuds[20].setDistancias(dist21);
		//cargar distancias rio gallegos
		dist22[0]=new CiudadesDistancias("Rio Gallegos","Buenos Aires",2635);
		dist22[1]=new CiudadesDistancias("Rio Gallegos","Salta",3532);
		dist22[2]=new CiudadesDistancias("Rio Gallegos","San M de Tucuman",3225);
		dist22[3]=new CiudadesDistancias("Rio Gallegos","Sgo. del Estero",3065);
		dist22[4]=new CiudadesDistancias("Rio Gallegos","Formosa",3558);
		dist22[5]=new CiudadesDistancias("Rio Gallegos","Resistencia",3390);
		dist22[6]=new CiudadesDistancias("Rio Gallegos","Santa Fe",2845);
		dist22[7]=new CiudadesDistancias("Rio Gallegos","Corrientes",3367);
		dist22[8]=new CiudadesDistancias("Rio Gallegos","Posadas",3675);
		dist22[9]=new CiudadesDistancias("Rio Gallegos","Paran�",2876);
		dist22[10]=new CiudadesDistancias("Rio Gallegos","C�rdoba",2635);
		dist22[11]=new CiudadesDistancias("Rio Gallegos","La Rioja",3070);
		dist22[12]=new CiudadesDistancias("Rio Gallegos","San Juan",2860);
		dist22[13]=new CiudadesDistancias("Rio Gallegos","San Luis",2540);
		dist22[14]=new CiudadesDistancias("Rio Gallegos","Catamarca",3075);
		dist22[15]=new CiudadesDistancias("Rio Gallegos","Mendoza",2800);
		dist22[16]=new CiudadesDistancias("Rio Gallegos","Santa Rosa",2035);
		dist22[17]=new CiudadesDistancias("Rio Gallegos","Neuqu�n",1930);
		dist22[18]=new CiudadesDistancias("Rio Gallegos","Viedma",1675);
		dist22[19]=new CiudadesDistancias("Rio Gallegos","Rawson",1180);
		dist22[20]=new CiudadesDistancias("Rio Gallegos","San S. de Jujuy",3565);
		dist22[21]=new CiudadesDistancias("Rio Gallegos","Ushuaia",593);
		ciuds[21].setDistancias(dist22);
		//cargar distancias ushuaia
		dist23[0]=new CiudadesDistancias("Ushuaia","Buenos Aires",3228);
		dist23[20]=new CiudadesDistancias("Ushuaia","San S. de Jujuy",4158);
		dist23[1]=new CiudadesDistancias("Ushuaia","Salta",4125);
		dist23[2]=new CiudadesDistancias("Ushuaia","San M de Tucuman",3818);
		dist23[3]=new CiudadesDistancias("Ushuaia","Sgo. del Estero",3658);
		dist23[4]=new CiudadesDistancias("Ushuaia","Formosa",4151);
		dist23[5]=new CiudadesDistancias("Ushuaia","Resistencia",3983);
		dist23[6]=new CiudadesDistancias("Ushuaia","Santa Fe",3438);
		dist23[7]=new CiudadesDistancias("Ushuaia","Corrientes",3960);
		dist23[8]=new CiudadesDistancias("Ushuaia","Posadas",4268);
		dist23[9]=new CiudadesDistancias("Ushuaia","Paran�",3469);
		dist23[10]=new CiudadesDistancias("Ushuaia","C�rdoba",3228);
		dist23[11]=new CiudadesDistancias("Ushuaia","La Rioja",3660);
		dist23[12]=new CiudadesDistancias("Ushuaia","San Juan",3453);
		dist23[13]=new CiudadesDistancias("Ushuaia","San Luis",3133);
		dist23[14]=new CiudadesDistancias("Ushuaia","Catamarca",3668);
		dist23[15]=new CiudadesDistancias("Ushuaia","Mendoza",3393);
		dist23[16]=new CiudadesDistancias("Ushuaia","Santa Rosa",2628);
		dist23[17]=new CiudadesDistancias("Ushuaia","Neuqu�n",2523);
		dist23[18]=new CiudadesDistancias("Ushuaia","Viedma",2228);
		dist23[19]=new CiudadesDistancias("Ushuaia","Rawson",1773);
		
		dist23[21]=new CiudadesDistancias("Ushuaia","Rio Gallegos",593);
		ciuds[22].setDistancias(dist23);
		
		
		
				
		
		
		
		
		
		
	}

}