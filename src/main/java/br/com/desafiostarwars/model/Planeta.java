package br.com.desafiostarwars.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;


@Document(collection = "planeta")
public class Planeta {

	@Id
	private String id;
	
	@Indexed(unique = true)
	@NotBlank
	@NotNull
	@JsonProperty(required = true)
	private String nome;
	
	@NotBlank
	@NotNull
	@JsonProperty(required = true)
	private String clima;
	
	@NotBlank
	@NotNull
	@JsonProperty(required = true)
	private String terreno;

	
	public Planeta() {
		super();
	}
	
	public Planeta(String nome, String clima, String terreno) {
		super();
		this.nome = nome;
		this.clima = clima;
		this.terreno = terreno;

	}
	
	
	public String toString() {
		return getNome();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getClima() {
		return clima;
	}

	public void setClima(String clima) {
		this.clima = clima;
	}

	public String getTerreno() {
		return terreno;
	}

	public void setTerreno(String terreno) {
		this.terreno = terreno;
	}
	
	
}
