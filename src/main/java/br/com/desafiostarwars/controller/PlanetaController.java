package br.com.desafiostarwars.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafiostarwars.model.Planeta;
import br.com.desafiostarwars.response.ResponsePlaneta;
import br.com.desafiostarwars.service.PlanetaService;
import br.com.desafiostarwars.service.SwapiService;
import br.com.desafiostarwars.swapi.SwapiPlaneta;
import br.com.desafiostarwars.swapi.SwapiResults;

@RestController
@RequestMapping("/api")
public class PlanetaController {
	
	private int ID_INVALIDO = -1;
	
	@Autowired
	private PlanetaService planetaService;
	
	@Autowired
	private SwapiService swapiService;
	
	@Value("${swapi.urlPlaneta}")
	private String urlPlaneta;
	
	
	//end points
	@GetMapping("/planeta")
	@ResponseBody
	public List<ResponsePlaneta> consultar(){
		List<Planeta> planeta = planetaService.buscarPlanetas();
		List<ResponsePlaneta> responsePlaneta = new ArrayList<ResponsePlaneta>();
		for(Planeta p : planeta){
			responsePlaneta.add(new ResponsePlaneta(p.getId(),p.getNome(),p.getClima(),p.getTerreno(),contarAparicao(p)));
		}
		return responsePlaneta;
	}
	
	@GetMapping("/planeta/{id}")
	@ResponseBody 
	public ResponsePlaneta consultarIdPlaneta(@PathVariable String id){
		Planeta planeta = planetaService.buscarId(id);
		if( planeta != null ){
			return new ResponsePlaneta(planeta.getId(),planeta.getNome(),planeta.getClima(),planeta.getTerreno(),contarAparicao(planeta));
		}else{
			return new ResponsePlaneta();
		}
		
	}
	
	@GetMapping("/planeta/nome/{nome}")
	@ResponseBody 
	public ResponsePlaneta consultarNomePlaneta(@PathVariable String nome){
		Planeta planeta = planetaService.buscarNome(nome);
		if(planeta != null){
			return new ResponsePlaneta(planeta.getId(),planeta.getNome(),planeta.getClima(),planeta.getTerreno(),contarAparicao(planeta));
		}else{
			return new ResponsePlaneta();
		}
		
	}

	@PostMapping("/planeta")
	@ResponseBody 
	public Object salvar(@RequestBody Planeta planeta){
		try {
			this.planetaService.salvar(planeta);
			return planeta;
		}catch(Exception e){
			return new ResponsePlaneta();	
		}
	}
	
	@DeleteMapping("/planeta/{id}")
	@ResponseBody
	public Object deletar(@PathVariable String id) {
		try {
			planetaService.delete(id);
			return id;
		}catch(Exception e){
			return ID_INVALIDO;	
		}
		
		
	}
	
	//metodos
	private int contarAparicao( Planeta planeta ) {
		//listo todos os planetas com suas aparicoes em filmes
		List<SwapiPlaneta> swapiPlaneta= listarPlanetas();
		for(SwapiPlaneta s : swapiPlaneta){
			if(planeta.getNome().equals(s.getName())){
				return s.getFilms().size();
			}
		}
		return 0;
	}
	
	private List<SwapiPlaneta> listarPlanetas(){

		SwapiResults swapiResult = new SwapiResults();
		List<SwapiPlaneta> results = new ArrayList<SwapiPlaneta>();
		
		swapiResult = swapiService.RetornaAparicoes(urlPlaneta).getBody();
		results.addAll(swapiResult.getResults());
		
		while (swapiResult.getNext() != null ){
			swapiResult = swapiService.RetornaAparicoes(swapiResult.getNext()).getBody();
			results.addAll(swapiResult.getResults());	
		}	
		return results;
	}
}
