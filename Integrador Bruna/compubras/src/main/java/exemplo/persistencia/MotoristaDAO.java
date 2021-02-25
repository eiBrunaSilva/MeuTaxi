package exemplo.persistencia;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import exemplo.model.*;

public class MotoristaDAO {

	private ConexaoMysql conexao;

	public MotoristaDAO() {
		super();
		this.conexao = ConexaoMysql.getInstance();
	}

	public Motorista salvar(Motorista motorista) {
		this.conexao.abrirConexao();
		String sqlInsert = "INSERT INTO motorista VALUES(null,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement statement = (PreparedStatement) this.conexao.getConexao().prepareStatement(sqlInsert,
					PreparedStatement.RETURN_GENERATED_KEYS);
			statement.setString(1, motorista.getSenha());
			statement.setString(2, motorista.getRua());
			statement.setString(3, motorista.getBairro());
			statement.setString(4, motorista.getCidade());
			statement.setString(5, motorista.getEstado());
			statement.setLong(6, motorista.getTelefone());
			statement.setString(7, motorista.getLogin());
			statement.setLong(8, motorista.getCep());
			statement.setString(9, motorista.getEmail());
			statement.setInt(10, motorista.getNumero());
			statement.setString(11, motorista.getNome());
			statement.setLong(12, motorista.getProprietario().getIdProprietario());
			statement.executeUpdate();
			ResultSet rs = statement.getGeneratedKeys();
			if (rs.next()) {
				long idMotorista = rs.getLong(1);
				motorista.setIdMotorista(idMotorista);
				;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return motorista;
	}

	public Motorista editar(Motorista motorista) {
		this.conexao.abrirConexao();
		String sqlUpdate = "UPDATE motorista SET senha = ?, rua = ?, bairro = ?, cidade = ?, estado = ?, telefone = ?, login = ?, cep = ?, email = ?, numero = ?, nome = ?, id_proprietario = ? WHERE id_motorista=?";
		try {
			PreparedStatement statement = (PreparedStatement) this.conexao.getConexao().prepareStatement(sqlUpdate);
			statement.setString(1, motorista.getSenha());
			statement.setString(2, motorista.getRua());
			statement.setString(3, motorista.getBairro());
			statement.setString(4, motorista.getCidade());
			statement.setString(5, motorista.getEstado());
			statement.setLong(6, motorista.getTelefone());
			statement.setString(7, motorista.getLogin());
			statement.setLong(8, motorista.getCep());
			statement.setString(9, motorista.getEmail());
			statement.setInt(10, motorista.getNumero());
			statement.setString(11, motorista.getNome());
			statement.setLong(12, motorista.getProprietario().getIdProprietario());
			statement.setLong(13, motorista.getIdMotorista());
			int linhasAfetadas = statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return motorista;
	}

	public boolean excluir(long idMotorista) {
		this.conexao.abrirConexao();
		String sqlExcluir = "DELETE FROM motorista WHERE id_motorista =?";
		try {
			PreparedStatement statement = (PreparedStatement) this.conexao.getConexao().prepareStatement(sqlExcluir);
			statement.setLong(1, idMotorista);
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

	public Motorista buscar(long idMotorista) {
		this.conexao.abrirConexao();
		String sqlUpdate = "select * from motorista where id_motorista = ?";
		Motorista motorista = null;
		try {
			PreparedStatement statement = (PreparedStatement) this.conexao.getConexao().prepareStatement(sqlUpdate);
			statement.setLong(1, idMotorista);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				motorista = new Motorista();
				idMotorista = rs.getLong("id_motorista");
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
				motorista.setSenha(senha);
				motorista.setRua(rua);
				motorista.setBairro(bairro);
				motorista.setCidade(cidade);
				motorista.setEstado(estado);
				motorista.setTelefone(telefone);
				motorista.setLogin(login);
				motorista.setCep(cep);
				motorista.setEmail(email);
				motorista.setNumero(numero);
				motorista.setNome(nome);

//				ProprietarioDAO pDAO = new ProprietarioDAO();
//				Proprietario p = pDAO.buscar(rs.getLong("id_proprietario"));
//				motorista.setProprietario(p);

//				DiariaDAO dDAO = new DiariaDAO();

//				List<Diaria> listaDiarias = dDAO.buscarDiariaPorIdMotorista(rs.getLong("id_motorista"));
//				motorista.setVetorDiaria(listaDiarias);
//
//				VeiculoMotoristaDAO vMDAO = new VeiculoMotoristaDAO();
//
//				List<VeiculoMotorista> listaVeiculoMotorista = vMDAO.buscarVeiculoMotoristaPorIdMotorista(rs.getLong("id_motorista"));
//				motorista.setVetorVeiculoMotorista(listaVeiculoMotorista);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return motorista;
	}

	public List<Motorista> listar() {
		List<Motorista> listaMotorista = new ArrayList();
		this.conexao.abrirConexao();
		String sqlUpdate = "select * from motorista";
		try {
			PreparedStatement statement = (PreparedStatement) this.conexao.getConexao().prepareStatement(sqlUpdate);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Motorista motorista = new Motorista();
				long idMotorista = rs.getLong("id_motorista");
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
				motorista.setIdMotorista(idMotorista);
				motorista.setSenha(senha);
				motorista.setRua(rua);
				motorista.setBairro(bairro);
				motorista.setCidade(cidade);
				motorista.setEstado(estado);
				motorista.setTelefone(telefone);
				motorista.setLogin(login);
				motorista.setCep(cep);
				motorista.setEmail(email);
				motorista.setNumero(numero);
				motorista.setNome(nome);

				ProprietarioDAO pDAO = new ProprietarioDAO();
				Proprietario p = pDAO.buscar(rs.getLong("id_proprietario"));
				motorista.setProprietario(p);

				DiariaDAO dDAO = new DiariaDAO();

				List<Diaria> listaDiarias = dDAO.buscarDiariaPorIdMotorista(rs.getLong("id_motorista"));
				motorista.setVetorDiaria(listaDiarias);

				VeiculoMotoristaDAO vMDAO = new VeiculoMotoristaDAO();

				List<VeiculoMotorista> listaVeiculoMotorista = vMDAO
						.buscarVeiculoMotoristaPorIdMotorista(rs.getLong("id_motorista"));
				motorista.setVetorVeiculoMotorista(listaVeiculoMotorista);

				listaMotorista.add(motorista);
				
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return listaMotorista;
	}

	public List<Motorista> buscarMotoristaPorIdProprietario(long idProprietario) {
		List<Motorista> listaMotorista = new ArrayList();
		this.conexao.abrirConexao();
		String sqlUpdate = "select * from motorista WHERE id_proprietario=?";
		try {
			PreparedStatement statement = (PreparedStatement) this.conexao.getConexao().prepareStatement(sqlUpdate);
			statement.setLong(1, idProprietario);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Motorista motorista = new Motorista();
				long idMotorista = rs.getLong("id_motorista");
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
				motorista.setIdMotorista(idMotorista);
				motorista.setSenha(senha);
				motorista.setRua(rua);
				motorista.setBairro(bairro);
				motorista.setCidade(cidade);
				motorista.setEstado(estado);
				motorista.setTelefone(telefone);
				motorista.setLogin(login);
				motorista.setCep(cep);
				motorista.setEmail(email);
				motorista.setNumero(numero);
				motorista.setNome(nome);

//				ProprietarioDAO pDAO = new ProprietarioDAO();
//				Proprietario p = pDAO.buscar(rs.getLong("id_proprietario"));
//				motorista.setProprietario(p);

//				DiariaDAO dDAO = new DiariaDAO();
//
//				List<Diaria> listaDiarias = dDAO.buscarDiariaPorIdMotorista(rs.getLong("id_motorista"));
//				motorista.setVetorDiaria(listaDiarias);
//
//				VeiculoMotoristaDAO vMDAO = new VeiculoMotoristaDAO();
//
//				List<VeiculoMotorista> listaVeiculoMotorista = vMDAO
//						.buscarVeiculoMotoristaPorIdMotorista(rs.getLong("id_motorista"));
//				motorista.setVetorVeiculoMotorista(listaVeiculoMotorista);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return listaMotorista;
	}

}
