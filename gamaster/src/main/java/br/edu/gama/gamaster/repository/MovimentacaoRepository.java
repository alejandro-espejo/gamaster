package br.edu.gama.gamaster.repository;

import br.edu.gama.gamaster.model.Conta;
import br.edu.gama.gamaster.model.Movimentacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Long> {

//    @Query(nativeQuery = true, value = "select * from tb_movimentacao where conta_destino_id = ?1 or conta_origem_id = ?2")
    List<Movimentacao> findByContaOrigemOrContaDestino(Conta contaOrigem, Conta contaDestino);
    List<Movimentacao> findByContaOrigemAndContaDestino(Conta contaOrigem, Conta contaDestino);
}
