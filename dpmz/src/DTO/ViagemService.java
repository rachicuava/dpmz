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
import Model.Motorista;
import Model.Veiculo;
import Model.Viagem;

public class ViagemService {

	// METODO PARA INSERIR VIAGENS  NA BASE DADOS
	public void adicionarViagem(Viagem viagem) {
		Connection connection = ConnectionFactory.getConnection();

		try {
			PreparedStatement pstmt = connection
					.prepareStatement("INSERT INTO viagem (descricao, data, origem, destino, veiculo_id_veiculo, motorista_id_motorista) values (?, ?, ?, ?, ?, ?)");

			pstmt.setString(1, viagem.getDescricao());
			pstmt.setDate(2, new java.sql.Date(new Date().getTime()));
			pstmt.setString(3, viagem.getOrigem());
			pstmt.setString(4, viagem.getDestino());
			pstmt.setInt(5, viagem.getVeiculo().getId_veiculo());
			pstmt.setInt(6, viagem.getMotorista().getId_motorista());

			pstmt.executeUpdate();

			pstmt.close();
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();

		}

	}

	// ------------------------------------------------------------------------------------------------------------------------------
	// MÉTODO PARA EDITAR ENCOMENDAS NA BASE DE DADOS!
	public void actualizarViagem(Viagem viagem) {
		Connection connection = ConnectionFactory.getConnection();

		try {
			PreparedStatement pstmt = connection.prepareStatement(
					"UPDATE viagem SET descricao=?, data=?, origem=?, destino=?,  veiculo_id_veiculo=?, motorista_id_motorista=?  WHERE id_viagem="
							+ viagem.getId_viagem());

			pstmt.setString(1, viagem.getDescricao());
			pstmt.setDate(2, new java.sql.Date(new Date().getTime()));
			pstmt.setString(3, viagem.getOrigem());
			pstmt.setString(4, viagem.getDestino());
			pstmt.setInt(5, viagem.getVeiculo().getId_veiculo());
			pstmt.setInt(6, viagem.getMotorista().getId_motorista());
			

			pstmt.executeUpdate();

			pstmt.close();
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();

		}

	}

	// ------------------------------------------------------------------------------------------------------------------------------
	// MÉTODO PARA LISTAR TODOS VIAGENS NA BASE DE DADOS!
	public List<Viagem> listarViagem() {
		List<Viagem> listaDeViagem = new ArrayList<>();
		Connection connection = ConnectionFactory.getConnection();

		try {
			Statement statement = connection.createStatement();
			statement.execute(
					"SELECT vg.id_viagem, vg.descricao,vg.origem, vg.destino, vg.data, v.id_veiculo, v.modelo, v.fabricante, v.ano_fabrico, v.tipo, v.capacidade, v.matricula, m.id_motorista, m.nome, m.apelido FROM sgtm_dpmz.viagem vg INNER JOIN sgtm_dpmz.veiculo v ON vg.veiculo_id_veiculo = v.id_veiculo INNER JOIN sgtm_dpmz.motorista m ON vg.motorista_id_motorista = m.id_motorista ORDER BY vg.data ASC");

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
				
				Motorista motorista = new Motorista();
				motorista.setId_motorista(rs.getInt("id_motorista"));
				motorista.setNome(rs.getString("nome"));
				motorista.setApelido(rs.getString("apelido"));

				Viagem viagem = new Viagem();
				viagem.setId_viagem(rs.getInt("vg.id_viagem"));
				viagem.setDescricao(rs.getString("vg.descricao"));
				viagem.setData(rs.getDate("vg.data"));
				viagem.setOrigem(rs.getString("vg.origem"));
				viagem.setDestino(rs.getString("vg.destino"));
				viagem.setVeiculo(veiculo);
				viagem.setMotorista(motorista);

				listaDeViagem.add(viagem);
			}

			rs.close();
			statement.close();
			connection.close();

			return listaDeViagem;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	// ------------------------------------------------------------------------------------------------------------------------------
		// MÉTODO PARA LISTAR TODOS VIAGENS NA BASE DE DADOS!
		public List<Viagem> listarViagemPordata(Date inicio, Date fim) {
			List<Viagem> listaDeViagem = new ArrayList<>();
			Connection connection = ConnectionFactory.getConnection();

			try {
				Statement statement = connection.createStatement();
				statement.execute(
						"SELECT vg.id_viagem, vg.descricao, vg.origem, vg.destino, vg.data, v.id_veiculo, v.modelo, v.fabricante, v.ano_fabrico, v.tipo, v.capacidade, v.matricula, m.id_motorista, m.nome, m.apelido FROM sgtm_dpmz.viagem vg INNER JOIN sgtm_dpmz.veiculo v ON vg.veiculo_id_veiculo = v.id_veiculo INNER JOIN sgtm_dpmz.motorista m ON vg.motorista_id_motorista = m.id_motorista WHERE vg.data  BETWEEN '"+inicio+"' AND '"+fim+"'ORDER BY vg.data ASC");

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
					
					Motorista motorista = new Motorista();
					motorista.setId_motorista(rs.getInt("id_motorista"));
					motorista.setNome(rs.getString("nome"));
					motorista.setApelido(rs.getString("apelido"));

					Viagem viagem = new Viagem();
					viagem.setId_viagem(rs.getInt("vg.id_viagem"));
					viagem.setDescricao(rs.getString("vg.descricao"));
					viagem.setData(rs.getDate("vg.data"));
					viagem.setOrigem(rs.getString("vg.origem"));
					viagem.setDestino(rs.getString("vg.destino"));
					viagem.setVeiculo(veiculo);
					viagem.setMotorista(motorista);

					listaDeViagem.add(viagem);
				}

				rs.close();
				statement.close();
				connection.close();

				return listaDeViagem;

			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;

		}

	// ------------------------------------------------------------------------------------------------------------------------------
	// MÉTODO PARA EXCLUIR TODOS ENCOMENDAS NA BASE DE DADOS!
	public void apagarViagem(int id_viagem) {
		Connection connection = ConnectionFactory.getConnection();

		try {
			PreparedStatement pstmt = connection
					.prepareStatement("DELETE FROM viagem WHERE id_viagem =" + id_viagem);

			pstmt.executeUpdate();

			pstmt.close();
			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ------------------------------------------------------------------------------------------------------------------------
	// MÉTODO PARA BUSCAR VEICULO POR ID NA BASE DE DADOS!

	public Viagem buscarViagem(int id_viagem) {
		Connection connection = ConnectionFactory.getConnection();
		Viagem viagem = new Viagem();

		try {
			Statement statement = connection.createStatement();
			statement.execute("SELECT * FROM viagem WHERE id_viagem=" + id_viagem);

			ResultSet rs = statement.getResultSet();
			
			while (rs.next()) {

				viagem.setId_viagem(rs.getInt("id_viagem"));
				viagem.setDescricao(rs.getString("descricao"));
				viagem.setOrigem(rs.getString("origem"));
				viagem.setDestino(rs.getString("destino"));
				
				
			}

			rs.close();
			statement.close();
			connection.close();

			return viagem;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}

}
