package DTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DAO.ConnectionFactory;
import Model.Usuario;

public class UsuarioService {
	
	//------------------------------------------------------------------------------------------------------------------------
	// MÉTODO PARA ADICIONAR NOVOS USUARIOS NA BASE DE DADOS!
		public void adicionarUsuario (Usuario user){
			
			Connection connection = ConnectionFactory.getConnection();
						
					try {
						
						PreparedStatement pstmt = connection
								.prepareStatement("INSERT INTO usuario (usuario, senha, nivel_acesso) values (?, ?, ?)");
						
						pstmt.setString(1, user.getUsuario());
						pstmt.setString(2, user.getSenha());
						pstmt.setString(3, user.getNivel_acesso());
												
						pstmt.executeUpdate();
						
						pstmt.close();
						connection.close();
						
											
					} catch (SQLException e) {
						e.printStackTrace();
						
					}
				
		}
		
		//-----------------------------------------------------------------------------------------------------------------------------------
		//MÉTODO PARA ACTUALIZAR DADOS DE USUARIOS NA BASE DE DADOS!
		public void actualizarUsuario (Usuario user){
			
			Connection connection = ConnectionFactory.getConnection();
						
					try {
						PreparedStatement pstmt = connection
								.prepareStatement("UPDATE usuario SET usuario=?, senha=?, nivel_acesso=? WHERE id_usuario="+user.getId_usuario());
						
						pstmt.setString(1, user.getUsuario());
						pstmt.setString(2, user.getSenha());
						pstmt.setString(3, user.getNivel_acesso());
											
						pstmt.executeUpdate();
						
						pstmt.close();
						connection.close();
			
									
					} catch (SQLException e) {
						e.printStackTrace();
						
					}
				
		}
		
		//------------------------------------------------------------------------------------------------------------------------------
		// MÉTODO PARA LISTAR TODOS USUARIOS NA BASE DE DADOS!
		
		public List<Usuario> listarUsuario(){

			Connection connection = ConnectionFactory.getConnection();
			List<Usuario> listaDeUsuarios = new ArrayList<>();
			
			try {
				Statement statement = connection.createStatement();
				statement.execute("SELECT * FROM usuario");
				
				ResultSet rs = statement.getResultSet();
				
				while (rs.next()){
					Usuario user = new Usuario();
					
					user.setId_usuario(rs.getInt("id_usuario"));
					user.setUsuario(rs.getString("usuario"));
					user.setSenha(rs.getString("senha"));
					user.setNivel_acesso(rs.getString("nivel_acesso"));
					
					listaDeUsuarios.add(user);
							
				}
				
				rs.close();
				statement.close();
				connection.close();
				
				return listaDeUsuarios;
				
			} catch (Exception e) {
				e.printStackTrace();
			}
				
			return null;
		}
		
		
		//-------------------------------------------------------------------------------------------------------------------------
		// MÉTODO PARA APAGAR USUARIOS NA BASE DE DADOS!
		public void apagarUsuario (int id_usuario){
			Connection connection = ConnectionFactory.getConnection();
			
			try {
				PreparedStatement pstmt = connection
						.prepareStatement("DELETE FROM usuario WHERE id_usuario="+id_usuario);
				
				pstmt.executeUpdate();
				
				pstmt.close();
				connection.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		//------------------------------------------------------------------------------------------------------------------------
		// MÉTODO PARA BUSCAR USUARIO POR ID NA BASE DE DADOS!
		
		public Usuario buscarUsuario (int id_usuario){
			Connection  connection = ConnectionFactory.getConnection();
			Usuario user = new Usuario();
			
			try {
				Statement statement = connection.createStatement();
				statement.execute(" SELECT * FROM usuario WHERE id_usuario="+id_usuario);
				
				ResultSet rs = statement.getResultSet();
				
				while (rs.next()){
								
					user.setId_usuario(rs.getInt("id_usuario"));
					user.setUsuario(rs.getString("usuario"));
					user.setSenha(rs.getString("senha"));
					user.setNivel_acesso(rs.getString("nivel_acesso"));
											
				}
				
				rs.close();
				statement.close();
				connection.close();
				
				return user;
				
			} catch (Exception e) {
				e.printStackTrace();
			}
				
			return null;
			
		}
		
		
	//------------------------------------------------------------------------------------------------------------------------
			// MÉTODO PARA VALIDAR USUARIO NO LOGIN!
			
			public Usuario usuarioLogin (String usuario, String senha){
				Connection  connection = ConnectionFactory.getConnection();
				Usuario user = new Usuario();
				
				try {
					Statement statement = connection.createStatement();
					statement.execute("SELECT * FROM usuario WHERE usuario='"+usuario+"' AND senha='"+senha+"'");
									
					ResultSet rs = statement.getResultSet();
					
					while (rs.next()){
											
						user.setId_usuario(rs.getInt("id_usuario"));
						user.setUsuario(rs.getString("usuario"));
						user.setSenha(rs.getString("senha"));
						user.setNivel_acesso(rs.getString("nivel_acesso"));
																	
					}
					
					rs.close();
					statement.close();
					connection.close();
					
					return user;
								
				} catch (Exception e) {
					e.printStackTrace();
				}
					
				return null;
				
			}

}
