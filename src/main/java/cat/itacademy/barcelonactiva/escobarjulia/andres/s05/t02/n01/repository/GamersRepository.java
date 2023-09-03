package cat.itacademy.barcelonactiva.escobarjulia.andres.s05.t02.n01.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cat.itacademy.barcelonactiva.escobarjulia.andres.s05.t02.n01.domain.Gamer;


public interface GamersRepository extends JpaRepository<Gamer , Long> {

}
