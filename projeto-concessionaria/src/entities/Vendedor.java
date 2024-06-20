package entities;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Vendedor extends Funcionario {
	private List<Venda<Veiculo>> vendasRealizadas;
	private BigDecimal comissaoTotal;
	
	public Vendedor(String nome, int idFuncionario) {
		super(nome, idFuncionario);
		this.vendasRealizadas = new ArrayList<>();
		this.comissaoTotal = BigDecimal.ZERO;
	}

	
	public void registrarVenda(String modelo, String marca, double preco, Cliente cliente) {
		boolean veiculoEncontrado = false;
		
		Iterator<Veiculo> iterator = Veiculo.getVeiculosDisponiveis().iterator();	
		BigDecimal precoConvertido = BigDecimal.valueOf(preco).setScale(2, RoundingMode.HALF_UP);
		
		while (iterator.hasNext()) {
            Veiculo veiculo = iterator.next();
            if (veiculo.getModelo().equals(modelo) && veiculo.getMarca().equals(marca) && veiculo.precoSemDepreciacao().compareTo(precoConvertido) == 0) {
            	Venda<Veiculo> venda = new Venda<>(veiculo,cliente);
            	vendasRealizadas.add(venda);
                iterator.remove();
                comissaoTotal = comissaoTotal.add(calcularComissao(precoConvertido));
                System.out.println("O vendedor " + getNome() + " registrou a venda: "+ veiculo);
                veiculoEncontrado = true;
                break;
            }
        }
		
		if (!veiculoEncontrado) {
            System.out.println("Carro não encontrado.");
        }
	}
	
	public List<Venda<Veiculo>> getVendasRealizadas() {
		return vendasRealizadas;
	}


	public  BigDecimal calcularComissao(BigDecimal valorVenda) {
        return valorVenda.multiply(new BigDecimal("0.03")).setScale(2, RoundingMode.HALF_UP);//faz a multiplicaçao e define 2 casas apos a virgula
    }

	public BigDecimal getComissaoTotal() {
		return comissaoTotal;
	}
	
	public void mostrarComissaoDasVendas() {
		System.out.println("Comissao total das vendas do " + getNome() + ": " + getComissaoTotal());
	}

	@Override
	public String toString() {
		return getNome();
	}
	
	public static String listaParaString(List<Venda<Veiculo>> vr) {
		StringBuilder sb = new StringBuilder();
		if (vr != null) {
        for (Venda<Veiculo> venda : vr) {
            sb.append(venda.toString()).append("\n");
        }
	  }else {
          sb.append("Lista de vendas é nula.\n");
      }
		
        return sb.toString();
    }
	
}
