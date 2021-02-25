package exemplo.model;

import java.util.List;

public class Motorista extends Usuario {

	private long idMotorista;
	private Proprietario proprieatio;
	private List<VeiculoMotorista> vetorVeiculoMotorista;
	private List<Diaria> vetorDiaria;

	public Motorista() {
		super();
	}

	public Motorista(long idMotorista, Proprietario proprietario, List<VeiculoMotorista> vetorVeiculoMotorista,
			List<Diaria> vetorDiaria) {
		this.idMotorista = idMotorista;
		this.proprieatio = proprietario;
		this.vetorVeiculoMotorista = vetorVeiculoMotorista;
		this.vetorDiaria = vetorDiaria;
	}

	public long getIdMotorista() {
		return idMotorista;
	}

	public void setIdMotorista(long idMotorista) {
		this.idMotorista = idMotorista;
	}

	public Proprietario getProprietario() {
		return proprieatio;
	}

	public void setProprietario(Proprietario proprieatio) {
		this.proprieatio = proprieatio;
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
		return this.idMotorista + ", " + this.getSenha() + ", " + this.getRua() + ", " + this.getBairro() + ", "
				+ this.getCidade() + ", " + this.getEstado() + ", " + this.getTelefone() + ", " + this.getLogin() + ", "
				+ this.getCep() + ", " + this.getEmail() + ", " + this.getNumero() + ", " + this.getNome() + ", "
				+ this.proprieatio + ", " + this.getVetorVeiculoMotorista() + ", " + this.getVetorDiaria();
	}
}
