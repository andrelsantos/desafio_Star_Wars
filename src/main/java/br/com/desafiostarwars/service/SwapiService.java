package br.com.desafiostarwars.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import br.com.desafiostarwars.swapi.SwapiResults;

@Service
public class SwapiService {
	
	public ResponseEntity<SwapiResults> RetornaAparicoes(String url) {
		try {
			
		    HttpHeaders headers = new HttpHeaders();
		    headers.add("user-agent", "swapi-java");
		    HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		    
			RestTemplate restTemplate = new RestTemplate();
			return restTemplate.exchange(url, HttpMethod.GET,entity,SwapiResults.class);
   		}catch(Exception e) {
   			throw e;
   		}
   	}
}
