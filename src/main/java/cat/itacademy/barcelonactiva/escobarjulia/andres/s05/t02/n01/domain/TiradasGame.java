package cat.itacademy.barcelonactiva.escobarjulia.andres.s05.t02.n01.domain;

 

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Document(collection = "tiradas")
public class TiradasGame {
   
	@Id
	private String tiradas;

	
	@JsonProperty(access = Access.WRITE_ONLY)
	private String jugadorId;

	
	public TiradasGame() {
		super();
	}
	
 
//	public TiradasGame(Gamer gamer ) {
//		this.gamer = gamer;
//	}

 	public TiradasGame(String tiradas, int dado1, int dado2, String resultado, String jugadorId) {
		this.tiradas = tiradas;
		this.dado1 = dado1;
		this.dado2 = dado2;
		this.resultado = resultado;
		this.jugadorId = jugadorId;
	}


	public String getJugadorId() {
		return jugadorId;
	}


	public void setJugadorId(String jugadorId) {
		this.jugadorId = jugadorId;
	}


	private int dado1;

	private int dado2;

    private String  resultado;
	
	
	public String  getResultado() {
		return resultado;
	}
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	
	public String getTiradas() {
		return tiradas;
	}

	public void setTiradas(String tiradas) {
		this.tiradas = tiradas;
	}
 

	public int getDado1() {
		return dado1;
	}

	public void setDado1(int dado1) {
		this.dado1 = dado1;
	}

	public int getDado2() {
		return dado2;
	}

	public void setDado2(int dado2) {
		this.dado2 = dado2;
	}
//    private Gamer  gamer;
 
}
	


