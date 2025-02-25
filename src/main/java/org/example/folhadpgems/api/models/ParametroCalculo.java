package org.example.folhadpgems.api.models;

import java.math.RoundingMode;
import java.util.Map;

public class ParametroCalculo {
    private String nome;
    private Map<String, Object> variaveis;
    private String formula;
    private int scale;
    private String roundingMode;

    // Construtores, getters e setters
    public ParametroCalculo() {
    }

    public ParametroCalculo(String nome, Map<String, Object> variaveis, String formula, int scale, String roundingMode) {
        this.nome = nome;
        this.variaveis = variaveis;
        this.formula = formula;
        this.scale = scale;
        this.roundingMode = roundingMode;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Map<String, Object> getVariaveis() {
        return variaveis;
    }

    public void setVariaveis(Map<String, Object> variaveis) {
        this.variaveis = variaveis;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public int getScale() {
        return scale;
    }

    public void setScale(int scale) {
        this.scale = scale;
    }

    public String getRoundingMode() {
        return roundingMode;
    }

    public void setRoundingMode(String roundingMode) {
        this.roundingMode = roundingMode;
    }

    public RoundingMode getRoundingModeEnum() {
        return RoundingMode.valueOf(roundingMode.toUpperCase());
    }
}