package loja_virtual_repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TesteInsercao {
	
	public static void main(String[] args) throws SQLException {
	ConnectionFactory connectionFactory = new ConnectionFactory();
	Connection con = connectionFactory.createConnection();
	
	 Statement stm = con.createStatement();
	
	 stm.execute("INSERT INTO PRODUTO(nome, descricao) VALUES('Cadeira','Cadeira gamer verde')", Statement.RETURN_GENERATED_KEYS);
	 
	 ResultSet rst = stm.getGeneratedKeys();
	 
	 while(rst.next()) {
		 System.out.println("O id adicionado foi: " + rst.getInt(1));
	 }
	}
}
