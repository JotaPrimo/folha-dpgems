package org.example.folhadpgems;

import org.example.folhadpgems.implementations.BaseFormulaEngine;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {

        BaseFormulaEngine baseFormulaEngine = new BaseFormulaEngine();
        ServiceCalculo serviceCalculo = new ServiceCalculo();

//        serviceCalculo.setBaseFormulaEngine(baseFormulaEngine);
//        serviceCalculo.calcular();

        serviceCalculo.setBaseFormulaEngine(baseFormulaEngine);
        BigDecimal diasTrabalhados = serviceCalculo.diasTrabalhados();


        serviceCalculo.setBaseFormulaEngine(baseFormulaEngine);
        BigDecimal valorDiario = serviceCalculo.valorDiario();

        serviceCalculo.setBaseFormulaEngine(baseFormulaEngine);
        serviceCalculo.valorTotalAcervo(diasTrabalhados, valorDiario);
    }
}