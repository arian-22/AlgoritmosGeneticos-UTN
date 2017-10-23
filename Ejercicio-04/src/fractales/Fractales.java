package fractales;
import java.applet.Applet;
import java.awt.Graphics;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

public class Fractales extends Applet {
	private static final long serialVersionUID = 1L;
	double xp1 = 0;
	double yp1 = 20;
	double xp2 = 150;
	double yp2 = 20;
	int nivel_de_recursividad = 2;
	public Fractales() { }
	
	public static void main(String[] args) { }
	
	public void paint(Graphics g){
	   paintRecursivo(g,nivel_de_recursividad,xp1,yp1,xp2,yp2);
	 }
	
	
	private void paintRecursivo(Graphics g, int x, double xp12, double yp12, double xp22, double yp22 ) 
	{

		//PREGUNTO SI ES LA PRIMER FASE
		 if (x == 0) {
	            x--;
	            //SI ES LA PRIMERA DIBUJO LA LINEA
	            g.drawLine((int)xp12,(int)yp12,(int)xp22,(int)yp22);
	            }
		 //SINO HAY Q CORTAR
	            else
	            {      		
//INTERVALO [0,xp22/3]
	            double dx = xp22/3;
//INTERVALO [xp22/dxx] (EL QUE SE TIENE QUE BORRAR)
	            double dxx= 2*dx;
//INTERVALO [dxx,xp22]
	            double dxxx=3*dx;
//CON ESTO BAJO 5 LUGARES	        	
	            double dy1 = (yp12) + 5;
				double dy2 = (yp22) + 5;

//primer linea
				g.drawLine((int)xp12,(int)yp12,(int)xp22,(int)yp22);
				/*esto me dibuja la segunda linea en la fase 1*/ g.drawLine((int)(dxx),(int)dy1,(int)(dxxx),(int)dy2);
							/*habria que replicar lo que hace esta linea para las demas fases*/				
				paintRecursivo((Graphics) g, (int) x, (double) xp12, (double) dy1, (double) dx, (double) dy2);
				paintRecursivo((Graphics) g, (int) x, (double) dxx, (double) dy1, (double) dxxx, (double) dy2);
	        

		}
		 
	
	}

		
	 }