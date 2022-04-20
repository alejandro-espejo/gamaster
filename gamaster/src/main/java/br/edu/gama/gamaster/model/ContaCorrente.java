package br.edu.gama.gamaster.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;
@Entity
@DiscriminatorValue("CC")
public class ContaCorrente extends Conta {

    public ContaCorrente(BigDecimal saldo , String agencia, String numeroConta) {
        super(saldo,agencia,numeroConta);
        this.saldo = saldo;
    }

    public ContaCorrente() {
        super();
    }

    @Override
    public BigDecimal getSaldo() {
        return saldo;
    }
    
    @Override
    public void transferir(Conta contaDestino, BigDecimal valor) {
    	if(valor.compareTo(BigDecimal.ZERO) > 0){
            if(valor.compareTo(saldo) < 1) {
                this.sacar(valor, contaDestino);
                contaDestino.depositar(valor, this);
            }else {
                System.out.println("Saldo insuficiente!");
            }
        }else {
            System.out.println("Valor invalido");
        }
    }

    @Override
    public BigDecimal depositar(BigDecimal valor, Conta contaOrigem ) {
        if(valor.compareTo(BigDecimal.ZERO) > 0){
            saldo= saldo.add(valor);
//            Movimentacao movimentacao = new Movimentacao(UUID.randomUUID(), TipoMovimentacao.ENTRADA,
//            		LocalDateTime.now(), valor, contaOrigem, this);
//            getMovimentacoes().add(movimentacao);
        }else {
            System.out.println("Valor invalido");
        }
        return saldo;
    }

    @Override
    public BigDecimal sacar(BigDecimal valor, Conta contaDestino) {
        if(valor.compareTo(BigDecimal.ZERO) > 0){
            if(valor.compareTo(saldo) < 1) {
                saldo = saldo.subtract(valor);
//                Movimentacao movimentacao = new Movimentacao(UUID.randomUUID(), TipoMovimentacao.SAIDA,
//                        LocalDateTime.now(), valor, this, contaDestino);
//                getMovimentacoes().add(movimentacao);
            }else {
                System.out.println("Saldo insuficiente!");
            }
        }else {
            System.out.println("Valor invalido");
        }
        return saldo;
    }

}
