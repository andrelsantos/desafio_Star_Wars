package br.com.desafiostarwars.response;

public class ResponsePlaneta {
	
	private String id;
	private String nome;
	private String clima;
	private String terreno;
	private int qtAparicao;
	
	public ResponsePlaneta(String id, String nome, String clima, String terreno, int qtAparicao) {
		this.id = id;
		this.nome = nome;
		this.clima = clima;
		this.terreno = terreno;
		this.qtAparicao = qtAparicao;
	}
	
	public ResponsePlaneta() {
	}
	
	public String toString() {
		return "Id:" +  getId() + "  Fornecedor:" +  getNome() + "  Clima: " + getClima() + "  Terreno:" +  getTerreno() + "  qtAparicao:" +  getQtAparicao();
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
	public int getQtAparicao() {
		return qtAparicao;
	}
	public void setQtAparicao(int qtAparicao) {
		this.qtAparicao = qtAparicao;
	}	
}
