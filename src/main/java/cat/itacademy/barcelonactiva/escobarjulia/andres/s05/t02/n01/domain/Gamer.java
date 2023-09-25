package cat.itacademy.barcelonactiva.escobarjulia.andres.s05.t02.n01.domain;
 
import org.springframework.data.mongodb.core.mapping.Document;
 
import java.util.Date;
import java.util.List;
 
	
@Document(collection = "gamer")
public class Gamer {

	public Gamer() {
		// TODO Auto-generated constructor stub
	}

	public Gamer(String id, String nombre, Date fechaalta, double porcentajeExito, int partidasjugadas,
			int partidasganadas) {
		this.id = id;
		this.nombre = nombre;
		this.fechaalta = fechaalta;
		this.porcentajeExito = porcentajeExito;
		this.partidasjugadas = partidasjugadas;
		this.partidasganadas = partidasganadas;
//		this.tiradasGame = tiradasGame;
	}

	String  id;
	
	private String nombre;
	private Date fechaalta;
	
	
	private double porcentajeExito;
	private int partidasjugadas;
	private int partidasganadas;	

	
	public String getId() {
		return id;
	}
	public void setId(String  id) {
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


//	@OneToMany(mappedBy="gamer",cascade = CascadeType.ALL ,fetch = FetchType.EAGER  , orphanRemoval = true)
//	private  List<TiradasGame> tiradasGame;

//	@JsonProperty(access = Access.WRITE_ONLY)
// 	public void eliminares() {
//		for ( int a = 0; a < tiradasGame.size() ; a++) {
//			tiradasGame.remove(a);
//		}
 

//	public List<TiradasGame>  getGames() {
//			return tiradasGame;
//	}
//   	public void setGames(List<TiradasGame>  tiradasGames) {
//			this.tiradasGame  = tiradasGames;
////			tiradaGames.forEach( tiradasGame --> tiradasGame );
//	}
		@Override
		public String toString() {
			return "Gamer [id=" + id + ", nombre=" + nombre + ", fechaalta=" + fechaalta;
		}
 
}
