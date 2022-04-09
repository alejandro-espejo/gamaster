package br.edu.gama.gamaster.model;

import java.util.Objects;

public class Cliente {

	private Long codigo;
	private String nome;
	private String cnpjCpf;
	private String telefone;

	public Cliente() {
		super();
	}

	public Cliente(Long codigo, String nome, String cnpjCpf, String telefone) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.cnpjCpf = cnpjCpf;
		this.telefone = telefone;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpjCpf() {
		return cnpjCpf;
	}

	public void setCnpjCpf(String cnpjCpf) {
		this.cnpjCpf = cnpjCpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(codigo, other.codigo);
	}

}
