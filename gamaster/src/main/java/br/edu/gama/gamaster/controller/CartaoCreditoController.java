package br.edu.gama.gamaster.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.gama.gamaster.event.RecursoCriadoEvent;
import br.edu.gama.gamaster.model.CartaoCredito;
import br.edu.gama.gamaster.service.CartaoCreditoService;

@RestController
@RequestMapping("/cartao-credito")
public class CartaoCreditoController {

	@Autowired
	private CartaoCreditoService cartaoCreditoService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	public List<CartaoCredito> listar() {
		List<CartaoCredito> cartoes = cartaoCreditoService.buscarTodos();
		return cartoes;
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<CartaoCredito> buscarPorCodigo(@PathVariable Long codigo) {
		CartaoCredito cartaoCredito = cartaoCreditoService.buscarPorCodigo(codigo);
		return ResponseEntity.ok(cartaoCredito);
	}
	
	@PostMapping
	public ResponseEntity<CartaoCredito> cadastrar(@Valid @RequestBody CartaoCredito cartaoCredito, HttpServletResponse response) {
		CartaoCredito cartaoSalvo = cartaoCreditoService.salvarCartao(cartaoCredito);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, cartaoSalvo.getCodigo()));
		return ResponseEntity.status(HttpStatus.CREATED).body(cartaoSalvo);
	}
	
	@PutMapping("/{codigo}")
	public ResponseEntity<CartaoCredito> atualizar(@PathVariable Long codigo, @Valid @RequestBody CartaoCredito cartaoCredito) {
		CartaoCredito cartaoCreditoAtualizado = cartaoCreditoService.atualizarCartao(codigo, cartaoCredito);
		return ResponseEntity.ok(cartaoCreditoAtualizado);
	}
	
	@DeleteMapping("/{codigo}")
	public ResponseEntity<Void> excluir(@PathVariable Long codigo) {
		cartaoCreditoService.excluirCartao(codigo);
		return ResponseEntity.noContent().build();
	}
}
