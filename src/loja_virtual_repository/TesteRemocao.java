package loja_virtual_repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TesteRemocao {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection con = connectionFactory.createConnection();
		
		Statement stm = con.createStatement();
		
		stm.execute("DELETE FROM PRODUTO WHERE ID > 2 ");
		
		System.out.println("Quantidade de itens deletados:" + stm.getUpdateCount());
		
		
		
		

	}

}
