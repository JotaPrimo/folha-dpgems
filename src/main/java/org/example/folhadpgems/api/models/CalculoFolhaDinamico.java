package org.example.folhadpgems.api.models;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@FunctionalInterface
public interface CalculoFolhaDinamico {
    Map<String, BigDecimal> calcularTodos(List<ParametroCalculo> parametros);
}

