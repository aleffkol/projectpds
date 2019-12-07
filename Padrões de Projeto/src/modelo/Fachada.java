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
	
	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	public ArrayList<Cenario_Product> getCenarios() {
		return cenarios;
	}

	public static Atuador getAtuador() {
		return atuador;
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
	
public Usuario cadastrarUsuario(String nome, int idade, String sexo)throws Exception {
		
		if(nome.equals("")) {
			throw new Exception("Digite um nome!");
		}
		else if(nome.length()<4) {
			throw new Exception("Digite um nome de até no mínimo 4 caracteres.");
		}
		if(idade<=0 || idade>=100) {
			throw new Exception("Informe uma idade válida!");
		}
		else if(sexo.equals("Masculino")) {
			return new Usuario_Masculino(nome, idade, Sexo.M);
		}
		else{
			return new Usuario_Feminino(nome, idade, Sexo.F);
		}

	
}
}
