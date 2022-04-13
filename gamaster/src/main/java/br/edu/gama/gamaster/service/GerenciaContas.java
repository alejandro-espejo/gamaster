package br.edu.gama.gamaster.service;

import java.math.BigDecimal;
import java.util.List;

import br.edu.gama.gamaster.model.Conta;
import br.edu.gama.gamaster.model.Movimentacao;

public class GerenciaContas {
	
	public static void inserir (Conta conta, BigDecimal valor){
		conta.depositar(valor);
	}
	
	public static void remover (Conta conta, BigDecimal valor) {
		conta.sacar(valor);
	}
	
	public static BigDecimal consultarSaldo(Conta conta) {
		return conta.getSaldo();
	}

	public static List<Movimentacao> consultarExtrato(Conta conta){
		return conta.getMovimentacoes();
	}
	
	public static void transferir(Conta conta, Conta contaDestino, BigDecimal valor) {
		conta.transferir(contaDestino, valor);
	}
	
}