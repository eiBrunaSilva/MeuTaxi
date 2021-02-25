package exemplo.model;

import java.util.List;

public class Diaria {
	private long idDiaria;
	private String horaInicial;
	private String horaFinal;
	private String dia;
	private float comissao;
	private float kmInicial;
	private float kmFinal;
	private float precoKm;
	private float combustivel;
	private Proprietario proprietario;
	private Veiculo veiculo;
	private Motorista motorista;
	private List<Gasto> vetorGasto;
	private List<Corrida> vetorCorrida;

	public Diaria() {
		super();
	}

	public Diaria(long idDiaria, String horaInicial, String horaFinal, String dia, float comissao, float kmInicial,
			float kmFinal, float precoKm, float combustivel, Proprietario proprietario, Veiculo veiculo,
			Motorista motorista, List<Gasto> vetorGasto, List<Corrida> vetorCorrida) {
		this.idDiaria = idDiaria;
		this.horaInicial = horaInicial;
		this.horaFinal = horaFinal;
		this.dia = dia;
		this.comissao = comissao;
		this.kmInicial = kmInicial;
		this.kmFinal = kmFinal;
		this.precoKm = precoKm;
		this.combustivel = combustivel;
		this.proprietario = proprietario;
		this.veiculo = veiculo;
		this.motorista = motorista;
		this.vetorGasto = vetorGasto;
		this.vetorCorrida = vetorCorrida;
	}

	public long getIdDiaria() {
		return idDiaria;
	}

	public void setIdDiaria(long idDiaria) {
		this.idDiaria = idDiaria;
	}

	public String getHoraInicial() {
		return horaInicial;
	}

	public void setHoraInicial(String horaInicial) {
		this.horaInicial = horaInicial;
	}

	public String getHoraFinal() {
		return horaFinal;
	}

	public void setHoraFinal(String horaFinal) {
		this.horaFinal = horaFinal;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public float getComissao() {
		return comissao;
	}

	public void setComissao(float comissao) {
		this.comissao = comissao;
	}

	public float getKmInicial() {
		return kmInicial;
	}

	public void setKmInicial(float kmInicial) {
		this.kmInicial = kmInicial;
	}

	public float getKmFinal() {
		return kmFinal;
	}

	public void setKmFinal(float kmFinal) {
		this.kmFinal = kmFinal;
	}

	public float getPrecoKm() {
		return precoKm;
	}

	public void setPrecoKm(float precoKm) {
		this.precoKm = precoKm;
	}

	public float getCombustivel() {
		return combustivel;
	}

	public void setCombustivel(float combustivel) {
		this.combustivel = combustivel;
	}

	public Proprietario getProprietario() {
		return proprietario;
	}

	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}

	public Motorista getMotorista() {
		return motorista;
	}

	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public List<Gasto> getVetorGasto() {
		return vetorGasto;
	}

	public void setVetorGasto(List<Gasto> vetorGasto) {
		this.vetorGasto = vetorGasto;
	}

	public List<Corrida> getVetorCorrida() {
		return vetorCorrida;
	}

	public void setVetorCorrida(List<Corrida> vetorCorrida) {
		this.vetorCorrida = vetorCorrida;
	}

	@Override
	public String toString() {
		return this.idDiaria + ", " + this.horaInicial + ", " + this.horaFinal + ", " + this.dia + ", " + this.comissao
				+ ", " + this.kmInicial + ", " + this.kmFinal + ", " + this.precoKm + ", " + this.combustivel + ", "
				+ this.proprietario + ", " + this.veiculo + ", " + this.motorista + ", " + this.getVetorGasto() + ", "
				+ this.getVetorCorrida();
	}
}
