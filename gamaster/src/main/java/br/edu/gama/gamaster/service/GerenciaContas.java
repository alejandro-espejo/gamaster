package br.edu.gama.gamaster.service;

import java.math.BigDecimal;

import br.edu.gama.gamaster.model.Conta;

public class GerenciaContas {
	
	public static void inserir (Conta conta, double valor){
		
	}
	
	public static void remover (Conta conta, BigDecimal valor) {
		conta.sacar(valor);
	}
	
	public static void consultar (Conta conta) {
		conta.getSaldo();
	}
	
}