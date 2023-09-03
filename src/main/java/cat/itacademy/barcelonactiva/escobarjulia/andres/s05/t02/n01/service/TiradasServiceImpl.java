package cat.itacademy.barcelonactiva.escobarjulia.andres.s05.t02.n01.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.escobarjulia.andres.s05.t02.n01.domain.Gamer;
import cat.itacademy.barcelonactiva.escobarjulia.andres.s05.t02.n01.domain.TiradasGame;
import cat.itacademy.barcelonactiva.escobarjulia.andres.s05.t02.n01.repository.GamersRepository;
import cat.itacademy.barcelonactiva.escobarjulia.andres.s05.t02.n01.repository.TiradasRepository;

@Service
public class TiradasServiceImpl implements TiradasService  {

	
    @Autowired
    private TiradasRepository tiradasRepository;

    @Autowired
    private GamersRepository  gamerRepository;

	public TiradasServiceImpl() {
		// TODO Auto-generated constructor stub
	}



	public TiradasGame gamerTirada(Long  id) {
		// TODO Auto-generated method stub
		
		Optional<Gamer>  gamer = gamerRepository.findById(id);
		
		
		if (gamer.isPresent()) {
		
		System.out.println(" Presnete ");
		}
		TiradasGame tiradasGame = new TiradasGame(gamer.get());

//		tiradasGame.setGamer(id);
		int numero = (int)(Math.random()*6+1);
		tiradasGame.setDado1(numero);
		

		int numero2 = (int)(Math.random()*6+1);
		tiradasGame.setDado2(numero2);

		tiradasRepository.save(tiradasGame);
		
		return tiradasGame;
	}

	@Override
	public List<TiradasGame> jugadorTiradas(Long id) {
		// TODO Auto-generated method stub
		
		
		return null;
	}
}
