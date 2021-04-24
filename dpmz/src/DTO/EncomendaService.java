package DTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import DAO.ConnectionFactory;
import Model.Encomenda;
import Model.Veiculo;

public class EncomendaService {

	// METODO PARA INSERIR ENCOMENDAS DE MEDICAMENTOS NA BASE DADOS
	public void adicionarEncomenda(Encomenda encomenda) {
		Connection connection = ConnectionFactory.getConnection();

		try {
			PreparedStatement pstmt = connection
					.prepareStatement("INSERT INTO encomenda (descricao, data, veiculo_id_veiculo) values (?, ?, ?)");

			pstmt.setString(1, encomenda.getDescricao());
			pstmt.setDate(2, new java.sql.Date(new Date().getTime()));
			pstmt.setInt(3, encomenda.getVeiculo().getId_veiculo());

			pstmt.executeUpdate();

			pstmt.close();
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();

		}

	}

	// ------------------------------------------------------------------------------------------------------------------------------
	// MÉTODO PARA EDITAR DADOS DE ENCOMENDAS NA BASE DE DADOS!
	public void actualizarEncomenda(Encomenda encomenda) {
		Connection connection = ConnectionFactory.getConnection();

		try {
			PreparedStatement pstmt = connection.prepareStatement(
					"UPDATE encomenda SET descricao=?, data=?, veiculo_id_veiculo=?  WHERE id_deposito="
							+ encomenda.getId_encomenda());

			pstmt.setString(1, encomenda.getDescricao());
			pstmt.setDate(2, new java.sql.Date(new Date().getTime()));
			pstmt.setInt(3, encomenda.getVeiculo().getId_veiculo());

			pstmt.executeUpdate();

			pstmt.close();
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();

		}

	}

	// ------------------------------------------------------------------------------------------------------------------------------
	// MÉTODO PARA LISTAR TODOS ENCOMENDAS NA BASE DE DADOS!
	public List<Encomenda> listarEncomenda() {
		List<Encomenda> listaDeEncomendas = new ArrayList<>();
		Connection connection = ConnectionFactory.getConnection();

		try {
			Statement statement = connection.createStatement();
			statement.execute(
					"SELECT e.id_encomenda, e.descricao, v.id_veiculo, v.modelo, v.fabricante, v.ano_fabrico, v.tipo, v.capacidade, v.matricula FROM sgtm_dpmz.encomenda e INNER JOIN sgtm_dpmz.veiculo v ON e.veiculo_id_veiculo = v.id_veiculo");

			ResultSet rs = statement.getResultSet();

			while (rs.next()) {

				Veiculo veiculo = new Veiculo();
				veiculo.setId_veiculo(rs.getInt("v.id_veiculo"));
				veiculo.setModelo(rs.getString("v.modelo"));
				veiculo.setFabricante(rs.getString("v.fabricante"));
				veiculo.setAno_fabrico(rs.getInt("v.ano_fabrico"));
				veiculo.setTipo(rs.getString("tipo"));
				veiculo.setCapacidade(rs.getString("v.capacidade"));
				veiculo.setMatricula(rs.getString("v.matricula"));

				Encomenda encomenda = new Encomenda();
				encomenda.setId_encomenda(rs.getInt("e.id_encomenda"));
				encomenda.setDescricao(rs.getString("e.descricao"));
				encomenda.setVeiculo(veiculo);

				listaDeEncomendas.add(encomenda);
			}

			rs.close();
			statement.close();
			connection.close();

			return listaDeEncomendas;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	// ------------------------------------------------------------------------------------------------------------------------------
	// MÉTODO PARA EXCLUIR TODOS ENCOMENDAS NA BASE DE DADOS!
	public void apagarEcomenda(int id_encomenda) {
		Connection connection = ConnectionFactory.getConnection();

		try {
			PreparedStatement pstmt = connection
					.prepareStatement("DELETE FROM encomenda WHERE id_encomenda =" + id_encomenda);

			pstmt.executeUpdate();

			pstmt.close();
			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ------------------------------------------------------------------------------------------------------------------------
	// MÉTODO PARA BUSCAR VEICULO POR ID NA BASE DE DADOS!

	public Encomenda buscarEncomenda(int id_encomenda) {
		Connection connection = ConnectionFactory.getConnection();
		Encomenda encomenda = new Encomenda();

		try {
			Statement statement = connection.createStatement();
			statement.execute("SELECT * FROM encomenda WHERE id_encomenda=" + id_encomenda);

			ResultSet rs = statement.getResultSet();
			
			while (rs.next()) {

				Veiculo veiculo = new Veiculo();
				veiculo.setId_veiculo(rs.getInt("v.id_veiculo"));
				veiculo.setModelo(rs.getString("v.modelo"));
				veiculo.setFabricante(rs.getString("v.fabricante"));
				veiculo.setAno_fabrico(rs.getInt("v.ano_fabrico"));
				veiculo.setTipo(rs.getString("tipo"));
				veiculo.setCapacidade(rs.getString("v.capacidade"));
				veiculo.setMatricula(rs.getString("v.matricula"));

				encomenda.setId_encomenda(rs.getInt("e.id_encomenda"));
				encomenda.setDescricao(rs.getString("e.descricao"));
				encomenda.setVeiculo(veiculo);


			}

			rs.close();
			statement.close();
			connection.close();

			return encomenda;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}

}
