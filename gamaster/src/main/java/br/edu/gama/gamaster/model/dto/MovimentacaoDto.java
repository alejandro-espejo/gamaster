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

    private BigDecimal valor;
    private Long codigoContaOrigem;
    private Long codigoContaDestino;


    public Movimentacao toModel(ContaService contaService){
        Movimentacao movimentacao = new Movimentacao();
        movimentacao.setValor(this.valor);
        movimentacao.setDataMovimentacao(LocalDateTime.now());

        Conta contaOrigem = this.codigoContaOrigem != null ?
                contaService.buscarPorCodigo(this.codigoContaOrigem) : null;
        Conta contaDestino = this.codigoContaDestino != null ?
                contaService.buscarPorCodigo(this.codigoContaDestino) : null;

        movimentacao.setContaOrigem(contaOrigem);
        movimentacao.setContaDestino(contaDestino);

        if(contaOrigem == null){
            movimentacao.setTipoMovimentacao(TipoMovimentacao.ENTRADA);
        } else if (contaDestino == null) {
            movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
        }else{
            movimentacao.setTipoMovimentacao(TipoMovimentacao.TRANSFERENCIA);
        }

        return movimentacao;
    }
}
