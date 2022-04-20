package br.edu.gama.gamaster.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

//@MappedSuperclass
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_conta")
@Table(name = "tb_conta")
public abstract class Conta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	protected BigDecimal saldo;
	private String agencia;
	private String numeroConta;
//	private CartaoCredito cartao;
//	private Cliente cliente;

	@OneToMany(mappedBy = "contaOrigem")
	private List<Movimentacao> movimentacoesOrigem = new ArrayList<>();

	@OneToMany(mappedBy = "contaDestinoId")
	private List<Movimentacao> movimentacoesDestino = new ArrayList<>();

	public Conta(BigDecimal saldo, String agencia, String numeroConta) {
		this.saldo = saldo;
		this.agencia = agencia;
		this.numeroConta = numeroConta;
	}

	public abstract BigDecimal getSaldo();

	public String getAgencia() {
		return agencia;
	}

	public String getNumeroConta() {
		return numeroConta;
	}

	public abstract BigDecimal depositar(BigDecimal valor, Conta contaOrigem);

	public abstract BigDecimal sacar(BigDecimal valor, Conta contaDestino);
	
	public abstract void transferir(Conta contaDestino, BigDecimal valor);
	
	
}
