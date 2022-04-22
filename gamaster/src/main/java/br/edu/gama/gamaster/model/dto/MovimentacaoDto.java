package br.edu.gama.gamaster.model.dto;

import br.edu.gama.gamaster.exceptionhandler.ContasInformadasInvalidasException;
import br.edu.gama.gamaster.model.Conta;
import br.edu.gama.gamaster.model.Movimentacao;
import br.edu.gama.gamaster.model.TipoMovimentacao;
import br.edu.gama.gamaster.service.ContaService;
import io.swagger.v3.oas.annotations.media.Schema;
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

	@Schema(description = "Valor da movimentação", example = "500.00")
    private BigDecimal valor;
	
	@Schema(description = "Conta de origem da movimentação", example = "1")
    private Long codigoContaOrigem;
	
	@Schema(description = "Conta de destino da movimentação", example = "2")
    private Long codigoContaDestino;


    public Movimentacao toModel(ContaService contaService){
        Movimentacao movimentacao = new Movimentacao();
        movimentacao.setValor(this.valor);
        movimentacao.setDataMovimentacao(LocalDateTime.now());

        if (this.codigoContaOrigem == null && this.codigoContaDestino == null) {
            throw new ContasInformadasInvalidasException();
        }

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
