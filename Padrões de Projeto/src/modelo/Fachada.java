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
		this.cenarios = new ArrayList<Cenario_Product>();
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
	
	//Usuario
	public Usuario cadastrarUsuario(String nome, int idade, String sexo)throws Exception {
		Usuario u;
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
			u = new Usuario_Masculino(nome, idade, Sexo.M);
			adicionarUsuario(u);
			return u;
			
		}
		else{
			u = new Usuario_Feminino(nome, idade, Sexo.F);
			adicionarUsuario(u);
			return u;
		}


	}
	
	//Cenário
	public Cenario_Product criarCenario(String nome)throws Exception {
		Cenario_Builder cb = new Cenario_Builder();
		if(nome.equals("")) {
			throw new Exception("Digite um nome!");
		}
		else if(nome.length()<4) {
			throw new Exception("Digite um nome de até no mínimo 4 caracteres.");
		}
		cb.nomeCenario(nome);
		return cb.gerarCenario();
	}
	public void adicionarDispositivoCenario(String nome) {
	}

}
