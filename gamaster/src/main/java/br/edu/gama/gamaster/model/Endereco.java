package br.edu.gama.gamaster.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Size;

@Embeddable
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

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
