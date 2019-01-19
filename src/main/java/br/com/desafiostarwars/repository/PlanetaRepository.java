package br.com.desafiostarwars.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;


import br.com.desafiostarwars.model.Planeta;

public interface PlanetaRepository extends MongoRepository<Planeta, String> {

	public Optional<Planeta> findByNome(String nome);
	public Optional<Planeta> findById(String nome);
}
