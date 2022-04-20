package br.edu.gama.gamaster.model;

import br.edu.gama.gamaster.controller.ContaController;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "tb_movimentacao")
public class Movimentacao implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private TipoMovimentacao tipoMovimentacao;

    @CreationTimestamp
    private LocalDateTime dataMovimentacao;
    private BigDecimal valor;

    @ManyToOne(targetEntity = Conta.class)
    private Long contaOrigem;

    @ManyToOne(targetEntity = Conta.class)
    @JoinColumn(name = "conta_destino_id")
    private Long contaDestinoId;

}
