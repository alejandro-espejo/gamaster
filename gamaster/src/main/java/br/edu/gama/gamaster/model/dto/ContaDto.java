package br.edu.gama.gamaster.model.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.edu.gama.gamaster.model.Cliente;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContaDto {

	@NotBlank
	private String agencia;
	
	@NotBlank
	private String numeroConta;
	
	@NotNull
	private Cliente cliente;

}
