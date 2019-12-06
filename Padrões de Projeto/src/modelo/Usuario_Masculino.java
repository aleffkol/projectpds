package modelo;

public class Usuario_Masculino extends Usuario{

	//Construtores
	public Usuario_Masculino() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Usuario_Masculino(String nome, int idade, Sexo sexo) {
		super(nome, idade, sexo);
		// TODO Auto-generated constructor stub
	}
	//Saudação
	public String Saudar_Usuario() {
		return "Olá Sr. "+super.getNome();
	}
	//toString
	@Override
	public String toString() {
		return "Usuario "+super.getSexo().getDescricao()+
		"\nNome: "+super.getNome()+
		"\nIdade: "+super.getIdade();
	}
	
	
	
}
