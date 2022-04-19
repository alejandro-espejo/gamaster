package br.edu.gama.gamaster.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class Endereco {

	@Column(name = "logradouro")
	@Size(max = 50)
	private String logradouro;
	
	@Column(name = "numero")
	@Size(max = 10)
	private String numero;
	
	@Column(name = "complemento")
	@Size(max = 50)
	private String complemento;
	
	@Column(name = "bairro")
	@Size(max = 50)
	private String bairro;
	
	@Column(name = "cep")
	@Size(max = 20)
	private String cep;
	
	@Column(name = "cidade")
	@Size(max = 20)
	private String cidade;
	
	@Column(name = "estado")
	@Size(max = 2)
	private String estado;

}
