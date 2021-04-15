package DTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
					.prepareStatement("INSERT INTO deposito (nome, latitude, longitude, actualizado_em) values (?, ?, ?, ?)");
			
			pstmt.setString(1, deposito.getNome());
			pstmt.setString(2, deposito.getLatitude());
			pstmt.setString(3, deposito.getLongitude());
			Date data = new Date();
			java.sql.Timestamp  timeStamp = new java.sql.Timestamp(data.getTime());
			pstmt.setTimestamp(4, timeStamp);
			
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
								.prepareStatement("UPDATE deposito SET nome=?, latitude=?,longitude=?,latitude=?, actualizado_em=? WHERE id_funcionario="+deposito.getId_deposito());
						
						pstmt.setString(1, deposito.getNome());
						pstmt.setString(2, deposito.getLatitude());
						pstmt.setString(3, deposito.getLongitude());
						
						Date data = new Date();
						java.sql.Timestamp  timeStamp = new java.sql.Timestamp(data.getTime());
						pstmt.setTimestamp(9, timeStamp);
						pstmt.setInt(10, deposito.getId_deposito());
						
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
				PreparedStatement pstmt = connection
						.prepareStatement("SELECT * FROM deposito");
				
				ResultSet rs = pstmt.getResultSet();
				
				while (rs.next()){
					Deposito deposito = new Deposito();
					
					deposito.setNome(rs.getString("nome"));
					deposito.setLatitude(rs.getString("latitude"));
					deposito.setLongitude(rs.getString("longitude"));
										
					listaDeDepositos.add(deposito);
					
					rs.close();
					pstmt.close();
					connection.close();
					
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
				
			return listaDeDepositos;
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
		// MÉTODO PARA BUSCAR FUNCIONARIO POR ID NA BASE DE DADOS!
		
		public Deposito buscarDepositoPorId (int id_deposito){
			Connection  connection = ConnectionFactory.getConnection();
			
			try {
				PreparedStatement pstmt = connection
						.prepareStatement("SELECT * FROM deposito WHERE id_deposito="+id_deposito);
				
				ResultSet rs = pstmt.getResultSet();
				
				while (rs.next()){
					Deposito deposito = new Deposito();
					
					deposito.setNome(rs.getString("nome"));
					deposito.setLatitude(rs.getString("latitude"));
					deposito.setLongitude(rs.getString("longitude"));
																					
					rs.close();
					pstmt.close();
					connection.close();
					
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
				
			return null;
			
		}

}
