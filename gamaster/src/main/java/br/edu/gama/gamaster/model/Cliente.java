package br.edu.gama.gamaster.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_cliente")
@Getter
@Setter
@EqualsAndHashCode
public class Cliente implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo")
	private Long codigo;
	
	@NotBlank
	@Size(min = 3, max = 50)
	@Column(name = "nome")
	private String nome;
	
	@NotBlank
	@Column(name = "cpf_cnpj")
	@Size(max = 25)
	private String cnpjCpf;
	
	@NotBlank
	@Column(name = "telefone")
	@Size(max = 20)
	private String telefone;
	
	@Embedded
	private Endereco endereco;

}
