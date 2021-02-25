package com.example.alunoinfo.meutaxi;

import android.text.Editable;

public class Veiculo {
    private String placa;
    private int idVeiculo;
    private String marca;
    private String modelo;
    private int ano;
    private int prefixo;
    private Diaria idDiaria;

    public Veiculo () {
        super();
    }
    public Veiculo(String placa, int idVeiculo, String marca, String modelo, int ano, int prefixo, Diaria idDiaria) {
        this.placa = placa;
        this.idVeiculo = idVeiculo;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.prefixo = prefixo;
        this.idDiaria = idDiaria;
    }
    public String getPlaca () {
        return placa;
    }
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    public int getIdVeiculo () {
        return idVeiculo;
    }
    public void setIdVeiculo(int idVeiculo) {
        this.idVeiculo = idVeiculo;
    }
    public String getMarca () {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getModelo () {
        return modelo;
    }
    public void setModelo(String Modelo) {
        this.modelo = modelo;
    }
    public int getAno () {
        return ano;
    }
    public void setAno(int ano) {
        this.ano = ano;
    }
    public int getPrefixo () {
        return prefixo;
    }
    public void setPrefixo(int prefixo) {
        this.prefixo = prefixo;
    }

    public Diaria getIdDiaria () {
        return idDiaria;
    }

    public void setIdDiaria(Diaria idDiaria) {
        this.idDiaria = idDiaria;
    }

}
