package br.edu.gama.gamaster.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class ContaEspecial extends Conta {

	private BigDecimal limiteDeCreditoPreAprovado;

	public BigDecimal getLimiteDeCreditoPreAprovado() {
		return limiteDeCreditoPreAprovado;
	}

	public void setLimiteDeCreditoPreAprovado(BigDecimal limiteDeCreditoPreAprovado) {
		this.limiteDeCreditoPreAprovado = limiteDeCreditoPreAprovado;
	}

	public ContaEspecial(BigDecimal saldo, String agencia, String numeroConta, CartaoCredito cartao, Cliente cliente,
			BigDecimal limiteDeCreditoPreAprovado) {
		super(saldo, agencia, numeroConta, cartao, cliente);
		this.limiteDeCreditoPreAprovado = limiteDeCreditoPreAprovado;
		this.saldo = saldo.add(limiteDeCreditoPreAprovado);
	}

	public ContaEspecial() {
	}
	
	@Override
    public void transferir(Conta contaDestino, BigDecimal valor) {
    	if(valor.compareTo(BigDecimal.ZERO) > 0){
            if(valor.compareTo(saldo) < 1) {
                this.sacar(valor);
                contaDestino.depositar(valor);
                Movimentacao movimentacao = new Movimentacao(UUID.randomUUID(), TipoMovimentacao.TRANSFERENCIA,
                        LocalDateTime.now(), valor, this, contaDestino);
                getMovimentacoes().add(movimentacao);
                
            }else {
                System.out.println("Saldo insuficiente!");
            }
        }else {
            System.out.println("Valor invalido");
        }
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
				Movimentacao movimentacao = new Movimentacao(UUID.randomUUID(), TipoMovimentacao.SAIDA,
						LocalDateTime.now(), valor, this, new ContaCorrente() {
				});
				getMovimentacoes().add(movimentacao);
			} else {
				System.out.println("Saldo insuficiente!");
			}
		} else {
			System.out.println("Valor inválido");
		}
		return saldo;
	}
}
