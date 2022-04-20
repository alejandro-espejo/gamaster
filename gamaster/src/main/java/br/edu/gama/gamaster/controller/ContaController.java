package br.edu.gama.gamaster.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.gama.gamaster.event.RecursoCriadoEvent;
import br.edu.gama.gamaster.model.Conta;
import br.edu.gama.gamaster.model.dto.ContaDto;
import br.edu.gama.gamaster.service.ContaService;

@RestController
@RequestMapping("/contas")
public class ContaController {

	@Autowired
	private ContaService contaService;

	@Autowired
	private ApplicationEventPublisher publisher;

	@GetMapping
	public List<Conta> buscarTodas() {
		return contaService.buscarTodasContas();
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<Conta> buscarPorCodigo(@PathVariable Long codigo) {
		Conta conta = contaService.buscarPorCodigo(codigo);
		return ResponseEntity.ok(conta);
	}

	@PostMapping
	public ResponseEntity<Conta> cadastrar(@Valid @RequestBody ContaDto conta, Boolean isContaEspecial,
			HttpServletResponse response) {
		Conta ContaSalva = contaService.criarConta(isContaEspecial, conta);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, ContaSalva.getCodigo()));
		return ResponseEntity.status(HttpStatus.CREATED).body(ContaSalva);
	}

}
