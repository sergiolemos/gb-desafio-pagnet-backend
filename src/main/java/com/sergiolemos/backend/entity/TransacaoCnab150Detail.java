package com.sergiolemos.backend.entity;

import java.math.BigDecimal;

public record TransacaoCnab150Detail(
        String codigoRegistro,
        String agenciaContaDigito,
        String dataPagamento,
        String dataCredito,
        String codigoDeBarras,
        BigDecimal valorRecebido,
        BigDecimal valorDaTarifa,
        Long numeroSequencial,
        String codigoAgenciaArrecadadora,
        String formaArrecadacao,
        String numeroAutenticacao,
        Long formaDePagamento,
        String reservaFuturo

) {
}
