package exemplo.model;

public abstract class Usuario {

	private String senha;
	private String rua;
	private String bairro;
	private String cidade;
	private String estado;
	private long telefone;
	private String login;
	private long cep;
	private String email;
	private int numero;
	private String nome;

	public Usuario() {
		super();
	}

	public Usuario(String senha, String rua, String bairro, String cidade, String estado, long telefone, String login,
			long cep, String email, int numero, String nome) {
		this.senha = senha;
		this.rua = rua;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.telefone = telefone;
		this.login = login;
		this.cep = cep;
		this.email = email;
		this.numero = numero;
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public long getTelefone() {
		return telefone;
	}

	public void setTelefone(long telefone) {
		this.telefone = telefone;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public long getCep() {
		return cep;
	}

	public void setCep(long cep) {
		this.cep = cep;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}