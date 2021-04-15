package DAO;

import java.sql.Connection;
import java.sql.DriverManager;




public class ConnectionFactory {
	
	
	public static Connection getConnection() {
        Connection connection = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/sgtm_dpmz", "root", "antonio2010");
            
            System.out.println("Conexão efectuada!");
            } catch (Exception ex) {
            ex.printStackTrace();
            System.exit(0);
            System.out.println("Erro de conexão"+ex);
        }

        return connection;

    }
	}

