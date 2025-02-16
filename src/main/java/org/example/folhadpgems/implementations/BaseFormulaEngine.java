package org.example.folhadpgems.implementations;

import org.example.folhadpgems.formulas.BaseFormula;
import org.example.folhadpgems.interfaces.IBaseFormulaEngine;
import org.mvel2.MVEL;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

@Component
public class BaseFormulaEngine implements IBaseFormulaEngine {

    @Override
    public Object evaluate(BaseFormula baseFormula, Map<String, Object> variables) {

        Object resultado = MVEL.eval(baseFormula.getExpressao(), variables);

        if (resultado instanceof Number) {
            return new BigDecimal(resultado.toString()).setScale(2, RoundingMode.HALF_UP);
        }
        return resultado;
    }
}