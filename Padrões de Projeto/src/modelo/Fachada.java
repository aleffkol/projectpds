package modelo;

import java.util.ArrayList;

public class Fachada {
	private ArrayList<Usuario> usuarios;
	private ArrayList<Cenario_Product> cenarios;
	private static Atuador atuador;
	
	//Construtor
	public Fachada() {
		this.usuarios = new ArrayList<Usuario>();
		this.atuador = new Atuador();
	}
	//Métodos
	public void adicionarUsuario(Usuario u) {
		this.usuarios.add(u);
	}
	
	public void removerUsuario(Usuario u) {
		this.usuarios.remove(u);
	}
	
	public ArrayList<Usuario> listarUsuarios() {
		return usuarios;
	}
	
	public void adicionarCenario(Cenario_Product c) {
		this.cenarios.add(c);
	}
	
	public void removerCenario(Cenario_Product c) {
		this.cenarios.remove(c);
	}

	
}
