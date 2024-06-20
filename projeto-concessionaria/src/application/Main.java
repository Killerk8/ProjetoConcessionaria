package application;

import java.util.List;

import constants.TipoCombustivel;
import entities.CarroNovo;
import entities.CarroUsado;
import entities.Cliente;
import entities.Gerente;
import entities.Veiculo;
import entities.Venda;
import entities.Vendedor;

public class Main {

	public static void main(String[] args) {
		
		CarroUsado c1 = new CarroUsado("Fusca","Volks",2024, 160,TipoCombustivel.GASOLINA,1000);
		CarroUsado c2 = new CarroUsado("Camionete", "Toyota", 2023, 500,TipoCombustivel.DIESEL,5000);
		CarroUsado c3 = new CarroUsado("Conversivel", "Ferrari", 2022, 400,TipoCombustivel.HIBRIDO,10000);
		CarroUsado c4 = new CarroUsado("Geep", "Geep", 2021, 600,TipoCombustivel.ELETRICO,0);
		
		CarroNovo c5 = new CarroNovo("Golf", "Volks", 2019, 800, TipoCombustivel.GASOLINA);
		CarroNovo c6 = new CarroNovo("Jetta", "Volks", 2023, 200, TipoCombustivel.GASOLINA);

		List<Veiculo> cp = Veiculo.getVeiculosDisponiveis();
		System.out.println(Veiculo.listaParaString(cp));
		
		Cliente cl1 = new Cliente("Sidcley", "111.111.111-11", "Disney");
		
		Vendedor v1 = new Vendedor("Cleyton",1);
		v1.registrarVenda("Jetta", "Volks", 200,cl1);
		
		Vendedor v2 = new Vendedor("Rogerio", 2);
		v2.registrarVenda("Camionete", "Toyota", 500,cl1);
		v2.registrarVenda("Conversivel", "Ferrari", 400,cl1);
		
		Vendedor v3 = new Vendedor("Thomas", 3);
		v3.registrarVenda("Golf", "Volks", 800,cl1);
		v3.registrarVenda("Geep", "Geep", 600,cl1);
		
		
		System.out.println();
		v1.mostrarComissaoDasVendas();
		v2.mostrarComissaoDasVendas();
		v3.mostrarComissaoDasVendas();
		
		Gerente g1 = new Gerente("Romario", 4);
		g1.adicionarVendedor(v1);
		g1.adicionarVendedor(v2);
		g1.adicionarVendedor(v3);
		
		System.out.println();
		System.out.println("Vendedores surpevisionados:");
		System.out.println(g1.getVendedoresSupervisionados());
		
		/*
		System.out.println();
		System.out.println("Remocao do vendedor 3.");
		g1.removerVendedor(v3);
		*/
		
		System.out.println();
		System.out.println("Vendedores surpevisionados:");
		System.out.println(g1.getVendedoresSupervisionados());
		
		System.out.println();
		

		System.out.println(Venda.listaParaString(v1.getVendasRealizadas()));
		System.out.println(Venda.listaParaString(v2.getVendasRealizadas()));
		
		System.out.println();
		System.out.println("Comissao do gerente: " + g1.calcularComissaoTotal());
		g1.avaliarDesempenhoVendedores();
		
		System.out.println();
		System.out.println("Carros disponiveis.");
		List<Veiculo> xx = Veiculo.getVeiculosDisponiveis();
		System.out.println(Veiculo.listaParaString(xx));
		
		
		cl1.addVeiculoHistorico(c1);
		cl1.addVeiculoHistorico(c2);
		cl1.addVeiculoHistorico(c6);
		
		cl1.removeVeiculoHistorico(c2);
		
		
		System.out.println("Veiculos no historico:");
		List<Veiculo> xy = Cliente.getHistoricoDeCompra();
		System.out.println(Cliente.listaParaString(xy));
}
}