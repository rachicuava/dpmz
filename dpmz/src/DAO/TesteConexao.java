package DAO;

import java.sql.Connection;

public class TesteConexao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connection = ConnectionFactory.getConnection();
		
		System.out.println(connection);
	}

}
