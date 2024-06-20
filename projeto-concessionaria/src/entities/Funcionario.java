package entities;

public class Funcionario {
	private String nome;
	private int idFuncionario;
	
	public Funcionario(String nome, int idFuncionario) {
		this.nome = nome;
		this.idFuncionario = idFuncionario;
	}

	public String getNome() {
		return nome;
	}

	public int getIdFuncionario() {
		return idFuncionario;
	}

}
