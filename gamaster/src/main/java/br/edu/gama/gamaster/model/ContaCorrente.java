package br.edu.gama.gamaster.model;

import java.math.BigDecimal;

public class ContaCorrente extends Conta {

    public ContaCorrente(BigDecimal saldo , String agencia, String numeroConta, CartaoCredito cartao ) {
        super(saldo,agencia,numeroConta,cartao);
        this.saldo = saldo;
    }

    @Override
    public BigDecimal getSaldo() {
        return saldo;
    }

    @Override
    public BigDecimal depositar(BigDecimal valor) {
        if(valor.compareTo(BigDecimal.ZERO) > 0){
            saldo= saldo.add(valor);
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
            }else {
                System.out.println("Saldo insuficiente!");
            }
        }else {
            System.out.println("Valor invalido");
        }
        return saldo;
    }

}
