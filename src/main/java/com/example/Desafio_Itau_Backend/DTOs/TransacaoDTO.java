package com.example.Desafio_Itau_Backend.DTOs;


import java.time.OffsetDateTime;

public record TransacaoDTO(
        Double valor,
        OffsetDateTime dataHora
) {}
