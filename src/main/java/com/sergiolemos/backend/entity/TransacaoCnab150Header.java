package com.sergiolemos.backend.entity;

public record TransacaoCnab150Header(
        String codigoRegistro,
        Integer codigoRemessa,
        String contaConvenio,
        String nomeEmpresa,
        Integer codigoBanco,
        String nomeBanco,
        String dataGeracaoArquivo,
        Integer numeroSequencialArquivo,
        Integer versaoLayout,
        String codigoDeBarras,
        String reservaFuturo
) {


}
