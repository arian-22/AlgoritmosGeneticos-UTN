import java.util.Arrays;
import java.util.Scanner;
import java.io.*;

public class ViajeroExhaustivo {
	

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Ciudad[] ciudades=new Ciudad[23];
		cargaDatos(ciudades);
		String entradaTeclado="";
		
		Scanner entradaScanner= new Scanner(System.in);
		
		System.out.println("ingrese ciudad de inicio");
		entradaTeclado=entradaScanner.nextLine();
		int posicion = busquedaCiudad(entradaTeclado,ciudades);
		System.out.println(posicion);
		int distancia=0;
		int cont=0;
		do
			{
				int masCercano=200000;
				for(int k=0;k<ciudades.length;k++)
					{	
						CiudadesDistancias[] distan=new CiudadesDistancias[23];
						distan=ciudades[posicion].getDistancias();
						
						if(distan[k].getDistancia()<masCercano && ciudades[posicion].getVisitado()==false)
						{
							masCercano=distan[k].getDistancia();
							entradaTeclado=distan[k].getCiudadDestino();
							
						}
					}
				
				posicion=busquedaCiudad(entradaTeclado,ciudades);
				distancia=distancia+masCercano;
				cont++;
				System.out.println("La ciudad numero "+cont+"fue "+entradaTeclado+"que se encuentra a "+masCercano);
				
				
				
			}while (cont<23);
		
	}
	private static int busquedaCiudad(String vieja,Ciudad[] ciudades)
	{
		int posicion=0;
		for(int i=0;i<ciudades.length;i++)
		{
			if(vieja==ciudades[i].getNombre())
				{
					posicion= i;
				}
		}
		return posicion;
		
	}

	private static void cargaDatos(Ciudad[] ciuds) {
		CiudadesDistancias[] dist=new CiudadesDistancias[23];
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
		ciuds[15]=new Ciudad(16,"Catamarca ");
		ciuds[16]=new Ciudad(17,"Mendoza");
		ciuds[17]=new Ciudad(18,"Santa Rosa");
		ciuds[18]=new Ciudad(19,"Neuqu�n");
		ciuds[19]=new Ciudad(20,"Viedma");
		ciuds[20]=new Ciudad(21,"Rawson");
		ciuds[21]=new Ciudad(22,"Rio Gallegos");
		ciuds[22]=new Ciudad(23,"Ushuaia");
		
		//cargar distancias bs AS
		dist[0]=new CiudadesDistancias("Buenos Aires","San S. de Jujuy",1543);
		dist[1]=new CiudadesDistancias("Buenos Aires","Salta",1510);
		dist[2]=new CiudadesDistancias("Buenos Aires","San M de Tucuman",1203);
		dist[3]=new CiudadesDistancias("Buenos Aires","Sgo. del Estero",1043);
		dist[4]=new CiudadesDistancias("Buenos Aires","Formosa",1191);
		dist[5]=new CiudadesDistancias("Buenos Aires","Resistencia",1023);
		dist[6]=new CiudadesDistancias("Buenos Aires","Santa Fe",478);
		dist[7]=new CiudadesDistancias("Buenos Aires","Corrientes",940);
		dist[8]=new CiudadesDistancias("Buenos Aires","Posadas",1040);
		dist[9]=new CiudadesDistancias("Buenos Aires","Paran�",480);
		dist[10]=new CiudadesDistancias("Buenos Aires","C�rdoba",715);
		dist[11]=new CiudadesDistancias("Buenos Aires","La Rioja",1150);
		dist[12]=new CiudadesDistancias("Buenos Aires","San Juan",1110);
		dist[13]=new CiudadesDistancias("Buenos Aires","San Luis",790);
		dist[14]=new CiudadesDistancias("Buenos Aires","Catamarca",1155);
		dist[15]=new CiudadesDistancias("Buenos Aires","Mendoza",1050);
		dist[16]=new CiudadesDistancias("Buenos Aires","Santa Rosa",620);
		dist[17]=new CiudadesDistancias("Buenos Aires","Neuqu�n",1158);
		dist[18]=new CiudadesDistancias("Buenos Aires","Viedma",960);
		dist[19]=new CiudadesDistancias("Buenos Aires","Rawson",1455);
		dist[20]=new CiudadesDistancias("Buenos Aires","Rio Gallegos",2635);
		dist[21]=new CiudadesDistancias("Buenos Aires","Ushuaia",3228);
		ciuds[0].setDistancias(dist);
		System.out.println(dist[5].getDistancia());
		//cargar distancias jujuy
		dist[0]=new CiudadesDistancias("San S. de Jujuy","Buenos Aires",1543);
		dist[1]=new CiudadesDistancias("San S. de Jujuy","Salta",99);
		dist[2]=new CiudadesDistancias("San S. de Jujuy","San M de Tucuman",340);
		dist[3]=new CiudadesDistancias("San S. de Jujuy","Sgo. del Estero",500);
		dist[4]=new CiudadesDistancias("San S. de Jujuy","Formosa",960);
		dist[5]=new CiudadesDistancias("San S. de Jujuy","Resistencia",860);
		dist[6]=new CiudadesDistancias("San S. de Jujuy","Santa Fe",1107);
		dist[7]=new CiudadesDistancias("San S. de Jujuy","Corrientes",883);
		dist[8]=new CiudadesDistancias("San S. de Jujuy","Posadas",1198);
		dist[9]=new CiudadesDistancias("San S. de Jujuy","Paran�",1138);
		dist[10]=new CiudadesDistancias("San S. de Jujuy","C�rdoba",930);
		dist[11]=new CiudadesDistancias("San S. de Jujuy","La Rioja",770);
		dist[12]=new CiudadesDistancias("San S. de Jujuy","San Juan",1220);
		dist[13]=new CiudadesDistancias("San S. de Jujuy","San Luis",1320);
		dist[14]=new CiudadesDistancias("San S. de Jujuy","Catamarca",572);
		dist[15]=new CiudadesDistancias("San S. de Jujuy","Mendoza",1345);
		dist[16]=new CiudadesDistancias("San S. de Jujuy","Santa Rosa",1530);
		dist[17]=new CiudadesDistancias("San S. de Jujuy","Neuqu�n",2200);
		dist[18]=new CiudadesDistancias("San S. de Jujuy","Viedma",2124);
		dist[19]=new CiudadesDistancias("San S. de Jujuy","Rawson",2385);
		dist[20]=new CiudadesDistancias("San S. de Jujuy","Rio Gallegos",3565);
		dist[21]=new CiudadesDistancias("San S. de Jujuy","Ushuaia",4158);
		System.out.println(dist[5].getDistancia());
		ciuds[1].setDistancias(dist);
		//cargar distancias salta
		dist[0]=new CiudadesDistancias("Salta","Buenos Aires",1510);
		dist[1]=new CiudadesDistancias("Salta","San S. de Jujuy",99);
		dist[2]=new CiudadesDistancias("Salta","San M de Tucuman",307);
		dist[3]=new CiudadesDistancias("Salta","Sgo. del Estero",467);
		dist[4]=new CiudadesDistancias("Salta","Formosa",948);
		dist[5]=new CiudadesDistancias("Salta","Resistencia",780);
		dist[6]=new CiudadesDistancias("Salta","Santa Fe",1074);
		dist[7]=new CiudadesDistancias("Salta","Corrientes",803);
		dist[8]=new CiudadesDistancias("Salta","Posadas",1118);
		dist[9]=new CiudadesDistancias("Salta","Paran�",1105);
		dist[10]=new CiudadesDistancias("Salta","C�rdoba",897);
		dist[11]=new CiudadesDistancias("Salta","La Rioja",695);
		dist[12]=new CiudadesDistancias("Salta","San Juan",1145);
		dist[13]=new CiudadesDistancias("Salta","San Luis",1245);
		dist[14]=new CiudadesDistancias("Salta","Catamarca",539);
		dist[15]=new CiudadesDistancias("Salta","Mendoza",1227);
		dist[16]=new CiudadesDistancias("Salta","Santa Rosa",1497);
		dist[17]=new CiudadesDistancias("Salta","Neuqu�n",2082);
		dist[18]=new CiudadesDistancias("Salta","Viedma",2091);
		dist[19]=new CiudadesDistancias("Salta","Rawson",2352);
		dist[20]=new CiudadesDistancias("Salta","Rio Gallegos",3532);
		dist[21]=new CiudadesDistancias("Salta","Ushuaia",4125);
		ciuds[2].setDistancias(dist);
		//cargar distancias tucuman
		dist[0]=new CiudadesDistancias("San M de Tucuman","Buenos Aires",1203);
		dist[1]=new CiudadesDistancias("San M de Tucuman","San S. de Jujuy",340);
		dist[2]=new CiudadesDistancias("San M de Tucuman","Salta",307);
		dist[3]=new CiudadesDistancias("San M de Tucuman","Sgo. del Estero",160);
		dist[4]=new CiudadesDistancias("San M de Tucuman","Formosa",936);
		dist[5]=new CiudadesDistancias("San M de Tucuman","Resistencia",768);
		dist[6]=new CiudadesDistancias("San M de Tucuman","Santa Fe",767);
		dist[7]=new CiudadesDistancias("San M de Tucuman","Corrientes",791);
		dist[8]=new CiudadesDistancias("San M de Tucuman","Posadas",1106);
		dist[9]=new CiudadesDistancias("San M de Tucuman","Paran�",798);
		dist[10]=new CiudadesDistancias("San M de Tucuman","C�rdoba",590);
		dist[11]=new CiudadesDistancias("San M de Tucuman","La Rioja",338);
		dist[12]=new CiudadesDistancias("San M de Tucuman","San Juan",838);
		dist[13]=new CiudadesDistancias("San M de Tucuman","San Luis",938);
		dist[14]=new CiudadesDistancias("San M de Tucuman","Catamarca",232);
		dist[15]=new CiudadesDistancias("San M de Tucuman","Mendoza",1005);
		dist[16]=new CiudadesDistancias("San M de Tucuman","Santa Rosa",1190);
		dist[17]=new CiudadesDistancias("San M de Tucuman","Neuqu�n",1860);
		dist[18]=new CiudadesDistancias("San M de Tucuman","Viedma",1784);
		dist[19]=new CiudadesDistancias("San M de Tucuman","Rawson",2045);
		dist[20]=new CiudadesDistancias("San M de Tucuman","Rio Gallegos",3225);
		dist[21]=new CiudadesDistancias("San M de Tucuman","Ushuaia",3818);
		ciuds[3].setDistancias(dist);
		//cargar distancias sgo del estero
		dist[0]=new CiudadesDistancias("Sgo. del Estero","Buenos Aires",1043);
		dist[1]=new CiudadesDistancias("Sgo. del Estero","Salta",467);
		dist[2]=new CiudadesDistancias("Sgo. del Estero","San S. de Jujuy",500);
		dist[3]=new CiudadesDistancias("Sgo. del Estero","San M de Tucuman",160);
		dist[4]=new CiudadesDistancias("Sgo. del Estero","Formosa",776);
		dist[5]=new CiudadesDistancias("Sgo. del Estero","Resistencia",610);
		dist[6]=new CiudadesDistancias("Sgo. del Estero","Santa Fe",607);
		dist[7]=new CiudadesDistancias("Sgo. del Estero","Corrientes",633);
		dist[8]=new CiudadesDistancias("Sgo. del Estero","Posadas",948);
		dist[9]=new CiudadesDistancias("Sgo. del Estero","Paran�",638);
		dist[10]=new CiudadesDistancias("Sgo. del Estero","C�rdoba",430);
		dist[11]=new CiudadesDistancias("Sgo. del Estero","La Rioja",360);
		dist[12]=new CiudadesDistancias("Sgo. del Estero","San Juan",810);
		dist[13]=new CiudadesDistancias("Sgo. del Estero","San Luis",850);
		dist[14]=new CiudadesDistancias("Sgo. del Estero","Catamarca",212);
		dist[15]=new CiudadesDistancias("Sgo. del Estero","Mendoza",977);
		dist[16]=new CiudadesDistancias("Sgo. del Estero","Santa Rosa",1030);
		dist[17]=new CiudadesDistancias("Sgo. del Estero","Neuqu�n",1567);
		dist[18]=new CiudadesDistancias("Sgo. del Estero","Viedma",1624);
		dist[19]=new CiudadesDistancias("Sgo. del Estero","Rawson",1885);
		dist[20]=new CiudadesDistancias("Sgo. del Estero","Rio Gallegos",3065);
		dist[21]=new CiudadesDistancias("Sgo. del Estero","Ushuaia",3658);
		ciuds[4].setDistancias(dist);
		//cargar distancias formosa
		dist[0]=new CiudadesDistancias("Formosa","Buenos Aires",1191);
		dist[1]=new CiudadesDistancias("Formosa","Salta",948);
		dist[2]=new CiudadesDistancias("Formosa","San M de Tucuman",936);
		dist[3]=new CiudadesDistancias("Formosa","Sgo. del Estero",776);
		dist[4]=new CiudadesDistancias("Formosa","San S. de Jujuy",960);
		dist[5]=new CiudadesDistancias("Formosa","Resistencia",168);
		dist[6]=new CiudadesDistancias("Formosa","Santa Fe",713);
		dist[7]=new CiudadesDistancias("Formosa","Corrientes",191);
		dist[8]=new CiudadesDistancias("Formosa","Posadas",506);
		dist[9]=new CiudadesDistancias("Formosa","Paran�",744);
		dist[10]=new CiudadesDistancias("Formosa","C�rdoba",1043);
		dist[11]=new CiudadesDistancias("Formosa","La Rioja",1136);
		dist[12]=new CiudadesDistancias("Formosa","San Juan",1543);
		dist[13]=new CiudadesDistancias("Formosa","San Luis",1463);
		dist[14]=new CiudadesDistancias("Formosa","Catamarca",988);
		dist[15]=new CiudadesDistancias("Formosa","Mendoza",1710);
		dist[16]=new CiudadesDistancias("Formosa","Santa Rosa",1523);
		dist[17]=new CiudadesDistancias("Formosa","Neuqu�n",2060);
		dist[18]=new CiudadesDistancias("Formosa","Viedma",2117);
		dist[19]=new CiudadesDistancias("Formosa","Rawson",2378);
		dist[20]=new CiudadesDistancias("Formosa","Rio Gallegos",3558);
		dist[21]=new CiudadesDistancias("Formosa","Ushuaia",4151);
		ciuds[5].setDistancias(dist);
		//cargar distancia resistencia
		dist[0]=new CiudadesDistancias("Resistencia","Buenos Aires",1023);
		dist[1]=new CiudadesDistancias("Resistencia","Salta",780);
		dist[2]=new CiudadesDistancias("Resistencia","San M de Tucuman",765);
		dist[3]=new CiudadesDistancias("Resistencia","Sgo. del Estero",610);
		dist[4]=new CiudadesDistancias("Resistencia","Formosa",168);
		dist[5]=new CiudadesDistancias("Resistencia","San S. de Jujuy",860);
		dist[6]=new CiudadesDistancias("Resistencia","Santa Fe",545);
		dist[7]=new CiudadesDistancias("Resistencia","Corrientes",23);
		dist[8]=new CiudadesDistancias("Resistencia","Posadas",338);
		dist[9]=new CiudadesDistancias("Resistencia","Paran�",576);
		dist[10]=new CiudadesDistancias("Resistencia","C�rdoba",875);
		dist[11]=new CiudadesDistancias("Resistencia","La Rioja",970);
		dist[12]=new CiudadesDistancias("Resistencia","San Juan",1420);
		dist[13]=new CiudadesDistancias("Resistencia","San Luis",1295);
		dist[14]=new CiudadesDistancias("Resistencia","Catamarca",822);
		dist[15]=new CiudadesDistancias("Resistencia","Mendoza",1587);
		dist[16]=new CiudadesDistancias("Resistencia","Santa Rosa",1475);
		dist[17]=new CiudadesDistancias("Resistencia","Neuqu�n",2012);
		dist[18]=new CiudadesDistancias("Resistencia","Viedma",2069);
		dist[19]=new CiudadesDistancias("Resistencia","Rawson",2210);
		dist[20]=new CiudadesDistancias("Resistencia","Rio Gallegos",3390);
		dist[21]=new CiudadesDistancias("Resistencia","Ushuaia",3983);
		ciuds[6].setDistancias(dist);
		//cargar distancia santa fe
		dist[0]=new CiudadesDistancias("Santa Fe","Buenos Aires",478);
		dist[1]=new CiudadesDistancias("Santa Fe","Salta",1074);
		dist[2]=new CiudadesDistancias("Santa Fe","San M de Tucuman",767);
		dist[3]=new CiudadesDistancias("Santa Fe","Sgo. del Estero",607);
		dist[4]=new CiudadesDistancias("Santa Fe","Formosa",713);
		dist[5]=new CiudadesDistancias("Santa Fe","Resistencia",545);
		dist[6]=new CiudadesDistancias("Santa Fe","San S. de Jujuy",1107);
		dist[7]=new CiudadesDistancias("Santa Fe","Corrientes",568);
		dist[8]=new CiudadesDistancias("Santa Fe","Posadas",883);
		dist[9]=new CiudadesDistancias("Santa Fe","Paran�",31);
		dist[10]=new CiudadesDistancias("Santa Fe","C�rdoba",330);
		dist[11]=new CiudadesDistancias("Santa Fe","La Rioja",765);
		dist[12]=new CiudadesDistancias("Santa Fe","San Juan",830);
		dist[13]=new CiudadesDistancias("Santa Fe","San Luis",625);
		dist[14]=new CiudadesDistancias("Santa Fe","Catamarca",770);
		dist[15]=new CiudadesDistancias("Santa Fe","Mendoza",885);
		dist[16]=new CiudadesDistancias("Santa Fe","Santa Rosa",810);
		dist[17]=new CiudadesDistancias("Santa Fe","Neuqu�n",1347);
		dist[18]=new CiudadesDistancias("Santa Fe","Viedma",1404);
		dist[19]=new CiudadesDistancias("Santa Fe","Rawson",1665);
		dist[20]=new CiudadesDistancias("Santa Fe","Rio Gallegos",2845);
		dist[21]=new CiudadesDistancias("Santa Fe","Ushuaia",3438);
		ciuds[7].setDistancias(dist);
		//cargar distancia corrientes
		dist[0]=new CiudadesDistancias("Corrientes","Buenos Aires",940);
		dist[1]=new CiudadesDistancias("Corrientes","Salta",803);
		dist[2]=new CiudadesDistancias("Corrientes","San M de Tucuman",791);
		dist[3]=new CiudadesDistancias("Corrientes","Sgo. del Estero",633);
		dist[4]=new CiudadesDistancias("Corrientes","Formosa",191);
		dist[5]=new CiudadesDistancias("Corrientes","Resistencia",23);
		dist[6]=new CiudadesDistancias("Corrientes","Santa Fe",568);
		dist[7]=new CiudadesDistancias("Corrientes","San S. de Jujuy",883);
		dist[8]=new CiudadesDistancias("Corrientes","Posadas",315);
		dist[9]=new CiudadesDistancias("Corrientes","Paran�",590);
		dist[10]=new CiudadesDistancias("Corrientes","C�rdoba",898);
		dist[11]=new CiudadesDistancias("Corrientes","La Rioja",993);
		dist[12]=new CiudadesDistancias("Corrientes","San Juan",1398);
		dist[13]=new CiudadesDistancias("Corrientes","San Luis",1318);
		dist[14]=new CiudadesDistancias("Corrientes","Catamarca",845);
		dist[15]=new CiudadesDistancias("Corrientes","Mendoza",1565);
		dist[16]=new CiudadesDistancias("Corrientes","Santa Rosa",1378);
		dist[17]=new CiudadesDistancias("Corrientes","Neuqu�n",1989);
		dist[18]=new CiudadesDistancias("Corrientes","Viedma",2046);
		dist[19]=new CiudadesDistancias("Corrientes","Rawson",2187);
		dist[20]=new CiudadesDistancias("Corrientes","Rio Gallegos",3367);
		dist[21]=new CiudadesDistancias("Corrientes","Ushuaia",3960);
		ciuds[8].setDistancias(dist);
		//cargar distancias posadas
		dist[0]=new CiudadesDistancias("Posadas","Buenos Aires",1040);
		dist[1]=new CiudadesDistancias("Posadas","Salta",1118);
		dist[2]=new CiudadesDistancias("Posadas","San M de Tucuman",1106);
		dist[3]=new CiudadesDistancias("Posadas","Sgo. del Estero",948);
		dist[4]=new CiudadesDistancias("Posadas","Formosa",506);
		dist[5]=new CiudadesDistancias("Posadas","Resistencia",338);
		dist[6]=new CiudadesDistancias("Posadas","Santa Fe",883);
		dist[7]=new CiudadesDistancias("Posadas","Corrientes",315);
		dist[8]=new CiudadesDistancias("Posadas","San S. de Jujuy",1198);
		dist[9]=new CiudadesDistancias("Posadas","Paran�",820);
		dist[10]=new CiudadesDistancias("Posadas","C�rdoba",1213);
		dist[11]=new CiudadesDistancias("Posadas","La Rioja",1308);
		dist[12]=new CiudadesDistancias("Posadas","San Juan",1758);
		dist[13]=new CiudadesDistancias("Posadas","San Luis",1633);
		dist[14]=new CiudadesDistancias("Posadas","Catamarca",1160);
		dist[15]=new CiudadesDistancias("Posadas","Mendoza",1925);
		dist[16]=new CiudadesDistancias("Posadas","Santa Rosa",1660);
		dist[17]=new CiudadesDistancias("Posadas","Neuqu�n",2198);
		dist[18]=new CiudadesDistancias("Posadas","Viedma",2000);
		dist[19]=new CiudadesDistancias("Posadas","Rawson",2445);
		dist[20]=new CiudadesDistancias("Posadas","Rio Gallegos",3675);
		dist[21]=new CiudadesDistancias("Posadas","Ushuaia",4268);
		ciuds[9].setDistancias(dist);
		//cargar distancias parana
		dist[0]=new CiudadesDistancias("Paran�","Buenos Aires",480);
		dist[1]=new CiudadesDistancias("Paran�","Salta",1105);
		dist[2]=new CiudadesDistancias("Paran�","San M de Tucuman",798);
		dist[3]=new CiudadesDistancias("Paran�","Sgo. del Estero",638);
		dist[4]=new CiudadesDistancias("Paran�","Formosa",744);
		dist[5]=new CiudadesDistancias("Paran�","Resistencia",576);
		dist[6]=new CiudadesDistancias("Paran�","Santa Fe",31);
		dist[7]=new CiudadesDistancias("Paran�","Corrientes",590);
		dist[8]=new CiudadesDistancias("Paran�","Posadas",820);
		dist[9]=new CiudadesDistancias("Paran�","San S. de Jujuy",1138);
		dist[10]=new CiudadesDistancias("Paran�","C�rdoba",361);
		dist[11]=new CiudadesDistancias("Paran�","La Rioja",796);
		dist[12]=new CiudadesDistancias("Paran�","San Juan",861);
		dist[13]=new CiudadesDistancias("Paran�","San Luis",656);
		dist[14]=new CiudadesDistancias("Paran�","Catamarca",801);
		dist[15]=new CiudadesDistancias("Paran�","Mendoza",916);
		dist[16]=new CiudadesDistancias("Paran�","Santa Rosa",841);
		dist[17]=new CiudadesDistancias("Paran�","Neuqu�n",1378);
		dist[18]=new CiudadesDistancias("Paran�","Viedma",1435);
		dist[19]=new CiudadesDistancias("Paran�","Rawson",1696);
		dist[20]=new CiudadesDistancias("Paran�","Rio Gallegos",2876);
		dist[21]=new CiudadesDistancias("Paran�","Ushuaia",3469);
		ciuds[10].setDistancias(dist);
		//cargar distancias cordoba
		dist[0]=new CiudadesDistancias("C�rdoba","Buenos Aires",715);
		dist[1]=new CiudadesDistancias("C�rdoba","Salta",897);
		dist[2]=new CiudadesDistancias("C�rdoba","San M de Tucuman",590);
		dist[3]=new CiudadesDistancias("C�rdoba","Sgo. del Estero",430);
		dist[4]=new CiudadesDistancias("C�rdoba","Formosa",1043);
		dist[5]=new CiudadesDistancias("C�rdoba","Resistencia",875);
		dist[6]=new CiudadesDistancias("C�rdoba","Santa Fe",330);
		dist[7]=new CiudadesDistancias("C�rdoba","Corrientes",898);
		dist[8]=new CiudadesDistancias("C�rdoba","Posadas",1231);
		dist[9]=new CiudadesDistancias("C�rdoba","Paran�",361);
		dist[10]=new CiudadesDistancias("C�rdoba","San S. de Jujuy",930);
		dist[11]=new CiudadesDistancias("C�rdoba","La Rioja",435);
		dist[12]=new CiudadesDistancias("C�rdoba","San Juan",500);
		dist[13]=new CiudadesDistancias("C�rdoba","San Luis",420);
		dist[14]=new CiudadesDistancias("C�rdoba","Catamarca",440);
		dist[15]=new CiudadesDistancias("C�rdoba","Mendoza",670);
		dist[16]=new CiudadesDistancias("C�rdoba","Santa Rosa",600);
		dist[17]=new CiudadesDistancias("C�rdoba","Neuqu�n",1137);
		dist[18]=new CiudadesDistancias("C�rdoba","Viedma",1194);
		dist[19]=new CiudadesDistancias("C�rdoba","Rawson",1455);
		dist[20]=new CiudadesDistancias("C�rdoba","Rio Gallegos",3635);
		dist[21]=new CiudadesDistancias("C�rdoba","Ushuaia",3228);
		ciuds[11].setDistancias(dist);
		//cargar distancias la rioja
		dist[0]=new CiudadesDistancias("La Rioja","Buenos Aires",1150);
		dist[1]=new CiudadesDistancias("La Rioja","Salta",695);
		dist[2]=new CiudadesDistancias("La Rioja","San M de Tucuman",388);
		dist[3]=new CiudadesDistancias("La Rioja","Sgo. del Estero",360);
		dist[4]=new CiudadesDistancias("La Rioja","Formosa",1136);
		dist[5]=new CiudadesDistancias("La Rioja","Resistencia",970);
		dist[6]=new CiudadesDistancias("La Rioja","Santa Fe",765);
		dist[7]=new CiudadesDistancias("La Rioja","Corrientes",993);
		dist[8]=new CiudadesDistancias("La Rioja","Posadas",1308);
		dist[9]=new CiudadesDistancias("La Rioja","Paran�",796);
		dist[10]=new CiudadesDistancias("La Rioja","C�rdoba",435);
		dist[11]=new CiudadesDistancias("La Rioja","San S. de Jujuy",770);
		dist[12]=new CiudadesDistancias("La Rioja","San Juan",450);
		dist[13]=new CiudadesDistancias("La Rioja","San Luis",550);
		dist[14]=new CiudadesDistancias("La Rioja","Catamarca",156);
		dist[15]=new CiudadesDistancias("La Rioja","Mendoza",617);
		dist[16]=new CiudadesDistancias("La Rioja","Santa Rosa",1035);
		dist[17]=new CiudadesDistancias("La Rioja","Neuqu�n",1472);
		dist[18]=new CiudadesDistancias("La Rioja","Viedma",1629);
		dist[19]=new CiudadesDistancias("La Rioja","Rawson",1890);
		dist[20]=new CiudadesDistancias("La Rioja","Rio Gallegos",3070);
		dist[21]=new CiudadesDistancias("La Rioja","Ushuaia",3663);
		ciuds[12].setDistancias(dist);
		//cargar distancias san juan
		dist[0]=new CiudadesDistancias("San Juan","Buenos Aires",1110);
		dist[1]=new CiudadesDistancias("San Juan","Salta",1145);
		dist[2]=new CiudadesDistancias("San Juan","San M de Tucuman",838);
		dist[3]=new CiudadesDistancias("San Juan","Sgo. del Estero",810);
		dist[4]=new CiudadesDistancias("San Juan","Formosa",1543);
		dist[5]=new CiudadesDistancias("San Juan","Resistencia",1420);
		dist[6]=new CiudadesDistancias("San Juan","Santa Fe",830);
		dist[7]=new CiudadesDistancias("San Juan","Corrientes",1398);
		dist[8]=new CiudadesDistancias("San Juan","Posadas",1758);
		dist[9]=new CiudadesDistancias("San Juan","Paran�",861);
		dist[10]=new CiudadesDistancias("San Juan","C�rdoba",500);
		dist[11]=new CiudadesDistancias("San Juan","La Rioja",450);
		dist[12]=new CiudadesDistancias("San Juan","San S. de Jujuy",1220);
		dist[13]=new CiudadesDistancias("San Juan","San Luis",320);
		dist[14]=new CiudadesDistancias("San Juan","Catamarca",606);
		dist[15]=new CiudadesDistancias("San Juan","Mendoza",167);
		dist[16]=new CiudadesDistancias("San Juan","Santa Rosa",825);
		dist[17]=new CiudadesDistancias("San Juan","Neuqu�n",1022);
		dist[18]=new CiudadesDistancias("San Juan","Viedma",1419);
		dist[19]=new CiudadesDistancias("San Juan","Rawson",1680);
		dist[20]=new CiudadesDistancias("San Juan","Rio Gallegos",2860);
		dist[21]=new CiudadesDistancias("San Juan","Ushuaia",3453);
		ciuds[13].setDistancias(dist);
		//cargar distancias san luis
		dist[0]=new CiudadesDistancias("San Luis","Buenos Aires",790);
		dist[1]=new CiudadesDistancias("San Luis","Salta",1245);
		dist[2]=new CiudadesDistancias("San Luis","San M de Tucuman",938);
		dist[3]=new CiudadesDistancias("San Luis","Sgo. del Estero",850);
		dist[4]=new CiudadesDistancias("San Luis","Formosa",1463);
		dist[5]=new CiudadesDistancias("San Luis","Resistencia",1295);
		dist[6]=new CiudadesDistancias("San Luis","Santa Fe",625);
		dist[7]=new CiudadesDistancias("San Luis","Corrientes",1318);
		dist[8]=new CiudadesDistancias("San Luis","Posadas",1633);
		dist[9]=new CiudadesDistancias("San Luis","Paran�",656);
		dist[10]=new CiudadesDistancias("San Luis","C�rdoba",420);
		dist[11]=new CiudadesDistancias("San Luis","La Rioja",550);
		dist[12]=new CiudadesDistancias("San Luis","San Juan",320);
		dist[13]=new CiudadesDistancias("San Luis","San S. de Jujuy",1320);
		dist[14]=new CiudadesDistancias("San Luis","Catamarca",705);
		dist[15]=new CiudadesDistancias("San Luis","Mendoza",260);
		dist[16]=new CiudadesDistancias("San Luis","Santa Rosa",505);
		dist[17]=new CiudadesDistancias("San Luis","Neuqu�n",883);
		dist[18]=new CiudadesDistancias("San Luis","Viedma",1099);
		dist[19]=new CiudadesDistancias("San Luis","Rawson",1360);
		dist[20]=new CiudadesDistancias("San Luis","Rio Gallegos",2540);
		dist[21]=new CiudadesDistancias("San Luis","Ushuaia",3133);
		ciuds[14].setDistancias(dist);
		//cargar distancias catamarca
		dist[0]=new CiudadesDistancias("Catamarca","Buenos Aires",1145);
		dist[1]=new CiudadesDistancias("Catamarca","Salta",539);
		dist[2]=new CiudadesDistancias("Catamarca","San M de Tucuman",232);
		dist[3]=new CiudadesDistancias("Catamarca","Sgo. del Estero",212);
		dist[4]=new CiudadesDistancias("Catamarca","Formosa",988);
		dist[5]=new CiudadesDistancias("Catamarca","Resistencia",822);
		dist[6]=new CiudadesDistancias("Catamarca","Santa Fe",770);
		dist[7]=new CiudadesDistancias("Catamarca","Corrientes",845);
		dist[8]=new CiudadesDistancias("Catamarca","Posadas",1160);
		dist[9]=new CiudadesDistancias("Catamarca","Paran�",801);
		dist[10]=new CiudadesDistancias("Catamarca","C�rdoba",440);
		dist[11]=new CiudadesDistancias("Catamarca","La Rioja",156);
		dist[12]=new CiudadesDistancias("Catamarca","San Juan",606);
		dist[13]=new CiudadesDistancias("Catamarca","San Luis",705);
		dist[14]=new CiudadesDistancias("Catamarca","San S. de Jujuy",572);
		dist[15]=new CiudadesDistancias("Catamarca","Mendoza",773);
		dist[16]=new CiudadesDistancias("Catamarca","Santa Rosa",1040);
		dist[17]=new CiudadesDistancias("Catamarca","Neuqu�n",1588);
		dist[18]=new CiudadesDistancias("Catamarca","Viedma",1634);
		dist[19]=new CiudadesDistancias("Catamarca","Rawson",1895);
		dist[20]=new CiudadesDistancias("Catamarca","Rio Gallegos",3075);
		dist[21]=new CiudadesDistancias("Catamarca","Ushuaia",3668);
		ciuds[15].setDistancias(dist);
		//cargar distancias mendoza
		dist[0]=new CiudadesDistancias("Mendoza","Buenos Aires",1050);
		dist[1]=new CiudadesDistancias("Mendoza","Salta",1227);
		dist[2]=new CiudadesDistancias("Mendoza","San M de Tucuman",1005);
		dist[3]=new CiudadesDistancias("Mendoza","Sgo. del Estero",977);
		dist[4]=new CiudadesDistancias("Mendoza","Formosa",1710);
		dist[5]=new CiudadesDistancias("Mendoza","Resistencia",1587);
		dist[6]=new CiudadesDistancias("Mendoza","Santa Fe",885);
		dist[7]=new CiudadesDistancias("Mendoza","Corrientes",1565);
		dist[8]=new CiudadesDistancias("Mendoza","Posadas",1925);
		dist[9]=new CiudadesDistancias("Mendoza","Paran�",916);
		dist[10]=new CiudadesDistancias("Mendoza","C�rdoba",670);
		dist[11]=new CiudadesDistancias("Mendoza","La Rioja",617);
		dist[12]=new CiudadesDistancias("Mendoza","San Juan",167);
		dist[13]=new CiudadesDistancias("Mendoza","San Luis",260);
		dist[14]=new CiudadesDistancias("Mendoza","Catamarca",773);
		dist[15]=new CiudadesDistancias("Mendoza","San S. de Jujuy",1345);
		dist[16]=new CiudadesDistancias("Mendoza","Santa Rosa",765);
		dist[17]=new CiudadesDistancias("Mendoza","Neuqu�n",855);
		dist[18]=new CiudadesDistancias("Mendoza","Viedma",1359);
		dist[19]=new CiudadesDistancias("Mendoza","Rawson",1620);
		dist[20]=new CiudadesDistancias("Mendoza","Rio Gallegos",2800);
		dist[21]=new CiudadesDistancias("Mendoza","Ushuaia",3393);
		ciuds[16].setDistancias(dist);
		//cargar distancias Santa rosa
		dist[0]=new CiudadesDistancias("Santa Rosa","Buenos Aires",620);
		dist[1]=new CiudadesDistancias("Santa Rosa","Salta",1497);
		dist[2]=new CiudadesDistancias("Santa Rosa","San M de Tucuman",1190);
		dist[3]=new CiudadesDistancias("Santa Rosa","Sgo. del Estero",1030);
		dist[4]=new CiudadesDistancias("Santa Rosa","Formosa",1523);
		dist[5]=new CiudadesDistancias("Santa Rosa","Resistencia",1475);
		dist[6]=new CiudadesDistancias("Santa Rosa","Santa Fe",810);
		dist[7]=new CiudadesDistancias("Santa Rosa","Corrientes",1378);
		dist[8]=new CiudadesDistancias("Santa Rosa","Posadas",1660);
		dist[9]=new CiudadesDistancias("Santa Rosa","Paran�",841);
		dist[10]=new CiudadesDistancias("Santa Rosa","C�rdoba",600);
		dist[11]=new CiudadesDistancias("Santa Rosa","La Rioja",1035);
		dist[12]=new CiudadesDistancias("Santa Rosa","San Juan",825);
		dist[13]=new CiudadesDistancias("Santa Rosa","San Luis",505);
		dist[14]=new CiudadesDistancias("Santa Rosa","Catamarca",1040);
		dist[15]=new CiudadesDistancias("Santa Rosa","Mendoza",765);
		dist[16]=new CiudadesDistancias("Santa Rosa","San S. de Jujuy",1530);
		dist[17]=new CiudadesDistancias("Santa Rosa","Neuqu�n",537);
		dist[18]=new CiudadesDistancias("Santa Rosa","Viedma",594);
		dist[19]=new CiudadesDistancias("Santa Rosa","Rawson",855);
		dist[20]=new CiudadesDistancias("Santa Rosa","Rio Gallegos",2035);
		dist[21]=new CiudadesDistancias("Santa Rosa","Ushuaia",2628);
		ciuds[17].setDistancias(dist);
		//cargar distancias neuquen
		dist[0]=new CiudadesDistancias("Neuqu�n","Buenos Aires",1158);
		dist[1]=new CiudadesDistancias("Neuqu�n","Salta",2082);
		dist[2]=new CiudadesDistancias("Neuqu�n","San M de Tucuman",1860);
		dist[3]=new CiudadesDistancias("Neuqu�n","Sgo. del Estero",1567);
		dist[4]=new CiudadesDistancias("Neuqu�n","Formosa",2060);
		dist[5]=new CiudadesDistancias("Neuqu�n","Resistencia",2012);
		dist[6]=new CiudadesDistancias("Neuqu�n","Santa Fe",1347);
		dist[7]=new CiudadesDistancias("Neuqu�n","Corrientes",1989);
		dist[8]=new CiudadesDistancias("Neuqu�n","Posadas",2198);
		dist[9]=new CiudadesDistancias("Neuqu�n","Paran�",1378);
		dist[10]=new CiudadesDistancias("Neuqu�n","C�rdoba",1137);
		dist[11]=new CiudadesDistancias("Neuqu�n","La Rioja",1472);
		dist[12]=new CiudadesDistancias("Neuqu�n","San Juan",1022);
		dist[13]=new CiudadesDistancias("Neuqu�n","San Luis",883);
		dist[14]=new CiudadesDistancias("Neuqu�n","Catamarca",1588);
		dist[15]=new CiudadesDistancias("Neuqu�n","Mendoza",855);
		dist[16]=new CiudadesDistancias("Neuqu�n","Santa Rosa",537);
		dist[17]=new CiudadesDistancias("Neuqu�n","San S. de Jujuy",2200);
		dist[18]=new CiudadesDistancias("Neuqu�n","Viedma",660);
		dist[19]=new CiudadesDistancias("Neuqu�n","Rawson",750);
		dist[20]=new CiudadesDistancias("Neuqu�n","Rio Gallegos",1930);
		dist[21]=new CiudadesDistancias("Neuqu�n","Ushuaia",2523);
		ciuds[18].setDistancias(dist);
		//cargar distancias viedma
		dist[0]=new CiudadesDistancias("Viedma","Buenos Aires",960);
		dist[1]=new CiudadesDistancias("Viedma","Salta",2091);
		dist[2]=new CiudadesDistancias("Viedma","San M de Tucuman",1784);
		dist[3]=new CiudadesDistancias("Viedma","Sgo. del Estero",1624);
		dist[4]=new CiudadesDistancias("Viedma","Formosa",2117);
		dist[5]=new CiudadesDistancias("Viedma","Resistencia",2069);
		dist[6]=new CiudadesDistancias("Viedma","Santa Fe",1404);
		dist[7]=new CiudadesDistancias("Viedma","Corrientes",2046);
		dist[8]=new CiudadesDistancias("Viedma","Posadas",2000);
		dist[9]=new CiudadesDistancias("Viedma","Paran�",1435);
		dist[10]=new CiudadesDistancias("Viedma","C�rdoba",1194);
		dist[11]=new CiudadesDistancias("Viedma","La Rioja",1629);
		dist[12]=new CiudadesDistancias("Viedma","San Juan",1419);
		dist[13]=new CiudadesDistancias("Viedma","San Luis",1099);
		dist[14]=new CiudadesDistancias("Viedma","Catamarca",1634);
		dist[15]=new CiudadesDistancias("Viedma","Mendoza",1359);
		dist[16]=new CiudadesDistancias("Viedma","Santa Rosa",594);
		dist[17]=new CiudadesDistancias("Viedma","Neuqu�n",660);
		dist[18]=new CiudadesDistancias("Viedma","San S. de Jujuy",2124);
		dist[19]=new CiudadesDistancias("Viedma","Rawson",495);
		dist[20]=new CiudadesDistancias("Viedma","Rio Gallegos",1180);
		dist[21]=new CiudadesDistancias("Viedma","Ushuaia",1773);
		ciuds[19].setDistancias(dist);
		//cargar distancias rio rawson
		dist[0]=new CiudadesDistancias("Rawson","Buenos Aires",1455);
		dist[1]=new CiudadesDistancias("Rawson","Salta",2352);
		dist[2]=new CiudadesDistancias("Rawson","San M de Tucuman",2045);
		dist[3]=new CiudadesDistancias("Rawson","Sgo. del Estero",1885);
		dist[4]=new CiudadesDistancias("Rawson","Formosa",2378);
		dist[5]=new CiudadesDistancias("Rawson","Resistencia",2210);
		dist[6]=new CiudadesDistancias("Rawson","Santa Fe",1665);
		dist[7]=new CiudadesDistancias("Rawson","Corrientes",2187);
		dist[8]=new CiudadesDistancias("Rawson","Posadas",2495);
		dist[9]=new CiudadesDistancias("Rawson","Paran�",1696);
		dist[10]=new CiudadesDistancias("Rawson","C�rdoba",1455);
		dist[11]=new CiudadesDistancias("Rawson","La Rioja",1890);
		dist[12]=new CiudadesDistancias("Rawson","San Juan",1680);
		dist[13]=new CiudadesDistancias("Rawson","San Luis",1360);
		dist[14]=new CiudadesDistancias("Rawson","Catamarca",1895);
		dist[15]=new CiudadesDistancias("Rawson","Mendoza",1620);
		dist[16]=new CiudadesDistancias("Rawson","Santa Rosa",855);
		dist[17]=new CiudadesDistancias("Rawson","Neuqu�n",750);
		dist[18]=new CiudadesDistancias("Rawson","Viedma",495);
		dist[19]=new CiudadesDistancias("Rawson","San S. de Jujuy",2385);
		dist[20]=new CiudadesDistancias("Rawson","Rio Gallegos",1180);
		dist[21]=new CiudadesDistancias("Rawson","Ushuaia",1773);
		ciuds[20].setDistancias(dist);
		//cargar distancias rio gallegos
		dist[0]=new CiudadesDistancias("Rio Gallegos","Buenos Aires",2635);
		dist[1]=new CiudadesDistancias("Rio Gallegos","Salta",3532);
		dist[2]=new CiudadesDistancias("Rio Gallegos","San M de Tucuman",3225);
		dist[3]=new CiudadesDistancias("Rio Gallegos","Sgo. del Estero",3065);
		dist[4]=new CiudadesDistancias("Rio Gallegos","Formosa",3558);
		dist[5]=new CiudadesDistancias("Rio Gallegos","Resistencia",3390);
		dist[6]=new CiudadesDistancias("Rio Gallegos","Santa Fe",2845);
		dist[7]=new CiudadesDistancias("Rio Gallegos","Corrientes",3367);
		dist[8]=new CiudadesDistancias("Rio Gallegos","Posadas",3675);
		dist[9]=new CiudadesDistancias("Rio Gallegos","Paran�",2876);
		dist[10]=new CiudadesDistancias("Rio Gallegos","C�rdoba",2635);
		dist[11]=new CiudadesDistancias("Rio Gallegos","La Rioja",3070);
		dist[12]=new CiudadesDistancias("Rio Gallegos","San Juan",2860);
		dist[13]=new CiudadesDistancias("Rio Gallegos","San Luis",2540);
		dist[14]=new CiudadesDistancias("Rio Gallegos","Catamarca",3075);
		dist[15]=new CiudadesDistancias("Rio Gallegos","Mendoza",2800);
		dist[16]=new CiudadesDistancias("Rio Gallegos","Santa Rosa",2035);
		dist[17]=new CiudadesDistancias("Rio Gallegos","Neuqu�n",1930);
		dist[18]=new CiudadesDistancias("Rio Gallegos","Viedma",1675);
		dist[19]=new CiudadesDistancias("Rio Gallegos","Rawson",1180);
		dist[20]=new CiudadesDistancias("Rio Gallegos","San S. de Jujuy",3565);
		dist[21]=new CiudadesDistancias("Rio Gallegos","Ushuaia",593);
		ciuds[21].setDistancias(dist);
		//cargar distancias ushuaia
		dist[0]=new CiudadesDistancias("Ushuaia","Buenos Aires",3228);
		dist[20]=new CiudadesDistancias("Ushuaia","San S. de Jujuy",4158);
		dist[1]=new CiudadesDistancias("Ushuaia","Salta",4125);
		dist[2]=new CiudadesDistancias("Ushuaia","San M de Tucuman",3818);
		dist[3]=new CiudadesDistancias("Ushuaia","Sgo. del Estero",3658);
		dist[4]=new CiudadesDistancias("Ushuaia","Formosa",4151);
		dist[5]=new CiudadesDistancias("Ushuaia","Resistencia",3983);
		dist[6]=new CiudadesDistancias("Ushuaia","Santa Fe",3438);
		dist[7]=new CiudadesDistancias("Ushuaia","Corrientes",3960);
		dist[8]=new CiudadesDistancias("Ushuaia","Posadas",4268);
		dist[9]=new CiudadesDistancias("Ushuaia","Paran�",3469);
		dist[10]=new CiudadesDistancias("Ushuaia","C�rdoba",3228);
		dist[11]=new CiudadesDistancias("Ushuaia","La Rioja",3660);
		dist[12]=new CiudadesDistancias("Ushuaia","San Juan",3453);
		dist[13]=new CiudadesDistancias("Ushuaia","San Luis",3133);
		dist[14]=new CiudadesDistancias("Ushuaia","Catamarca",3668);
		dist[15]=new CiudadesDistancias("Ushuaia","Mendoza",3393);
		dist[16]=new CiudadesDistancias("Ushuaia","Santa Rosa",2628);
		dist[17]=new CiudadesDistancias("Ushuaia","Neuqu�n",2523);
		dist[18]=new CiudadesDistancias("Ushuaia","Viedma",2228);
		dist[19]=new CiudadesDistancias("Ushuaia","Rawson",1773);
		
		dist[21]=new CiudadesDistancias("Rio Gallegos","Ushuaia",593);
		ciuds[22].setDistancias(dist);
		
		
		
				
		
		
		
		
		
		
	}

}
