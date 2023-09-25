package cat.itacademy.barcelonactiva.escobarjulia.andres.s05.t02.n01.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;


import cat.itacademy.barcelonactiva.escobarjulia.andres.s05.t02.n01.domain.Gamer;
 
 
public interface GamersRepository  extends MongoRepository<Gamer , String > {
	
		List<Gamer>  findAll();
		
	 	Optional<Gamer>  findBynombre(String nombre);
	 
	    @Aggregation(value = "{'$group': {_id: null, mediaPorcentajeExito: {$avg: $porcentajeExito} }}")
	    PorcentajeMedioJugadores porcentajeExitoMedio();
		
 	    @Aggregation(pipeline = {
		            "{ $sort: { porcentajeExito: -1 } }",  
		            "{ $limit: 1 }"  
		})
		Gamer     findByIdGanador();

	    @Aggregation(pipeline = {
		            "{ $sort: { porcentajeExito: 1 } }",  
		            "{ $limit: 1 }"  
		})
		Gamer     findByIdPerdedor();

}		
		
 
