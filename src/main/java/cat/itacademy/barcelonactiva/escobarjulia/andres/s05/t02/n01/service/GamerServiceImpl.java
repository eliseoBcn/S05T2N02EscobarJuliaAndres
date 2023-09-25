package cat.itacademy.barcelonactiva.escobarjulia.andres.s05.t02.n01.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

 
import cat.itacademy.barcelonactiva.escobarjulia.andres.s05.t02.n01.domain.Gamer;
import cat.itacademy.barcelonactiva.escobarjulia.andres.s05.t02.n01.dto.GamerDTO;
import cat.itacademy.barcelonactiva.escobarjulia.andres.s05.t02.n01.dto.JugadorPorcentajeDTO;
import cat.itacademy.barcelonactiva.escobarjulia.andres.s05.t02.n01.repository.GamersRepository;
import cat.itacademy.barcelonactiva.escobarjulia.andres.s05.t02.n01.repository.PorcentajeMedioJugadores;
 
@Service
public class GamerServiceImpl implements GamerService  {

	
    @Autowired
    private GamersRepository gamersRepository;
	
	public GamerServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public  String  AltaGamer(GamerDTO  gamerdto) {
		// TODO Auto-generated method stub

 	      String gamerId="";
 	      FechaDia fechadia = null;
 	       if(gamerdto.getFechaalta() == null ) {
 	    	   fechadia = new FechaDia();
 	       }
 	       
		   Gamer gamer = new Gamer();
		   
		   gamer.setNombre(gamerdto.getNombre());

		   gamer.setFechaalta(fechadia.getFechadia());
		   gamersRepository.save(gamer);
		   
 	       gamerId=gamer.getId();
	       gamerdto.setId(gamerId);
	       gamerdto.setFechaalta(gamer.getFechaalta());
	       
	       
//	       Gamer game2 = gamersRepository.returnIntegerFromDB(String id);
	       return gamerId;
  
	}

	@Override
	public List<GamerDTO>  AllGamer() {
		// TODO Auto-generated method stub
	List<Gamer>  listagamer = ( List<Gamer>) gamersRepository.findAll();
        List<GamerDTO> gamerDTO = new ArrayList<>();
        List<Gamer> gamers = new ArrayList<>();
        gamersRepository.findAll().forEach(gamers::add);
        
        for ( Gamer gamer : gamers) {
        	
        	   GamerDTO   gamerdto =  new GamerDTO(); 
        	   gamerdto.setFechaalta(gamer.getFechaalta());
        	   gamerdto.setId(gamer.getId());
        	   gamerdto.setNombre(gamer.getNombre());
        	   gamerdto.setPartidasganadas(gamer.getPartidasganadas());
        	   gamerdto.setPartidasjugadas(gamer.getPartidasjugadas());
        	   gamerdto.setPorcentajeExito(gamer.getPorcentajeExito());
         	   
        	   gamerDTO.add(gamerdto);
        	   gamerdto = null;

        }
        return  gamerDTO;
	}


	@Override
	public boolean existeGamer(String  id) {
		// TODO Auto-generated method stub
		Optional<Gamer>  gamer = gamersRepository.findById(id);
		if (gamer.isPresent()) {
			return true;
		}
		return false;
	}
	@Override
	public boolean existenombreGamer(String nombre) {
		// TODO Auto-generated method stub
	 
		Optional<Gamer>  gamer =  gamersRepository.findBynombre(nombre);
		if (gamer.isPresent()) {
			return true;
		}
		return false;
		
	}
	@Override
	public Gamer BuscaJugadorById(String  id) {
		// TODO Auto-generated method stub

		System.out.println(" BuscaJugadorById(Long id)" +  id  );

		Optional<Gamer>  gamer =  gamersRepository.findById(id);
		if (gamer.isPresent()) {
			return gamer.get();
			
			
			
		}
		System.out.println(" BuscaJugadorById(Long id)   NULOOOOO" );
		
		return null;
	}
 
	public boolean BorrarJugadasGamerById(String id) {
		// TODO Auto-generated method stub
		
		Optional<Gamer>  gameroptional =  gamersRepository.findById(id);
		
		Gamer gamer  = gameroptional.get();
//		if (gamer.isPresent()) {
	//	gamer.eliminares();

//			System.out.println("***********    partidad del jugador " + gamer.getGames() );
 
 
			
			gamersRepository.save(gamer);
//			System.out.println("despues de grabar " + gamer.getGames() );
			
			return true;
 
	}
	@Override
	public double  porcentajesmedios() {
		// TODO Auto-generated method stub
		
 	 PorcentajeMedioJugadores  porcentajeMedioJugadores = gamersRepository.porcentajeExitoMedio();
	
 	 return 	porcentajeMedioJugadores.getMediaPorcentajeExito();
 	 
	}
	@Override
	public List<JugadorPorcentajeDTO>  JugadorGanador() {
		
		
//		JugadorPorcentajeDTO
		// TODO Auto-generated method stub
// 		ConsultaCampoByID jugadorGanadorID = gamersRepository.findByIdGanador();
//		Gamer  jugador = BuscaJugadorById(jugadorGanadorID.getId());
 		Gamer  gamer  = gamersRepository.findByIdGanador();
 		List<JugadorPorcentajeDTO>  jugadorPorcentajeDTO = new ArrayList<>();
 		
// 		 for(Gamer  gamer :jugadorGanadorID) {
// 			Gamer gamer = jugadorGanadorID.get(0);
 			
 //			gamer  = gamersRepository.findTopByOrderByporcentajeExitoDesc();

 			JugadorPorcentajeDTO jugadorDTO = null;
 			jugadorDTO = new JugadorPorcentajeDTO();
 			jugadorDTO.setFechaalta(gamer.getFechaalta());
 			jugadorDTO.setId(gamer.getId());
 			jugadorDTO.setNombre(gamer.getNombre());;
 			jugadorDTO.setPorcentajeExito(gamer.getPorcentajeExito());
 			jugadorPorcentajeDTO.add(jugadorDTO);
// 		    }
		return jugadorPorcentajeDTO;
	}
	
	public List<JugadorPorcentajeDTO>  JugadorPerdedor() {
		// TODO Auto-generated method stub
 		Gamer   gamer  = gamersRepository.findByIdPerdedor();
 //		double      min  = gamersRepository.findMin();
 		List<JugadorPorcentajeDTO>  jugadorPorcentajeDTO = new ArrayList<>();
 		
//		 for(Gamer  gamer :jugadorPerdedorID) {
			JugadorPorcentajeDTO jugadorDTO = null;
			jugadorDTO = new JugadorPorcentajeDTO();	
			jugadorDTO.setFechaalta(gamer.getFechaalta());
			jugadorDTO.setId(gamer.getId());
			jugadorDTO.setNombre(gamer.getNombre());;
			jugadorDTO.setPorcentajeExito(gamer.getPorcentajeExito());
			jugadorPorcentajeDTO.add(jugadorDTO);
//		    }
		
		return jugadorPorcentajeDTO;
		
		
	}
}