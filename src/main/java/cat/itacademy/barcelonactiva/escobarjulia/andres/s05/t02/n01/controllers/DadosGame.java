package cat.itacademy.barcelonactiva.escobarjulia.andres.s05.t02.n01.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

 
import cat.itacademy.barcelonactiva.escobarjulia.andres.s05.t02.n01.domain.TiradasGame;
import cat.itacademy.barcelonactiva.escobarjulia.andres.s05.t02.n01.dto.GamerDTO;
import cat.itacademy.barcelonactiva.escobarjulia.andres.s05.t02.n01.dto.JugadorPorcentajeDTO;
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
	public ResponseEntity<?> createPlayer(@RequestBody GamerDTO gamer) {

		
	 
		String mensaje = null;
		boolean  existeGamer = gamerService.existenombreGamer( gamer.getNombre() );
		
		if ( existeGamer) {
		return new ResponseEntity<>(new MensajeError(302, "Jugador encontrado ", " El jugador " + gamer.getNombre() + " esta dado alta" ),
				HttpStatus.FOUND);
		}
		
		try{
        	
    		gamerService.AltaGamer(gamer);
			return new ResponseEntity<>(gamer,  HttpStatus.OK);
         
        }catch( Exception err){

    		System.out.println(err.getMessage() );
    		mensaje = err.getMessage() + "  " + err.getCause();
    		 
        }
		return new ResponseEntity<>(new MensajeError(400, "error grave ", mensaje ),  HttpStatus.BAD_REQUEST);

 
	}
	
	@PostMapping("/players/{id}/games/")
	public ResponseEntity<?> createPartida(@PathVariable("id") String  id ){
		
 		 // Controlamos existe Jugador 
			if ( !gamerService.existeGamer(id) ) {
				return new ResponseEntity<>( new MensajeError(404, "no encontrado id ", " El Id introducido es " + id ),
						HttpStatus.NOT_FOUND);
				
			};
		    TiradasGame tiradasGame = tiradasService.gamerTirada(id);
		
			return new ResponseEntity<>(tiradasGame ,  HttpStatus.OK);
	}

	@GetMapping("/players/")
	public ResponseEntity<?> AllPlayer(){
		
		List<GamerDTO> listgamer = gamerService.AllGamer();

		if( listgamer.size() == 0) {
			return new ResponseEntity<>( new MensajeError(404, "No encontrado", " No existen todavia jugadores en el sistema" ),  HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>( listgamer,  HttpStatus.OK);

	}
	@GetMapping("/players/{id}/games")
	public ResponseEntity<?> JugadasPlayer(@PathVariable("id") String   id ){

		 // Controlamos existe Jugador 
		if ( !gamerService.existeGamer(id) ) {
			return new ResponseEntity<>( new MensajeError(404, "no encontrado id ", " El Id introducido es " + id ),
						HttpStatus.NOT_FOUND);
		};
		
		List<TiradasGame> tiradasgamer = tiradasService.jugadorTiradas(id);

	
		return new ResponseEntity<>( tiradasgamer,  HttpStatus.OK);
	}

	@DeleteMapping("/players/{id}/games")
	public ResponseEntity<?> BorrarJugadas(@PathVariable("id") String   id ){

				 // Controlamos existe Jugador 
				if ( !gamerService.existeGamer(id) ) {
					return new ResponseEntity<>( new MensajeError(404, "no encontrado id ", " El Id introducido es " + id ),
								HttpStatus.NOT_FOUND);
				};
//				boolean  tiradasgamer = gamerService.BorrarJugadasGamerById(id);
				long  tiradasGamer = tiradasService.BorrarTiradas(id);
				 
				String mensaje = "Se han borrado " + tiradasGamer + " jugadas del Jugador "; 
					mensaje = mensaje +  id;	
				return new ResponseEntity<>( mensaje  , HttpStatus.OK);
	}
 
	@GetMapping("/players/ranking")
	public ResponseEntity<?> RankingsPlayers(){
	 
		double  porcentajemedio = gamerService.porcentajesmedios();
	
		return new ResponseEntity<>( "El porcentaje medio de todos los jugadores del torneo es de " + porcentajemedio + "%",  HttpStatus.OK);
	}
	

	
	@GetMapping("/players/ranking/loser")
	public ResponseEntity<?> RankingLoserPlayers( ){


		List<JugadorPorcentajeDTO>  jugadorPerdedor  =  gamerService.JugadorPerdedor();

		
		return new ResponseEntity<>( jugadorPerdedor  ,  HttpStatus.OK);

	}

	@GetMapping("/players/ranking/winner")
	public ResponseEntity<?> RankingWinnerPlayers( ){
		
		List<JugadorPorcentajeDTO>  jugadorGanador  = gamerService.JugadorGanador();
 
		
		return new ResponseEntity<>( jugadorGanador,  HttpStatus.OK);

	}

	
}
