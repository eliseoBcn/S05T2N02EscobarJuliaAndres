package cat.itacademy.barcelonactiva.escobarjulia.andres.s05.t02.n01.service;

import java.util.List;

import cat.itacademy.barcelonactiva.escobarjulia.andres.s05.t02.n01.domain.Gamer;
import cat.itacademy.barcelonactiva.escobarjulia.andres.s05.t02.n01.domain.TiradasGame;

public interface GamerService {

	
	  long AltaGamer(Gamer  gamer);
	
	  List<Gamer> AllGamer();
	 

	  List<TiradasGame>   jugadorTiradas(Long  id);	 
		 
}
