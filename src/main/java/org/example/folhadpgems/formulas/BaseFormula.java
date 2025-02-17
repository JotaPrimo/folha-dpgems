package org.example.folhadpgems.formulas;

import java.math.RoundingMode;
import java.util.Map;

public class BaseFormula {

    private String nome;
    private String expressao;
    private String descricao;
    private Map<String, String> parametrosDefault;
    private int scale;
    private RoundingMode roundingMode;

    public BaseFormula() {
    }

    protected BaseFormula(int scale, RoundingMode roundingMode) {
        this.scale = scale;
        this.roundingMode = roundingMode;
    }

    public BaseFormula(String nome, String expressao, String descricao, Map<String, String> parametrosDefault, int scale, RoundingMode roundingMode) {
        this.nome = nome;
        this.expressao = expressao;
        this.descricao = descricao;
        this.parametrosDefault = parametrosDefault;
        this.scale = scale;
        this.roundingMode = roundingMode;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getExpressao() {
        return expressao;
    }

    public void setExpressao(String expressao) {
        this.expressao = expressao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Map<String, String> getParametrosDefault() {
        return parametrosDefault;
    }

    public void setParametrosDefault(Map<String, String> parametrosDefault) {
        this.parametrosDefault = parametrosDefault;
    }

    public int getScale() {
        return scale;
    }

    public void setScale(int scale) {
        this.scale = scale;
    }

    public RoundingMode getRoundingMode() {
        return roundingMode;
    }

    public void setRoundingMode(RoundingMode roundingMode) {
        this.roundingMode = roundingMode;
    }

    @Override
    public String toString() {
        return "Formula{" +
                "nome='" + nome + '\'' +
                ", expressao='" + expressao + '\'' +
                ", descricao='" + descricao + '\'' +
                ", parametrosDefault=" + parametrosDefault +
                '}';
    }
}