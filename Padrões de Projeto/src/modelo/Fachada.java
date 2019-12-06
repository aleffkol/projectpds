package modelo;

import java.util.ArrayList;

public class Fachada {
	private ArrayList<Usuario> usuarios;
	
	//Construtor
	public Fachada() {
		this.usuarios = new ArrayList<Usuario>();
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

	
}
