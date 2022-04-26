package br.edu.gama.gamaster.service;

import br.edu.gama.gamaster.exceptionhandler.ContaSemSaldoException;
import br.edu.gama.gamaster.model.Conta;
import br.edu.gama.gamaster.model.ContaCorrente;
import br.edu.gama.gamaster.model.ContaEspecial;
import br.edu.gama.gamaster.repository.ContaRepository;
import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith({MockitoExtension.class})
class ContaServiceTest {

    @Mock
    private ContaRepository contaRepository;

    @InjectMocks
    private ContaService contaService;

    @Test
    void buscarTodasContas() {

        when(contaRepository.findAll()).thenReturn(new ArrayList<Conta>());

        List<Conta> contaList = contaService.buscarTodasContas();

        assertThat(contaList, notNullValue());
        assertThat(contaList, Matchers.isA(ArrayList.class));
        assertThat(contaList, hasSize(0));

    }

    @Test
    void atualizarSaldo_transferenciaEntreDuasContasCorrente() {
        Conta contaOrigem = new ContaCorrente();
        contaOrigem.setSaldo(BigDecimal.valueOf(100L));
        Conta contaDestino = new ContaCorrente();
        contaDestino.setSaldo(BigDecimal.valueOf(50L));

        BigDecimal valorParaTransferir = BigDecimal.valueOf(40L);

        when(contaRepository.saveAndFlush(contaOrigem)).thenReturn(contaOrigem);
        when(contaRepository.saveAndFlush(contaDestino)).thenReturn(contaDestino);

        contaService.atualizarSaldo(contaOrigem, contaDestino, valorParaTransferir);

        assertThat(contaOrigem.getSaldo(), equalTo(BigDecimal.valueOf(60L)));
        assertThat(contaDestino.getSaldo(), equalTo(BigDecimal.valueOf(90L)));
        assertThat(contaDestino.getSaldo(), greaterThan(contaOrigem.getSaldo()));
    }

    @Test
    void atualizarSaldo_transferenciaEntreContaCorrenteEContaEspecial() {
        ContaEspecial contaOrigem = new ContaEspecial();
        contaOrigem.setSaldo(BigDecimal.valueOf(100L));
        contaOrigem.setLimiteDeCreditoPreAprovado(BigDecimal.valueOf(300L));
        Conta contaDestino = new ContaCorrente();
        contaDestino.setSaldo(BigDecimal.valueOf(50L));

        BigDecimal valorParaTransferir = BigDecimal.valueOf(200L);

        when(contaRepository.saveAndFlush(contaOrigem)).thenReturn(contaOrigem);
        when(contaRepository.saveAndFlush(contaDestino)).thenReturn(contaDestino);

        contaService.atualizarSaldo(contaOrigem, contaDestino, valorParaTransferir);

        assertThat(contaOrigem.getSaldo(), equalTo(BigDecimal.valueOf(-100L)));
        assertThat(contaDestino.getSaldo(), equalTo(BigDecimal.valueOf(250L)));
        assertThat(contaDestino.getSaldo(), greaterThan(contaOrigem.getSaldo()));
    }

    @Test()
    void atualizarSaldo_contaSemSaldo() {
        Conta contaOrigem = new ContaCorrente();
        contaOrigem.setSaldo(BigDecimal.valueOf(100L));
        Conta contaDestino = null;

        BigDecimal valorParaSacar = BigDecimal.valueOf(200L);

        ContaSemSaldoException contaSemSaldoException =
                assertThrows(ContaSemSaldoException.class,
                        () -> contaService.atualizarSaldo(contaOrigem, contaDestino, valorParaSacar));
    }
}