package entities;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
	private String nome;
	private String CPF;
	private String endereco;
	
	private static List<Veiculo> historicoCompras = new ArrayList<>();
	
	public Cliente(String nome, String CPF, String endereco) {
		this.nome = nome;
		this.CPF = CPF;
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public String getCPF() {
		return CPF;
	}

	public String getEndereco() {
		return endereco;
	}
	
	public void addVeiculoHistorico(Veiculo veiculo) {
		historicoCompras.add(veiculo);
	}
	
	public void removeVeiculoHistorico(Veiculo veiculo) {
		historicoCompras.remove(veiculo);
	}
	
	public static List<Veiculo> getHistoricoDeCompra() {
		return historicoCompras;
	}

	public static String listaParaString(List<Veiculo> v) {
        StringBuilder sb = new StringBuilder();
        for (Veiculo veiculo : v) {
            sb.append(veiculo.toString()).append("\n");
        }
        return sb.toString();
    }

	
	
}
