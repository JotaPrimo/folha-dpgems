package org.example.folhadpgems;


import org.example.folhadpgems.formulas.BaseFormula;
import org.example.folhadpgems.formulas.DiasTrabalhadosAjustados;
import org.example.folhadpgems.formulas.ValorDiario;
import org.example.folhadpgems.formulas.ValorTotalAcervo;
import org.example.folhadpgems.interfaces.IBaseFormulaEngine;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Objects;

public class ServiceCalculo {

    private IBaseFormulaEngine baseFormulaEngine;

    public ServiceCalculo() { }

    public IBaseFormulaEngine getBaseFormulaEngine() {
        return baseFormulaEngine;
    }

    public void setBaseFormulaEngine(IBaseFormulaEngine baseFormulaEngine) {
        this.baseFormulaEngine = baseFormulaEngine;
    }

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

        BaseFormula diasTrabalhados = new DiasTrabalhadosAjustados();
        diasTrabalhados.setDescricao("Dias trabalhados ajustados");
        diasTrabalhados.setNome("Dias trabalhados ajustados");
        diasTrabalhados.setExpressao(" ((DIAS_TRABALHADOS - DIAS_AFASTADOS) / DIAS_TOTAIS_DO_MES) * 30 ");

        HashMap<String, Object> paramsDiasTrabalhados = new HashMap<>();
        paramsDiasTrabalhados.put("DIAS_TRABALHADOS", new BigDecimal(28));
        paramsDiasTrabalhados.put("DIAS_AFASTADOS", new BigDecimal(19));
        paramsDiasTrabalhados.put("DIAS_TOTAIS_DO_MES", new BigDecimal(28));


        Object resultadoDiasTrabalhadosAjustados = baseFormulaEngine.evaluate(diasTrabalhados, paramsDiasTrabalhados);
        System.out.println("=================================== RESULTADOS ===================================");
        System.out.println("DIAS TRABALHADOS AJUSTADOS = " + resultadoDiasTrabalhadosAjustados);
        return new BigDecimal(String.valueOf(resultadoDiasTrabalhadosAjustados));
    }

    public BigDecimal valorDiario() {
        ValorDiario valorDiario = new ValorDiario();
        valorDiario.setNome("Valor diario");
        valorDiario.setDescricao("Valor diario");
        valorDiario.setExpressao("(SALARIO_BASE * PERCENTUAL_ACERVO) / 30");

        HashMap<String, Object> mapValorDiario = new HashMap<>();
        mapValorDiario.put("SALARIO_BASE", new BigDecimal(6350));
        mapValorDiario.put("PERCENTUAL_ACERVO", new BigDecimal("0.1"));

        Object resultadoValorDiario = baseFormulaEngine.evaluate(valorDiario, mapValorDiario);
        System.out.println("VALOR DIARIO = " + resultadoValorDiario);
        return new BigDecimal(String.valueOf(resultadoValorDiario));
    }

    public BigDecimal valorTotalAcervo(BigDecimal diasTrabalhados,BigDecimal valorDiario) {

        Objects.requireNonNull(diasTrabalhados, "Valor de dias trabalhados NULL");
        Objects.requireNonNull(valorDiario, "Valor diário não pode ser null");

        ValorTotalAcervo valorTotalAcervo = new ValorTotalAcervo();
        valorTotalAcervo.setNome("Valor Total Acervo");
        valorTotalAcervo.setDescricao("DIAS TRABALHADOS AJUSTADOS");
        valorTotalAcervo.setExpressao(" DIAS_TRABALHADOS_AJUSTADOS * VALOR_DIARIO ");

        HashMap<String, Object> mapValorTotalAcervo = new HashMap<>();
        mapValorTotalAcervo.put("DIAS_TRABALHADOS_AJUSTADOS", diasTrabalhados);
        mapValorTotalAcervo.put("VALOR_DIARIO", valorDiario);

        Object resultadoValorTotalAcervo = baseFormulaEngine.evaluate(valorTotalAcervo, mapValorTotalAcervo);
        System.out.println("VALOR TOTAL ACERVO = " + resultadoValorTotalAcervo);
        System.out.println("=================================== RESULTADOS ===================================");
        return new BigDecimal(String.valueOf(resultadoValorTotalAcervo));
    }
}