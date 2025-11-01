package com.example.Desafio_Itau_Backend.Controller;

import com.example.Desafio_Itau_Backend.Service.ServiceTransacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
@RequestMapping("/estatistica")
public class ControllerEstatisticas {

    @Autowired
    private ServiceTransacao serviceTransacao;

    @GetMapping
    public ResponseEntity<Map<String, Double>> estatisticas(){
        return ResponseEntity.ok(serviceTransacao.estatisicaTransacao());
    }
}
