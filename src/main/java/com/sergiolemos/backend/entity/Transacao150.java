package com.sergiolemos.backend.entity;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public record Transacao150(
    Long id,
    Integer tipo,
    Date data,
    BigDecimal valor,
    Long cpf,
    String cartao,
    Time hora,
    String donoDaLoja,
    String nomeDaLoja) {

    public Transacao150 withValor(BigDecimal valor){
        return new Transacao150(
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

    public Transacao150 wihtData(String data) throws ParseException {
        var dateFormat = new SimpleDateFormat("yyyyMMdd");
        var date = dateFormat.parse(data);

        return new Transacao150(
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

    public Transacao150 wihtHora(String hora) throws ParseException {
        var dateFormat = new SimpleDateFormat("HHmmss");
        var date = dateFormat.parse(hora);

        return new Transacao150(
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
