package br.edu.gama.gamaster.model.dto;

import br.edu.gama.gamaster.model.Conta;
import br.edu.gama.gamaster.model.Movimentacao;
import br.edu.gama.gamaster.model.TipoMovimentacao;
import br.edu.gama.gamaster.service.ContaService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovimentacaoDto {

    private TipoMovimentacao tipoMovimentacao;
    private BigDecimal valor;
    private Long codigoContaOrigem;
    private Long codigoContaDestino;


    public Movimentacao toModel(ContaService contaService){
        Movimentacao movimentacao = new Movimentacao();
        BeanUtils.copyProperties(this, movimentacao, "id");
        movimentacao.setDataMovimentacao(LocalDateTime.now());
        Conta contaOrigem = this.getCodigoContaOrigem() != null ?
                contaService.buscarPorCodigo(this.getCodigoContaOrigem()) : null;
        Conta contaDestino = this.getCodigoContaDestino() != null ?
                contaService.buscarPorCodigo(this.getCodigoContaDestino()) : null;
        movimentacao.setContaOrigem(contaOrigem);
        movimentacao.setContaDestino(contaDestino);
        return movimentacao;
    }
}
