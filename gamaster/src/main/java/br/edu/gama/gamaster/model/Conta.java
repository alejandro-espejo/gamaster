package br.edu.gama.gamaster.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_conta")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "DTYPE")
@Getter
@Setter
@EqualsAndHashCode(of = "codigo")
public abstract class Conta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo")
	private Long codigo;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_conta")
	private TipoConta tipoConta;
	
	@Column(name = "saldo")
	private BigDecimal saldo;
	
	@NotBlank
	@Column(name = "agencia")
	private String agencia;
	
	@NotBlank
	@Column(name = "numero_conta")
	private String numeroConta;
	
	@NotNull
	@Column(name = "data_criacao")
	private LocalDate dataCriacao;

//	private CartaoCredito cartao;
//	private Cliente cliente;

	@OneToMany(mappedBy = "contaOrigem")
	private List<Movimentacao> movimentacoesOrigem = new ArrayList<>();

	@OneToMany(mappedBy = "contaDestino")
	private List<Movimentacao> movimentacoesDestino = new ArrayList<>();

	public Conta(BigDecimal saldo, String agencia, String numeroConta) {
		this.saldo = saldo;
		this.agencia = agencia;
		this.numeroConta = numeroConta;
	}

	public abstract BigDecimal getSaldo();

	@OneToOne
	@JoinColumn(name = "cod_cartao")
	private CartaoCredito cartao;
	
	@NotNull
	@OneToOne
	@JoinColumn(name = "cod_cliente")
	private Cliente cliente;

}
