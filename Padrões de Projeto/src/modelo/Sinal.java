package modelo;

public enum Sinal {
	M("Movimento"),
	V("Voz"),
	T("Temperatura");

	private String descricao;
	
	Sinal(String descricao){
		this.descricao= descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
