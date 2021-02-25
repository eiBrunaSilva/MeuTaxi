package exemplo.model;

public class VeiculoMotorista {

	private long idVeiculoMotorista;
	private Motorista motorista;
	private Veiculo veiculo;

	public VeiculoMotorista() {
		super();
	}

	public VeiculoMotorista(long idVeiculoMotorista, Motorista motorista, Veiculo veiculo) {
		this.idVeiculoMotorista = idVeiculoMotorista;
		this.motorista = motorista;
		this.veiculo = veiculo;
	}

	public long getIdVeiculoMotorista() {
		return idVeiculoMotorista;
	}

	public void setIdVeiculoMotorista(long idVeiculoMotorista) {
		this.idVeiculoMotorista = idVeiculoMotorista;
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

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.idVeiculoMotorista + ", " + this.veiculo + ", " + this.motorista;
	}

}
