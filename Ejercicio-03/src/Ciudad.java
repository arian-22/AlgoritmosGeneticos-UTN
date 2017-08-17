
import java.util.Arrays;
public class Ciudad {
	private String nombre;
	private int id;
	private CiudadesDistancias[] distanciasC=new CiudadesDistancias[22];
	private int visitado=0;
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
	public CiudadesDistancias getDistancias(int i) {
		return distanciasC[i];
	}
	public void setDistancias(CiudadesDistancias[] distancias) {
		this.distanciasC = distancias;
	}
	public int getVisitado()
	{
		return visitado;
	}
	public void setVisitado()
	{
		this.visitado=1;
	}
	
}
