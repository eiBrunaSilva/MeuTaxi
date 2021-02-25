package exemplo.persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exemplo.model.Diaria;
import exemplo.model.Motorista;
import exemplo.model.Proprietario;
import exemplo.model.Veiculo;

public class ProprietarioDAO {

	private ConexaoMysql conexao;

	public ProprietarioDAO() {
		super();
		this.conexao = ConexaoMysql.getInstance();
	}

	public Proprietario salvar(Proprietario proprietario) {
		this.conexao.abrirConexao();
		String sqlInsert = "INSERT INTO proprietario (id_proprietario, senha, rua, bairro, cidade, estado, telefone, login, cep, email, numero, nome) VALUES(null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement statement = (PreparedStatement) this.conexao.getConexao().prepareStatement(sqlInsert,
					PreparedStatement.RETURN_GENERATED_KEYS);
			statement.setString(1, proprietario.getSenha());
			statement.setString(2, proprietario.getRua());
			statement.setString(3, proprietario.getBairro());
			statement.setString(4, proprietario.getCidade());
			statement.setString(5, proprietario.getEstado());
			statement.setLong(6, proprietario.getTelefone());
			statement.setString(7, proprietario.getLogin());
			statement.setLong(8, proprietario.getCep());
			statement.setString(9, proprietario.getEmail());
			statement.setInt(10, proprietario.getNumero());
			statement.setString(11, proprietario.getNome());
			statement.executeUpdate();
			ResultSet rs = statement.getGeneratedKeys();
			if (rs.next()) {
				long idProprietario = rs.getLong(1);
				proprietario.setIdProprietario(idProprietario);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return proprietario;
	}

	public Proprietario editar(Proprietario proprietario) {
		this.conexao.abrirConexao();
		String sqlUpdate = "UPDATE proprietario SET senha = ?, rua = ?, bairro = ?, cidade = ?, estado = ?, telefone = ?, login = ?, cep = ?, email = ?, numero = ?, nome = ?  WHERE id_proprietario=?";
		try {
			PreparedStatement statement = (PreparedStatement) this.conexao.getConexao().prepareStatement(sqlUpdate);
			statement.setString(1, proprietario.getSenha());
			statement.setString(2, proprietario.getRua());
			statement.setString(3, proprietario.getBairro());
			statement.setString(4, proprietario.getCidade());
			statement.setString(5, proprietario.getEstado());
			statement.setLong(6, proprietario.getTelefone());
			statement.setString(7, proprietario.getLogin());
			statement.setLong(8, proprietario.getCep());
			statement.setString(9, proprietario.getEmail());
			statement.setInt(10, proprietario.getNumero());
			statement.setString(11, proprietario.getNome());
			statement.setLong(12, proprietario.getIdProprietario());
			int linhasAfetadas = statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return proprietario;
	}

	public boolean excluir(long idProprietario) {
		this.conexao.abrirConexao();
		String sqlExcluir = "DELETE FROM proprietario WHERE id_proprietario=?";
		try {
			PreparedStatement statement = (PreparedStatement) this.conexao.getConexao().prepareStatement(sqlExcluir);
			statement.setLong(1, idProprietario);
			int linhasAfetadas = statement.executeUpdate();
			if (linhasAfetadas > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return false;
	}

	public Proprietario buscar(long idProprietario) {
		this.conexao.abrirConexao();
		String sqlUpdate = "select * from proprietario where id_proprietario = ?";
		Proprietario proprietario = null;
		try {

			PreparedStatement statement = (PreparedStatement) this.conexao.getConexao().prepareStatement(sqlUpdate);
			statement.setLong(1, idProprietario);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				proprietario = new Proprietario();
				idProprietario = rs.getLong("id_proprietario");
				String senha = rs.getString("senha");
				String rua = rs.getString("rua");
				String bairro = rs.getString("bairro");
				String cidade = rs.getString("cidade");
				String estado = rs.getString("estado");
				long telefone = rs.getLong("telefone");
				String login = rs.getString("login");
				long cep = rs.getLong("cep");
				String email = rs.getString("email");
				int numero = rs.getInt("numero");
				String nome = rs.getString("nome");
				proprietario.setIdProprietario(idProprietario);
				proprietario.setSenha(senha);
				proprietario.setRua(rua);
				proprietario.setBairro(bairro);
				proprietario.setCidade(cidade);
				proprietario.setEstado(estado);
				proprietario.setTelefone(telefone);
				proprietario.setLogin(login);
				proprietario.setCep(cep);
				proprietario.setEmail(email);
				proprietario.setNumero(numero);
				proprietario.setNome(nome);

				MotoristaDAO mDAO = new MotoristaDAO();
				List<Motorista> listaMotoristas = mDAO.buscarMotoristaPorIdProprietario(rs.getLong("id_proprietario"));
				proprietario.setVetorMotorista(listaMotoristas);

				VeiculoDAO vDAO = new VeiculoDAO();
				List<Veiculo> listaVeiculos = vDAO.buscarVeiculoPorIdProprietario(rs.getLong("id_proprietario"));
				proprietario.setVetorVeiculo(listaVeiculos);

				DiariaDAO dDAO = new DiariaDAO();
				List<Diaria> listaDiarias = dDAO.buscarDiariaPorIdProprietario(rs.getLong("id_proprietario"));
				proprietario.setVetorDiaria(listaDiarias);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return proprietario;
	}

	public List<Proprietario> listar() {
		List<Proprietario> listaProprietario = new ArrayList();
		this.conexao.abrirConexao();
		String sqlUpdate = "select * from proprietario";
		try {
			PreparedStatement statement = (PreparedStatement) this.conexao.getConexao().prepareStatement(sqlUpdate);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				long idProprietario = rs.getLong("id_proprietario");
				String senha = rs.getString("senha");
				String rua = rs.getString("rua");
				String bairro = rs.getString("bairro");
				String cidade = rs.getString("cidade");
				String estado = rs.getString("estado");
				long telefone = rs.getLong("telefone");
				String login = rs.getString("login");
				long cep = rs.getLong("cep");
				String email = rs.getString("email");
				int numero = rs.getInt("numero");
				String nome = rs.getString("nome");
				Proprietario proprietario = new Proprietario();
				proprietario.setIdProprietario(idProprietario);
				proprietario.setSenha(senha);
				proprietario.setRua(rua);
				proprietario.setBairro(bairro);
				proprietario.setCidade(cidade);
				proprietario.setEstado(estado);
				proprietario.setTelefone(telefone);
				proprietario.setLogin(login);
				proprietario.setCep(cep);
				proprietario.setEmail(email);
				proprietario.setNumero(numero);
				proprietario.setNome(nome);

				MotoristaDAO mDAO = new MotoristaDAO();
				List<Motorista> listaMotoristas = mDAO.buscarMotoristaPorIdProprietario(rs.getLong("id_proprietario"));
				proprietario.setVetorMotorista(listaMotoristas);

				VeiculoDAO vDAO = new VeiculoDAO();
				List<Veiculo> listaVeiculos = vDAO.buscarVeiculoPorIdProprietario(rs.getLong("id_proprietario"));
				proprietario.setVetorVeiculo(listaVeiculos);

				DiariaDAO dDAO = new DiariaDAO();
				List<Diaria> listaDiarias = dDAO.buscarDiariaPorIdProprietario(rs.getLong("id_proprietario"));
				proprietario.setVetorDiaria(listaDiarias);

				listaProprietario.add(proprietario);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return listaProprietario;
	}

}
