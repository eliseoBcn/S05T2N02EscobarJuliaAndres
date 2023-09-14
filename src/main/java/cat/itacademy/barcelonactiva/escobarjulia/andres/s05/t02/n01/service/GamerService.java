package cat.itacademy.barcelonactiva.escobarjulia.andres.s05.t02.n01.service;

import java.util.List;

import cat.itacademy.barcelonactiva.escobarjulia.andres.s05.t02.n01.domain.Gamer;
import cat.itacademy.barcelonactiva.escobarjulia.andres.s05.t02.n01.domain.TiradasGame;
import cat.itacademy.barcelonactiva.escobarjulia.andres.s05.t02.n01.dto.GamerDTO;
import cat.itacademy.barcelonactiva.escobarjulia.andres.s05.t02.n01.dto.JugadorPorcentajeDTO;

public interface GamerService {

	
	  long AltaGamer(GamerDTO  gamer);
	

	  List<GamerDTO> AllGamer();

	  
	  List<TiradasGame>   jugadorTiradas(Long  id);	 

	  
	  boolean existeGamer( Long id);

	  
	  boolean existenombreGamer(String nombre);


	  Gamer  BuscaJugadorById (Long  id);	 

	  
	  boolean BorrarJugadasGamerById (Long  id);	 

	  
	  double  porcentajesmedios ();	 

	  
	  List<JugadorPorcentajeDTO>  JugadorGanador ();

	  
	  List<JugadorPorcentajeDTO>  JugadorPerdedor();	 

	  
}

