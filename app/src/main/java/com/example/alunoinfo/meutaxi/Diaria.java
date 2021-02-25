package com.example.alunoinfo.meutaxi;

public class Diaria {
    private int horaInicial;
    private int horaFinal;
    private int dia;
    private float comissao;
    private float kmInicial;
    private float kmFinal;
    private float precoKm;
    private float combustivel;
    private int idDiaria;
    private Corrida idCorrida;
    private Gasto idGasto;

    public Diaria() {
        super();
    }
    public Diaria(int horaInicial, int horaFinal, int dia, float comissao, float kmInicial, float kmFinal, float precoKm,float combustivel, int idDiaria, Corrida idCorrida, Gasto idGasto) {
        this.horaInicial = horaInicial;
        this.horaFinal = horaFinal;
        this.dia = dia;
        this.comissao = comissao;
        this.kmInicial = kmInicial;
        this.kmFinal = kmFinal;
        this.precoKm = precoKm;
        this.combustivel = combustivel;
        this.idDiaria = idDiaria;
        this.idCorrida = idCorrida;
        this.idGasto = idGasto;
    }
    public int getHoraInicial () {
        return horaInicial;
    }
    public void setHoraInicial(int horaInicial) {
        this.horaInicial = horaInicial;
    }
    public int getHoraFinal () {
        return horaFinal;
    }
    public void setHoraFinal (int horaFinal) {
        this.horaFinal = horaFinal;
    }
    public int getDia () {
        return dia;
    }
    public void setDia(int dia) {
        this.dia = dia;
    }
    public float getComissao () {
        return comissao;
    }
    public void setComissao(float Comissao) {
        this.comissao = comissao;
    }
    public float getKmInicial () {
        return kmInicial;
    }
    public void setKmInicial(float kmInicial) {
        this.kmInicial = kmInicial;
    }
    public float getKmFinal () {
        return kmFinal;
    }
    public void setKmFinal(float kmFinal) {
        this.kmFinal = kmFinal;
    }
    public float getPrecoKm () {
        return precoKm;
    }
    public void setPrecoKm(float precoKm) {
        this.precoKm = precoKm;
    }
    public float getCombustivel () {
        return combustivel;
    }
    public void setCombustivel(float combustivel) {
        this.combustivel = combustivel;
    }
    public int getIdDiaria () {
        return idDiaria;
    }
    public void setIdDiaria(int idDiaria) {
        this.idDiaria = idDiaria;
    }

    public Corrida getIdCorrida () {
        return idCorrida;
    }

    public void setIdCorrida(Corrida idCorrida) {
        this.idCorrida = idCorrida;
    }

    public Gasto getIdGasto () {
        return idGasto;
    }

    public void setIdGasto(Gasto idGasto) {
        this.idGasto = idGasto;
    }
}


