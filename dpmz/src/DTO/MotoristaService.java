package DTO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DAO.ConnectionFactory;
import Model.Funcionario;
import Model.Motorista;



public class MotoristaService {
	
	
	// MÉTODO PARA ADICIONAR NOVOS MOTORISTA NA BASE DE DADOS!
	public void adicionarMotorista (Motorista motorista){
		
		Connection connection = ConnectionFactory.getConnection();
					
				try {
					
					PreparedStatement pstmt = connection
							.prepareStatement("INSERT INTO motorista (nome, apelido, sexo, data_nascimento, email, telefone, distrito, bairro, rua) values (?, ?, ?, ?, ?, ?, ?, ?, ?)");
					
					pstmt.setString(1, motorista.getNome());
					pstmt.setString(2, motorista.getApelido());
					pstmt.setString(3, motorista.getSexo());
					pstmt.setDate(4, new java.sql.Date(motorista.getData_nascimento().getTime()));
					pstmt.setString(5, motorista.getEmail());
					pstmt.setString(6, motorista.getTelefone());
					pstmt.setString(7, motorista.getDistrito());
					pstmt.setString(8, motorista.getBairro());
					pstmt.setString(9, motorista.getRua());
					
					pstmt.executeUpdate();
					
					pstmt.close();
					connection.close();
					
										
				} catch (SQLException e) {
					e.printStackTrace();
					
				}
			
	}
	

	//-----------------------------------------------------------------------------------------------------------------------------------
	//MÉTODO PARA ACTUALIZAR DADOS DE FUNCIONARIO NA BASE DE DADOS!
	public void actualizarMotorista (Motorista motorista){
		
		Connection connection = ConnectionFactory.getConnection();
					
				try {
					PreparedStatement pstmt = connection
							.prepareStatement("UPDATE motorista SET nome=?, apelido=?, sexo=?, data_nascimento=?, email=?, telefone=?, distrito=?, bairro=?, rua=?  WHERE id_motorista="+motorista.getId_motorista());
					
					pstmt.setString(1, motorista.getNome());
					pstmt.setString(2, motorista.getApelido());
					pstmt.setString(3, motorista.getSexo());
					pstmt.setDate(4, new java.sql.Date(motorista.getData_nascimento().getTime()));
					pstmt.setString(5, motorista.getEmail());
					pstmt.setString(6, motorista.getTelefone());
					pstmt.setString(7, motorista.getDistrito());
					pstmt.setString(8, motorista.getBairro());
					pstmt.setString(9, motorista.getRua());
					
										
					pstmt.executeUpdate();
					
					pstmt.close();
					connection.close();
					
										
				} catch (SQLException e) {
					e.printStackTrace();
					
				}
			
			
	}
	
	
	
	//------------------------------------------------------------------------------------------------------------------------------
	// MÉTODO PARA LISTAR TODOS MOTORISTAS NA BASE DE DADOS!
	
	public List<Motorista> listarMotorista(){

		Connection connection = ConnectionFactory.getConnection();
		List<Motorista> listaDeMotorista = new ArrayList<>();
		
		try {
			Statement statement = connection.createStatement();
			statement.execute("SELECT * FROM motorista");
			
			ResultSet rs = statement.getResultSet();
			
			while (rs.next()){
				Motorista motorista = new Motorista();
				
				motorista.setId_motorista(rs.getInt("id_motorista"));
				motorista.setNome(rs.getString("nome"));
				motorista.setApelido(rs.getString("apelido"));
				motorista.setSexo(rs.getString("sexo"));
				motorista.setData_nascimento(rs.getDate("data_nascimento"));
				motorista.setEmail(rs.getString("email"));
				motorista.setTelefone(rs.getString("telefone"));
				motorista.setDistrito(rs.getString("distrito"));
				motorista.setBairro(rs.getString("bairro"));
				motorista.setRua(rs.getString("rua"));
				
				listaDeMotorista.add(motorista);
						
			}
			
			rs.close();
			statement.close();
			connection.close();
			
			return listaDeMotorista;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		return null;
	}
	
	
	//-------------------------------------------------------------------------------------------------------------------------
	// MÉTODO PARA APAGAR MOTORISTA NA BASE DE DADOS!
	public void apagarMotorista(int id_motorista){
		Connection connection = ConnectionFactory.getConnection();
		
		try {
			PreparedStatement pstmt = connection
					.prepareStatement("DELETE FROM motorista WHERE id_motorista="+id_motorista);
			
			pstmt.executeUpdate();
			
			pstmt.close();
			connection.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//------------------------------------------------------------------------------------------------------------------------
	// MÉTODO PARA BUSCAR MTORISTA POR ID NA BASE DE DADOS!
	
	public Motorista buscarMotorista (int id_motorista){
		Connection  connection = ConnectionFactory.getConnection();
		Motorista motorista = new Motorista();;
		try {
			Statement statement = connection.createStatement();
			statement.execute(" SELECT * FROM motorista WHERE id_motorista="+id_motorista);
			
			ResultSet rs = statement.getResultSet();
			
			while (rs.next()){
							
				motorista.setId_motorista(rs.getInt("id_motorista"));
				motorista.setNome(rs.getString("nome"));
				motorista.setApelido(rs.getString("apelido"));
				motorista.setSexo(rs.getString("sexo"));
				motorista.setData_nascimento(rs.getDate("data_nascimento"));
				motorista.setEmail(rs.getString("email"));
				motorista.setTelefone(rs.getString("telefone"));
				motorista.setDistrito(rs.getString("distrito"));
				motorista.setBairro(rs.getString("bairro"));
				motorista.setRua(rs.getString("rua"));
										
			}
			
			rs.close();
			statement.close();
			connection.close();
			
			return motorista;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		return null;
		
	}
	
	
}
