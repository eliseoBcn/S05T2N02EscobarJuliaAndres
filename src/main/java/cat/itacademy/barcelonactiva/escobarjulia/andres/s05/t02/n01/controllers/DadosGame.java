package cat.itacademy.barcelonactiva.escobarjulia.andres.s05.t02.n01.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cat.itacademy.barcelonactiva.escobarjulia.andres.s05.t02.n01.domain.Gamer;
import cat.itacademy.barcelonactiva.escobarjulia.andres.s05.t02.n01.domain.TiradasGame;
import cat.itacademy.barcelonactiva.escobarjulia.andres.s05.t02.n01.service.GamerService;
import cat.itacademy.barcelonactiva.escobarjulia.andres.s05.t02.n01.service.TiradasService;

@RestController
//@RequestMapping("/players")
public class DadosGame {

	@Autowired
	GamerService gamerService;
	
	@Autowired
	TiradasService tiradasService;

	public DadosGame() {
		// TODO Auto-generated constructor stub
	}
	@PostMapping("/players")
	public ResponseEntity<?> createPlayer(@RequestBody Gamer gamer) {
		
			gamerService.AltaGamer(gamer);
			System.out.println(gamer.toString() );

			return new ResponseEntity<>(gamer,  HttpStatus.OK);
 
	}
	
	@PostMapping("/players/{id}/games/")
	public ResponseEntity<?> createPlayer(@PathVariable("id") Long  id ){
		
  		    TiradasGame tiradasGame = tiradasService.gamerTirada(id);
		
			return new ResponseEntity<>(tiradasGame ,  HttpStatus.OK);
	}

	@GetMapping("/players/")
	public ResponseEntity<?> AllPlayer(){

		
		List<Gamer> listgamer = gamerService.AllGamer();

		
		return new ResponseEntity<>( listgamer,  HttpStatus.OK);

	}
	@GetMapping("/players/{id}/games")
	public ResponseEntity<?> JugadasPlayer(@PathVariable("id") Long  id ){

		
		List<TiradasGame> tiradasgamer = gamerService.jugadorTiradas(id);
//		System.out.println (  listgamer.forEach( Gamer --> gamerService.) );
		
		return new ResponseEntity<>( tiradasgamer,  HttpStatus.OK);
	}

}
