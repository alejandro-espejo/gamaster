package br.edu.gama.gamaster.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.edu.gama.gamaster.model.CartaoCredito;
import br.edu.gama.gamaster.repository.CartaoCreditoRepository;

@Service
public class CartaoCreditoService {

	@Autowired
	private CartaoCreditoRepository cartaoCreditoRepository;

	public List<CartaoCredito> buscarTodos() {
		return cartaoCreditoRepository.findAll();
	}

	public CartaoCredito buscarPorCodigo(Long codigo) {
		CartaoCredito cartaoCredito = buscarCartaoPeloCodigo(codigo);
		return cartaoCredito;
	}

	private CartaoCredito buscarCartaoPeloCodigo(Long codigo) {
		Optional<CartaoCredito> cartaoCredito = cartaoCreditoRepository.findById(codigo);
		if (!cartaoCredito.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		return cartaoCredito.get();
	}

	public CartaoCredito salvarCartao(CartaoCredito cartaoCredito) {
		return cartaoCreditoRepository.save(cartaoCredito);
	}

	public void excluirCartao(Long codigo) {
		CartaoCredito cartaoCredito = buscarCartaoPeloCodigo(codigo);
		cartaoCreditoRepository.delete(cartaoCredito);
	}
	
	public CartaoCredito atualizarCartao(Long codigo, CartaoCredito cartaoCredito) {
		CartaoCredito cartaoSalvo = buscarCartaoPeloCodigo(codigo);
		BeanUtils.copyProperties(cartaoCredito, cartaoSalvo, "codigo");
		return cartaoCreditoRepository.save(cartaoSalvo);
	}

}
