package cat.itacademy.barcelonactiva.escobarjulia.andres.s05.t02.n01.service;

import java.util.List;

import cat.itacademy.barcelonactiva.escobarjulia.andres.s05.t02.n01.domain.TiradasGame;

public interface TiradasService {

 
	 
	  TiradasGame  gamerTirada(Long  id);	 
	  
	  List<TiradasGame>   jugadorTiradas(Long  id);	 
	 
}
