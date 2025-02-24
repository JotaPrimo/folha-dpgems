package org.example.folhadpgems.api.controllers;

import org.example.folhadpgems.ServiceCalculo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/folha/calculo")
public class CalculoController {

    private final ServiceCalculo serviceCalculo;

    public CalculoController(ServiceCalculo serviceCalculo) {
        this.serviceCalculo = serviceCalculo;
    }

    @GetMapping("/acervo-processual")
    public ResponseEntity<?> acervoProcessual(@RequestParam @NonNull HashMap<String, BigDecimal> parametros) {
        BigDecimal diasTrabalhados = serviceCalculo.diasTrabalhados(parametros);
        BigDecimal valorDiario = serviceCalculo.valorDiario(parametros);

        String valorAcervo = serviceCalculo.valorTotalAcervo(diasTrabalhados, valorDiario).toString();

        Map<String, Object> response = new HashMap<>();
        response.put("response", valorAcervo);

        return ResponseEntity.status(HttpStatus.OK).body(response.toString());
    }
}