package fractales;
import java.applet.Applet;
import java.awt.Graphics;

public class Fractales extends Applet {
 double xp1=10;
 double yp1=20;
 double xp2=150;
 double yp2=20;
 int nivel_de_recursividad=6;

 public Fractales() { }

 public static void main(String[] args) { }

 public void paint(Graphics g){
   paintRecursivo(g,nivel_de_recursividad,xp1,yp1,xp2,yp2);
 }

 private void paintRecursivo(Graphics g, int i, double xp12, double yp12, double xp22, double yp22 ) {
	 g.drawLine((int)xp12,(int)yp12,(int)xp22,(int)yp22);
	 
	 double dx = (xp22)/3;
	 
	 //double 
	 
	// paintRecursivo(g,i-1,xp12,yp12,dx,dy);
	 
	 if(i<=0){
		 g.drawLine((int)xp12,(int)(yp12+10),(int)xp22,(int)(yp22+10));
	 }else{
		// paintRecursivo(g,(i-1),xp12,yp12,dx1,dx2);
	 }
/*
 double dx=(xp22-xp12)/3.;
  double dy=(yp22-yp12)/3.;

  double dx1=(xp22+xp12)/2.;
  double dy1=(yp22+yp12)/2.;
  double dx2=(xp32+xp22)/2.;
  double dy2=(yp32+yp22)/2.;
  double dx3=(xp12+xp32)/2.;
  double dy3=(yp12+yp32)/2.;

  if(i<=0){
   g.drawLine((int)xp12,(int)yp12,(int)xp22,(int)yp22);
   g.drawLine((int)xp22,(int)yp22,(int)xp32,(int)yp32);
   g.drawLine((int)xp32,(int)yp32,(int)xp12,(int)yp12);
  }
  else{
   paintRecursivo(g,i-1,xp12,yp12,dx1,dy1);
   paintRecursivo(g,i-1,dx1,dy1,xp22,yp22);
   paintRecursivo(g,i-1,dx3,dy3,dx2,dy2);
  }
*/
 }
}

