package DTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DAO.ConnectionFactory;
import Model.Veiculo;


public class VeiculoService {
	
	// MÉTODO PARA ADICIONAR NOVOS FUNCIONARIOS NA BASE DE DADOS!
		public void adicionarVeiculo (Veiculo veiculo){
			
			Connection connection = ConnectionFactory.getConnection();
						
					try {
						PreparedStatement pstmt = connection
								.prepareStatement("INSERT INTO veiculo (fabricante, modelo, tipo, capacidade, matricula, ano_fabrico) values (?, ?, ?, ?, ?, ?)");
						
						pstmt.setString(1, veiculo.getFabricante());
						pstmt.setString(2, veiculo.getModelo());
						pstmt.setString(3, veiculo.getTipo());
						pstmt.setString(4, veiculo.getCapacidade());
						pstmt.setString(5, veiculo.getMatricula());
						pstmt.setInt(6, veiculo.getAno_fabrico());
												
						pstmt.executeUpdate();
						
						pstmt.close();
						connection.close();
						
						System.out.println("Veículo actualizado: "+veiculo.getMatricula());						
					} catch (SQLException e) {
						e.printStackTrace();
						
					}
				
		}
		
		//-----------------------------------------------------------------------------------------------------------------------------------
		//MÉTODO PARA ACTUALIZAR DADOS DE VEICULO NA BASE DE DADOS!
		
				public void actualizarVeiculo (Veiculo veiculo){
					
					Connection connection = ConnectionFactory.getConnection();
								
							try {
								PreparedStatement pstmt = connection
										.prepareStatement("UPDATE veiculo SET fabricante=?, modelo=?, tipo=?, capacidade=?, matricula=?, ano_fabrico=? WHERE id_veiculo="+veiculo.getId_veiculo());
								
								pstmt.setString(1, veiculo.getFabricante());
								pstmt.setString(2, veiculo.getModelo());
								pstmt.setString(3, veiculo.getTipo());
								pstmt.setString(4, veiculo.getCapacidade());
								pstmt.setString(5, veiculo.getMatricula());
								pstmt.setInt(6, veiculo.getAno_fabrico());
																
								pstmt.executeUpdate();
								
								pstmt.close();
								connection.close();
								
								System.out.println("Veículo actualizado: "+veiculo.getMatricula());
													
							} catch (SQLException e) {
								e.printStackTrace();
								
							}
						
				}
				
		//------------------------------------------------------------------------------------------------------------------------------
		// MÉTODO PARA LISTAR TODOS VEICULOS NA BASE DE DADOS!
		public List<Veiculo> listarVeiculo(){
			List<Veiculo> listaDeVeiculos = new ArrayList<>();
			Connection  connection = ConnectionFactory.getConnection();
			
			try {
				Statement statement = connection.createStatement();
				statement.execute("SELECT * FROM veiculo");
				
				ResultSet rs = statement.getResultSet();
				
				while (rs.next()){
					Veiculo veiculo = new Veiculo();
					
					veiculo.setId_veiculo(rs.getInt("id_veiculo"));
					veiculo.setFabricante(rs.getString("fabricante"));
					veiculo.setModelo(rs.getString("modelo"));
					veiculo.setTipo(rs.getString("tipo"));
					veiculo.setCapacidade(rs.getString("capacidade"));
					veiculo.setMatricula(rs.getString("matricula"));
					veiculo.setAno_fabrico(rs.getInt("ano_fabrico"));
										
					listaDeVeiculos.add(veiculo);
			 	}
				
				rs.close();
				statement.close();
				connection.close();
				
				return listaDeVeiculos;
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
			
		}
				
				
		//-------------------------------------------------------------------------------------------------------------------------
		// MÉTODO PARA APAGAR VEICULO NA BASE DE DADOS!
		public void apagarVeiculo (int id_veiculo){
			Connection connection = ConnectionFactory.getConnection();
			
			try {
				PreparedStatement pstmt = connection
						.prepareStatement("DELETE FROM veiculo WHERE id_veiculo="+id_veiculo);
				
				pstmt.executeUpdate();
				
				pstmt.close();
				connection.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
				
		//------------------------------------------------------------------------------------------------------------------------
		// MÉTODO PARA BUSCAR VEICULO POR ID NA BASE DE DADOS!
		
		public Veiculo buscarVeiculo (int id_veiculo){
			Connection  connection = ConnectionFactory.getConnection();
			Veiculo veiculo = new Veiculo();
			
			try {
				Statement statement = connection.createStatement();
				statement.execute("SELECT * FROM veiculo WHERE id_veiculo="+id_veiculo);
				
				ResultSet rs = statement.getResultSet();
				
				while (rs.next()){
					
					veiculo.setId_veiculo(rs.getInt("id_veiculo"));
					veiculo.setFabricante(rs.getString("fabricante"));
					veiculo.setModelo(rs.getString("modelo"));
					veiculo.setTipo(rs.getString("tipo"));
					veiculo.setCapacidade(rs.getString("capacidade"));
					veiculo.setMatricula(rs.getString("matricula"));
					veiculo.setAno_fabrico(rs.getInt("ano_fabrico"));
					
				}
				
				rs.close();
				statement.close();
				connection.close();
					
				return veiculo;
				
			} catch (Exception e) {
				e.printStackTrace();
			}
				
			return null;
			
		}
}
