package cat.itacademy.barcelonactiva.escobarjulia.andres.s05.t02.n01.repository;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

 
import cat.itacademy.barcelonactiva.escobarjulia.andres.s05.t02.n01.domain.TiradasGame;


@Repository
public interface TiradasRepository  extends MongoRepository<TiradasGame , String > {

	
	
		void deleteByjugadorId(String id);
					List<TiradasGame>      findByjugadorId(String id);
		 				
 
	    @Query(value = "{ jugadorId: ?0}", count = true)
		public long countTiradasJugador(String id);
	    
}
