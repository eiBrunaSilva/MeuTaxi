package exemplo.model;

public class Corrida {
	private long idCorrida;
	private String horaInicial;
	private String horaFinal;
	private float preco;
	private boolean cartao;
	private Diaria diaria;

	public Corrida() {
		super();
	}

	public Corrida(long idCorrida, String horaInicial, String horaFinal, float preco, boolean cartao, Diaria diaria) {
		this.idCorrida = idCorrida;
		this.horaInicial = horaInicial;
		this.horaFinal = horaFinal;
		this.preco = preco;
		this.cartao = cartao;
		this.diaria = diaria;
	}

	public long getIdCorrida() {
		return idCorrida;
	}

	public void setIdCorrida(long idCorrida) {
		this.idCorrida = idCorrida;
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

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public boolean getCartao() {
		return cartao;
	}

	public void setCartao(boolean cartao) {
		this.cartao = cartao;
	}

	public Diaria getDiaria() {
		return diaria;
	}

	public void setDiaria(Diaria diaria) {
		this.diaria = diaria;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.idCorrida + ", " + this.horaInicial + ", " + this.horaFinal + ", " + this.preco + ", " + this.cartao
				+ ", " + this.diaria;
	}

}
