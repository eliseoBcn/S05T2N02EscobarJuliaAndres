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
		
		Optional<Gamer>   gamero = gamerRepository.findById(id);
		Gamer gamer =   gamero.get();

		TiradasGame tiradasGame = new TiradasGame(gamer );

//		tiradasGame.setGamer(id);
		int numero = (int)(Math.random()*6+1);
		tiradasGame.setDado1(numero);
		

		int numero2 = (int)(Math.random()*6+1);
		tiradasGame.setDado2(numero2);

		System.out.println(" Suma " + ( numero + numero2)  );

		int pg =  gamer.getPartidasganadas();
		int pj =  gamer.getPartidasjugadas() + 1;
		if( numero + numero2 == 7) {
			pg = pg +1 ;
			tiradasGame.setResultado("ganada");
		}else {
			tiradasGame.setResultado("perdida");
		}
			
		System.out.println(" pg " +  pg );
		System.out.println(" pj " +  pj );

 

		gamer.setPartidasganadas(pg);
		gamer.setPartidasjugadas(pj);
//		if ( pg > 0 ) {
		double por1 = ( pg*100) /pj; 
		gamer.setPorcentajeExito( por1 );
		tiradasRepository.save(tiradasGame);
		
		return tiradasGame;
	}

	@Override
	public List<TiradasGame> jugadorTiradas(Long id) {
		// TODO Auto-generated method stub
		
	
		return null;
	}


	@Override
	public boolean BorrarTiradas(Long id) {
		// TODO Auto-generated method stub
//	 tiradasRepository.delete
	
		 return true;
	}
}
