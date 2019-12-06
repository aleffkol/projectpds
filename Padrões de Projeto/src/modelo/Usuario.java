package modelo;

public class Usuario {
	
	//Atributos
	private String nome;
	private int idade;
	private Sexo sexo;
	
	//Construtores
	public Usuario(String nome, int idade, Sexo sexo) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.sexo = sexo;
	}
	
	public Usuario() {
		super();
	}
	
	//Get & Set
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}
	
	//Métodos
	public String Saudar_Usuario() {
		return "Olá "+this.nome;
	}

	@Override
	public String toString() {
		return "Usuario [nome=" + nome + ", idade=" + idade + ", sexo=" + sexo + "]";
	}
	
	
	
}
