package modelo;

public class Ar_Condicionado extends Dispositivo{
	private int Temperatura;

	public Ar_Condicionado() {
		super();
	}

	public Ar_Condicionado(String nome) {
		super(nome);
	}

	public int getTemperatura() {
		return Temperatura;
	}

	public void setTemperatura(int temperatura) {
		Temperatura = temperatura;
	}




}
