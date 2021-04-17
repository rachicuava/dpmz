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
import Model.Deposito;



public class DepositoService {
	//METODO PARA INSERIR DEPOSITOS DE MEDICAMENTOS NA BASE DADOS
	public void adicionarDeposito (Deposito deposito){
		Connection connection = ConnectionFactory.getConnection();
		
		try {
			PreparedStatement pstmt = connection
					.prepareStatement("INSERT INTO deposito (descricao, bairro, rua, email, telefone, longitude, latitude) values (?, ?, ?, ?, ?, ?, ?)");
			
			pstmt.setString(1, deposito.getDescricao());
			pstmt.setString(2, deposito.getBairro());
			pstmt.setString(3, deposito.getRua());
			pstmt.setString(4, deposito.getEmail());
			pstmt.setString(5, deposito.getTelefone());
			pstmt.setString(6, deposito.getLongitude());
			pstmt.setString(7, deposito.getLatitude());
					
			pstmt.executeUpdate();
			
			pstmt.close();
			connection.close();
			
								
		} catch (SQLException e) {
			e.printStackTrace();
			
		}

	}
	
	//-----------------------------------------------------------------------------------------------------------------------------------
		//MÉTODO PARA ACTUALIZAR DADOS DE DEPOSITOS NA BASE DE DADOS!
		public void actuaizarFuncionario (Deposito deposito){
			
			Connection connection = ConnectionFactory.getConnection();
						
					try {
						PreparedStatement pstmt = connection
								.prepareStatement("UPDATE deposito SET descricao=?, bairro=?, rua=?, email=?, telefone=?, longitude=?, latitude=? WHERE id_deposito="+deposito.getId_deposito());
						
						pstmt.setString(1, deposito.getDescricao());
						pstmt.setString(2, deposito.getBairro());
						pstmt.setString(3, deposito.getRua());
						pstmt.setString(4, deposito.getEmail());
						pstmt.setString(5, deposito.getTelefone());
						pstmt.setString(6, deposito.getLongitude());
						pstmt.setString(7, deposito.getLatitude());
											
						pstmt.executeUpdate();
						
						pstmt.close();
						connection.close();
						
											
					} catch (SQLException e) {
						e.printStackTrace();
						
					}
				
		}
		
		//------------------------------------------------------------------------------------------------------------------------------
		// MÉTODO PARA LISTAR TODOS DEPOSITOS DE DE MEDICAMENTOS NA BASE DE DADOS!
		public List<Deposito> listarDepositos(){
			List<Deposito> listaDeDepositos = new ArrayList<>();
			Connection  connection = ConnectionFactory.getConnection();
			try {
				Statement statement = connection.createStatement();
				statement.execute("SELECT * FROM deposito");
				
				ResultSet rs = statement.getResultSet();
				
				while (rs.next()){
					Deposito deposito = new Deposito();
					
					deposito.setId_deposito(rs.getInt("id_deposito"));
					deposito.setDescricao(rs.getString("descricao"));
					deposito.setBairro(rs.getString("bairro"));
					deposito.setRua(rs.getString("rua"));
					deposito.setEmail(rs.getString("email"));
					deposito.setTelefone(rs.getString("telefone"));
					deposito.setLatitude(rs.getString("latitude"));
					deposito.setLongitude(rs.getString("longitude"));
										
					listaDeDepositos.add(deposito);
					
				}
				
				rs.close();
				statement.close();
				connection.close();
				return listaDeDepositos;
				
			} catch (Exception e) {
				e.printStackTrace();
			}
				
			return null;
		}
		
		
		//-------------------------------------------------------------------------------------------------------------------------
		// MÉTODO PARA APAGAR DEPOSTOS DE MEDICAMENTOS NA BASE DE DADOS!
		public void apagarDeposito (int id_deposito){
			Connection connection = ConnectionFactory.getConnection();
			
			try {
				PreparedStatement pstmt = connection
						.prepareStatement("DELETE FROM deposito WHERE id_deposito="+id_deposito);
				
				pstmt.executeUpdate();
				
				pstmt.close();
				connection.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		//------------------------------------------------------------------------------------------------------------------------
		// MÉTODO PARA BUSCAR DEPOSITO POR ID NA BASE DE DADOS!
		
		public Deposito buscarDepositoPorId (int id_deposito){
			Connection  connection = ConnectionFactory.getConnection();
			
			try {
				Statement statement = connection.createStatement();
				statement.execute("SELECT * FROM deposito");
				
				ResultSet rs = statement.getResultSet();
				
				while (rs.next()){
					Deposito deposito = new Deposito();
					
					deposito.setId_deposito(rs.getInt("id_deposito"));
					deposito.setDescricao(rs.getString("descricao"));
					deposito.setBairro(rs.getString("bairro"));
					deposito.setRua(rs.getString("rua"));
					deposito.setEmail(rs.getString("email"));
					deposito.setTelefone(rs.getString("telefone"));
					deposito.setLatitude(rs.getString("latitude"));
					deposito.setLongitude(rs.getString("longitude"));
																					
					rs.close();
					statement.close();
					connection.close();
					
					return deposito;
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
				
			return null;
			
		}

}
