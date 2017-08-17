
import java.util.Arrays;
public class Ciudad {
	private String nombre;
	private int id;
	private CiudadesDistancias[] distanciasC=new CiudadesDistancias[22];
	private boolean visitado=false;
	Ciudad(int idd, String nom)
	{
		nombre=nom;
		id=idd;
		
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public CiudadesDistancias[] getDistancias() {
		return distanciasC;
	}
	public void setDistancias(CiudadesDistancias[] distancias) {
		this.distanciasC = distancias;
	}
	public boolean getVisitado()
	{
		return visitado;
	}
	public void setVisitado()
	{
		this.visitado=true;
	}
	
}
