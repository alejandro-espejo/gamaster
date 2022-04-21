package br.edu.gama.gamaster.exceptionhandler;

public class ContaSemSaldoException extends Throwable {
    public ContaSemSaldoException(Long codigo) {
        super(String.format("Conta %s não possui saldo suficiente!", codigo));
    }
}
