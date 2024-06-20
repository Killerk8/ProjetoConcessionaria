package entities;

import constants.TipoCombustivel;

public class CarroNovo extends Veiculo {

	private TipoCombustivel tipoCombustivel;
	
	public CarroNovo(String modelo, String marca, int anoFabricacao, double preco, TipoCombustivel tipoCombustivel) {
		super(modelo, marca, anoFabricacao, preco);
		this.tipoCombustivel = tipoCombustivel;
	}
	
	@Override
	public String toString() {
		String tipoComb = "Carro Novo: " + 
				 		   super.toString();
		return tipoComb += ", " + "Tipo de Combustivel: " + tipoCombustivel;
						    

	} 
}
