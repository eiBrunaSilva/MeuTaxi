package com.example.alunoinfo.meutaxi;

public class Gasto {
    private float valor;
    private String descricao;
    private int idGasto;

    public Gasto () {
        super();
    }
    public Gasto (float valor, String descricao, int idGasto) {
        this.valor = valor;
        this.descricao = descricao;
        this.idGasto = idGasto;
    }
    public float getValor () {
        return valor;
    }
    public void setValor(float valor) {
        this.valor = valor;
    }
    public String getDescricao () {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public int getIdGasto () {
        return idGasto;
    }
    public void setIdGasto(int idGasto) {
        this.idGasto = idGasto;
    }

}
