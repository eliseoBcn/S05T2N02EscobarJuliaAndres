package cat.itacademy.barcelonactiva.escobarjulia.andres.s05.t02.n01.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cat.itacademy.barcelonactiva.escobarjulia.andres.s05.t02.n01.domain.TiradasGame;


public interface TiradasRepository extends JpaRepository<TiradasGame , Long > {

}
