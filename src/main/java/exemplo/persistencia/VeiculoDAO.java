package exemplo.persistencia;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import exemplo.model.*;

public class VeiculoDAO {

	private ConexaoMysql conexao;

	public VeiculoDAO() {
		super();
		this.conexao = ConexaoMysql.getInstance();
	}

	public Veiculo salvar(Veiculo veiculo) {
		this.conexao.abrirConexao();
		String sqlInsert = "INSERT INTO veiculo VALUES(null,?,?,?,?,?,?)";
		try {
			PreparedStatement statement = (PreparedStatement) this.conexao.getConexao().prepareStatement(sqlInsert,
					PreparedStatement.RETURN_GENERATED_KEYS);
			statement.setString(1, veiculo.getPlaca());
			statement.setString(2, veiculo.getMarca());
			statement.setString(3, veiculo.getModelo());
			statement.setInt(4, veiculo.getAno());
			statement.setLong(5, veiculo.getPrefixo());
			statement.setLong(6, veiculo.getProprietario().getIdProprietario());
			statement.executeUpdate();
			ResultSet rs = statement.getGeneratedKeys();
			if (rs.next()) {
				long idVeiculo = rs.getLong(1);
				veiculo.setIdVeiculo(idVeiculo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return veiculo;
	}

	public Veiculo editar(Veiculo veiculo) {
		this.conexao.abrirConexao();
		String sqlUpdate = "UPDATE veiculo SET placa=?, marca=?, modelo=?, ano=?, prefixo=?, id_proprietario=? WHERE id_veiculo=?";
		try {
			PreparedStatement statement = (PreparedStatement) this.conexao.getConexao().prepareStatement(sqlUpdate);
			statement.setString(1, veiculo.getPlaca());
			statement.setString(2, veiculo.getMarca());
			statement.setString(3, veiculo.getModelo());
			statement.setInt(4, veiculo.getAno());
			statement.setLong(5, veiculo.getPrefixo());
			statement.setLong(6, veiculo.getProprietario().getIdProprietario());
			statement.setLong(7, veiculo.getIdVeiculo());
			int linhasAfetadas = statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return veiculo;
	}

	public boolean excluir(long idVeiculo) {
		this.conexao.abrirConexao();
		String sqlExcluir = "DELETE FROM veiculo WHERE id_veiculo =?";
		try {
			PreparedStatement statement = (PreparedStatement) this.conexao.getConexao().prepareStatement(sqlExcluir);
			statement.setLong(1, idVeiculo);
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

	public Veiculo buscar(long idVeiculo) {
		this.conexao.abrirConexao();
		String sqlUpdate = "select * from veiculo where id_veiculo = ?";
		Veiculo veiculo = null;
		try {
			PreparedStatement statement = (PreparedStatement) this.conexao.getConexao().prepareStatement(sqlUpdate);
			statement.setLong(1, idVeiculo);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				veiculo = new Veiculo();
				idVeiculo = rs.getLong("id_veiculo");
				String placa = rs.getString("placa");
				String marca = rs.getString("marca");
				String modelo = rs.getString("modelo");
				int ano = rs.getInt("ano");
				long prefixo = rs.getLong("prefixo");
				veiculo.setIdVeiculo(idVeiculo);
				veiculo.setPlaca(placa);
				veiculo.setMarca(marca);
				veiculo.setModelo(modelo);
				veiculo.setAno(ano);
				veiculo.setPrefixo(prefixo);

				ProprietarioDAO pDAO = new ProprietarioDAO();
				Proprietario p = pDAO.buscar(rs.getLong("id_proprietario"));
				veiculo.setProprietario(p);

				DiariaDAO dDAO = new DiariaDAO();
				List<Diaria> listaDiarias = dDAO.buscarDiariaPorIdVeiculo(rs.getLong("id_veiculo"));
				veiculo.setVetorDiaria(listaDiarias);

//				VeiculoMotoristaDAO vMDAO = new VeiculoMotoristaDAO();
//				List<VeiculoMotorista> listaVeiculoMotorista = vMDAO.buscarVeiculoMotoristaPorIdVeiculo(rs.getLong("id_veiculo"));
//				veiculo.setVetorVeiculoMotorista(listaVeiculoMotorista);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return veiculo;
	}

	public List<Veiculo> listar() {
		List<Veiculo> listaVeiculo = new ArrayList();
		this.conexao.abrirConexao();
		String sqlUpdate = "select * from veiculo";
		try {
			PreparedStatement statement = (PreparedStatement) this.conexao.getConexao().prepareStatement(sqlUpdate);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				long idVeiculo = rs.getLong("id_veiculo");
				String placa = rs.getString("placa");
				String marca = rs.getString("marca");
				String modelo = rs.getString("modelo");
				int ano = rs.getInt("ano");
				long prefixo = rs.getLong("prefixo");
				Veiculo veiculo = new Veiculo();
				veiculo.setIdVeiculo(idVeiculo);
				veiculo.setPlaca(placa);
				veiculo.setMarca(marca);
				veiculo.setModelo(modelo);
				veiculo.setAno(ano);
				veiculo.setPrefixo(prefixo);

				ProprietarioDAO pDAO = new ProprietarioDAO();
				Proprietario p = pDAO.buscar(rs.getLong("id_proprietario"));
				veiculo.setProprietario(p);

				DiariaDAO dDAO = new DiariaDAO();
				List<Diaria> listaDiarias = dDAO.buscarDiariaPorIdVeiculo(rs.getLong("id_veiculo"));
				veiculo.setVetorDiaria(listaDiarias);

//				VeiculoMotoristaDAO vMDAO = new VeiculoMotoristaDAO();
//				List<VeiculoMotorista> listaVeiculoMotorista = vMDAO
//						.buscarVeiculoMotoristaPorIdVeiculo(rs.getLong("id_veiculo"));
//				veiculo.setVetorVeiculoMotorista(listaVeiculoMotorista);

				listaVeiculo.add(veiculo);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return listaVeiculo;
	}

	public List<Veiculo> buscarVeiculoPorIdProprietario(long idProprietario) {
		List<Veiculo> listaVeiculo = new ArrayList();
		this.conexao.abrirConexao();
		String sqlUpdate = "select * from veiculo WHERE id_proprietario = ?";
		try {
			PreparedStatement statement = (PreparedStatement) this.conexao.getConexao().prepareStatement(sqlUpdate);
			statement.setLong(1, idProprietario);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				long idVeiculo = rs.getLong("id_veiculo");
				String placa = rs.getString("placa");
				String marca = rs.getString("marca");
				String modelo = rs.getString("modelo");
				int ano = rs.getInt("ano");
				long prefixo = rs.getLong("prefixo");
				Veiculo veiculo = new Veiculo();
				veiculo.setIdVeiculo(idVeiculo);
				veiculo.setPlaca(placa);
				veiculo.setMarca(marca);
				veiculo.setModelo(modelo);
				veiculo.setAno(ano);
				veiculo.setPrefixo(prefixo);

				DiariaDAO dDAO = new DiariaDAO();
				List<Diaria> listaDiarias = dDAO.buscarDiariaPorIdVeiculo(rs.getLong("id_veiculo"));
				veiculo.setVetorDiaria(listaDiarias);

//				ProprietarioDAO pDAO = new ProprietarioDAO();
//				Proprietario p = pDAO.buscar(rs.getLong("id_proprietario"));
//				veiculo.setProprietario(p);

//				VeiculoMotoristaDAO vMDAO = new VeiculoMotoristaDAO();
//				List<VeiculoMotorista> listaVeiculoMotorista = vMDAO
//						.buscarVeiculoMotoristaPorIdVeiculo(rs.getLong("id_veiculo"));
//				veiculo.setVetorVeiculoMotorista(listaVeiculoMotorista);

				listaVeiculo.add(veiculo);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return listaVeiculo;
	}

}
