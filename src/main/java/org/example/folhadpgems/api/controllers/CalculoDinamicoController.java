package org.example.folhadpgems.api.controllers;

import org.example.folhadpgems.api.models.CalculoFolhaDinamico;
import org.example.folhadpgems.api.models.ParametroCalculo;
import org.mvel2.MVEL;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/folha/calculo/dinamico")
public class CalculoDinamicoController {

    @PostMapping("/executar")
    public Map<String, BigDecimal> calcular(@RequestBody List<ParametroCalculo> parametros) {
        // Implementação da interface funcional com MVEL
        CalculoFolhaDinamico calculoDinamico = (listaParametros) -> {
            Map<String, BigDecimal> resultados = new HashMap<>();

            for (ParametroCalculo parametro : listaParametros) {
                // Compila a expressão para melhor performance
                Serializable compilado = MVEL.compileExpression(parametro.getFormula());

                // Executa a expressão com as variáveis fornecidas
                Object resultado = MVEL.executeExpression(compilado, parametro.getVariaveis());

                // Converte para BigDecimal garantindo precisão
                BigDecimal valorCalculado = new BigDecimal(resultado.toString());

                // Aplica o setScale e adiciona ao mapa de resultados
                resultados.put(parametro.getNome(),
                        valorCalculado.setScale(parametro.getScale(), parametro.getRoundingModeEnum()));
            }
            return resultados;
        };

        // Calculando todos os resultados
        return calculoDinamico.calcularTodos(parametros);
    }
}
