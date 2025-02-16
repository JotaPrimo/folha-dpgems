package org.example.folhadpgems.interfaces;

import org.example.folhadpgems.formulas.BaseFormula;

import java.util.Map;

public interface IBaseFormulaEngine {
    /**
     * Avalia a expresso de uma dada frmula, com base em variveis passadas.
     *
     * @param baseFormula A entidade de domnio contendo a expresso
     * @param variables Variveis (nome -> valor) necessrias para o clculo
     * @return O resultado do clculo. Pode ser Double, BigDecimal, etc.
     */
    Object evaluate(BaseFormula baseFormula, Map<String, Object> variables);
}
