package br.edu.gama.gamaster.controller;

import br.edu.gama.gamaster.model.Conta;
import br.edu.gama.gamaster.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/contas")
public class ContaController {
  
    @Autowired
    private ContaRepository contaRepository;

    @GetMapping
    public List<Conta> buscarTodas(){
        return contaRepository.findAll();
    }
  
}
