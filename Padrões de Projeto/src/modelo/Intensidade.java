package modelo;

public enum Intensidade {
	B("Baixa"),
	M("Média"),
	A("Alta");

	private String descricao;
	
	Intensidade(String descricao){
		this.descricao= descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
