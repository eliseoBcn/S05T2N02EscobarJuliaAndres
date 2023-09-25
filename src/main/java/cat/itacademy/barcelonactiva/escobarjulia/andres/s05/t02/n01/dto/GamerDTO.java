package cat.itacademy.barcelonactiva.escobarjulia.andres.s05.t02.n01.dto;



import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
 

public class GamerDTO {

	public GamerDTO() {
		// TODO Auto-generated constructor stub
	}
 
	private String id;
	
	private String nombre;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd" )
	private Date fechaalta;
	private double porcentajeExito;
	private int partidasjugadas;
	private int partidasganadas;	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Date getFechaalta() {
		return fechaalta;
	}
	public void setFechaalta(Date fechaalta) {
		this.fechaalta = fechaalta;
	}

	
	public double getPorcentajeExito() {
		return porcentajeExito;
	}
	public void setPorcentajeExito(double porcentajeExito) {
		this.porcentajeExito = porcentajeExito;
	}
	public int getPartidasjugadas() {
		return partidasjugadas;
	}
	public void setPartidasjugadas(int partidasjugadas) {
		this.partidasjugadas = partidasjugadas;
	}
	public int getPartidasganadas() {
		return partidasganadas;
	}
	public void setPartidasganadas(int partidasganadas) {
		this.partidasganadas = partidasganadas;
	}

}
