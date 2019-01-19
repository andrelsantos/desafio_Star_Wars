package br.com.desafiostarwars.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.desafiostarwars.model.Planeta;
import br.com.desafiostarwars.service.PlanetaService;

@RunWith(SpringRunner.class)
@DataMongoTest
public class TesteRpository {

	@Autowired
	private PlanetaService planetaService;
	
	@Test
	public void teste_planeta() throws Exception {
		this.planetaService.salvar(new Planeta("nome","clima","terreno"));
		Planeta planeta = this.planetaService.buscarNome("nome");
		assertThat(planeta.getNome()).isEqualTo("nome");
		assertThat(planeta.getClima()).isEqualTo("clima");
		assertThat(planeta.getTerreno()).isEqualTo("terreno");
	}
}
