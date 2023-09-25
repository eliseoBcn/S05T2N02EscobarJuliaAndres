package cat.itacademy.barcelonactiva.escobarjulia.andres.s05.t02.n01.service;

import java.util.List;

import org.springframework.stereotype.Service;

 

import cat.itacademy.barcelonactiva.escobarjulia.andres.s05.t02.n01.domain.TiradasGame;

@Service
public interface TiradasService {

 
	 
	  TiradasGame  gamerTirada(String  id);	 
	  
 	  List<TiradasGame> jugadorTiradas(String  id);

	  long   BorrarTiradas(String  id);	 
	  
	  		 
	 
}
