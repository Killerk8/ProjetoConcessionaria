package entities;

import java.math.BigDecimal;
import java.math.RoundingMode;

import constants.TipoCombustivel;

public class CarroUsado extends Veiculo {
	
	private TipoCombustivel tipoCombustivel;
	private int quilometragem;

	private BigDecimal preco;
	
	public CarroUsado(String modelo, String marca, int anoFabricacao, double preco, TipoCombustivel tipoCombustivel, int quilometragem) {
		super(modelo, marca, anoFabricacao);	
		this.preco = BigDecimal.valueOf(preco).setScale(2, RoundingMode.HALF_UP);
		this.tipoCombustivel = tipoCombustivel;
		this.quilometragem = quilometragem;	
	}
	
	public double getQuilometragem() {
		return quilometragem;
	}
	
	public BigDecimal precoSemDepreciacao() {
		return preco;
	}
	
	@Override
	public BigDecimal getPreco() {
		BigDecimal valor = preco;
		
		if (valor == null) {
	        valor = BigDecimal.ZERO; 
	    }
		
		if (quilometragem > 0) {
	        BigDecimal desconto = new BigDecimal("0.8");
	        valor = valor.multiply(desconto).setScale(2, RoundingMode.HALF_UP);
	    }
		
		return valor;
	}
	
	@Override
	public String toString() {
		String tipoComb = "Carro Usado: " +
						   super.toString();
		return tipoComb += ", " + "Tipo de Combustivel: " + tipoCombustivel + ", " +
						   "Quilometragem: " + quilometragem; 
							
	} 
		
	
}
