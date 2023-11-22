package com.sergiolemos.backend.entity;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(of = "id")
public class Transacao150Trailer {

    private Long id;
    private Integer totalRegistrosArquivo;
    private BigDecimal valorTotalArquivo;
    private String filler;
    private LocalDateTime createdAt;
}
