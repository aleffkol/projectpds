package modelo;

public class Lampada extends Dispositivo{
	//Atributos
	private Intensidade intensidade;
	//Construtores
	public Lampada() {
		super();
	}

	public Lampada(String nome) {
		super(nome);
	}
	//Métodos
	public Intensidade getIntensidade() {
		return intensidade;
	}

	public void setIntensidade(Intensidade intensidade) {
		this.intensidade = intensidade;
	}
	
	
	
}
