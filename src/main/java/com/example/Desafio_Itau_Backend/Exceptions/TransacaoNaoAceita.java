package com.example.Desafio_Itau_Backend.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class TransacaoNaoAceita extends RuntimeException{
    public TransacaoNaoAceita(String message){
        super(message);
    }
}
