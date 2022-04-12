package br.edu.gama.gamaster.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class ContaCorrente extends Conta {

    public ContaCorrente(BigDecimal saldo , String agencia, String numeroConta, CartaoCredito cartao, Cliente cliente) {
        super(saldo,agencia,numeroConta,cartao, cliente);
        this.saldo = saldo;
    }

    public ContaCorrente() {
    }

    @Override
    public BigDecimal getSaldo() {
        return saldo;
    }

    @Override
    public BigDecimal depositar(BigDecimal valor ) {
        if(valor.compareTo(BigDecimal.ZERO) > 0){
            saldo= saldo.add(valor);
            Movimentacao movimentacao = new Movimentacao(UUID.randomUUID(), TipoMovimentacao.ENTRADA,
            		LocalDateTime.now(), valor, this, new ContaCorrente());
            getMovimentacoes().add(movimentacao);
        }else {
            System.out.println("Valor invalido");
        }
        return saldo;
    }

    @Override
    public BigDecimal sacar(BigDecimal valor) {
        if(valor.compareTo(BigDecimal.ZERO) > 0){
            if(valor.compareTo(saldo) < 1) {
                saldo = saldo.subtract(valor);
                Movimentacao movimentacao = new Movimentacao(UUID.randomUUID(), TipoMovimentacao.SAIDA,
                        LocalDateTime.now(), valor, this, new ContaCorrente() {
                });
                getMovimentacoes().add(movimentacao);
            }else {
                System.out.println("Saldo insuficiente!");
            }
        }else {
            System.out.println("Valor invalido");
        }
        return saldo;
    }

}
