package cat.itacademy.barcelonactiva.escobarjulia.andres.s05.t02.n01.service;

import java.util.List;

import cat.itacademy.barcelonactiva.escobarjulia.andres.s05.t02.n01.domain.Gamer;

import cat.itacademy.barcelonactiva.escobarjulia.andres.s05.t02.n01.dto.GamerDTO;
import cat.itacademy.barcelonactiva.escobarjulia.andres.s05.t02.n01.dto.JugadorPorcentajeDTO;

public interface GamerService {

	
	  String  AltaGamer(GamerDTO  gamer);
	

	  List<GamerDTO> AllGamer();

	  
//	  List<TiradasGame>   jugadorTiradas(String   id);	 

	  
	  boolean existeGamer( String  id);

	  
	  boolean existenombreGamer(String nombre);


	  Gamer  BuscaJugadorById (String   id);	 

	  
//	  boolean BorrarJugadasGamerById (String   id);	 

	  
	  double  porcentajesmedios ();	 

	  
	  List<JugadorPorcentajeDTO>  JugadorGanador ();

	  
	  List<JugadorPorcentajeDTO>  JugadorPerdedor();	 

	  
}

