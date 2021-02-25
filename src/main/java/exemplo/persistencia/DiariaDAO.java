package exemplo.persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import exemplo.model.*;

public class DiariaDAO {

	private ConexaoMysql conexao;

	public DiariaDAO() {
		super();
		this.conexao = ConexaoMysql.getInstance();
	}

	public Diaria salvar(Diaria diaria) {
		this.conexao.abrirConexao();
		String sqlInsert = "INSERT INTO diaria (id_diaria, hora_inicial, hora_final, dia, comissao, km_inicial, km_final, preco_km, combustivel, id_proprietario, id_veiculo, id_motorista) VALUES(null,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement statement = (PreparedStatement) this.conexao.getConexao().prepareStatement(sqlInsert,
					PreparedStatement.RETURN_GENERATED_KEYS);
			statement.setString(1, diaria.getHoraInicial());
			statement.setString(2, diaria.getHoraFinal());
			statement.setString(3, diaria.getDia());
			statement.setFloat(4, diaria.getComissao());
			statement.setFloat(5, diaria.getKmInicial());
			statement.setFloat(6, diaria.getKmFinal());
			statement.setFloat(7, diaria.getPrecoKm());
			statement.setFloat(8, diaria.getCombustivel());
			statement.setLong(9, diaria.getProprietario().getIdProprietario());
			statement.setLong(10, diaria.getVeiculo().getIdVeiculo());
			statement.setLong(11, diaria.getMotorista().getIdMotorista());
			statement.executeUpdate();
			ResultSet rs = statement.getGeneratedKeys();
			if (rs.next()) {
				long idDiaria = rs.getLong(1);
				diaria.setIdDiaria(idDiaria);
				diaria.setIdDiaria(idDiaria);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return diaria;
	}

	public Diaria editar(Diaria diaria) {
		this.conexao.abrirConexao();

		String sqlUpdate = "UPDATE diaria SET hora_inicial=?, hora_final=?, dia=?, comissao=?, km_inicial=?, km_final=?, preco_km=?, combustivel=?, id_proprietario = ?, id_veiculo = ?, id_motorista = ? WHERE id_diaria=?";
		try {
			PreparedStatement statement = (PreparedStatement) this.conexao.getConexao().prepareStatement(sqlUpdate);
			statement.setString(1, diaria.getHoraInicial());
			statement.setString(2, diaria.getHoraFinal());
			statement.setString(3, diaria.getDia());
			statement.setFloat(4, diaria.getComissao());
			statement.setFloat(5, diaria.getKmInicial());
			statement.setFloat(6, diaria.getKmFinal());
			statement.setFloat(7, diaria.getPrecoKm());
			statement.setFloat(8, diaria.getCombustivel());
			statement.setLong(9, diaria.getProprietario().getIdProprietario());
			statement.setLong(10, diaria.getVeiculo().getIdVeiculo());
			statement.setLong(11, diaria.getMotorista().getIdMotorista());
			statement.setLong(12, diaria.getIdDiaria());
			int linhasAfetadas = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return diaria;
	}

	public boolean excluir(long idDiaria) {
		this.conexao.abrirConexao();
		String sqlExcluir = "DELETE FROM diaria WHERE id_diaria=?";
		try {
			PreparedStatement statement = (PreparedStatement) this.conexao.getConexao().prepareStatement(sqlExcluir);
			statement.setLong(1, idDiaria);
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

	public Diaria buscar(long idDiaria) {
		this.conexao.abrirConexao();
		String sqlUpdate = "select * from diaria where id_diaria = ?";
		Diaria diaria = null;
		try {
			PreparedStatement statement = (PreparedStatement) this.conexao.getConexao().prepareStatement(sqlUpdate);
			statement.setLong(1, idDiaria);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				idDiaria = rs.getLong("id_diaria");
				String horaInicial = rs.getString("hora_inicial");
				String horaFinal = rs.getString("hora_final");
				String dia = rs.getString("dia");
				float comissao = rs.getFloat("comissao");
				float kmInicial = rs.getFloat("km_inicial");
				float kmFinal = rs.getFloat("km_final");
				float precoKm = rs.getFloat("preco_km");
				float combustivel = rs.getFloat("combustivel");
				diaria = new Diaria();
				diaria.setIdDiaria(idDiaria);
				diaria.setHoraInicial(horaInicial);
				diaria.setHoraFinal(horaFinal);
				diaria.setDia(dia);
				diaria.setComissao(comissao);
				diaria.setKmInicial(kmInicial);
				diaria.setKmFinal(kmFinal);
				diaria.setPrecoKm(precoKm);
				diaria.setCombustivel(combustivel);

				ProprietarioDAO pDAO = new ProprietarioDAO();
				Proprietario p = pDAO.buscar(rs.getLong("id_proprietario"));
				diaria.setProprietario(p);

				VeiculoDAO vDAO = new VeiculoDAO();
				Veiculo v = vDAO.buscar(rs.getLong("id_veiculo"));
				diaria.setVeiculo(v);

				MotoristaDAO mDAO = new MotoristaDAO();
				Motorista m = mDAO.buscar(rs.getLong("id_motorista"));
				diaria.setMotorista(m);

				GastoDAO gDAO = new GastoDAO();
				List<Gasto> listaGastos = gDAO.buscaGastosPorIdDiaria(rs.getLong("id_diaria"));
				diaria.setVetorGasto(listaGastos);

				CorridaDAO cDAO = new CorridaDAO();
				List<Corrida> listaCorrida = cDAO.buscaCorridaPorIdDiaria(rs.getLong("id_diaria"));
				diaria.setVetorCorrida(listaCorrida);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return diaria;
	}

	public List<Diaria> listar() {
		List<Diaria> listaDiaria = new ArrayList();
		this.conexao.abrirConexao();
		String sqlUpdate = "select * from diaria";
		try {
			PreparedStatement statement = (PreparedStatement) this.conexao.getConexao().prepareStatement(sqlUpdate);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				int idDiaria = rs.getInt("id_diaria");
				String horaInicial = rs.getString("hora_inicial");
				String horaFinal = rs.getString("hora_final");
				String dia = rs.getString("dia");
				float comissao = rs.getFloat("comissao");
				float kmInicial = rs.getFloat("km_inicial");
				float kmFinal = rs.getFloat("km_final");
				float precoKm = rs.getFloat("preco_km");
				float combustivel = rs.getFloat("combustivel");
				Diaria diaria = new Diaria();
				diaria.setIdDiaria(idDiaria);
				diaria.setHoraInicial(horaInicial);
				diaria.setHoraFinal(horaFinal);
				diaria.setDia(dia);
				diaria.setComissao(comissao);
				diaria.setKmInicial(kmInicial);
				diaria.setKmFinal(kmFinal);
				diaria.setPrecoKm(precoKm);
				diaria.setCombustivel(combustivel);

				ProprietarioDAO pDAO = new ProprietarioDAO();
				Proprietario p = pDAO.buscar(rs.getLong("id_proprietario"));
				diaria.setProprietario(p);

				VeiculoDAO vDAO = new VeiculoDAO();
				Veiculo v = vDAO.buscar(rs.getLong("id_veiculo"));
				diaria.setVeiculo(v);

				MotoristaDAO mDAO = new MotoristaDAO();
				Motorista m = mDAO.buscar(rs.getLong("id_motorista"));
				diaria.setMotorista(m);

				GastoDAO gDAO = new GastoDAO();
				List<Gasto> listaGastos = gDAO.buscaGastosPorIdDiaria(rs.getLong("id_diaria"));
				diaria.setVetorGasto(listaGastos);

				CorridaDAO cDAO = new CorridaDAO();
				List<Corrida> listaCorrida = cDAO.buscaCorridaPorIdDiaria(rs.getLong("id_diaria"));
				diaria.setVetorCorrida(listaCorrida);

				listaDiaria.add(diaria);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return listaDiaria;
	}

	public List<Diaria> buscarDiariaPorIdMotorista(long idMotorista) {
		List<Diaria> listaDiaria = new ArrayList();
		this.conexao.abrirConexao();
		String sqlUpdate = "select * from diaria WHERE id_motorista = ?";
		try {
			PreparedStatement statement = (PreparedStatement) this.conexao.getConexao().prepareStatement(sqlUpdate);
			statement.setLong(1, idMotorista);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				int idDiaria = rs.getInt("id_diaria");
				String horaInicial = rs.getString("hora_inicial");
				String horaFinal = rs.getString("hora_final");
				String dia = rs.getString("dia");
				float comissao = rs.getFloat("comissao");
				float kmInicial = rs.getFloat("km_inicial");
				float kmFinal = rs.getFloat("km_final");
				float precoKm = rs.getFloat("preco_km");
				float combustivel = rs.getFloat("combustivel");
				Diaria diaria = new Diaria();
				diaria.setIdDiaria(idDiaria);
				diaria.setHoraInicial(horaInicial);
				diaria.setHoraFinal(horaFinal);
				diaria.setDia(dia);
				diaria.setComissao(comissao);
				diaria.setKmInicial(kmInicial);
				diaria.setKmFinal(kmFinal);
				diaria.setPrecoKm(precoKm);
				diaria.setCombustivel(combustivel);

				GastoDAO gDAO = new GastoDAO();
				List<Gasto> listaGastos = gDAO.buscaGastosPorIdDiaria(rs.getLong("id_diaria"));
				diaria.setVetorGasto(listaGastos);

				CorridaDAO cDAO = new CorridaDAO();
				List<Corrida> listaCorrida = cDAO.buscaCorridaPorIdDiaria(rs.getLong("id_diaria"));
				diaria.setVetorCorrida(listaCorrida);

//				ProprietarioDAO pDAO = new ProprietarioDAO();
//				Proprietario p = pDAO.buscar(rs.getLong("id_proprietario"));
//				diaria.setProprietario(p);

//				VeiculoDAO vDAO = new VeiculoDAO();
//				Veiculo v = vDAO.buscar(rs.getLong("id_veiculo"));
//				diaria.setVeiculo(v);
//
//				MotoristaDAO mDAO = new MotoristaDAO();
//				Motorista m = mDAO.buscar(rs.getLong("id_motorista"));
//				diaria.setMotorista(m);

				listaDiaria.add(diaria);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return listaDiaria;
	}

	public List<Diaria> buscarDiariaPorIdProprietario(long idProprietario) {
		List<Diaria> listaDiaria = new ArrayList();
		this.conexao.abrirConexao();
		String sqlUpdate = "select * from diaria WHERE id_proprietario = ?";
		try {
			PreparedStatement statement = (PreparedStatement) this.conexao.getConexao().prepareStatement(sqlUpdate);
			statement.setLong(1, idProprietario);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				int idDiaria = rs.getInt("id_diaria");
				String horaInicial = rs.getString("hora_inicial");
				String horaFinal = rs.getString("hora_final");
				String dia = rs.getString("dia");
				float comissao = rs.getFloat("comissao");
				float kmInicial = rs.getFloat("km_inicial");
				float kmFinal = rs.getFloat("km_final");
				float precoKm = rs.getFloat("preco_km");
				float combustivel = rs.getFloat("combustivel");
				Diaria diaria = new Diaria();
				diaria.setIdDiaria(idDiaria);
				diaria.setHoraInicial(horaInicial);
				diaria.setHoraFinal(horaFinal);
				diaria.setDia(dia);
				diaria.setComissao(comissao);
				diaria.setKmInicial(kmInicial);
				diaria.setKmFinal(kmFinal);
				diaria.setPrecoKm(precoKm);
				diaria.setCombustivel(combustivel);

//				ProprietarioDAO pDAO = new ProprietarioDAO();
//				Proprietario p = pDAO.buscar(rs.getLong("id_proprietario"));
//				diaria.setProprietario(p);

//				VeiculoDAO vDAO = new VeiculoDAO();
//				Veiculo v = vDAO.buscar(rs.getLong("id_veiculo"));
//				diaria.setVeiculo(v);
//
//				MotoristaDAO mDAO = new MotoristaDAO();
//				Motorista m = mDAO.buscar(rs.getLong("id_motorista"));
//				diaria.setMotorista(m);

				GastoDAO gDAO = new GastoDAO();

				List<Gasto> listaGastos = gDAO.buscaGastosPorIdDiaria(rs.getLong("id_diaria"));
				diaria.setVetorGasto(listaGastos);

				CorridaDAO cDAO = new CorridaDAO();

				List<Corrida> listaCorrida = cDAO.buscaCorridaPorIdDiaria(rs.getLong("id_diaria"));
				diaria.setVetorCorrida(listaCorrida);

				listaDiaria.add(diaria);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return listaDiaria;
	}

	public List<Diaria> buscarDiariaPorIdVeiculo(long idVeiculo) {
		List<Diaria> listaDiaria = new ArrayList();
		this.conexao.abrirConexao();
		String sqlUpdate = "select * from diaria WHERE id_veiculo = ?";
		try {
			PreparedStatement statement = (PreparedStatement) this.conexao.getConexao().prepareStatement(sqlUpdate);
			statement.setLong(1, idVeiculo);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				int idDiaria = rs.getInt("id_diaria");
				String horaInicial = rs.getString("hora_inicial");
				String horaFinal = rs.getString("hora_final");
				String dia = rs.getString("dia");
				float comissao = rs.getFloat("comissao");
				float kmInicial = rs.getFloat("km_inicial");
				float kmFinal = rs.getFloat("km_final");
				float precoKm = rs.getFloat("preco_km");
				float combustivel = rs.getFloat("combustivel");
				Diaria diaria = new Diaria();
				diaria.setIdDiaria(idDiaria);
				diaria.setHoraInicial(horaInicial);
				diaria.setHoraFinal(horaFinal);
				diaria.setDia(dia);
				diaria.setComissao(comissao);
				diaria.setKmInicial(kmInicial);
				diaria.setKmFinal(kmFinal);
				diaria.setPrecoKm(precoKm);
				diaria.setCombustivel(combustivel);

				GastoDAO gDAO = new GastoDAO();
				List<Gasto> listaGastos = gDAO.buscaGastosPorIdDiaria(rs.getLong("id_diaria"));
				diaria.setVetorGasto(listaGastos);

				CorridaDAO cDAO = new CorridaDAO();
				List<Corrida> listaCorrida = cDAO.buscaCorridaPorIdDiaria(rs.getLong("id_diaria"));
				diaria.setVetorCorrida(listaCorrida);

//				ProprietarioDAO pDAO = new ProprietarioDAO();
//				Proprietario p = pDAO.buscar(rs.getLong("id_proprietario"));
//				diaria.setProprietario(p);

//				VeiculoDAO vDAO = new VeiculoDAO();
//				Veiculo v = vDAO.buscar(rs.getLong("id_veiculo"));
//				diaria.setVeiculo(v);
//
//				MotoristaDAO mDAO = new MotoristaDAO();
//				Motorista m = mDAO.buscar(rs.getLong("id_motorista"));
//				diaria.setMotorista(m);

				listaDiaria.add(diaria);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return listaDiaria;
	}

}
