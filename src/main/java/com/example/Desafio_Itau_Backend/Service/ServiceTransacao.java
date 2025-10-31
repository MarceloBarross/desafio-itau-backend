package com.example.Desafio_Itau_Backend.Service;

import com.example.Desafio_Itau_Backend.DTOs.TransacaoDTO;
import com.example.Desafio_Itau_Backend.Exceptions.TransacaoNaoAceita;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ServiceTransacao {

    private static int id = 0;
    private static Map<Integer,TransacaoDTO> mapTransacoes = new HashMap<Integer, TransacaoDTO>();



    public TransacaoDTO processarTransacao(TransacaoDTO transacao){

        if (transacao.dataHora() == null || transacao.valor() == null){
            throw new TransacaoNaoAceita("Preencha todos os campos");
        }
        if (transacao.dataHora().isAfter(OffsetDateTime.now())){
            throw new TransacaoNaoAceita("A transacao nao pode acontecer no futuro");
        }
        if (transacao.valor() < 0){
            throw new TransacaoNaoAceita("A transacao deve ser maior ou igual a 0");
        }

        mapTransacoes.put(++id, transacao);
        return transacao;
    }

}
