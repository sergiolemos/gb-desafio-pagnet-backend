package com.sergiolemos.backend.entity;

import java.math.BigDecimal;
import java.util.Arrays;

public enum TipoTransacao {

    DEBITO(1),
    BOLETO(2),
    FINANCIAMENTO(3),
    CREDITO(4),
    RECEBIMENTO_EMPRESTIMO(5),
    VENDAS(6),
    RECEBIMENTO_TED(7),
    RECEBIMENTO_DOC(8),
    ALUGUEL(9);

    private int tipo;

    TipoTransacao(int tipo) {
        this.tipo = tipo;
    }

    public int getTipo() {
        return tipo;
    }

    public BigDecimal getSinal(){
        return switch (tipo){
            case 1,4,5,6,7,8 -> new BigDecimal(1);
            case 2,3,9 -> new BigDecimal(-1);
            default ->  BigDecimal.ZERO;
        };
    }

    public static TipoTransacao findByTipo(int tipo){
        return Arrays.stream(TipoTransacao.values())
                .filter(t -> t.getTipo() == tipo)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Invalid tipo: "+ tipo));

    }


}
