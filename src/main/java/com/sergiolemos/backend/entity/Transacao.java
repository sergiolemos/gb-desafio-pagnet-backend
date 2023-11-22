package com.sergiolemos.backend.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public record Transacao(
        @Id Long id,
        Integer tipo,
        Date data,
        BigDecimal valor,
        Long cpf,
        String cartao,
        Time hora,
        @Column("dono_loja") String donoDaLoja,
        @Column("nome_loja") String nomeDaLoja) {

    public Transacao withValor(BigDecimal valor) {
        return new Transacao(
                id,
                tipo,
                data,
                valor,
                cpf,
                cartao,
                hora,
                donoDaLoja,
                nomeDaLoja);
    }

    public Transacao wihtData(String data) throws ParseException {
        var dateFormat = new SimpleDateFormat("yyyyMMdd");
        var date = dateFormat.parse(data);

        return new Transacao(
                id,
                tipo,
                new Date(date.getTime()),
                valor,
                cpf,
                cartao,
                hora,
                donoDaLoja,
                nomeDaLoja
        );
    }

    public Transacao wihtHora(String hora) throws ParseException {
        var dateFormat = new SimpleDateFormat("HHmmss");
        var date = dateFormat.parse(hora);

        return new Transacao(
                id,
                tipo,
                data,
                valor,
                cpf,
                cartao,
                new Time(date.getTime()),
                donoDaLoja,
                nomeDaLoja
        );
    }
}
