package org.example.folhadpgems.interfaces;

import org.example.folhadpgems.formulas.BaseFormula;

import java.util.Map;

public interface IBaseFormulaEngine {
    /**
     * Avalia a expresso de uma dada fórmula, com base em variáveis passadas.
     *
     * @param baseFormula A entidade de domínio contendo a expressão
     * @param variables Variáveis (nome -> valor) necessárias para o cálculo
     * @return O resultado do cálculo. Pode ser deve BigDecimal.
     */
    Object evaluate(BaseFormula baseFormula, Map<String, Object> variables);
}