package cat.itacademy.barcelonactiva.escobarjulia.andres.s05.t02.n01.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.escobarjulia.andres.s05.t02.n01.domain.Gamer;
import cat.itacademy.barcelonactiva.escobarjulia.andres.s05.t02.n01.domain.TiradasGame;
import cat.itacademy.barcelonactiva.escobarjulia.andres.s05.t02.n01.repository.GamersRepository;

@Service
public class GamerServiceImpl implements GamerService  {

	
    @Autowired
    private GamersRepository gamersRepository;
	
	public GamerServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	
	
	
	@Override
	public long AltaGamer(Gamer  gamer) {
		// TODO Auto-generated method stub

 	       long gamerId=0;
//		   Sucursal  sucursal  =  new Sucursal(); 
//		
//		   sucursal.setNomSucursal(sucursaldto.getNomSucursal());
//		   sucursal.setPaisSucursal(sucursaldto.getPaisSucursal());
 	       if(gamer.getFechaalta() == null ) {
 	    	   FechaDia fechadia = new FechaDia();
         }
		   
		   gamersRepository.save(gamer);
 
	 
	       gamerId=gamer.getId();
	       gamer.setId(gamerId);
	       
	       return gamerId;
  
	}




	@Override
	public List<Gamer> AllGamer() {
		// TODO Auto-generated method stub
		
		return 		gamersRepository.findAll();
	}




	@Override
	public List<TiradasGame> jugadorTiradas(Long id) {
		// TODO Auto-generated method stub
		
		Optional<Gamer>  gamer = gamersRepository.findById(id);
		List<TiradasGame>  tiradasGames = null;
		
		if (gamer.isPresent()) {
		
			System.out.println(" Presente----> ");
		
			tiradasGames = gamer.get().getGames();
			
		}
			
		return   tiradasGames;
	}
}
