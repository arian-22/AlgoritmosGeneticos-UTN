package fractales;
import java.applet.Applet;
import java.awt.Graphics;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

public class Fractales extends Applet {

	private static final long serialVersionUID = 1L;
	double xp1 = 10;
	double yp1 = 20;
	double xp2 = 150;
	double yp2 = 20;
	int nivel_de_recursividad = 6;
	
	public Fractales() { }
	
	public static void main(String[] args) { }
	
	public void paint(Graphics g){
	   paintRecursivo(g,nivel_de_recursividad,xp1,yp1,xp2,yp2);
	 }
	
	private void paintRecursivo(Graphics g, int i, double xp12, double yp12, double xp22, double yp22 ) {
		
		if(i == nivel_de_recursividad){
			g.drawLine((int)xp12,(int)yp12,(int)xp22,(int)yp22);
		}else{
			g.drawLine((int)xp12,(int)yp12,(int)xp22,(int)yp22);
			//g.drawLine((int)xp12*3,(int)yp12,(int)xp22*3,(int)yp22);
		}
	
		double dx = (xp22-xp12)/3;
		System.out.println("Punto X: " + dx);
		
		//Bajar la posicion Y
		double dy1 = (yp12) + 5;
		double dy2 = (yp22) + 5;
		 
		// paintRecursivo(g,i-1,xp12,yp12,dx,dy);
		
		if(i<=0){
				 g.drawLine((int)xp12,(int)dy1,(int)dx,(int)(dy2));
				 g.drawLine((int)xp12*3,(int)dy1,(int)dx*3,(int)(dy2));
			 }else{
				paintRecursivo(g,(i-1),xp12,dy1,dx, dy2);
			 }
		
	 }
}
