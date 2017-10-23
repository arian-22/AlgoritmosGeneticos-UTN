package fractales;
import java.applet.Applet;
import java.awt.*;

@SuppressWarnings("serial")
public class Cantorcito extends Applet{
		 
	    // Atributos
	        String cjto;
	        int fases = 0;
	        int recto = 0;
	        int cp[] = {250,60,550,350};
	        
		void ListaConjuntos_Action(Event event) {
			// to do: place event handler code here.
	        //cjto = Lista_conjuntos.getSelectedItem();
			// Repaint the Panel
			//repaint(cp[0],cp[1],cp[2]-cp[0],cp[3]-cp[1]);
			//}}
		}
			
		void bajarFases_Clicked(Event event) {
		    if (fases > 0) fases --;
		    sel_fases.setText(Integer.toString(fases));
		    repaint(cp[0],cp[1],cp[2]-cp[0],cp[3]-cp[1]);
			// to do: place event handler code here.
		}

		void subirFases_Clicked(Event event) {
		    fases ++;
		    sel_fases.setText(Integer.toString(fases));
		    repaint(cp[0],cp[1],cp[2]-cp[0],cp[3]-cp[1]);
			// to do: place event handler code here.
		}
		
		public void init() {
			super.init();
			//{{INIT_CONTROLS
			setLayout(null);
			addNotify();
			resize(591,383);
			setBackground(new Color(16777215));
			
			Etiqueta = new java.awt.Label("Conjunto de Cantor",Label.CENTER);
			Etiqueta.reshape(60,12,446,39);
			Etiqueta.setFont(new Font("TimesRoman", Font.BOLD|Font.ITALIC, 40));
			add(Etiqueta);
			Etiqueta2 = new java.awt.Label("Fases:");
			Etiqueta2.reshape(36,132,63,29);
			Etiqueta2.setFont(new Font("Dialog", Font.BOLD, 14));
			add(Etiqueta2);
			sel_fases = new java.awt.TextField();
			sel_fases.setEditable(false);
			sel_fases.setText("0");
			sel_fases.reshape(108,132,36,23);
			add(sel_fases);
			subir_fases = new java.awt.Button("+");
			subir_fases.reshape(156,132,18,14);
			add(subir_fases);
			bajar_fases = new java.awt.Button("-");
			bajar_fases.reshape(156,144,18,14);
			add(bajar_fases);
			//}}
		}

		public boolean handleEvent(Event event) {
			if (event.target == Lista_conjuntos && event.id == Event.ACTION_EVENT) {
				ListaConjuntos_Action(event);
				return true;
			}
			if (event.target == subir_fases && event.id == Event.ACTION_EVENT) {
				subirFases_Clicked(event);
				return true;
			}
			if (event.target == bajar_fases && event.id == Event.ACTION_EVENT) {
				bajarFases_Clicked(event);
				return true;
			}
			return super.handleEvent(event);
		}

		//{{DECLARE_CONTROLS
		java.awt.Choice Lista_conjuntos;
		java.awt.Label Etiqueta;
		java.awt.Label Etiqueta2;
		java.awt.TextField sel_fases;
		java.awt.Button subir_fases;
		java.awt.Button bajar_fases;
		
		//}}
		
		
	public void paint(Graphics g){
        //setBackground(Color.white);
        g.drawRect(cp[0],cp[1],cp[2]-cp[0],cp[3]-cp[1]);
        
            int x1,x2,y;
            x1 = cp[0]+ 10;
            x2 = cp[2]- 10;
            y  = ((cp[3]-cp[1])/2)+ cp[1];
            g.drawLine(x1,y,x2,y);
            cantorizar(g,x1,y,x2,y,fases);
        
        }
	 public void cantorizar(Graphics g,int x1, int y1, int x2, int y2,int f){
	        float untercio,dostercios;
	        untercio = (x1+((x2-x1)/3)) ;
	        dostercios = (2*((x2-x1)/3))+x1;
	        g.setColor(Color.white);
	        if (f > 0) {
	            f--;
	            g.drawLine((int)untercio,y1,(int)dostercios,y2);
	            cantorizar(g, x1, y1, (int)untercio , y2,f);
	            cantorizar(g, (int)dostercios, y1, x2, y2,f);
	        }

	 	}
}