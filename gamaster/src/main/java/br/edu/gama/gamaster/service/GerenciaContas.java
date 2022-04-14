package br.edu.gama.gamaster.service;

import java.math.BigDecimal;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

import br.edu.gama.gamaster.model.Conta;
import br.edu.gama.gamaster.model.ContaCorrente;
import br.edu.gama.gamaster.model.Movimentacao;

public class GerenciaContas {
	
	public static void inserir (Conta conta, BigDecimal valor){

		conta.depositar(valor, null);
	}
	
	public static void remover (Conta conta, BigDecimal valor) {
		conta.sacar(valor, null);
	}
	
	public static BigDecimal consultarSaldo(Conta conta) {
		return conta.getSaldo();
	}
	
	public static void transferir(Conta contaOrigem, Conta contaDestino, BigDecimal valor) {
		contaOrigem.transferir(contaDestino, valor);
	}

	public static void consultarExtrato(Conta conta){
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter
				.ofPattern("yyyy-MM-dd HH:mm:ss")
				.withZone(ZoneId.of("GMT-3"));

		System.out.println("===== EXTRATO DA CONTA =====");
		System.out.format("%-25s %-10s %-17s %-10s %-10s %n", "Data da Mov.", "Tipo", "Valor", "Origem", "Destino");
		for (Movimentacao mov : conta.getMovimentacoes()) {
			System.out.format("%-25s %-10s R$ %-14.2f %-10s %-10s %n",
					dateTimeFormatter.format(mov.getDataMovimentacao()), mov.getTipoMovimentacao()
					, mov.getValor(), mov.getContaOrigem() != null ? mov.getContaOrigem().getNumeroConta() : "-"
					, mov.getContaDestino() != null ? mov.getContaDestino().getNumeroConta() : "-");
		}
		System.out.format("%-25s %-10s %-17s %-10s %-7.2f %n", "", "", "Saldo da Conta", "=", conta.getSaldo());
	}
	
}