package com.example.Desafio_Itau_Backend.Controller;

import com.example.Desafio_Itau_Backend.DTOs.TransacaoDTO;
import com.example.Desafio_Itau_Backend.Service.ServiceTransacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/transacao")
public class Controller {

    @Autowired
    private ServiceTransacao service;

    @PostMapping
    public ResponseEntity<TransacaoDTO> ReceberTransacao(@RequestBody TransacaoDTO transacao){
        service.processarTransacao(transacao);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @DeleteMapping
    public ResponseEntity<Void> deletarTransacoes(){
        service.deletarTransacoes();
        return ResponseEntity.ok().build();
    }
}
