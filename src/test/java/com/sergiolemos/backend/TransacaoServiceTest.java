package com.sergiolemos.backend;

import com.sergiolemos.backend.entity.Transacao;
import com.sergiolemos.backend.repository.TransacaoRepository;
import com.sergiolemos.backend.service.TransacaoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TransacaoServiceTest {

    @InjectMocks
    private TransacaoService service;

    @Mock
    private TransacaoRepository repository;

    @Test
    public void testListTotaisTransacoesByNomeDaLoja() {

        // AAA
        final String lojaA = "Loja A", lojaB = "Loja B";

        var transacao1 = new Transacao(
                1L, 1, new Date(System.currentTimeMillis()),
                new BigDecimal(100), 12345678909L,
                "1234-0567-9012-3546",
                new Time(System.currentTimeMillis()),
                "Dono da Loja A", lojaA);
        var transacao2 = new Transacao(
                2L, 1, new Date(System.currentTimeMillis()),
                new BigDecimal(100), 83512012353L,
                "9520-0655-5852-8736",
                new Time(System.currentTimeMillis()),
                "Dono da Loja B", lojaB);
        var transacao3 = new Transacao(
                3L, 1, new Date(System.currentTimeMillis()),
                new BigDecimal(100), 64034666315L,
                "1654-8565-5231-2130",
                new Time(System.currentTimeMillis()),
                "Dono da Loja A", lojaA);

        var mockTransacoes = List.of(transacao1, transacao2, transacao3);

        when(repository.findAllByOrderByNomeDaLojaAscIdDesc())
                .thenReturn(mockTransacoes);

        var reports = service.listTotaisTransacaoPorNomeDaLoja();

        assertEquals(2, reports.size());

        reports.forEach(report -> {
            if (report.nomeDaLoja().equals(lojaA)) {
                assertEquals(2, report.transacoes().size());
                assertEquals(BigDecimal.valueOf(200), report.total());
                assertTrue(report.transacoes().contains(transacao1));
                assertTrue(report.transacoes().contains(transacao3));
            } else if (report.nomeDaLoja().equals(lojaB)) {
                assertEquals(1, report.transacoes().size());
                assertEquals(BigDecimal.valueOf(100), report.total());
                assertTrue(report.transacoes().contains(transacao2));
            }
        });

    }

}
