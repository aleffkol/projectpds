package modelo;

public class Cenario_Builder {
	//Atributos
	Cenario_Product cenario = new Cenario_Product("");
	
	//Construtor
	public Cenario_Builder() {}
	
	//Métodos
	public void nomeCenario(String nome) {
		cenario.setNome(nome);
	}
	
	public void adicionarDispositivoCenario(Dispositivo dispositivo) {
		cenario.addDispositivo(dispositivo);
	}
	
	public Cenario_Product gerarCenario() {
		return cenario;
	}
}
