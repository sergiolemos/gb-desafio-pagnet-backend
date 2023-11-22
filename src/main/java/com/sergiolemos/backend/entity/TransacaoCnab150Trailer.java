package com.sergiolemos.backend.entity;

import java.math.BigDecimal;

public record TransacaoCnab150Trailer(
        Integer totalRegistrosArquivo,
        BigDecimal valorTotalArquivo,
        String filler
) {

}
