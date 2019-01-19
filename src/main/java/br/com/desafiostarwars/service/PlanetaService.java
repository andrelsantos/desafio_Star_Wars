package br.com.desafiostarwars.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafiostarwars.model.Planeta;
import br.com.desafiostarwars.repository.PlanetaRepository;

@Service
public class PlanetaService  {

	@Autowired
	private PlanetaRepository planetaRepository;
	
	public void salvar(Planeta planeta){
		planetaRepository.save(planeta);
	}
	
	public List<Planeta> buscarPlanetas(){
		return planetaRepository.findAll();
	}
	
	public Planeta buscarId(String id){
		return planetaRepository.findById(id).orElse(null);
	}

	public Planeta buscarNome(String nome){
		return planetaRepository.findByNome(nome).orElse(null);
	}
	
	public void delete(String id){
		planetaRepository.deleteById(id);
	}
}
