package br.edu.gama.gamaster.model;

import java.math.BigDecimal;

public class ContaEspecial extends Conta{

    private BigDecimal limiteDeCreditoPreAprov;

    public ContaEspecial(BigDecimal saldo, String agencia, String numeroConta,
                         CartaoCredito cartao, BigDecimal limiteDeCreditoPreAprov){
        super(saldo, agencia, numeroConta, cartao);
        this.limiteDeCreditoPreAprov = limiteDeCreditoPreAprov;
        this.saldo = saldo.add(limiteDeCreditoPreAprov) ;
    }

    @Override
    public BigDecimal getSaldo() {
        return saldo;
    }

    @Override
    public BigDecimal depositar(BigDecimal valor) {
        if(valor.compareTo(BigDecimal.ZERO) > 0){
            saldo = saldo.add(valor);
        }else {
            System.out.println("Valor inválido");
        }
        return saldo;
    }

    @Override
    public BigDecimal sacar(BigDecimal valor) {
        if(valor.compareTo(BigDecimal.ZERO) > 0){
            if(valor.compareTo(saldo) <= 0) {
                saldo = saldo.subtract(valor);
            }else {
                System.out.println("Saldo insuficiente!");
            }
        }else {
            System.out.println("Valor inválido");
        }
        return saldo;
    }
}
