package exemplo.model;

public class Gasto {
	private long idGasto;
	private String descricao;
	private float valor;
	private Diaria diaria;

	public Gasto() {
		super();
	}

	public Gasto(long idGasto, String descricao, float valor, Diaria diaria) {
		this.idGasto = idGasto;
		this.descricao = descricao;
		this.valor = valor;
		this.diaria = diaria;
	}

	public long getIdGasto() {
		return idGasto;
	}

	public void setIdGasto(long idGasto) {
		this.idGasto = idGasto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
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
		return this.idGasto + ", " + this.descricao + ", " + this.valor + ", " + this.diaria;
	}

}
