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
					.prepareStatement("INSERT INTO encomenda (descricao, data, veiculo_id_veiculo, criadoPor, transportadoPor, guia) values (?, ?, ?, ?, ?, ?)");

			pstmt.setString(1, encomenda.getDescricao());
			pstmt.setDate(2, new java.sql.Date(new Date().getTime()));
			pstmt.setInt(3, encomenda.getVeiculo().getId_veiculo());
			pstmt.setString(4, encomenda.getCriadoPor());
			pstmt.setString(5, encomenda.getTransportadoPor());
			pstmt.setBlob(6, encomenda.getGuia());


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
					"UPDATE encomenda SET descricao=?, veiculo_id_veiculo=?, criadoPor=?, transportadoPor=?, guia=?  WHERE id_encomenda="
							+ encomenda.getId_encomenda());

			pstmt.setString(1, encomenda.getDescricao());
			pstmt.setInt(2, encomenda.getVeiculo().getId_veiculo());
			pstmt.setString(3, encomenda.getCriadoPor());
			pstmt.setString(4, encomenda.getTransportadoPor());
			pstmt.setBlob(55, encomenda.getGuia());

			pstmt.executeUpdate();

			pstmt.close();
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();

		}

	}
	// ------------------------------------------------------------------------------------------------------------------------------
		// MÉTODO PARA VALIDAR ENTREGA DE ENCOMENDAS NA BASE DE DADOS!
		public void entrgarEncomenda(Encomenda encomenda) {
			Connection connection = ConnectionFactory.getConnection();

			try {
				PreparedStatement pstmt = connection.prepareStatement(
						"UPDATE encomenda SET status=?, dataEntrega=?, comentario=?, recebidoPor=? WHERE id_encomenda="
								+ encomenda.getId_encomenda());

				pstmt.setString(1, encomenda.getStatus());
				pstmt.setDate(2, new java.sql.Date(new Date().getTime()));
				pstmt.setString(3, encomenda.getComentario());
				pstmt.setString(4, encomenda.getRecebidoPor());

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
					"SELECT e.*, v.* FROM sgtm_dpmz.encomenda e INNER JOIN sgtm_dpmz.veiculo v ON e.veiculo_id_veiculo = v.id_veiculo ORDER BY e.data DESC");

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
				encomenda.setData(rs.getDate("e.data"));
				encomenda.setStatus(rs.getString("e.status"));
				encomenda.setComentario(rs.getString("e.comentario"));
				encomenda.setDataEntrega(rs.getDate("e.dataEntrega"));
				encomenda.setCriadoPor(rs.getString("e.criadoPor"));
				encomenda.setTransportadoPor(rs.getString("e.transportadoPor"));
				encomenda.setRecebidoPor(rs.getString("e.recebidoPor"));
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
		// MÉTODO PARA LISTAR TODOS ENCOMENDAS NA BASE DE DADOS!
		public List<Encomenda> buscarEncaomenda( int id_encomenda) {
			List<Encomenda> listaDeEncomendas = new ArrayList<>();
			Connection connection = ConnectionFactory.getConnection();

			try {
				Statement statement = connection.createStatement();
				statement.execute(
						"SELECT e.*, v.* FROM sgtm_dpmz.encomenda e INNER JOIN sgtm_dpmz.veiculo v ON e.veiculo_id_veiculo = v.id_veiculo WHERE id_encomenda = '"+id_encomenda+"'ORDER BY e.data DESC");

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
					encomenda.setData(rs.getDate("e.data"));
					encomenda.setStatus(rs.getString("e.status"));
					encomenda.setComentario(rs.getString("e.comentario"));
					encomenda.setDataEntrega(rs.getDate("e.dataEntrega"));
					encomenda.setCriadoPor(rs.getString("e.criadoPor"));
					encomenda.setTransportadoPor(rs.getString("e.transportadoPor"));
					encomenda.setRecebidoPor(rs.getString("e.recebidoPor"));
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
		// MÉTODO PARA LISTAR TODOS ENCOMENDAS POR DATA NA BASE DE DADOS!
		public List<Encomenda> listarEncomendaPorData(Date inicio, Date fim) {
			List<Encomenda> listaDeEncomendas = new ArrayList<>();
			Connection connection = ConnectionFactory.getConnection();

			try {
				Statement statement = connection.createStatement();
				statement.execute(
						"SELECT e.*, v.* FROM sgtm_dpmz.encomenda e INNER JOIN sgtm_dpmz.veiculo v ON e.veiculo_id_veiculo = v.id_veiculo WHERE  e.data BETWEEN '"+inicio+"' AND '"+fim+"' ORDER BY e.data DESC");

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
					encomenda.setData(rs.getDate("e.data"));
					encomenda.setStatus(rs.getString("e.status"));
					encomenda.setComentario(rs.getString("e.comentario"));
					encomenda.setDataEntrega(rs.getDate("e.dataEntrega"));
					encomenda.setCriadoPor(rs.getString("e.criadoPor"));
					encomenda.setTransportadoPor(rs.getString("e.transportadoPor"));
					encomenda.setRecebidoPor(rs.getString("e.recebidoPor"));
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
			statement.execute("SELECT * FROM encomenda WHERE id_encomenda="+id_encomenda);

			ResultSet rs = statement.getResultSet();
			
			while (rs.next()) {

				encomenda.setId_encomenda(rs.getInt("id_encomenda"));
				encomenda.setDescricao(rs.getString("descricao"));
				encomenda.setData(rs.getDate("data"));
				encomenda.setStatus(rs.getString("status"));
				encomenda.setComentario(rs.getString("comentario"));
				encomenda.setDataEntrega(rs.getDate("dataEntrega"));
				encomenda.setCriadoPor(rs.getString("criadoPor"));
				encomenda.setTransportadoPor(rs.getString("transportadoPor"));
				encomenda.setRecebidoPor(rs.getString("recebidoPor"));
				
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
