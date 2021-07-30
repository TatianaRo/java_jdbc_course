package loja_virtual_repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TesteListagem {

	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection con = connectionFactory.createConnection();
        
		Statement stm = con.createStatement();
		
		System.out.println(stm.execute("SELECT * FROM PRODUTO"));
		
		ResultSet rst = stm.getResultSet();
		
		while(rst.next()) {
			System.out.println(rst.getInt("ID"));
			System.out.println(rst.getString("nome"));
			System.out.println(rst.getString("descricao"));
		}
		                                                                                  
		con.close();
	}

}
