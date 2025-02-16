package org.example.folhadpgems.formulas;

import java.util.Map;

public class BaseFormula {

    private String nome;
    private String expressao;
    private String descricao;
    private Map<String, String> parametrosDefault;

    public BaseFormula() {
    }

    public BaseFormula(String nome, String expressao, String descricao, Map<String, String> parametrosDefault) {
        this.nome = nome;
        this.expressao = expressao;
        this.descricao = descricao;
        this.parametrosDefault = parametrosDefault;
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
