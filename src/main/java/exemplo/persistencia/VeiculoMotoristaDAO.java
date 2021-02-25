package exemplo.persistencia;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import exemplo.model.*;

public class VeiculoMotoristaDAO {

	private ConexaoMysql conexao;

	public VeiculoMotoristaDAO() {
		super();
		this.conexao = ConexaoMysql.getInstance();
	}

	public VeiculoMotorista salvar(VeiculoMotorista veiculoMotorista) {
		this.conexao.abrirConexao();
		String sqlInsert = "INSERT INTO veiculo_motorista VALUES(null,?,?)";
		try {
			PreparedStatement statement = (PreparedStatement) this.conexao.getConexao().prepareStatement(sqlInsert,
					PreparedStatement.RETURN_GENERATED_KEYS);
			statement.setLong(1, veiculoMotorista.getVeiculo().getIdVeiculo());
			statement.setLong(2, veiculoMotorista.getMotorista().getIdMotorista());
			statement.executeUpdate();
			ResultSet rs = statement.getGeneratedKeys();
			if (rs.next()) {
				long idVeiculoMotorista = rs.getLong(1);
				veiculoMotorista.setIdVeiculoMotorista(idVeiculoMotorista);
				;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return veiculoMotorista;
	}

	public VeiculoMotorista editar(VeiculoMotorista veiculoMotorista) {
		this.conexao.abrirConexao();

		String sqlUpdate = "UPDATE veiculo_motorista SET id_veiculo=?, id_motorista=? WHERE id_veiculo_motorista=?";
		try {
			PreparedStatement statement = (PreparedStatement) this.conexao.getConexao().prepareStatement(sqlUpdate);
			statement.setLong(1, veiculoMotorista.getVeiculo().getIdVeiculo());
			statement.setLong(2, veiculoMotorista.getMotorista().getIdMotorista());
			statement.setLong(3, veiculoMotorista.getIdVeiculoMotorista());
			int linhasAfetadas = statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return veiculoMotorista;
	}

	public boolean excluir(long idVeiculoMotorista) {
		this.conexao.abrirConexao();
		String sqlExcluir = "DELETE FROM veiculo_motorista WHERE id_veiculo_motorista=?";
		try {
			PreparedStatement statement = (PreparedStatement) this.conexao.getConexao().prepareStatement(sqlExcluir);
			statement.setLong(1, idVeiculoMotorista);
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

	public VeiculoMotorista buscar(long idVeiculoMotorista) {
		this.conexao.abrirConexao();
		String sqlUpdate = "select * from veiculo_motorista where id_veiculo_motorista = ?";
		VeiculoMotorista veiculoMotorista = null;
		try {
			PreparedStatement statement = (PreparedStatement) this.conexao.getConexao().prepareStatement(sqlUpdate);
			statement.setLong(1, idVeiculoMotorista);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				idVeiculoMotorista = rs.getInt("id_veiculo_motorista");
				veiculoMotorista = new VeiculoMotorista();
				veiculoMotorista.setIdVeiculoMotorista(idVeiculoMotorista);

				VeiculoDAO vDAO = new VeiculoDAO();
				Veiculo v = vDAO.buscar(rs.getLong("id_veiculo"));
				veiculoMotorista.setVeiculo(v);

				MotoristaDAO mDAO = new MotoristaDAO();
				Motorista m = mDAO.buscar(rs.getLong("id_motorista"));
				veiculoMotorista.setMotorista(m);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return veiculoMotorista;
	}

	public List<VeiculoMotorista> listar() {
		List<VeiculoMotorista> listaVeiculoMotorista = new ArrayList();
		this.conexao.abrirConexao();
		String sqlUpdate = "select * from veiculo_motorista";
		try {
			PreparedStatement statement = (PreparedStatement) this.conexao.getConexao().prepareStatement(sqlUpdate);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				long idVeiculoMotorista = rs.getLong("id_veiculo_motorista");
				VeiculoMotorista veiculoMotorista = new VeiculoMotorista();
				veiculoMotorista.setIdVeiculoMotorista(idVeiculoMotorista);

				VeiculoDAO vDAO = new VeiculoDAO();
				Veiculo v = vDAO.buscar(rs.getLong("id_veiculo"));
				veiculoMotorista.setVeiculo(v);

				MotoristaDAO mDAO = new MotoristaDAO();
				Motorista m = mDAO.buscar(rs.getLong("id_motorista"));
				veiculoMotorista.setMotorista(m);

				listaVeiculoMotorista.add(veiculoMotorista);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return listaVeiculoMotorista;
	}

//	public List<VeiculoMotorista> buscarVeiculoMotoristaPorIdMotorista(long idMotorista) {
//		List<VeiculoMotorista> listaVeiculoMotorista = new ArrayList();
//		this.conexao.abrirConexao();
//		String sqlUpdate = "select * from veiculo_motorista WHERE id_motorista=?";
//		try {
//			PreparedStatement statement = (PreparedStatement) this.conexao.getConexao().prepareStatement(sqlUpdate);
//			statement.setLong(1, idMotorista);
//			ResultSet rs = statement.executeQuery();
//			while (rs.next()) {
//				long idVeiculoMotorista = rs.getLong("id_veiculo_motorista");
//				VeiculoMotorista veiculoMotorista = new VeiculoMotorista();
//				veiculoMotorista.setIdVeiculoMotorista(idVeiculoMotorista);
//
//				VeiculoDAO vDAO = new VeiculoDAO();
//				Veiculo v = vDAO.buscar(rs.getLong("id_veiculo"));
//				veiculoMotorista.setVeiculo(v);
//				
//
//				MotoristaDAO mDAO = new MotoristaDAO();
//				Motorista m = mDAO.buscar(rs.getLong("id_motorista"));
//				veiculoMotorista.setMotorista(m);
//
//				listaVeiculoMotorista.add(veiculoMotorista);
//
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			this.conexao.fecharConexao();
//		}
//
//		return listaVeiculoMotorista;
//	}
//
//	public List<VeiculoMotorista> buscarVeiculoMotoristaPorIdVeiculo(long idVeiculo) {
//		List<VeiculoMotorista> listaVeiculoMotorista = new ArrayList();
//		this.conexao.abrirConexao();
//		String sqlUpdate = "select * from veiculo_motorista WHERE id_veiculo = ?";
//		try {
//			PreparedStatement statement = (PreparedStatement) this.conexao.getConexao().prepareStatement(sqlUpdate);
//			statement.setLong(1, idVeiculo);
//			ResultSet rs = statement.executeQuery();
//			while (rs.next()) {
//				long idVeiculoMotorista = rs.getLong("id_veiculo_motorista");
//				VeiculoMotorista veiculoMotorista = new VeiculoMotorista();
//				veiculoMotorista.setIdVeiculoMotorista(idVeiculoMotorista);
//
//				VeiculoDAO vDAO = new VeiculoDAO();
//				Veiculo v = vDAO.buscar(rs.getLong("id_veiculo"));
//				veiculoMotorista.setVeiculo(v);
//				;
//
//				MotoristaDAO mDAO = new MotoristaDAO();
//				Motorista m = mDAO.buscar(rs.getLong("id_motorista"));
//				veiculoMotorista.setMotorista(m);
//
//				listaVeiculoMotorista.add(veiculoMotorista);
//
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			this.conexao.fecharConexao();
//		}
//		return listaVeiculoMotorista;
//	}

}
