package br.edu.gama.gamaster.model.dto;

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


    public Movimentacao toModel(){
        Movimentacao movimentacao = new Movimentacao();
        BeanUtils.copyProperties(this, movimentacao, "id");
        movimentacao.setDataMovimentacao(LocalDateTime.now());
        return movimentacao;
    }
}
