package br.edu.gama.gamaster.model;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
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
    @Column(name = "codigo")
    private Long codigo;
    @NotNull
    @Enumerated
    @Column(name = "tipo_movimentacao")
    private TipoMovimentacao tipoMovimentacao;

    @CreationTimestamp
    @NotNull
    @Column(name="data_movimentacao")
    private LocalDateTime dataMovimentacao;

    @NotNull
    @Positive
    @Column(name = "valor")
    private BigDecimal valor;

    @ManyToOne
    @JoinColumn(name = "cod_conta_origem")
    @JsonIdentityReference(alwaysAsId = true)
    private Conta contaOrigem;

    @ManyToOne
    @JoinColumn(name = "cod_conta_destino")
    @JsonIdentityReference(alwaysAsId = true)
    private Conta contaDestino;

}
