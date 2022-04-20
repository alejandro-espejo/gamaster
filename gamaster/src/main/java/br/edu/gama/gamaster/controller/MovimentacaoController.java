package br.edu.gama.gamaster.controller;

import br.edu.gama.gamaster.model.Conta;
import br.edu.gama.gamaster.model.Movimentacao;
import br.edu.gama.gamaster.repository.ContaRepository;
import br.edu.gama.gamaster.repository.MovimentacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movimentacoes")
public class MovimentacaoController {

    @Autowired
    private MovimentacaoRepository movimentacaoRepository;
    @Autowired
    private ContaRepository contaRepository;

    @GetMapping("/{idConta}")
    public List<Movimentacao> buscarMovimentacoesPorConta(@PathVariable Long idConta) {
        Conta conta = contaRepository.findById(idConta).get();
        return movimentacaoRepository.findByContaDestinoOrContaOrigem(idConta, idConta);
    }

}
