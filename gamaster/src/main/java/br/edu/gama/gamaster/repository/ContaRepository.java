package br.edu.gama.gamaster.repository;

import br.edu.gama.gamaster.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<Conta, Long> {
}
