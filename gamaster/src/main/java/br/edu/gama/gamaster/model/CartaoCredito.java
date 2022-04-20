package br.edu.gama.gamaster.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_cartao")
@Getter
@Setter
@EqualsAndHashCode(of = "codigo")
public class CartaoCredito implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@NotBlank
	@Column(name = "numero")
    private String numero;
	
	@NotNull
	@Column(name = "validade")
    private LocalDate validade;
	
	@NotBlank
	@Column(name = "cod_seguranca")
    private String codigoSeguranca;
	
	@NotBlank
	@Column(name = "bandeira")
    private String bandeira;
	
	@NotBlank
	@Column(name = "portador")
    private String nomePortador;
	
	@NotNull
	@Column(name = "limite")
	private BigDecimal limite;
	
	@Column(name = "limite_disponivel")
	private BigDecimal limiteDesponivel;

}
