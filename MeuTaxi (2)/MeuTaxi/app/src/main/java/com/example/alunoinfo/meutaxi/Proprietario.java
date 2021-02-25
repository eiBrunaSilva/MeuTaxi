package com.example.alunoinfo.meutaxi;


import java.util.List;

public class Proprietario extends Usuario {

    private long idProprietario;
    private List<Motorista> vetorMotorista;
    private List<Veiculo> vetorVeiculo;
    private List<Diaria> vetorDiaria;

    public Proprietario() {
        super();
    }

    public Proprietario(String senha, String rua, String bairro, String cidade, String estado, long telefone, String login,
                        long cep, String email, int numero, String nome, long idProprietario, List<Motorista> vetorMotorista, List<Veiculo> vetorVeiculo,
                        List<Diaria> vetorDiaria) {
        super(senha, rua, bairro, cidade, estado, telefone, login, cep, email, numero, nome);
        this.idProprietario = idProprietario;
        this.vetorMotorista = vetorMotorista;
        this.vetorVeiculo = vetorVeiculo;
        this.vetorDiaria = vetorDiaria;
    }

    public long getIdProprietario() {
        return idProprietario;
    }

    public void setIdProprietario(long idProprietario) {
        this.idProprietario = idProprietario;
    }

    public List<Motorista> getVetorMotorista() {
        return vetorMotorista;
    }

    public void setVetorMotorista(List<Motorista> vetorMotorista) {
        this.vetorMotorista = vetorMotorista;
    }

    public List<Veiculo> getVetorVeiculo() {
        return vetorVeiculo;
    }

    public void setVetorVeiculo(List<Veiculo> vetorVeiculo) {
        this.vetorVeiculo = vetorVeiculo;
    }

    public List<Diaria> getVetorDiaria() {
        return vetorDiaria;
    }

    public void setVetorDiaria(List<Diaria> vetorDiaria) {
        this.vetorDiaria = vetorDiaria;
    }

    @Override
    public String toString() {
       // TODO Auto-generated method stub
        return this.idProprietario + ", " + this.getSenha() + ", " + this.getRua() + ", " + this.getBairro() + ", "
                + this.getCidade() + ", " + this.getEstado() + ", " + this.getTelefone() + ", " + this.getLogin() + ", "
                + this.getCep() + ", " + this.getEmail() + ", " + this.getNumero() + ", " + this.getNome() + ", "
                + this.getVetorMotorista() + ", " + this.getVetorVeiculo() + ", " + this.getVetorDiaria();
    }
}
