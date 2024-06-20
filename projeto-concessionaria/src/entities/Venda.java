package entities;

import java.math.BigDecimal;
import java.util.List;

public class Venda<T extends Veiculo> {
	private T veiculo;
	private Cliente cliente;
	
	public Venda(T veiculo, Cliente cliente) {
        this.veiculo = veiculo;
        this.cliente = cliente;
    }
	
	public BigDecimal getValorVenda() {
        return veiculo.getPreco();
    }

	@Override
	public String toString() {
		return "Marca: " + veiculo.getMarca() + ", " +
			   "Modelo: " + veiculo.getModelo() + ", " +
			   "Preço : " + veiculo.getPreco() + ", " +
			   "Cliente: " + cliente.getNome();
	}
	
	public static String listaParaString(List<Venda<Veiculo>> vendedor) {
        StringBuilder sb = new StringBuilder();
        for (Venda<Veiculo> veiculo : vendedor) {
            sb.append(veiculo.toString()).append("\n");
        }
        return sb.toString();
    }
	
}
