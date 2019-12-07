package modelo;

public abstract class Sensor {
	//atributos
	private Sinal sinal;
	private boolean detectar = false;
	//Construtores
	public Sensor() {
	}
	public Sensor(Sinal s) {
		this.sinal = s;
	}
	//Getters e Setters
	public Sinal getSinal() {
		return sinal;
	}
	public void setSinal(Sinal sinal) {
		this.sinal = sinal;
	}
	public boolean isDetectar() {
		return detectar;
	}
	public void setDetectar(boolean observando) {
		this.detectar = observando;
	}
	//Métodos
	public final void Executar() {
		Detectar();
		enviarSinal();
		permanecerObservando();
	}
	
	public void Detectar() {
		this.detectar = true;
	}
	public Sinal enviarSinal() {
		return this.sinal;
	}
	public void permanecerObservando() {
		this.detectar = false;
	}
	
}
