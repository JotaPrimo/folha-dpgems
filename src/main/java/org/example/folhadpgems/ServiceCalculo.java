package org.example.folhadpgems;

import org.example.folhadpgems.formulas.BaseFormula;
import org.example.folhadpgems.formulas.DiasTrabalhadosAjustados;
import org.example.folhadpgems.formulas.ValorDiario;
import org.example.folhadpgems.formulas.ValorTotalAcervo;
import org.example.folhadpgems.implementations.BaseFormulaEngine;
import org.example.folhadpgems.interfaces.IBaseFormulaEngine;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;


@Service
public class ServiceCalculo {

    private IBaseFormulaEngine baseFormulaEngine;

    public ServiceCalculo() {
        baseFormulaEngine = new BaseFormulaEngine();
    }

    public BigDecimal diasTrabalhados(HashMap<String, BigDecimal> paramsDiasTrabalhados) {
        BaseFormula diasTrabalhados = new DiasTrabalhadosAjustados();
        diasTrabalhados.setDescricao("Dias trabalhados ajustados");
        diasTrabalhados.setNome("Dias trabalhados ajustados");
        diasTrabalhados.setExpressao(" ((DIAS_TOTAIS_DO_MES - DIAS_AFASTADOS) / DIAS_TOTAIS_DO_MES) * 30 ");

        Map<String, BigDecimal> paramsDiasTrabalhadosBig = getStringBigDecimalMap(paramsDiasTrabalhados);

        Object resultadoDiasTrabalhadosAjustados = baseFormulaEngine.evaluate(diasTrabalhados, paramsDiasTrabalhadosBig);
        return new BigDecimal(String.valueOf(resultadoDiasTrabalhadosAjustados));
    }

    public BigDecimal valorDiario(HashMap<String, BigDecimal> paramsDiasTrabalhados) {
        ValorDiario valorDiario = new ValorDiario();
        valorDiario.setNome("Valor diário");
        valorDiario.setDescricao("Valor diário");
        valorDiario.setExpressao("(SALARIO_BASE * PERCENTUAL_ACERVO) / 30");

        Map<String, BigDecimal> paramsDiasTrabalhadosBig = getStringBigDecimalMap(paramsDiasTrabalhados);

        Object resultadoValorDiario = baseFormulaEngine.evaluate(valorDiario, paramsDiasTrabalhadosBig);
        return new BigDecimal(String.valueOf(resultadoValorDiario));
    }

    public BigDecimal valorTotalAcervo(BigDecimal diasTrabalhados,BigDecimal valorDiario) {
        Objects.requireNonNull(diasTrabalhados, "Valor de dias trabalhados NULL");
        Objects.requireNonNull(valorDiario, "Valor diário NULL");

        ValorTotalAcervo valorTotalAcervo = new ValorTotalAcervo();
        valorTotalAcervo.setNome("Valor Total Acervo");
        valorTotalAcervo.setDescricao("DIAS TRABALHADOS AJUSTADOS");
        valorTotalAcervo.setExpressao(" DIAS_TRABALHADOS_AJUSTADOS * VALOR_DIARIO ");

        HashMap<String, BigDecimal> mapValorTotalAcervo = new HashMap<>();
        mapValorTotalAcervo.put("DIAS_TRABALHADOS_AJUSTADOS", diasTrabalhados);
        mapValorTotalAcervo.put("VALOR_DIARIO", valorDiario);

        Object resultadoValorTotalAcervo = baseFormulaEngine.evaluate(valorTotalAcervo, mapValorTotalAcervo);
        return new BigDecimal(String.valueOf(resultadoValorTotalAcervo));
    }

    private static Map<String, BigDecimal> getStringBigDecimalMap(HashMap<String, BigDecimal> paramsDiasTrabalhados) {
        return paramsDiasTrabalhados.entrySet()
                .stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        e -> new BigDecimal(String.valueOf(e.getValue()))
                ));
    }
}