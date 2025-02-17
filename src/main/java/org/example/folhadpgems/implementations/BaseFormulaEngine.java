package org.example.folhadpgems.implementations;

import org.example.folhadpgems.formulas.BaseFormula;
import org.example.folhadpgems.interfaces.IBaseFormulaEngine;
import org.mvel2.MVEL;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Objects;

@Component
public class BaseFormulaEngine implements IBaseFormulaEngine {

    @Override
    public Object evaluate(BaseFormula baseFormula, Map<String, Object> variables) {

        Objects.requireNonNull(baseFormula, "Form�la n�o definida para c�lculo");
        Objects.requireNonNull(variables, "Par�metros de c�lculo n�o definidos");

        Object resultado = MVEL.eval(baseFormula.getExpressao(), variables);

        if (resultado instanceof Number) {
            return new BigDecimal(resultado.toString()).setScale(baseFormula.getScale(), baseFormula.getRoundingMode());
        }
        return resultado;
    }
}