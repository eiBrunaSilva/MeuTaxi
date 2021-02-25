package com.example.alunoinfo.meutaxi;

public class Corrida {
    private int horaInicial;
    private int horaFinal;
    private float preco;
    private boolean cartao;
    private int idCorrida;

    public Corrida() {
        super();
    }
    public Corrida(int horaInical, int horaFinal, float preco, boolean cartao, int idCorrida) {
        this.horaInicial = horaInical;
        this.horaFinal = horaFinal;
        this.preco = preco;
        this.cartao = cartao;
        this.idCorrida = idCorrida;
    }
    public int getHoraInicial () {
        return horaInicial;
    }
    public void setHoraInicial (int horaInicial){
        this.horaInicial = horaInicial;
    }
    public int getHoraFinal () {
        return horaFinal;
    }
    public void setHoraFinal(int horaFinal) {
        this.horaFinal = horaFinal;
    }
    public float getPreco () {
        return preco;
    }
    public void setPreco(float preco) {
        this.preco = preco;
    }
    public boolean getCartao () {
        return cartao;
    }
    public void setCartao(boolean cartao) {
        this.cartao = cartao;
    }
    public int getIdCorrida () {
        return idCorrida;
    }
    public void setIdCorrida(int idCorrida) {
        this.idCorrida = idCorrida;
    }

}

