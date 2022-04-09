package br.edu.gama.gamaster.model;

public abstract class  Conta {
    protected Double saldo;
    private String agencia;
    private String numeroConta;
    private CartaoCredito cartao;

    public abstract Double getSaldo();

    public String getAgencia() {
        return agencia;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public CartaoCredito getCartao() {
        return cartao;
    }

    public abstract double depositar(double valor);

    public abstract double sacar(double valor);

    public Conta(Double saldo, String agencia, String numeroConta, CartaoCredito cartao) {
        super();
        this.saldo = saldo;
        this.agencia = agencia;
        this.numeroConta = numeroConta;
        this.cartao = cartao;
    }
}
