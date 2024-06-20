package entities;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Veiculo {
	private String modelo;
	private String marca;
	private int anoFabricacao;
	private BigDecimal preco;
	
	private static List<Veiculo> veiculosDisponiveis = new ArrayList<>();
	
	public Veiculo() {
		
	}
	
	public Veiculo(String modelo, String marca, int anoFabricacao) {
		this.modelo = modelo;
		this.marca =  marca;
		this.anoFabricacao = anoFabricacao;
		veiculosDisponiveis.add(this);
	}
	
	public Veiculo(String modelo, String marca, int anoFabricacao, double preco) {
		this.modelo = modelo;
		this.marca =  marca;
		this.anoFabricacao = anoFabricacao;
		this.preco = BigDecimal.valueOf(preco).setScale(2, RoundingMode.HALF_UP);
		veiculosDisponiveis.add(this);
	}

	public String getModelo() {
		return modelo;
	}
	
	public String getMarca() {
		return marca;
	}
	public int getAnoFabricacao() {
		return anoFabricacao;
	}
	
	public BigDecimal getPreco() {
		 return preco;
	}
		
	public BigDecimal precoSemDepreciacao() {
		return preco;
	}
	
	public static List<Veiculo> getVeiculosDisponiveis() {
		return veiculosDisponiveis;
	}
		
	
	public static String listaParaString(List<Veiculo> v) {
        StringBuilder sb = new StringBuilder();
        for (Veiculo veiculo : v) {
            sb.append(veiculo.toString()).append("\n");
        }
        return sb.toString();
    }
	
	@Override
    public String toString() {   
		return  "Modelo: " + modelo + ", " +
                "Marca: " + marca + ", " +
                "Ano de Fabricacao: " + anoFabricacao + ", " +
                "Preço: " + getPreco();
    }
}
