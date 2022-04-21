package br.edu.gama.gamaster.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_conta")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "DTYPE")
@Getter
@Setter
@EqualsAndHashCode(of = "codigo")
@NoArgsConstructor
@ToString
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "codigo")
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
	@JsonBackReference
	@ToString.Exclude
	private List<Movimentacao> movimentacoesOrigem = new ArrayList<>();

	@OneToMany(mappedBy = "contaDestino")
	@JsonBackReference
	@ToString.Exclude
	private List<Movimentacao> movimentacoesDestino = new ArrayList<>();

	public Conta(BigDecimal saldo, String agencia, String numeroConta) {
		this.saldo = saldo;
		this.agencia = agencia;
		this.numeroConta = numeroConta;
	}

//	public abstract BigDecimal getSaldo();

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cod_cartao")
	@ToString.Exclude
	private CartaoCredito cartao;

	@NotNull
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cod_cliente")
	private Cliente cliente;

}
