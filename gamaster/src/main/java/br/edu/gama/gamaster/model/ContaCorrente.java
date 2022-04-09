package br.edu.gama.gamaster.model;

public class ContaCorrente extends Conta {


    public ContaCorrente( Double saldo , String agencia, String numeroConta, CartaoCredito cartao ) {
        super(saldo,agencia,numeroConta,cartao);
        this.saldo = saldo;
    }

    @Override
    public Double getSaldo() {
        return saldo;
    }

    @Override
    public double depositar(double valor) {
        if((valor != 0.00)&&(valor > 0.00)){
            saldo+=valor;
        }else {
            System.out.println("Valor invalido");
        }
        return saldo;
    }

    @Override
    public double sacar(double valor) {
        if((valor != 0.00)&&(valor > 0.00)){
            if(valor <= saldo) {
                saldo-=valor;
            }else {
                System.out.println("Saldo insuficiente!");
            }
        }else {
            System.out.println("Valor invalido");
        }
        return saldo;
    }

}
