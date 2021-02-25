package exemplo.persistencia;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import exemplo.model.*;

public class CorridaDAO {

	private ConexaoMysql conexao;

	public CorridaDAO() {
		super();
		this.conexao = ConexaoMysql.getInstance();
	}

	public Corrida salvar(Corrida corrida) {
		this.conexao.abrirConexao();
		String sqlInsert = "INSERT INTO corrida VALUES(null,?,?,?,?,?)";
		try {
			PreparedStatement statement = (PreparedStatement) this.conexao.getConexao().prepareStatement(sqlInsert,
					PreparedStatement.RETURN_GENERATED_KEYS);
			statement.setString(1, corrida.getHoraInicial());
			statement.setString(2, corrida.getHoraFinal());
			statement.setFloat(3, corrida.getPreco());
			statement.setBoolean(4, corrida.getCartao());
			statement.setLong(5, corrida.getDiaria().getIdDiaria());
			statement.executeUpdate();
			ResultSet rs = statement.getGeneratedKeys();
			if (rs.next()) {
				long idCorrida = rs.getLong(1);
				corrida.setIdCorrida(idCorrida);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return corrida;
	}

	public Corrida editar(Corrida corrida) {
		this.conexao.abrirConexao();
		String sqlUpdate = "UPDATE corrida SET hora_inicial=?, hora_final=?, preco=?, cartao=?, id_diaria=? WHERE id_corrida=?";
		try {
			PreparedStatement statement = (PreparedStatement) this.conexao.getConexao().prepareStatement(sqlUpdate);
			statement.setString(1, corrida.getHoraInicial());
			statement.setString(2, corrida.getHoraFinal());
			statement.setFloat(3, corrida.getPreco());
			statement.setBoolean(4, corrida.getCartao());
			statement.setLong(5, corrida.getIdCorrida());
			statement.setLong(6, corrida.getDiaria().getIdDiaria());
			int linhasAfetadas = statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return corrida;
	}

	public boolean excluir(long idCorrida) {
		this.conexao.abrirConexao();
		String sqlExcluir = "DELETE FROM corrida WHERE id_corrida =?";
		try {
			PreparedStatement statement = (PreparedStatement) this.conexao.getConexao().prepareStatement(sqlExcluir);
			statement.setLong(1, idCorrida);
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

	public Corrida buscar(long idCorrida) {
		this.conexao.abrirConexao();
		String sqlUpdate = "select * from corrida where id_corrida = ?";
		Corrida corrida = null;
		try {

			PreparedStatement statement = (PreparedStatement) this.conexao.getConexao().prepareStatement(sqlUpdate);
			statement.setLong(1, idCorrida);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				corrida = new Corrida();
				idCorrida = rs.getInt("id_corrida");
				String horaInicial = rs.getString("hora_inicial");
				String horaFinal = rs.getString("hora_final");
				float preco = rs.getFloat("preco");
				boolean cartao = rs.getBoolean("cartao");
				corrida.setHoraInicial(horaInicial);
				corrida.setHoraFinal(horaFinal);
				corrida.setPreco(preco);
				corrida.setCartao(cartao);

				DiariaDAO dDAO = new DiariaDAO();
				Diaria d = dDAO.buscar(rs.getLong("id_diaria"));
				corrida.setDiaria(d);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return corrida;
	}

	public List<Corrida> listar() {
		List<Corrida> listaCorrida = new ArrayList();
		this.conexao.abrirConexao();
		String sqlUpdate = "select * from corrida";
		try {
			PreparedStatement statement = (PreparedStatement) this.conexao.getConexao().prepareStatement(sqlUpdate);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				long idCorrida = rs.getLong("id_corrida");
				String horaInicial = rs.getString("hora_inicial");
				String horaFinal = rs.getString("hora_final");
				float preco = rs.getFloat("preco");
				boolean cartao = rs.getBoolean("cartao");
				Corrida corrida = new Corrida();
				corrida.setIdCorrida(idCorrida);
				corrida.setHoraInicial(horaInicial);
				corrida.setHoraFinal(horaFinal);
				corrida.setPreco(preco);
				corrida.setCartao(cartao);

				DiariaDAO dDAO = new DiariaDAO();
				Diaria d = dDAO.buscar(rs.getLong("id_diaria"));
				corrida.setDiaria(d);

				listaCorrida.add(corrida);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return listaCorrida;
	}

	public List<Corrida> buscaCorridaPorIdDiaria(long idDiaria) {
		List<Corrida> listaCorrida = new ArrayList();
		this.conexao.abrirConexao();
		String sqlUpdate = "select * from corrida WHERE id_diaria=?";
		try {
			PreparedStatement statement = (PreparedStatement) this.conexao.getConexao().prepareStatement(sqlUpdate);
			statement.setLong(1, idDiaria);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Corrida corrida = new Corrida();
				long idCorrida = rs.getLong("id_corrida");
				String horaInicial = rs.getString("hora_inicial");
				String horaFinal = rs.getString("hora_inicial");
				float preco = rs.getFloat("preco");
				boolean cartao = rs.getBoolean("cartao");
				corrida.setIdCorrida(idCorrida);
				corrida.setHoraInicial(horaInicial);
				corrida.setHoraFinal(horaFinal);
				corrida.setPreco(preco);
				corrida.setCartao(cartao);

				DiariaDAO dDAO = new DiariaDAO();
				Diaria d = dDAO.buscar(rs.getLong("id_Diaria"));
				corrida.setDiaria(d);

				listaCorrida.add(corrida);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return listaCorrida;
	}

}
