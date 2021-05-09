package DAO;

import java.sql.Connection;

import org.junit.Test;

public class TesteConexao {
 
	@Test
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connection = ConnectionFactory.getConnection();
		
		System.out.println(connection);
	}

}
