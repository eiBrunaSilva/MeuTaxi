package exemplo.persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exemplo.model.Diaria;
import exemplo.model.Gasto;

public class GastoDAO {

	private ConexaoMysql conexao;

	public GastoDAO() {
		super();
		this.conexao = ConexaoMysql.getInstance();
	}

	public Gasto salvar(Gasto gasto) {
		this.conexao.abrirConexao();
		String sqlInsert = "INSERT INTO gasto VALUES(null,?,?,?)";
		try {
			PreparedStatement statement = (PreparedStatement) this.conexao.getConexao().prepareStatement(sqlInsert,
					PreparedStatement.RETURN_GENERATED_KEYS);
			statement.setString(1, gasto.getDescricao());
			statement.setFloat(2, gasto.getValor());
			statement.setLong(3, gasto.getDiaria().getIdDiaria());
			statement.executeUpdate();
			ResultSet rs = statement.getGeneratedKeys();
			if (rs.next()) {
				long idGasto = rs.getLong(1);
				gasto.setIdGasto(idGasto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return gasto;
	}

	public Gasto editar(Gasto gasto) {
		this.conexao.abrirConexao();
		String sqlUpdate = "UPDATE gasto SET descricao=?, valor=?, id_diaria = ? WHERE id_gasto=?";
		try {
			PreparedStatement statement = (PreparedStatement) this.conexao.getConexao().prepareStatement(sqlUpdate);
			statement.setString(1, gasto.getDescricao());
			statement.setFloat(2, gasto.getValor());
			statement.setLong(3, gasto.getDiaria().getIdDiaria());
			statement.setLong(4, gasto.getIdGasto());
			int linhasAfetadas = statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return gasto;
	}

	public boolean excluir(long idGasto) {
		this.conexao.abrirConexao();
		String sqlExcluir = "DELETE FROM gasto WHERE id_gasto =?";
		try {
			PreparedStatement statement = (PreparedStatement) this.conexao.getConexao().prepareStatement(sqlExcluir);
			statement.setLong(1, idGasto);
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

	public Gasto buscar(long idGasto) {
		this.conexao.abrirConexao();
		String sqlUpdate = "select * from gasto where id_gasto = ?";
		Gasto gasto = null;
		try {
			PreparedStatement statement = (PreparedStatement) this.conexao.getConexao().prepareStatement(sqlUpdate);
			statement.setLong(1, idGasto);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				gasto = new Gasto();
				idGasto = rs.getLong("id_gasto");
				String descricao = rs.getString("descricao");
				float valor = rs.getFloat("valor");
				gasto.setIdGasto(idGasto);
				gasto.setDescricao(descricao);
				gasto.setValor(valor);

				DiariaDAO dDAO = new DiariaDAO();
				Diaria d = dDAO.buscar(rs.getLong("id_diaria"));
				gasto.setDiaria(d);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return gasto;
	}

	public List<Gasto> listar() {
		List<Gasto> listaGasto = new ArrayList();
		this.conexao.abrirConexao();
		String sqlUpdate = "select * from gasto";
		try {
			PreparedStatement statement = (PreparedStatement) this.conexao.getConexao().prepareStatement(sqlUpdate);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				long idGasto = rs.getLong("id_gasto");
				String descricao = rs.getString("descricao");

				float valor = rs.getFloat("valor");
				Gasto gasto = new Gasto();
				gasto.setIdGasto(idGasto);
				gasto.setDescricao(descricao);
				gasto.setValor(valor);

				DiariaDAO dDAO = new DiariaDAO();
				Diaria d = dDAO.buscar(rs.getLong("id_Diaria"));
				gasto.setDiaria(d);

				listaGasto.add(gasto);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return listaGasto;
	}

	public List<Gasto> buscaGastosPorIdDiaria(long idDiaria) {
		List<Gasto> listaGasto = new ArrayList();
		this.conexao.abrirConexao();
		String sqlUpdate = "select * from gasto WHERE id_diaria=?";
		try {
			PreparedStatement statement = (PreparedStatement) this.conexao.getConexao().prepareStatement(sqlUpdate);
			statement.setLong(1, idDiaria);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				long idGasto = rs.getLong("id_gasto");
				String descricao = rs.getString("descricao");

				float valor = rs.getFloat("valor");
				Gasto gasto = new Gasto();
				gasto.setIdGasto(idGasto);
				gasto.setDescricao(descricao);
				gasto.setValor(valor);

//				DiariaDAO dDAO = new DiariaDAO();
//				Diaria d = dDAO.buscar(rs.getLong("id_Diaria"));
//				gasto.setDiaria(d);

				listaGasto.add(gasto);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return listaGasto;
	}

}
