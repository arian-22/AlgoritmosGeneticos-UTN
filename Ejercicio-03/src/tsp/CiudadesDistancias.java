package tsp;

public class CiudadesDistancias {
	
	private String ciudadOrigen;
	private String ciudadDestino;
	private int distancia;
	
	CiudadesDistancias(){

	}
	
	CiudadesDistancias(String so, String sd, int d){
		ciudadOrigen = so;
		ciudadDestino = sd;
		distancia = d;
	}

	public String getCiudadOrigen() {
		return ciudadOrigen;
	}
	
	public void setCiudadOrigen(String ciudadOrigen) {
		this.ciudadOrigen = ciudadOrigen;
	}
	
	public String getCiudadDestino() {
		return ciudadDestino;
	}
	
	public void setCiudadDestino(String ciudadDestino) {
		this.ciudadDestino = ciudadDestino;
	}
	
	public int getDistancia() {
		return distancia;
	}
	
	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}
}