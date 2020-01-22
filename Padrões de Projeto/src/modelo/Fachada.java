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
		this.usuarios.add(new Usuario_Masculino("adm", 1, null));
	}
	//Métodos
	public boolean realizarLogin(String nome) {
		for(Usuario u: usuarios) {
			if(u.getNome().equalsIgnoreCase(nome)) {
				return true;
			}
		}
		return false;
	}
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
	public void adicionarDispositivoCenario(String nome, Dispositivo d) {
		
		for (Cenario_Product c:cenarios) {
			if(c.getNome().equals(nome)) {
				
				c.addDispositivo(d);
			}
		}
	}
	
	public Lampada criarLampada(String nome) {
		Lampada lampada = new Lampada(nome);
		return lampada;
	}
	public Som criarSom(String nome) {
		Som som = new Som(nome);
		return som;
	}
	public Ar_Condicionado criarAr(String nome) {
		Ar_Condicionado ar = new Ar_Condicionado(nome);
		return ar;
	}
	
	public void ligarDispositivo(String nomeDispositivo, String nomeCenario) {
		for(Cenario_Product c:cenarios) {
			if(c.getNome().equals(nomeCenario)) {
				for(Dispositivo d:c.getDispositivos()) {
					if(d.getNome().equals(nomeDispositivo)) {
						d.ligar();
					}
				}
			}
		}
	}

}
