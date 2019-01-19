package br.com.desafiostarwars.swapi;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SwapiResults {

	private String next;
	private List<SwapiPlaneta> results;

	public List<SwapiPlaneta> getResults() {
		return results;
	}

	public void setResults(List<SwapiPlaneta> results) {
		this.results = results;
	}

	public String getNext() {
		return next;
	}

	public void setNext(String next) {
		this.next = next;
	}

}
