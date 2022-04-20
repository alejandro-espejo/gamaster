package br.edu.gama.gamaster.repository;

import br.edu.gama.gamaster.model.Conta;

import javax.transaction.Transactional;

@Transactional
public interface ContaRepository extends ContaBaseRepository<Conta> {
}
