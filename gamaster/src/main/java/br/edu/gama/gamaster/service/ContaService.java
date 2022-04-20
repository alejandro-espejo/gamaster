package br.edu.gama.gamaster.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.edu.gama.gamaster.model.Conta;
import br.edu.gama.gamaster.model.dto.ContaDto;
import br.edu.gama.gamaster.repository.ContaRepository;

@Service
public class ContaService {

	@Autowired
	private ContaRepository contaRepository;

	public List<Conta> buscarTodasContas() {
		return contaRepository.findAll();
	}

	public Conta buscarPorCodigo(Long codigo) {
		Conta conta = buscarContaPeloCodigo(codigo);
		return conta;
	}

	public Conta criarConta(Boolean isContaEspecial, ContaDto conta) {
		if (isContaEspecial) {
			return contaRepository.save(CriarContaEspecial.criarContaEspecial(conta));
		} else {
			return contaRepository.save(CriarContaCorrente.criarContaCorrente(conta));
		}
	}

	private Conta buscarContaPeloCodigo(Long codigo) {
		Optional<Conta> conta = contaRepository.findById(codigo);
		if (!conta.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		return conta.get();
	}
}
