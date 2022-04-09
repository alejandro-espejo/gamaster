package br.edu.gama.gamaster.model;

import java.math.BigDecimal;

public abstract class  Conta {
    protected BigDecimal saldo;
    private String agencia;
    private String numeroConta;
    private CartaoCredito cartao;

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

    public Conta(BigDecimal saldo, String agencia, String numeroConta, CartaoCredito cartao) {
        super();
        this.saldo = saldo;
        this.agencia = agencia;
        this.numeroConta = numeroConta;
        this.cartao = cartao;
    }

    public abstract BigDecimal depositar(BigDecimal valor);

    public abstract BigDecimal sacar(BigDecimal valor);
}
