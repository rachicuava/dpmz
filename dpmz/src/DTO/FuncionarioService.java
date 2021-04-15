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



public class FuncionarioService {
	
	
	// MÉTODO PARA ADICIONAR NOVOS FUNCIONARIOS NA BASE DE DADOS!
	public void adicionarFuncionario (Funcionario funcionario){
		
		Connection connection = ConnectionFactory.getConnection();
					
				try {
					
					PreparedStatement pstmt = connection
							.prepareStatement("INSERT INTO funcionario (nome, apelido, sexo, data_nascimento, categoria, nuit, email, telefone, distrito, bairro, rua) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
					
					pstmt.setString(1, funcionario.getNome());
					pstmt.setString(2, funcionario.getApelido());
					pstmt.setString(3, funcionario.getSexo());
					pstmt.setDate(4, new java.sql.Date(funcionario.getData_nascimento().getTime()));
					pstmt.setString(5, funcionario.getCategoria());
					pstmt.setInt(6, funcionario.getNuit());
					pstmt.setString(7, funcionario.getEmail());
					pstmt.setString(8, funcionario.getTelefone());
					pstmt.setString(9, funcionario.getDistrito());
					pstmt.setString(10, funcionario.getBairro());
					pstmt.setString(11, funcionario.getRua());
					
					pstmt.executeUpdate();
					
					pstmt.close();
					connection.close();
					
										
				} catch (SQLException e) {
					e.printStackTrace();
					
				}
			
	}
	

	//-----------------------------------------------------------------------------------------------------------------------------------
	//MÉTODO PARA ACTUALIZAR DADOS DE FUNCIONARIO NA BASE DE DADOS!
	public void actualizarFuncionario (Funcionario funcionario){
		
		Connection connection = ConnectionFactory.getConnection();
					
				try {
					PreparedStatement pstmt = connection
							.prepareStatement("UPDATE funcionario SET nome=?, apelido=?, sexo=?, data_nascimento=? categoria=?,  nuit=?, email=?, telefone=?, distrito=?, bairro=?, rua=?  WHERE id_funcionario="+funcionario.getId_funcionario());
					
					pstmt.setString(1, funcionario.getNome());
					pstmt.setString(2, funcionario.getApelido());
					pstmt.setString(3, funcionario.getSexo());
					pstmt.setDate(4, new java.sql.Date(funcionario.getData_nascimento().getTime()));
					pstmt.setString(5, funcionario.getCategoria());
					pstmt.setInt(6, funcionario.getNuit());
					pstmt.setString(7, funcionario.getEmail());
					pstmt.setString(8, funcionario.getTelefone());
					pstmt.setString(9, funcionario.getDistrito());
					pstmt.setString(10, funcionario.getBairro());
					pstmt.setString(11, funcionario.getRua());
										
					pstmt.executeUpdate();
					
					pstmt.close();
					connection.close();
					
										
				} catch (SQLException e) {
					e.printStackTrace();
					
				}
			
			
	}
	
	
	
	//------------------------------------------------------------------------------------------------------------------------------
	// MÉTODO PARA LISTAR TODOS FUNCIONARIOS NA BASE DE DADOS!
	
	public List<Funcionario> listarFuncionario(){

		Connection connection = ConnectionFactory.getConnection();
		List<Funcionario> listaDeFuncionario = new ArrayList<>();
		
		try {
			Statement statement = connection.createStatement();
			statement.execute("SELECT * FROM funcionario");
			
			ResultSet rs = statement.getResultSet();
			
			while (rs.next()){
				Funcionario funcionario = new Funcionario();
				
				funcionario.setId_funcionario(rs.getInt("id_funcionario"));
				funcionario.setNome(rs.getString("nome"));
				funcionario.setApelido(rs.getString("apelido"));
				funcionario.setSexo(rs.getString("sexo"));
				funcionario.setData_nascimento(rs.getDate("data_nascimento"));
				funcionario.setCategoria(rs.getString("categoria"));
				funcionario.setNuit(rs.getInt("nuit"));
				funcionario.setEmail(rs.getString("email"));
				funcionario.setTelefone(rs.getString("telefone"));
				funcionario.setDistrito(rs.getString("distrito"));
				funcionario.setBairro(rs.getString("bairro"));
				funcionario.setRua(rs.getString("rua"));
				
				listaDeFuncionario.add(funcionario);
						
			}
			
			rs.close();
			statement.close();
			connection.close();
			
			return listaDeFuncionario;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		return null;
	}
	
	
	//-------------------------------------------------------------------------------------------------------------------------
	// MÉTODO PARA APAGAR FUNCIONARIOS NA BASE DE DADOS!
	public void apagarFuncionario (int id_funcionario){
		Connection connection = ConnectionFactory.getConnection();
		
		try {
			PreparedStatement pstmt = connection
					.prepareStatement("DELETE FROM funcionario WHERE id_funcionario="+id_funcionario);
			
			pstmt.executeUpdate();
			
			pstmt.close();
			connection.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//------------------------------------------------------------------------------------------------------------------------
	// MÉTODO PARA BUSCAR FUNCIONARIO POR ID NA BASE DE DADOS!
	
	public Funcionario buscarFuncionario (int id_funcionario){
		Connection  connection = ConnectionFactory.getConnection();
		Funcionario funcionario = new Funcionario();
		try {
			Statement statement = connection.createStatement();
			statement.execute(" SELECT * FROM funcionario WHERE id_funcionario="+id_funcionario);
			
			ResultSet rs = statement.getResultSet();
			
			while (rs.next()){
							
				funcionario.setId_funcionario(rs.getInt("id_funcionario"));
				funcionario.setNome(rs.getString("nome"));
				funcionario.setApelido(rs.getString("apelido"));
				funcionario.setSexo(rs.getString("sexo"));
				funcionario.setData_nascimento(rs.getDate("data_nascimento"));
				funcionario.setCategoria(rs.getString("categoria"));
				funcionario.setNuit(rs.getInt("nuit"));
				funcionario.setEmail(rs.getString("email"));
				funcionario.setTelefone(rs.getString("telefone"));
				funcionario.setDistrito(rs.getString("distrito"));
				funcionario.setBairro(rs.getString("bairro"));
				funcionario.setRua(rs.getString("rua"));
										
			}
			
			rs.close();
			statement.close();
			connection.close();
			
			return funcionario;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		return null;
		
	}
	
	
}
