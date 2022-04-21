package br.edu.gama.gamaster.service;

import br.edu.gama.gamaster.exceptionhandler.ContaSemSaldoException;
import br.edu.gama.gamaster.model.Conta;
import br.edu.gama.gamaster.model.Movimentacao;
import br.edu.gama.gamaster.model.dto.MovimentacaoDto;
import br.edu.gama.gamaster.repository.MovimentacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovimentacaoService {

    @Autowired
    private MovimentacaoRepository movimentacaoRepository;

    @Autowired
    private ContaService contaService;

    public List<Movimentacao> buscarMovimentacaoPorConta(Long codigoConta) {
        Conta conta = contaService.buscarPorCodigo(codigoConta);

        return movimentacaoRepository.findByContaOrigemOrContaDestino(conta, conta);
    }

    public List<Movimentacao> buscarMovimentacaoEntreContas(Long codigoContaOrigem, Long codigoContaDestino) {
        Conta contaOrigem = contaService.buscarPorCodigo(codigoContaOrigem);
        Conta contaDestino = contaService.buscarPorCodigo(codigoContaDestino);

        return movimentacaoRepository.findByContaOrigemAndContaDestino(contaOrigem, contaDestino);
    }

    public List<Movimentacao> buscarSaidasPorConta(Long codigoConta) {
        return movimentacaoRepository.buscarSaidasPorConta(codigoConta);
    }

    public List<Movimentacao> buscarEntradasPorConta(Long codigoConta) {
        return movimentacaoRepository.buscarEntradasPorConta(codigoConta);
    }

    public Movimentacao criarMovimentacao(MovimentacaoDto movimentacaoDto) {
        Movimentacao movimentacao = movimentacaoDto.toModel(contaService);
        contaService.atualizarSaldo(movimentacao.getContaOrigem(), movimentacao.getContaDestino(), movimentacao.getValor());
        return movimentacaoRepository.save(movimentacao);
    }
}
