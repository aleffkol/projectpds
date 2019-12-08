package modelo;

public class Som extends Dispositivo{
	//Atributos
	private int volume;
	//Construtores
	public Som() {
		super();
	}

	public Som(String nome) {
		super(nome);
	}
	//Métodos
	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}
	
	
}
