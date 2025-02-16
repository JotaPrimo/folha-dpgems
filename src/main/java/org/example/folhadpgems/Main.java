package org.example.folhadpgems;

import org.example.folhadpgems.implementations.DiasTrabalhadosAjustadosEngine;
import org.example.folhadpgems.implementations.ValorDiarioEngine;
import org.example.folhadpgems.implementations.ValorTotalAcervoEngine;
import org.example.folhadpgems.interfaces.IBaseFormulaEngine;
import org.example.folhadpgems.implementations.BaseFormulaEngine;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {

        ServiceCalculo serviceCalculo = new ServiceCalculo();

        serviceCalculo.setBaseFormulaEngine(new DiasTrabalhadosAjustadosEngine());
        BigDecimal diasTrabalhados = serviceCalculo.diasTrabalhados();


        serviceCalculo.setBaseFormulaEngine(new ValorDiarioEngine());
        BigDecimal valorDiario = serviceCalculo.valorDiario();

        serviceCalculo.setBaseFormulaEngine(new ValorTotalAcervoEngine());
        serviceCalculo.valorTotalAcervo(diasTrabalhados, valorDiario);
    }
}
