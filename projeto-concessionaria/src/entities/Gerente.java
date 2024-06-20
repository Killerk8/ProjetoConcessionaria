package entities;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Gerente extends Funcionario {

	private List<Vendedor> vendedoresSupervisionados;
	
	public Gerente(String nome, int idFuncionario) {
		super(nome, idFuncionario);
		this.vendedoresSupervisionados = new ArrayList<>();
	}

	public List<Vendedor> getVendedoresSupervisionados() {
        return vendedoresSupervisionados;
    }
	
	public void adicionarVendedor(Vendedor vendedor) {
        vendedoresSupervisionados.add(vendedor);
    }

    public void removerVendedor(Vendedor vendedor) {
        vendedoresSupervisionados.remove(vendedor);
    }
    
    public BigDecimal calcularComissaoTotal() {
    	BigDecimal valorTotalVendas = BigDecimal.ZERO; 
    	
    	for (Vendedor vendedor : vendedoresSupervisionados) { 
            for (Venda<Veiculo> venda : vendedor.getVendasRealizadas()) { 
            	valorTotalVendas = valorTotalVendas.add(venda.getValorVenda()); 
            }
        }
    	
    	BigDecimal comissaoAdicional = valorTotalVendas.multiply(new BigDecimal("0.01")); 
    	comissaoAdicional = comissaoAdicional.setScale(2, RoundingMode.HALF_UP);
    	
    	return comissaoAdicional;
    }
    
    public void avaliarDesempenhoVendedores() {
        for (Vendedor vendedor : vendedoresSupervisionados) {
            System.out.println("Vendedor: " + vendedor.getNome() + " - Vendas Realizadas: " + vendedor.getVendasRealizadas());
        }
}
}
