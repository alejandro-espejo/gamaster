package br.edu.gama.gamaster.model;

import java.math.BigDecimal;

public class ContaEspecial extends Conta {

	private BigDecimal limiteDeCreditoPreAprov;

	public BigDecimal getLimiteDeCreditoPreAprov() {
		return limiteDeCreditoPreAprov;
	}

	public void setLimiteDeCreditoPreAprov(BigDecimal limiteDeCreditoPreAprov) {
		this.limiteDeCreditoPreAprov = limiteDeCreditoPreAprov;
	}

	public ContaEspecial(BigDecimal saldo, String agencia, String numeroConta, CartaoCredito cartao, Cliente cliente,
			BigDecimal limiteDeCreditoPreAprov) {
		super(saldo, agencia, numeroConta, cartao, cliente);
		this.limiteDeCreditoPreAprov = limiteDeCreditoPreAprov;
		this.saldo = saldo.add(limiteDeCreditoPreAprov);
	}

	public ContaEspecial() {
	}

	@Override
	public BigDecimal getSaldo() {
		return saldo;
	}

	@Override
	public BigDecimal depositar(BigDecimal valor) {
		if (valor.compareTo(BigDecimal.ZERO) > 0) {
			saldo = saldo.add(valor);
		} else {
			System.out.println("Valor inválido");
		}
		return saldo;
	}

	@Override
	public BigDecimal sacar(BigDecimal valor) {
		if (valor.compareTo(BigDecimal.ZERO) > 0) {
			if (valor.compareTo(saldo) <= 0) {
				saldo = saldo.subtract(valor);
			} else {
				System.out.println("Saldo insuficiente!");
			}
		} else {
			System.out.println("Valor inválido");
		}
		return saldo;
	}
}
