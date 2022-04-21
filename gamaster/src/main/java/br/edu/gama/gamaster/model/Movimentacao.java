package br.edu.gama.gamaster.model;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_movimentacao")
@Getter
@Setter
@ToString
public class Movimentacao implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private TipoMovimentacao tipoMovimentacao;

    @CreationTimestamp
    private LocalDateTime dataMovimentacao;

    private BigDecimal valor;

    @ManyToOne
    @JoinColumn(name = "conta_origem_id")
    @JsonIdentityReference(alwaysAsId = true)
    private Conta contaOrigem;

    @ManyToOne
    @JoinColumn(name = "conta_destino_id")
    @JsonIdentityReference(alwaysAsId = true)
    private Conta contaDestino;

}
