package cat.itacademy.barcelonactiva.escobarjulia.andres.s05.t02.n01.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tiradas")

public class TiradasGame {
   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long tiradas;
	
//	@Column(name="gamerId",unique = false)
//	private Long  gamerId;
 
	public TiradasGame(Gamer gamer ) {
		this.gamer = gamer;
	}
	public TiradasGame() {
		super();
	}
	
	@Column(name="dado1")
 	private int dado1;

	@Column(name="dado2")
	private int dado2;

	@Column(name="resultado")
	private String  resultado;
	
	
	public String  getResultado() {
		return resultado;
	}
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	
	public long getTiradas() {
		return tiradas;
	}

	public void setTiradas(int tiradas) {
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
	@ManyToOne
    @JoinColumn(name = "gamer_id", nullable = false, updatable = false)
    private Gamer  gamer;
 
}
	


