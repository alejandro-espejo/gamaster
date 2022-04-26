package br.edu.gama.gamaster.service;

import br.edu.gama.gamaster.model.Conta;
import br.edu.gama.gamaster.model.ContaCorrente;
import br.edu.gama.gamaster.repository.ContaRepository;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@ExtendWith({MockitoExtension.class})
class ContaServiceTest {

    @Mock
    private ContaRepository contaRepository;

    @InjectMocks
    private ContaService contaService;

    @Test
    void buscarTodasContas() {

        Mockito.when(contaRepository.findAll()).thenReturn(new ArrayList<Conta>());

        List<Conta> contaList = contaService.buscarTodasContas();

        MatcherAssert.assertThat(contaList, Matchers.notNullValue());
        MatcherAssert.assertThat(contaList, Matchers.isA(ArrayList.class));
        MatcherAssert.assertThat(contaList, Matchers.hasSize(0));

    }

    @Test
    void atualizarSaldo_duasContasCorrente() {
        Conta contaOrigem = new ContaCorrente();
        contaOrigem.setSaldo(BigDecimal.valueOf(100L));
        Conta contaDestino = new ContaCorrente();
        contaDestino.setSaldo(BigDecimal.valueOf(50L));

        BigDecimal valorParaTransferir = BigDecimal.valueOf(40L);

        Mockito.when(contaRepository.saveAndFlush(contaOrigem)).thenReturn(contaOrigem);
        Mockito.when(contaRepository.saveAndFlush(contaDestino)).thenReturn(contaDestino);

        contaService.atualizarSaldo(contaOrigem, contaDestino, valorParaTransferir);

        MatcherAssert.assertThat(contaOrigem.getSaldo(), Matchers.equalTo(BigDecimal.valueOf(60L)));
        MatcherAssert.assertThat(contaDestino.getSaldo(), Matchers.equalTo(BigDecimal.valueOf(90L)));
        MatcherAssert.assertThat(contaDestino.getSaldo(), Matchers.greaterThan(contaOrigem.getSaldo()));

    }
}