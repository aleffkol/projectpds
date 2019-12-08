package modelo;

public abstract class Dispositivo {
	//atributos
	private String nome;
	private boolean ativo = false;
	//construtores
	public Dispositivo() {}
	public Dispositivo(String nome) {
		this.nome = nome;
	}
	//métodos
	public void ligar() {
		this.ativo = true;
	}
	
	public void desligar() {
		this.ativo = false;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
