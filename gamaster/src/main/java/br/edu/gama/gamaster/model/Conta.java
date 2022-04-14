package br.edu.gama.gamaster.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public abstract class Conta {
	protected BigDecimal saldo;
	private String agencia;
	private String numeroConta;
	private CartaoCredito cartao;
	private Cliente cliente;
	private List<Movimentacao> movimentacoes = new ArrayList<>();

	public abstract BigDecimal getSaldo();

	public String getAgencia() {
		return agencia;
	}

	public String getNumeroConta() {
		return numeroConta;
	}

	public CartaoCredito getCartao() {
		return cartao;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public List<Movimentacao> getMovimentacoes() {
		return movimentacoes;
	}

	public void setMovimentacoes(List<Movimentacao> movimentacoes) {
		this.movimentacoes = movimentacoes;
	}

	public Conta(BigDecimal saldo, String agencia, String numeroConta, CartaoCredito cartao, Cliente cliente) {
		super();
		this.saldo = saldo;
		this.agencia = agencia;
		this.numeroConta = numeroConta;
		this.cartao = cartao;
		this.cliente = cliente;
	}

	public Conta() {
	}

	public abstract BigDecimal depositar(BigDecimal valor, Conta contaOrigem);

	public abstract BigDecimal sacar(BigDecimal valor, Conta contaDestino);
	
	public abstract void transferir(Conta contaDestino, BigDecimal valor);
	
	
}
