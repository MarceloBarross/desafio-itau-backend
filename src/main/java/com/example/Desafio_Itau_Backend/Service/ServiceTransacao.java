package com.example.Desafio_Itau_Backend.Service;

import com.example.Desafio_Itau_Backend.DTOs.TransacaoDTO;
import com.example.Desafio_Itau_Backend.Exceptions.TransacaoNaoAceita;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.*;

@Service
public class ServiceTransacao {

    private static List<TransacaoDTO> listTransacoes = new ArrayList<TransacaoDTO>();



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

        listTransacoes.add(transacao);
        return transacao;
    }


    public void deletarTransacoes(){
        listTransacoes.clear();
    }

    public Map<String,Double> estatisicaTransacao(){
        Map<String,Double> mapEstatisticas= new HashMap<String,Double>();
        int cont = 0;
        Double avg = 0.0;
        Double sum = 0.0;
        Double min = null;
        Double max = null;

        for(TransacaoDTO transacao: listTransacoes){
            if (transacao.dataHora().isAfter(OffsetDateTime.now().minusMinutes(1))){
                sum+= transacao.valor();
                cont++;
                if (min == null){
                    min = transacao.valor();
                } else if (transacao.valor() < min){
                    min = transacao.valor();
                }

                if (max == null){
                    max = transacao.valor();
                } else if (transacao.valor() > max){
                    max = transacao.valor();
                }
            }
        }

        if(cont == 0){
            avg = 0.0;
        }else{
            avg = sum/cont;
        }

        mapEstatisticas.put("count",(double) cont);
        mapEstatisticas.put("sum",sum);
        mapEstatisticas.put("avg",avg);
        mapEstatisticas.put("min", min);
        mapEstatisticas.put("max", max);

        return mapEstatisticas;
    }

}
