package cat.itacademy.barcelonactiva.escobarjulia.andres.s05.t02.n01.dto;

public class ConsultaCampoByID {

 
	public ConsultaCampoByID(double porcentaje, long id) {
		this.porcentaje = porcentaje;
		this.id = id;
	}
	double  porcentaje;
	long    id;
	
	public double getPorcentaje() {
		return porcentaje;
	}
	public void setPorcentaje(double porcentaje) {
		this.porcentaje = porcentaje;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
}
