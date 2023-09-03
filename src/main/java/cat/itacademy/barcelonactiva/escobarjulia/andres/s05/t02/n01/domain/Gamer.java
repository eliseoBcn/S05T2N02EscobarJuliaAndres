package cat.itacademy.barcelonactiva.escobarjulia.andres.s05.t02.n01.domain;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Temporal;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.time.LocalDate;
import java.util.Calendar;
	
@Entity
@Table(name = "gamer")

public class Gamer {

	public Gamer() {
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "nombre", nullable = false )	
	private String nombre;
 
 
    @Column(name = "fechaalta", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd" )
    @CreationTimestamp
	private Date fechaalta;

    
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
	
	@OneToMany(mappedBy="gamer")
	private  List<TiradasGame> tiradasGame;
		  
 	public List<TiradasGame>  getGames() {
			return tiradasGame;
	}
   	public void setGames(List<TiradasGame>  tiradasGames) {
			this.tiradasGame  = tiradasGames;
//			tiradaGames.forEach( tiradasGame --> tiradasGame );
	}
		@Override
		public String toString() {
			return "Gamer [id=" + id + ", nombre=" + nombre + ", fechaalta=" + fechaalta + ", tiradasGame="
					+ tiradasGame + "]";
		}
		
		
		
//    @JoinColumn(name = "FK_GAMER", nullable = false)
//    @ManyToOne(optional = false, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
//////    private Customer customer;
//    
// 
//    
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gamer")
//    private TiradasGame  lines;
}
