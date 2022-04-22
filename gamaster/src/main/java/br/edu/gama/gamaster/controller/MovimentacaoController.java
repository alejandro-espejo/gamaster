package br.edu.gama.gamaster.controller;

import br.edu.gama.gamaster.event.RecursoCriadoEvent;
import br.edu.gama.gamaster.model.Movimentacao;
import br.edu.gama.gamaster.model.dto.MovimentacaoDto;
import br.edu.gama.gamaster.service.MovimentacaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/movimentacoes")
public class MovimentacaoController {

    @Autowired
    private MovimentacaoService movimentacaoService;

    @Autowired
    private ApplicationEventPublisher publisher;

    @GetMapping
    @Operation(summary = "Retorna todos os objetos movimentação de uma conta", tags = {"movimentação"})
	@ApiResponses({@ApiResponse(responseCode = "200", description = "Successful Operation")})
    public ResponseEntity<List<Movimentacao>> buscarMovimentacoesPorConta(@RequestParam(name = "codigoConta") Long codigoConta) {
        List<Movimentacao> movimentacaoList = movimentacaoService.buscarMovimentacaoPorConta(codigoConta);
        return ResponseEntity.ok(movimentacaoList);
    }

    @GetMapping("/entre-contas")
    @Operation(summary = "Retorna todos os objetos movimentação entre contas específicas", tags = {"movimentação"})
	@ApiResponses({@ApiResponse(responseCode = "200", description = "Successful Operation")})
    public ResponseEntity<List<Movimentacao>> buscarMovimentacaoEntreContas(
            @RequestParam(name = "codigoContaOrigem") Long codigoContaOrigem,
            @RequestParam(name = "codigoContaDestino") Long codigoContaDestino) {
        List<Movimentacao> movimentacaoList = movimentacaoService.buscarMovimentacaoEntreContas(codigoContaOrigem, codigoContaDestino);
        return ResponseEntity.ok(movimentacaoList);
    }

    @GetMapping("/saidas")
    @Operation(summary = "Retorna todos os objetos movimentação de saida de uma conta específicas", tags = {"movimentação"})
	@ApiResponses({@ApiResponse(responseCode = "200", description = "Successful Operation")})
    public ResponseEntity<List<Movimentacao>> buscarSaidasPorConta(@RequestParam(name = "codigoConta") Long codigoConta) {
        List<Movimentacao> movimentacaoList = movimentacaoService.buscarSaidasPorConta(codigoConta);
        return ResponseEntity.ok(movimentacaoList);
    }

    @GetMapping("/entradas")
    @Operation(summary = "Retorna todos os objetos movimentação de entrada de uma conta específicas", tags = {"movimentação"})
   	@ApiResponses({@ApiResponse(responseCode = "200", description = "Successful Operation")})
    public ResponseEntity<List<Movimentacao>> buscarEntradasPorConta(@RequestParam(name = "codigoConta") Long codigoConta) {
        List<Movimentacao> movimentacaoList = movimentacaoService.buscarEntradasPorConta(codigoConta);
        return ResponseEntity.ok(movimentacaoList);
    }

    @PostMapping
    @Operation(summary = "Cria e retorna um objeto movimentação", tags = {"movimentação"})
	@ApiResponses({@ApiResponse(responseCode = "201", description = "Created")})
    public ResponseEntity<Movimentacao> cadastrar(@RequestBody MovimentacaoDto movimentacaoDto, HttpServletResponse response) {
        Movimentacao movimentacaoSalva = movimentacaoService.criarMovimentacao(movimentacaoDto);
        publisher.publishEvent(new RecursoCriadoEvent(this, response, movimentacaoSalva.getId()));
        return ResponseEntity.status(HttpStatus.CREATED).body(movimentacaoSalva);
    }
}
