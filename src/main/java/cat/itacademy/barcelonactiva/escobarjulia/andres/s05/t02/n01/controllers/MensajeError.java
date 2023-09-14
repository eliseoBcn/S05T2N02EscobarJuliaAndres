package cat.itacademy.barcelonactiva.escobarjulia.andres.s05.t02.n01.controllers;

public class MensajeError {

	public MensajeError() {
		// TODO Auto-generated constructor stub
	}
	int  status ;
	String  title;
	String  descripcion;
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public MensajeError(int status, String title, String descripcion) {
		this.status = status;
		this.title = title;
		this.descripcion = descripcion;
	}
	
	
	
}
