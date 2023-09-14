package cat.itacademy.barcelonactiva.escobarjulia.andres.s05.t02.n01.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import cat.itacademy.barcelonactiva.escobarjulia.andres.s05.t02.n01.domain.Gamer;
import cat.itacademy.barcelonactiva.escobarjulia.andres.s05.t02.n01.dto.ConsultaCampoByID;
import cat.itacademy.barcelonactiva.escobarjulia.andres.s05.t02.n01.dto.ConsultaCampoByID2;

 
//public interface GamersRepository extends JpaRepository<Gamer , Long> {

public interface GamersRepository extends JpaRepository<Gamer  , Long > {

	
		List<Gamer>  findAll();


	 	Optional<Gamer>  findBynombre(String nombre);
	 
	 	@Query ("select  AVG(s.porcentajeExito)  from Gamer  s ")
   	    double    findByCaros();
	 	
	 	@Query (" select  f from Gamer f where  f.porcentajeExito in (select  ( MAX(l.porcentajeExito)  )   from Gamer  l )")
 	    List<Gamer>     findByIdGanador();

	 	@Query (" select  f from Gamer f where  f.porcentajeExito in (select  ( MIN(l.porcentajeExito)  )   from Gamer  l )")
	 	List<Gamer>     findByIdPerdedor();


}
