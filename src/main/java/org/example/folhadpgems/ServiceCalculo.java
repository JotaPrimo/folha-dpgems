package org.example.folhadpgems;


import org.example.folhadpgems.formulas.BaseFormula;
import org.example.folhadpgems.formulas.DiasTrabalhadosAjustados;
import org.example.folhadpgems.formulas.ValorDiario;
import org.example.folhadpgems.formulas.ValorTotalAcervo;
import org.example.folhadpgems.implementations.DiasTrabalhadosAjustadosEngine;
import org.example.folhadpgems.implementations.ValorDiarioEngine;
import org.example.folhadpgems.interfaces.IBaseFormulaEngine;

import java.math.BigDecimal;
import java.util.HashMap;

public class ServiceCalculo {

    private IBaseFormulaEngine baseFormulaEngine;

    public ServiceCalculo() { }

    public void calcular() {
        BaseFormula baseFormula = new BaseFormula();
        baseFormula.setDescricao("Calculo de salario");
        baseFormula.setExpressao(" (SALARIO_BASE / 30) * DIAS_TRABALHADOS ");
        baseFormula.setNome("Calcular salario");

        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("SALARIO_BASE", new BigDecimal(6350));
        hashMap.put("DIAS_TRABALHADOS", new BigDecimal(28));

        Object resultado = baseFormulaEngine.evaluate(baseFormula, hashMap);
        System.out.println("Resultado do calculo: " + resultado);
    }

    public BigDecimal diasTrabalhados() {

        // Dias trabalhados ajustados
        BaseFormula baseFormulaDiasTrabalhadosAjustados = new DiasTrabalhadosAjustados();
        baseFormulaDiasTrabalhadosAjustados.setDescricao("Dias trabalhados ajustados");
        baseFormulaDiasTrabalhadosAjustados.setNome("Dias trabalhados ajustados");
        baseFormulaDiasTrabalhadosAjustados.setExpressao(" ((DIAS_TRABALHADOS - DIAS_AFASTADOS) / DIAS_TOTAIS_DO_MES) * 30 ");

        HashMap<String, Object> hashMapDiasTrabalhadosAjustados = new HashMap<>();
        hashMapDiasTrabalhadosAjustados.put("DIAS_TRABALHADOS", new BigDecimal(28));
        hashMapDiasTrabalhadosAjustados.put("DIAS_AFASTADOS", new BigDecimal(19));
        hashMapDiasTrabalhadosAjustados.put("DIAS_TOTAIS_DO_MES", new BigDecimal(28));


        Object resultadoDiasTrabalhadosAjustados = baseFormulaEngine.evaluate(baseFormulaDiasTrabalhadosAjustados, hashMapDiasTrabalhadosAjustados);
        System.out.println("===================== RESULTADOS =====================");
        System.out.println("DIAS TRABALHADOS AJUSTADOS = " + resultadoDiasTrabalhadosAjustados);
        return new BigDecimal(String.valueOf(resultadoDiasTrabalhadosAjustados));
    }

    public BigDecimal valorDiario() {
        // VALOR DIARIO
        ValorDiario formulaValorDiario = new ValorDiario();
        formulaValorDiario.setNome("Valor diario");
        formulaValorDiario.setDescricao("Valor diario");
        formulaValorDiario.setExpressao("(SALARIO_BASE * PERCENTUAL_ACERVO) / 30");

        HashMap<String, Object> hashMapformulaValorDiario = new HashMap<>();
        hashMapformulaValorDiario.put("SALARIO_BASE", new BigDecimal(6350));
        hashMapformulaValorDiario.put("PERCENTUAL_ACERVO", new BigDecimal(0.1));

        Object resultadoValorDiario = baseFormulaEngine.evaluate(formulaValorDiario, hashMapformulaValorDiario);
        System.out.println("VALOR DIARIO = " + resultadoValorDiario);
        return new BigDecimal(String.valueOf(resultadoValorDiario));
    }


    public BigDecimal valorTotalAcervo(BigDecimal diasTrabalhados,BigDecimal valorDiario) {

        ValorTotalAcervo formulaValorTotalAcerto = new ValorTotalAcervo();
        formulaValorTotalAcerto.setNome("formulaValorTotalAcerto");
        formulaValorTotalAcerto.setDescricao("DIAS TRABALHADOS AJUSTADOS");
        formulaValorTotalAcerto.setExpressao(" DIAS_TRABALHADOS_AJUSTADOS * VALOR_DIARIO ");

        HashMap<String, Object> hasMapValorTotalAcervo = new HashMap<>();
        hasMapValorTotalAcervo.put("DIAS_TRABALHADOS_AJUSTADOS", diasTrabalhados);
        hasMapValorTotalAcervo.put("VALOR_DIARIO", valorDiario);

        Object resultadoValorTotalAcervo = baseFormulaEngine.evaluate(formulaValorTotalAcerto, hasMapValorTotalAcervo);
        System.out.println("VALOR TOTAL ACERVO = " + resultadoValorTotalAcervo);
        System.out.println("===================== RESULTADOS =====================");
        return new BigDecimal(String.valueOf(resultadoValorTotalAcervo));
    }


    public IBaseFormulaEngine getBaseFormulaEngine() {
        return baseFormulaEngine;
    }

    public void setBaseFormulaEngine(IBaseFormulaEngine baseFormulaEngine) {
        this.baseFormulaEngine = baseFormulaEngine;
    }
}

