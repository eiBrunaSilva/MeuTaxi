package exemplo.persistencia;

import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.*;;

public class ConexaoMysql {

	private String ip;
	private String porta;
	private String login;
	private String senha;
	private String nomeBD;
	private static Connection conexao;

	private static ConexaoMysql conexaoMysql;

	private ConexaoMysql() {
		super();
	}

	private ConexaoMysql(String ip, String porta, String login, String senha, String nomeBD) {
		super();
		this.ip = ip;
		this.porta = porta;
		this.login = login;
		this.senha = senha;
		this.nomeBD = nomeBD;
	}

	public static ConexaoMysql getInstance() {
		if (conexaoMysql == null) {
			conexaoMysql = new ConexaoMysql(MysqlUtils.IP, MysqlUtils.PORTA, MysqlUtils.LOGIN, MysqlUtils.SENHA,
					MysqlUtils.NOME_BD);
		}
		return conexaoMysql;
	}

	public Connection getConexao() {
		return conexao;
	}

	public void setConexao(Connection conexao) {
		this.conexao = conexao;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getPorta() {
		return porta;
	}

	public void setPorta(String porta) {
		this.porta = porta;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNomeBD() {
		return nomeBD;
	}

	public void setNomeBD(String nomeBD) {
		this.nomeBD = nomeBD;
	}

	public void abrirConexao() {
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://" + ip + ":" + porta + "/" + nomeBD
					+ "?autoReconnect=true&useSSL=false&useTimezone=true&serverTimezone=UTC&useSSL=false";
			this.conexao = (Connection) DriverManager.getConnection(url, login, senha);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void fecharConexao() {
		try {
			if (!this.conexao.isClosed()) {
				this.conexao.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}