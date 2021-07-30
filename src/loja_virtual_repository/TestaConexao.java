package loja_virtual_repository;

import java.sql.SQLException;

public class TestaConexao {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory connectionFactory = new ConnectionFactory();

		for (int i = 0; i < 20; i++) {
			connectionFactory.createConnection();
			System.out.println("Conexão aberta numero " + i);
		}
	}
}
