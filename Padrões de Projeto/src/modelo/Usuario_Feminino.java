package modelo;

public class Usuario_Feminino extends Usuario{
	
	//Construtores
	public Usuario_Feminino() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Usuario_Feminino(String nome, int idade, Sexo sexo) {
		super(nome, idade, sexo);
		// TODO Auto-generated constructor stub
	}
	public String Saudar_Usuario() {
		return "Olá Sra. "+super.getNome();
	}
	@Override
	public String toString() {
		return "Usuario "+super.getSexo().getDescricao()+
				"\nNome: "+super.getNome()+
				"\nIdade: "+super.getIdade();
	}
	
	
	
	
}
