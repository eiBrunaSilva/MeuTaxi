package exemplo.model;

import java.util.List;

public class Veiculo {
	private long idVeiculo;
	private String placa;
	private String marca;
	private String modelo;
	private int ano;
	private long prefixo;
	private Proprietario proprietario;
	private List<VeiculoMotorista> vetorVeiculoMotorista;
	private List<Diaria> vetorDiaria;

	public Veiculo() {
		super();
	}

	public Veiculo(long idVeiculo, String placa, String marca, String modelo, int ano, long prefixo,
			Proprietario proprietario, List<VeiculoMotorista> vetorVeiculoMotorista, List<Diaria> vetorDiaria) {
		this.idVeiculo = idVeiculo;
		this.placa = placa;
		this.marca = marca;
		this.modelo = modelo;
		this.ano = ano;
		this.prefixo = prefixo;
		this.proprietario = proprietario;
		this.vetorVeiculoMotorista = vetorVeiculoMotorista;
		this.vetorDiaria = vetorDiaria;
	}

	public long getIdVeiculo() {
		return idVeiculo;
	}

	public void setIdVeiculo(long idVeiculo) {
		this.idVeiculo = idVeiculo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public long getPrefixo() {
		return prefixo;
	}

	public void setPrefixo(long prefixo) {
		this.prefixo = prefixo;
	}

	public Proprietario getProprietario() {
		return proprietario;
	}

	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}

	public List<VeiculoMotorista> getVetorVeiculoMotorista() {
		return vetorVeiculoMotorista;
	}

	public void setVetorVeiculoMotorista(List<VeiculoMotorista> vetorVeiculoMotorista) {
		this.vetorVeiculoMotorista = vetorVeiculoMotorista;
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
		return this.idVeiculo + ", " + this.placa + ", " + this.marca + ", " + this.modelo + ", " + this.ano + ", "
				+ this.prefixo + ", " + this.proprietario + ", " + this.getVetorVeiculoMotorista() + ", "
				+ this.getVetorDiaria();
	}

}
